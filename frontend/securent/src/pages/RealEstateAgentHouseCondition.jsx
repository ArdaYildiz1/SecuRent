import Button from "react-bootstrap/esm/Button";
import React from "react";
import pp from "./defaultPP.jpg";
import TopNavBar from "./TopNavBar";
import { Card, Col, Form, Row } from "react-bootstrap";
import { Link } from "react-router-dom";
import RealEstateAgentNavBar from "./RealEstateAgentNavBar";
import { useLocation, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect } from "react";

function RealEstateAgentHouseCondition() {
  const location = useLocation();
  const houseCondition = Object.values(location.state || {});
  const [tenants, setTenants] = useState([]);
  let navigate = useNavigate();

  const [houseID, setHouseID] = useState([]);

  function navigateHouse(idx) {
    axios
      .get(`http://localhost:8080/houses/${idx}`)
      .then((response) => {
        navigate("/realEstateAgentHouseDetails", {
          state: { ...response.data },
        });
      })
      .catch((error) => {
        console.error("Error fetching house details:", error);
      });
  }

  function acceptRentalRequest(idx) {
    //{realEstateAgentId}/rental-service-requests/{rentalServiceId}/accept
    axios
      .put(
        `http://localhost:8080/real-estate-agents/${houseCondition[idx].realEstateAgentID}/rental-service-requests/${houseCondition[idx].serviceID}/accept`,
        { serviceAccepted: true, newlyCreated: false }
      )
      .then((response) => {
        console.log(response.data);
        navigate("/realEstateAgentHouseCondition");
      })
      .catch((error) => {
        console.error("Error accepting rental request:", error);
      });
  }

  function declineRentalRequest(idx) {
    axios
      .put(
        `http://localhost:8080/real-estate-agents/${houseCondition[idx].realEstateAgentID}/rental-service-requests/${houseCondition[idx].serviceID}/reject`,
        { serviceAccepted: false, newlyCreated: false }
      )
      .then((response) => {
        console.log(response.data);
        navigate("/realEstateAgentHouseCondition");
      })
      .catch((error) => {
        console.error("Error accepting rental request:", error);
      });
  }

  useEffect(() => {
    // Only fetch if tenants array is empty to avoid unnecessary requests
    if (tenants.length === 0) {
      houseCondition.forEach((notification, idx) => {
        getTenantNameById(idx);
      });
    }
  }, [houseCondition]);

  function getTenantNameById(idx) {
    axios
      .get(`http://localhost:8080/tenants/${houseCondition[idx].tenantID}`)
      .then((response) => {
        const newTenant = response.data.firstName;
        // Update tenants state and save to local storage
        setTenants((prevTenants) => {
          const updatedTenants = [...prevTenants, newTenant];
          return updatedTenants;
        });
      })
      .catch((error) => {
        console.error("Error fetching tenant:", error);
      });
  }

  const dynamicData = [
    "Ahmet Kalem",
    "Fatih Kor",
    "Ali Tarık",
    "Kasım Kale",
    "Fatih Kor",
    "Ali Tarık",
    "Ahmet Kalem",
    "Fatih Kor",
    "Ali Tarık",
    "Mehmet Ersoy",
    "Fatih Kor",
    "Ali Tarık",
    "Mehmet Ersoy",
    "Fatih Kor",
    "Ali Tarık",
    "Mehmet Ersoy",
  ];

  const DynamicList = ({ data }) => {
    return (
      <>
        <div className="row">
          <div className="col-md-2"></div>
          <div className="col-md-8">
            <Row xs={1} md={3} className="g-4">
              <>
                {Array.from({ length: houseCondition.length }).map((_, idx) => (
                  <Col key={idx}>
                    <Link style={{ textDecoration: "none" }}>
                      <Card
                        onClick={() => navigateHouse(houseCondition[idx].houseID)}
                        style={{
                          backgroundColor: "#f1f2ed",
                          borderRadius: "2rem",
                        }}
                      >
                        <br />

                        <Card.Img
                          className="ps-3 pe-3"
                          style={{ borderRadius: "1rem" }}
                          variant="top"
                          src={pp}
                        />
                        <Card.Body>
                          <Card.Title style={{ color: "black" }}>
                            {tenants[idx]}
                          </Card.Title>
                          <Card.Text style={{ color: "black" }}>
                            {tenants[idx]} wants you to upload a house condition
                            report. Click to see the house to be examined.
                          </Card.Text>

                          <div
                            style={{ display: "flex", flexDirection: "row" }}
                          >
                            <Button
                              style={{ width: "150px", height: "50px" }}
                              className="btn-decline"
                              onClick={() => declineRentalRequest(idx)}
                              type="submit"
                            >
                              Decline
                            </Button>
                            <Button
                              style={{ width: "150px", height: "50px" }}
                              className="btn-fav"
                              onClick={() => acceptRentalRequest(idx)}
                              type="submit"
                            >
                              Accept
                            </Button>
                          </div>

                          <br />
                        </Card.Body>
                      </Card>
                    </Link>
                  </Col>
                ))}
              </>
            </Row>
          </div>
          <div className="col-md-2"></div>
        </div>
      </>
    );
  };

  return (
    <>
      <RealEstateAgentNavBar />

      <div style={{ width: "100%", height: "100vh", overflowY: "auto" }}>
        <div
          style={{
            display: "flex",
            justifyContent: "center",
            paddingTop: "2%",
            paddingBottom: "2%",
          }}
        >
          <h1 style={{ color: "white" }}>House Condition Check Notification</h1>
        </div>

        <div style={{ width: "100%", height: "100vh" }}>
          <DynamicList data={dynamicData} />
        </div>
      </div>
    </>
  );
}

export default RealEstateAgentHouseCondition;

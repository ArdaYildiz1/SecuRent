import Button from "react-bootstrap/esm/Button";
import React from "react";
import pp from "./defaultPP.jpg";
import TopNavBar from "./TopNavBar";
import { useState, useEffect } from "react";
import { Card, Col, Form, Row } from "react-bootstrap";
import { Link } from "react-router-dom";
import RealEstateAgentNavBar from "./RealEstateAgentNavBar";
import { useLocation, useNavigate } from "react-router-dom";
import axios from "axios";

function RealEstateAgentNotification() {
  const location = useLocation();
  const notifications = Object.values(location.state || {});
  console.log(notifications);
  const [tenants, setTenants] = useState([]);
  let navigate = useNavigate();

  useEffect(() => {
    // Only fetch if tenants array is empty to avoid unnecessary requests
    if (tenants.length === 0) {
      notifications.forEach((notification, idx) => {
        getTenantNameById(idx);
      });
    }
  }, [notifications]);

  function getTenantNameById(idx) {
    axios
      .get(`http://localhost:8080/tenants/${notifications[idx].tenantID}`)
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

  function acceptRentalRequest(idx) {
    //{realEstateAgentId}/rental-service-requests/{rentalServiceId}/accept
    axios
      .put(
        `http://localhost:8080/real-estate-agents/${notifications[idx].realEstateAgentID}/rental-service-requests/${notifications[idx].serviceID}/accept`,
        { serviceAccepted: true, newlyCreated: false }
      )
      .then((response) => {
        console.log(response.data);
        navigate("/realEstateAgentNotification");
      })
      .catch((error) => {
        console.error("Error accepting rental request:", error);
      });
  }

  function declineRentalRequest(idx) {
    axios
      .put(
        `http://localhost:8080/real-estate-agents/${notifications[idx].realEstateAgentID}/rental-service-requests/${notifications[idx].serviceID}/reject`,
        { serviceAccepted: false, newlyCreated: false }
      )
      .then((response) => {
        console.log(response.data);
        navigate("/realEstateAgentNotification");
      })
      .catch((error) => {
        console.error("Error accepting rental request:", error);
      });
  }

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
                {Array.from({ length: notifications.length }).map((_, idx) => (
                  <Col key={idx}>
                    <Link style={{ textDecoration: "none" }}>
                      <Card
                        onClick={() => navigateHouse(notifications[idx].houseID)}
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
                            {" "}
                            {tenants[idx]}
                          </Card.Title>
                          <Card.Text style={{ color: "black" }}>
                            {" "}
                            {tenants[idx]} wants to see the house. Click to see
                            the house to be escorted.
                          </Card.Text>

                          <div
                            style={{ display: "flex", flexDirection: "row" }}
                          >
                            <Button
                              style={{ width: "150px", height: "50px" }}
                              className="btn-decline"
                              onClick={() => {
                                declineRentalRequest(idx);
                              }}
                              type="submit"
                            >
                              Decline
                            </Button>
                            <Button
                              style={{ width: "150px", height: "50px" }}
                              className="btn-fav"
                              onClick={() => {
                                acceptRentalRequest(idx);
                              }}
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
          <h1 style={{ color: "white" }}>Rental Notifications</h1>
        </div>

        <div style={{ width: "100%", height: "100vh" }}>
          <DynamicList data={dynamicData} />
        </div>
      </div>
    </>
  );
}

export default RealEstateAgentNotification;

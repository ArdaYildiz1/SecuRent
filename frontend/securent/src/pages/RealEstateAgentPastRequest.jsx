import Button from "react-bootstrap/esm/Button";
import React, { useEffect, useState } from "react";
import pp from "./defaultPP.jpg";
import TopNavBar from "./TopNavBar";
import { Card, Col, Form, Row } from "react-bootstrap";
import { Link, useLocation, useNavigate } from "react-router-dom";
import RealEstateAgentNavBar from "./RealEstateAgentNavBar";
import axios from "axios";

function RealEstateAgentPastRequest() {
  const location = useLocation();
  const currentRequests = Object.values(location.state || {});
  const [tenants, setTenants] = useState([]);
  const [landlords, setLandlords] = useState([]);
  let navigate = useNavigate();

  function navigateHouse(idx) {
    axios
      .get(`http://52.59.214.208:8080/houses/${idx}`)
      .then((response) => {
        navigate("/realEstateAgentHouseDetails", {
          state: { ...response.data },
        });
      })
      .catch((error) => {
        console.error("Error fetching house details:", error);
      });
  }

  useEffect(() => {
    if (tenants.length === 0) {
      currentRequests.forEach((notification, idx) => {
        getTenantNameById(idx);
      });
    }
  }, [currentRequests]);

  useEffect(() => {
    // Only fetch if tenants array is empty to avoid unnecessary requests
    if (landlords.length === 0) {
      currentRequests.forEach((notification, idx) => {
        getLandlordNameById(idx);
      });
    }
  }, [currentRequests]); // Dependency array to avoid infinite loop

  function getTenantNameById(idx) {
    axios
      .get(`http://52.59.214.208:8080/tenants/${currentRequests[idx].tenantID}`)
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

  function getLandlordNameById(idx) {
    axios
      .get(`http://52.59.214.208:8080/landlords/${currentRequests[idx].landlordID}`)
      .then((response) => {
        console.log(response.data);
        const newRealEstateAgent = response.data.firstName;
        // Update real estate agent state and save to local storage
        setLandlords((prevRealEstateAgents) => {
          const updatedRealEstateAgents = [
            ...prevRealEstateAgents,
            newRealEstateAgent,
          ];
          return updatedRealEstateAgents;
        });
      })
      .catch((error) => {
        console.error("Error fetching real estate agent:", error);
      });
  }

  function handleSeeProfiles(idx) {
    Promise.all([
      axios.get(
        `http://52.59.214.208:8080/landlords/${currentRequests[idx].landlordID}`
      ),
      axios.get(
        `http://52.59.214.208:8080/tenants/${currentRequests[idx].tenantID}`
      ),
    ])
      .then(([landlordResponse, tenantResponse]) => {
        const newLandlord = landlordResponse.data;
        const newTenant = tenantResponse.data;
        navigate("/seeTenantAndLandlord", {
          state: { landlord: newLandlord, tenant: newTenant },
        });
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
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
  const landlord = [
    "Ali Kemal Yazıcı",
    "Fatih Terim",
    "Aslı Kavun",
    "Melike Bodur",
  ];

  const DynamicList = ({ data, landlord }) => {

    let navigate = useNavigate();

    return (
      <>
        <div className="row">
          <div className="col-md-2"></div>
          <div className="col-md-8">
            <Row xs={1} md={3} className="g-4">
              <>
                {Array.from({ length: currentRequests.length }).map(
                  (_, idx) => (
                    <Col key={idx}>
                      {/* burayı belki bir profile yönlendiririz   to={`/houseDetails`}*/}
                      <div style={{ textDecoration: "none" }}>
                        <Card
                          style={{
                            backgroundColor: "#f1f2ed",
                            borderRadius: "2rem",
                          }}
                        >
                          <br />
                          <div
                            style={{
                              display: "flex",
                              flexDirection: "row",
                              justifyContent: "center",
                              marginBottom: 30,
                            }}
                          >
                            <div
                              style={{
                                display: "flex",
                                flexDirection: "column",
                                justifyContent: "center",
                                alignItems: "center",
                              }}
                            >
                              <h4>Tenant</h4>
                              <Card.Img
                                style={{
                                  borderRadius: "1rem",
                                  width: "120px",
                                  height: "120px",
                                }}
                                variant="top"
                                src={pp}
                              />
                            </div>
                            <div
                              style={{
                                display: "flex",
                                flexDirection: "column",
                                justifyContent: "center",
                                alignItems: "center",
                              }}
                            >
                              <h4>Landlord</h4>

                              <Card.Img
                                style={{
                                  borderRadius: "1rem",
                                  width: "120px",
                                  height: "120px",
                                  marginLeft: 10,
                                }}
                                variant="top"
                                src={pp}
                              />
                            </div>
                          </div>

                          <Card.Body>
                            <Card.Title style={{ color: "black" }}>
                              {tenants[idx]}
                            </Card.Title>
                            <Card.Text style={{ color: "black" }}>
                              {tenants[idx]} requested to see house owned by{" "}
                              {landlords[idx]} .
                            </Card.Text>

                            <div
                              style={{
                                display: "flex",
                                flexDirection: "row",
                                justifyContent: "center",
                              }}
                            >
                              <Button
                                style={{ width: "150px", height: "50px" }}
                                className="btn-teal"
                                type="submit"
                                onClick={() => handleSeeProfiles(idx)}
                              >
                                See the Profiles
                              </Button>
                            </div>

                            <br />
                          </Card.Body>
                        </Card>
                      </div>
                    </Col>
                  )
                )}
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
          <h1 style={{ color: "white" }}>Past Requests</h1>
        </div>

        <div style={{ width: "100%", height: "100vh" }}>
          <DynamicList data={dynamicData} landlord={landlord} />
        </div>
      </div>
    </>
  );
}

export default RealEstateAgentPastRequest;

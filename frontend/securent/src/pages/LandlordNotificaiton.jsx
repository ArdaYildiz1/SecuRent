import Button from "react-bootstrap/esm/Button";
import React from "react";
import { useState } from "react";
import pp from "./defaultPP.jpg";
import TopNavBar from "./TopNavBar";
import { Card, Col, Form, Row } from "react-bootstrap";
import { Link } from "react-router-dom";
import LandlordNavBar from "./LandlordNavBar";
import { useLocation, useNavigate } from "react-router-dom";
import axios from "axios";

function LandlordNotification() {
  const location = useLocation();
  const notifications = Object.values(location.state);
  const [tenantName, setTenantName] = useState("");
  const [tenants, setTenants] = useState([]); // State to hold list of tenant objects
  let navigate = useNavigate();

  console.log(notifications);

  function getTenantNameById(idx) {
    axios
      .get(`http://localhost:8080/tenants/${notifications[idx].tenantID}`)
      .then((response) => {
        console.log(response.data.firstName);
        tenants.push(response.data.firstName);
      })
      .catch((error) => {
        console.error("Error fetching houses:", error);
      });
  }

  const dynamicData = [];

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
                    {/* burayı belki bir profile yönlendiririz   to={`/houseDetails`}*/}
                    <div>
                      <Card
                        className="clickable-card"
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
                            {getTenantNameById(idx)}
                            {tenants[idx]}
                          </Card.Title>
                          <Card.Text style={{ color: "black" }}>
                            You have a new rental request!
                          </Card.Text>

                          <div
                            style={{ display: "flex", flexDirection: "row" }}
                          >
                            <Button
                              style={{ width: "150px", height: "50px" }}
                              className="btn-decline"
                              type="submit"
                            >
                              Decline
                            </Button>
                            <Button
                              style={{ width: "150px", height: "50px" }}
                              className="btn-fav"
                              type="submit"
                            >
                              Accept
                            </Button>
                          </div>

                          <br />
                        </Card.Body>
                      </Card>
                    </div>
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
      <LandlordNavBar />

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

export default LandlordNotification;

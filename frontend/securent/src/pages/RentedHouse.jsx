import React from "react";
import TopNavBar from "./TopNavBar";
import Card from "react-bootstrap/Card";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Carousel from "react-bootstrap/Carousel";
import Modal from "react-bootstrap/Modal";
import { useState } from "react";
import TenantNavBar from "./TenantNavBar";
import { useNavigate } from "react-router-dom";

import { useLocation } from "react-router-dom";

function RentedHouse() {
  const location = useLocation();
  const {
    houseId,
    landlordId,
    tenantId,
    address,
    adDate,
    areaGross,
    areaNet,
    areaOpenSpace,
    numberOfRooms,
    buildingAge,
    flatNumber,
    heating,
    numberOfBathrooms,
    balconyIsPresent,
    furnitureIsPresent,
    insideASite,
    siteName,
    currentAmount,
    adDetails,
    adTitle,
    landlordName,
    landlordPhoneNumber,
    rentPrice,
  } = location?.state || {};
  
  const [show, setShow] = useState(false);
  const [explanation, setExplanation] = useState("");

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  function handleSelectAgent() {
    navigate("/selectAgent");
  }

  let navigate = useNavigate();

  return (
    <>
      <TenantNavBar />
      <br />

      <div className="container-fluid" >
        <div className="row">
          <div className="col-md-2"></div>
          <div className="col-md-8">
            <Card
              className="mb-3"
              style={{
                backgroundColor: "#f1f2ed",
                borderRadius: "1rem",
                display: "flex",
                justifyContent: "center",
                alignItems: "center",
                paddingTop: "60px",
                paddingBottom: "60px",
              }}
            >
              <div className="row flex-container">
                <div className=" ms-5 me-5 mb-3">
                  <div style={{ display: "flex", flexdirection: "column" }}>
                    <h5>Address: </h5>
                    <p style={{ marginLeft: 10 }}>456 Elm St</p>
                  </div>
                  <div style={{ display: "flex", flexdirection: "column" }}>
                    <h5>Area Gross: </h5>
                    <p style={{ marginLeft: 10 }}> 200</p>
                  </div>

                  <div style={{ display: "flex", flexdirection: "column" }}>
                    <h5>Area Net: 180</h5>
                    <p style={{ marginLeft: 10 }}></p>
                  </div>
                  <div style={{ display: "flex", flexdirection: "column" }}>
                    <h5>Area Open Space: 20</h5>
                    <p style={{ marginLeft: 10 }}></p>
                  </div>

                  <div style={{ display: "flex", flexdirection: "column" }}>
                    <h5>Number Of Rooms: 5</h5>
                    <p style={{ marginLeft: 10 }}></p>
                  </div>
                  <div style={{ display: "flex", flexdirection: "column" }}>
                    <h5>Building Age: 8</h5>
                    <p style={{ marginLeft: 10 }}></p>
                  </div>
                  <div style={{ display: "flex", flexdirection: "column" }}>
                    <h5>Flat Number: 2</h5>
                    <p style={{ marginLeft: 10 }}></p>
                  </div>
                  <div style={{ display: "flex", flexdirection: "column" }}>
                    <h5>Heating: GAS_HEATING </h5>
                    <p style={{ marginLeft: 10 }}></p>
                  </div>
                  <div style={{ display: "flex", flexdirection: "column" }}>
                    <h5>Number Of Bathrooms: 3</h5>
                    <p style={{ marginLeft: 10 }}></p>
                  </div>
                  <div style={{ display: "flex", flexdirection: "column" }}>
                    <h5>Balcony Is Present: Yes</h5>
                    <p style={{ marginLeft: 10 }}></p>
                  </div>
                  <div style={{ display: "flex", flexdirection: "column" }}>
                    <h5>Furniture Is Present: No</h5>
                    <p style={{ marginLeft: 10 }}></p>
                  </div>
                  <div style={{ display: "flex", flexdirection: "column" }}>
                    <h5>Inside A Site: Yes</h5>
                    <p style={{ marginLeft: 10 }}></p>
                  </div>

                  <div style={{ display: "flex", flexdirection: "column" }}>
                    <h5>Site Name: Maple Meadows</h5>
                    <p style={{ marginLeft: 10 }}></p>
                  </div>
                  <div style={{ display: "flex", flexdirection: "column" }}>
                    <h5>Rent Amount: 2000</h5>
                    <p style={{ marginLeft: 10 }}></p>
                  </div>
                </div>
                <hr />

                <div className="row">
                  <Form>
                    <Form.Group
                      className="ms-5 me-5 mb-3"
                      controlId="loginPassword"
                    >
                      <h5>
                        You can send request for house condition check if
                        reamining contract time is less than 7 days!
                      </h5>
                      <br></br>
                      <div style={{ display: "flex", flexdirection: "column" }}>
                        <h5>Remaining Time For Contract End: </h5>
                        <p style={{ marginLeft: 10 }}>
                          06 days, 20 hours, 20 minutes
                        </p>
                      </div>
                      <br />
                      <div
                        className=""
                        style={{
                          display: "flex",
                          flexdirection: "column",
                          alignItems: "center",
                        }}
                      >
                        <h5 style={{ marginRight: 10 }}>
                          Select agent to request house condition check:
                        </h5>
                        <Button
                          className="btn-teal"
                          onClick={handleSelectAgent}
                        >
                          Select Agent
                        </Button>
                      </div>
                    </Form.Group>
                  </Form>
                  <br />
                  <br />
                </div>
              </div>
            </Card>
          </div>
        </div>
      </div>
      <br />
      <br />
      <br />
      <br />
      <br />
    </>
  );
}
export default RentedHouse;

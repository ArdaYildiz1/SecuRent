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

export default function HouseDetails() {
  const location = useLocation();
  console.log(location.state);
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
  function handlePreview() {
    navigate("/selectAgent");
  }

  let navigate = useNavigate();

  return (
    <>
      <TenantNavBar></TenantNavBar>
      <br />
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-2"></div>
          <div class="col-md-8">
            <br />
            <Card style={{ backgroundColor: "#f1f2ed", borderRadius: "1rem" }}>
              <br />
              <Form>
                <Form.Group
                  className="ms-5 me-5 mb-3"
                  controlId="loginPassword"
                >
                  <div className="d-flex justify-content-center">
                    <Carousel>
                      <Carousel.Item>
                        <img
                          src="/h6.jpg"
                          style={{
                            width: "auto",
                            height: "40vh",
                            display: "block",
                            marginLeft: "auto",
                            marginRight: "auto",
                          }}
                          alt="First slide"
                        />
                      </Carousel.Item>
                      <Carousel.Item>
                        <img
                          src="/h6_1.jpg"
                          style={{
                            width: "auto",
                            height: "40vh",
                            display: "block",
                            marginLeft: "auto",
                            marginRight: "auto",
                          }}
                          alt="Second slide"
                        />
                      </Carousel.Item>
                      <Carousel.Item>
                        <img
                          src="/h6_2.jpg"
                          style={{
                            width: "auto",
                            height: "40vh",
                            display: "block",
                            marginLeft: "auto",
                            marginRight: "auto",
                          }}
                          alt="Third slide"
                        />
                      </Carousel.Item>
                    </Carousel>
                  </div>
                  <br />

                  <br />
                  <Form.Label>
                    <strong>
                      <h2>{adTitle}</h2>
                    </strong>
                  </Form.Label>

                  <br />
                  <Form.Label>
                    <h4>{address}</h4>
                  </Form.Label>

                  <br />
                  <Form.Label>{rentPrice} TL</Form.Label>
                  <br />
                  <Button className="btn-teal" onClick={handleShow}>
                    Report Ad
                  </Button>

                  <Modal show={show} onHide={handleClose}>
                    <Modal.Header closeButton>
                      <Modal.Title>Report Ad</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                      <Form.Label>
                        Report your complaints about the ad
                      </Form.Label>
                      <Form.Control
                        as="textarea"
                        rows={3}
                        value={explanation}
                        onChange={(e) => setExplanation(e.target.value)}
                        placeholder="Write your complaints here..."
                      />
                    </Modal.Body>
                    <Modal.Footer>
                      <Button className="btn-velvet" onClick={handleClose}>
                        Close
                      </Button>
                      <Button className="btn-teal" onClick={handleClose}>
                        {" "}
                        {/* Handle report submission here */}
                        Submit Report
                      </Button>
                    </Modal.Footer>
                  </Modal>
                </Form.Group>
              </Form>
            </Card>
            <br />
          </div>
        </div>
      </div>
      <br />
      <div className="container-fluid">
        <div className="row">
          <div className="col-md-2"></div>
          <div className="col-md-8">
            <Card
              className="mb-3"
              style={{ backgroundColor: "#f1f2ed", borderRadius: "1rem" }}
            >
              <div className="row">
                <Form>
                  <Form.Group
                    className="ms-5 me-5 mb-3"
                    controlId="loginPassword"
                  >
                    <br />
                    <Form.Group className="d-flex align-items-center">
                      <h2>{landlordName}</h2>
                    </Form.Group>

                    <Form.Group className="d-flex align-items-center">
                      <Form.Label className="d-flex justify-content-center">
                        {landlordPhoneNumber}
                      </Form.Label>
                    </Form.Group>
                  </Form.Group>
                </Form>
                <br />
                <br />
              </div>
              <div className="row flex-container">
                <div className="col-md-6 flex-container">
                  <hr className="me-5" />
                  <p style={{ fontSize: 13 }}>
                    <br />
                    Address: {address}
                    <br />
                    Ad Date: {adDate}
                    <br />
                    m² (Gross): {areaGross}
                    <br />
                    m² (Net): {areaNet}
                    <br />
                    Open Area Space m²: {areaOpenSpace}
                    <br />
                    Number of Rooms: {numberOfRooms}
                    <br />
                    Building Age: {buildingAge}
                    <br />
                    Flat Number (Door Number): {flatNumber}
                    <br />
                    Heating: {heating}
                    <br />
                    Number of Bathroomsı: {numberOfBathrooms}
                    <br />
                    Have a Balcony (?):{" "}
                    {balconyIsPresent ? "Yes" : "No"}
                    <br />
                    Have a Furniture (?):{" "}
                    {furnitureIsPresent ? "Yes" : "No"}
                    <br />
                    In a Site (?): {insideASite ? "Yes" : "No"}
                    <br />
                    Site Name: {siteName}
                    <br />
                    Rent Amount (TL): {rentPrice}
                    <br />
                  </p>
                </div>
                <div className="col-md-6 justify-content-center flex-container">
                  <p style={{ fontSize: 13, textAlign: "center" }}>
                    <br />
                    <strong>Ad Details: </strong>
                    {adDetails}
                  </p>
                </div>
                <div className="row">
                  <Form>
                    <Form.Group
                      className="ms-5 me-5 mb-3"
                      controlId="loginPassword"
                    >
                      <div className="d-flex justify-content-end me-5">
                        <Button className="btn-teal" onClick={handlePreview}>
                          Preview
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

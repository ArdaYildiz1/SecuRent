import React, { useState } from "react";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import NavDropdown from "react-bootstrap/NavDropdown";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function RealEstateAgentNavBar() {
  const [tenantId, setTenantId] = useState(1); // Use a static tenantId for testing
  const [houseId, setHouseId] = useState(null);
  const [landlordId, setLandlordId] = useState(null);
  const [address, setAddress] = useState(null);
  const [adDate, setAdDate] = useState(null);
  const [areaGross, setAreaGross] = useState(null);
  const [areaNet, setAreaNet] = useState(null);
  const [areaOpenSpace, setAreaOpenSpace] = useState(null);
  const [numberOfRooms, setNumberOfRooms] = useState(null);
  const [buildingAge, setBuildingAge] = useState(null);
  const [flatNumber, setFlatNumber] = useState(null);
  const [heating, setHeating] = useState(null);
  const [numberOfBathrooms, setNumberOfBathrooms] = useState(null);
  const [balconyIsPresent, setBalconyIsPresent] = useState(null);
  const [furnitureIsPresent, setFurnitureIsPresent] = useState(null);
  const [insideASite, setInsideASite] = useState(null);
  const [siteName, setSiteName] = useState(null);
  const [currentAmount, setCurrentAmount] = useState(null);
  const [adDetails, setAdDetails] = useState(null);
  const [adTitle, setAdTitle] = useState(null);
  const [landlordName, setLandlordName] = useState(null);
  const [landlordPhoneNumber, setLandlordPhoneNumber] = useState(null);
  const [rentPrice, setRentPrice] = useState(null);

  function handleLogOut() {
    navigate("/");
  }
  function handleGoHome() {
    axios
      .get(`http://localhost:8080/houses`)
      .then((response) => {
        setHouseId(response.data.houseId);
        setLandlordId(response.data.landlordId);
        setTenantId(response.data.tenantId);
        setAddress(response.data.address);
        setAdDate(response.data.adDate);
        setAreaGross(response.data.areaGross);
        setAreaNet(response.data.areaNet);
        setAreaOpenSpace(response.data.areaOpenSpace);
        setNumberOfRooms(response.data.numberOfRooms);
        setBuildingAge(response.data.buildingAge);
        setFlatNumber(response.data.flatNumber);
        setHeating(response.data.heating);
        setNumberOfBathrooms(response.data.numberOfBathrooms);
        setBalconyIsPresent(response.data.balconyIsPresent);
        setFurnitureIsPresent(response.data.furnitureIsPresent);
        setInsideASite(response.data.insideASite);
        setSiteName(response.data.siteName);
        setCurrentAmount(response.data.currentAmount);
        setAdDetails(response.data.adDetails);
        setAdTitle(response.data.adTitle);
        setLandlordName(response.data.landlordName);
        setLandlordPhoneNumber(response.data.landlordPhoneNumber);
        setRentPrice(response.data.rentPrice);

        navigate("/realestateagenthome", { state: { ...response.data } });
        console.log(response.data);
      })
      .catch((error) => {
        console.error("Error fetching houses:", error);
      });
  }
  function handleCurrentRequests() {
    navigate("/realEstateAgentCurrentRequest");
  }
  function handlePastRequests() {
    navigate("/realEstateAgentPastRequest");
  }
  function handleHouseConditionList() {
    navigate("/realEstateAgentHouseConditionList");
  }
  function handleHouseConditionNotifications() {
    navigate("/realEstateAgentHouseCondition");
  }
  function handleNotifications() {
    navigate("/realEstateAgentNotification");
  }
  function handleProfile() {
    navigate("/realEstateAgentProfile");
  }

  let navigate = useNavigate();
  return (
    <Navbar bg="light" expand="lg">
      <Navbar.Brand>
        <img className="ms-4" src="/sr_logo.png" width="50" height="50" />
      </Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="me-5">
          <>
            <Nav.Link className="btn-navbar" onClick={handleGoHome}>
              Home
            </Nav.Link>

            <Nav.Link className="btn-navbar" onClick={handleCurrentRequests}>
              Current Requests
            </Nav.Link>
            <Nav.Link className="btn-navbar" onClick={handlePastRequests}>
              Past Requests
            </Nav.Link>
            <Nav.Link className="btn-navbar" onClick={handleHouseConditionList}>
              House Condition List
            </Nav.Link>
            <Nav.Link
              className="btn-navbar"
              onClick={handleHouseConditionNotifications}
            >
              House Condition Notificiations
            </Nav.Link>
            <Nav.Link className="btn-navbar" onClick={handleNotifications}>
              Notifications
            </Nav.Link>
          </>
        </Nav>
        <Nav style={{ marginLeft: "auto" }}>
          <NavDropdown
            drop="start"
            className="btn-navbar pe-5"
            title={<img src="/usr.png" width="40" height="40" alt="usr logo" />}
            id="basic-nav-dropdown"
          >
            <>
              <NavDropdown.Item className="btn-navbar" onClick={handleProfile}>
                Profile
              </NavDropdown.Item>

              <NavDropdown.Item className="btn-navbar" onClick={handleLogOut}>
                Log out
              </NavDropdown.Item>
            </>
          </NavDropdown>
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  );
}

export default RealEstateAgentNavBar;

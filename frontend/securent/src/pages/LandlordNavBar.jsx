import React from "react";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import NavDropdown from "react-bootstrap/NavDropdown";
import { useNavigate } from "react-router-dom";
import axios from "axios"; // Import axios

function LandlordNavBar() {
  

  let navigate = useNavigate();

  function handleProfile() {
    navigate("/landlordProfile");
  }

  function handleLogout() {
    navigate("/");
  }

  function handleCurrentRequests() {
    // axios
    //   .get(`http://localhost:8080/houses`)
    //   .then((response) => {
    //     setHouseId(response.data.houseId);
    //     setLandlordId(response.data.landlordId);
    //     setTenantId(response.data.tenantId);
    //     setAddress(response.data.address);
    //     setAdDate(response.data.adDate);
    //     setAreaGross(response.data.areaGross);
    //     setAreaNet(response.data.areaNet);
    //     setAreaOpenSpace(response.data.areaOpenSpace);
    //     setNumberOfRooms(response.data.numberOfRooms);
    //     setBuildingAge(response.data.buildingAge);
    //     setFlatNumber(response.data.flatNumber);
    //     setHeating(response.data.heating);
    //     setNumberOfBathrooms(response.data.numberOfBathrooms);
    //     setBalconyIsPresent(response.data.balconyIsPresent);
    //     setFurnitureIsPresent(response.data.furnitureIsPresent);
    //     setInsideASite(response.data.insideASite);
    //     setSiteName(response.data.siteName);
    //     setCurrentAmount(response.data.currentAmount);
    //     setAdDetails(response.data.adDetails);
    //     setAdTitle(response.data.adTitle);
    //     setLandlordName(response.data.landlordName);
    //     setLandlordPhoneNumber(response.data.landlordPhoneNumber);
    //     setRentPrice(response.data.rentPrice);


    //     navigate("/landlordCurrentRequest", { state: { ...response.data } });
    //     console.log(response.data);
    //   })
    //   .catch((error) => {
    //     console.error("Error fetching houses:", error);
    //   });
  }

  function handlePastRequests() {
    navigate("/landlordPastRequest");
  }

  function handleNotifications() {
    navigate("/landlordNotification");
  }

  return (
    <Navbar bg="light" expand="lg">
      <Navbar.Brand>
        <img className="ms-4" src="/sr_logo.png" width="50" height="50" />
      </Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="me-5">
          <>
            <Nav.Link onClick={handleCurrentRequests} className="btn-navbar">
              Current Requests
            </Nav.Link>
            <Nav.Link onClick={handlePastRequests} className="btn-navbar">
              Past Requests
            </Nav.Link>

            <Nav.Link onClick={handleNotifications} className="btn-navbar">
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
              <NavDropdown.Item onClick={handleProfile} className="btn-navbar">
                Profile
              </NavDropdown.Item>

              <NavDropdown.Item onClick={handleLogout} className="btn-navbar">
                Log out
              </NavDropdown.Item>
            </>
          </NavDropdown>
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  );
}

export default LandlordNavBar;

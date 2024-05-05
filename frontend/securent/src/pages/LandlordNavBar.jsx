import React from "react";
import { useState } from "react";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import NavDropdown from "react-bootstrap/NavDropdown";
import { useNavigate } from "react-router-dom";
import axios from "axios"; // Import axios

function LandlordNavBar() {
  

  let navigate = useNavigate();
  const [landlordID, setLandlordID] = useState(1); // Use a static tenantId for testing

  function handleProfile() {
    navigate("/landlordProfile");
  }

  function handleLogout() {
    navigate("/");
  }

  function handleCurrentRequests() {
    axios
      .get(`http://localhost:8080/landlords/${landlordID}`)
      .then((response) => {
        // Assuming response.data is an array of renting requests
        console.log(response.data);
        navigate("/landlordCurrentRequest", { state: { ...response.data } });
      })
      .catch((error) => {
        console.error("Error fetching renting requests:", error);
        // You can also display a user-friendly error message here
      });
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

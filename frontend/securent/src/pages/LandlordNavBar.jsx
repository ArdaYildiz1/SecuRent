import React from "react";
import { useState } from "react";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import NavDropdown from "react-bootstrap/NavDropdown";
import { useNavigate } from "react-router-dom";
import axios from "axios"; // Import axios

function LandlordNavBar() {
  const [landlordID, setLandlordID] = useState(1); // Use a static landlordID for testing

  let navigate = useNavigate();

  function handleProfile() {
    navigate("/landlordProfile");
  }

  function handleLogout() {
    navigate("/");
  }

  function handleCurrentRequests() {
    axios
      .get(`http://localhost:8080/landlords/${landlordID}/renting-requests/current`)
      .then((response) => {

        navigate("/landlordCurrentRequest", { state: { ...response.data } });
      })
      .catch((error) => {
        console.error("Error fetching houses:", error);
      });

  }

  function handlePastRequests() {
    axios
      .get(`http://localhost:8080/landlords/${landlordID}/renting-requests/past`)
      .then((response) => {

        navigate("/landlordPastRequest", { state: { ...response.data } });
      })
      .catch((error) => {
        console.error("Error fetching houses:", error);
      });

  }

  function handleNotifications() {


    axios
      .get(`http://localhost:8080/landlords/${landlordID}/renting-requests/new`)
      .then((response) => {

        navigate("/landlordNotification", { state: { ...response.data } });
      })
      .catch((error) => {
        console.error("Error fetching houses:", error);
      });
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
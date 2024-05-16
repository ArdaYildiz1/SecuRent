import React, { useState } from "react";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import NavDropdown from "react-bootstrap/NavDropdown";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { useNavigate } from "react-router-dom";

import axios from "axios";

function RealEstateAgentNavBar() {
  const [realEstateAgentId, setRealEstateAgentId] = useState(1); // Use a static landlordID for testing
  let navigate = useNavigate();

  function handleLogOut() {
    navigate("/");
  }
  function handleGoHome() {
    axios
      .get(`http://52.59.214.208:8080/houses`)
      .then((response) => {
        navigate("/realestateagenthome", { state: { ...response.data } });
        console.log(response.data);
      })
      .catch((error) => {
        console.error("Error fetching houses:", error);
      });
  }
  function handleCurrentRequests() {
    axios
      .get(
        `http://52.59.214.208:8080/real-estate-agents/${realEstateAgentId}/rental-service-requests/rental-service/current`
      )
      .then((response) => {
        console.log(response.data);
        navigate("/realEstateAgentCurrentRequest", {
          state: { ...response.data },
        });
      })
      .catch((error) => {
        console.error("Error fetching handle current requests :", error);
      });
  }
  function handlePastRequests() {
    axios
      .get(
        `http://52.59.214.208:8080/real-estate-agents/${realEstateAgentId}/rental-service-requests/rental-service/old`
      )
      .then((response) => {
        console.log(response.data);
        navigate("/realEstateAgentPastRequest", {
          state: { ...response.data },
        });
      })
      .catch((error) => {
        console.error("Error fetching handle current requests :", error);
      });
  }
  function handleHouseConditionList() {
    axios
      .get(
        `http://52.59.214.208:8080/real-estate-agents/${realEstateAgentId}/rental-service-requests/evaluation/current`
      )
      .then((response) => {
        console.log(response.data);
        navigate("/realEstateAgentHouseConditionList", {
          state: { ...response.data },
        });
      })
      .catch((error) => {
        console.error("Error fetching handleHouseConditionList :", error);
      });
  }
  function handleHouseConditionNotifications() {
    axios
      .get(
        `http://52.59.214.208:8080/real-estate-agents/${realEstateAgentId}/rental-service-requests/evaluation/new`
      )
      .then((response) => {
        console.log(response.data);
        navigate("/realEstateAgentHouseCondition", {
          state: { ...response.data },
        });
      })
      .catch((error) => {
        console.error("Error fetching houses:", error);
      });
  }
  function handleNotifications() {
    axios
      .get(
        `http://52.59.214.208:8080/real-estate-agents/${realEstateAgentId}/rental-service-requests/rental-service/new`
      )
      .then((response) => {
        console.log(response.data);
        navigate("/realEstateAgentNotification", {
          state: { ...response.data },
        });
      })
      .catch((error) => {
        console.error("Error fetching houses:", error);
      });
  }
  function handleProfile() {
    navigate("/realEstateAgentProfile");
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

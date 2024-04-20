import React, { useState } from "react";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import NavDropdown from "react-bootstrap/NavDropdown";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { useNavigate } from "react-router-dom";
import axios from "axios"; // Import axios

function TenantNavBar() {
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
  
  let navigate = useNavigate();

  function handleGoHome() {
    navigate("/home");
  }
  function handleRentedHome() {
    axios
      .get(`http://localhost:8080/tenants/${tenantId}/rented-house`)
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

        navigate("/rentedHouse", { state: { ...response.data } });
      })
      .catch((error) => {
        console.error("Error fetching rented house:", error);
      });
  }
  function handleGoProfile() {
    axios
      .get(`http://localhost:8080/tenants/${tenantId}`)
      .then((response) => {
        // Handle the response data, e.g., redirect to a new page
        console.log(response.data);
      })
      .catch((error) => {
        // Handle errors
        console.error("Error fetching profile info:", error);
      });
    navigate("/tenantProfile");
  }
  function handleLogOut() {
    navigate("/");
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
            <Nav.Link className="btn-navbar" onClick={handleRentedHome}>
              Rented House
            </Nav.Link>
          </>
        </Nav>
        <Nav style={{ marginLeft: "auto" }}>
          {/* <Form className="d-flex align-items-center">
                        <Form.Control
                            type="search"
                            placeholder="Search"
                            className="me-2"
                            aria-label="Search"
                            style={{ height: '30px' }}
                        />
                        <Button
                            className="btn-teal d-flex align-items-center"
                            style={{ height: '30px' }}

                        >
                            Search
                        </Button>
                    </Form> */}
          <NavDropdown
            drop="start"
            className="btn-navbar pe-5"
            title={<img src="/usr.png" width="40" height="40" alt="usr logo" />}
            id="basic-nav-dropdown"
          >
            <>
              <NavDropdown.Item
                className="btn-navbar"
                onClick={handleGoProfile}
              >
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

export default TenantNavBar;

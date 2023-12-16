import React from 'react';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import NavDropdown from 'react-bootstrap/NavDropdown';
import {useNavigate} from "react-router-dom";

function LandlordNavBar() {
    let navigate = useNavigate();

    function handleProfile() {
        navigate("/landlordProfile");
    }

    function handleLogout() {
        navigate("/");
    }

    function handleCurrentRequests() {
        navigate("/landlordCurrentRequest");
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
                <img className='ms-4' src="/sr_logo.png" width="50" height="50" />
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
                <Nav style={{ marginLeft: 'auto' }}>

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
import React from 'react';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { useNavigate } from 'react-router-dom';

function TenantNavBar() {
    function handleGoHome() {
        navigate("/home");
    }
    function handleRentedHome() {
        navigate("/rentedHouse");
    }
    function handleGoProfile() {
        navigate("/tenantProfile");
    }
    function handleLogOut() {
        navigate("/");
    }

    let navigate = useNavigate();

    return (
        <Navbar bg="light" expand="lg">
            <Navbar.Brand>
                <img className='ms-4' src="/sr_logo.png" width="50" height="50" />
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
                <Nav style={{ marginLeft: 'auto' }}>
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
                            
                            <NavDropdown.Item className="btn-navbar" onClick={handleGoProfile}>
                                Profile
                            </NavDropdown.Item>
                            
                            <NavDropdown.Item className="btn-navbar"  onClick={handleLogOut}>
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
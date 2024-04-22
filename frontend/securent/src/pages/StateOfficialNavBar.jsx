import React from 'react';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import {useNavigate} from "react-router-dom";

function StateOfficialNavBar() {

    let navigate = useNavigate();

    function handleStateOfficialHome() {
        navigate("/stateofficialhome");
    }
    
    function handleHandledComplaints() {
        navigate("/handledcomplaints");
    }
    
    function handlePendingComplaints() {
        navigate("/pendingcomplaints");
    }
    
    function handleApprovedContracts() {
        navigate("/approvedContracts");
    }
    
    function handleContracts() {
        navigate("/contracts");
    }
    
    function handleNotifications() {
        navigate("/StateOfficialNotification");
    }

    function handleDepositSide() {
        navigate("/choosedDeposit");
    }

    function handleProfile() {
        navigate("/stateOfficialProfile");
    }

    function handleLogout() {
        navigate("/");
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
                        <Nav.Link onClick={handleStateOfficialHome} className="btn-navbar">
                            Home
                        </Nav.Link>

                        <Nav.Link onClick={handleHandledComplaints} className="btn-navbar">
                            Handled Complaints
                        </Nav.Link>
                        <Nav.Link onClick={handlePendingComplaints} className="btn-navbar">
                            Pending Complaints
                        </Nav.Link>
                        <Nav.Link onClick={handleApprovedContracts} className="btn-navbar">
                            Approved Contracts
                        </Nav.Link>

                        <Nav.Link onClick={handleContracts} className="btn-navbar">
                            Contracts
                        </Nav.Link>
                        <Nav.Link onClick={handleNotifications } className="btn-navbar">
                            Notifications
                        </Nav.Link>
                        <Nav.Link onClick={handleDepositSide} className="btn-navbar">
                            Deposit Side
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

export default StateOfficialNavBar;
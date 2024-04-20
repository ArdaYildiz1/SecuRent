import Button from 'react-bootstrap/esm/Button';
import React, { useRef, useState } from 'react';
import pp from './defaultPP.jpg';
import {  FormControl } from 'react-bootstrap';
import TopNavBar from './TopNavBar';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import TenantNavBar from './TenantNavBar';
import { useLocation } from 'react-router-dom';


function TenantProfile() {
    const location = useLocation();
    console.log(location.state);

    const [entityId, setEntityId] = useState(location.state.entityId);
    const [firstName, setFirstName] = useState(location.state.firstName);
    const [lastName, setLastName] = useState(location.state.lastName);
    const [password, setPassword] = useState(location.state.password);
    const [emailAddress, setEmailAddress] = useState(location.state.emailAddress);
    const [phoneNo, setPhoneNo] = useState(location.state.phoneNo);
    const [tck, setTck] = useState(location.state.tck);
    const [depositPaymentStatus, setDepositPaymentStatus] = useState(location.state.depositPaymentStatus);
    const [depositAmount, setDepositAmount] = useState(location.state.depositAmount);
    console.log(entityId);

    const [selectedFile, setSelectedFile] = useState(null);
    const fileInputRef = useRef(null);

    const handleButtonClick = () => {
        fileInputRef.current.click();
    };

    const handleFileChange = (e) => {
        const file = e.target.files[0];
        console.log('Selected file:', file);
        setSelectedFile(file);
    };

    return (
        <>
            <TenantNavBar />
            
            <div style={{ width: '100%', height: '100vh', overflowY: 'auto', flexDirection: 'row', display: 'flex' }}>
                <Card style={{ width: '20%',  backgroundColor: '#f1f2ed', borderRadius: "1rem", height: '80vh', margin: '40px', alignItems: 'center', display: 'flex', flexDirection: 'column', justifyContent: 'center' }}>
                    <p style={{ fontSize: 24 }}>Ali Eren Taş</p>
                    <img src={selectedFile ? URL.createObjectURL(selectedFile) : pp} style={{ width: '100px', height: '100px', borderRadius: '50%' }} />
                    <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
                        <Button style={{ backgroundColor: '#2D9596', borderColor: '#2D9596', marginTop: 20 }} onClick={handleButtonClick}>
                            Upload Photo
                        </Button>
                        <Form.Group controlId="formFile" style={{ display: 'none' }}>
                            <Form.Control
                                type="file"
                                ref={fileInputRef}
                                style={{ display: 'none' }}
                                onChange={handleFileChange}
                            />
                        </Form.Group>
                    </div>
                    <div style={{ width: '80%', alignItems: 'center', display: 'flex', justifyContent: 'center', backgroundColor: '#ECEAEA', marginTop: 20, paddingTop: 20, borderRadius: '5%' }}>
                        <p style={{ alignItems: 'center', display: 'flex', textAlign: 'center' }}>
                            Upload your photo to ensure a better communication
                        </p>
                    </div>

                </Card>

                <Card style={{ width: '70%', backgroundColor: '#f1f2ed', borderRadius: "1rem", height: '80vh', margin: '40px', alignItems: 'center', display: 'flex', justifyContent: 'center' }}>
                    <Form style={{ width: '70%', alignItems: 'center' }}>
                        <Form.Group controlId="formName">
                            <Form.Label>Name:</Form.Label>
                            <FormControl type="text" value={firstName} readOnly disabled />
                        </Form.Group>
                        <br />
                        <Form.Group controlId="formSurname">
                            <Form.Label>Surname:</Form.Label>
                            <FormControl type="text" value={lastName} readOnly disabled />
                        </Form.Group>
                        <br />

                        <Form.Group controlId="formTCNumber">
                            <Form.Label>TC Number:</Form.Label>
                            <FormControl type="text" value={tck} readOnly disabled />
                        </Form.Group>
                        <br />
                        <Form.Group controlId="formPhoneNumber">
                            <Form.Label>Phone Number:</Form.Label>
                            <FormControl type="text" value={phoneNo} readOnly disabled />
                        </Form.Group>
                        <br />

                        <Form.Group controlId="formEmailAddress">
                            <Form.Label>E-mail Address:</Form.Label>
                            <FormControl type="email" value={emailAddress} readOnly disabled />
                        </Form.Group>
                        <br />

                        <Form.Group controlId="formPassword">
                            <Form.Label>Password:</Form.Label>
                            <FormControl type="password" placeholder={password}readOnly disabled />
                        </Form.Group>
                    </Form>
                </Card>
            </div>
        </>

    );
}

export default TenantProfile;
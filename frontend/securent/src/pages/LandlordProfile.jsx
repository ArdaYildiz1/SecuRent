import Button from 'react-bootstrap/esm/Button';
import React, { useRef, useState } from 'react';
import pp from './defaultPP.jpg';
import {  FormControl } from 'react-bootstrap';
import TopNavBar from './TopNavBar';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import LandlordNavBar from './LandlordNavBar';


function LandlordProfile() {
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
            <LandlordNavBar />
            
            <div style={{ width: '100%', height: '100vh', overflowY: 'auto', flexDirection: 'row', display: 'flex' }}>
                <Card style={{ width: '20%',  backgroundColor: '#f1f2ed', borderRadius: "1rem", height: '80vh', margin: '40px', alignItems: 'center', display: 'flex', flexDirection: 'column', justifyContent: 'center' }}>

                    <p style={{ fontSize: 24 }}>John Doe</p>
                    <img src={selectedFile ? URL.createObjectURL(selectedFile) : pp} style={{ width: '100px', height: '100px', borderRadius: '50%' }} />
                    <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
                       
                        <Form.Group controlId="formFile" style={{ display: 'none' }}>
                            <Form.Control
                                type="file"
                                ref={fileInputRef}
                                style={{ display: 'none' }}
                                onChange={handleFileChange}
                            />
                        </Form.Group>
                    </div>
                   

                </Card>

                <Card style={{ width: '70%', backgroundColor: '#f1f2ed', borderRadius: "1rem", height: '80vh', margin: '40px', alignItems: 'center', display: 'flex', justifyContent: 'center' }}>
                    <Form style={{ width: '70%', alignItems: 'center' }}>
                        <Form.Group controlId="formName">
                            <Form.Label>Name:</Form.Label>
                            <FormControl type="text" value="John" readOnly disabled />
                        </Form.Group>
                        <br />
                        <Form.Group controlId="formSurname">
                            <Form.Label>Surname:</Form.Label>
                            <FormControl type="text" value="Doe" readOnly disabled />
                        </Form.Group>
                        <br />

                        <Form.Group controlId="formTCNumber">
                            <Form.Label>TC Number:</Form.Label>
                            <FormControl type="text" value="12345678901" readOnly disabled />
                        </Form.Group>
                        <br />

                        <Form.Group controlId="formEmailAddress">
                            <Form.Label>E-mail Address:</Form.Label>
                            <FormControl type="email" value="john.doe@example.com" readOnly disabled />
                        </Form.Group>
                        <br />
                        <Form.Group controlId="formEmailAddress">
                            <Form.Label>Phone Number:</Form.Label>
                            <FormControl type="text" value="123-456-7890" readOnly disabled />
                        </Form.Group>
                        <br />
                        <Form.Group controlId="formPassword">
                            <Form.Label>Password:</Form.Label>
                            <FormControl type="password" placeholder="************" readOnly disabled />
                        </Form.Group>
                    </Form>
                </Card>
            </div>
        </>

    );
}

export default LandlordProfile;

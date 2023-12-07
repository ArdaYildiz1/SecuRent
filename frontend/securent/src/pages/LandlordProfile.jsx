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

                    <p style={{ fontSize: 24 }}>Hikmet Kara</p>
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
                            <FormControl type="text" value="Hikmet" readOnly disabled />
                        </Form.Group>
                        <br />
                        <Form.Group controlId="formSurname">
                            <Form.Label>Surname:</Form.Label>
                            <FormControl type="text" value="Kara" readOnly disabled />
                        </Form.Group>
                        <br />

                        <Form.Group controlId="formTCNumber">
                            <Form.Label>TC Number:</Form.Label>
                            <FormControl type="text" value="987654321" readOnly disabled />
                        </Form.Group>
                        <br />

                        <Form.Group controlId="formEmailAddress">
                            <Form.Label>E-mail Address:</Form.Label>
                            <FormControl type="email" value="hikmetkara@example.com" readOnly disabled />
                        </Form.Group>
                        <br />
                        <Form.Group controlId="formEmailAddress">
                            <Form.Label>Phone Number:</Form.Label>
                            <FormControl type="text" value="05333333333" readOnly disabled />
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

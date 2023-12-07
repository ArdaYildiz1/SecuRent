import Button from 'react-bootstrap/esm/Button';
import React, { useRef, useState } from 'react';
import pp from './defaultPP.jpg';
import {  FormControl } from 'react-bootstrap';
import TopNavBar from './TopNavBar';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';


function SeeLandlordProfile() {
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
            <TopNavBar />
            
            <div style={{ width: '100%', height: '100vh', overflowY: 'auto', flexDirection: 'row', display: 'flex' }}>
                <Card style={{ width: '20%',  backgroundColor: '#f1f2ed', borderRadius: "1rem", height: '80vh', margin: '40px', alignItems: 'center', display: 'flex', flexDirection: 'column', justifyContent: 'center' }}>
                    <p style={{ fontSize: 24 }}>Ali Eren Taş</p>
                    <img src={selectedFile ? URL.createObjectURL(selectedFile) : pp} style={{ width: '200px', height: '200px', borderRadius: '50%' }} />
                   
                    
                </Card>

                <Card style={{ width: '70%', backgroundColor: '#f1f2ed', borderRadius: "1rem", height: '80vh', margin: '40px', alignItems: 'center', display: 'flex', justifyContent: 'center' }}>
                    <Form style={{ width: '70%', alignItems: 'center' }}>
                        <Form.Group controlId="formName">
                            <Form.Label>Name:</Form.Label>
                            <FormControl type="text" value="Ali Eren" readOnly disabled />
                        </Form.Group>
                        <br />
                        <Form.Group controlId="formSurname">
                            <Form.Label>Surname:</Form.Label>
                            <FormControl type="text" value="Taş" readOnly disabled />
                        </Form.Group>
                        <br />

                        <Form.Group controlId="formTCNumber">
                            <Form.Label>TC Number:</Form.Label>
                            <FormControl type="text" value="123456789" readOnly disabled />
                        </Form.Group>
                        <br />
                        <Form.Group controlId="formPhoneNumber">
                            <Form.Label>Phone Number:</Form.Label>
                            <FormControl type="text" value="+90123456789" readOnly disabled />
                        </Form.Group>
                        <br />

                        <Form.Group controlId="formEmailAddress">
                            <Form.Label>E-mail Address:</Form.Label>
                            <FormControl type="email" value="alitas@example.com" readOnly disabled />
                        </Form.Group>
                        <br />

                        
                    </Form>
                </Card>
            </div>
        </>

    );
}

export default SeeLandlordProfile;

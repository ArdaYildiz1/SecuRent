import Button from 'react-bootstrap/esm/Button';
import React, { useRef, useState } from 'react';
import pp from './defaultPP.jpg';
import {  FormControl } from 'react-bootstrap';
import TopNavBar from './TopNavBar';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import StateOfficialNavBar from './StateOfficialNavBar';
import AdminNavBar from './AdminNavBar';


function AdminUpdateProfile() {
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
            <AdminNavBar />
            
            <div style={{ width: '100%', height: '100vh', overflowY: 'auto', flexDirection: 'row', display: 'flex' }}>
                <Card style={{ width: '20%',  backgroundColor: '#f1f2ed', borderRadius: "1rem", height: '80vh', margin: '40px', alignItems: 'center', display: 'flex', flexDirection: 'column', justifyContent: 'center' }}>
                    <p style={{ fontSize: 24 }}>Burcu Çelik</p>
                    <img src={selectedFile ? URL.createObjectURL(selectedFile) : pp} style={{ width: '100px', height: '100px', borderRadius: '50%' }} />
                    <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
                        <Button style={{ backgroundColor: '#2D9596', borderColor: '#2D9596', marginTop: 20 }} onClick={handleButtonClick}>
                            Update Photo
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
                    

                </Card>

                <Card style={{ width: '70%', backgroundColor: '#f1f2ed', borderRadius: "1rem", height: '80vh', margin: '40px', alignItems: 'center', display: 'flex', justifyContent: 'center' }}>
                    <Form style={{ width: '70%', alignItems: 'center' }}>
                        <Form.Group controlId="formName">
                            <Form.Label>Name:</Form.Label>
                            <FormControl type="text" placeholder="Burcu"  />
                        </Form.Group>
                        <br />
                        <Form.Group controlId="formSurname">
                            <Form.Label>Surname:</Form.Label>
                            <FormControl type="text" placeholder="Çelik"/>
                        </Form.Group>
                        <br />

                        <Form.Group controlId="formTCNumber">
                            <Form.Label>TC Number:</Form.Label>
                            <FormControl type="text" placeholder="1111111111"  />
                        </Form.Group>
                        <br />

                        <Form.Group controlId="formEmailAddress">
                            <Form.Label>E-mail Address:</Form.Label>
                            <FormControl type="email" placeholder="burcucelik@example.com" />
                        </Form.Group>
                        <br />
                        <Form.Group controlId="formPhoneNumber">
                            <Form.Label>Phone Number:</Form.Label>
                            <FormControl type="text" placeholder="+90123456789"  />
                        </Form.Group>
                        <br />

                        <Form.Group controlId="formPassword">
                            <Form.Label>Password:</Form.Label>
                            <FormControl type="password" placeholder="**********"  />
                        </Form.Group>
                        <br />

                        <Button className="btn-teal">Update Account Information</Button>
                    </Form>
                </Card>
            </div>
        </>

    );
}

export default AdminUpdateProfile

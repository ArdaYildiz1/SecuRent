import Button from 'react-bootstrap/esm/Button';
import React, { useRef, useState } from 'react';
import pp from './defaultPP.jpg';
import { FormControl } from 'react-bootstrap';
import TopNavBar from './TopNavBar';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import SeeLandlordProfile from './SeeLandlordProfile';
import LandlordNavBar from './LandlordNavBar';

function SeeTenantAndRealEstateAgent() {

    return (
        <>
            <LandlordNavBar />
            <div style={{display:'flex', flexDirection:'row' ,height:'120vh'}}>

                <div style={{ width: '100%', height: '100vh',  flexDirection: 'column', display: 'flex' ,alignItems:'center'}}>
                   
                   <h1 style={{color:'white'}}>Tenant</h1>
                    <Card style={{ width: '40%', backgroundColor: '#f1f2ed', borderRadius: "1rem", height: '80vh', margin: '40px', alignItems: 'center', display: 'flex', flexDirection: 'column', justifyContent: 'center' }}>
                        <p style={{ fontSize: 24 }}>Ali Eren Taş</p>
                        <img src={pp} style={{ width: '150px', height: '150px', borderRadius: '50%' }} />


                    </Card>

                    <Card style={{ width: '70%', backgroundColor: '#f1f2ed', borderRadius: "1rem", height: '80vh', margin: '40px', alignItems: 'center', display: 'flex', justifyContent: 'center' ,paddingTop:20}}>
                        <Form style={{ width: '70%', alignItems: 'center' }}>
                            <Form.Group controlId="formName">
                                <Form.Label>Name:</Form.Label>
                                <FormControl type="text" value="Kazım" readOnly disabled />
                            </Form.Group>
                            <br />
                            <Form.Group controlId="formSurname">
                                <Form.Label>Surname:</Form.Label>
                                <FormControl type="text" value="Aslan" readOnly disabled />
                            </Form.Group>
                            <br />

                            <Form.Group controlId="formTCNumber">
                                <Form.Label>TC Number:</Form.Label>
                                <FormControl type="text" value="313212389" readOnly disabled />
                            </Form.Group>
                            <br />
                            <Form.Group controlId="formPhoneNumber">
                                <Form.Label>Phone Number:</Form.Label>
                                <FormControl type="text" value="+90888456789" readOnly disabled />
                            </Form.Group>
                            <br />

                            <Form.Group controlId="formEmailAddress">
                                <Form.Label>E-mail Address:</Form.Label>
                                <FormControl type="email" value="kazimaslan@example.com" readOnly disabled />
                            </Form.Group>
                            <br />


                        </Form>
                    </Card>
                </div>

                <div style={{ width: '100%', height: '100vh',  flexDirection: 'column', display: 'flex' ,alignItems:'center'}}>
                    
                <h1 style={{color:'white'}}>Real Estate Agent</h1>

                    <Card style={{ width: '40%', backgroundColor: '#f1f2ed', borderRadius: "1rem", height: '80vh', margin: '40px', alignItems: 'center', display: 'flex', flexDirection: 'column', justifyContent: 'center' }}>
                        <p style={{ fontSize: 24 }}>Ali Eren Taş</p>
                        <img src={pp} style={{ width: '150px', height: '150px', borderRadius: '50%' }} />


                    </Card>

                    <Card style={{ width: '70%', backgroundColor: '#f1f2ed', borderRadius: "1rem", height: '80vh', margin: '40px', alignItems: 'center', display: 'flex', justifyContent: 'center' ,paddingTop:20}}>
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

                            <Form.Group controlId="formEmailAddress">
                                <Form.Label>Location:</Form.Label>
                                <FormControl type="text" value="Çankaya" readOnly disabled />
                            </Form.Group>
                            <br />
                        </Form>
                    </Card>
                </div>
            </div>

        </>

    );
}

export default SeeTenantAndRealEstateAgent;

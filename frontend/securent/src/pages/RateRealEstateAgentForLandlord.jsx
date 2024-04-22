import React from 'react';
import TopNavBar from './TopNavBar';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import { useNavigate } from 'react-router-dom';
import LandlordNavBar from './LandlordNavBar';

function RateRealEstateAgentForLandlord() {

    return (
        <>
            <LandlordNavBar />
            <br />
            <div className="container-fluid" style={{ height: "100vh" }}>
                <div className="row">
                    <div className="col-md-3"></div>
                    <div className="col-md-6">
                        <br />
                        <h2 className="text-center" style={{ color: '#FEF2F4' }}>
                            Rate Real Estate Agent
                        </h2>

                        <br />

                        <Card className="mb-3" style={{ borderRadius: '1rem', height: "40vh" ,display:'flex',justifyContent:'center',alignItems:'center'}}>
                            <div className="row">
                                <br />
                                <Form>
                                    <Form.Group className="ms-5 me-5 mb-3" style={{ marginTop:10}} controlId="loginPassword">
                                        <br />
                                        <Form.Group className="d-flex align-items-center">
                                            <h2>Real Estate Agent 1</h2>
                                        </Form.Group>




                                        <Form.Group className="d-flex align-items-center">
                                            <Form.Label className="d-flex justify-content-center">Rate the agent out of                                                5</Form.Label>
                                        </Form.Group>
                                        <Form.Control style={{ width: '100px' ,marginTop:10}} type="number" min="1" max="5" />




                                        <Button style={{ marginTop:10}} className="btn-teal">
                                            Send
                                        </Button>
                                    </Form.Group>
                                </Form>
                                <br /><br />
                            </div>
                        </Card>

                    </div>
                </div>
            </div>
            <br /><br />
            <br /><br /><br />
        </>
    );
}

export default RateRealEstateAgentForLandlord;
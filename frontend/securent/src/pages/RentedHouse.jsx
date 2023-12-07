import React from 'react';
import TopNavBar from './TopNavBar';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Carousel from 'react-bootstrap/Carousel';
import Modal from 'react-bootstrap/Modal';
import { useState } from 'react';
import TenantNavBar from './TenantNavBar';



function RentedHouse() {
    const [show, setShow] = useState(false);
    const [explanation, setExplanation] = useState("");


    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);


    return (
        <>
            <TenantNavBar />
            <br />

            <div className="container-fluid" style={{height:"80vh"}}>
                <div className="row">
                    <div className="col-md-2"></div>
                    <div className="col-md-8">
                        <Card className="mb-3" style={{ backgroundColor: '#f1f2ed', borderRadius: '1rem' ,height:"60vh", display:'flex',justifyContent:'center',alignItems:'center'}}>

                            <div className="row flex-container">


                                <div className="row">
                                    <Form>
                                        <Form.Group className="ms-5 me-5 mb-3" controlId="loginPassword">
                                            <h5>You can send request for house condition check if reamining contract time is less than 7 days!</h5>
                                            <br></br>
                                            <div style={{ display: 'flex', flexdirection: 'column' }}>
                                                <h5>Remaining Time For Contract End: </h5>
                                                <p style={{ marginLeft: 10 }}>06 days, 20 hours, 20 minutes</p>
                                            </div>
                                            <br />
                                            <div className="" style={{ display: 'flex', flexdirection: 'column', alignItems: 'center' }}>
                                                <h5 style={{ marginRight: 10 }}>Select agent to request house condition check:</h5>
                                                <Button className="btn-teal">
                                                    Select Agent
                                                </Button>
                                            </div>
                                        </Form.Group>
                                    </Form>
                                    <br /><br />
                                </div>
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
export default RentedHouse;
import Button from 'react-bootstrap/esm/Button';
import React from 'react';
import pp from './defaultPP.jpg';
import TopNavBar from './TopNavBar';
import { Card, Col, Form, Row } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import StateOfficialNavBar from './StateOfficialNavBar';

function ChoosedDeposit() {
    const navigate = useNavigate();


    const dynamicData = ['Ahmet Kalem', 'Fatih Koray', 'Ali Tarık Çam', 'Kasım Kale', 'Fatih Çakıl', 'Ali Tarık', 'Ahmet Kalem', 'Fatih Kor', 'Ali Tarık', 'Mehmet Ersoy', 'Fatih Kor', 'Ali Tarık', 'Mehmet Ersoy', 'Fatih Kor', 'Ali Tarık', 'Mehmet Ersoy'];

    const DynamicList = ({ data }) => {
        return (
            <>

                <div className="row">
                    <div className="col-md-2"></div>
                    <div className="col-md-8">
                        <Row xs={1} md={3} className="g-4">
                            <>
                                {Array.from({ length: 5 }).map((_, idx) => (
                                    <Col key={idx}>
                                        {/* this will direct to the house complaint occured */}
                                        <Card
                                            onClick={() => navigate('/houseDetails')}

                                            className="clickable-card"
                                            style={{ borderRadius: '2rem' }}
                                        >
                                            <br />
                                            <Card.Img
                                                className="ps-3 pe-3"
                                                style={{ borderRadius: '1rem' }}
                                                variant="top"
                                                src={pp}
                                            />
                                            <Card.Body>
                                                <Card.Title style={{ color: "black" }}>{dynamicData[idx]}</Card.Title>
                                                <Card.Text style={{ color: "black" }}>
                                                    {dynamicData[idx]}'s house's condition file.
                                                </Card.Text>
                                                <div style={{ display: 'flex', justifyContent: 'center' }}>
                                                    <Button style={{ width: '200px', height: '70px' }} className="btn-teal"
                                                        type="submit">
                                                        Download  Condition File
                                                    </Button>
                                                </div>

                                                {['radio'].map((type) => (
                                                    <div key={`reverse-${type}`} className="mb-3" style={{ marginTop: 10, display: 'flex', flexDirection: 'row' }}>
                                                        <Form.Check
                                                            label="Tenant"
                                                            name="group1"
                                                            type={type}
                                                            id={`reverse-${type}-1`}
                                                            style={{ marginRight: 50, marginLeft: 30 }}
                                                        />
                                                        <Form.Check
                                                            label="Landlord"
                                                            name="group1"
                                                            type={type}
                                                            id={`reverse-${type}-2`}
                                                        />

                                                    </div>
                                                ))}

                                                <div style={{ display: 'flex', justifyContent: 'center' }}>
                                                    <Button style={{ width: '200px', height: '70px' }} className="btn-teal"
                                                        type="submit">
                                                        Submit the Deposit Side
                                                    </Button>
                                                </div>

                                                <br />
                                            </Card.Body>
                                        </Card>
                                    </Col>
                                ))}
                            </>

                        </Row>
                    </div>
                    <div className="col-md-2"></div>
                </div>
            </>
        );
    };

    return (
        <>
            <StateOfficialNavBar />

            <div style={{ width: '100%', height: '100vh', overflowY: 'auto' }}>

                <div style={{ display: 'flex', justifyContent: 'center', paddingTop: '2%', paddingBottom: '2%' }}>
                    <h1 style={{ color: "white" }}>
                        Choose Who Will Keep The Deposit
                    </h1>
                </div>

                <div style={{ width: '100%', height: '100vh', }}>
                    <DynamicList data={dynamicData} />
                </div>
            </div>
        </>

    );
}

export default ChoosedDeposit;

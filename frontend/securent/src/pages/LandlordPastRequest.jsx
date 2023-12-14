import Button from 'react-bootstrap/esm/Button';
import React from 'react';
import pp from './defaultPP.jpg';
import TopNavBar from './TopNavBar';
import { Card, Col, Form, Row } from 'react-bootstrap';
import { Link, useNavigate } from 'react-router-dom';
import LandlordNavBar from './LandlordNavBar';

function LandlordPastRequest() {


    const dynamicData = ['Ahmet Kalem', 'Fatih Kor', 'Ali Tarık', 'Kasım Kale', 'Fatih Kor', 'Ali Tarık', 'Ahmet Kalem', 'Fatih Kor', 'Ali Tarık', 'Mehmet Ersoy', 'Fatih Kor', 'Ali Tarık', 'Mehmet Ersoy', 'Fatih Kor', 'Ali Tarık', 'Mehmet Ersoy'];
    const realEstateAgent = ['Real Estate Agent'];
    function handleSeeProfiles() {
        navigate("/seeTenantAndRealEstateAgent");
    }

    let navigate = useNavigate();

    const DynamicList = ({ data, realEstateAgent }) => {
        return (
            <>

                <div className="row">
                    <div className="col-md-2"></div>
                    <div className="col-md-8">
                        <Row xs={1} md={3} className="g-4">
                            <>
                                {Array.from({ length: 4 }).map((_, idx) => (
                                    <Col key={idx}>
                                        {/* burayı belki bir profile yönlendiririz   to={`/houseDetails`}*/}
                                        <div>
                                            <Card
                                                className="clickable-card"
                                                style={{ backgroundColor: '#f1f2ed', borderRadius: '2rem' }}
                                            >
                                                <br />
                                                <div style={{ display: 'flex', flexDirection: 'row', justifyContent: 'center', marginBottom: 30 }}>
                                                    <div style={{ display: 'flex', flexDirection: 'column', justifyContent: 'center', alignItems: 'center' }}>
                                                        <h4>Tenant</h4>
                                                        <Card.Img
                                                            style={{ borderRadius: '1rem', width: '120px', height: '120px' }}
                                                            variant="top"
                                                            src={pp}
                                                        />
                                                    </div>
                                                    <div style={{ display: 'flex', flexDirection: 'column', justifyContent: 'center', alignItems: 'center' }}>
                                                        <h4 >Real Estate</h4>

                                                        <Card.Img

                                                            style={{ borderRadius: '1rem', width: '120px', height: '120px', marginLeft: 10 }}
                                                            variant="top"
                                                            src={pp}
                                                        />
                                                    </div>

                                                </div>

                                                <Card.Body>
                                                    <Card.Title style={{ color: "black" }}>{dynamicData[idx]}</Card.Title>
                                                    <Card.Text style={{ color: "black" }}>
                                                        {dynamicData[idx]} requested to see your house {idx} with {realEstateAgent[0]} {idx}.
                                                    </Card.Text>

                                                    <div style={{ display: 'flex', flexDirection: 'row', justifyContent: 'center' }}>

                                                        <Button style={{ width: '150px', height: '50px' }} className="btn-teal"
                                                            type="submit"
                                                            onClick={handleSeeProfiles}>
                                                            See the Profiles
                                                        </Button>
                                                    </div>

                                                    <br />
                                                </Card.Body>
                                            </Card>
                                        </div>
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
            <LandlordNavBar />

            <div style={{ width: '100%', height: '100vh', overflowY: 'auto' }}>

                <div style={{ display: 'flex', justifyContent: 'center', paddingTop: '2%', paddingBottom: '2%' }}>
                    <h1 style={{ color: "white" }}>
                        Past Requests
                    </h1>
                </div>

                <div style={{ width: '100%', height: '100vh', }}>
                    <DynamicList data={dynamicData} realEstateAgent={realEstateAgent} />
                </div>
            </div>
        </>

    );
}

export default LandlordPastRequest;

import Button from 'react-bootstrap/esm/Button';
import React from 'react';
import pp from './defaultPP.jpg';
import TopNavBar from './TopNavBar';
import { Card, Col, Form, Row } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import RealEstateAgentNavBar from './RealEstateAgentNavBar';

function ListUsers() {


    const dynamicData = ['Ahmet Kalem', 'Fatih Kor', 'Ali Tarık', 'Kasım Kale', 'Fatih Kor', 'Ali Tarık', 'Ahmet Kalem', 'Fatih Kor', 'Ali Tarık', 'Mehmet Ersoy', 'Fatih Kor', 'Ali Tarık', 'Mehmet Ersoy', 'Fatih Kor', 'Ali Tarık', 'Mehmet Ersoy'];

    const DynamicList = ({ data }) => {
        return (
            <>

                <div className="row">
                    <div className="col-md-2"></div>
                    <div className="col-md-8">
                        <Row xs={1} md={3} className="g-4">
                            <>
                                {Array.from({ length: 4 }).map((_, idx) => (
                                    <Col key={idx}>
                                        <Link to={`/houseDetails`} style={{ textDecoration: 'none' }}>
                                            <Card
                                                className="clickable-card"
                                                style={{ backgroundColor: '#f1f2ed', borderRadius: '2rem' }}
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



                                                    <div style={{ display: 'flex', flexDirection: 'row' }}>
                                                        <Button style={{ width: '150px', height: '50px' }} className="btn-teal"
                                                            type="submit">
                                                            See the Profile
                                                        </Button>
                                                        <Button style={{ width: '150px', height: '50px' }} className="btn-teal"
                                                            type="submit">
                                                            Update Profile
                                                        </Button>
                                                    </div>

                                                    <br />
                                                </Card.Body>
                                            </Card>
                                        </Link>
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
            <RealEstateAgentNavBar />

            <div style={{ width: '100%', height: '100vh', overflowY: 'auto', }}>

                <div style={{ display: 'flex', justifyContent: 'center', paddingTop: '2%', paddingBottom: '2%' }}>
                    <h1 style={{ color: "white" }}>
                        Tenants
                    </h1>
                </div>
                <div style={{ width: '100%', height: '10vh', display: 'flex', justifyContent: 'center', alignItems: 'center' , color: "white"}}>
                    {['radio'].map((type) => (
                        <div key={`inline-${type}`} className="mb-3">
                            <Form.Check
                                inline
                                label="Tenant"
                                name="group1"
                                type={type}
                                id={`inline-${type}-1`}
                                value="Tenant"

                            />
                            <Form.Check
                                inline
                                label="Landlord"
                                name="group1"
                                type={type}
                                id={`inline-${type}-2`}
                                value="Landlord"

                            />
                            <Form.Check
                                inline
                                label="Real Estate"
                                name="group1"
                                type={type}
                                id={`inline-${type}-3`}
                                value="Real Estate"

                            />
                            <Form.Check
                                inline
                                label="State Official"
                                name="group1"
                                type={type}
                                id={`inline-${type}-4`}
                                value="State Official"

                            />
                            <Button className="btn-teal" > List Users</Button>
                        </div>
                    ))}
                </div>



                <div style={{ width: '100%', height: '100vh', }}>
                    <DynamicList data={dynamicData} />
                </div>
            </div>
        </>

    );
}

export default ListUsers;

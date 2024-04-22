import Button from 'react-bootstrap/esm/Button';
import React from 'react';
import pp from './defaultPP.jpg';
import TopNavBar from './TopNavBar';
import { Card, Col, Form, Row } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import StateOfficialNavBar from './StateOfficialNavBar';

function Contracts() {
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
                                                    {dynamicData[idx]} has been uploaded a contract.
                                                </Card.Text>
                                                <div style={{display:'flex', justifyContent:'center'}}>
                                                    <Button style={{ width: '200px', height: '50px' }} className="btn-teal"
                                                        type="submit">
                                                        Download  Contract
                                                    </Button>
                                                </div>
                                                <div style={{ display: 'flex', flexDirection: 'row' }}>
                                                    <Button style={{ width: '150px', height: '50px' }} className="btn-decline"
                                                        type="submit">
                                                        Decline
                                                    </Button>
                                                    <Button style={{ width: '150px', height: '50px' }} className="btn-fav"
                                                        type="submit">
                                                        Accept
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
                        Contracts
                    </h1>
                </div>

                <div style={{ width: '100%', height: '100vh', }}>
                    <DynamicList data={dynamicData} />
                </div>
            </div>
        </>

    );
}

export default Contracts;

import React from 'react';
import { Link } from 'react-router-dom';
import Card from 'react-bootstrap/Card';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import Button from 'react-bootstrap/Button';
import TopNavBar from './TopNavBar';

export default function HomePage() {


    return (
        <>
        <TopNavBar></TopNavBar>
            <br />
            <div className="row">
                <div className="col-md-2"></div>
                <div className="col-md-8">
                    <Row xs={1} md={3} className="g-4">
                        <>
                            {Array.from({ length: 7 }).map((_, idx) => (
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
                                                src="https://placehold.co/600x400"
                                            />
                                            <Card.Body>
                                                <Card.Title style={{ color: "black" }}>Lorem Ipsum</Card.Title>
                                                <Card.Title style={{ color: "black" }}>Dolor sit amet</Card.Title>
                                                <Card.Text style={{ color: "black" }}>
                                                    Price
                                                </Card.Text>
                                                <Button style={{ width: '150px', height: '50px' }} className="btn-teal"
                                                    type="submit">
                                                    Details
                                                </Button>
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
            <br /><br /><br />
        </>
    );
}
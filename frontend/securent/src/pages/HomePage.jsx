import React from 'react';
import { Link } from 'react-router-dom';
import Card from 'react-bootstrap/Card';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import Button from 'react-bootstrap/Button';
import TopNavBar from './TopNavBar';
import FilterComponent from './FilterComponent';

export default function HomePage() {


    return (
        <>
            <TopNavBar></TopNavBar>
            <br />
            <div className="row">
                <div className="col-md-2"></div>
                <div className="col-md-8">
                    <FilterComponent/>
                    <br /><br />
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
                                            <Card.Body>
                                                {idx === 0 && (
                                                    <>
                                                        <Card.Img
                                                            className="ps-3 pe-3"
                                                            style={{ borderRadius: '1rem', height: '280px' }}
                                                            variant="top"
                                                            src="/h1.jpg"
                                                        />
                                                        <Card.Title style={{ color: "black" }}> <br /> İncek 4+1 Daire</Card.Title>
                                                        <Card.Title style={{ color: "black" }}>Ankara / Gölbaşı</Card.Title>
                                                        <Card.Text style={{ color: "black" }}>
                                                            21.000 TL
                                                        </Card.Text>
                                                    </>
                                                )}
                                                {idx === 1 && (
                                                    <>
                                                        <Card.Img
                                                            className="ps-3 pe-3"
                                                            style={{ borderRadius: '1rem', height: '280px' }}
                                                            variant="top"
                                                            src="/h2.jpg"
                                                        />
                                                        <Card.Title style={{ color: "black" }}> <br /> Lösante Hastanesine Yakın 2+1</Card.Title>
                                                        <Card.Title style={{ color: "black" }}>Beytepe</Card.Title>
                                                        <Card.Text style={{ color: "black" }}>
                                                            24.000 TL
                                                        </Card.Text>
                                                    </>
                                                )}
                                                {idx === 2 && (
                                                    <>
                                                        <Card.Img
                                                            className="ps-3 pe-3"
                                                            style={{ borderRadius: '1rem', height: '280px' }}
                                                            variant="top"
                                                            src="/h3.jpg"
                                                        />
                                                        <Card.Title style={{ color: "black" }}> <br /> ACIBADEM CAD. 210 m2 NET</Card.Title>
                                                        <Card.Title style={{ color: "black" }}>Üsküdar/İstanbul</Card.Title>
                                                        <Card.Text style={{ color: "black" }}>
                                                            35.000 TL
                                                        </Card.Text>
                                                    </>
                                                )}
                                                {idx === 3 && (
                                                    <>
                                                        <Card.Img
                                                            className="ps-3 pe-3"
                                                            style={{ borderRadius: '1rem', height: '280px' }}
                                                            variant="top"
                                                            src="/h4.jpg"
                                                        />
                                                        <Card.Title style={{ color: "black" }}><br /> Ümitköy Metro Durağı 3dk 3+1</Card.Title>
                                                        <Card.Title style={{ color: "black" }}>Ümitköy</Card.Title>
                                                        <Card.Text style={{ color: "black" }}>
                                                            32.000 TL
                                                        </Card.Text>
                                                    </>
                                                )}
                                                {idx === 4 && (
                                                    <>
                                                        <Card.Img
                                                            className="ps-3 pe-3"
                                                            style={{ borderRadius: '1rem', height: '280px' }}
                                                            variant="top"
                                                            src="/h5.jpg"
                                                        />
                                                        <Card.Title style={{ color: "black" }}> <br /> Çayyolu Satılık Müstakil Ev</Card.Title>
                                                        <Card.Title style={{ color: "black" }}>Çayyolu/Ümitköy</Card.Title>
                                                        <Card.Text style={{ color: "black" }}>
                                                            17.000 TL
                                                        </Card.Text>
                                                    </>
                                                )}
                                                {idx === 5 && (
                                                    <>
                                                        <Card.Img
                                                            className="ps-3 pe-3"
                                                            style={{ borderRadius: '1rem', height: '280px' }}
                                                            variant="top"
                                                            src="/h6.jpg"
                                                        />
                                                        <Card.Title style={{ color: "black" }}> <br /> ATATÜRK MAHALLESİNDE 3+1</Card.Title>
                                                        <Card.Title style={{ color: "black" }}>Akyurt</Card.Title>
                                                        <Card.Text style={{ color: "black" }}>
                                                            22.000 TL
                                                        </Card.Text>
                                                    </>
                                                )}
                                                {idx === 6 && (
                                                    <>
                                                        <Card.Img
                                                            className="ps-3 pe-3"
                                                            style={{ borderRadius: '1rem', height: '280px' }}
                                                            variant="top"
                                                            src="/h7.jpg"
                                                        />
                                                        <Card.Title style={{ color: "black" }}> <br /> TÜRKKONUT DUHAKENT SİTESİ VİLLA</Card.Title>
                                                        <Card.Title style={{ color: "black" }}>Çankaya</Card.Title>
                                                        <Card.Text style={{ color: "black" }}>
                                                            18.000 TL
                                                        </Card.Text>
                                                    </>
                                                )}
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
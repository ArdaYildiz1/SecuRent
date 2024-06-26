import React from 'react';
import TopNavBar from './TopNavBar';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Carousel from 'react-bootstrap/Carousel';
import Modal from 'react-bootstrap/Modal';
import { useState } from 'react';
import TenantNavBar from './TenantNavBar';
import { useNavigate } from 'react-router-dom';
import StateOfficialNavBar from './StateOfficialNavBar';



export default function StateOfficialHouseDetails() {
    const [show, setShow] = useState(false);
    const [explanation, setExplanation] = useState("");


    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    function handlePreview() {
        navigate("/selectAgent");
    }

    let navigate = useNavigate();

    return (
        <>
            <StateOfficialNavBar></StateOfficialNavBar>
            <br />
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-8">
                        <br />
                        <Card style={{ backgroundColor: '#f1f2ed', borderRadius: "1rem", }}>
                            <br />
                            <Form>
                                <Form.Group className="ms-5 me-5 mb-3" controlId="loginPassword">
                                    <div className='d-flex justify-content-center'>
                                        <Carousel>
                                            <Carousel.Item>
                                                <img
                                                    src="/h6.jpg"
                                                    style={{ width: "auto", height: "40vh", display: "block", marginLeft: "auto", marginRight: "auto" }}
                                                    alt="First slide"
                                                />
                                            </Carousel.Item>
                                            <Carousel.Item>
                                                <img
                                                    src="/h6_1.jpg"
                                                    style={{ width: "auto", height: "40vh", display: "block", marginLeft: "auto", marginRight: "auto" }}
                                                    alt="Second slide"
                                                />
                                            </Carousel.Item>
                                            <Carousel.Item>
                                                <img
                                                    src="/h6_2.jpg"
                                                    style={{ width: "auto", height: "40vh", display: "block", marginLeft: "auto", marginRight: "auto" }}
                                                    alt="Third slide"
                                                />
                                            </Carousel.Item>
                                        </Carousel>
                                    </div>
                                    <br />

                                    <br />
                                    <Form.Label>
                                        <strong>
                                            <h2>
                                                ATATÜRK MAHALLESİNDE 3+1 MÜSTAKİL İSKANI HAZIR YAPI
                                            </h2>
                                        </strong>
                                    </Form.Label>

                                    <br />
                                    <Form.Label>
                                        <h4>
                                            Ankara / Akyurt / Atatürk Mah.
                                        </h4>
                                    </Form.Label>

                                    <br />
                                    <Form.Label>
                                        22.000 TL
                                    </Form.Label>
                                    <br />
                                    <Button className="btn-teal" onClick={handleShow}>
                                        Report Ad
                                    </Button>

                                    <Modal show={show} onHide={handleClose}>
                                        <Modal.Header closeButton>
                                            <Modal.Title>Report Ad</Modal.Title>
                                        </Modal.Header>
                                        <Modal.Body>
                                            <Form.Label>Report your complaints about the ad</Form.Label>
                                            <Form.Control
                                                as="textarea"
                                                rows={3}
                                                value={explanation}
                                                onChange={e => setExplanation(e.target.value)}
                                                placeholder="Write your complaints here..."
                                            />
                                        </Modal.Body>
                                        <Modal.Footer>
                                            <Button className="btn-velvet" onClick={handleClose}>
                                                Close
                                            </Button>
                                            <Button className="btn-teal" onClick={handleClose}>  {/* Handle report submission here */}
                                                Submit Report
                                            </Button>
                                        </Modal.Footer>
                                    </Modal>
                                </Form.Group>
                            </Form>
                        </Card>
                        <br />
                    </div>
                </div>
            </div>
            <br />
            <div className="container-fluid">
                <div className="row">
                    <div className="col-md-2"></div>
                    <div className="col-md-8">
                        <Card className="mb-3" style={{ backgroundColor: '#f1f2ed', borderRadius: '1rem' }}>
                            <div className="row">
                                <Form>
                                    <Form.Group className="ms-5 me-5 mb-3" controlId="loginPassword">
                                        <br />
                                        <Form.Group className="d-flex align-items-center">
                                            <h2>
                                                Bedirhan Özenç
                                            </h2>
                                        </Form.Group>

                                        <Form.Group className="d-flex align-items-center">
                                            <Form.Label className="d-flex justify-content-center">
                                                Tel.: 0 (541) 504 30 08
                                            </Form.Label>
                                        </Form.Group>
                                    </Form.Group>
                                </Form>
                                <br /><br />
                            </div>
                            <div className="row flex-container">
                                <div className="col-md-6 flex-container">
                                    <hr className='me-5' />
                                    <p style={{ fontSize: 13 }}>
                                        <br />
                                        Address: Çınar Cd. 19-17, Atatürk, 06750 Akyurt/Ankara
                                        <br />
                                        Ad ID: 1121591458
                                        <br />
                                        Ad Date: 06 November 2023
                                        <br />
                                        m² (Gross): 372
                                        <br />
                                        m² (Net): 130
                                        <br />
                                        Open Area Space m²: Unspecified
                                        <br />
                                        Number of Rooms: 3+1
                                        <br />
                                        Building Age: 5-10 years
                                        <br />
                                        Flat Number (Door Number): 1
                                        <br />
                                        Heating: Kombi (Doğalgaz)
                                        <br />
                                        Number of Bathroomsı: 1
                                        <br />
                                        Have a Balcony (?): Yes
                                        <br />
                                        Have a Furniture (?): No
                                        <br />
                                        In a Site (?): No
                                        <br />
                                        Site Name: Unspecified
                                        <br />
                                        Rent Amount (TL): Unspecified
                                        <br />
                                    </p>
                                </div>
                                <div className="col-md-6 justify-content-center flex-container">
                                    <p style={{ fontSize: 13, textAlign: 'center' }}>
                                        <br />
                                        <h3>
                                            Ad Details:
                                        </h3>
                                        <br />
                                        PRIME GROUP'TAN ATATÜRK MAHALLESİNDE MERKEZE YAKIN KONUMDA 3+1 MÜSTAKİL EV
                                        <br />
                                        EVİMİZ ISI YALITIMLI VE SIVA MEVCUTTUR
                                        <br />
                                        ÇATISI VE EV İÇİ YENİ YAPILMIŞTIR
                                        <br />
                                        372 M2 ARSA ÜZERİNE KURULU
                                        <br />
                                        MERKEZE YAKIN KONUMDA
                                        <br />
                                        3+1 120 M2 KULLANIM ALANINA SAHİP
                                        <br />
                                        10 M2 GENİŞ BALKONLU
                                        <br />
                                        ÇEŞİTLİ MEYVE AĞAÇLARI MEVCUT
                                        <br />
                                        KULLANIMA UYGUN TANDIR EVİ
                                        <br />
                                        KÖMÜRLÜK VE SIĞINAKLI
                                        <br />
                                        EGO VE OTOBÜS DURAĞINA YÜRÜME MESAFESİNDE
                                        <br />
                                        ORTA OKUL VE LİSE YAKINI
                                        <br />
                                        MÜSTAKİL EVİMİZİN İSKANI HAZIRDIR
                                        <br />
                                        DETAYLI BİLGİ İÇİN OFİSİMİZE BEKLERİZ
                                    </p>
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
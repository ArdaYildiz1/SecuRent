import React from 'react';
import TopNavBar from './TopNavBar';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Accordion from 'react-bootstrap/Accordion';
import { useState } from 'react';


export default function PublishAd() {
    const accordionItems = [
        { eventKey: "0", header: "Flat", choice: "House / Rent /" },
        { eventKey: "1", header: "Residence", choice: "House / Rent /" },
        { eventKey: "2", header: "Detached House", choice: "House / Rent /" },
        { eventKey: "3", header: "Villa", choice: "House / Rent /" },
        { eventKey: "4", header: "Farmhouse", choice: "House / Rent /" },
        { eventKey: "5", header: "Mansion", choice: "House / Rent /" },
        { eventKey: "6", header: "Waterside", choice: "House / Rent /" },
        { eventKey: "7", header: "Waterside Apartment", choice: "House / Rent /" },
        { eventKey: "8", header: "Summerhouse", choice: "House / Rent /" },
        // Add more items as needed
    ];

    const [accordionItem, setAccordionItem] = useState({ eventKey: "", header: "", choice: "" });

    return (
        <>
            <TopNavBar />
            <br />
            <div className="container-fluid">
                <div className="row">
                    <div className="col-md-3"></div>
                    <div className="col-md-6">
                        <br />
                        <h2 className="text-center" style={{ color: '#FEF2F4' }}>
                            Publish Ad
                        </h2>
                        <br />

                        <Card className="mb-3" style={{ backgroundColor: '#f1f2ed', borderRadius: '1rem' }}>
                            <div className="row">
                                <br />
                                <Form>
                                    <br /><br />
                                    <p className='ms-4'>
                                        Choose a category step-by-step to publish your ad:
                                    </p>
                                    <Accordion className='ms-3 me-3'>
                                        <Accordion.Item eventKey="0">
                                            <Accordion.Header>House</Accordion.Header>
                                            <Accordion.Body>
                                                <Accordion>
                                                    <Accordion.Item eventKey="0">
                                                        <Accordion.Header>For Rent</Accordion.Header>
                                                        <Accordion.Body>
                                                            <Accordion>
                                                                {accordionItems.map(item => (
                                                                    <Accordion.Item eventKey={item.eventKey} key={item.eventKey}>
                                                                        <Accordion.Header>{item.header}</Accordion.Header>
                                                                        <Accordion.Body>
                                                                            Category selection completed.
                                                                            <br />
                                                                            <br />
                                                                            <Button className="btn-teal" onClick={() => setAccordionItem(item)}>Continue</Button>
                                                                        </Accordion.Body>
                                                                    </Accordion.Item>
                                                                ))}
                                                            </Accordion>
                                                            {/* Add your content here */}
                                                        </Accordion.Body>
                                                    </Accordion.Item>
                                                    {/* <Accordion.Item eventKey="1">
                                                        <Accordion.Header>For Daily Rent</Accordion.Header>
                                                        <Accordion.Body>
                                                            <Button className="btn-teal">Completed</Button>
                                                        </Accordion.Body>
                                                    </Accordion.Item> */}
                                                    {/* Add more sub-levels as needed */}
                                                </Accordion>
                                            </Accordion.Body>
                                        </Accordion.Item>
                                        {/* Add more levels as needed */}
                                    </Accordion>
                                    <Form.Group className="ms-4 me-4 mb-3" controlId="loginPassword">
                                        <br />
                                        <Form.Group className="d-flex align-items-center">
                                            <Form.Label className="d-flex justify-content-center">{accordionItem.choice} {accordionItem.header} </Form.Label>
                                        </Form.Group>

                                        <Form.Group className="d-flex align-items-center">
                                            <Form.Label className="d-flex justify-content-center">496
                                                Evaluations</Form.Label>
                                        </Form.Group>

                                        <Form.Group className="d-flex align-items-center">
                                            <Form.Label className="d-flex justify-content-center">100
                                                Comments </Form.Label>
                                        </Form.Group>

                                        <hr />

                                        <Form.Group className="d-flex align-items-center">
                                            <Form.Label className="d-flex justify-content-center">Rate your order out of
                                                5</Form.Label>
                                        </Form.Group>
                                        <Form.Control style={{ width: '100px' }} type="number" min="1" max="5" />

                                        <hr />

                                        <div className='mb-2'>Your Comment</div>
                                        <Form.Control placeholder='You can add your comment about your order here'
                                            as="textarea" rows={3} />
                                        <br /><br />
                                        <div className='d-flex justify-content-end'>

                                            <Button className="btn-teal">
                                                Send
                                            </Button>
                                        </div>
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
import React from 'react';
import TopNavBar from './TopNavBar';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';


export default function HouseDetails() {


    return (
        <>
            <TopNavBar />
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
                                    <Card.Img
                                        className="ps-3 pe-3"
                                        style={{ borderRadius: '3rem', width: "900px", height: "100px" }}
                                        variant="top"
                                        src="https://placehold.co/900x100"
                                    />
                                    <br />

                                    <br />
                                    <Form.Label>
                                        <strong>
                                            <h2>
                                                Lorem ipsum dolor sit amet
                                            </h2>
                                        </strong>
                                    </Form.Label>

                                    <br />
                                    <Form.Label>
                                        <h4>
                                            consectetur adipiscing elit
                                        </h4>
                                    </Form.Label>

                                    <br />
                                    <Form.Label>
                                        Ut enim ad minim veniam
                                    </Form.Label>
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
                                                Lorem ipsum dolor sit amet
                                            </h2>
                                        </Form.Group>

                                        <Form.Group className="d-flex align-items-center">
                                            <Form.Label className="d-flex justify-content-center">
                                                Duis aute irure dolor in reprehenderit in
                                            </Form.Label>
                                        </Form.Group>

                                        <Form.Group className="d-flex align-items-center">
                                            <Form.Label className="d-flex justify-content-center">
                                                voluptate velit esse cillum dolore eu fugiat nulla pariatur
                                            </Form.Label>
                                        </Form.Group>

                                        <Form.Group className="d-flex align-items-center">
                                            <Form.Label className="d-flex justify-content-center">
                                                Excepteur sint occaecat cupidatat non proident
                                            </Form.Label>
                                        </Form.Group>

                                        <hr />

                                        <Form.Group className="d-flex align-items-center">
                                            <Form.Label className="d-flex justify-content-center">
                                                sunt in culpa qui officia deserunt
                                            </Form.Label>
                                        </Form.Group>
                                        <Form.Control style={{ width: '100px' }} type="number" min="1" max="5" />

                                        <hr />

                                        <div className='mb-2'>
                                            Sed cras ornare arcu dui
                                        </div>
                                        <Form.Control placeholder='Et egestas quis ipsum suspendisse ultrices'
                                            as="textarea" rows={3} />
                                        <br /><br />
                                        <div className="d-flex justify-content-end me-5">
                                            <Button className="btn-teal">
                                                Preview
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
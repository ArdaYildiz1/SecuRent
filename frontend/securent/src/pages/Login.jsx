import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Card from 'react-bootstrap/Card';
import {useNavigate} from "react-router-dom";
// import {useState} from 'react';
// import axios from 'axios';

export default function Login() {

    let navigate = useNavigate();

    function handleClickLogin() {
        navigate("/rentedHouse");
    }

    function handleForgotPassword() {
        navigate("/forgotPassword");
    }
    
    function handlesignup() {
        navigate("/signup");
    }

    return (
        <div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-8 text-center">
                        <br/>
                        <img
                            src="/sr_logo.png"
                            width="180rem"
                            height="180rem"
                            className="d-inline-block align-top"
                            alt="app logo"
                        />
                        <br/><br/>
                        <h1 style={{color: "#FEF2F4"}}> Welcome to SecuRent</h1>
                        <br/>
                        <h2 style={{color: "#FEF2F4"}}>Please Log In</h2>
                        <div class="row">
                            <div class="col-md-3">
                            </div>
                            <div class="col-md-6">
                                <Card style={{backgroundColor: "#f1f2ed", borderRadius: "1rem",}}>
                                    <Form className='text-center'>
                                        <Form.Group className="ms-5 me-5 mb-3" controlId="loginEmail">
                                            <br/>
                                            <Form.Label>Email address</Form.Label>
                                            <Form.Control type="email"
                                                          placeholder="Enter email"/>
                                            <Form.Text className="text-muted">
                                                Login via your e-mail
                                            </Form.Text>
                                        </Form.Group>

                                        <Form.Group className="ms-5 me-5 mb-3" controlId="loginPassword">
                                            <Form.Label>Password</Form.Label>
                                            <Form.Control type="password" 
                                                          placeholder="Password"/>
                                        </Form.Group>
                                        <br/>
                                        <Button className="btn-teal" onClick={handleClickLogin} type="submit">
                                            Login
                                        </Button>
                                        <br/><br/>
                                        <href onClick={handleForgotPassword} class="link-primary">Forgot Your
                                            Password?
                                        </href>
                                        <br/>---<br/>
                                        <href onClick={handlesignup} class="link-secondary">Sign Up</href>
                                        <br/><br/>
                                    </Form>
                                </Card>
                                <br/><br/><br/><br/><br/><br/><br/><br/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}
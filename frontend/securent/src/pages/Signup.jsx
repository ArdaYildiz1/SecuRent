import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Card from 'react-bootstrap/Card';
import axios from 'axios';
import { useNavigate } from "react-router-dom";

export default function Signup() {
    const navigate = useNavigate();

    // Define the data to send in the request body
    const [formData, setFormData] = useState({
        firstName: '',
        lastName: '',
        password: '',
        emailAddress: '',
        phoneNo: 1,
        role: '', 
        tck: 1 
    });

    

    function handleChange(event) {
        const { name, value } = event.target;
        setFormData(prevState => ({
            ...prevState,
            [name]: value
        }));
    }

    function handleSubmit(event) {
        event.preventDefault();
        // console.log(formData);
        axios.post('http://52.59.214.208:8080/auth/signup', {
            firstName: formData.first_name,
            lastName: formData.last_name,
            password: formData.password,
            emailAddress: formData.email_address,
            phoneNo: formData.phone_no,
            role: formData.userType,
            tck: formData.tck,
        })
            .then(response => {
                // Handle the response
                console.log('Response:', response.data);
            })
            .catch(error => {
                // Handle errors
                console.error('Error:', error.response.data);
            });


    }



    function handleClickBack() {
        navigate("/");
    }

    return (
        <div>
            <div className="container-fluid">
                <div className="row">
                    <div className="col-md-2">
                        <img
                            className="mt-4 ms-3"
                            src="/sr_logo.png"
                            width="70rem"
                            height="70rem"
                            alt="app logo"
                        />
                    </div>
                    <div className="col-md-8 text-center">
                        <br />
                        <br /><br />
                        <h2 style={{ color: "#FEF2F4" }}>Sign Up</h2>
                        <div className="row">
                            <div className="col-md-2">
                            </div>
                            <div className="col-md-8">
                                <Card style={{ backgroundColor: "#f1f2ed", borderRadius: "1rem", }}>
                                    <Form className='text-center' onSubmit={handleSubmit}>
                                        <br /><br />
                                        {['radio'].map((type) => (
                                            <div key={`inline-${type}`} className="mb-3">
                                                <Form.Check
                                                    inline
                                                    label="Tenant"
                                                    name="userType"
                                                    type={type}
                                                    id={`inline-${type}-1`}
                                                    value="TENANT"
                                                    onChange={handleChange}

                                                />
                                                <Form.Check
                                                    inline
                                                    label="Landlord"
                                                    name="userType"
                                                    type={type}
                                                    id={`inline-${type}-2`}
                                                    value="LANDLORD"
                                                    onChange={handleChange}

                                                />
                                                <Form.Check
                                                    inline
                                                    label="Real Estate"
                                                    name="userType"
                                                    type={type}
                                                    id={`inline-${type}-3`}
                                                    value="REAL_ESTATE_AGENT"
                                                    onChange={handleChange}

                                                />
                                            </div>
                                        ))}
                                        <Form.Group className="ms-5 me-5 mb-3" controlId="loginEmail">
                                            <br />
                                            <Form.Label>
                                                <strong>
                                                    Account Information
                                                </strong>
                                            </Form.Label>
                                            <Form.Control type="text" placeholder="Name" name="first_name" onChange={handleChange} />
                                            <Form.Control className='mt-3' type="text" placeholder="last_name" name="last_name" onChange={handleChange} />
                                            <Form.Control className='mt-3' type="text" placeholder="Phone Number" name="phone_no" onChange={handleChange} />
                                            <Form.Control className='mt-3' type="text" placeholder="TCK No." name="tck" onChange={handleChange} />
                                        </Form.Group>
                                        <br />
                                        <Form.Group className="ms-5 me-5 mb-3" controlId="loginEmail">
                                            <Form.Label>E-mail</Form.Label>
                                            <Form.Control type="email" placeholder="Enter email" name="email_address" onChange={handleChange} />
                                        </Form.Group>
                                        <br />
                                        <Form.Group className="ms-5 me-5 mb-3" controlId="loginPassword">
                                            <Form.Label>Password</Form.Label>
                                            <Form.Control type="password" placeholder="Enter Password" name="password" onChange={handleChange} />
                                        </Form.Group>
                                        <br /><br />
                                        <Button className="btn-teal" onClick={handleSubmit} type="submit">
                                            Sign Up
                                        </Button>
                                        <br />---<br />
                                        <Button className="btn-velvet" onClick={handleClickBack} type="button">
                                            Back
                                        </Button>
                                        <br /><br /><br />
                                    </Form>
                                </Card>
                                <br /><br /><br /><br /><br /><br /><br /><br />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

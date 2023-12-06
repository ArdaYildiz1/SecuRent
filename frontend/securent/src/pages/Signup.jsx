import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Card from 'react-bootstrap/Card';
import { useNavigate } from "react-router-dom";


export default function Signup() {
    let navigate = useNavigate();

    function handleClickBack() {
        navigate("/");
    }

    function handleClickSignup() {
        navigate("/");
    }

    return (
        <div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-2">
                        <img
                            class="mt-4 ms-3"
                            src="/sr_logo.png"
                            width="70rem"
                            height="70rem"
                            alt="app logo"
                        />
                    </div>
                    <div class="col-md-8 text-center">
                        <br />
                        <br /><br />
                        <h2 style={{ color: "#FEF2F4" }}>Sign Up</h2>
                        <div class="row">
                            <div class="col-md-2">
                            </div>
                            <div class="col-md-8">
                                <Card style={{ backgroundColor: "#f1f2ed", borderRadius: "1rem", }}>
                                    <Form className='text-center'>
                                        <br /><br />
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
                                            </div>
                                        ))}
                                        <Form.Group className="ms-5 me-5 mb-3" controlId="loginEmail">
                                            <br />
                                            <Form.Label>
                                                <strong>
                                                    Account Information
                                                </strong>
                                            </Form.Label>
                                            <Form.Control type="text" placeholder="Name" />
                                            <Form.Control className='mt-3' type="text" placeholder="Surname" />
                                            <Form.Control className='mt-3' type="text" placeholder="Phone Number" />
                                            <Form.Control className='mt-3' type="text"
                                                placeholder="Birth Date (mm/dd/yyyy)" />
                                        </Form.Group>
                                        <br />
                                        <Form.Group className="ms-5 me-5 mb-3" controlId="loginPassword">
                                            <Form.Label>E-mail</Form.Label>
                                            <Form.Control type="email"
                                                placeholder="Enter email" />
                                        </Form.Group>

                                        <br />
                                        <Form.Group className="ms-5 me-5 mb-3" controlId="loginPassword">
                                            <Form.Label>Password</Form.Label>
                                            <Form.Control type="password"
                                                placeholder="Enter Password" />
                                            <Form.Control className='mt-3' type="text" placeholder="Confirm Password" />
                                        </Form.Group>

                                        <br /><br />
                                        <Button className="btn-teal" onClick={handleClickSignup} type="submit">
                                            Sign Up
                                        </Button>
                                        <br />---<br />
                                        <Button className="btn-velvet" onClick={handleClickBack} type="submit">
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
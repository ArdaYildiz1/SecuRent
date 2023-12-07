import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Card from 'react-bootstrap/Card';
import {useNavigate} from "react-router-dom";

export default function ForgotPassword() {
    // const [emailInput, setEmailInput] = useState("");
    // const [passwordInput, setPasswordInput] = useState("");

    let navigate = useNavigate();

    function handleClickBack() {
        navigate("/");
    }

    function handleClickLogin() {
        navigate("/home");
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
                        <div class="row">
                            <div class="col-md-3">
                            </div>
                            <div class="col-md-6">
                                <Card style={{backgroundColor: "#f1f2ed", borderRadius: "1rem",}}>
                                    <Form className='text-center'>
                                        <Form.Group className="ms-5 me-5 mb-3" controlId="loginEmail">
                                            <br/>
                                            <Form.Label>Email address</Form.Label>
                                            <Form.Control type="email" placeholder="Enter email"/>
                                            <Form.Text className="text-muted">
                                                Enter your email to receive new password
                                            </Form.Text>
                                        </Form.Group>

                                        <Form.Group className="ms-5 me-5 mb-3" controlId="loginPassword">
                                            <Form.Label>Password</Form.Label>
                                            <Form.Control type="password" placeholder="New Password"/>
                                            <Form.Text className="text-muted">
                                                Enter the password in the mail sent
                                            </Form.Text>
                                        </Form.Group>
                                        <br/>
                                        <Button className="btn-teal" onClick={handleClickLogin} type="submit">
                                            Login
                                        </Button>

                                        <br/><br/>
                                        <Form.Group className="ms-5 me-5 mb-3" controlId="loginPassword">
                                            <Form.Text className='text-muted'>Didn't receive the email?</Form.Text>
                                            <Button className="btn-teal ms-4" type="submit">
                                                Resend
                                            </Button>
                                        </Form.Group>
                                        <br/>---<br/>
                                        <Button className="btn-velvet" onClick={handleClickBack} type="submit">
                                            Back
                                        </Button>

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
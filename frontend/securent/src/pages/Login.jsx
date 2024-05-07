import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Card from "react-bootstrap/Card";
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import axios from "axios";

export default function Login() {
  const [formData, setFormData] = useState({
    password: "",
    emailAddress: "",
  });
  
  function handleChange(event) {
    const { name, value } = event.target;
    setFormData((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  }

  let navigate = useNavigate();

  function handleClickLogin() {
    axios
      .get("http://localhost:8080/auth/login")
      .then((response) => {
        // Handle the response
        console.log("Response:", response.data);
      })
      .catch((error) => {
        // Handle errors
        console.error("Error:", error.response.data);
      });
  }

  function handleForgotPassword() {
    navigate("/forgotPassword");
  }

  function handlesignup() {
    navigate("/signup");
  }

  return (
    <div>
      <div className="container-fluid">
        <div className="row">
          <div className="col-md-2"></div>
          <div className="col-md-8 text-center">
            <br />
            <img
              src="/sr_logo.png"
              width="180rem"
              height="180rem"
              className="d-inline-block align-top"
              alt="app logo"
            />
            <br />
            <br />
            <h1 style={{ color: "#FEF2F4" }}> Welcome to SecuRent</h1>
            <br />
            <h2 style={{ color: "#FEF2F4" }}>Please Log In</h2>
            <div className="row">
              <div className="col-md-3"></div>
              <div className="col-md-6">
                <Card
                  style={{ backgroundColor: "#f1f2ed", borderRadius: "1rem" }}
                >
                  <Form className="text-center" onSubmit={handleClickLogin}>
                    <Form.Group
                      className="ms-5 me-5 mb-3"
                      controlId="loginEmail"
                    >
                      <br />
                      <Form.Label>Email address</Form.Label>
                      <Form.Control type="email" placeholder="Enter email"  name="email_address" onChange={handleChange} />
                      <Form.Text className="text-muted">
                        Login via your e-mail
                      </Form.Text>
                    </Form.Group>
                    <Form.Group
                      className="ms-5 me-5 mb-3"
                      controlId="loginPassword"
                    >
                      <Form.Label>Password</Form.Label>
                      <Form.Control type="password" placeholder="Password" name="password" onChange={handleChange} />
                    </Form.Group>
                    <br />
                    <Button
                      className="btn-teal"
                      onClick={handleClickLogin}
                      type="submit"
                    >
                      Login
                    </Button>
                    <br />
                    <br />
                    <href onClick={handleForgotPassword} className="link-primary">
                      Forgot Your Password?
                    </href>
                    <br />
                    ---
                    <br />
                    <href onClick={handlesignup} className="link-secondary">
                      Sign Up
                    </href>
                    <br />
                    <br />
                  </Form>
                </Card>
                <br />
                <br />
                <br />
                <br />
                <br />
                <br />
                <br />
                <br />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

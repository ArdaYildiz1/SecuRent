import React from "react";
import { Link } from "react-router-dom";
import Card from "react-bootstrap/Card";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import Button from "react-bootstrap/Button";
import TopNavBar from "./TopNavBar";
import FilterComponent from "./FilterComponent";
import TenantNavBar from "./TenantNavBar";
import { useLocation } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import axios from "axios";

export default function HomePage() {
  const location = useLocation();

  let navigate = useNavigate();

  const houses = Object.values(location.state);


  function navigateHouse(idx) {
    axios
      .get(`http://localhost:8080/houses/${houses[idx].houseId}`)
      .then((response) => {
        navigate("/houseDetails", { state: { ...response.data } });
      })
      .catch((error) => {
        console.error("Error fetching house details:", error);
      });
  }

  return (
    <>
      <TenantNavBar></TenantNavBar>
      <br />
      <div className="row">
        <div className="col-md-2"></div>
        <div className="col-md-8">
          <FilterComponent />
          <br />
          <br />
          <Row xs={1} md={3} className="g-4">
            <>
              {Array.from({ length: houses.length }).map((_, idx) => (
                <Col key={idx}>
                  <Link
                    to={`/houseDetails`}
                    onClick={() => navigateHouse(idx)}
                    style={{ textDecoration: "none" }}
                  >
                    <Card
                      className="clickable-card"
                      style={{
                        backgroundColor: "#f1f2ed",
                        borderRadius: "2rem",
                      }}
                    >
                      <br />
                      <Card.Body>
                        <>
                          <Card.Img
                            className="ps-3 pe-3"
                            style={{ borderRadius: "1rem", height: "280px" }}
                            variant="top"
                            src="/h1.jpg"
                          />
                          <Card.Title style={{ color: "black" }}>
                            <br /> {houses[idx].siteName}
                          </Card.Title>
                          <Card.Title style={{ color: "black" }}>
                            {houses[idx].address}
                          </Card.Title>
                          <Card.Text style={{ color: "black" }}>
                            {houses[idx].currentAmount} TL
                          </Card.Text>
                        </>

                        <Button
                          style={{ width: "150px", height: "50px" }}
                          className="btn-teal"
                          type="submit"
                        >
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
      <br />
      <br />
      <br />
    </>
  );
}

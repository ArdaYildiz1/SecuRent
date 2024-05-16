import Button from 'react-bootstrap/esm/Button';
import React, { useEffect, useRef, useState } from 'react';
import pp from './defaultPP.jpg';
import TopNavBar from './TopNavBar';
import { Card, Col, Form, Row } from 'react-bootstrap';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import RealEstateAgentNavBar from './RealEstateAgentNavBar';
import axios from "axios";

function RealEstateAgentHouseConditionList() {
    
    const location = useLocation();
    const houseCondition = Object.values(location.state || {});
    const [tenants, setTenants] = useState([]);
    let navigate = useNavigate();
   


    function navigateHouse(idx) {
        axios
          .get(`http://52.59.214.208:8080/houses/${idx}`)
          .then((response) => {
  
            navigate("/realEstateAgentHouseDetails", { state: { ...response.data } });
          })
          .catch((error) => {
            console.error("Error fetching house details:", error);
          });
      }
  
    useEffect(() => {
        if (tenants.length === 0) {
          houseCondition.forEach((notification, idx) => {
            getTenantNameById(idx);
          });
        }
      }, [houseCondition]);
  
       function getTenantNameById(idx) {
          axios
            .get(`http://52.59.214.208:8080/tenants/${houseCondition[idx].tenantID}`)
            .then((response) => {
              const newTenant = response.data.firstName;
              // Update tenants state and save to local storage
              setTenants((prevTenants) => {
                const updatedTenants = [...prevTenants, newTenant];
                return updatedTenants;
              });
  
            })
            .catch((error) => {
              console.error("Error fetching tenant:", error);
            });
        }



    const dynamicData = ['Ahmet Kalem', 'Fatih Kor', 'Ali Tarık', 'Kasım Kale', 'Fatih Kor', 'Ali Tarık', 'Ahmet Kalem', 'Fatih Kor', 'Ali Tarık', 'Mehmet Ersoy', 'Fatih Kor', 'Ali Tarık', 'Mehmet Ersoy', 'Fatih Kor', 'Ali Tarık', 'Mehmet Ersoy'];

    const DynamicList = ({ data }) => {
        return (
            <>

                <div className="row">
                    <div className="col-md-2"></div>
                    <div className="col-md-8">
                        <Row xs={1} md={3} className="g-4">
                            <>
                                {Array.from({ length: houseCondition.length }).map((_, idx) => (
                                    <Col key={idx}>
                                        <div  style={{ textDecoration: 'none' }}>
                                            <Card
                                                className="clickable-card"
                                                style={{ backgroundColor: '#f1f2ed', borderRadius: '2rem' }}
                                                onClick={() => navigateHouse(6)}
                                            >
                                                <br />

                                                <Card.Img
                                                    className="ps-3 pe-3"
                                                    style={{ borderRadius: '1rem' }}
                                                    variant="top"
                                                    src={pp}
                                                />
                                                <Card.Body>
                                                    <Card.Title style={{ color: "black" }}>{tenants[idx]}</Card.Title>
                                                    <Card.Text style={{ color: "black" }}>
                                                    {tenants[idx]} wants you to upload a house condition report. Click to see the house to be examined.

                                                    </Card.Text>


                                                    <div style={{ display: 'flex', flexDirection: 'row', alignItems:'center' }}>
                                                        <Button style={{ width: '150px', height: '50px' }} className="btn-teal"
                                                            type="submit"
                                                            >
                                                            Upload Report
                                                        </Button>
                                                        
                                                    </div>

                                                    <br />
                                                </Card.Body>
                                            </Card>
                                        </div>
                                    </Col>
                                ))}
                            </>

                        </Row>
                    </div>
                    <div className="col-md-2"></div>
                </div>
            </>
        );
    };

    return (
        <>
            <RealEstateAgentNavBar />

            <div style={{ width: '100%', height: '100vh', overflowY: 'auto' }}>

                <div style={{ display: 'flex', justifyContent: 'center', paddingTop: '2%', paddingBottom: '2%' }}>
                    <h1 style={{ color: "white" }}>
                        House Condition Check Upload Report
                    </h1>
                </div>

                <div style={{ width: '100%', height: '100vh', }}>
                    <DynamicList data={dynamicData} />
                </div>
            </div>
        </>

    );
}

export default RealEstateAgentHouseConditionList;
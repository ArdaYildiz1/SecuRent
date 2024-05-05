import Button from 'react-bootstrap/esm/Button';
import React, { useEffect, useState } from 'react';
import pp from './defaultPP.jpg';
import TopNavBar from './TopNavBar';
import { Card, Col, Form, Row } from 'react-bootstrap';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import LandlordNavBar from './LandlordNavBar';
import axios from "axios";

function LandlordCurrentRequest() {

    const location = useLocation();
    const currentRequests = Object.values(location.state || {});
    const [tenants, setTenants] = useState([]);
    const [realEstateAgents, setRealEstateAgents] = useState([]);
    let navigate = useNavigate();

    useEffect(() => {
        // Only fetch if tenants array is empty to avoid unnecessary requests
        if (tenants.length === 0) {
            currentRequests.forEach((notification, idx) => {
            getTenantNameById(idx);
          });
        }
      }, [currentRequests]); // Dependency array to avoid infinite loop
    
      useEffect(() => {
        // Only fetch if tenants array is empty to avoid unnecessary requests
        if (realEstateAgents.length === 0) {
            currentRequests.forEach((notification, idx) => {
            getRealEstateAgentNameById(idx);
          });
        }
      }, [currentRequests]); // Dependency array to avoid infinite loop
    
      function getTenantNameById(idx) {
        axios
          .get(`http://localhost:8080/tenants/${currentRequests[idx].tenantID}`)
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

      function getRealEstateAgentNameById(idx) {
        axios
          .get(`http://localhost:8080/real-estate-agents/${currentRequests[idx].realEstateAgentId}`)
          .then((response) => {
            const newRealEstateAgent = response.data.firstName;
            // Update real estate agent state and save to local storage
            setRealEstateAgents((prevRealEstateAgents) => {
              const updatedRealEstateAgents = [...prevRealEstateAgents, newRealEstateAgent];
              return updatedRealEstateAgents;
            });
          })
          .catch((error) => {
            console.error("Error fetching real estate agent:", error);
          });
      }









    const dynamicData = ['Ahmet Kalem', 'Fatih Kor', 'Ali Tarık', 'Kasım Kale', 'Fatih Kor', 'Ali Tarık', 'Ahmet Kalem', 'Fatih Kor', 'Ali Tarık', 'Mehmet Ersoy', 'Fatih Kor', 'Ali Tarık', 'Mehmet Ersoy', 'Fatih Kor', 'Ali Tarık', 'Mehmet Ersoy'];
    const realEstateAgent = ['Real Estate Agent'];

    const handleFileChange = (event) => {
        const file = event.target.files[0];
        // handle the file here
    };
    function handleSeeProfiles() {
        navigate("/seeTenantAndRealEstateAgent");
    }


    const DynamicList = ({ data, realEstateAgent }) => {
        return (
            <>

                <div className="row">
                    <div className="col-md-2"></div>
                    <div className="col-md-8">
                        <Row xs={1} md={3} className="g-4">
                            <>
                                {Array.from({ length: currentRequests.length }).map((_, idx) => (
                                    <Col key={idx}>
                                        {/* burayı belki bir profile yönlendiririz   to={`/houseDetails`}*/}
                                        <div>
                                            <Card
                                                className="clickable-card"
                                                style={{ backgroundColor: '#f1f2ed', borderRadius: '2rem' }}
                                            >
                                                <br />
                                                <div style={{ display: 'flex', flexDirection: 'row', justifyContent: 'center', marginBottom: 30 }}>
                                                    <div style={{ display: 'flex', flexDirection: 'column', justifyContent: 'center', alignItems: 'center' }}>
                                                        <h4>Tenant</h4>
                                                        <Card.Img
                                                            style={{ borderRadius: '1rem', width: '120px', height: '120px' }}
                                                            variant="top"
                                                            src={pp}
                                                        />
                                                    </div>
                                                    <div style={{ display: 'flex', flexDirection: 'column', justifyContent: 'center', alignItems: 'center' }}>
                                                        <h4 >Real Estate</h4>

                                                        <Card.Img

                                                            style={{ borderRadius: '1rem', width: '120px', height: '120px', marginLeft: 10 }}
                                                            variant="top"
                                                            src={pp}
                                                        />
                                                    </div>

                                                </div>
                                                <Card.Body>
                                                    <Card.Title style={{ color: "black" }}>{tenants[idx]}</Card.Title>
                                                    <Card.Text style={{ color: "black" }}>
                                                        {tenants[idx]} requested to see your house with {realEstateAgents[idx]}.
                                                    </Card.Text>

                                                    <div style={{ display: 'flex', flexDirection: 'row', justifyContent: 'center' }}>

                                                        <Button style={{ width: '150px', height: '60px' }} className="btn-teal"
                                                            type="submit"
                                                            onClick={handleSeeProfiles}>
                                                            See Profiles
                                                        </Button>

                                                        <Button style={{ width: '150px', height: '60px' }} className="btn-teal"
                                                            type="submit">
                                                            End Operation
                                                        </Button>
                                                        <input
                                                            type="file"
                                                            id="fileInput"
                                                            style={{ display: 'none' }}
                                                            onChange={handleFileChange}
                                                        />

                                                        <Button style={{ width: '150px', height: '60px' }} className="btn-teal"
                                                            onClick={() => document.getElementById('fileInput').click()}
                                                            type="button">
                                                            Upload Contract
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
            <LandlordNavBar />

            <div style={{ width: '100%', height: '100vh', overflowY: 'auto' }}>

                <div style={{ display: 'flex', justifyContent: 'center', paddingTop: '2%', paddingBottom: '2%' }}>
                    <h1 style={{ color: "white" }}>
                        Current Requests
                    </h1>
                </div>

                <div style={{ width: '100%', height: '100vh', }}>
                    <DynamicList data={dynamicData} realEstateAgent={realEstateAgent} />
                </div>
            </div>
        </>

    );
}

export default LandlordCurrentRequest;
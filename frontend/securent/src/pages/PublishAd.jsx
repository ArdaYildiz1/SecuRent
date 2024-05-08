import React from "react";
import TopNavBar from "./TopNavBar";
import Card from "react-bootstrap/Card";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Accordion from "react-bootstrap/Accordion";
import { useState } from "react";
import InputGroup from "react-bootstrap/InputGroup";
import DatePicker from "react-datepicker";
import LandlordNavBar from "./LandlordNavBar";
import { useLocation } from "react-router-dom";
import axios from "axios"; // Import axios

export default function PublishAd() {
  const location = useLocation();
  console.log(location.state)

  const accordionItems = [
    { eventKey: "0", header: "FLAT", choice: "House > Rent >" },
    { eventKey: "1", header: "RESIDENCE", choice: "House > Rent >" },
    { eventKey: "2", header: "DETACHED_HOUSE", choice: "House > Rent >" },
    { eventKey: "3", header: "VILLA", choice: "House > Rent >" },
    { eventKey: "4", header: "FARMHOUSE", choice: "House > Rent >" },
    { eventKey: "5", header: "MANSION", choice: "House > Rent >" },
    { eventKey: "6", header: "WATERSIDE", choice: "House > Rent >" },
    { eventKey: "7", header: "WATERSIDE_APARTMENT", choice: "House > Rent >" },
    { eventKey: "8", header: "SUMMERHOUSE", choice: "House > Rent >" },
    // Add more items as needed
  ];

  const [accordionItem, setAccordionItem] = useState({
    eventKey: "",
    header: "",
    choice: "",
  });
  const [startDate, setStartDate] = useState(new Date());
  const [file, setFile] = useState(null);
  const [houseId, setHouseId] = useState(0); // Initialize with a default value
  const handleFileChange = (event) => {
    setFile(event.target.files[0]);
  };
  //TODO filterlar hopepageden çıkacak
  //TODO rental ad ve house arasındaki fark tam olarak ne 
  // Define the data to send in the request body
  const [ad, setAd] = useState({
    landlordId: 1, // Replace with the actual landlord ID
    landlordName: "", // Update with the landlord name
    landlordPhoneNumber: "", // Update with the landlord phone number
    houseType: "", // Update with the selected house type
    adTitle: "Ad Title", // Update with the ad title
    adDetails: "Ad Description", // Update with the ad description
    rentPrice: 1000, // Update with the ad price
    address: "Ad Address", // Update with the ad address
    adDate: startDate,
    areaGross: 100.0, // Update with the gross area
    areaNet: 80.0, // Update with the net area
    areaOpenSpace: 20.0, // Update with the open space area
    numberOfRooms: 3, // Update with the number of rooms
    buildingAge: 5, // Update with the building age
    flatNumber: 10, // Update with the flat number
    heating: "GAS_HEATING", // Update with the heating type
    numberOfBathrooms: 2, // Update with the number of bathrooms
    haveBalcony: true, // Update based on whether there is a balcony
    haveFurniture: true, // Update based on whether there is furniture
    inASite: false, // Update based on whether it's in a site
    siteName: "Site Name", // Update with the site name
  });

  function handleChange(event) {
    const { name, value } = event.target;
    setAd((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  }

  let headerSetter = (item) => {
    ad.houseType = item.header;
  };

  // Bu fonksiyonu foto yükleme için yazdım isme takılma, çalışıyor
  //   const handlePublishAd = async () => {
  //     const formData = new FormData();
  //     formData.append('file', file);
  //     formData.append('houseId', houseId);

  //     try {
  //         await axios.post('http://localhost:8080/house-photos/upload', formData);
  //         alert('Photo uploaded successfully');
  //     } catch (error) {
  //         alert('Photo uploaded successfully');
  //     }
  // };

  // Bu fonksiyonu fonksiyonu submit edip rental ad'i database'e kaydetmek için yazmaya başaldım
  function handleSubmit(event) {
    event.preventDefault();
    console.log(ad);
    axios
      .post(
        `http://localhost:8080/houses`,
        {
          landlordId: location.state.entityId,
          landlordName: location.state.firstName,
          landlordPhoneNumber: location.state.phoneNo,
          siteName: ad.houseType,
          adTitle: ad.title,
          adDetails: ad.description,
          rentPrice: ad.price,
          adDate: startDate,
          address: ad.address,
          areaGross: ad.areaGross,
          areaNet: ad.areaNet,
          areaOpenSpace: ad.areaOpenSpace,
          numberOfRooms: ad.numberOfRooms,
          buildingAge: ad.buildingAge,
          flatNumber: ad.flatNumber,
          heating: ad.heating,
          numberOfBathrooms: ad.numberOfBathrooms,
          haveBalcony: true,
          haveFurniture: true,
          inASite: false,
        }
      )
      .then((response) => {
        // Handle the response
        console.log("Response:", response.data);
      })
      .catch((error) => {
        // Handle errors
        console.error("Error:", error.response.data);
      });

    // Promise.all([
    //   post(
    //     `http://localhost:8080/landlords/${ad.landlordId}/publish-rental-ad`,
    //     {
    //       landlordId: location.state.entityId,
    //       houseType: ad.houseType,
    //       title: ad.title,
    //       description: ad.description,
    //       price: ad.price,
    //       adDate: startDate,
    //       address: ad.address,
    //       areaGross: ad.areaGross,
    //       areaNet: ad.areaNet,
    //       areaOpenSpace: ad.areaOpenSpace,
    //       numberOfRooms: ad.numberOfRooms,
    //       buildingAge: ad.buildingAge,
    //       flatNumber: ad.flatNumber,
    //       heating: ad.heating,
    //       numberOfBathrooms: ad.numberOfBathrooms,
    //       haveBalcony: false,
    //       haveFurniture: false,
    //       inASite: true,
    //       siteName: ad.siteName,
    //     }
    //   ),
    //   axios.post(`http://localhost:8080/houses`, {}),
    // ])
    //   .then(([realEstateAgentResponse, tenantResponse]) => {
    //     const newRealEstateAgent = realEstateAgentResponse.data;
    //     const newTenant = tenantResponse.data;
    //   })
    //   .catch((error) => {
    //     console.error("Error fetching data:", error);
    //   });
  }

  return (
    <>
      <LandlordNavBar />
      <br />
      <div className="container-fluid">
        <div className="row">
          <div className="col-md-3"></div>
          <div className="col-md-6">
            <br />
            <h2 className="text-center" style={{ color: "#FEF2F4" }}>
              Publish Ad
            </h2>
            <br />

            <Card
              className="mb-3"
              style={{ backgroundColor: "#f1f2ed", borderRadius: "1rem" }}
            >
              <div className="row">
                <br />
                <Form>
                  <br />
                  <br />
                  <p className="ms-4">
                    Choose a category step-by-step to publish your ad:
                  </p>
                  <Accordion className="ms-3 me-3">
                    <Accordion.Item eventKey="0">
                      <Accordion.Header>House</Accordion.Header>
                      <Accordion.Body>
                        <Accordion>
                          <Accordion.Item eventKey="0">
                            <Accordion.Header>For Rent</Accordion.Header>
                            <Accordion.Body>
                              <Accordion>
                                {accordionItems.map((item) => (
                                  <Accordion.Item
                                    eventKey={item.eventKey}
                                    key={item.eventKey}
                                  >
                                    <Accordion.Header>
                                      {item.header}
                                    </Accordion.Header>
                                    <Accordion.Body>
                                      Category selection completed.
                                      <br />
                                      <br />
                                      <Button
                                        className="btn-teal"
                                        onClick={() => setAccordionItem(item)}
                                      >
                                        Continue
                                      </Button>
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
                  <Form.Group
                    className="ms-4 me-4 mb-3"
                    controlId="loginPassword"
                  >
                    <br />
                    <Form.Group className="d-flex align-items-center">
                      <Form.Label className="d-flex justify-content-center">
                        {accordionItem.choice} {accordionItem.header}{" "}
                        {headerSetter(accordionItem)}
                      </Form.Label>
                    </Form.Group>
                  </Form.Group>
                </Form>
                <br />
                <br />
              </div>
            </Card>
            <br />
            <h2 className="text-center" style={{ color: "#FEF2F4" }}>
              Ad Details
            </h2>
            <br />

            <Card
              className="mb-3"
              style={{ backgroundColor: "#f1f2ed", borderRadius: "1rem" }}
            >
              <div className="row">
                <br />
                <Form>
                  <Form.Group
                    className="ms-4 me-4 mb-3"
                    controlId="loginPassword"
                  >
                    <br />
                    <div className="mb-2">Ad title:</div>
                    <Form.Control
                      type="text"
                      name="title"
                      onChange={handleChange}
                    />
                    <br />
                    <div className="mb-2">Description:</div>
                    <Form.Control
                      type="text"
                      name="description"
                      onChange={handleChange}
                      as="textarea"
                      rows={3}
                    />
                    <br />
                    <div className="mb-2">Price:</div>
                    <InputGroup style={{ width: "10vw" }} className="mb-3">
                      <Form.Control
                        type="number"
                        name="price"
                        onChange={handleChange}
                        min={0}
                      />
                      <InputGroup.Text>TL</InputGroup.Text>
                    </InputGroup>
                    <hr />
                    <div className="mb-2">Address</div>
                    <Form.Control
                      type="text"
                      name="address"
                      onChange={handleChange}
                      defaultValue={"Unspecified"}
                    />
                    <br />
                    {/* <div className="mb-2">Ad ID</div>
                    <Form.Control
                      style={{ width: "10vw" }}
                      min={0}
                      type="number"
                    />
                    <br /> */}
                    <br />
                    <div className="mb-2" onChange={handleChange}>
                      Ad Date
                    </div>
                    <DatePicker
                      selected={startDate}
                      onChange={(date) => setStartDate(date)}
                    />
                    <br />
                    <br />
                    <div className="mb-2">m² (Gross)</div>
                    <Form.Control
                      style={{ width: "10vw" }}
                      min={0}
                      type="number"
                      name="areaGross"
                      onChange={handleChange}
                    />
                    <br />
                    <div className="mb-2">m² (Net)</div>
                    <Form.Control
                      style={{ width: "10vw" }}
                      min={0}
                      type="number"
                      name="areaNet"
                      onChange={handleChange}
                    />
                    <br />
                    <div className="mb-2">Open Area Space m²</div>
                    <Form.Control
                      style={{ width: "10vw" }}
                      min={0}
                      defaultValue="Unspecified"
                      type="number"
                      name="areaOpenSpace"
                      onChange={handleChange}
                    />
                    <br />
                    <div className="mb-2">Number of Rooms</div>
                    <Form.Control
                      style={{ width: "10vw" }}
                      min={0}
                      type="number"
                      name="numberOfRooms"
                      onChange={handleChange}
                    />
                    <br />
                    <div className="mb-2">Building Age</div>
                    <InputGroup style={{ width: "10vw" }} className="mb-3">
                      <Form.Control
                        min={0}
                        type="number"
                        name="buildingAge"
                        onChange={handleChange}
                      />
                      <InputGroup.Text>years</InputGroup.Text>
                    </InputGroup>
                    <br />
                    <div className="mb-2">Flat Number (Door Number)</div>
                    <Form.Control
                      style={{ width: "10vw" }}
                      min={0}
                      type="number"
                      name="flatNumber"
                      onChange={handleChange}
                    />
                    <br />
                    <div className="mb-2">Heating</div>
                    <Form.Control
                      style={{ width: "10vw" }}
                      type="text"
                      name="heating"
                      onChange={handleChange}
                      defaultValue={"GAS_HEATING"}
                    />
                    <br />
                    <div className="mb-2">Number of Bathrooms</div>
                    <Form.Control
                      style={{ width: "10vw" }}
                      min={0}
                      type="number"
                      name="numberOfBathrooms"
                      onChange={handleChange}
                    />
                    <br />
                    <div className="mb-2" onChange={handleChange}>
                      Have a Balcony (?)
                    </div>
                    <Form.Check
                      name="haveBalcony"
                      onChange={handleChange}
                      type="checkbox"
                    />
                    <br />
                    <div className="mb-2">Have a Furniture (?)</div>
                    <Form.Check
                      name="haveFurniture"
                      onChange={handleChange}
                      type="checkbox"
                    />
                    <br />
                    <div className="mb-2">In a Site (?)</div>
                    <Form.Check
                      name="inASite"
                      onChange={handleChange}
                      type="checkbox"
                    />
                    <br />
                    <div className="mb-2">Site Name</div>
                    <Form.Control
                      name="siteName"
                      onChange={handleChange}
                      type="text"
                      defaultValue={"Unspecified"}
                    />
                    <br />
                    {/* <div className="mb-2">Upload Photo</div>
                    <label htmlFor="image-file" className="custom-file-upload">
                      Choose File
                    </label>
                    <input
                      style={{ display: "none" }}
                      type="file"
                      id="image-file"
                      onChange={handleFileChange}
                    /> */}
                    <br />
                    <br />
                    <div className="d-flex justify-content-center">
                      <Button className="btn-teal" onClick={handleSubmit}>
                        Publish Ad
                      </Button>
                    </div>
                  </Form.Group>
                </Form>
                <br />
                <br />
              </div>
            </Card>
          </div>
        </div>
      </div>
      <br />
      <br />
      <br />
      <br />
      <br />
    </>
  );
}

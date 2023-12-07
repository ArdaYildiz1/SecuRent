import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Card from 'react-bootstrap/Card';

function FilterComponent() {
    return (
        <>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <br />
                        <Card style={{ backgroundColor: 'white', borderRadius: "1rem", }}>
                                <br /><br />
                            <Form className='d-flex align-items-center'>
                                <Form.Group className="ms-5 me-5 mb-3" controlId="loginPassword">
                                    <Form.Label>Sort By:</Form.Label>
                                    <Form.Select aria-label="Filter">
                                        <option>A-Z</option>
                                        <option value="1">Z-A</option>
                                    </Form.Select>
                                </Form.Group>
                                <br />
                                <Form.Group className="ms-5 me-5 mb-3" controlId="loginPassword">
                                    <Form.Label>Max Result:</Form.Label>
                                    <Form.Select aria-label="Max Results">
                                        <option>20</option>
                                        <option value="1">30</option>
                                        <option value="2">50</option>
                                        <option value="3">100</option>
                                    </Form.Select>
                                </Form.Group>
                                <br /><br />
                                <Form.Group className="ms-5 me-5 mb-3" controlId="loginPassword">
                                    <br />
                                    <Form className="d-flex align-items-center">
                                        <Form.Control
                                            type="search"
                                            placeholder="Search"
                                            className="me-2"
                                            aria-label="Search"
                                            style={{ height: '30px' }}
                                        />
                                        <Button
                                            className="btn-teal d-flex align-items-center"
                                            style={{ height: '30px' }}

                                        >
                                            Search
                                        </Button>
                                    </Form>
                                </Form.Group>
                            </Form>
                            <br /><br />
                            <Form.Group className="ms-5 me-5 mb-3" controlId="loginPassword">
                                <Button className="btn-teal" type="submit">
                                    Filter
                                </Button>
                            </Form.Group>
                        </Card>
                    </div>
                </div>
            </div>
        </>
    );

}

export default FilterComponent;
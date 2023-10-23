import { useEffect, useState } from "react";
import { Spinner } from "react-bootstrap";
import { Badge, Button, Col, Container, Form, Nav, Card, Navbar, NavDropdown, Row } from "react-bootstrap";
import Table from 'react-bootstrap/Table';
import { Link, useNavigate, useSearchParams } from "react-router-dom";
import MySpinner from "../layout/MySpinner";
import format from "date-fns/format";
import Apis, { endpoints } from "../configs/Apis";
const Home = () => {

    //data
    const [city, setCity] = useState(null);
    const loadCity = async () => {
        let res = await Apis.get(endpoints['city'])
        setCity(res.data);
    }
    const [major, setMajor] = useState(null);
    const loadMajor = async () => {
        let res = await Apis.get(endpoints['major'])
        setMajor(res.data);
    }
    const [typeJob, setTypeJob] = useState(null);
    const loadTypeJob = async () => {
        let res = await Apis.get(endpoints['typeJob'])
        setTypeJob(res.data);
    }
    const [edu, setEdu] = useState(null);
    const loadEdu = async () => {
        let res = await Apis.get(endpoints['education'])
        setEdu(res.data);
    }

    const [q] = useSearchParams();
    // search
    const [kw, setKw] = useState("");
    const nav = useNavigate();
    const search = (evt) => {
        evt.preventDefault();
        nav(`/?kw=${kw}`)
    }

    const [job, setJob] = useState(null);
    useEffect(() => {
        const loadJob = async () => {
            let e = endpoints['job'];
            let cityId = q.get("cityId");
            let majorId = q.get("majorId");
            let typeId = q.get("typeJobId");
            let edusId = q.get("educationId");
            if (cityId !== null)
                e = `${e}?cityId=${cityId}`;

            else if (majorId !== null) {
                e = `${e}?majorId=${majorId}`;
            }
            else if (typeId !== null) {
                e = `${e}?typeJobId=${typeId}`;
            }
            else if (edusId !== null) {
                e = `${e}?educationId=${edusId}`;
            }
            else if (kw !== null) {
                let kw = q.get("kw");
                if (kw !== null)
                    e = `${e}?kw=${kw}`;
            }
            let res = await Apis.get(e);
            setJob(res.data);
        }

        loadJob();
    }, [q]);

    useEffect(() => {
        loadCity();
        loadMajor();
        loadTypeJob();
        loadEdu();
    }, [])

    if (city === null || major === null || edu === null || typeJob === null || job === null)
        return <MySpinner />

    return (
        <>
            <Navbar expand="lg" className="bg-body-tertiary">
                <Container>

                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                            <Link className="nav-link" to="/">Lọc</Link>
                            <NavDropdown title=" Thành phố" id="basic-nav-dropdown">
                                {city.map(c => {
                                    let h = `/?cityId=${c.id}`;
                                    return <Link className="dropdown-item" to={h} key={c.id}>{c.nameCity}</Link>
                                })}

                            </NavDropdown>
                            <NavDropdown title="Nghề nghiệp" id="basic-nav-dropdown">
                                {major.map(m => {
                                    let mj = `/?majorId=${m.id}`;
                                    return <Link className="dropdown-item" to={mj} key={m.id}>{m.nameMajor}</Link>
                                })}

                            </NavDropdown>
                            <NavDropdown title="Hình thức" id="basic-nav-dropdown">
                                {typeJob.map(m => {
                                    let mj = `/?typeJob=${m.id}`;
                                    return <Link className="dropdown-item" to={mj} key={m.id}>{m.nameType}</Link>
                                })}

                            </NavDropdown>
                            <NavDropdown title="Học vấn" id="basic-nav-dropdown">
                                {edu.map(m => {
                                    let mj = `/?edu=${m.id}`;
                                    return <Link className="dropdown-item" to={mj} key={m.id}>{m.typeEducation}</Link>
                                })}

                            </NavDropdown>
                            <Form onSubmit={search} inline>
                                <Form.Control
                                    type="text"
                                    value={kw}
                                    onChange={e => setKw(e.target.value)}
                                    placeholder="Nhập từ khóa..." name="kw"
                                    className=" mr-sm-2"
                                />
                            </Form>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
            <Container className="mt-5">

                <h1 className="text-center">DANH SÁCH VIỆC LÀM</h1>

                <Table striped bordered hover>
                    <thead>
                        <tr>
                            <th>Hình ảnh</th>
                            <th>Công việc</th>
                            <th>Mức lương</th>
                            <th>Số lượng</th>
                            <th>Ngành tuyển dụng</th>
                            <th>Nhà tuyển dụng</th>
                            <th>Ngày đăng</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {Object.values(job).map(c => {
                            let url = `/job/${c.id}`;
                            return <tr>
                                <td>
                                    <Card style={{ width: '10rem' }}>
                                        <Card.Img variant="top" src={c.avatarJob} fluid rounded />
                                    </Card>
                                </td>

                                <td>{c.nameJob}</td>
                                <td>{c.salary} VNĐ</td>
                                <td>{c.soLuongTuyenDung}</td>
                                <td>{c.employerID.nganhNghe}</td>
                                <td>{c.employerID.nameEmployer}</td>
                                <td>
                                    {format(new Date(c.createdDate), 'dd-MM-yyyy')}
                                </td>


                                <td>
                                <Link to={url} className="btn btn-info" style={{textDecoration:"none"}}> Ứng tuyển</Link>

                                </td>
                            </tr>
                        })}
                    </tbody>
                </Table>
            </Container>

        </>
    )
}
export default Home;
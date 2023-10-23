import { useContext, useEffect, useState } from "react";
import { Alert, Spinner } from "react-bootstrap";
import { Badge, Button, Col, Container, Form, Nav, Card, Navbar, NavDropdown, Row } from "react-bootstrap";
import Table from 'react-bootstrap/Table';
import { Link, useNavigate, useSearchParams } from "react-router-dom";
import MySpinner from "../layout/MySpinner";
import format from "date-fns/format";
import Apis, { endpoints } from "../configs/Apis";
import { MyCookieContext, MyUserContext } from "../App";



const EmpJob = () => {

    const [user,] = useContext(MyUserContext);
    const [kw, setKw] = useState("");
    const [q] = useSearchParams();
    const [, setSave] = useContext(MyCookieContext);
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
    const [emp, setEmp] = useState(null);
    const loadEmp = async () => {
        let res = await Apis.get(endpoints['empjob'])
        setEmp(res.data);
    }

    const nav = useNavigate();
    const search = (evt) => {
        evt.preventDefault();
        nav(`/EmpJob/?kw=${kw}`)
    }

    setSave({
        "type": "dec",
        "payload": 1
    })

    const [job, setJob] = useState(null
    );
    useEffect(() => {
        const loadJobs = async () => {
            try {
                let e = endpoints['job'];

                let kw = q.get("kw");
                if (kw !== null)
                    e = `${e}?kw=${kw}`;



                let res = await Apis.get(e);
                setJob(res.data);
            } catch (ex) {
                console.error(ex);
            }
        }

        loadJobs();
    }, [q]);

    useEffect(() => {
        if (user === null || user === undefined) {
            nav("/Login");
        }
        loadCity();
        loadMajor();
        loadTypeJob();
        loadEdu();
        loadEmp();
    }, [])

    const deletes = (deleteJob) => {
        const loadJob = async () => {
            let { data } = await Apis.delete(endpoints['delete'](deleteJob));
            nav("/")
        }
        loadJob();
    }
    if (city === null || major === null || edu === null || typeJob === null || job === null)
        return <MySpinner />

    return (
        <>
            <Container className="mt-5">
                <Form onSubmit={search} inline>
                    <Row>
                        <Col xs="auto">
                            <Form.Control
                                type="text"
                                value={kw}
                                onChange={e => setKw(e.target.value)}
                                placeholder="Nhập từ khóa..." name="kw"
                                className=" mr-sm-2"
                            />
                        </Col>
                        <Col xs="auto">
                            <Button type="submit">Tìm</Button>
                        </Col>
                    </Row>
                </Form>
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
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {Object.values(job).map(c => {
                            let url = `/jobs/${c.id}`;

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
                                    {user.id !== c.employerID.userID.id ? <p>Đây không phải tin của bạn nên không được sửa</p> : <>

                                        <Button variant="danger" href={url}>Sửa tin</Button>
                                    </>}

                                </td>
                                {user.id !== c.employerID.userID.id ? <p>Đây không phải tin của bạn nên không được xoá</p> : <>
                                    <td><Button variant="danger" onClick={() => deletes(c.id)} >Xóa tin</Button></td>
                                </>}


                            </tr>

                        })}
                    </tbody>
                </Table>
            </Container>

        </>
    )
}
export default EmpJob;
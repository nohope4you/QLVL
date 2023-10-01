import { useContext, useEffect, useState } from "react";
import { Alert, Spinner } from "react-bootstrap";
import { Badge, Button, Col, Container, Form, Nav, Card, Navbar, NavDropdown, Row } from "react-bootstrap";
import Table from 'react-bootstrap/Table';
import { Link, useNavigate, useParams, useSearchParams } from "react-router-dom";
import MySpinner from "../layout/MySpinner";
import format from "date-fns/format";
import Apis, { endpoints } from "../configs/Apis";
import { MyCookieContext, MyUserContext } from "../App";



const EmpJob = () => {

    const [user,] = useContext(MyUserContext);
    const [kw, setKw] = useState("");
    const [q] = useSearchParams();
    const { id } = useParams();
    const [, setSave] = useContext(MyCookieContext);


    const nav = useNavigate();
    const search = (evt) => {
        evt.preventDefault();
        nav(`/?kw=${kw}`)
    }

    setSave({
        "type": "dec",
        "payload": 1
    })

    const [emp, setEmp] = useState([]);
    useEffect(() => {
        const loadEmp = async () => {
            try {
                let e = endpoints['empreview'];

                let kw = q.get("kw");
                if (kw !== null)
                    e = `${e}?kw=${kw}`;



                let res = await Apis.get(e);
                setEmp(res.data);
            } catch (ex) {
                console.error(ex);
            }
        }

        loadEmp();
    }, [q]);



    return (
        <>

            <Button href="/newjob" > thêm job </Button>
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
                <h1 className="text-center">DANH SÁCH NHÀ TUYỂN DỤNG</h1>

                <Table striped bordered hover>
                    <thead>
                        <tr>
                            <th>Hình ảnh</th>
                            <th>Tên nhà tuyển dụng</th>
                            <th>Tên công ty</th>
                            <th>Địa chỉ</th>
                            <th>Số điện thoại</th>
                            <th>Ngành nghề</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {Object.values(emp).map(c => {
                            let url = `/empreview/${c.id}`;
                            return <tr>

                                <td>
                                    <Card style={{ width: '10rem' }}>
                                        <Card.Img variant="top" src={c.avatar} fluid rounded />
                                    </Card>
                                </td>
                                <td>{c.nameEmployer}</td>
                                <td>{c.nameCompany}</td>
                                <td>{c.addressComapny}</td>
                                <td>{c.soDienThoai}</td>
                                <td>{c.nganhNghe}</td>
                                <td>
                                    {user === null ? <p>Vui lòng <Link to="/login">đăng nhập</Link> để đánh giá nhà tuyển dụng </p> : <>

                                        <Button className="mt-2" variant="info"> <Link to={url} style={{ textDecoration: "none", color: "white" }}> Đánh giá</Link></Button>
                                        <hr /></>}
                                </td>

                            </tr>

                        })}
                    </tbody>
                </Table>
            </Container>

        </>
    )
}
export default EmpJob;
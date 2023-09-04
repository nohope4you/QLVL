import { useContext, useEffect, useState } from "react";
import { Spinner } from "react-bootstrap";
import { Badge, Button, Col, Container, Form, Nav, Navbar, NavDropdown, Row } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import Apis, { endpoints } from "../configs/Apis";
import { MyUserContext } from "../App";
const Header = () => {
    const [user,dispatch] = useContext(MyUserContext);
    const [kw, setKw] = useState("");
    const nav = useNavigate();

    const search = (evt) => {
        evt.preventDefault();
        nav(`/?kw=${kw}`)
    }

    const logout = () => {
        dispatch({
            "type": "logout"
        })
    }

    return (<>
        <Navbar expand="lg" className="bg-body-tertiary">
            <Container>
                <Navbar.Brand href="#home">&#128178;WORK</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Link className="nav-link" to="/"> Trang chủ</Link>
                        <Link className="nav-link" to="/"> Hồ sơ</Link>
                        <Link className="nav-link" to="/"> Quản trị</Link>
                        <Link className="nav-link" to="/"> Thống kê</Link>
                        <Link className="nav-link" to="/"> Đăng ký nhà tuyển dụng</Link>
                        <Link className="nav-link" to="/"> Tìm kiếm ứng viên</Link>
                        <Link className="nav-link" to="/"> Đánh giá</Link>

                        {user === null ? <>
                        <Link className="nav-link" to="/login"> Đăng nhập</Link>
                        <Link className="nav-link" to="/register"> Đăng ký</Link>
                        </>: <>
                        <Link className="nav-link" to="/"> {user}</Link>
                        <Button variant="secondary" onClick={logout}> Đăng xuất</Button>
                        </>}

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

                    </Nav>
                </Navbar.Collapse>

            </Container>

        </Navbar>

    </>)
}
export default Header; 
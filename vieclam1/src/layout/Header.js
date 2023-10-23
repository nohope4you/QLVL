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
        nav("/");
    }
    return (<>
        <Navbar expand="lg" className="bg-body-tertiary">
            <Container>
                <Navbar.Brand href="#home">&#128178;WORK</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Link className="nav-link" to="/"> Trang chủ</Link>
                        <Link className="nav-link" to="/empreview"> Đánh giá</Link>
                        
                        {user === null ? <>
                        <Link className="nav-link" to="/login"> Đăng nhập</Link>
                        <Link className="nav-link" to="/register"> Đăng ký</Link>
                        </>: <>
                        {user.userRole==="ROLE_USER"?"":<>
                        <Link className="nav-link" to="/RegisterEmp"> Đăng ký nhà tuyển dụng</Link>
                        <Link className="nav-link" to="/EmpJob"> Công việc đã đăng</Link>
                        <Link className="nav-link" to="/NewJob">Đăng tin tuyển dụng</Link>
                        </>}
                       
                        <Link className="nav-link" to="/">{user.username}</Link>
                        <Button variant="secondary" onClick={logout}> Đăng xuất</Button>
                        </>}

                       

                    </Nav>
                </Navbar.Collapse>

            </Container>

        </Navbar>

    </>)
}
export default Header; 
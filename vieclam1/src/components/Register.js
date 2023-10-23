import { useRef, useState, useEffect } from "react";
import { Alert, Button, Form, NavDropdown } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";


const Register = () => {
    const [major, setMajor] = useState([]);
    const loadMajor = async () => {
        let res = await Apis.get(endpoints['major'])
        setMajor(res.data);
    }
    const [role, setRole] = useState([]);
    const loadRole = async () => {
        let res = await Apis.get(endpoints['role'])
        setRole(res.data);
    }
    useEffect(() => {
        loadMajor();
        loadRole();
    }, [])

    const avatar = useRef();
    const [err, setErr] = useState(null);
    const [loading, setLoading] = useState(false);
    const nav = useNavigate();
    const [user, SetUser] = useState({
        "username": "",
        "password": "",
        "ho": "",
        "ten": "",
        "namKinhNghiem": "",
        "tuoi": "",
        "email": "",
        "sdt": "",
        "NganhNghe": "IT",
        "roleID": "1",
        "confirmPass": ""
    });

    const register = (evt) => {
        evt.preventDefault();

        const process = async () => {
            try {
                let form = new FormData();

                for (let field in user)
                    if (field !== "confirmPass")
                        form.append(field, user[field]);
                form.append("avatar", avatar.current.files[0]);
                setLoading(true)
                let check = await Apis.get(endpoints['getUserByUsername'](user.username))
                if (check.status === 200) {
                    let res = await Apis.post(endpoints['register'], form);
                    if (res.status === 201) {
                        nav("/login");
                    } else
                        setErr("Hệ thống bị lỗi!");
                }
                else {
                    window.location.reload();
                }

            } catch (ex) {
                setErr("Trùng tài khoản!");
                window.scrollTo(0, 0);
            }

        }

        if (user.password === user.confirmPass)
            process();
        else {
            setErr("Mật khẩu KHÔNG khớp!");
            window.scrollTo(0, 0);
        }
    }

    const change = (evt, field) => {
        // setUser({...user, [field]: evt.target.value})
        SetUser(current => {
            return { ...current, [field]: evt.target.value }
        })
    }

    return <>


        <h1 className="text-center text-info mt-2"> ĐĂNG KÝ NGƯỜI DÙNG</h1>
        {err === null ? "" : <Alert variant="danger">{err}</Alert>}
        <Form onSubmit={register}>

            <Form.Group className="mb-3">
                <Form.Label>Tên đăng nhập</Form.Label>
                <Form.Control value={user.username} onChange={(e) => change(e, "username")} type="text" placeholder="Tên đăng nhập" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Mật khẩu</Form.Label>
                <Form.Control value={user.password} onChange={(e) => change(e, "password")} type="password" placeholder="Mật khẩu" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Xác nhận mật khẩu</Form.Label>
                <Form.Control value={user.confirmPass} onChange={(e) => change(e, "confirmPass")} type="password" placeholder="Xác nhận mật khẩu" required />
            </Form.Group>

            <Form.Group className="mb-3">
                <Form.Label>Tên</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "ten")} placeholder="Tên" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Họ và chữ lót</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "ho")} placeholder="Họ và chữ lót" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Năm kinh nghiệm</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "namKinhNghiem")} placeholder="Năm kinh nghiệm" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Tuổi</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "tuoi")} placeholder="Tuổi" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Email</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "email")} placeholder="Email" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Số điện thại</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "sdt")} placeholder="Số điện thoại" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Ngành nghề</Form.Label>
                <Form.Select onChange={(e) => change(e, "NganhNghe")}>
                    {major.map(m => {
                        return <option key={m.id} >{m.nameMajor}</option>
                    })}
                </Form.Select>
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Chọn vị trí</Form.Label>
                <Form.Select onChange={(e) => change(e, "roleID")}>
                    {role.map(m => {
                        return <option key={m.id} value={m.id} >{m.nameRole}</option>
                    })}

                </Form.Select>
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Ảnh đại diện</Form.Label>
                <Form.Control type="file" ref={avatar} />
            </Form.Group>

            <Form.Group className="mb-3">
                <Button variant="info" type="submit">
                    Đăng ký
                </Button>
            </Form.Group>
        </Form>
    </>
}

export default Register;
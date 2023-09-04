import { useRef, useState } from "react";
import { Alert, Button, Form } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";


const Register = () => {

    const avatar = useRef();
    const [err, setErr] = useState(null);
    const [loading, setLoading] = useState(false);
    const nav = useNavigate();
    const [user, SetUser] = useState({
        "username": "",
        "password": "",
        "ho": "",
        "ten": "",
        "NganhNghe": "",
        "roleID": "",
        "confirmPass": ""
    });

    const register = (evt) => {
        evt.preventDefault();

        const process = async () => {
            let form = new FormData();

            for (let field in user)
                if (field !== "confirmPass")
                    form.append(field, user[field]);

            form.append("avatar", avatar.current.files[0]);

            setLoading(true)
            let res = await Apis.post(endpoints['register'], form);
            if (res.status === 201) {
                nav("/login");
            } else
            setErr("Hệ thống bị lỗi!");
        }

        if (user.password === user.confirmPass)
            process();
        else {
            setErr("Mật khẩu KHÔNG khớp!");
        }
    }

    const change = (evt, field) => {
        // setUser({...user, [field]: evt.target.value})
        SetUser(current => {
            return {...current, [field]: evt.target.value}
        })
    }

    return <>
        <h1 className="text-center text-info mt-2"> ĐĂNG KÝ NGƯỜI DÙNG</h1>
        {err === null?"":<Alert variant="danger">{err}</Alert>}
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
                <Form.Label>Ngành nghề</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "NganhNghe")} placeholder="NganhNghe" />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>vị trí</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "roleID")} placeholder="RoleId" />
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
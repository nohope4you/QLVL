import { useContext, useEffect, useRef, useState } from "react";
import { Alert, Button, Form } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";
import { MyUserContext } from "../App";


const RegisterEmp = () => {
    const [user,] = useContext(MyUserContext);
    const avatar = useRef();
    const [err, setErr] = useState(null);
    const [loading, setLoading] = useState(false);
    const nav = useNavigate();
    const [emp, SetEmp] = useState({
        "nameCompany": "",
        "nameEmployer": "",
        "soDienThoai": "",
        "addressComapny": "",
        "nganhNghe": "IT",
        "userID": user.id,
    });
    const [major, setMajor] = useState([]);
    const loadMajor = async () => {
        let res = await Apis.get(endpoints['major'])
        setMajor(res.data);
    }
    useEffect(() => {   
        loadMajor();
    }, [])
    const registeremp = (evt) => {
        evt.preventDefault();

        const process = async () => {
            let form = new FormData();

            for (let field in emp)
                    form.append(field, emp[field]);

            form.append("avatar", avatar.current.files[0]);

            setLoading(true)
            let res = await Apis.post(endpoints['registeremp'], form);
            if (res.status === 201) {
                nav("/");
            } else
            setErr("Hệ thống bị lỗi!");
        }
            process();
    }

    const change = (evt, field) => {
        // setUser({...user, [field]: evt.target.value})
        SetEmp(current => {
            return {...current, [field]: evt.target.value}
        })
    }

    return <>
        <h1 className="text-center text-info mt-2"> ĐĂNG KÝ NHÀ TUYỂN DỤNG</h1>
        {err === null?"":<Alert variant="danger">{err}</Alert>}
        <Form onSubmit={registeremp}>
            <Form.Group className="mb-3">
                <Form.Label>Tên công ty</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "nameCompany")} placeholder="Tên công ty" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Tên nhà tuyển dụng</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "nameEmployer")} placeholder="Tên nhà tuyển dụng" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Số điện thoại</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "soDienThoai")} placeholder="Số điện thoại" required/>
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Địa chỉ</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "addressComapny")} placeholder="Địa chỉ" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Nghề nghiệp</Form.Label>
                <Form.Select onChange={(e) => change(e, "ngheNghiep")}>
                    {major.map(m => {
                        return <option key={m.nameMajor} >{m.nameMajor}</option>
                    })}
                </Form.Select>
            </Form.Group>

            <Form.Group className="mb-3">
                <Form.Label>Ảnh đại diện</Form.Label>
                <Form.Control type="file" ref={avatar} />
            </Form.Group>

            <Form.Group className="mb-3">
                {loading === true?<MySpinner/>:<Button variant="info" type="submit">
                    Đăng ký thông tin nhà tuyển dụng
                </Button>}

            </Form.Group>
        </Form>
    </>
}

export default RegisterEmp;
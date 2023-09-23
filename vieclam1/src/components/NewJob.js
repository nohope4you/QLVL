import { useContext, useRef, useState } from "react";
import { Alert, Button, Form } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";
import { MyUserContext } from "../App";


const NewJob = () => {
    const [user,] = useContext(MyUserContext);
    const avatar = useRef();
    const [err, setErr] = useState(null);
    const [loading, setLoading] = useState(false);
    const nav = useNavigate();
    const [newjob, SetNewJob] = useState({
        "nameJob": "1",
        "salary": "1",
        "soLuongTuyenDung": "1",
        "kinhNghiem": "1",
        "age": "12",
        "cityID": "1",
        "majorID": "1",
        "typeJobID": "1",
        "idEmp":user.id,
        "educationID": "2",
        "districID": "2"
    });

    const Newjob = (evt) => {
        evt.preventDefault();

        const process = async () => {
            let form = new FormData();

            for (let field in newjob)
                form.append(field, newjob[field]);


            form.append("avatarJob", avatar.current.files[0]);

            setLoading(true)
            let res = await Apis.post(endpoints['newjob'], form);
            if (res.status === 201) {
                nav("/");
            } else
            setErr("Hệ thống bị lỗi!");
        }

        if (newjob.kinhNghiem <= newjob.age  )
        process();
        else {
        setErr("Vui lòng nhập lại !!! Số năm kinh nghiệm và tuổi không hợp lệ !!! ");
    }

    }

    const change = (evt, field) => {
        // setUser({...user, [field]: evt.target.value})
        SetNewJob(current => {
            return {...current, [field]: evt.target.value}
        })
    }

    return <>
        <h1 className="text-center text-info mt-2"> TUYỂN DỤNG NHÂN SỰ</h1>
        {err === null?"":<Alert variant="danger">{err}</Alert>}
        <Form onSubmit={Newjob}>

            <Form.Group className="mb-3">
                <Form.Label>Tên Công Việc</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "nameJob")} placeholder="Tên Công Việc" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Mức lương theo tháng</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "salary")} placeholder="Mức lương theo tháng" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Số lượng tuyển dụng</Form.Label>
                <Form.Control type="number" onChange={(e) => change(e, "soLuongTuyenDung")} placeholder="Số lượng tuyển dụng" />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Kinh nghiệm yêu cầu</Form.Label>
                <Form.Control value={newjob.kinhNghiem} type="number" onChange={(e) => change(e, "kinhNghiem")} placeholder="Kinh nghiệm yêu cầu" />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Độ tuổi</Form.Label>
                <Form.Control value={newjob.age} type="number" onChange={(e) => change(e, "age")} placeholder="Độ tuỏi yêu cầu" />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Khu vực thành phố </Form.Label>
                <Form.Control type="number" onChange={(e) => change(e, "cityID")} placeholder="Khu vực thành phố" />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Nghề nghiệp </Form.Label>
                <Form.Control type="number" onChange={(e) => change(e, "majorID")} placeholder="Nghề nghiệp" />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Loại công việc</Form.Label>
                <Form.Control type="number" onChange={(e) => change(e, "typeJobID")} placeholder="Loại công việc" />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Trình độ giáo dục</Form.Label>
                <Form.Control type="number" onChange={(e) => change(e, "educationID")} placeholder="Trình độ giáo dục" />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Khu vực quận </Form.Label>
                <Form.Control type="number" onChange={(e) => change(e, "districID")} placeholder="Khu vực quận" />
            </Form.Group>

            <Form.Group className="mb-3">
                <Form.Label>Ảnh đại diện</Form.Label>
                <Form.Control type="file" ref={avatar} />
            </Form.Group>

            <Form.Group className="mb-3">
                {loading === true?<MySpinner/>:<Button variant="info" type="submit">
                    Đăng ký
                </Button>}

            </Form.Group>
        </Form>
    </>
}

export default NewJob;
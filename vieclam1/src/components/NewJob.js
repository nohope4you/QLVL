import { useContext, useEffect, useRef, useState } from "react";
import { Alert, Button, Form } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
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
        "kinhNghiem": "",
        "age": "",
        "cityID": "1",
        "majorID": "1",
        "typeJobID": "1",
        "idEmp": "",
        "educationID": "2",
        "districID": "2"
    });
    const [city, setCity] = useState([]);
    const loadCity = async () => {
        let res = await Apis.get(endpoints['city'])
        setCity(res.data);
    }
    const [typeJob, setTypeJob] = useState([]);
    const loadTypeJob = async () => {
        let res = await Apis.get(endpoints['typeJob'])
        setTypeJob(res.data);
    }
    const [edu, setEdu] = useState([]);
    const loadEdu = async () => {
        let res = await Apis.get(endpoints['education'])
        setEdu(res.data);
    }
    const [major, setMajor] = useState([]);
    const loadMajor = async () => {
        let res = await Apis.get(endpoints['major'])
        setMajor(res.data);
    }
    const [district, setDistrict] = useState([]);
    const loadDistrict = async () => {
        let res = await Apis.get(endpoints['district'])
        setDistrict(res.data);
    }
    useEffect(() => {


        loadDistrict();
        loadCity();
        loadMajor();
        loadTypeJob();
        loadEdu();


    }, [])

    const Newjob = (evt) => {
        evt.preventDefault();
        newjob.idEmp = user.id;
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

        if (newjob.kinhNghiem <= newjob.age)
            process();
        else {
            setErr("Vui lòng nhập lại !!! Số năm kinh nghiệm và tuổi không hợp lệ !!! ");
        }

    }

    const change = (evt, field) => {
        SetNewJob(current => {
            return { ...current, [field]: evt.target.value }
        })
    }
   
    return <>
        <h1 className="text-center text-info mt-2"> TUYỂN DỤNG NHÂN SỰ</h1>
        {err === null ? "" : <Alert variant="danger">{err}</Alert>}
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
                <Form.Select onChange={(e) => change(e, "cityID")}>
                    {city.map(m => {
                        return <option key={m.id} value={m.id}>{m.nameCity}</option>
                    })}

                </Form.Select>

            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Nghề nghiệp </Form.Label>
                <Form.Select onChange={(e) => change(e, "majorID")}>
                    {major.map(m => {
                        return <option key={m.id} value={m.id}>{m.nameMajor}</option>
                    })}
                </Form.Select>

            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Loại công việc</Form.Label>
                <Form.Select onChange={(e) => change(e, "typeJobID")}>
                    {typeJob.map(m => {
                        return <option key={m.id} value={m.id}>{m.nameType}</option>
                    })}
                </Form.Select>

            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Trình độ giáo dục</Form.Label>
                <Form.Select onChange={(e) => change(e, "educationID")}>
                    {edu.map(m => {
                        return <option key={m.id} value={m.id}>{m.typeEducation}</option>
                    })}
                </Form.Select>

            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Khu vực quận </Form.Label>
                <Form.Select onChange={(e) => change(e, "districID")}>
                    {district.map(m => {
                        return <option key={m.id} value={m.id}>{m.nameDistrict}</option>
                    })}
                </Form.Select>

            </Form.Group>

            <Form.Group className="mb-3">
                <Form.Label>Ảnh đại diện</Form.Label>
                <Form.Control type="file" ref={avatar} />
            </Form.Group>
            {user === null ? <p>Vui lòng <Link to="/login">đăng nhập</Link> để tạo việc làm </p> : <>
                {user.userRole === "ROLE_EMP" ? <Form.Group className="mb-3">
                    {loading === true ? <MySpinner /> : <Button variant="info" type="submit">
                        Đăng ký
                    </Button>}

                </Form.Group> : <Link className="btn btn-info" to="/"> Trang chủ</Link>}

            </>}

        </Form>
    </>
}

export default NewJob;
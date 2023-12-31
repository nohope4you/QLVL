import { useContext, useEffect, useRef, useState } from "react";
import { Alert, Button, Form } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";
import { MyCookieContext, MyUserContext } from "../App";


const UpdateJob = () => {
    const [user,] = useContext(MyUserContext);
    const [savecookie,] = useContext(MyCookieContext);
    const avatar = useRef();
    const [err, setErr] = useState(null);
    const [loading, setLoading] = useState(false);
    const nav = useNavigate();
    const [newjob, SetNewJob] = useState({
        "id": savecookie.id,
        "nameJob": savecookie.nameJob,
        "salary": savecookie.salary,
        "soLuongTuyenDung": savecookie.soLuongTuyenDung,
        "kinhNghiem": savecookie.kinhNghiem,
        "age": savecookie.age,
        "cityID": savecookie.cityID.id,
        "majorID": savecookie.majorID.id,
        "typeJobID": savecookie.typeJobID.id,
        "idEmp": user.id,
        "educationID": savecookie.educationID.id,
        "districID": savecookie.districID.id
    });

    const Newjob = (evt) => {
        evt.preventDefault();

        const process = async () => {
            try {
                let form = new FormData();

                for (let field in newjob)
                    form.append(field, newjob[field]);


                form.append("avatarJob", avatar.current.files[0]);

                setLoading(true)
                let res = await Apis.post(endpoints['updatejob'], form);
                if (res.status === 200) {
                    nav("/");
                } else
                    setErr("Hệ thống bị lỗi!");

            } catch (ex) {
                setErr("Thêm lại hình ảnh!");
                window.scrollTo(0, 0);
            }

        }

        if (newjob.kinhNghiem <= newjob.age)
            process();
        else {
            setErr("Vui lòng nhập lại !!! Số năm kinh nghiệm và tuổi không hợp lệ !!! ");
        }

    }

    const change = (evt, field) => {
        // setUser({...user, [field]: evt.target.value})
        SetNewJob(current => {
            return { ...current, [field]: evt.target.value }
        })
    }
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
    return <>
        <h1 className="text-center text-info mt-2"> SỬA THÔNG TIN NHÂN SỰ CỦA CÔNG TY {savecookie.nameJob}</h1>
        {err === null ? "" : <Alert variant="danger">{err}</Alert>}
        <Form onSubmit={Newjob}>

            <Form.Group className="mb-3">
                <Form.Label>Tên Công Việc</Form.Label>
                <Form.Control value={newjob.nameJob} type="text" onChange={(e) => change(e, "nameJob")} placeholder="Tên Công Việc" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Mức lương theo tháng</Form.Label>
                <Form.Control value={newjob.salary} type="text" onChange={(e) => change(e, "salary")} placeholder="Mức lương theo tháng" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Số lượng tuyển dụng</Form.Label>
                <Form.Control value={newjob.soLuongTuyenDung} type="number" onChange={(e) => change(e, "soLuongTuyenDung")} placeholder="Số lượng tuyển dụng" />
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
                <Form.Select onChange={(e) => change(e, "cityID")} value={newjob.cityID}>
                    {city.map(m => {
                        return <option key={m.id} value={m.id}>{m.nameCity}</option>
                    })}

                </Form.Select>
                {/* <Form.Control value={newjob.cityID} type="number" onChange={(e) => change(e, "cityID")} placeholder="Khu vực thành phố" /> */}
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Nghề nghiệp </Form.Label>
                <Form.Select onChange={(e) => change(e, "majorID")} value={newjob.majorID}>
                    {major.map(m => {
                        return <option key={m.id} value={m.id}>{m.nameMajor}</option>
                    })}
                </Form.Select>
                {/* <Form.Control value={newjob.majorID} type="number" onChange={(e) => change(e, "majorID")} placeholder="Nghề nghiệp" /> */}
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Loại công việc</Form.Label>
                <Form.Select onChange={(e) => change(e, "typeJobID")} value={newjob.typeJobID}>
                    {typeJob.map(m => {
                        return <option key={m.id} value={m.id}>{m.nameType}</option>
                    })}
                </Form.Select>

                {/* <Form.Control value={newjob.typeJobID} type="number" onChange={(e) => change(e, "typeJobID")} placeholder="Loại công việc" /> */}
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Trình độ giáo dục</Form.Label>
                <Form.Select onChange={(e) => change(e, "educationID")} value={newjob.educationID} >
                    {edu.map(m => {
                        return <option key={m.id} value={m.id}>{m.typeEducation}</option>
                    })}
                </Form.Select>
                {/* <Form.Control value={newjob.educationID} type="number" onChange={(e) => change(e, "educationID")} placeholder="Trình độ giáo dục" /> */}
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Khu vực quận </Form.Label>
                <Form.Select onChange={(e) => change(e, "districID")} value={newjob.districID}>
                    {district.map(m => {
                        return <option key={m.id} value={m.id}>{m.nameDistrict}</option>
                    })}
                </Form.Select>
                {/* <Form.Control value={newjob.districID} type="number" onChange={(e) => change(e, "districID")} placeholder="Khu vực quận" /> */}
            </Form.Group>

            <Form.Group className="mb-3">
                <Form.Label>Ảnh đại diện</Form.Label>
                <Form.Control type="file" ref={avatar} value={newjob.avatarJob} />
            </Form.Group>

            <Form.Group className="mb-3">
            <Button variant="info" type="submit">
                    Sửa tin </Button>
                {/* {loading === true ? <MySpinner /> : 
               } */}

            </Form.Group>
        </Form>
    </>
}

export default UpdateJob;
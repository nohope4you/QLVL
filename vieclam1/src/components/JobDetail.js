import { useContext, useEffect, useState } from "react";
import { Button, Card, Col, Form, Image, ListGroup, Row } from "react-bootstrap";
import { Link, useParams } from "react-router-dom";
import { MyUserContext } from "../App";
import Apis, { authApi, endpoints } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";

const JobDetail = () => {
    const [user,] = useContext(MyUserContext);
    const { id } = useParams();
    const [Job, setJob] = useState(null);

    useEffect(() => {
        const loadJob = async () => {
            let { data } = await Apis.get(endpoints['details'](id));
            setJob(data);
        }

        loadJob();
    }, []);

    if (Job === null)
        return <MySpinner />;

    let url = `/login?next=/products/${id}`;
    return <>
        <h1 className="text-center text-info mt-2">CHI TIẾT CÔNG VIỆC ({id})</h1>
        <Row >
            <Col md={5} xs={6}>
                <Card style={{ width: 'auto' }}>
                    <Card.Img variant="top" src={Job.avatarJob} fluid rounded />
                </Card>
            </Col>
            <Col md={5} xs={6}>
                <h2 className="text-danger">Tên công ty :     {Job.nameJob}</h2>
                <h3> Số lượng tuyển dụng :  {Job.soLuongTuyenDung} Người</h3>
                <h3> Kinh nghiệm tối thiểu :  {Job.kinhNghiem} năm</h3>
                <h3> Tuổi tối thiểu :  {Job.age} tuổi</h3>
                <h3> Mức lương :  {Job.salary} VNĐ</h3>
                <h3> Ngành nghề :  {Job.age} </h3>
                <h3> Khu vực làm việc :  Quận {Job.age} </h3>
            </Col>
        </Row>
        <hr />


        {user === null ? <p>Vui lòng <Link to={url}>đăng nhập</Link> để nộp đơn ứng tuyển </p> : <>

            <Button href="/application" className="mt-2" variant="info">Nộp đơn</Button>
        </>}
        <hr />

        <Button href="/" className="mt-2" variant="info">Trở về</Button>
    </>
}

export default JobDetail;
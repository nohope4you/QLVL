import { useContext, useEffect, useRef, useState } from "react";
import { Button, Card, Col, Form, Image, ListGroup, Row } from "react-bootstrap";
import { Link, useNavigate, useParams } from "react-router-dom";
import { MyCookieContext, MyUserContext } from "../App";
import Apis, { authApi, endpoints } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";
import cookie from "react-cookies";

const ReviewDetailEmp = () => {

    const avatar = useRef();
    const [err, setErr] = useState(null);
    const [loading, setLoading] = useState(false);
    const nav = useNavigate();
    const [user,] = useContext(MyUserContext);
    const [,setSave] = useContext(MyCookieContext);
    const { id } = useParams();
    const [Emp, setEmp] = useState(null);
    const [comments, setComments] = useState(null);
    const [content, setContent] = useState();
    const [rate, setRate] = useState();

    useEffect(() => {
        const loademp = async () => {
            let { data } = await Apis.get(endpoints['empdetail'](id));
            setEmp(data);
            setSave({
                "type": "inc",
                "payload" : data
            })
        }
        const loadComments = async () => {
            let {data} = await Apis.get(endpoints['comment'](id));
            setComments(data);
        }
        loadComments();
        loademp();
    }, []);

    const addComment = () => {
        const process = async () => {
            let {data} = await authApi().post(endpoints['addcomment'], {
                "rating": rate,
                "cmt": content, 
                "employerID": Emp.id
            });

            setComments([...comments, data]);
        }

        process();
    }

    if (Emp === null)
        return <MySpinner />;

    return <>
<h1 className="text-center text-danger mt-2">CHI TIẾT NHÀ TUYỂN DỤNG ({id})</h1>
        <Row >
            <Col md={5} xs={6}>
                <Card style={{ width: 'auto' }}>
                    <Card.Img variant="top" src={Emp.avatar} fluid rounded />
                </Card>
            </Col>
            <Col md={5} xs={6}>
                <h2 className="text-info">Tên công ty :     {Emp.nameCompany}</h2>
                <h2 className="text-info">Tên nhà tuyển dụng :     {Emp.nameEmployer}</h2>
                <h3> Địa chỉ :  {Emp.addressComapny} </h3>
                <h3> Số điện thoại :  {Emp.soDienThoai} </h3>
                <h3> Ngành nghề :  {Emp.nganhNghe} </h3>
            </Col>
        </Row>
        <hr />

        <h3> Đánh giá độ hài lòng</h3>
        <Form.Select onChange={e => setRate(e.target.value)}>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
        </Form.Select>

        <hr />
        <h3>Bình luận </h3>
        <Form.Control as="textarea" aria-label="With textarea" value={content} onChange={e => setContent(e.target.value)} placeholder="Nội dung bình luận" />
        <Button onClick={addComment} className="mt-2" variant="info">Bình luận</Button>
        <hr />
        <ListGroup>
            {comments.map(c => <ListGroup.Item id={c.id}>
                        {c.userID.username} - {c.cmt} - {c.rating}
                    </ListGroup.Item>)
            }
        </ListGroup>
    </>
}

export default ReviewDetailEmp;
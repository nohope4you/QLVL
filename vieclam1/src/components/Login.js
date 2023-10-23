import { useContext, useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Apis, { authApi, endpoints } from '../configs/Apis';
import cookie from "react-cookies";
import { MyUserContext } from '../App';
import { Navigate, useNavigate } from 'react-router-dom';

const Login = () =>{
    
    const [user,dispatch]= useContext(MyUserContext);
    const [username,SetUsername] = useState();
    const [password, SetPassword] = useState();
    const nav = useNavigate();

    const login = (evt) => {
        evt.preventDefault();

        const process = async() => {
            try {
                let res = await Apis.post(endpoints['login'],{
                    "username":username,
                    "password":password
                });
                cookie.save("token",res.data);

                let {data} = await authApi().get(endpoints['current-user']);
                cookie.save("user",data);
                

                dispatch({
                    "type" : "login",
                    "payload": data
                })
    
            } catch (err) {
                console.error(err); 
            }

        }

        process();
    }

    if(user !== null)
        return <Navigate to="/"/>

    return <>
        <h1 className="text-center text-info">ĐĂNG NHẬP</h1>

        <Form onSubmit={login}>
      <Form.Group className="mb-3" controlId="formBasicEmail">
        <Form.Label>Tên đăng nhập</Form.Label>
        <Form.Control value={username} onChange={e => SetUsername(e.target.value)} type="text" placeholder="Nhập tên đăng nhập.." />
      </Form.Group>

      <Form.Group className="mb-3" controlId="formBasicPassword">
        <Form.Label>Nhập mật khẩu</Form.Label>
        <Form.Control value={password} onChange={e => SetPassword(e.target.value)} type="password" placeholder="Nhập mật khẩu..." />
      </Form.Group>
      <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
      <Button variant="info" type="submit">
        Đăng nhập
      </Button>
      </Form.Group>
    </Form>
    </>
}

export default Login;
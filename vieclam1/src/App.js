import { BrowserRouter, Route, Routes } from "react-router-dom";
import Footer from "./layout/Footer";
import Header from "./layout/Header";
import Home from "./components/Home";
import Login from "./components/Login";
import Register from "./components/Register";
import { createContext, useReducer } from "react";
import MyUserReducer from "./reducers/MyUserReducer";
import cookie from "react-cookies";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

export const MyUserContext = createContext();


const App = () => {
  const [user,dispatch] = useReducer(MyUserReducer, cookie.load("user",null));

  return (
    < MyUserContext.Provider value={[user,dispatch]}>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/login" element={<Login/>} />
          <Route path="/register" element={<Register/>} />
        </Routes>
        <Footer />
      </BrowserRouter>
    </MyUserContext.Provider>
  )
}
export default App;
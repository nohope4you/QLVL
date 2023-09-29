import { BrowserRouter, Route, Router, Routes } from "react-router-dom";
import Footer from "./layout/Footer";
import Header from "./layout/Header";
import Home from "./components/Home";
import Login from "./components/Login";
import Register from "./components/Register";
import RegisterEmp from "./components/RegisterEmp";
import { createContext, useReducer } from "react";
import MyUserReducer from "./reducers/MyUserReducer";
import MyJobReducer from "./reducers/MyJobReducer";
import cookie from "react-cookies";
import Application from "./components/Application";
import JobDetail from "./components/JobDetail";
import NewJob from "./components/NewJob";
import EmpJob from "./components/EmpJob";
import ReviewEmp from "./components/ReviewEmp";
import UpdateJob from "./components/UpdateJob";
import JobDetailBeforeUpdate from "./components/JobDetailBeforeUpdate";


export const MyUserContext = createContext();
export const MyCookieContext = createContext();


const App = () => {
  const [user, dispatch] = useReducer(MyUserReducer, cookie.load("user") || null);
  const [savecookie,setSave] = useReducer(MyJobReducer,cookie.load("savecookie") || null);

  return (
    < MyUserContext.Provider value={[user,dispatch]}>
      < MyCookieContext.Provider value={[savecookie,setSave]}>
      <BrowserRouter>
        <Header />
        <Routes>
          
          <Route path="/" element={<Home/>}/>
          <Route path="/login" element={<Login/>} />
          <Route path="/register" element={<Register/>} />
          <Route path="/registeremp" element={<RegisterEmp/>} />
          <Route path="/application" element={<Application/>} />
          <Route path="/job/:id" element={<JobDetail/>} />
          <Route path="/jobs/:id" element={<JobDetailBeforeUpdate/>} />
          <Route path="/newjob" element={<NewJob/>} />
          <Route path="/empjob" element={<EmpJob/>} />
          <Route path="/empreview" element={<ReviewEmp/>} />
          <Route path="/updatejob" element={<UpdateJob/>} />
        </Routes>
        <Footer />
      </BrowserRouter>
      </MyCookieContext.Provider>
    </MyUserContext.Provider>
  )
}
export default App;
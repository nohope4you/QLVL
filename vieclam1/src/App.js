import { BrowserRouter, Route, Router, Routes } from "react-router-dom";
import Footer from "./layout/Footer";
import Header from "./layout/Header";
import Home from "./components/Home";
import Login from "./components/Login";
import Register from "./components/Register";
import { createContext, useReducer } from "react";
import MyUserReducer from "./reducers/MyUserReducer";
import cookie from "react-cookies";
import Application from "./components/Application";
import JobDetail from "./components/JobDetail";
import NewJob from "./components/NewJob";


export const MyUserContext = createContext();


// const app = NewJob;
// var cors = require('cors');
// app.use(cors())

// app.get("/api", (req, res) => {
//   res.setHeader("Access-Control-Allow-Origin", "*")
//   res.setHeader("Access-Control-Allow-Credentials", "true");
//   res.setHeader("Access-Control-Max-Age", "1800");
//   res.setHeader("Access-Control-Allow-Headers", "content-type");
//   res.setHeader( "Access-Control-Allow-Methods", "PUT, POST, GET, DELETE, PATCH, OPTIONS" ); 
//    });

const App = () => {
  const [user, dispatch] = useReducer(MyUserReducer, cookie.load("user") || null);
  return (
    < MyUserContext.Provider value={[user,dispatch]}>
      <BrowserRouter>
        <Header />
        <Routes>
          
          <Route path="/" element={<Home/>}/>
          <Route path="/login" element={<Login/>} />
          <Route path="/register" element={<Register/>} />
          <Route path="/application" element={<Application/>} />
          <Route path="/job/:id" element={<JobDetail/>} />
          <Route path="/newjob" element={<NewJob/>} />
        </Routes>
        <Footer />
      </BrowserRouter>
    </MyUserContext.Provider>
  )
}
export default App;
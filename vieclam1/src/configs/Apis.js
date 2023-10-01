import axios from "axios";
import cookie from "react-cookies";

export const endpoints = {
    "city":"/QLViecLam/api/GetCity/",
    "application":"/QLViecLam/api/getApplication/",
    "job":"/QLViecLam/api/GetJob/",
    "details":(id) => `/QLViecLam/api/GetJob/${id}`,
    "major":"/QLViecLam/api/GetMajor/",
    "typeJob":"/QLViecLam/api/GetTypeJob/",
    "education":"/QLViecLam/api/GetEducation/",
    "district":"/QLViecLam/api/GetDistrict/",
    "login":"/QLViecLam/api/login/",
    "current-user":"/QLViecLam/api/current-user/",
    "register":"/QLViecLam/api/users/",
    "newjob":"/QLViecLam/api/NewJob/",
    "empjob":"/QLViecLam/api/GetJobByEmp/",
    "delete":(id) => `/QLViecLam/api/deleteJob/${id}`,
    "updatejob":"/QLViecLam/api/UpdateJob/",
    "registeremp":"/QLViecLam/api/employer/",
    "empreview":"/QLViecLam/api/GetEmp/",
    "comment": (id) => `/QLViecLam/api/GetEmp/${id}/comments/`,
    "addcomment":"/QLViecLam/api/comments/",
    "empdetail":(id) => `/QLViecLam/api/GetEmp/${id}`,

}

export const authApi = () => {
    return axios.create({
        baseURL:"http://localhost:8080",
        headers: {
            "Authorization":  cookie.load("token")
        }
    })
}

export default axios.create({
    baseURL:"http://localhost:8080"
});
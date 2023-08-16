<%-- 
    Document   : index
    Created on : Aug 15, 2023, 4:50:59 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="<c:url value="/"/>">Work</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="mynavbar">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/"/>">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">Hồ sơ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/SignUp" />">Đăng ký</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="login" />">Đăng nhập</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
<h2 style="margin-left:400px;">DANH SÁCH VIỆC LÀM</h2>
        <ul class="pagination" style="margin-left:400px;">
            <c:forEach begin="1" end="${counts}" var="i">
                <c:url value="/" var="pageUrl">
                    <c:param name="page" value="${i}"></c:param>
                </c:url>
                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
            </c:forEach>
            
         
        </ul>
        <div class="container" style="margin-top:30px;width:800px;" >
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Công việc</th>
                        <th>Mức lương</th>
                        <th>Số lượng</th>
                        <th>Tuổi</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${JOB}" var="j">
                        <tr>
                            <td>${j.id}</td>
                            <td>${j.nameJob}</td>
                            <td>${j.salary}</td>
                            <td>${j.soLuongTuyenDung}</td>
                            <td>${j.age}</td>
                            <td>  <a href="#" class="btn btn-success">Xem công việc</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>

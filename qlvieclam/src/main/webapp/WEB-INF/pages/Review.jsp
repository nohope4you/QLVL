<%-- 
    Document   : Review
    Created on : Aug 24, 2023, 12:19:53 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <h2 style="margin-left: 400px;">DANH SÁCH NHÀ TUYỂN DỤNG</h2>
</div>
 <li style="margin:auto ; width: 500px;list-style-type: none" >
        <c:url value="/Review" var="action" />
        <form class="d-flex" action="${action}">
            <input class="form-control me-auto" type="text" name="kw" placeholder="Nhập tên công việc cần tìm .....">
            <button class="btn btn-primary" type="submit">Tìm</button>
        </form>

    </li>
<div class="container" style="margin-top:30px;width:900px;" >
    
    <table class="table table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên nhà tuyển dụng</th>
                  <th>Tên công ty</th>
                  <th>Chuyên ngành</th>
                <th>Địa chỉ</th>
                <th>Số điện thoại</th>
                <th></th>
            </tr>
        </thead>
         <tbody>
            <c:forEach items="${EMP}" var="e">
                <tr>
                    <td>${e.id}</td>
                    <td>${e.nameEmployer}</td>
                    <td>${e.nameCompany}</td>
                     <td>${e.nganhNghe}</td>
                    <td>${e.addressComapny}</td>
                    <td>${e.soDienThoai}</td>
                    <td>   
                        <a href="<c:url value="/ReviewDetail/${e.id}"/>" class="btn btn-success">Đánh giá</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
 </table>
</div>
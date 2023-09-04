<%-- 
    Document   : SearchUser
    Created on : Aug 26, 2023, 2:44:13 PM
    Author     : Admin
--%>
<style>
    form{
        border: 1px solid black;
        padding: 10px;
    }
    form div{
        margin-left: 50px;
    }
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <h2 style="margin-left: 500px;">TÌM KIẾM ỨNG VIÊN</h2>
    <div class="col-md-5" style="margin-left: 380px;">
        <c:url value="/SearchUser" var="action" />
        <form  class="col-md-12" action="${action}" >
            <div class="col-md-12">
                <div class="col-md-8" style="margin-bottom: 10px;">
                    <input class="form-control me-auto " type="text" name="name" placeholder="Nhập tên ứng viên .....">
                </div>
                <div class="col-md-8" style="margin-bottom: 10px;">
                    <input class="form-control me-auto " type="text" name="major" placeholder="Nhập tên chuyên ngành .....">
                </div>
            </div>


            <button class="btn btn-primary" style="margin-left: 100px;" type="submit">Tìm kiếm</button>
        </form>
    </div>
    <div class="container">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên ứng viên</th>
                    <th>Chuyên ngành của ứng viên</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${USER}" var="u">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.ho} ${u.ten}</td>
                    <td>${u.nganhNghe}</td>
                    
                    
                </tr>
            </c:forEach>
        </tbody>
          
        </table>
    </div>

</div>
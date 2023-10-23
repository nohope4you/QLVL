<%-- 
    Document   : TaoCV
    Created on : Sep 22, 2023, 11:23:44 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<c:url value="/TaoCV" var="action" />
<div class="container">
    <form:form action="${action}" method="post" enctype="multipart/form-data">
        <label for="name">Họ tên:</label>
        <input class="form-control" type="text" id="name" name="name"required />

        <label for="tuoi">Tuổi:</label>
        <input class="form-control" type="number" id="tuoi" name="tuoi"required />

        <label for="tuoi">Trường đại học:</label>
        <input class="form-control" type="text" id="school" name="school"required />

        <label for="tuoi">GPA:</label>
        <input class="form-control" type="number" id="GPA" name="GPA"required />

        <label for="tuoi">Mô tả:</label>
        <textarea class="form-control mb-3" id="mota" name="mota" required></textarea>

        <label for="tuoi">Ảnh chân dung</label>
        <input class="form-control" type="file" id="img" name="img"required />
       <button type="submit" class="btn btn-primary">Tạo CV</button>
    </form:form>  
</div>


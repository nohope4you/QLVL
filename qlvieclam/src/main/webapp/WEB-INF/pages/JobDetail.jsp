<%-- 
    Document   : JobDetail
    Created on : Aug 18, 2023, 9:05:23 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2 class="text-center text-info ">FORM CHI TIẾT VIỆC LÀM</h2>

<c:url value="/JobDetail" var="action" />
<form:form action="${action}"  method="post" modelAttribute="JD" enctype="multipart/form-data">

        <form:errors path="*" element="div"  cssClass="alert alert-danger" />
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Tên công việc</label>
        <form:input path="nameJob"/>
    </div>  
    <button type="submit" class="btn btn-primary">Submit</button>
</form:form>



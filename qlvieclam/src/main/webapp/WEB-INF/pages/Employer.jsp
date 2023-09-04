<%-- 
    Document   : Employer
    Created on : Aug 19, 2023, 2:14:13 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<div class="container">
    <h2>ĐĂNG KÝ NHÀ TUYỂN DỤNG</h2>
    <c:url value="/Employer" var="action" />
    <form:form action="${action}"  method="post" modelAttribute="emp" enctype="multipart/form-data">



        <div class="mb-3 mt-3">
            <label for="nameEmployer" class="form-label">Tên nhà tuyển dụng</label>      
            <form:input type="text" path="nameEmployer" class="form-control" 
                        id="nameEmployer" placeholder="Nhập tên nhà tuyển dụng"/>
        </div>
        <div class="mb-3 mt-3">
            <label for="nameCompany" class="form-label">Tên công ty</label>      
            <form:input type="text" path="nameCompany" class="form-control" 
                        id="nameCompany" placeholder="Nhập tên công ty"/>
        </div>

        <div class="mb-3 mt-3">
            <label for="addressComapny" class="form-label">Địa chỉ công ty</label>      
            <form:input type="text" path="addressComapny" class="form-control" 
                        id="addressComapny" placeholder="Nhập dịa chỉ công ty"/>
        </div>
        <div class="mb-3 mt-3">
            <label for="soDienThoai" class="form-label">Số điện thoại công ty</label>      
            <form:input type="text" path="soDienThoai" class="form-control" 
                        id="soDienThoai" placeholder="Nhập số điện thoại công ty"/>
        </div>
          <div  class="mb-3 mt-3">
            <label for="nganhNghe" class="form-label">Chuyên ngành công ty</label>      
            <form:select class="form-select" id="nganhNghe" name="nganhNghe" path="nganhNghe">
                <c:forEach items="${MAJOR}" var="m">
                    <option value="${m.nameMajor}" >${m.nameMajor}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="mb-3 mt-3">
            <label for="file" class="form-label">Ảnh công ty</label>      
            <form:input type="file" path="file" class="form-control" 
                        id="file"/>
        </div>
        
        <c:if test="${not empty message}">
            <div class="alert alert-danger">
                ${message}
            </div>
        </c:if>
        <button type="submit" class="btn btn-primary">Đăng ký</button>
    </form:form>

</div>


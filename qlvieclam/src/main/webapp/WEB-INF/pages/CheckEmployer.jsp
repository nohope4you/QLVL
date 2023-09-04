<%-- 
    Document   : CheckEmployer
    Created on : Aug 19, 2023, 3:29:25 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <h2 style="margin-left:300px;">KIỂM TRA THÔNG TIN NHÀ TUYỂN DỤNG</h2>
    <c:url value="/CheckEmployer" var="action" />
    <form:form action="${action}" modelAttribute="EMPLOYER" method="post" enctype="multipart/form-data"> 
        <form:hidden path="id" />
       
        <form:hidden path="avatar"/>
        <form:hidden path="userID.id" />
        <div>${EMPLOYER.userID.id}</div>
        <div class="mb-3 mt-3">
            <label for="id" class="form-label">ID nhà tuyển dụng</label>
            <form:input type="text" path="id" class="form-control" 
                        id="id"  />
        </div>
        <div class="mb-3 mt-3">
            <label for="nameEmployer" class="form-label">Tên nhà tuyển dụng</label>
            <form:input type="text" path="nameEmployer" class="form-control" 
                        id="nameEmployer"  />
        </div>
        
         <div class="mb-3 mt-3">
            <label for="nameCompany" class="form-label">Tên công ty</label>
            <form:input type="text" path="nameCompany" class="form-control" 
                        id="nameCompany" />
        </div>
        
        <div class="mb-3 mt-3">
            <label for="addressComapny" class="form-label">Địa chỉ công ty</label>
            <form:input type="text" path="addressComapny" class="form-control" 
                        id="addressComapny"  />
        </div>
        
         <div class="mb-3 mt-3">
            <label for="soDienThoai" class="form-label">Số điện thoại công ty</label>
            <form:input type="text" path="soDienThoai" class="form-control" 
                        id="soDienThoai"  />
        </div>
        <div class="mb-3 mt-3">
            <label for="nganhNghe" class="form-label">Chuyên ngành công ty</label>
            <form:input type="text" path="nganhNghe" class="form-control" 
                        id="nganhNghe"  />
        </div>
          <div class="mb-3">
        <label for="file" class="form-label">Ảnh minh hoạ</label>
        <form:input type="file" path="file" class="form-control" 
                    id="file"  />
    </div>
        <button type="submit" class="btn btn-success">
          Xác nhận
           </button>
         <a href="<c:url value="/Admin"/>" class="btn btn-primary">Trở về</a>
    </form:form>


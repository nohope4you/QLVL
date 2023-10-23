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
    <div class="container" style="margin-top:30px;width:1300px;" >
        <table class="table table-hover">
            <thead>
                <tr>
                    <th></th>
                    <th>Công việc</th>
                    <th>Mức lương</th>
                    <th>Số lượng</th>
                    <th>Ngành tuyển dụng</th>
                    <th>Nhà tuyển dụng</th>
                    <td>Ngày đăng</td>
                    <th></th>
                    <th></th>
                    <td></td>
                </tr>
            </thead>
            <tbody> 
                <c:forEach items="${jobEmploy}" var="j">
                    <tr>
                        <td><img src="${j.avatarJob}" width="120" height="90"/></td>
                        <td>${j.nameJob}</td>
                        <td>${j.salary}</td>
                        <td>${j.soLuongTuyenDung}</td>
                        <td>${j.majorID.nameMajor}</td>
                        <td>${j.employerID.nameEmployer}</td>
                        <td>${j.createdDate}</td>
                        <td>
                            <c:url value="/api/createJob/${j.id}" var="deleteApi" />
                            <a href="<c:url value="/createJob/${j.id}"/>" class="btn btn-success">Chỉnh sửa công việc</a>

                        </td>
                        <td>  
                            <a href="<c:url value="/ListApplication/${j.id}"/>" class="btn btn-success">Xem đơn ứng tuyển</a>   
                        </td>
                        <td>  
                            <button class="btn btn-danger" onclick="deleteJobApp(${j.id})">Xoá</button>  
                        </td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script>
    function deleteJobApp(id) {
        $.ajax({
            url: "http://localhost:8080/QLViecLam/api/x/" + id,
            method: "DELETE",
            success: function () {
                $.ajax({
                    url: "http://localhost:8080/QLViecLam/api/createJob/" + id,
                    method: "DELETE",
                    success: function () {
                        alert("Xoá thành công !!");
                         location.reload();
                        
                    }
                });
            },
            error: function () {
                $.ajax({
                    url: "http://localhost:8080/QLViecLam/api/createJob/" + id,
                    method: "DELETE",
                    success: function () {
                        alert("Xoá thành công !!");
                         location.reload();
                    }
                });

            }
        });
    }
</script>


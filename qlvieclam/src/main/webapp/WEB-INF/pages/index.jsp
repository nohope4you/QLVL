<%-- 
    Document   : index
    Created on : Aug 15, 2023, 4:50:59 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

           
<div class="container">
    <c:if test="${not empty message}">
            <div class="alert alert-danger">
                ${message}
            </div>
        </c:if> 
    <h3 style="margin-left: 500px;">TÌM KIẾM THEO TIÊU CHÍ</h3>
    <c:url value="/" var="action" />
    <form  action="${action}">
        <div class="col-md-5" style="margin-left: 400px;">
            <label for="pwd" class="form-label">Thành phố</label>
            <select class="form-select" name="cityId">
                <c:forEach items="${CITY}" var="ct">

                    <option value="${ct.id}" >${ct.nameCity}</option>
                </c:forEach>
            </select>

            <label for="pwd" class="form-label">Quận</label>
            <select class="form-select" name="districtId">
                <c:forEach items="${DISTRICT}" var="d">

                    <option value="${d.id}" >${d.nameDistrict}</option>
                </c:forEach>
            </select>

            <label for="pwd" class="form-label">Nghề nghiệp</label>
            <select class="form-select"   name="majorId">
                <c:forEach items="${MAJOR}" var="m">

                    <option value="${m.id}" >${m.nameMajor}</option>
                </c:forEach>
            </select>

            <label for="pwd" class="form-label">Hình thức</label>
            <select class="form-select"   name="typeJobId">
                <c:forEach items="${TYPEJOB}" var="t">

                    <option value="${t.id}" >${t.nameType}</option>
                </c:forEach>
            </select>
        </div>
        <button class="btn btn-primary" style="margin-left: 400px;" type="submit">Tìm</button>
    </form>

</div>

<h2 style="margin-left:400px;">DANH SÁCH VIỆC LÀM</h2>
<se:authorize access="hasRole('ROLE_EMP')">
    <a class="btn btn-info " style="margin-left: 400px;" href="<c:url value="/createJob" />"> Thêm Job</a>
</se:authorize>


<c:if test="${COUNT > 1}">
    <ul class="pagination mt-1" style="margin-left:400px;">
        <li class="page-item"><a class="page-link" href="${action}">Tất cả</a></li>
            <c:forEach begin="1" end="${COUNT}" var="i">

            <c:url value="/" var="pageUrl">
                <c:param name="page" value="${i}"></c:param>
            </c:url>
            <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
            </c:forEach>
    </ul> 
</c:if>


<div class="container" style="margin-top:30px;width:1100px;" >
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
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${JOB}" var="j">
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
                        <a href="<c:url value="/JobDetail/${j.id}"/>" class="btn btn-success">Xem công việc</a>
                        <se:authorize access="hasRole('ROLE_ADMIN')">
                            <button class="btn btn-danger" onclick="delJob('${deleteApi}',${j.id})">Xoá</button>  
                        </se:authorize>       

                    </td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script src="<c:url value="/js/main.js"/>">

</script>
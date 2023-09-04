<%-- 
    Document   : index
    Created on : Aug 15, 2023, 4:50:59 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<ul class="nav nav-pills" style = "background-color : cornflowerblue " >
    <li class="nav-item">
        <div class="nav-link" style="background-color: greenyellow">
            <img src="https://img.icons8.com/?size=512&id=h75QzKozczfv&format=png" style=" height :30px">
            <a style = " color: darkmagenta ; font-size: 20px ; font-weight: 900" href="/">
                Lọc
            </a>

        </div>
    </li>
    <li class="nav-item dropdown">
        <div class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
            <img src="https://img.icons8.com/?size=1x&id=Fed3w16hj37u&format=png" style=" height :30px">
            <a href="#" style="text-decoration: none  ; color: linen ; font-size: 20px ; font-weight: 700" >
                Thành phố
            </a>
            <ul class="dropdown-menu">

                <c:forEach items="${CITY}" var="city">

                    <li>   
                        <a class="dropdown-item" href="${searchCITY}">${city.nameCity}</a>
                    </li>
                </c:forEach>
            </ul>

        </div>
    </li>

    <li class="nav-item dropdown" >
        <div class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
            <img src="https://img.icons8.com/?size=512&id=qSDZIF4neVDE&format=png" style=" height :30px">
            <a href="#" style="text-decoration: none  ; color: linen ; font-size: 20px;font-weight: 700" >
                Quận
            </a>
            <ul class="dropdown-menu">
                <c:forEach items="${DISTRICT}" var="x">
                    <c:url value="/" var="searchDistrict">
                        <c:param name="districtId" value="${x.id}"></c:param>
                    </c:url>
                    <li><a class="dropdown-item" href="${searchDistrict}">${x.nameDistrict}</a></li>
                    </c:forEach>
            </ul>

        </div>
    </li>
    <li class="nav-item dropdown" >
        <div class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
            <img src="https://img.icons8.com/?size=512&id=ScAViD0I8h4B&format=png" style=" height :30px">
            <a href="#" style="text-decoration: none  ; color: linen ; font-size: 20px;font-weight: 700" >
                Nghề nghiệp
            </a>
            <ul class="dropdown-menu">
                <c:forEach items="${MAJOR}" var="m">
                    <c:url value="/" var="searchMajor">
                        <c:param name="majorId" value="${m.id}"></c:param>
                    </c:url>
                    <li><a class="dropdown-item" href="${searchMajor}">${m.nameMajor}</a></li>
                    </c:forEach>
            </ul>

        </div>
    </li>
    <li class="nav-item dropdown">
        <div class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
            <img src="https://img.icons8.com/?size=512&id=9489&format=png" style=" height :30px">
            <a href="#" style="text-decoration: none  ; color: linen ; font-size: 20px;font-weight: 700" >
                Hình thức
            </a>
            <ul class="dropdown-menu">
                <c:forEach items="${TYPEJOB}" var="t">
                    <c:url value="/" var="searchTypeJob">
                        <c:param name="typeJobId" value="${t.id}"></c:param>
                    </c:url>
                    <li><a class="dropdown-item" href="${searchTypeJob}">${t.nameType}</a></li>
                    </c:forEach>

            </ul>

        </div>
    </li>
    <li class="nav-item dropdown" >
        <div class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
            <img src="https://img.icons8.com/?size=512&id=11225&format=png" style=" height :30px">
            <a href="#" style="text-decoration: none  ; color: linen ; font-size: 20px;font-weight: 700" >
                Học vấn
            </a>
            <ul class="dropdown-menu">
                <c:forEach items="${EDUCATION}" var="e">
                    <c:url value="/" var="searchEdu">
                        <c:param name="EduId" value="${e.id}"></c:param>
                    </c:url>
                    <li><a class="dropdown-item" href="${searchEdu}">${e.typeEducation}</a></li>
                    </c:forEach>
            </ul>

        </div>
    </li>
    <li style="margin:auto ; width: 500px">
        <c:url value="/" var="action" />
        <form class="d-flex" action="${action}">
            <input class="form-control me-auto" type="text" name="kw" placeholder="Nhập tên công việc cần tìm .....">
            <button class="btn btn-primary" type="submit">Tìm</button>
        </form>

    </li>
</ul>
           
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
                    <td>${j.employerID.nganhNghe}</td>
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
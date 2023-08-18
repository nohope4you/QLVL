<%-- 
    Document   : index
    Created on : Aug 15, 2023, 4:50:59 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<ul class="nav nav-pills" style = "background-color : cornflowerblue " >
    <li class="nav-item">
        <div class="nav-link" style="background-color: greenyellow">
            <img src="https://img.icons8.com/?size=512&id=h75QzKozczfv&format=png" style=" height :30px">
            <a style = " color: darkmagenta ; font-size: 20px ; font-weight: 900" >
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
                    <li><a class="dropdown-item" href="#">${city.nameCity}</a></li>
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
                    <li><a class="dropdown-item" href="#">${x.nameDistrict}</a></li>
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
                    <li><a class="dropdown-item" href="#">${m.nameMajor}</a></li>
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
                    <li><a class="dropdown-item" href="#">${t.nameType}</a></li>
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
                    <li><a class="dropdown-item" href="#">${e.typeEducation}</a></li>
                    </c:forEach>
            </ul>

        </div>
    </li>
    <li style="margin:auto ; width: 550px">
        <c:url value="/" var="action" />
        <form class="d-flex" action="${action}">
            <input class="form-control me-auto" type="text" placeholder="Nhập tên công ty cần tìm .....">
            <button class="btn btn-primary" type="submit">Tìm</button>
        </form>

    </li>
</ul>



<h2 style="margin-left:400px;">DANH SÁCH VIỆC LÀM</h2>
<a class="btn btn-info " href="<c:url value="/createJob" />"> Thêm Job</a>

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
                    <td>
                        <c:url value="/api/createJob/${j.id}" var="deleteApi" />
                        <a href="<c:url value="/createJob/${j.id}"/>" class="btn btn-success">Xem công việc</a>
                        <button class="btn btn-danger" onclick="delJob('${deleteApi}',${j.id})">Xoá</button>
                    </td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script src="<c:url value="/js/main.js"/>">

</script>
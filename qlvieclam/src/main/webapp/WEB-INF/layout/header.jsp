<%-- 
    Document   : header
    Created on : Aug 16, 2023, 4:43:33 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value="/"/>">Work</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/"/>">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="javascript:void(0)">Hồ sơ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/SignUp" />">Đăng ký</a>
                </li>
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name !=null}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/" />">${pageContext.request.userPrincipal.name}</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/login" />">Đăng nhập</a>
                        </li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </div>
    </div>
</nav>
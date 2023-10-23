<%-- 
    Document   : ListApplication
    Created on : Sep 19, 2023, 1:12:34 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<h2 class="text-center text-info ">DANH SÁCH ĐƠN ỨNG TUYỂN</h2>
<form:form action="${action}"  modelAttribute="Applicationss" method="get"> 
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Mã công việc</th>
                    <th>Họ</th>
                    <th>Tên</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${Applicationss}" var="a">
                    <tr>
                        <td>${a.jobID.id}</td>
                        <td>${a.ho}</td>
                        <td>${a.ten}</td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </form:form>


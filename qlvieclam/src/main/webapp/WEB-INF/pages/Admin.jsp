<%-- 
    Document   : Admin
    Created on : Aug 19, 2023, 2:10:02 PM
    Author     : Admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<se:authorize access="hasRole('ROLE_ADMIN')">
    <div class="container">
    <h2>Quản trị</h2>

    <table class="table table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên nhà tuyển dụng</th>
                  <th>Tên công ty</th>
                <th>Địa chỉ</th>
                <th>Số điện thoại</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${EMP}" var="e">
                <tr>
                    <td>${e.id}</td>
                    <td>${e.nameEmployer}</td>
                    <td>${e.nameCompany}</td>
                    <td>${e.addressComapny}</td>
                    <td>${e.soDienThoai}</td>
                    <td>
                         
                        <a href="<c:url value="/CheckEmployer/${e.id}"/>" class="btn btn-success">Xem thông tin</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>

<script src="<c:url value="/js/main.js"/>">

</script>
</se:authorize>

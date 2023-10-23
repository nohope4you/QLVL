<%-- 
    Document   : ThongKe
    Created on : Aug 20, 2023, 8:48:46 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<se:authorize access="hasRole('ROLE_ADMIN')">
    <div class="container">
        <h2 style="margin-left: 500px;">THỐNG KÊ</h2>
        <form>



            <input class="form-control me-auto" type="number" id="year"  style="margin-bottom: 10px;" required placeholder="Nhập năm cần thống kê .....">

            <button class="btn btn-primary" onClick="showName()" type="button">Thống kê theo năm</button>

            <button class="btn btn-primary" onClick="GetName()" type="button">Thống kê theo số lượng</button>
            <button class="btn btn-primary" onClick="Quy1()" type="button">Quý 1</button>
            <button class="btn btn-primary" onClick="Quy2()" type="button">Quý 2</button>
            <button class="btn btn-primary" onClick="Quy3()" type="button">Quý 3</button>
            <button class="btn btn-primary" onClick="Quy4()" type="button">Quý 4</button>
            <button class="btn btn-primary" onClick="destroy()" type="button">Xoá</button>
            <a href="<c:url value="/generate"/>" class="btn btn-success">Xuát PDF công việc</a>
              <a href="<c:url value="/generateExcel"/>" class="btn btn-success">Xuất Excel công việc</a>
        </form>
        <canvas id="myChart" style="width: auto;">

        </canvas>

    </div>

    <script src="<c:url value="/js/myChart.js"/>">

    </script>

</se:authorize>


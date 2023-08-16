<%-- 
    Document   : createJob
    Created on : Aug 16, 2023, 4:59:02 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2 class="text-center text-info    "">FORM TẠO VIỆC LÀM</h2>

<c:url value="/createJob" var="action" />
<form:form action="${action}"  method="post" modelAttribute="job" enctype="multipart/form-data">
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Tên công việc</label>
        <form:input type="text" path="nameJob" class="form-control" 
                    id="nameJob" placeholder="Tên công việc"/>
    </div>  
    <div class="mb-3">
        <label for="pwd" class="form-label">Mức lương</label>
        <form:input type="text" path="salary" class="form-control" 
                    id="salary" placeholder="Nhập mức lương"/>

    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Số lượng tuyển dụng</label>
        <form:input type="text" path="SoLuongTuyenDung" class="form-control" 
                    id="SoLuongTuyenDung" placeholder="Nhập số lượng tuyển dụng"/>

    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Tuổi</label>
        <form:input type="text" path="Age" class="form-control" 
                    id="Age" placeholder="Nhập độ tuổi cần tuyển"/>
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Kinh nghiệm</label>
        <form:input type="text" path="KinhNghiem" class="form-control" 
                    id="KinhNghiem" placeholder="Nhập độ số năm kinh nghiệm"/>
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Thành phố</label>
        <form:select class="form-select" id="city" name="city" path="cityID">
            <c:forEach items="${CITY}" var="ct">
                <option value="${ct.id}">${ct.nameCity}</option>
            </c:forEach>
        </form:select>


    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Quận/huyện</label>
        <form:select class="form-select" id="district" name="district" path="districID">
            <c:forEach items="${DISTRICT}" var="q">
                <option value="${q.id}">${q.nameDistrict}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Nghề nghiệp tuyển dụng</label>
        <form:select class="form-select" id="district" name="district" path="majorID">
            <c:forEach items="${MAJOR}" var="m">
                <option value="${m.id}">${m.nameMajor}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Trình độ học vấn</label>
        <form:select class="form-select" id="edu" name="edu" path="EducationID">
            <c:forEach items="${EDUCATION}" var="e">
                <option value="${e.id}">${e.typeEducation}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Loại công việc</label>
        <form:select class="form-select" id="typejob" name="typejob" path="typeJobID">
            <c:forEach items="${TYPEJOB}" var="t">
                <option value="${t.id}">${t.nameType}</option>
            </c:forEach>
        </form:select>
    </div>
      <div class="mb-3">
        <label for="file" class="form-label">Ảnh minh hoạ</label>
         <form:input type="file" path="file" class="form-control" 
                    id="file" />
    </div>
    
    

    <button type="submit" class="btn btn-primary">Submit</button>
</form:form>

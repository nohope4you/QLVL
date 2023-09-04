<%-- 
    Document   : createJob
    Created on : Aug 16, 2023, 4:59:02 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2 class="text-center text-info ">CHI TIẾT VIỆC LÀM</h2>

<div class="container col-md-8">
    <c:url value="/createJob" var="action" />
<form:form action="${action}"  method="post" modelAttribute="job" enctype="multipart/form-data">
   
    <form:hidden path="id" />
    <form:hidden path="avatarJob"/>

    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Tên công việc</label>
         <form:errors path="nameJob" element="div" cssClass="text-danger" />
        <form:input type="text" path="nameJob" class="form-control"
                    id="nameJob" placeholder="Tên công việc"/>
        
    </div>  
    
    <div class="mb-3">
        <label for="pwd" class="form-label">Mức lương</label>
          <form:errors path="salary" element="div" cssClass="text-danger" />
        <form:input type="number" path="salary" class="form-control" 
                    id="salary" placeholder="Nhập mức lương"/>

    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Số lượng tuyển dụng</label>
        <form:input type="number" path="SoLuongTuyenDung" class="form-control" 
                    id="SoLuongTuyenDung" placeholder="Nhập số lượng tuyển dụng"/>

    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Tuổi</label>
        <form:input type="number" path="Age" class="form-control" 
                    id="Age" placeholder="Nhập độ tuổi cần tuyển"/>
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Kinh nghiệm</label>
        <form:input type="number" path="KinhNghiem" class="form-control" 
                    id="KinhNghiem" placeholder="Nhập độ số năm kinh nghiệm"/>
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Thành phố</label>
        <form:select class="form-select" id="city" name="city" path="cityID">
            <c:forEach items="${CITY}" var="ct">
                <c:choose>
                    <c:when test="${ct.id==job.cityID.id}">
                        <option value="${ct.id}" selected>${ct.nameCity}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${ct.id}" >${ct.nameCity}</option>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
        </form:select>


    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Quận/huyện</label>
        <form:select class="form-select" id="district" name="district" path="districID">
            <c:forEach items="${DISTRICT}" var="q">
                <c:choose>
                    <c:when test="${q.id==job.districID.id}">
                        <option value="${q.id}" selected>${q.nameDistrict}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${q.id}">${q.nameDistrict}</option>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
        </form:select>
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Nghề nghiệp tuyển dụng</label>
        <form:select class="form-select" id="majorID" name="majorID" path="majorID">
            <c:forEach items="${MAJOR}" var="m">
                <c:choose>
                    <c:when test="${m.id==job.majorID.id}">
                        <option value="${m.id}" selected>${m.nameMajor}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${m.id}">${m.nameMajor}</option>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
        </form:select>
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Trình độ học vấn</label>
        <form:select class="form-select" id="edu" name="edu" path="educationID">
            <c:forEach items="${EDUCATION}" var="e">      
                <c:choose>
                    <c:when test="${e.id==job.educationID.id}">
                        <option value="${e.id}" selected>${e.typeEducation}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${e.id}">${e.typeEducation}</option>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
        </form:select>
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Loại công việc</label>
        <form:select class="form-select" id="typejob" name="typejob" path="typeJobID">
            <c:forEach items="${TYPEJOB}" var="t">
                <c:choose>
                    <c:when test="${t.id==job.typeJobID.id}">
                        <option value="${t.id}" selected>${t.nameType}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${t.id}">${t.nameType}</option>
                    </c:otherwise>
                </c:choose>




            </c:forEach>
        </form:select>
    </div>
    <div class="mb-3">
        <label for="file" class="form-label">Ảnh minh hoạ</label>
        <form:input type="file" path="file" class="form-control" 
                    id="file" />
    </div>
    <c:if test="${not empty message}">
        <div class="alert alert-danger">
            ${message}
        </div>
    </c:if>



    <button type="submit" class="btn btn-primary">
        <c:choose>
            <c:when test="${job.id==null}">
                Thêm sản phẩm
            </c:when>
            <c:otherwise>
                Cập nhật sản phẩm
            </c:otherwise>
        </c:choose>
    </button>

</form:form>


</div>

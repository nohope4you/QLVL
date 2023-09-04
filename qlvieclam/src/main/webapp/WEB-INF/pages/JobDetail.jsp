<%-- 
    Document   : JobDetail
    Created on : Aug 18, 2023, 9:05:23 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<h2 class="text-center text-info ">FORM CHI TIẾT VIỆC LÀM</h2>

<c:url value="/JobDetail/" var="action" />
<form:form action="${action}"  method="post" modelAttribute="JD" enctype="multipart/form-data">
    <div class="container">
   <form:errors path="*" element="div"  cssClass="alert alert-danger" />
    <form:hidden path="id" />
    <form:hidden path="avatarJob"/>
    <label for="file" class="form-label" >Mã số công việc: <div style="float: right;" >${JD.id}</div> </label>
      <br>
    <label for="email" class="form-label">Hình ảnh minh hoạ</label>
    <div><img  src="${JD.avatarJob}" width="120"/></div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Tên công việc</label>
        <form:input type="text" path="nameJob" class="form-control" 
                    id="nameJob" disabled="true" placeholder="Tên công việc" />
    </div>  
    <form:errors path="nameJob" element="div"  cssClass="text-danger" />
    <div class="mb-3">
        <label for="pwd" class="form-label">Mức lương</label>
        <form:input type="text" path="salary" class="form-control" 
                    id="salary" disabled="true" placeholder="Nhập mức lương"/>

    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Số lượng tuyển dụng</label>
        <form:input type="text" path="SoLuongTuyenDung" class="form-control" 
                    id="SoLuongTuyenDung" disabled="true" placeholder="Nhập số lượng tuyển dụng"/>

    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Tuổi</label>
        <form:input type="text" path="Age" class="form-control" 
                    id="Age" disabled="true" placeholder="Nhập độ tuổi cần tuyển"/>
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Kinh nghiệm</label>
        <form:input type="text" path="KinhNghiem" class="form-control" 
                    id="KinhNghiem" disabled="true" placeholder="Nhập độ số năm kinh nghiệm"/>
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Thành phố</label>
        <form:select class="form-select" id="city" name="city" disabled="true" path="cityID">
            <c:forEach items="${CITY}" var="ct">
                <c:choose>
                    <c:when test="${ct.id==JD.cityID.id}">
                        <option value="${ct.id}" selected >${ct.nameCity}</option>
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
        <form:select class="form-select" id="district" name="district" disabled="true" path="districID">
            <c:forEach items="${DISTRICT}" var="q">
                <c:choose>
                    <c:when test="${q.id==JD.districID.id}">
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
        <form:select class="form-select" id="district" name="district" disabled="true" path="majorID">
            <c:forEach items="${MAJOR}" var="m">
                <c:choose>
                    <c:when test="${m.id==JD.majorID.id}">
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
        <form:select class="form-select" id="edu" name="edu" disabled="true" path="educationID">
            <c:forEach items="${EDUCATION}" var="e">      
                <c:choose>
                    <c:when test="${e.id==JD.educationID.id}">
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
        <form:select class="form-select" id="typejob" name="typejob" disabled="true" path="typeJobID">
            <c:forEach items="${TYPEJOB}" var="t">
                <c:choose>
                    <c:when test="${t.id==JD.typeJobID.id}">
                        <option value="${t.id}" selected>${t.nameType}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${t.id}">${t.nameType}</option>
                    </c:otherwise>
                </c:choose>




            </c:forEach>
        </form:select>
    </div>

    <se:authorize access="hasRole('ROLE_USER')">
         <a href="<c:url value="/Application/${JD.id}"/>"style="margin-left:500px; "  class="btn btn-primary">Ứng tuyển</a>
    </se:authorize>
    <c:choose>
        <c:when test="${pageContext.request.userPrincipal.name ==null}">
            <a href="<c:url value="/login"/>" style="margin-left:300px;" class="btn btn-primary">Đăng nhập</a>
        </c:when>
    </c:choose>
              <a href="<c:url value="/"/>"  class="btn btn-primary">Trở về</a>

    </div>
    
</form:form>



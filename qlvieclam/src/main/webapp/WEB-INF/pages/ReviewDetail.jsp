<%-- 
    Document   : ReviewDetail
    Created on : Aug 24, 2023, 12:43:51 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/ReviewDetail" var="action" />
<form:form action="${action}"  modelAttribute="REVIEW" method="post">  
    ${EMPLOYER.id}
    <form:hidden path="employerID.id" value=" ${EMPLOYER.id}"/>
    <div class="mb-3">
        <label for="cmt" class="form-label">Bình luận</label>
        <form:textarea  path="cmt" class="form-control" 
                        id="cmt" />
    </div>
    <div class="mb-3">
        <label for="rating" class="form-label">Mức đánh giá</label>
        <form:input  path="rating" class="form-control" placeholder="Ví dụ: 2"
                     id="rating" />
    </div>
    <c:choose>
        <c:when test="${pageContext.request.userPrincipal.name ==null}">
            <a href="<c:url value="/login"/>" style="margin-left:300px;" class="btn btn-primary">Đăng nhập</a>
        </c:when>
        <c:otherwise>
             <button type="submit" class="btn btn-primary">Đánh giá</button>
        </c:otherwise>
    </c:choose>
   
</form:form>
<form:form action="${action}"  modelAttribute="ALLREVIEW" method="post"> 
     <table class="table table-hover">
        <thead>
            <tr>
                
                <th>Bình luận</th>
                  <th>Đánh giá</th>
               
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${ALLREVIEW}" var="e">
                <tr>
                    <td>${e.cmt}</td>
                    <td>${e.rating}</td>
                   
                  
                </tr>
            </c:forEach>
        </tbody>
    </table>
</form:form>
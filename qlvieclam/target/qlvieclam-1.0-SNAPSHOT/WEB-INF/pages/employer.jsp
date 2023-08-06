<%-- 
    Document   : employer
    Created on : Aug 6, 2023, 10:45:39 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="text-align:center">Đăng ký nhà tuyển dụng</h1>
        
         <div class="container-fluid" style="width:500px;">
            <form action="/action_page.php">
                <div class="mb-3 mt-3">
                    <label for="email" class="form-label">Tên công ty</label>
                    <input type="email" class="form-control" id="account" placeholder="Enter email" name="email">
                </div>
                <div class="mb-3">
                    <label for="pwd" class="form-label">Địa chỉ cơ sở</label>
                    <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd">
                </div>
                <div class="mb-3">
                    <label for="pwd" class="form-label">Số điện thoại</label>
                    <input type="password" class="form-control" id="pass" placeholder="Enter password" name="pswd">
                </div>
              <div class="mb-3">
                    <label for="pwd" class="form-label">Tên nhà tuyển dụng</label>
                    <input type="password" class="form-control" id="pass" placeholder="Enter password" name="pswd">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>

    </body>
</html>

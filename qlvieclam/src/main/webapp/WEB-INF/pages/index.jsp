<%-- 
    Document   : index
    Created on : Aug 6, 2023, 9:51:28 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>

        <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="javascript:void(0)">Work</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="mynavbar">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">Hồ sơ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">Đăng ký</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">Đăng nhập</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        
                <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="javascript:void(0)">Work</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="mynavbar">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">Đăng tin tuyển dụng</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">Đánh giá</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">Tìm ứng viên</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        
                        <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="javascript:void(0)">Work</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="mynavbar">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">Thống kê</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

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
                        <li><a class="dropdown-item" href="#">Link 1</a></li>
                        <li><a class="dropdown-item" href="#">Link 2</a></li>
                        <li><a class="dropdown-item" href="#">Link 3</a></li>
                        <li><a class="dropdown-item-text" href="#">Text Link</a></li>
                        <li><span class="dropdown-item-text">Just Text</span></li>
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
                        <li><a class="dropdown-item" href="#">Link 1</a></li>
                        <li><a class="dropdown-item" href="#">Link 2</a></li>
                        <li><a class="dropdown-item" href="#">Link 3</a></li>
                        <li><a class="dropdown-item-text" href="#">Text Link</a></li>
                        <li><span class="dropdown-item-text">Just Text</span></li>
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
                        <li><a class="dropdown-item" href="#">Link 1</a></li>
                        <li><a class="dropdown-item" href="#">Link 2</a></li>
                        <li><a class="dropdown-item" href="#">Link 3</a></li>
                        <li><a class="dropdown-item-text" href="#">Text Link</a></li>
                        <li><span class="dropdown-item-text">Just Text</span></li>
                    </ul>

                </div>
            </li>
            <li class="nav-item dropdown">
                <div class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                    <img src="https://img.icons8.com/?size=512&id=70052&format=png" style=" height :30px">
                    <a href="#" style="text-decoration: none  ; color: linen ; font-size: 20px;font-weight: 700" >
                        Tuổi
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#"> tuổi <= 18 </a></li>
                        <li><a class="dropdown-item" href="#">18 <= tuổi <= 30</a></li>
                        <li><a class="dropdown-item" href="#"> tuổi >= 30 </a></li>
                    </ul>

                </div>
            </li>
            <li class="nav-item dropdown" >
                <div class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                    <img src="https://img.icons8.com/?size=512&id=LVPdJpaboyzj&format=png" style=" height :30px">
                    <a href="#" style="text-decoration: none  ; color: linen ; font-size: 20px;font-weight: 700" >
                        Kinh nghiệm
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Link 1</a></li>
                        <li><a class="dropdown-item" href="#">Link 2</a></li>
                        <li><a class="dropdown-item" href="#">Link 3</a></li>
                        <li><a class="dropdown-item-text" href="#">Text Link</a></li>
                        <li><span class="dropdown-item-text">Just Text</span></li>
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
                        <li><a class="dropdown-item" href="#">Link 1</a></li>
                        <li><a class="dropdown-item" href="#">Link 2</a></li>
                        <li><a class="dropdown-item" href="#">Link 3</a></li>
                        <li><a class="dropdown-item-text" href="#">Text Link</a></li>
                        <li><span class="dropdown-item-text">Just Text</span></li>
                    </ul>

                </div>
            </li>
            <li style="margin:auto ; width: 350px">
                <form class="d-flex">
                    <input class="form-control me-auto" type="text" placeholder="Nhập tên công ty cần tìm .....">
                </form>
            </li>
        </ul>

        <%--Nhà tuyển dụng--%>
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
                        <li><a class="dropdown-item" href="#">Link 1</a></li>
                        <li><a class="dropdown-item" href="#">Link 2</a></li>
                        <li><a class="dropdown-item" href="#">Link 3</a></li>
                        <li><a class="dropdown-item-text" href="#">Text Link</a></li>
                        <li><span class="dropdown-item-text">Just Text</span></li>
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
                        <li><a class="dropdown-item" href="#">Link 1</a></li>
                        <li><a class="dropdown-item" href="#">Link 2</a></li>
                        <li><a class="dropdown-item" href="#">Link 3</a></li>
                        <li><a class="dropdown-item-text" href="#">Text Link</a></li>
                        <li><span class="dropdown-item-text">Just Text</span></li>
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
                        <li><a class="dropdown-item" href="#">Link 1</a></li>
                        <li><a class="dropdown-item" href="#">Link 2</a></li>
                        <li><a class="dropdown-item" href="#">Link 3</a></li>
                        <li><a class="dropdown-item-text" href="#">Text Link</a></li>
                        <li><span class="dropdown-item-text">Just Text</span></li>
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
                        <li><a class="dropdown-item" href="#">Link 1</a></li>
                        <li><a class="dropdown-item" href="#">Link 2</a></li>
                        <li><a class="dropdown-item" href="#">Link 3</a></li>
                        <li><a class="dropdown-item-text" href="#">Text Link</a></li>
                        <li><span class="dropdown-item-text">Just Text</span></li>
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
                        <li><a class="dropdown-item" href="#">Link 1</a></li>
                        <li><a class="dropdown-item" href="#">Link 2</a></li>
                        <li><a class="dropdown-item" href="#">Link 3</a></li>
                        <li><a class="dropdown-item-text" href="#">Text Link</a></li>
                        <li><span class="dropdown-item-text">Just Text</span></li>
                    </ul>

                </div>
            </li>
            <li style="margin:auto ; width: 550px">
                <form class="d-flex">
                    <input class="form-control me-auto" type="text" placeholder="Nhập tên công ty cần tìm .....">
                </form>
            </li>
        </ul>

<div class="container mt-3">
  <h2>Textarea</h2>
  <p>Use the .form-control class to style textareas as well:</p>
  <form action="/action_page.php">
    <div class="mb-3 mt-3">
      <label for="comment">Comments:</label>
      <textarea class="form-control" rows="5" id="comment" name="text"></textarea>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>
        
        <div class="form-check">
  <input type="radio" class="form-check-input" id="radio1" name="optradio" value="option1" checked>Option 1
  <label class="form-check-label" for="radio1"></label>
</div>
<div class="form-check">
  <input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2">Option 2
  <label class="form-check-label" for="radio2"></label>
</div>
<div class="form-check">
  <input type="radio" class="form-check-input" disabled>Option 3
  <label class="form-check-label"></label>
</div>

    </body>



</html>

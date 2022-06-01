<%-- 
    Document   : login
    Created on : May 29, 2022, 8:03:39 PM
    Author     : LENOVO
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous"
            />
        <title>Đăng nhập</title>
        <link rel="stylesheet" href="style/style.css">
        <link rel="stylesheet" href="style/queries.css">
    </head>
    <body>
        <!-- Header -->
        <div class="container-fluid">
            <div class="">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <a class="navbar-brand" href="/index.jsp"> <img src="../assets/img/logo.jpg" alt="anh" /></a>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="/">Trang chủ <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item active">
                                    <a class="nav-link" href="/postBlog" >Đăng bài viết <span class="sr-only">(current)</span></a>
                            </li>
                        </ul>
                        <form action="/blogs" accept-charset="" class="form-inline my-2 my-lg-0">
                            <input class="form-control mr-sm-2" type="search" name="q" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                        <div  class="my-2 my-lg-0 d-flex align-items-center">
                            <a href='/login'> <button   class='btn btn-outline-success my-2 my-sm-0 mr-2' type='button'> Đăng nhập</button></a>
                            <a href='/register'> <button class='btn my-2 my-sm-0' type='button'>Đăng ký</button></a>
                        </div>
                    </div>
                </nav>
                <!-- body -->
                <div  class="col-sm-12 justify-content-center" style="margin: 20%;">
                    <div class="form ">
                        <form action="/login" method="post">
                            <h3 class="form__title justify-content-center">Đăng nhập</h3>
                            <input type="text" name="username" autocomplete="off" placeholder="Tài khoản" style="width: 50%"/> <br/>
                            <input type="password" name="password"  autocomplete="off" placeholder="Mật khẩu" style="width: 50%"/> <br/><br/>

                            <button type="submit" class="Form__btn btn btn-warning mr-2">Đăng nhập</button>
                            <a class="form__signUp" href="/register">Tạo tài khoản</a>
                            <p class="form__alert--warning"> ${loginError}</p>
                            <p class="form__alert--success">    ${regSuccess}</p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>


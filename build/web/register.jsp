<%-- 
    Document   : register
    Created on : May 29, 2022, 9:36:07 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous"
            />
        <title>Đăng ký</title>
        <link rel="stylesheet" href="style/style.css" />
        <link rel="stylesheet" href="style/queries.css" />
    </head>
    <body>
        <div class="container-fluid">
            <div class="">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <a class="navbar-brand" href="/index.jsp"> <img src="assets/img/logo.jpg" alt="" style="height:16px;"/></a>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="/">Trang chủ <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item active">
                                    <a class="nav-link" href="/postBlog" >Đăng bài viết <span class="sr-only">(current)</span></a>
                            </li>

                        </ul>
                        <form action="/Blogs" accept-charset="" class="form-inline my-2 my-lg-0">
                            <input class="form-control mr-sm-2" type="search" name="q" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                        <div  class="my-2 my-lg-0 d-flex align-items-center">
                            <a href='/login'> <button   class='btn btn-outline-success my-2 my-sm-0 mr-2' type='button'> Đăng nhập</button></a>
                            <a href='/register'> <button class='btn my-2 my-sm-0' type='button'>Đăng ký</button></a>
                        </div>
                    </div>
                </nav>
           
                <div class="container" style="margin-top: 20%">
            <div class="row justify-content-center ">
                <div class="form justify-content-center" style="width:600px">
                        <form action="/register" method="post">
                            <h3 class="form__title">Đăng ký</h3>
                            <input type="text"  name="username"  autocomplete="off"   placeholder="Tài khoản" style="width:100%"/>
                            <br />
                            <input type="password"  name="password"  autocomplete="off" placeholder="Mật khẩu" style="width:100%"/>
                            <br />
                            <input  type="password"   name="repass" autocomplete="off" placeholder="Nhập lại mật khẩu" style="width:100%"/>
                            <br />
                            <input  type="text"  name="name" autocomplete="off" placeholder="Tên" style="width:100%"/>
                            <br /><br />
                            <button type="submit" class="Form__btn btn btn-warning mr-2"> Đăng ký </button>
                            <a class="" href="login">Đăng nhập</a>

                            <p class="form__alert--warning">${regError}</p>
                        </form>
                    </div>
                
            </div>
        </div>
    </body>
</html>

<%-- 
    Document   : blogdetail
    Created on : May 30, 2022, 4:05:57 AM
    Author     : LENOVO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${blog.title}</title>
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous"
            />
        <link
            rel="stylesheet"
            href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
            integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="style/style.css">
        <link rel="stylesheet" href="style/queries.css">
    </head>
    <body>
        <!-- Header -->
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12">
                    <nav class="navbar navbar-expand-lg navbar-light bg-light">
                        <a class="navbar-brand" href="/index.jsp"><img src="../assets/img/logo.jpg" alt=""/></a>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item active">
                                    <a class="nav-link" href="/blogs" >Trang chủ <span class="sr-only">(current)</span></a>
                                </li>
                                <li class="nav-item active">
                                    <a class="nav-link" href="/postBlog" >Đăng bài viết <span class="sr-only">(current)</span></a>
                                </li>
                            </ul>
                            <form action="/blogs" accept-charset="" class="form-inline my-2 my-lg-0">
                                <input class="form-control mr-sm-2" type="search" name="q" placeholder="Search" aria-label="Search">
                                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                            </form>
                            <div class="my-2 my-lg-0 d-flex align-items-center">
                                <%
                                    String username = (String) session.getAttribute("user_name");
                                    if (username == null) {
                                %>            
                                <a href='/login.jsp'> <button class='btn btn-outline-success my-2 my-sm-0 mr-2' type='button'> Đăng nhập </button></a>
                                <a href='register.jsp'> <button class='btn my-2 my-sm-0' type='button'>Đăng ký</button></a>
                                <%
                                } else {
                                %>
                                <a  href='#'><i class='navbar__account fas fa-user-circle mr-2' style="font-size: 20px">${user_name}</i></a>
                                <form action='/logout'>
                                    <button class='btn btn-outline-warning my-2 my-sm-0 mr-2' type='submit'/> Đăng xuất </button>
                                </form> 
                                <%
                                    }
                                %>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
            <div class="row mb-5">
                <div class="col-6"> <img width="300" src="../assets/img/${blog.img}" alt="ảnh" />
                    <p>
                        <strong>
                            ${blog.title}
                        </strong>
                    </p>   
                    <br/>
                    <p>${blog.content}</p></div>
            </div>
            <div class="row mb-5">
                <div class="col-6">     
                    <br/>
                    <br/>
                    <form action="/comment" method="post">
                        <input name="blogid" value="${blog.id}" type="hidden">

                        <input name="content" type="text">
                        <button type="submit" class="btn btn-primary">Bình luận</button>

                    </form></div>
            </div>
            <div class="row mb-5">
                <div class="col-12">  
                    <c:forEach items="${blog.comments}" var="comment">
                        <div class="d-flex">

                            <p  class="mr-2"><strong>${comment.user.name }</strong> </p>

                            <p >${comment.content } </p>
                        </div>
                    </c:forEach>
                </div>
            </div>

        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>

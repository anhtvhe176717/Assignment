<%-- 
    Document   : login
    Created on : Nov 3, 2023, 11:18:38 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Website HR</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Website</title>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

        <style>
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap');
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: "Poppins", sans-serif;
            }

            body {
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
                background: url('img/Web.png') no-repeat;
                background-size: cover;
                background-position: center;
            }

            .wrapper {
                width: 420px;
                background: transparent;
                border: 2px solid rgba(255, 255, 255, .2);
                backdrop-filter: blur(20px);
                box-shadow: 0 0 10px rgba(0, 0, 0, .2);
                color: #fff;
                border-radius: 10px;
                padding: 30px 40px;
            }

            .wrapper h1 {
                font-size: 36px;
                text-align: center;
            }
            .wrapper h3 {
                font-size: 20px;
                text-align: center;
                color: red;
            }

            .wrapper .input-box {
                position: relative;
                width: 100%;
                height: 50px;
                margin: 30px 0;
            }

            .input-box input {
                width: 100%;
                height: 100%;
                background: transparent;
                border: none;
                outline: none;
                border: 2px solid rgba(255, 255, 255, .2);
                border-radius: 40px;
                font-size: 16px;
                color: #fff;
                padding: 20px 45px 20px 20px;
            }

            .input-box input::placeholder {
                color: #fff;
            }

            .input-box i {
                position: absolute;
                right: 20px;
                top: 50%;
                transform: translateY(-50%);
                font-size: 20px;
                color: rgba(25, 22, 51, 0.884);
            }

            .wrapper .remember-forgot {
                display: flex;
                justify-content: space-between;
                font-size: 14.5px;
                margin: -15px 0 15px;
            }

            .remember-forgot label input {
                accent-color: #fff;
                margin-right: 3px;
            }

            .wrapper .btn {
                width: 100%;
                height: 45px;
                border: none;
                outline: none;
                border-radius: 40px;
                box-shadow: 0 0 10px rgba(0, 0, 0, .1);
                cursor: pointer;
                font-size: 16px;
                color: #333;
                font-weight: 600;
            }
        </style>
    </head>
    <body>
        <div class="wrapper">
            <form action="login" method="post">
                <h1>Welcome</h1>
                <div class="input-box">
                    <c:set var="cookie" value="${pageContext.request.cookies}"/>
                    <input type="text" placeholder="Username" name="user" value="${cookie.cuser.value}" required>
                    <i class='bx bxs-user'></i>
                </div>

                <div class="input-box">
                    <input type="password" placeholder="Password" name="pass" value="${cookie.cpass.value}" required>
                    <i class='bx bxs-lock-alt'></i>
                </div>

                <div class="remember-forgot">
                    <label><input type="checkbox" ${(cookie.crem!=null?'checked':'')} name="rem" value="ON"> Remember me</label>
                </div>

                <button type="submit" class="btn">Login</button><br/><br/>
                        <h3>${requestScope.error}</h3>

            </form>
        </div>
    </body>
</html>

<%-- 
    Document   : add
    Created on : Nov 4, 2023, 2:27:04 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add New Personnel</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap');
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                position: relative;
                width: 100%;
                min-height: 150vh;
            }

            nav {
                font-family: 'Poppins', sans-serif;
                position: fixed;
                width: 250px;
                height: 100%;
                background: #f1f1f1;
                display: flex;
                align-items: center;
                border-right: 1px solid rgba(0, 0, 0, .1);
                z-index: 1000;
                transition: ease-in-out 0.5s;
            }

            nav.hide {
                width: 0;
            }

            nav ul {
                width: 100%;
                list-style: none;
                overflow: hidden;
            }

            nav ul li a {
                width: 100%;
                color: #1e90ff;
                font-size: 1.2em;
                text-decoration: none;
                display: inline-flex;
                align-items: center;
                padding: 15px;
                transition: linear 0.5s;
            }

            nav ul li a ion-icon {
                margin: 0 20px;
                color: #1e90ff;
                font-size: 1.2em;
                transition: linear 0.2s;
            }

            nav ul li a:hover {
                background: #1e90ff;
                color: white;
            }

            nav ul li a:hover ion-icon {
                color: white;
            }

            .content {
                position: absolute;
                top: 0;
                left: 250px;
                width: calc(100% - 250px);
                min-height: 110vh;
                display: flex;
                justify-content: center;
                align-items: center;
                padding: 20px;
                transition: ease-in-out 0.5s;
            }

            .content h2 {
                font-size: 4.5em;
                color: #1e90ff;
                text-transform: uppercase;
            }

            .content.expand {
                width: 100%;
                left: 0;
            }

            nav ul li h2 {
                text-align: center;
                /* Căn giữa nội dung trong thẻ h1 */
                font-weight: bold;
                /* Tạo đậm cho chữ "Hello" */
                font-size: 1.5em;
                /* Đặt kích thước cho chữ "Hello" */
                margin: 0;
                /* Loại bỏ khoảng cách ở trên và dưới h1 */
                color: tomato;
            }

            nav .toggle_menu {
                position: absolute;
                top: 20px;
                right: -46px;
                width: 45px;
                height: 45px;
                display: flex;
                justify-content: center;
                align-items: center;
                background: #f1f1f1;
                border-radius: 0 10px 10px 0;
                cursor: pointer;
                transition: linear 0.2s;
            }

            nav .toggle_menu ion-icon {
                color: #1e90ff;
                font-size: 1.5em;
                transition: linear 0.2s;
            }

            nav .toggle_menu:hover {
                background: #1e90ff;
            }

            nav .toggle_menu:hover ion-icon {
                color: white;
            }
            .form-container {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                font-weight: bold;
                width: 45%;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                background-color: #f9f9f9;
            }

            label {
                display: block;
                margin-bottom: 10px;
            }

            select,
            input,
            label {
                width: 95%;
                padding: 10px;
                margin-bottom: 10px;
                margin-left: 16px;
            }

            .type {
                font-size: 10%;
            }

            input[type="radio"] {
                margin: 0 10px 0 0;
            }

            .radio-label {
                display: inline-block;
                margin-right: 20px;
            }

            .btn-container {
                width: 98%;
                text-align: center;

            }

            .btn-container h3{
                width: 100%;
                text-align: center;
                color: red;
            }

            .btn-add {
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 5px;
                /*padding: ;*/
                cursor: pointer;
                /*text-align: center;*/
                /*justify-content: center;*/
                /*display: flex;*/
            }

            .form-container select {
                width: 95%;
            }

        </style>
        <script>
            function limitInputLength(input, maxLength) {
                if (input.value.length > maxLength) {
                    input.value = input.value.slice(0, maxLength); // Cắt chuỗi ngắn lại nếu nó dài hơn maxLength
                }
            }
        </script>
        
    </head>
    <body>
        <nav>
            <div class="toggle_menu">
                <ion-icon name="menu-outline"></ion-icon>

            </div>
            <ul>
                <li>

                    <a href="home">
                        <ion-icon name="home-outline"></ion-icon> Home</a>
                </li>
                <li>
                    <a href="personnel">
                        <ion-icon name="people-outline"></ion-icon>
                        Personnel</a>
                </li>
                <li>
                    <a href="department">
                        <ion-icon name="podium-outline"></ion-icon>
                        Department</a>
                </li>
                <li>
                    <a href="project">
                        <ion-icon name="logo-angular"></ion-icon>
                        Project</a>
                </li>
                <li>
                    <a href="login">
                        <ion-icon name="log-out-outline"></ion-icon>
                        Log Out</a>
                </li>
            </ul>
        </nav>

        <section class="content">
            <div class="form-container">
                <form action="addperson" method="post">
                    <label for="name">Personnel Name:</label>
                    <input class="type" type="text" pattern="^[A-Za-z\s\u0080-\uFFFF]+$" title="Vui lòng nhập chỉ các ký tự chữ" id="name" name="name" required>

                    <label for="department">Department:</label>
                    <select id="department" name="department">
                        <c:forEach items="${requestScope.listd}" var="d">
                            <option value="${d.codedepart}">${d.departname}</option>
                        </c:forEach>
                    </select>

                    <label for="sex">Gender:</label>
                    <div class="radio-label">
                        <input type="radio" id="male" name="sex" value="true" required>
                        <label for="male">Male</label>
                    </div>
                    <div class="radio-label">
                        <input type="radio" id="female" name="sex" value="false" required>
                        <label for="female">Female</label>
                    </div>

                    <label for="birthdate">BirthDate:</label>
                    <input type="date" id="birthdate" name="birthdate" required>

                    <label for="phone">Phone Number:</label>
                    <input type="number" id="phone" name="phone" oninput="limitInputLength(this, 10)" required>

                    <label for="role">Role:</label>
                    <select id="role" name="role">
                        <c:forEach items="${requestScope.listr}" var="ro">
                            <option value="${ro.id}">${ro.rolename}</option>
                        </c:forEach>
                    </select><br/><br/>



                    <div class="btn-container">
                        <input type="submit" class="btn-add" value="Add New Person">
                        <h3>${requestScope.err}</h3>

                    </div>
                </form>
            </div>
        </section>
    </body>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <script>
            const nav = document.querySelector('nav');
            const toggle_menu = document.querySelector('.toggle_menu');
            const content = document.querySelector('.content');
            toggle_menu.onclick = function () {
                nav.classList.toggle('hide');
                content.classList.toggle('expand');
            };
    </script>
</html>

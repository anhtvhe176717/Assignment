<%-- 
    Document   : home
    Created on : Nov 1, 2023, 4:34:45 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap');
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: 'Poppins', sans-serif;
            }

            body {
                position: relative;
                width: 100%;
                min-height: 150vh;
            }

            nav {
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
                min-height: 100vh;
                display: flex;
                justify-content: center;
                align-items: center;
                padding: 20px;
                transition: ease-in-out 0.5s;
                background: url('img/Home.jpg') no-repeat;
                background-size: 100%;
                background-position: center;

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
            footer {
                position: absolute;
                bottom: 0;
                left: 250px;
                width: calc(100% - 250px);
                transition: ease-in-out 0.5s;
                background-size: 100%;
                background-color: #333;
                color: #fff;
                padding: 20px 0;
            }

            .footer-content {
                display: flex;
                justify-content: space-around;
                align-items: center;
                max-width: 1200px;
                margin: 0 auto;
                padding: 0 20px;
            }

            .footer-logo img {
                width: 100px;
                height: auto;
            }

            .footer-info p {
                margin: 5px 0;
            }
            footer.expand {
                width: 100%;
                left:0;
            }

        </style>
    </head>
    <body>
        

        <div>
            <nav>
                <div class="toggle_menu">
                    <ion-icon name="menu-outline"></ion-icon>

                </div>
                <ul>
                    <li>
                        <h2>Hello ${sessionScope.account.username}</h2>
                    </li> 
                    <li>

                        <a href="home">
                            <ion-icon name="home-outline"></ion-icon> Home</a>
                    </li>
                    <li>
                        <a href="personnel" method="get">
                            <ion-icon name="people-outline"></ion-icon>
                            Personnel</a>
                    </li>
                    <li>
                        <a href="department">
                            <!--<ion-icon name="business-outline"></ion-icon>-->
                            <ion-icon name="podium-outline"></ion-icon>
                            Department</a>
                    </li>
                    <li>
                        <a href="project">
                            <!--<ion-icon name="business-outline"></ion-icon>-->
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
        </div>
        <section class="content">

        </section>

        <div>
            <footer>
                <div class="footer-content">
                    <div class="footer-logo">
                        <img src="img/logo.jpg" alt="Logo">
                    </div>
                    <div class="footer-info">
                        <p>&copy; 2023 Human resource management website</p>

                    </div>
                </div>
            </footer>
        </div>
    </body>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <script>
        const nav = document.querySelector('nav');
        const toggle_menu = document.querySelector('.toggle_menu');
        const content = document.querySelector('.content');
        const footer = document.querySelector('footer');

        toggle_menu.onclick = function () {
            nav.classList.toggle('hide');
            content.classList.toggle('expand');
            footer.classList.toggle('expand');
        }
    </script>
</html>

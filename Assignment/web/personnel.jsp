<%-- 
    Document   : personnel
    Created on : Nov 3, 2023, 5:12:36 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Personnel</title>
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
                /*min-height: 100vh;*/
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
            .container {
                display: flex;
                align-items: center;
            }

            .image {
                flex: 1;
                padding: 20px;
            }

            .student-id {
                font-size: 20px;
                font-weight: bold;
            }

            .info {
                flex: 2;
                padding: 20px;
            }

            .info p {
                margin: 0;
            }

            .search-bar {
                width: 100%;
                display: flex;
                /* justify-content: space-between;   */
                background-color: #f0f0f0; /* Màu nền của dòng đầu tiên */
                padding: 10px; /* Khoảng cách giữa nội dung và viền dòng đầu tiên */
            }

            .search-input {
                flex: 1;
                margin-right: 10px;
                width: 200px; /* Độ rộng của ô nhập */
                padding: 5px; /* Khoảng cách bên trong ô nhập */
            }

            .search-button {
                background-color: #007bff;
                color: #fff;
                border: none;
                padding: 10px 20px;
                cursor: pointer;
                border-radius: 5px;
            }
            .search-button a{
                /*background-color: #1e90ff;*/
                color: #fff;
                border: none;
                padding: 10px 20px;
                cursor: pointer;
                border-radius: 5px;
            }


            .search-button:hover {
                background-color: #0056b3;
            }

            .add-button {
                background-color: #007bff;
                color: #fff;
                border: none;
                padding: 10px 20px;
                cursor: pointer;
                border-radius: 5px;
                text-decoration: none;
            }

            .add-button:hover {
                background-color: #0056b3;
            }

            table {
                width: 100%;
                /*border-collapse: collapse;*/
                /*border: 10px;*/
            }


            td {
                padding: 8px;
                text-align: left;
            }

            th {
                background-color: #f2f2f2;
            }

            tr {
                background-color: #f0f0f0;
            }

            tr td {
                padding: 10px;
            }

            tr td img {
                border: 1px solid #000;
                /*border-radius: 50px;*/
            }

            tr h3 {
                font-size: 16px;
            }

            .ion {
                font-size: 28px;
                margin-bottom: -8px;
            }
            .ion1 {
                font-size: 28px;
                margin-top: 7px;
                margin-left: 10px;
            }

            .imgu {
                border: none;
                margin-left: 27px;
                /*margin-top: -50%;*/
                margin-bottom: 10px;

            }
            .update-button {
                display: flex;
                flex-direction: column;
                justify-content: center;
                text-decoration: none;

            }

            .update-button a{
                text-decoration: none;
            }

            .delete-button {
                display: flex;
                flex-direction: column;
                justify-content: center;
                text-decoration: none;
                color: red;

            }

            .delete-button a{
                text-decoration: none;
                background-color: red;

            }
            .delete-button a:hover {
                background-color: crimson;
            }
            .imgu1 {
                border: none;
                margin-left: 23px;
                /*margin-top: -50%;*/
                margin-bottom: 10px;

            }

        </style>
        <script type="text/javascript">
            function doDelete(id) {
                if (confirm("Are you sure to delete Personnel with Code " + id + "?")) {
                    window.location = "deleteperson?id=" + id;
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
                    <h2>Hello ${sessionScope.account.username}</h2>
                </li> 
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

        <section class="content">

            <div class="container">

                <div class="info">

                    <center>

                        <div class="add">
                            <ion-icon class="ion" name="add-circle-outline"></ion-icon>
                            <a href="addperson" class="add-button">Add new Personnel</a><br/><br/>
                        </div>
                        <table>
                            <form action="personnel" method="post">
                                <tr>
                                <div class="search-bar">
                                    <input type="text" class="search-input" name="search" placeholder="Search Personnel(Code,Name)" value="${param.search}" />
                                    <button type="submit" class="search-button">Search</button>
                                    <ion-icon class="ion1" name="search-outline"></ion-icon>
                                </div>
                                </tr>
                            </form>

                            <tr>
                                <th></th>
                                <th>
                                    <h3>Code</h3>
                                </th>
                                <th>
                                    <h3>Image</h3>
                                </th>
                                <th>
                                    <h3>User Information
                                    </h3>
                                </th>

                                <th>
                                    <h3>Update
                                    </h3>

                                </th>
                                <th><h3>Delete</h3></th>

                            </tr>
                            <% int cnt = 0;                                        
                            %>
                            <c:forEach items="${requestScope.listp}" var="per">

                                <tr>
                                    <%cnt++;%>
                                    <td><%= cnt %></td>
                                    <td>${per.codepersonnel}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${per.sex == true}">
                                                <img src="img/ava.png"  width="150">
                                            </c:when>
                                            <c:otherwise>
                                                <img src="img/avawoman.png"  width="150">

                                            </c:otherwise>
                                        </c:choose>
                                    </td>

                                    <td>
                                        Name: ${per.psname}<br/> Phone: ${per.phonenum}<br/> BirthDate: ${per.dob} 
                                        <br/>
                                        <c:choose>
                                            <c:when test="${per.sex == true}">
                                                Gender: Male
                                            </c:when>
                                            <c:otherwise>
                                                Gender: Female
                                            </c:otherwise>
                                        </c:choose>
                                        <br/> 
                                        <c:forEach items="${requestScope.listr}" var="role">
                                            <c:if test="${per.roleid == role.id}">
                                                Role: ${role.rolename}
                                            </c:if>
                                        </c:forEach><br/>

                                        <c:choose>
                                            <c:when test="${per.status == true}">
                                                Status: On
                                            </c:when>
                                            <c:otherwise>                                              
                                                Status: Off
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>

                                        <div class="update-button" >
                                            <img class="imgu" src="img/update.png" width="50px">
                                            <a href="updateperson?id=${per.codepersonnel}" class="search-button">Update</a>
                                        </div>

                                    </td>     
                                    <td>
                                        <div class="delete-button" >
                                            <img class="imgu1" src="img/remove.png" width="50px">
                                            <a href="#" onclick="doDelete('${per.codepersonnel}')" class="search-button">Delete</a>
                                        </div>

                                    </td>
                                </tr>
                            </c:forEach> 

                        </table>
                    </center>
                </div>
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
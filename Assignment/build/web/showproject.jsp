<%-- 
    Document   : showproject
    Created on : Nov 8, 2023, 2:08:37 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Project</title>
        <style>
            body {
                /*font-family: Arial, sans-serif;*/
                /*text-align: center;*/
            }


            .container1 {
                display: flex;
            }

            .icon {
                font-size: 20px;
                margin-right: 10px;
                margin-top: 25px;

            }

            .link {
                text-decoration: none;
                color: #007BFF;
                transition: color 0.3s;
                /* Hiệu ứng màu sắc trong 0.3 giây */
            }

            .link:hover {
                color: orangered;
                /* Đổi màu khi di chuột qua liên kết */
            }
            .title {
                text-align: center;

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
                width: 80%;
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
            .imgava {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="container1">
            <ion-icon class="icon" name="chevron-back"></ion-icon>
            <h2><a class="link" href="project">Back to List Project</a></h2>
        </div>
        <c:set var="pro" value="${requestScope.p}" />
        <div class="title">
            <h1 style="color: #ff4d00">PROJECT</h1>
            <h1 style="color: #ff4d00">${pro.projectname}</h1>
            <h3> 
                <c:choose>
                    <c:when test="${p.status == true}">
                        <p style="color: green">Status: ON</p>

                    </c:when>
                    <c:otherwise>                                              
                        <p style="color: gray">Status: OFF</p>
                    </c:otherwise>
                </c:choose>
            </h3>
            <h4>Start at: ${p.startdate}</h4>
            <h4>Enddate:<c:choose>
                    <c:when test="${p.enddate != null}">
                        ${p.enddate}
                    </c:when>
                    <c:otherwise> N/A</c:otherwise>
                </c:choose>
            </h4>
        </div>

        <div class="container">

            <div class="info">

                <center>

                    <h3 style="color: chocolate">List Of Personnel On Project</h3>
                    <table>


                        <tr>
                            <td></td>
                            <th>
                                <h3>Code</h3>
                            </th>
                            <th>Name</th>

                            <th>
                                <h3>Image</h3>
                            </th>

                            <th>Department</th>



                        </tr>
                        <% int cnt = 0;                                        
                        %>
                        <c:forEach items="${requestScope.listpa}" var="pa">
                            <c:if test="${pa.projectid == pro.id}">

                                <tr>
                                    <%cnt++;%>
                                    <td><%= cnt %></td>
                                    <c:forEach items="${requestScope.listp}" var="person">
                                        <c:if test="${person.id == pa.personid}">
                                            <td>${person.codepersonnel}</td>
                                        </c:if>
                                    </c:forEach> 

                                    <c:forEach items="${requestScope.listp}" var="person">
                                        <c:if test="${person.id == pa.personid}">
                                            <td>${person.psname}</td>
                                        </c:if>
                                    </c:forEach> 

                                    <c:forEach items="${requestScope.listp}" var="person">
                                        <c:if test="${person.id == pa.personid}">
                                            <td class="imgava">
                                                <c:choose>
                                                    <c:when test="${person.sex == true}">
                                                        <img src="img/ava.png"  width="150">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <img src="img/avawoman.png"  width="150">

                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </c:if>

                                    </c:forEach> 

                                    <c:forEach items="${requestScope.listp}" var="person">
                                        <c:if test="${person.id == pa.personid}">
                                            <c:forEach items="${requestScope.listd}" var="depart">
                                                <c:if test="${person.departid == depart.id}">
                                                    <td>${depart.departname}</td>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>
                                    </c:forEach> 
                                </tr>
                            </c:if>
                        </c:forEach> 

                    </table>
                </center>
            </div>
        </div>

        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    </body>
</html>

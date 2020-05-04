<%--
  Created by IntelliJ IDEA.
  User: 11
  Date: 02.05.2020
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>IT Company</title>
        <style>
            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #333333;
            }

            li {
                float: left;
            }

            li a {
                display: block;
                color: white;
                text-align: center;
                padding: 16px;
                text-decoration: none;
            }

            li a:hover {
                background-color: #111111;
            }
        </style>
    </head>
    <body>
    <ul>
        <li><a href="/servlet/departments">Departments</a></li>
        <li><a href="/servlet/employees">Employees</a></li>
    </ul>

    </body>
</html>

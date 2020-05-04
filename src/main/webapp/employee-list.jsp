<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Employees</title>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <table border="1 px">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Salary</th>
                <th>Department</th>
                <th>Action</th>
            </tr>
            <c:forEach var="employee" items="${requestScope.employees}">
                <tr>
                    <td><c:out value="${employee.id}"/></td>
                    <td><c:out value="${employee.name}"/></td>
                    <td><c:out value="${employee.salary}"/></td>
                    <td><c:out value="${employee.department.name}"/></td>
                    <td><c:out value="EDIT"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

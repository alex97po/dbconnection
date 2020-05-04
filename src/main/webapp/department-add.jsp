<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>New Department</title>
    </head>
    <body>
        <form action = "/servlet/departments" method = "POST">
            Name: <input type = "text" name = "name">
            <input type = "submit" value = "Submit" />
        </form>
    </body>
</html>

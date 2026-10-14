<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Subject Registrations</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        table { border-collapse: collapse; width: 100%; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background-color: #f4f4f4; }
    </style>
</head>
<body>
<h2>School Registration Dashboard</h2>
<a href="index.jsp">&larr; Home</a>

<h3>Registered Subjects</h3>
<table>
    <tr>
        <th>Subject Code</th>
        <th>Subject Name</th>
        <th>Assigned Teacher</th>
    </tr>
    <c:forEach var="sub" items="${subjects}">
        <tr>
            <td>${sub.subjectCode}</td>
            <td>${sub.subjectName}</td>
            <td>${sub.teacher.name} (${sub.teacher.email})</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--jstl라이브러리를 꼭 build.gradle에 추가하기--%>
<html>
<head>
    <title>Todo List</title>
</head>
<body>
<h1>Todo List</h1>

<ul>
    <c:forEach items="${dtoList}" var="dto">
        <li>${dto}</li>
    </c:forEach>
</ul>

</body>
</html>

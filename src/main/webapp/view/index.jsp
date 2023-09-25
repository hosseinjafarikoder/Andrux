<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>index</title>
</head>
<body>
<h1>this is index jsp</h1><br><hr>
<a href="${pageContext.request.contextPath}/terminal/java">java terminal</a><br>
<%--<a href="https://www.tutorialspoint.com/compile_java_online.php">java terminal</a><br>--%>

</body>
</html>

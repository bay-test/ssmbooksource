<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/user/home/login" method="post">
<input type="text" name="username"><br>
<input type="password" name="password"><br> 
<input type="submit" value="submit"><br>
</form>


<form action="<%=request.getContextPath() %>/user/home/transfer" method="post">

<input type="submit" value="submit"><br>
</form>
${message}
<img alt="aaa" src="<%=request.getContextPath() %>/images/bd_logo1.png">

<form action="<%=request.getContextPath() %>/user/home/findUser" method="post">
<input type="text" name="username"><br>

<input type="submit" value="submit"><br>
</form>
${users}
<c:forEach var="user" items="${users}">

${user.username}<br>

</c:forEach>



</body>
</html>
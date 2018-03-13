<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>BookList</h1>
<table>
<tr>
<td>ID</td>
<td>NAME</td>
<td>PUB</td>
<td>PRICE</td>
</tr>
<c:forEach items="${list }" var="b">
<tr>
<td>${b.bookid }</td>
<td>${b.bookname }</td>
<td>${b.publisher }</td>
<td>${b.price }</td>
</tr>
</c:forEach>
</table>
<a href="bookWrite">Write</a>
</body>
</html>
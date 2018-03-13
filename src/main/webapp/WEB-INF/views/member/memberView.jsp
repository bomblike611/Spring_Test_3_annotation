<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>MemberView</h1>
<h1>id : ${member.id }</h1>
<h1>name : ${member.name }</h1>
<h1>job : ${member.job }</h1>
<a href="memberUpdate?id=${member.id }">update</a>
<a href="memberDelete?id=${member.id }">delete</a>
</body>
</html>
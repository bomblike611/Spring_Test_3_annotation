<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>MemberUpdate</h1>
<form action="memberUpdate" method="post">
<input type="hidden" name="id" value="${member.id }">
<p>PW : <input type="text" name="pw" value="${member.pw }"></p>
<p>NAME : <input type="text" name="name" value="${member.name }"></p>
<p>EMAIL : <input type="email" name="email" value="${member.email }"></p>
<p>PHONE : <input type="text" name="phone" value="${member.phone }"></p>
<p>AGE : <input type="number" name="age" value="${member.age }"></p>
<input type="hidden" name="job" value="${member.job }">
<button>Update</button>
</form>
</body>
</html>
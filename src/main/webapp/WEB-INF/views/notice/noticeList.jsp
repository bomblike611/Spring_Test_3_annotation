<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var m= '${message}';
if(m != ''){
	alert(m);
}
</script>
</head>
<body>
<h1>NoticeList</h1>
<h2>CurPage : ${integer}</h2>

<table>
<tr>
<td>num</td>
<td>title</td>
<td>writer</td>
<td>date</td>
<td>hit</td>
</tr>
<c:forEach items="${list}" var="n">
<tr>
	<td>${n.num}</td>
	<td><a href="noticeView?num=${n.num}">${n.title}</a></td>
	<td>${n.writer}</td>
	<td>${n.reg_date }</td>
	<td>${n.hit }</td>
</tr>
</c:forEach>
</table>


<a href="./noticeWrite">Write</a>
</body>
</html>
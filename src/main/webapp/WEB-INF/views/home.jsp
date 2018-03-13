<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 밑에 쓰여진 애가 있으면 session이 안먹음 -->
<%-- <%@ page session="false" %> --%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="book/bookList">BookList</a>
<a href="notice/noticeList">Notice</a>
<c:if test="${empty member}">
<a href="member/memberJoin">Join</a>
<a href="member/memberLogin">Login</a>
</c:if>
<c:if test="${not empty member }">
<a href="member/memberView">Mypage</a>
<a href="member/memberLogout">Logout</a>
<a href="member/memberDelete">Delete</a>
</c:if>
</body>
</html>

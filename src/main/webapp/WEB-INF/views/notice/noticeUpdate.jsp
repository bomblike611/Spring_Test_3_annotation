<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>NoticeUpdate</h1>
	<form action="noticeUpdate" method="post">
		<p>
			title : <input type="text" name="title" value="${notice.title}">
		</p>
		<p>
			writer : <input type="text" name="writer" value="${notice.writer }" readonly="readonly">
		</p>
		<p>
			contents : <input type="text" name="contents" value="${notice.contents }">
		</p>
		<input type="hidden" value="${notice.num}" name="num">
		<button>Click</button>
	</form>
	
</body>
</html>
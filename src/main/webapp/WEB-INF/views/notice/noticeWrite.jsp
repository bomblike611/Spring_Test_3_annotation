<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>NoticeWrite</h1>
	<form action="${board}Write" method="post">
		<p>
			title : <input type="text" name="title">
		</p>
		<p>
			writer : <input type="text" name="writer">
		</p>
		<p>
			contents : <input type="text" name="contents">
		</p>
		<button>Click</button>
	</form>
	<form action="${board}Write2" method="post">
		<p>
			<input type="text" name="title">
		</p>
		<p>
			<input type="text" name="writer">
		</p>
		<p>
			<input type="text" name="contents">
		</p>
		<button>Click</button>
	</form>
</body>
</html>
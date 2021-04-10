<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body> 
<font color="red">${errorMessage}</font>

<form method="post">

Username: <input type="text" name="uname"><br>
Password: <input type="password" name="pass"><br>
<button>Login</button>
</form>
</body>
</html>
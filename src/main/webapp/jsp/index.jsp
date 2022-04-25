<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to the website</h1><br>
<h4>Search using the form below</h4><br>
<form action="/submit" method="POST">
  <label for="ticker">Stock ticker:</label><br>
  <input type="text" id="ticker" name="ticker" value="ibm"><br><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>

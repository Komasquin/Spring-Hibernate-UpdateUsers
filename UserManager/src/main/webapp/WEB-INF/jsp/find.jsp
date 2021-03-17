<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
<h1>Editing ${user.name }</h1>
<form action="save" method="post">
  <label for="su_id">ID:</label><br>
  <input type="text" id="su_id" name="su_id" value="${user.id}" readonly><br>
  <label for="fName">First name:</label><br>
  <input type="text" id="fName" name="fName" value="${user.name}"><br>
  <label for="eMail">email:</label><br>
  <input type="text" id="eMail" name="eMail" value="${user.email}"><br>
  <label for="passWord">password:</label><br>
  <input type="text" id="passWord" name="passWord" value="${user.password}"><br>
  <input type="submit" value="save">
</form> 
</body>
</html>
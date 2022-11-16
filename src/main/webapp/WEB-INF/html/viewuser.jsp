<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="dd" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User ABC Job</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
 body {
    font: 400 15px/1.8 Lato, sans-serif;
    color: #777;
  }
  .edit{
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 4px 7px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 12px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 4px;
  }
  .delete{
  background-color: #f44336; /* Red */ 
  border: none;
  color: white;
  padding:4px 7px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 12px;
  margin: 2px 1px;
  cursor: pointer;
  border-radius: 4px;
  }
  table{
  font-size: 14px;
  }
   
</style>
</head>
<body>
<jsp:include page="../components/aheader.jsp"/>
<div class="container" style="margin-top:20px; margin-left:90px;">
<center> <h1>User Details</h1></center>
 <form method="post" action="search-data">
    <input type ="hidden" name ="${_csrf.parameterName }" value ="${_csrf.token }"/>
      <div class="input">
    <input type="search" placeholder=" Search user here..." name="search" size="30">
	</div>
</form>
<br>
<table class="table">
<thead>
<tr>
<th>Username</th>
<th>FirstName</th>
<th>LastName</th>
<th>Email</th>
<th>Number</th>
<th>Country</th>
<th>Bio</th>
<th>Action</th>
</tr>
</thead>
<tbody>


<tr>
<dd:forEach var="user" items="${attribute}">
               <td>${user.getUser().getEmail()}</td>
                <td>${user.getUserName()}</td>
                <td>${user.getFirstName()}</td>
                <td>${user.getLastName()}</td>
                <td>${user.getAddress()}</td>
                <td>${user.getPhoneNumber()}</td>
                <td>${user.getBio()}</td>
                <td>
                <a href ="updateDataAdmin?edit= ${user.getId()}">
            <button class="edit">Edit</button>
            </a>
           <a href = "deleteDataAdmin?delete= ${user.getId()}">
            <button class="delete">Delete</button> </a></td> 
            </tr>
            
</dd:forEach>
</tr>
</tbody>
</table>
</center>

 

</div>
<br>
<br>
<jsp:include page="../components/footer.jsp"/>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Confirmation - ABC Job</title>
</head>
 <head>
    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,400i,700,900&display=swap" rel="stylesheet">
  </head>
    <style>
      body {
        text-align: center;
        background: #EBF0F5;
      }
        h1 {
          color: #0059b3;
          font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
          font-weight: 600;
          font-size: 21px;
          margin-bottom: 10px;
        }
        p {
          color: #404F5E;
          font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
          font-size:18px;
          margin: 0;
        }
      i {
        color: #9ABC66;
        font-size: 100px;
        line-height: 200px;
        margin-left:-15px;
      }
      .card {
        background: white;
        padding: 60px;
        border-radius: 4px;
        box-shadow: 0 2px 3px #C8D0D8;
        display: inline-block;
        margin: 0 auto;
      }
      a {
      font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
      text-decoration: none;
      display: inline-block;
	  padding: 10px 20px;
	  border-radius: 7px;
	  font-color: black;
	  }
	  .loginpage {
	  background-color: #00a3cc;
	  color: white;
	  margin-top: 20px;
	  margin-right: 20px; 
	  margin-left: 20px;
	  }
	  .button {
	  border-radius: 7px;
	  padding: 2px 6px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  font-size: 16px;
	  margin: 4px 2px;
	  transition-duration: 0.4s;
	  cursor: pointer;
	  background-color: #008CBA; 
	  color: black; 
	  border: 2px solid white;
	  }
	  .button1:hover {
	  background-color: white;
	  color: white;
	  }
    </style>
    <body>
      <div class="card">
      <div style="border-radius:200px; height:200px; width:200px; background: #F8FAF5; margin:0 auto;">
   		 <img src="img/logo2.png" alt="company logo" style="height:200px; width:200px">
      </div>
      <form class="Confirm_form" action="/thankyou" method="get" name="form" onsubmit="return validated()">
      <h1>Please</h1> 
        <p>Click the button below to verification your email</p>
        <br>
		<button class="button button1"><a href="/thankyou" class="Login">Confirm Email</a></button>
      </form>
	</div>
	<br>
	<br>
	<jsp:include page="../components/footer.jsp"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Registration - ABC Job</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">
 <script src="https://kit.fontawesome.com/2bbac3a66c.js" crossorigin="anonymous" ></script>
<!-- Main css -->
<link rel="stylesheet" href="css/RegisterLoginStyle.css">
</head>
<body style="background:#daebea;">

	<div class="main" style="background:#daebea;">
	
		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content" style="background:white; border-radius: 10px;">
					<div class="signup-form">
						<h2 class="form-title">Registration</h2>
						<h4>Make Register to Create a ABC Account</h4>
						<form id="form" name="form" method="post" action="/register-confirmation">
							<div class="form-group">
								<label for="firstname"><i
									class="zmdi zmdi-account material-icons-name"></i></label> 
									<input path="fname" type="text" name="fname" id="firstname" placeholder="First Name" required="required"/>
							</div>
							<div class="form-group">
								<label for="lastname"><i
									class="zmdi zmdi-account material-icons-name"></i></label> 
									<input path="lname" type="text" name="lname" id="lastname" placeholder="Last Name" required="required"/>
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> 
								<input path="email" type="email" name="email" id="email" placeholder="Email Address" required="required"/>
							</div>
							<div class="form-group">
								<label for="username"><i
									class="zmdi zmdi-account material-icons-name"></i></label> 
									<input path="username" type="text" name="username" id="username" placeholder="Username" required="required"/>
							</div>
							<div class="form-group">
								<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
								<input path="phone" type="tel" name="phone" id="phonenumber"
									placeholder="Phone Number" required="required"/>
							</div>
							<div class="form-group">
								<label for="country"><i
									class="zmdi zmdi-account material-icons-name"></i></label> 
									<input path="address" type="text" name="address" id="address" placeholder="Country" required="required"/>
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> 
								<input path="password" type="password" name="password" id="password" placeholder="Password" required="required"/>
							</div>
						 	<div class="form-group form-button">
						 	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" required="required"/>
							</div>
							
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="img/logo2.png" alt="company logo">
						</figure>
						<a href="login" class="signup-image-link">I have an account</a>
					</div>
				</div>
			</div>
		</section>
		<jsp:include page="../components/footer.jsp"/>
	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">



</body>

</html>
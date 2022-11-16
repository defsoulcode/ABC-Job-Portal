<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <title>Update Profile</title>
    <link rel="stylesheet" href="../css/ViewProfile.css">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
</head>

<body style="background:#d5e3f5">

    <section>

      <div class="card1-wrp">
        <div class="box_container">
          <div class="box1">
            <div class="title">
              <img src="../img/profile.jpg" alt="Profile" />
              <h3>${user.getFirstName()}</h3>
              <div class="wrp-email">
                <div class="email">
                   <h4>${user.getUser().getEmail()}</h4>
                </div>
              </div>
              <div class="wrp-location">
                <div class="location">
                  <h4>${user.getAddress()}</h4>
                </div>
              </div>
              <!-- box 2 -->

            </div>
          </div>
          <div class="box2">
            <div class="title2">
              <h3>Profile</h3>
            </div>
            <div class="main3">
              <div class="firstname">
                <h4>First Name</h4>
                <h5>${user.getFirstName()}</h5>
              </div>
              <br>
              <div class="lastname">
                <h4>First Name</h4>
                <h5>${user.getLastName()}</h5>
              </div>
              <br>
              <div class="email">
                <h4>E-mail</h4>
                <h5>${user.getUser().getEmail()}</h5>
              </div>
              <br>
              <div class="username">
                <h4>Username</h4>
                <h5>${user.getUserName()}</h5>
              </div>
              <br>
              <div class="address">
                <h4>Address</h4>
                <h5>${user.getAddress()}</h5>
              </div>
              <br>
              <div class="phone">
                <h4>Phone Number</h4>
				<h5>${user.getPhoneNumber()}</h5>
              </div>
              <br>
              <div class="bio">
                <h4>Bio</h4>
                <h5>${user.getBio()}</h5>
              </div>
            </div>
            
              <br>
            </div>
          </div>
        </div>

        <div class="wrp-btn">

        </div>
    </section>
</body>

</html>




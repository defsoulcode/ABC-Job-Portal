<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="dd" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Search User - ABC Job</title>
<link rel="stylesheet" href="../css/SearchProfile.css" />

</head>
<body>

<form method="post" action="search-user">
      <div class="search-box">
        <h2>Search Profile</h2>
        <input type ="hidden" name ="${_csrf.parameterName }" value ="${_csrf.token }"/>
        <div class="input-group rounded">
          <input name="search"
            type="search"
            class="form-control rounded"
            placeholder="Search People here..."
            aria-label="Search"
            aria-describedby="search-addon"
          />
        </div>
      </form>
        <div class="card1-wrp">
         <dd:forEach var="user" items="${attribute}">
          <div class="box_container">
          <div class="box1">
            <div class="title">
              <img src="../img/profile.jpg" alt="profile" />
              <h3>${user.getFirstName()}</h3>
              <h4>${user.getUser().getEmail()}</h4>
              <h4>${user.getUserName()}</h4>
            </div>
          </div>
          <div class="box2">
            <div class="title2">
              <h3>Profile</h3>
            </div>
            <div class="main">
              <h4>Phone: ${user.getPhoneNumber()}</h4>
              <h4>Address: ${user.getAddress()}</h4>
              <h4>${user.getBio()}</h4>
              <div class="btn">
                <a href="view?show=${user.getId()}" class="hyperlink">
                      View Profile
              </a>
              </div>
            </div>
           
          </div>
   
          </div>
         
            </dd:forEach>
        </div>
        </div>
       </div>
        <!-- tag close search-box -->
      
<jsp:include page="../components/footer.jsp"/>
<br>
<br>
</body>
</html>
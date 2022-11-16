<%@ taglib prefix="dd" uri="http://java.sun.com/jsp/jstl/core"%>
<DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Update Profile</title>
    <link rel="stylesheet" href="../css/UpdateProfile.css" />
  </head>

  <body>

    <section>
      <div class="card1-wrp">
        <div class="box_container">
      
          <div class="box1">
            <div class="title">
              <img src="../img/profile.jpg" alt="Profile" />
               <input type ="hidden" name ="id" value = "${update.getId()}"/>
              <h3>${update.getFirstName()}</h3>
              <div class="wrp-email">
                <div class="email">
                  <h4>${update.getUser().getEmail()}</h4>
                </div>
              </div>
              <div class="wrp-location">
                <div class="location">
                  <h4>${update.getAddress()}</h4>
                </div>
              </div>
              </div>
                </div>
              <!-- box 2 -->

            <dd:choose>
           <dd:when test="${role == 'ADMIN'}">
                <form method="post" action="update-user">
                <input type="hidden" name = "id-user-profile" value ="${update.getId()}">
              </dd:when>
              <dd:otherwise>
              <form method="post" action="update-profile">
              </dd:otherwise>
          </dd:choose>

           <input type ="hidden" name ="${_csrf.parameterName }" value ="${_csrf.token }"/>
          <div class="box2">
            <div class="title2">
              <h3>Profile</h3>
            </div>
            <div class="main" >
              <div class="fname">
                <h4>First Name<span style="color: #ff7446">*</span></h4>
                
                <h4 class="data">${update.getFirstName()}</h4>
                <input type="text" class="input" value="${update.getFirstName()}" name="fname">
              </div>
              <div class="lname">
                <h4>Last Name<span style="color: #ff7446">*</span></h4>
                
                <h4 class="data">${update.getLastName()}</h4>
                <input type="text" class="input"value="${update.getLastName()}" name="lname">
              </div>
            </div>
            <div class="main3">
              <div class="email">
                <h4>E-mail<span style="color: #ff7446">*</span></h4>
                
                <h5>${update.getUser().getEmail()}</h5>
              </div>
              <div class="username">
                <h4>Username<span style="color: #ff7446">*</span></h4>
                
                <input type="text" class="input" value="${update.getUserName()}" name="username">
                <h5 class="data">${update.getUserName()}</h5>
              </div>
            </div>
            <div class="main4">
              <h4>Address<span style="color: #ff7446">*</span></h4>
              <div class="input">
              <input type="text" class="input" value="${update.getAddress()}" name="address">
              <div class="country">
                <h5 class="data">${update.getAddress()}</h5>
              </div>
            </div>
            <h4>Phone<span style="color: #ff7446">*</span></h4>
            
            <input type="text" class="input" value="${update.getPhoneNumber()}" name="number">
            <div class="number">
            <h5 class="data">${update.getPhoneNumber()}</h5>
          </div>
              <h4>Bio<span style="color: #ff7446">*</span></h4>
              <div class="bio">
              <input type="text" class="input-bio" value="${update.getBio()}" name="bio">
              <h5 class="data">${update.getBio()}</h5>
            </div>
              <br>
              <div class="wrp-btn">
              <button class="edit" type="button" name="btn-edit" onclick="button()"><p style="margin: auto">Edit</p></button>
              <div class="wrp-btn2">
                <button name="btn-submit" class="button" onclick="button3()"><p style="margin: auto">Submit</p></button>
                <div class="wrp-btn3">
                  <button name="btn-cancel" class="button" onclick="button2()"><p style="margin: auto">Cancel</p></button>
                </div>
              </div>
            </div>
            </div>
          </div>
        </div>
       </form>
    </section>

  </body>
<script>

  function button(){
    let bioInput = document.getElementsByClassName("input-bio")[0].style.display="block"

    let input = document.querySelectorAll("input")
    let data = document.querySelectorAll(".data")
    document.getElementsByClassName("wrp-btn2")[0].style.display="flex" 
    document.getElementsByClassName("edit")[0].style.display="none"

    input.forEach(item=>item.style.display="block")
    data.forEach(item=>item.style.display="none") 
    console.log("test");
  
  }
  function button2(){
    document.getElementsByClassName("wrp-btn2")[0].style.display="none" 
    document.getElementsByClassName("edit")[0].style.display="block"
    let input = document.querySelectorAll("input")
    input.forEach(item=>item.style.display="none")
    let data = document.querySelectorAll(".data")
    data.forEach(item=>item.style.display="block") 
  }

</script>
  </html>
</DOCTYPE>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../css/ListJob.css">
  <title>List Job</title>
</head>

<body>
	<center>
 	<h1 style="margin-top: 40px">List Job</h1></center>
 	
 <form action="search-job" method="post">
  <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
<div class="form-search">
<input type="text" placeholder="Job" name="search-job">
<input type="text" placeholder="Location" name="search-address">
<button type="submit">Search</button>
</div>
</form>
  <main>
          <c:choose>
      <c:when test="${role == 'ADMIN'}">
      <a href="post-job">
          <button class="btn-post-job">Post New Job</button>
        </a>
       </c:when>
        </c:choose>
   <br>

    <div class="right">
          <c:forEach var="list" items="${dataJob}">
      <div class="card2-top">
        <div class="card2-bot">
          <div class="card2-left">
            <h2>Details</h2>
            <ul>
              <li>
                <p>Salary: ${list.getSalary()}</p>
                <p>Job-type: ${list.getJobType().getJobType()}</p>
                <p>Work Level: ${list.getWorkLevel().getWorkLevel() }</p>
                <p>Company: ${list.getCompany().getCompanyName()}</p>
                <p>Location: ${list.getAddress()}</p>
                <p>Status: ${list.getStatus()} </p>
                <p>Description:  ${list.getDescription()}</p>
              </li>
            </ul>
          </div>
          <div class="card2-right">
          <h2>${list.getJobTitle().getJobTitleName()}</h2>
          <h3>${list.getCompany().getCompanyName()}</h3>
          
           <c:choose>
            <c:when test="${role == 'ADMIN'}">
           <div class="wrp-btn-manage-job">
          <button type="submit" class="apply-job">${list.getJob().size()} Apply</button>
           <a href ="updateDataPostJob?edit=${list.getId()}">
           <button type="submit" class="update-apply-job">Update</button>
           </a>
            <a href ="deleteDataPostJob?delete= ${list.getId()}">
          <button type="submit" class="delete-apply-job">Delete</button>
           </a>
        </div>     
         </c:when>  
       <c:otherwise>
          <button type="submit" class="apply-job"onclick="myFunction(${list.getId()})">Apply</button>
      </c:otherwise>
        </c:choose>
        </div>
        </div>
      </div>
      </c:forEach>
    </div>
     <div class="popup">
     
      <div class="modal"id="myPopup">
      <span class="popuptext" >
           <sf:form method="post" action="submit-apply" modelAttribute = "job-apply">
            <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
     <sf:input type="hidden" name="job" path="job" id="job" value="${job.getId()}"/>
             
      <h1 class="apply-job">Apply <span style="color:#ff7446">Job</span></h1>
      <div class="btn-popup"> 
        <textarea name="jobApplyContent" path="jobApplyContent" id="apply-job" placeholder="Applicant Content" required="required"></textarea>
     <div class="wrp-down">
          <button class="see-after-apply"id="see-after-apply" type="submit">Apply
          </button>
          <a href="list-job">
  			<button class="see-after-apply"id="see-after-apply" type="button">close
          </button>
          </a>
          </div>
         </sf:form>
  </div>

  </span>
  </div>
</div>

  </main>
 <script src="../Java Script/ListJob.js"></script>

</body>
</html>
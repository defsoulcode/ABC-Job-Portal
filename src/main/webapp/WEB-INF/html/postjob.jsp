<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="dd" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Post Job</title>
    <link rel="stylesheet" href="../css/PostJob.css">
</head>
<body>

         <main>
            <div class="wrap-job">
        
                <h1>Post Job</h1>
                
                <sf:form method="post" action="/submit-job?edit=${job.getId()}" modelAttribute = "job">
                
                 <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
                <div class="wrp-select">
                    <sf:select name="jobTitle" id="job-title" path="jobTitle">
                        <option value="">Job Title</option>
                        <dd:forEach var = "jt" items="${jobTitle}">
                        <sf:option value="${jt.getId()}" >${jt.getJobTitleName()}</sf:option>
                        </dd:forEach>
                    </sf:select>

                    <sf:select name="jobType" id="job-type" path="jobType">
                        <option value="">Job Type</option>
                        <dd:forEach var = "jtype" items="${jobType}">
                          <sf:option value="${jtype.getId()}">${jtype.getJobType()}</sf:option>
                        </dd:forEach>
                    </sf:select>

                    <sf:select name="Work-level" id="work-level" path="workLevel">
                        <option value="">Work Level</option>
                         <dd:forEach var = "wl" items="${workLevel}">
                          <sf:option value="${wl.getId()}">${wl.getWorkLevel()}</sf:option>
                        </dd:forEach>
                    </sf:select>

                    <sf:select name="status" id="status" path="status">
                       <option value="status">Status</option>
                        <sf:option value="actively">Actively recruiting</sf:option>
                        <sf:option value="close">Recruiting Closed</sf:option>
                    </sf:select>
                </div>
                <div class="wrp-input">
                    <sf:select name="company" path="company" type="text" id="company" placeholder="Company">
                    <option value="">Company</option>
                         <dd:forEach var = "comp" items="${company}">
                          <sf:option value="${comp.getId()}">${comp.getCompanyName()}</sf:option>
                        </dd:forEach>
                        </sf:select>
                   <sf:input name = "salary" path="salary" type="text" id="salary" placeholder="Salary ($)" ></sf:input>
                    <sf:input name = "address" path="address" type="text" id="address" placeholder="Address" ></sf:input>
                </div>
                <div>
                    <sf:textarea name="description" path="description" id="job-description" cols="30" rows="10"
                        placeholder="Description"  required="required" ></sf:textarea>
                </div>
         
                <div class="btn-add-job-popup">
                    <button id="btnaddjob" type="submit">Add Job
                    </button>
                </div>
                  </sf:form>
            </div>
            <div class="popup">
                <div class="modal"id="myPopup">
                <span class="popuptext" >
                <img src="../../img/check.png" alt="ceklis.png" class="img-check" />
                <h1 class="success-post-job">Success <span style="color:#ff7446"> Post Job</span></h1>
                <div class="btn-popup"> 
                <a href="list-job">
                    <button id="see-after-post" type="button">See Your Post Job?
                    </button>
                </a>
                <a href="post-job">
                    <button id="back-post-job" type="button">Post Job Again?
                    </button>
                </a>
                 
                  
            </div>
           
            </span>
          
            </div>
        </div>
        </main>
       <script src="../Java Script/PostJob.js"></script>
       <script>
       
       document.querySelector("[name=jobTitle]").value = "${job.getJobTitle().getId()}"
    	   document.querySelector("[name=jobType]").value = "${job.getJobType().getId()}"
    		   document.querySelector("[name=workLevel]").value = "${job.getWorkLevel().getId()}"
    			   document.querySelector("[name=company]").value = "${job.getCompany().getId()}"
       </script>
		</body>
</html>
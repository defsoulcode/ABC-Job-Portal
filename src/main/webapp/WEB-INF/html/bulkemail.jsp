<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send Email</title>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">
<style>
body {
margin:40px;
}

</style>
</head>

<body>
<jsp:include page="../components/aheader.jsp"/>
<div class="container" style="margin-left:130px;">
 
 <div class="page-header">
 			<center><h1>Send Email</h1></center>

 </div>
	<form method="post" action="/sent-bulk-email">
	  <input type ="hidden" name ="${_csrf.parameterName }" value ="${_csrf.token }"/>
       <div class="row">
          <div class="col-md-11">
			<div class="panel-body">
				<div class="tab-content">
                   <div class="tab-pane fade in active" id="user-profile-info">
                      <div class="row">
                         <div class="col-sm-12">
                            <label>To:</label>
                            <input type="email" class="input-lg form-control" id="email" name="emails" path="email" placeholder="Email Address" required="required"/>
                            <span id="email-invalid" style="visibility:hidden">Must be a valid email address</span>
                         </div>
                      </div>
                      <div class="row">
                         <div class="col-sm-12">
                            <label>Subject:</label>
                            <input type="text" class="input-lg form-control" id="subject" name="subject" path="subject" placeholder="Type something" required="required"/> 
                         </div>
                      </div>
                      <br>
                      <div class="row">
                          <div class="col-sm-12">
                             <label>Message:</label>
                             <textarea class="input-lg form-control" id="description" name="description" path="description" placeholder="Type something" rows="5" required="required"></textarea> 
                          </div>
                      </div>
					</div>
				</div>
			</div>
               <div class="actions text-center">
  
                 <br> <a><button type="submit" class="btn-success" style="border-radius: 7px;, margin: 12px">Send</button></a>
               </div>
          </div>
		</div>
	</form>
          </div>
<br>
<br>
<jsp:include page="../components/footer.jsp"/>
</body>
</html>
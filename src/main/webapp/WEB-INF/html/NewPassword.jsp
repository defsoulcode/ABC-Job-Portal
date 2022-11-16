<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body  style="background:#daebea;">

<div class="container" style="width:60%;">
          
            <div class="card border-0 shadow my-5" >
                <div class="card-body p-5" >
            <h2 class="form-title text-center">Reset Password </h2>
      
              <form name="resetpass" id="form" action="/thankyoureset" method="post">
                <div class="form-group">
                    <label for="nps">New Password</label>
                   <input class="form-control" type="password" name="ps" id="new-password" required />
                </div>
                <div class="form-group">
                    <label for="cps">Confirm New Password</label>
                  <input class="form-control" type="password" name="c_ps" id="new-password-confirm" required />
                </div>
                <div class="form-group">
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
                  <button id="submit" type="submit" class="btn btn-primary" class="rounded"
                   onclick="checkInputs(event)"> Reset Password </button>
                </div>
                </form>
                </div>
              </div>
        </div>
        
<jsp:include page="../components/footer.jsp"/>


</body>
</html>
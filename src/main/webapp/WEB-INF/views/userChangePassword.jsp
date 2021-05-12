<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ICIN Bank</title>
    <jsp:include page="components/css-links.jsp" />
   
  </head>
  <body class="default-body">
    	<jsp:include page="components/nav.jsp" />  
      <div class="custom-container">
        <div class="custom-frame-login">
        <h5 class="text-center mt-5 mb-4 text-dark">Change Password</h5>
        <form class="form-signin" action="/user/changePassAction" method="post">
           <input class="form-styling" type="password" name="password1" placeholder="Enter New Password" />
             <input class="form-styling" type="password" name="password2" placeholder="Confirm New Password" /> 
               <span class="text-danger font-weight-bolder my-2">${errorMessage}</span>
            <input type="submit" id="btn-color" class="btn-custom-signin  btn-rounded my-3"  value="Submit">
            </form>
      </div>
    </div>

 	<jsp:include page="components/js-links.jsp" />
  </body>
</html>
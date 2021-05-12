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
        <h5 class="text-center mt-5 mb-4 text-dark">Admin Register</h5>
        <form class="form-signin" action="/admin/register" method="post">
           <input class="form-styling" type="text" name="username" placeholder="Username" required/>
             <input class="form-styling" type="password" name="password" placeholder="Password" required/> 
             <span
					class="text-danger font-weight-bolder my-2">${errorMessage}</span>
            <input type="submit" id="btn-color" class="btn-custom-signin  btn-rounded my-3"  value="Register">
            <div class="f-pass"> <a href="#">Forgot your password?</a> </div>
            </form>
      </div>
    </div>

 	<jsp:include page="components/js-links.jsp" />
  </body>
</html>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ICIN Bank</title>
    <link rel="stylesheet" href="../css/style.css" />
	<jsp:include page="components/css-links.jsp" />
  </head>
  <body class="default-body">
    
	    <jsp:include page="components/nav.jsp" />
     
   <div class="container w-50  text-center">
        
     <p id="custom-alert-block" class="alert alert-light my-5 py-4" style="text-align:center;">
      <img src="../images/blocked-icon.png"  alt="" width="80px">
      <br><span class="fs-2">Blocked</span>
      <br><br> Hello,  ${user.firstname}  ${user.lastname}. <br> Your account has been blocked for security reasons. Kindly contact to the nearest branch.
      <br></p>
    
      
    </div>
	<jsp:include page="components/js-links.jsp" />
   
  </body>
</html>
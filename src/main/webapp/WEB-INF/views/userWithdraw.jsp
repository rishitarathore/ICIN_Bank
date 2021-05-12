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
   	 <jsp:include page="components/sub-nav-user-info.jsp" />
    <div class="custom-container d-flex justify-content-center">
        <div class="custom-frame-register p-5 text-center">
        <form method=post action="/user/withdrawAction">
            <h5 class="text-center mb-4 ">Withdraw Money</h5>
            <input type=hidden name=id > 
            <input class="form-control mb-2" type="text" placeholder="Amount" name="amount" required> 
             <p class="text-danger my-2">${errorMessage}</p>
            <input class="btn btn-info my-3" type="submit" value="Withdraw">
        </form>
    </div>
</div>
     <jsp:include page="components/js-links.jsp" />
  </body>
</html>
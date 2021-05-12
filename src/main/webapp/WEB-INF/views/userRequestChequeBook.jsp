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
        <form method=post action="/user/requestChequeBookAction">
            <h5 class="text-center mb-4 ">Request Cheque Book</h5>
            <select class="browser-default custom-select form-select mb-2 " name="no_of_pages" required>
                <option value="" disabled selected>Number of Pages</option>
                <option value="15">15</option>
                 <option value="25">25</option>
                  <option value="35">35</option>
            </select> 
            <input class="btn btn-info my-3" type="submit" value="Confirm">


        </form>
    </div>
</div>
      <jsp:include page="components/js-links.jsp" />
  </body>
</html>
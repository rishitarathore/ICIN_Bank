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
    <div class="custom-frame  pb-5  ">
        
        <br>
        <h4 class="text-center mt-4 mb-4 ">Admin Dashboard</h4>
        <br>
    
        <div class="container d-flex justify-content-center">
    
                <div class="row-12 w-25" id="custom-anchor" >
                <div  id="btn-color" class="col-12 btn my-3 btn-rounded position-relative"><a href="/admin/userAccountInfo" class="stretched-link" >User Account Info </a></div>
                <div id="btn-color" class="col-12  btn my-3  btn-rounded position-relative"><a href="/admin/authorizeChequeBook" class="stretched-link">Cheque Book Requests</a></div>
                <div id="btn-color" class="col-12 btn my-3 btn-rounded position-relative"><a href="/admin/authorize" class="stretched-link">Authorization (KYC) </a></div>
            </div>
    
        </div>

    </div>
<jsp:include page="components/js-links.jsp" />
  </body>
</html>
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
        
    <p id="custom-alert-danger" class="alert alert-danger my-5 py-4" style="text-align:center;">
      <img src="../images/red-cross.png"  alt="" width="80px">
      <br><span class="fs-2">Failed</span>
      <br><br> Transaction Failed. Txn. No. ${transfer_session.transferId} <br> Benificary Account Invalid.<br></p>
    
      
    </div>
	<jsp:include page="components/js-links.jsp" />
   
  </body>
</html>
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
        
    <p id="custom-alert-success" class="alert alert-success my-5 py-4"
			style="text-align: center;">
			<img src="../images/green-tick.png" alt="" width="80px"> <br>
			<span class="fs-2">Success</span> <br>
			<br> Transaction Successful. Txn. No.
			${transaction_session.transactionId} <br> Rs.
			${transaction_session.amount} has been credited to your account ${account_session.accno}.Your
			Balance is Rs ${account_session.balance} <br>
		</p>
           <p id="custom-alert-light" class="alert alert-light font-weight-bold fs-3"> Thank you for banking with us!</p>
        </div>
	<jsp:include page="components/js-links.jsp" />
   
  </body>
</html>
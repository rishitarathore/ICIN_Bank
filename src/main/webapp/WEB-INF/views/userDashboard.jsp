<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    
   <div class="custom-frame pb-5 mx-auto w-50">
        
        <br>
        <h4 class="text-center mt-4 mb-4 ">User Dashboard</h4>
        <br>
    
	 <div  id="custom-anchor" class="row mx-auto  container d-flex justify-content-center">
                <div  id="btn-color" class="col-4 btn m-3 btn-rounded position-relative"><a  href="/user/deposit" class="stretched-link" >Deposit Money</a></div>
                <!-- Dynamic menu -->
                
                <c:if test="${account.user.featureStatus == 1 }">
                <div  id="btn-color" class="col-4 btn m-3 btn-rounded position-relative disabled"><a href="/user/withdraw" class="stretched-link" >Withdraw Money</a></div>
                <div id="btn-color" class="col-4  btn m-3  btn-rounded position-relative disabled"><a href="/user/transferMoney" class="stretched-link">Transfer Money</a></div>
                </c:if>
                    
                <c:if test="${account.user.featureStatus == 2 }">
                <div  id="btn-color" class="col-4 btn m-3 btn-rounded position-relative"><a href="/user/withdraw" class="stretched-link" >Withdraw Money</a></div>
                <div id="btn-color" class="col-4  btn m-3  btn-rounded position-relative disabled"><a href="/user/transferMoney" class="stretched-link">Transfer Money</a></div>
                </c:if>
                
                <c:if test="${account.user.featureStatus == 3}">       
                <div  id="btn-color" class="col-4 btn m-3 btn-rounded position-relative"><a href="/user/withdraw" class="stretched-link" >Withdraw Money</a></div>
                <div id="btn-color" class="col-4  btn m-3  btn-rounded position-relative"><a href="/user/transferMoney" class="stretched-link">Transfer Money</a></div>
                </c:if>
                
                <div id="btn-color" class="col-4 btn m-3 btn-rounded position-relative"><a href="/user/requestChequeBook" class="stretched-link">Request Cheque Book</a></div>
                 <div id="btn-color" class="col-4 btn m-3 btn-rounded position-relative"><a href="/user/transactionHistory" class="stretched-link" >Transaction History</a></div>
                  <div id="btn-color" class="col-4 btn m-3 btn-rounded position-relative"><a href="/user/transferHistory" class="stretched-link">Transfer History</a></div>
            </div>
    
    

    </div>
<jsp:include page="components/js-links.jsp" />
  </body>
</html>
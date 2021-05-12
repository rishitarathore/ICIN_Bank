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
 
    <div class="dashboard  pb-5 px-5  ">
            
        <br>
        <h4 class="text-center mt-4 mb-4 ">Transaction History</h4>
        <br>
     
        	<c:if test="${list.size() <= 0 }">
			<p class="alert alert-warning p-2 my-3 text-center w-75 mx-auto">No Transactions</p>
		</c:if>
		<c:if test="${list.size() > 0 }">	
		<div class="container d-flex justify-content-end">
			<input id="btn" class="text-center hidden-print btn btn-link"
				type="button" value="Print" onclick="window.print()" />
		</div>  

 
  <table class="table">
   
      <tr class="table-header-color">
        <th scope="col">Transaction ID</th>
        <th scope="col">Date</th>
        <th scope="col">Action Type</th>
        <th scope="col">Amount</th>


  
      </tr>
  
    <tbody>
    <c:forEach items="${list}" var="item">
      <tr>
        <td>${item.transactionId }</td>
        <td>${item.dateTime }</td>
        <td>${item.action }</td>
        <td>${item.amount }</td>
    
      </tr> 
  </c:forEach>
      </tbody>

</table>
  </c:if>
    </div>     

    <jsp:include page="components/js-links.jsp" />
  </body>
</html>
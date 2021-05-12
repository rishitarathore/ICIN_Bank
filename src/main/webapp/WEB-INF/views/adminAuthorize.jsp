<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

    <div class="dashboard  pb-5 px-5  ">
            
        <br>
        <h4 class="text-center mt-4 mb-4 ">Authorization (KYC) </h4>
        <br>
      
	<c:if test="${list.size() <= 0 }">
			<p class="alert alert-warning p-2 my-3 text-center w-75 mx-auto">No KYC Pending</p>
		</c:if>
		<c:if test="${list.size() > 0 }">	
		<div class="container d-flex justify-content-end">
			<input id="btn" class="text-center hidden-print btn btn-link"
				type="button" value="Print" onclick="window.print()" />
			<div id="btn"
				class="text-center hidden-print btn btn-link text-danger">
				<a class="text-danger"
					href="/admin/dashboard">Back</a>
			</div>
		</div>
		

  <table class="table">
   
      <tr class="table-header-color">
           
        <th scope="col">First Name</th>
        <th scope="col">Last Name</th>
        <th scope="col">Phone Number</th>
        <th scope="col">Address</th>
        <th scope="col">DOB</th>
       <!--  <th scope="col"  width="20%">Type of Verification Document</th> -->
        <th scope="col">Verification ID</th>
        <th scope="col" width="15%">Email</th>
        <th scope="col" width="14%">Action</th> 
  
      </tr>
  
    <tbody>
    	<c:forEach items="${list}" var="item">
      <tr>
        <td>${item.firstname }</td>
        <td>${item.lastname }</td>
        <td>${item.phone }</td>
        <td>${item.address }</td>
        <td>${item.dob }</td>
        <td>${item.identity }</td>
        <td>${item.email }</td>
         <td>
            <a class="text-success font-weight-bold" href="/admin/authorizationAccept?username=${item.username}">Accept</a>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
            <a class="text-danger font-weight-bold"href="/admin/authorizationReject?username=${item.username}">
                Reject</a></td>
  
      </tr> 
          </c:forEach>
      </tbody>

</table>
  	
    </c:if>
</div>
      <jsp:include page="components/js-links.jsp" />

  </body>
</html>
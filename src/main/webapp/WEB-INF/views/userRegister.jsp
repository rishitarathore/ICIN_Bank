<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<div class="custom-container">
		<div class="custom-frame-register">
			<h5 class="text-center mt-5 mb-4  text-dark">User Register</h5>
			<form class="form-signin mx-auto" action="/user/register" method="post">
				<input class="form-styling " type="text" name="firstname" placeholder="First Name" />
				<input class="form-styling " type="text" name="lastname" placeholder="Last Name" />
				<input class="form-styling" type="text" name="username" placeholder="Username" />
				<input class="form-styling" type="password" name="password"	placeholder="Password" />
				<input class="form-styling" type="text"	name="phone" placeholder="Mobile Number" /> 
				<input class="form-styling"	type="email" name="email" placeholder="Email-Id" /> 
				<input class="form-styling" type="date" name="dob"	placeholder="Date Of Birth" /> 
				<input class="form-styling"	type="text" name="address" placeholder="Address" />
				<input class="form-styling " type="text" name="identity" placeholder="Adhaar Number" /> <br>
				<c:if test="${error!=null}">
                    <span class=" text-danger font-weight-bolder my-2"><c:out value="${error}"/></span>
		  	  		</c:if>	
				
			 	<input type="submit" id="btn-color" class="btn-custom-signin  btn-rounded my-3" value="Register">
			 	 
			</form>
		</div>
	</div>
	    <jsp:include page="components/js-links.jsp" />
</body>
</html>

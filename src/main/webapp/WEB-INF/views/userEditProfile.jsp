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
			<h5 class="text-center mt-5 mb-4  text-dark">Edit Profile</h5>
			<form class="form-signin mx-auto" action="/user/editProfileAction" method="post">
				<input class="form-styling  " type="text" name="firstname" placeholder="First Name" value="${user.firstname}" disabled/>
				<input class="form-styling " type="text" name="lastname" placeholder="Last Name" value="${user.lastname}" disabled/>
				<input class="form-styling" type="text"	name="phone" placeholder="Mobile Number" /> 
				<input class="form-styling"	type="email" name="email" placeholder="Email-Id" /> 
				<input class="form-styling" type="date" name="dob"	placeholder="Date Of Birth" value="${user.dob}" disabled/> 
				<input class="form-styling"	type="text" name="address" placeholder="Address" />
			 	<input type="submit" id="btn-color" class="btn-custom-signin  btn-rounded my-3" value="Confirm">
			 	 
			</form>
		</div>
	</div>
	    <jsp:include page="components/js-links.jsp" />
</body>
</html>

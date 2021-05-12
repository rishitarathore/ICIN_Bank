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
		<h4 class="text-center mt-4 mb-4 ">User Account Information</h4>
		<br>
		
		<c:if test="${list.size() <= 0 }">
			<p class="alert alert-warning p-2 my-3 text-center w-75 mx-auto">No
				Users</p>
		</c:if>
		<c:if test="${list.size() > 0 }">
			<table class="table">

				<tr class="table-header-color">
					<th scope="col">A/c Number</th>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">User Name</th>
					<th scope="col">Features Granted To the User</th>
					<th scope="col">Change Features</th>
					<th scope="col">Status</th>
					<th scope="col">Change Status</th>

				</tr>


				<tbody>


					<c:if test="${list.size() > 0 }">
						<c:forEach items="${list}" var="item">

							<tr>
								<td>${item.accno }</td>
								<td>${item.user.firstname }</td>
								<td>${item.user.lastname }</td>
								<td>${item.user.username }</td>
								<td><c:if test="${item.user.featureStatus == 1}">Credit</c:if>
									<c:if test="${item.user.featureStatus == 2}">Credit + Debit</c:if>
									<c:if test="${item.user.featureStatus == 3}">Credit + Debit + Transfer</c:if>
								</td>
								<td>
									<form id="${item.user.id }" action="/admin/grantAccess">
										<input type=hidden name=username value="${item.user.username}">
										<select name="featureSelect"
											class="browser-default custom-select form-select-sm mb-2 "
											required>
											<option value="" disabled selected>Choose Features</option>
											<option value="1">Credit</option>
											<option value="2">Credit + Debit</option>
											<option value="3">Credit + Debit + Transfer</option>
										</select> &nbsp; <a class="text-primary font-weight-bold"
											href="javascript:{}"
											onclick="document.getElementById('${item.user.id }').submit();">Set</a>
									</form>
								</td>
								<td><c:if test="${item.user.status == false}">
          	Blocked
          	</c:if> <c:if test="${item.user.status == true }">
          	Active
          	</c:if></td>
								<td><c:if test="${item.user.status == false }">
										<a class="text-success font-weight-bold"
											href="/admin/activateUser?username=${item.user.username}">Activate</a>
									</c:if> <c:if test="${item.user.status == true}">
										<a class="text-danger font-weight-bold"
											href="/admin/blockUser?username=${item.user.username}">
											Block</a>
									</c:if></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</c:if>
	</div>
	<jsp:include page="components/js-links.jsp" />


</body>
</html>
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

	<div class="dashboard  pb-5 px-5  ">

		<br>
		<h4 class="text-center mt-4 mb-4 ">Cheque Book request</h4>
		<br>

		<c:if test="${list.size() <= 0 }">
			<p class="alert alert-warning p-2 my-3 text-center w-75 mx-auto">No Request</p>
		</c:if>
		<c:if test="${list.size() > 0 }">

			<table class="table">

				<tr class="table-header-color">

					<th scope="col">Request Number</th>
					<th scope="col">Type of Account</th>
					<th scope="col">Account Number</th>
					<th scope="col">Applied Date</th>
					<th scope="col">Number of Pages</th>
					<th scope="col" width="20%">Confirm Request</th>

				</tr>

				<tbody>
					<c:forEach items="${list}" var="item">
						<tr>
							<td>${item.requestId }</td>
							<td>Savings</td>
							<td>${item.accno }</td>
							<td>${item.dateTime }</td>
							<td>${item.no_of_pages}</td>
							<td><a class="text-primary font-weight-bold"
								href="/admin/authorizeChequeBookAction?requestId=${item.requestId}">Confirm
									Request</a>
						</tr>
					</c:forEach>
				</tbody>

			</table>


		</c:if>
	</div>

	<jsp:include page="components/js-links.jsp" />
</body>
</html>
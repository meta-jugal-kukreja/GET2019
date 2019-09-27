<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="pageTitle" scope="request" value="Friends" />
<%@include file="../includes/header.jsp"%>
<div class="container" style="margin-top: 60px">
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">Friends</h3>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Friend's Name</th>
							<th>Friend's Email</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${employeeList}" var="employee">
							<spring:url value="/employee/${employee.email}/viewProfile" var="urlFriendDetail" />
							<tr>
								<td>${employee.fullName}</td>
								<td>${employee.email}</td>
								<td><a href="${urlFriendDetail}">View Profile</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<jsp:include flush="true" page="../includes/footer.jsp"></jsp:include>
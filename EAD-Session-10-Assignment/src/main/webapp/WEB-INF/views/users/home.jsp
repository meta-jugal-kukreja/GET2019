<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="pageTitle" scope="request" value="Home" />
<%@include file="../includes/header.jsp"%>
<spring:url value="/home/employee/${employee.email}/update" var="urlEditUserDetails" />
<spring:url value="/home/employee/${employee.email}/friends" var="urlUserFriends" />
<div class="container" style="margin-top: 30px">
	<div align="right">
		Welcome &nbsp;
		<a href="">
			<object
				data="${image}" width="50px" height="60px">
				<img src="images/default_image.png" width="50px" height="60px">
			</object>
		</a>
		&nbsp;  ${employee.fullName}
	</div>
	<br>
	<div align="right">
		<button class="btn btn-primary" onclick="window.location.href = '/home/employee/logout';">Logout</button>
	</div>
	<br> <br>
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">Home</h3>
		</div>
		<div class="card-body">
			<c:if test="${not empty message}">
				<div class="alert alert-success alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">x</span>
					</button>
					<strong>${message}</strong>
				</div>
			</c:if>
			
			
			<h4 align="center">User Details</h4>
			<div class="table-responsive">
				<table class="table table-striped" align="center" cellpadding="10%"
					style="text-align: left">
					<tbody>
						<tr>
							<td>Name</td>
							<td><input type="text" value="${employee.fullName}" readonly
								size="90%"></td>
						</tr>
						<tr>
							<td>Gender</td>
							<td><input type="text" value="${employee.gender}" readonly
								size="90%"></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><input type="text" value="${employee.email}" readonly
								size="90%"></td>
						</tr>
						<tr>
							<td>Contact Number</td>
							<td><input type="text" value="${employee.contactNumber}"
								readonly size="90%"></td>
						</tr>
						<tr>
							<td>Organization</td>
							<td><input type="text" value="${employee.organization}"
								readonly size="90%"></td>
						</tr>
						<tr>
							<td>Vehicle Name</td>
							<td><input type="text" value="${employee.vehicleName}"
								readonly size="90%"></td>
						</tr>
						<tr>
							<td>Vehicle Type</td>
							<td><input type="text" value="${employee.vehicleType}"
								readonly size="90%"></td>
						</tr>
						<tr>
							<td>Vehicle Number</td>
							<td><input type="text" value="${employee.vehicleNumber}"
								readonly size="90%"></td>
						</tr>
						<tr>
							<td>Vehicle Identification</td>
							<td><input type="text"
								value="${employee.vehicleIdentification}" readonly size="90%"></td>
						</tr>
						<tr>
							<td>Pass Number</td>
							<td><input type="text" value="${employee.passNumber}"
								readonly size="90%"></td>
						</tr>
						<tr>
							<td>Pass Price</td>
							<td><input type="text" value="${employee.passPrice} USD" readonly size="90%"></td>
						</tr>
					</tbody>
				</table>
			</div>
			<br>
			<div align="center">
				<button class="btn btn-primary"
					onclick="window.location.href = '${urlEditUserDetails}';">Edit Details</button>
			</div>
			<br>
			<div align="center">
				<button class="btn btn-primary"
					onclick="window.location.href = '${urlUserFriends}';">Friends</button>
			</div>
			<br>
		</div>
	</div>
</div>
<jsp:include flush="true" page="../includes/footer.jsp"></jsp:include>

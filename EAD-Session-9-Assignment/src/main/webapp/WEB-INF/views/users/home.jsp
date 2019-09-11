<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="pageTitle" scope="request" value="Home" />
<%@include file="../includes/header.jsp"%>
<spring:url value="/employee/${employee.email}/update" var="urlEditUserDetails" />
<div class="container" style="margin-top: 30px">
	<div align="right">
		Welcome &nbsp;
		<img src="/images/default_image.png" id="upfile1" style="cursor:pointer" width="65px" height="65px" />
		&nbsp; 
		<%-- ${employee.fullName} --%> 
		Jugal Kukreja
	</div>
	<br>
	<div align="right">
		<button class="btn btn-primary">Logout</button>
	</div>
	<br> <br>
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">Home</h3>
		</div>
		<div class="card-body">
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
							<td><input type="text" value="$ "+ "${employee.passPrice}" readonly size="90%"></td>
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
					onclick="window.location.href = '/home/friendsList';">Friends</button>
			</div>
			<br>
		</div>
	</div>
</div>
<jsp:include flush="true" page="../includes/footer.jsp"></jsp:include>

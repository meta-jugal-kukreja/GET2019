<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="pageTitle" scope="request" value="Add Vehicle" />
<%@include file="../includes/header.jsp"%>
<div class="container" style="margin-top: 60px">
	<h3>${message}</h3>
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">Add Vehicle Details</h3>
		</div>
		<div class="card-body">
			<form:form modelAttribute="vehicleRegistrationForm">
				<form:errors cssClass="text-danger" />
				<div class="form-group">
					<form:label path="vehicleName">Vehicle Name : </form:label>
					<form:input path="vehicleName" type="text" class="form-control" id="vehicle_name"
						placeholder="Vehicle Name" />
					<form:errors path="vehicleName" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="vehicleNumber">Vehicle Number : </form:label>
					<form:input path="vehicleNumber" type="text" class="form-control" id="vehicle_number"
						placeholder="Vehicle Number" />
					<form:errors path="vehicleNumber" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="employeeEmail">Employee Email address : </form:label>
					<form:input path="employeeEmail" type="email" class="form-control" id="employee_email"
						placeholder="Employee Email" value="${employee_email}" readonly="true"/>
					<form:errors path="employeeEmail" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="type">Vehicle Type : </form:label>
					&nbsp; &nbsp;
						<form:select path="type"  id="selectedVehicle">
							<form:option value="none" disabled="true" >--Select-type--</form:option>
							<form:option value="Cycle" selected="true">Cycle</form:option>
							<form:option value="MotorCycle">MotorCycle</form:option>
							<form:option value="FourWheeler">FourWheeler</form:option>
						</form:select>
						<br>
					<form:errors path="type" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="identification">Vehicle Identification</form:label>
						<form:textarea path="identification" class="form-control" id="vehicle_identification"
						placeholder="Vehicle Identification" cols="60"/>
					<form:errors path="identification" cssClass="text-danger" />
				</div>
				<button type="submit" class="btn btn-primary">Add Vehicle</button>
			</form:form>
		</div>
	</div>
</div>
<jsp:include flush="true" page="../includes/footer.jsp"></jsp:include>
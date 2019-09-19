<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="pageTitle" scope="request" value="Update Employee Information" />
<%@include file="../includes/header.jsp"%>
<div class="container" style="margin-top: 60px">
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">Update Employee Information</h3>
		</div>
		<div class="card-body">
			<form:form modelAttribute="employeeUpdationForm">
				<form:errors cssClass="text-danger" />
				<div class="form-group">
					<form:label path="fullName">Full Name : </form:label>
					<form:input path="fullName" type="text" class="form-control" id="employee_full_name"
						placeholder="Full Name" />
					<form:errors path="fullName" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="gender">Gender : </form:label>
					&nbsp; &nbsp; &nbsp;
					<label>
						<form:radiobutton path="gender"  id="employee_gender_male" 
						value="Male"/>Male
					</label>
					&nbsp; &nbsp; &nbsp;
					<label>
						<form:radiobutton path="gender"  id="employee_gender_female"
						value="Female"/>Female
					</label>
					<br>
					<form:errors path="gender" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="email">Email address : </form:label>
					<form:input path="email" type="email" class="form-control" id="employee_email"
						placeholder="Email"  value="${employee_email}" readonly="true"/>
				</div>
				
				<div class="form-group">
					<form:label path="contactNumber">Contact Number : </form:label>
					<form:input path="contactNumber" type="text" class="form-control" id="employee_contact"
						placeholder="Contact Number" />
					<form:errors path="contactNumber" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="organization">Organization : </form:label>
						<form:select path="organization">
							<form:option disabled="true" selected="true" value="null">--Select-Organization--</form:option>
							<form:option value="Metacube">Metacube</form:option>
							<form:option value="TCS">TCS</form:option>
							<form:option value="Wipro">Wipro</form:option>
							<form:option value="Infosys">Infosys</form:option>
						</form:select>
						<br>
					<form:errors path="organization" cssClass="text-danger" />
				</div>
				<button type="submit" class="btn btn-primary">Update</button>
			</form:form>
		</div>
		<br>
		<br>
	</div>
</div>
<jsp:include flush="true" page="../includes/footer.jsp"></jsp:include>
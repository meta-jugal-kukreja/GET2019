<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="pageTitle" scope="request" value="${employee_email != null? 'Update Employee information' : 'Add Employee Information'}" />
<%@include file="../includes/header.jsp"%>
<div class="container" style="margin-top: 60px">
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">${employee_email != null?'Update Employee information' : 'Add Employee Information'}</h3>
		</div>
		<div class="card-body">
			<form:form modelAttribute="employeeRegistrationForm" onsubmit="return passwordMatching(this)">
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
						placeholder="Email"  value="${employee_email}"/>
					<form:errors path="email" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="password">Password : </form:label>
					<form:input path="password" type="password" class="form-control" id="employee_password"
						placeholder="Password" />
					<form:errors path="password" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="confirmPassword">Confirm Password : </form:label>
					<form:input path="confirmPassword" type="password" class="form-control" id="employee_confirm_password"
						placeholder="Confirm Password" />
					<form:errors path="confirmPassword" cssClass="text-danger" />
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
				<button type="submit" class="btn btn-primary">Register</button>
			</form:form>
		</div>
		<div align="center">
			<h4>
				Already a member ? <a href="/employeeLogin">LogIn</a>
			</h4>
		</div>
	</div>
</div>
<jsp:include flush="true" page="../includes/footer.jsp"></jsp:include>
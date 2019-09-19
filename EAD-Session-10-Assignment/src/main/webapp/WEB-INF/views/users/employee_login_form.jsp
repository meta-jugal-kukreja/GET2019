<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="pageTitle" scope="request" value="Employee Login" />
<%@include file="../includes/header.jsp"%>
<div class="container" style="margin-top: 60px">
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">Login</h3>
		</div>
		<div class="card-body">
			<form:form modelAttribute="employeeLoginForm">
				<form:errors cssClass="text-danger" />
				<div class="form-group">
					<form:label path="email">Email address : </form:label>
					<form:input path="email" type="email" class="form-control" id="employee_email"
						placeholder="Email" />
					<form:errors path="email" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="password">Password : </form:label>
					<form:input path="password" type="password" class="form-control" id="employee_password"
						placeholder="Password" />
					<form:errors path="password" cssClass="text-danger" />
				</div>
				<button type="submit" class="btn btn-primary">Login</button>
			</form:form>
		</div>
	</div>
</div>
<jsp:include flush="true" page="../includes/footer.jsp"></jsp:include>
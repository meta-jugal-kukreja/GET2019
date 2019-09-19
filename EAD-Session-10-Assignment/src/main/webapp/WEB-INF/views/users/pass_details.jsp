<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="pageTitle" scope="request" value="Pass Details" />
<%@include file="../includes/header.jsp"%>

<div class="container" style="margin-top: 60px">
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">Pass Details</h3>
		</div>
		<div class="card-body">
			<form:form modelAttribute="getPass" onsubmit="return currencySelectionValidation(this)">
				<form:errors cssClass="text-danger" />
				<h2>Select Plan</h2>
				<input type="hidden" value="${selectedVehicleType}" id="vehicleType">
				<form:input path="employeeEmail" type="hidden" value="${employee_email}" id="employeeEmail"/>
				<div class="table-responsive">
					<table class="table table-striped" style="width: 15%"
						id="priceTable">
						<tbody>
							<tr>
								<th>Plan</th>
								<th width="50%">Prices</th>
							</tr>
							<tr>
								<td>Daily</td>
								<td width="50%"></td>
							</tr>
							<tr>
								<td>Monthly</td>
								<td width="50%"></td>
							</tr>
							<tr>
								<td>Yearly</td>
								<td width="50%"></td>
							</tr>
						</tbody>
					</table>
					<br>
				</div>
				<div class="form-group">
					<label>Currency Type : </label>
					<select id="typeOfCurrency" onchange="changeCurrency()">
						<option disabled selected value="">--Select-Currency-Type--</option>
						<option value="INR">INR</option>
						<option value="USD">USD</option>
						<option value="YEN">YEN</option>
					</select>
					<br>
				</div>
				<br>
				<div class="form-group">
					<label>Select Plan : </label>
					<br> <label> 
					<input type="radio" id="plan_daily" value="Daily" name="plan" />Daily
					</label> &nbsp; &nbsp; &nbsp; <label> 
					<input type="radio" id="plan_monthly" value="Monthly" name="plan"/>Monthly
					</label> &nbsp; &nbsp; &nbsp; <label> 
					<input type="radio" id="plan_yearly" value="Yearly" name="plan"/>Yearly
					</label> <br>
				</div>
				<div class="form-group">
					<form:input path="passPrice" type="hidden" class="form-control" id="pass_price"/>
				</div>
				<button type="submit" class="btn btn-primary" >Get Pass</button>
			</form:form>
		</div>
	</div>
</div>
<jsp:include flush="true" page="../includes/footer.jsp"></jsp:include>
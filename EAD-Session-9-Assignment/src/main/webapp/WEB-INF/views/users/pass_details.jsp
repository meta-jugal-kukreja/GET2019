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
			<form:form modelAttribute="getPass" onsubmit="return currencySelectionValidation(this)" action="/home">
				<form:errors cssClass="text-danger" />
				<h2>Select Plan</h2>
				<input type="hidden" value="${selectedVehicleType}" id="vehicleType">
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
					<form:label path="currencyType">Currency Type : </form:label>
					<form:select path="currencyType" id="typeOfCurrency" onchange="changeCurrency()">
						<form:option disabled="true" selected="true" value="">--Select-Currency-Type--</form:option>
						<form:option value="INR">INR</form:option>
						<form:option value="USD">USD</form:option>
						<form:option value="YEN">YEN</form:option>
					</form:select>
					<br>
					<form:errors path="currencyType" cssClass="text-danger" />
				</div>
				<br>
				<div class="form-group">
					<form:label path="plan">Select Plan : </form:label>
					<br> <label> <form:radiobutton path="plan"
							id="plan_daily" value="Daily" />Daily
					</label> &nbsp; &nbsp; &nbsp; <label> <form:radiobutton path="plan"
							id="plan_monthly" value="Monthly" />Monthly
					</label> &nbsp; &nbsp; &nbsp; <label> <form:radiobutton path="plan"
							id="plan_yearly" value="Yearly" />Yearly
					</label> <br>
					<form:errors path="plan" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:input path="finalPrice" type="hidden" class="form-control"
						id="final_price" placeholder="Final Price" readonly="true" />
				</div>
				<button type="submit" class="btn btn-primary" >Get Pass</button>
			</form:form>
		</div>
	</div>
</div>
<jsp:include flush="true" page="../includes/footer.jsp"></jsp:include>
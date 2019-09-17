<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Vehicle</title>
<script src="functions.js">	
</script>
</head>
<body align="center">

	<h2>Add Your Vehicle</h2>
	<form action="AddVehicleServlet" method="post" onsubmit="return vehicleSelectionValidation(this)">
		<table align="center" style="text-align: left" cellpadding="10">
			<tr>
				<td><label>Vehicle Name</label></td>
				<td><input name="vehicle_name" type="text" placeholder="Vehicle Name"
					size="60%" pattern="[A-Z a-z]*" required></td>
			</tr>
			<tr>
				<td><label>Vehicle Type</label></td>
				<td><select name="typeOfVehicle">
						<option disabled selected>--Select-Type--</option>
						<option value="Cycle">Cycle</option>
						<option value="MotorCycle">MotorCycle</option>
						<option value="Four Wheelers">Four Wheelers</option>
				</select></td>
			</tr>
			<tr>
				<td><label>Vehicle Number</label></td>
				<td><input name="vehicleNumber" type="text"
					placeholder="Vehicle Number" size="60%" pattern="^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}$" required ></td>
			</tr>
			<tr>
				<td><label>Employee Email</label></td>
				<td><input name="email" type="text" size="60%"
					value="<%=session.getAttribute("email")%>" readonly ></td>
			</tr>
			<tr>
				<td><label>Identification</label></td>
				<td><textarea name="vehicleIdentification"
						placeholder="Identification" cols="60"></textarea></td>
			</tr>
		</table>
		<input name="addVehicleButton" type="submit" value="Add">
	</form>
</body>
</html>
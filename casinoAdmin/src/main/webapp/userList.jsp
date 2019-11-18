<%@page import="org.hibernate.Session"%>
<%@page
	import="org.nagarro.tanzeem.casinoAdmin.sessionConfiguration.SessionUtil"%>
<%@page
	import="org.nagarro.tanzeem.casinoAdmin.service.CustomerRegisterService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.nagarro.tanzeem.casinoAdmin.model.Customer"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<script
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap.min.js"></script>
<style>
/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 300px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	background-color: #fefefe;
	margin: auto;
	padding: 20px;
	border: 1px solid #888;
	width: 30%;
}

/* The Close Button */
.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}

#fieldBox {
	border: 1px solid;
	padding: 10px;
	box-shadow: 5px 10px;
}

#tableField {
	box-shadow: 5px 5px #888888;
}

#button {
	background-color: #000000;
	color: #ffffff;
	border-radius: 8px;
	padding: 7px 20px;
}
</style>
<script>
	$(document).ready(function() {
		$('#tableField').DataTable();
	});

	$(function() {
		  $('.jquery input[pattern]').on('input', function() {
		    var pos = this.selectionStart;
		    var re = $(this).attr('pattern');
		    $(this).val($(this).val().match(re)[0]);
		    
		    // Restore caret position after setting value
		    this.setSelectionRange(pos, pos);
		  });
		});
</script>
</head>

<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">

			<ul class="nav navbar-nav">
				<li><a href="http://localhost:9999/casinoAdmin/">Home</a></li>
				<li><a href="http://localhost:9999/casinoAdmin/register.jsp">Register</a></li>
				<li class="active"><a href="#">User List</a></li>
			</ul>
			<div class="navbar-header" style="float: right">
				<a class="navbar-brand">Welcome to Casino Admin App!</a>
			</div>
		</div>
	</nav>
	<div style="padding-left: 20%; padding-right: 25%;">
		<h2 align=center>Search Box</h2>
		<fieldset id="fieldBox"
			style="padding-left: 10%; padding-top: 5%; border: 1px solid black;">

			<form action=search style="padding-bottom: 5%;">
				Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=text name=name
					required>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				Contact &nbsp;&nbsp;<input type=text name=contact required><br>
				<br> Email ID &nbsp;&nbsp;<input type=email name=email required>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

				<input type=submit value=Search style="width: 30%" id="button">
			</form>
		</fieldset>
	</div>
	<br>

	<fieldset style="padding-top: 5%; padding-left: 1%; padding-right: 1%">
		<table class="table table-striped" id="tableField"
			style="width: 100%; border-collapse: collapse;" border="1">
			<thead>


				<tr>
					<th scope="col" class="th-sm">S.No</th>
					<th scope="col" class="th-sm">Unique Id</th>
					<th scope="col" class="th-sm">Name</th>
					<th scope="col" class="th-sm">Date Of Birth</th>
					<th scope="col" class="th-sm">Contact</th>
					<th scope="col" class="th-sm">Email</th>
					<th scope="col" class="th-sm">Balance</th>
					<th scope="col" class="th-sm">Recharge</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usersList}" var="customer" varStatus="myIndex">
					<tr>
						<td>${myIndex.index + 1}</td>
						<td>${customer.uniqueId}</td>
						<td>${customer.custName}</td>
						<td>${customer.custDob}</td>
						<td>${customer.custContact}</td>
						<td>${customer.custEmail}</td>
						<td>${customer.custAccountBalance}</td>
						<td><button type="button" id="button" data-toggle="modal"
								data-target="#myModal${customer.uniqueId}">+</button> <!-- The Modal -->
							<div class="modal fade" id="myModal${customer.uniqueId}"
								data-backdrop="false">
								<div class="modal-dialog">
									<div class="modal-content" style="width: 65%">

										<!-- Modal Header -->
										<div class="modal-header">
											<h4 class="modal-title" style="float: left">
												<b>Recharge</b>
											</h4>
											<button type="button" class="close" style="float: right"
												data-dismiss="modal">&times;</button>
										</div>

										<!-- Modal body -->
										<div class="modal-body">
											<form action="rechargeBalance" method=POST>
												<input type=hidden name=secretKey
													value="${customer.uniqueId}"> <label class="jquery">Amount
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs&nbsp;<input
													type=number name=amount min=0 pattern="\d*(\.\d{0,2})?"
													step=0.01 required>
												</label> <br> <br>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<input type=submit value=Recharge id="button">
											</form>
										</div>

									</div>
								</div>
							</div></td>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>


</body>
</html>
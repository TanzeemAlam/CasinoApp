
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">


<script type="text/javascript">
	function validateFields() {
		var name = document.forms["form"]["name"].value;
		var dob = document.forms["form"]["dob"].value;
		var contact = document.forms["form"]["contact"].value;
		var email = document.forms["form"]["email"].value;
		var file = document.forms["form"]["file"].value;

		if (name == null || dob == null || contact == null || email == null
				|| file == null) {
			alert("Please enter all fields!!");
			return false;
		} else {
			alert("User registered successfully!!");
			return true;
		}
	}
</script>

<style>
#fieldBox {
	border: 1px solid;
	padding: 10px;
	box-shadow: 5px 10px;
}
#button{
	background-color: #000000;
	color: #ffffff;
	border-radius: 8px;
	padding: 7px 20px;
}
</style>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">

			<ul class="nav navbar-nav">
				<li><a href="http://localhost:9999/casinoAdmin/">Home</a></li>
				<li class="active"><a href="#">Register</a></li>
				<li><a href="http://localhost:9999/casinoAdmin/userList">User List</a></li>
			</ul>
			<div class="navbar-header" style="float: right">
				<a class="navbar-brand">Welcome to Casino Admin App!</a>
			</div>
		</div>
	</nav>

	<h2 align=center>Register</h2>
	<br>
	<div style="padding-left: 30%; padding-right: 30%;">
		<fieldset style="border: 1px solid black;" id="fieldBox">
			&nbsp;
			<form action="registerCustomer" enctype="multipart/form-data"
				name="form" style="padding-left: 25%;"
				onsubmit="return validateFields()">
				Name
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type=text name="name" id="name" required><br> <br>
				Date Of Birth &nbsp;<input type=date name="dob" id="dob" required><br>
				<br> Contact
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type=text name="contact" id="contact" required><br> <br>
				Email Id
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type=email name="email" id="email" required><br> <br>
				Identity Proof <input type=file name="file" size="30" required><br>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type=submit value=Register id="button" >
			</form>
		</fieldset>
	</div>
</body>
</html>
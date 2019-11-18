
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

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

	function validateFileType() {
		var fileName = document.getElementById("fileName").value;
		var idxDot = fileName.lastIndexOf(".") + 1;
		var extFile = fileName.substr(idxDot, fileName.length).toLowerCase();
		if (extFile == "jpg" || extFile == "png") {
		} else {
			alert("Only jpg and png files are allowed!");
			document.getElementById("fileName").value = "";
		}
	}

	function validateContact(evt) {
		var theEvent = evt || window.event;

		// Handle paste
		if (theEvent.type === 'paste') {
			key = event.clipboardData.getData('text/plain');
		} else {
			// Handle key press
			var key = theEvent.keyCode || theEvent.which;
			key = String.fromCharCode(key);
		}
		var regex = /[0-9]|\./;
		if (!regex.test(key)) {
			theEvent.returnValue = false;
			if (theEvent.preventDefault)
				theEvent.preventDefault();
		}
	}
</script>

<style>
#fieldBox {
	border: 1px solid;
	padding: 10px;
	box-shadow: 5px 10px;
}

#button {
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
				<li><a href="http://localhost:9999/casinoAdmin/userList">User
						List</a></li>
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
					type=text name="name" id="name"
					onkeypress="return /[a-z]/i.test(event.key)" required><br>
				<br> Date Of Birth &nbsp;<input type=date name="dob" id="dob"
					max="2001-11-01" required><br> <br> Contact
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type=text name="contact" id="contact" pattern="[1-9]{1}[0-9]{9}" maxlength="10"
					onkeypress='validateContact(event)' required><br> <br>
				Email Id
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type=email name="email" id="email" required><br> <br>
				Identity Proof <input type=file name="file" size="30" id="fileName"
					accept=".jpg,.png" onchange="return validateFileType()" required><br>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type=submit value=Register id="button">
			</form>
		</fieldset>
	</div>
</body>
</html>

<!DOCTYPE html>
<html>
<style type="text/css">
	body{
	margin: 0 auto;
	background-image: url("images/cafe.jpg");
	background-repeat: no-repeat;
	background-size: 100% 720px;
}

.container{
	width: 500px;
	height: 450px;
	text-align: center;
	margin: 0 auto;
	background-color: rgba(44, 62, 80,0.7);
	margin-top: 160px;
}

.container img{
	width: 150px;
	height: 150px;
	margin-top: -60px;
}

input[type="text"],input[type="password"]{
	margin-top: 30px;
	height: 45px;
	width: 300px;
	font-size: 18px;
	margin-bottom: 20px;
	background-color: #fff;
	padding-left: 40px;
}

.form-input::before{
	content: "\f007";
	font-family: "FontAwesome";
	padding-left: 07px;
	padding-top: 40px;
	position: absolute;
	font-size: 35px;
	color: #2980b9; 
}

.form-input:nth-child(2)::before{
	content: "\f023";
}

.btn-login{
	padding: 15px 25px;
	border: none;
	background-color: #27ae60;
	color: #fff;
}
h1{
	color:#fff;
}
</style>
<head>
	<title>Đăng Nhập</title>
	<link rel="stylesheet" a href="css\style.css">
	<link rel="stylesheet" a href="css\font-awesome.min.css">
</head>
<body>
	<div class="container">
		<h1> Đăng Nhập </h1>
		<form action="xulydangky.php" method="POST">
			<div class="form-input">
				<input type="text" name="name" placeholder="Nhập tên">
			</div>
			<div class="form-input">
				<input type="text" name="email" placeholder="Nhập email"/>	
			</div>
			<div class="form-input">
				<input type="password" name="password" placeholder="password"/>
			</div>
			<input type="submit" name="submit" value="Đăng Ký" class="btn-login"/>
			
		</form>
	</div>
</body>
</html>
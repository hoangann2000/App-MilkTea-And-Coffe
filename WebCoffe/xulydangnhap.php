<?php
	include("connect.php");

	if (isset($_POST['submit'])) {
		# code...
		$email = $_POST['email'];
		$password =$_POST['password'];
		
		$sql="SELECT * FROM users WHERE email='$email' AND password='$password'";
		$query=mysqli_query($conn,$sql);

		$num_row = mysqli_num_rows($query);

		if($num_row!=0){
			echo "Đăng nhập thành công";
			header("location:admin.php");
		}else{
			echo "Tên hoặc mật khẩu không đúng";
		}
	}

?>
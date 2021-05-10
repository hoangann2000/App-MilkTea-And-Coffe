<?php
	include("connect.php");
	$name = $_POST['name'];
	$email = $_POST['email'];
	$password =$_POST['password'];
	 
	if(strlen($name)>0 &&strlen($email)>0 &&strlen($password)>0) {
		$query = "INSERT INTO users(name,email,password) VALUES ('$name','$email','$password')";
		if(mysqli_query($conn,$query)) {
			$result["success"]="1";
			$result["massage"]="success";

			echo json_encode($result);
			mysqli_close($conn);
		}else{
			$result["success"]="0";
			$result["massage"]="error";

			echo json_encode($result);
			mysqli_close($conn);
		
		}

	}
?> 
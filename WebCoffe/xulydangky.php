<<?php 
include("connect.php");
if (isset($_POST['submit'])) {
	# code...
	$name =$_POST['name'];
	$email = $_POST['email'];
	$password = $_POST['password'];


		# code...
			$sql="INSERT INTO users (name,email,password) VALUES ('$name','$email','$password')";
		$query=mysqli_query($conn,$sql);

		header("location:dangnhap.php");

}else{
	echo "Hãy nhập đầy đủ";
}
 ?>

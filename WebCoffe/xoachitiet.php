<?php
include("connect.php");
	if(isset($_GET['id'])) {
		$id=$_GET['id'];
		$query="DELETE FROM chitietdonhang WHERE id='$id'";
		mysqli_query($conn,$query);
		header("location:chitietdonhang.php");
	}
?>
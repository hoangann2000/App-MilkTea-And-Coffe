<?php
	include("connect.php");
	$tenkhachhang = $_POST['tenkhachhang'];
	$sodienthoai = $_POST['sodienthoai'];
	$diachi =$_POST['diachi'];
	if(strlen($tenkhachhang)>0 &&strlen($sodienthoai)>0 &&strlen($email)>0) {
		$query = "INSERT INTO donhang(id,tenkhachhang,sodienthoai,diachi) VALUES (NUll,'$tenkhachhang','$sodienthoai','$diachi')";
		if(mysqli_query($conn,$query)) {
			$iddonhang = $conn->insert_id;
			echo $iddonhang;
		}else{
			echo "fail";
		}
	}else {
		echo "kiem tra lai";
	}
?> 
<?php
	include("connect.php");
	$result = "SELECT * FROM loaisanpham";
	$data=$conn->query($result);
		$mangloaisanpham = array();
	while ($row = mysqli_fetch_assoc($data)) {
		# code...
		array_push($mangloaisanpham, new Loaisp(
			$row["id"],
			$row['tenloaisanpham'],
			$row['hinhanhloaisanpham']));
	}
	class Loaisp{
		function Loaisp($id,$tenloaisanpham,$hinhanhloaisanpham){
			$this->id=$id;
			$this->tenLoaisp=$tenloaisanpham;
			$this->hinhanhloaisp=$hinhanhloaisanpham;
		}
	}
	
	echo json_encode($mangloaisanpham);
?>

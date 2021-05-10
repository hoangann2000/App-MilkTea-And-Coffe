<?php
	include("connect.php");
	$result = "SELECT * FROM sanpham ORDER BY id ASC LIMIT 8";
	$data=$conn->query($result);
		$mangsanpham = array();
	while ($row = mysqli_fetch_assoc($data)) {
		# code...
		array_push($mangsanpham, new Sanpham(
			$row["id"],
			$row['tensanpham'],
			$row['giasanpham'],
			$row['hinhanhsanpham'],
			$row['motasanpham'],
			$row['idsanpham']));
	}
	class Sanpham{
		function Sanpham($id,$tensanpham,$giasanpham,$hinhanhsanpham,$motasanpham,$idsanpham){
			$this->id=$id;
			$this->temsanpham=$tensanpham;
			$this->giasanpham=$giasanpham;
			$this->hinhanhsanpham=$hinhanhsanpham;
			$this->motasanpham=$motasanpham;
			$this->idsanpham=$idsanpham;
		}
	}
	
	echo json_encode($mangsanpham);
?>

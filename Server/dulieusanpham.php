<?php
 	include "connect.php";
 	$space = 5;
 	$idsp = 1;
 	$limit = ($space - 1) * $space;
 	$mangsanpham = array();
 	$query = "SELECT * FROM sanpham WHERE $idsp = idsanpham";
 	$data = mysqli_query($conn, $query);
 	while ($row= mysqli_fetch_assoc($data)) {
 		array_push($mangsanpham, new Sanpham(
 			$row['id'],
 			$row['tensanpham'],
 			$row['giasanpham'],
 			$row['hinhanhsanpham'],
 			$row['motasanpham'],
 			$row['idsanpham']));
 		# code...
 	}
 	class Sanpham{
 		function Sanpham($id, $tensanpham, $giasanpham, $hinhanhsanpham,$motasanpham,$idsanpham){
 			$this->id=$id;
 			$this->tensanpham=$tensanpham;
 			$this->giasanpham=$giasanpham;
 			$this->hinhanhsanpham=$hinhanhsanpham;
 			$this->motasanpham=$motasanpham;
 			$this->idsanpham=$idsanpham;
 		}
 	}
 	echo json_encode($mangsanpham);
 ?>
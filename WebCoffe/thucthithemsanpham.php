<<?php 
include("connect.php");
if (isset($_POST['submit'])) {
   # code...
	$tensanpham = $_POST['tensanpham'];
	$giasanpham= $_POST['giasanpham'];
	$hinhanhsanpham = $_POST['hinhanhsanpham'];
	$motasanpham = $_POST['motasanpham'];
	$idsanpham = $_POST['idsanpham'];
  


      # code...
         $sql="INSERT INTO sanpham (tensanpham,giasanpham,hinhanhsanpham,motasanpham,idsanpham) VALUES ('$tensanpham','$giasanpham','$hinhanhsanpham','$motasanpham','$idsanpham')";
      $query=mysqli_query($conn,$sql);

      header("location:chitietsanpham.php");

}else{
   echo "Hãy nhập đầy đủ";
}
 ?>

<?php
 session_start();
 require_once("connect.php");
 $id=$_POST['id'];
 $madonhang=$_POST['madonhang'];
 $masanpham=$_POST['masanpham'];
 $tensanpham = $_POST['tensanpham'];
 $giasanpham = $_POST['giasanpham'];
 $soluongsanpham = $_POST['soluongsanpham'];
 // session này cho biết chúng ta cần phải where từ thuộc tính nào
    $Origniduser = $_SESSION['saveiduser'];
 
 // sữa ID user 
   $sql = "update chitietdonhang set id='".$id."' where id='".$Origniduser."'";
   $query = mysqli_query($conn,$sql);
 
 // sữa username
   $sql = "update chitietdonhang set madonhang='".$madonhang."' where id='".$Origniduser."'";
   $query = mysqli_query($conn,$sql);
 
 // sữa password
   $sql = "update chitietdonhang set masanpham='".$masanpham."' where id='".$Origniduser."'";
   $query = mysqli_query($conn,$sql);

   $sql = "update chitietdonhang set tensanpham='".$tensanpham."' where id='".$Origniduser."'";
   $query = mysqli_query($conn,$sql);


   $sql = "update chitietdonhang set giasanpham='".$giasanpham."' where id='".$Origniduser."'";
   $query = mysqli_query($conn,$sql);


   $sql = "update chitietdonhang set soluongsanpham='".$soluongsanpham."' where id='".$Origniduser."'";
   $query = mysqli_query($conn,$sql);

   header("location: chitietdonhang.php");
?>
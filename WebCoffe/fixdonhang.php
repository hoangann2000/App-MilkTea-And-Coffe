<?php
 session_start();
 require_once("connect.php");
 $id=$_POST['id'];
 $tenkhachhang=$_POST['tenkhachhang'];
 $sodienthoai=$_POST['sodienthoai'];
 $diachi = $_POST['diachi'];
 // session này cho biết chúng ta cần phải where từ thuộc tính nào
    $Origniduser = $_SESSION['saveiduser'];
 
 // sữa ID user 
   $sql = "update donhang set id='".$id."' where id='".$Origniduser."'";
   $query = mysqli_query($conn,$sql);
 
 // sữa username
   $sql = "update donhang set tenkhachhang='".$tenkhachhang."' where id='".$Origniduser."'";
   $query = mysqli_query($conn,$sql);
 
 // sữa password
   $sql = "update donhang set sodienthoai='".$sodienthoai."' where id='".$Origniduser."'";
   $query = mysqli_query($conn,$sql);

   $sql = "update donhang set diachi='".$diachi."' where id='".$Origniduser."'";
   $query = mysqli_query($conn,$sql);

   header("location: donhang.php");
?>
<?php
 session_start();
 require_once("connect.php");
 $id=$_POST['id'];
 $name=$_POST['name'];
 $email=$_POST['email'];
 $password = $_POST['password'];
 // session này cho biết chúng ta cần phải where từ thuộc tính nào
    $Origniduser = $_SESSION['saveiduser'];
 
 // sữa ID user 
   $sql = "update users set id='".$id."' where id='".$Origniduser."'";
   $query = mysqli_query($conn,$sql);
 
 // sữa username
   $sql = "update users set name='".$name."' where id='".$Origniduser."'";
   $query = mysqli_query($conn,$sql);
 
 // sữa password
   $sql = "update user set email='".$email."' where id='".$Origniduser."'";
   $query = mysqli_query($conn,$sql);

   $sql = "update user set password='".$password."' where id='".$Origniduser."'";
   $query = mysqli_query($conn,$sql);

   header("location: khachhang.php");
?>
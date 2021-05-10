<<?php 
include("connect.php");
if (isset($_POST['submit'])) {
   # code...
   $tenkhachhang =$_POST['tenkhachhang'];
   $sodienthoai = $_POST['sodienthoai'];
   $diachi = $_POST['diachi'];


      # code...
         $sql="INSERT INTO donhang (tenkhachhang,sodienthoai,diachi) VALUES ('$tenkhachhang','$sodienthoai','$diachi')";
      $query=mysqli_query($conn,$sql);

      header("location:donhang.php");

}else{
   echo "Hãy nhập đầy đủ";
}
 ?>

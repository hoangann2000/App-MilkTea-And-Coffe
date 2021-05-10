<?php
       include("connect.php");
        $sql ="SELECT * from sanpham";
        $query = mysqli_query($conn,$sql);
        
 if(mysqli_num_rows($query)>0){

        echo "<table class='w3-table w3-striped w3-bordered'>";
        echo "<tr>";
        echo "<div style='background-color: skyblue'>";
           echo "<td id='ok' style='border:1px solid black' style='background-color: skyblue'>";
             echo "Id";
           echo "</td>";

           echo "<td id='ok' style='border:1px solid black' style='background-color: skyblue'>";
             echo "Tên Sản Phẩm";
           echo "</td>";

           echo "<td id='ok' style='border:1px solid black' style='background-color: skyblue'>";
             echo "Giá Sản Phẩm";
           echo "</td>";

              echo "<td id='ok' style='border:1px solid black' style='background-color: skyblue'>";
             echo "Hình ảnh sản phẩm";
           echo "</td>";

           echo "<td id='ok' style='border:1px solid black' style='background-color: skyblue'>";
             echo "Mô tả sản phẩm";
           echo "</td>";

           echo "<td id='ok' style='border:1px solid black' style='background-color: skyblue'>";
             echo "Id sản phẩm";

        echo "</tr>";
        while($dong = mysqli_fetch_array($query)){
        echo "<tr>";
            error_reporting(0);
            echo "<td style='border:1px solid black'>".$dong['id']."</td>";
            echo "<td style='border:1px solid black'>".$dong['tensanpham']."</td>";
            echo "<td style='border:1px solid black'>".$dong['giasanpham']."</td>";
            echo '<td> <img src='.$dong['hinhanhsanpham'].'/> </td>';
            echo "<td style='border:1px solid black'>".$dong['motasanpham']."</td>";
            echo "<td style='border:1px solid black'>".$dong['idsanpham']."</td>";

            echo "<td style='border:1px solid black'><a href='xoasanpham.php?id=".$dong['id']."'>Xóa</a></td>";
            echo "<td style='bolder:1px solid black'><a href='suasanpham.php?id=".$dong['id']."'>Sửa</a></td>";  
        echo "</tr>";}
        echo "</table>";
    }
  


?>
<br/>


<<!DOCTYPE html>
<html>
<title>Chi tiet san pham</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style type="text/css">
   #ok{
    padding: 8px 8px;
    display: table-cell;
    text-align: left;
    vertical-align: top;
    background-color: #00FF99;
  }
  .btn-login{
  padding: 15px 25px;
  border: none;
  background-color: #27ae60;
  color: #fff;
  margin-left: 30px;
  margin-right: 30px;
} 
</style>
<body>
  <button onclick="location.href='themsanpham.php'" type="button" class="btn-login">Thêm sản phẩm</button>
  <button onclick="location.href='admin.php'" type="button" class="btn-login">Trang Chủ</button>
 

</body>
</html> 

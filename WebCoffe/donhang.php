<?php
	include"connect.php";
	$sql="SELECT * FROM donhang ";
	$query=mysqli_query($conn,$sql);

	if(mysqli_num_rows($query)>0){
		echo "<table class='w3-table w3-striped w3-bordered'>";
        echo "<tr>";
        echo "<div style='background-color: skyblue'>";
           echo "<td id='ok' style='border:1px solid black' style='background-color: skyblue'>";
             echo "Id";
           echo "</td>";

           echo "<td id='ok' style='border:1px solid black' style='background-color: skyblue'>";
             echo "Tên Khách Hàng";
           echo "</td>";

           echo "<td id='ok' style='border:1px solid black' style='background-color: skyblue'>";
             echo "Số Điện Thoại";
           echo "</td>";

           echo "<td id='ok' style='border:1px solid black' style='background-color: skyblue'>";
             echo "Địa Chỉ";
           echo "</td>";

        echo "</tr>";
        while($dong = mysqli_fetch_array($query)){
        echo "<tr>";
            error_reporting(0);
            echo "<td style='border:1px solid black'>".$dong['id']."</td>";
            echo "<td style='border:1px solid black'>".$dong['tenkhachhang']."</td>";
            echo "<td style='border:1px solid black'>".$dong['sodienthoai']."</td>";
            echo "<td style='border:1px solid black'>".$dong['diachi']."</td>";

             echo "<td style='border:1px solid black'><a href='xoadonhang.php?id=".$dong['id']."'>Xóa</a></td>";
                echo "<td style='border:1px solid black'><a href='suadonhang.php?id=".$dong['id']."'>Sửa</a></td>";  
        echo "</tr>";}
        echo "</table>";
    }
  


?>
<br/>


<!DOCTYPE html>
<html>
<title>don hang</title>
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
	<button onclick="location.href='themdonhang.php'" type="button" class="btn-login">Thêm Đơn Hàng</button>
	<button onclick="location.href='admin.php'" type="button" class="btn-login">Trang Chủ</button>
	

</body>
</html> 

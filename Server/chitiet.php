<?php
	include("connect.php");
	if(isset($_GET['ct'])){
		$id=$_GET['ct'];
		$result="SELECT * FROM sanpham WHERE id=$id";
		$select=$con->query($result);
		$row=$select->fetch_assoc();
	}
echo "<table class='bangchitiec'>";
    	echo "<tr>";
        echo "<th> Tên sản phẩm</th>";
		echo "<th> Chi tiếc sản phẩm</th>";
		echo "<th> Gía sản phẩm</th>";
		echo "<th> Hình đại diện</th>";
        echo "</tr>";
        echo "<tr>";
        echo "<td>".$row['tensanpham']."</td>";
        echo "<td>".$row['motasanpham']."</td>";
		echo "<td> ".$row['giasanpham']."</td>";
		echo "<td> <img width='150px' height='80px' src='".$row['hinhanhsp']."'></td>";
       echo " </tr>";
   echo " </table>";

	
?>
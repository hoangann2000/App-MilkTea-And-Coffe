<?php
	include("connect.php");
	

		$query = "SELECT hinhanhsanpham FORM sanpham WHERE id = '$id'";
		$result = mysql_query($query, $connect);
		$row = mysql_fetch_array($result);
		echo '<img src='.$row['link_img'].' />';
 ?>
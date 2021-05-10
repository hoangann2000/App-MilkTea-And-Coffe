<?php 
	$host = "localhost";
	$username = "root";
	$password ="";
	$database ="appcoffe";
	$conn = mysqli_connect($host,$username,$password,$database);
	mysqli_query($conn,"SET NAMES 'utf8'");
	if ($conn) {
		echo "";
	}else
{
	echo "ket noi that bai";
}
?>
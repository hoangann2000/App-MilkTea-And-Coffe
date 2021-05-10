<?php
session_start();
$id=$_GET['id'];
//$_SESSION['saveiduser']=$iduser;

require_once("connect.php");

        $sql ="select*from chitietdonhang where id='".$id."'";
        $query = mysqli_query($conn,$sql);
        while($dong = mysqli_fetch_array($query)){
          $_SESSION['saveiduser'] = $dong['id'];
?>
<!DOCTYPE html>
<html>

<style>
input[type=text], select {
  width: 100%;
 padding: 20px;
  margin: 12px;
}

input[type=submit] {
	padding: 20px 25px;
	border: none;
	background-color: #0000FF;
	color: #fff;
	margin-left: 200px;
	margin-right: 30px;
}

div {
  padding-left: 500px;
  padding-right:500px;
}
</style>
<body>



<div>
  <form action="fixctdh.php" method="POST">
    <label for="fname">ID</label>
    <?php 
    echo "<input type='text' id='fname' name='id' value='".$dong['id']."'>";
    ?>

     <label for="fname">Mã Đơn Hàng</label>
    <?php 
    echo "<input type='text' id='fname' name='madonhang' value='".$dong['madonhang']."'>";
    ?>

    <label for="lname">Mã Sản Phẩm</label>
    <?php 
    echo "<input type='text' id='fname' name='masanpham' value='".$dong['masanpham']."'>";
    ?>

    <label for="fname">Tên Sản Phẩm</label>
    <?php 
    echo "<input type='text' id='fname' name='tensanpham' value='".$dong['tensanpham']."'>";
    ?>

    <label for="fname">Giá Sản Phẩm</label>
    <?php 
    echo "<input type='text' id='fname' name='giasanpham' value='".$dong['giasanpham']."'>";
    ?>

    <label for="fname">Số lượng sản phẩm</label>
    <?php 
    echo "<input type='text' id='fname' name='soluongsanpham' value='".$dong['soluongsanpham']."'>";
  } ?>

    <input type="submit" value="Chấp nhận">
  </form>
</div>

</body>
</html>	
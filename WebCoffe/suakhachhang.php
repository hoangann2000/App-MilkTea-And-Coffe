<?php
session_start();
$id=$_GET['id'];
//$_SESSION['saveiduser']=$iduser;

require_once("connect.php");

        $sql ="select*from users where id='".$id."'";
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
  <form action="fixkhachhang.php" method="POST">
    <label for="fname">ID</label>
    <?php 
    echo "<input type='text' id='fname' name='id' value='".$dong['id']."'>";
    ?>

     <label for="fname">name</label>
    <?php 
    echo "<input type='text' id='fname' name='name' value='".$dong['name']."'>";
    ?>

    <label for="lname">email</label>
    <?php 
    echo "<input type='text' id='fname' name='email' value='".$dong['email']."'>";
    ?>

    <label for="fname">password</label>
    <?php 
    echo "<input type='text' id='fname' name='password' value='".$dong['password']."'>";
    }?>
    <input type="submit" value="Chấp nhận">
  </form>
</div>

</body>
</html>	
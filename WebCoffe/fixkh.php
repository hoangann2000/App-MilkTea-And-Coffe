<?php
include"connect.php";
$id=$_GET['id'];
  $sql="SELECT * FROM users WHERE '$id'";
  $query=mysqli_query($conn,$sql);
        while($dong = mysqli_fetch_array($query)){
?>
<!DOCTYPE html>
<html>

<body>



<div>
  <form action="fixkh.php" method="POST">
    <label for="fname">ID user</label>
    <?php 
    echo "<input type='text' id='fname' name='id' value='".$dong['id']."'>";
    ?>

    <label for="lname">username</label>
    <?php 
    echo "<input type='text' id='fname' name='email' value='".$dong['email']."'>";
    ?>

    <label for="fname">password</label>
    <?php 
    echo "<input type='text' id='fname' name='password' value='".$dong['password']."'>";
    }?>
    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>
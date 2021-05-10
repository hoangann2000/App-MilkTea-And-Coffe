<!DOCTYPE html>
<html>
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<body>

<h3>Nhập thông tin muốn thêm vào database</h3>

<div>
  <form action="thucthithemproduct.php" method="POST">
    <label for="fname">idproduct</label>
    <?php 
    echo "<input type='text' id='fname' name='idproduct'>";
    ?>
    

    <label for="lname">productname</label>
    <?php 
    echo "<input type='text' id='fname' name='productname'>";
    ?>

    <label for="fname">price</label>
    <?php 
    echo "<input type='text' id='fname' name='price'>";
    ?>

    <label for="fname">soluong</label>
    <?php 
    echo "<input type='text' id='fname' name='soluong'>";
    ?>

    <label for="fname">motasanpham</label>
    <?php 
    echo "<input type='text' id='fname' name='motasanpham'>";
    ?>

    <label for="fname">url</label>
    <?php 
    echo "<input type='text' id='fname' name='url'>";
    ?>

    <label for="fname">tag</label>
    <?php 
    echo "<input type='text' id='fname' name='tag'>";
    ?>
    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>
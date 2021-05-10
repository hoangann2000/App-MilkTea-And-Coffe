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


<div>
  <form action="thucthithemsanpham.php" method="POST">
  

     <label for="fname">Tên sản phẩm</label>
   <input type='text' id='fname' name='tensanpham'/>


    <label for="lname">Giá sản phẩm</label>
     <input type='text' id='fname' name='giasanpham' />


    <label for="fname">Hình ảnh sản phẩm</label>
    <input type='text' id='fname' name='hinhanhsanpham'/>


    <label for="fname">Mô tả sản phẩm</label>
    <input type='text' id='fname' name='motasanpham'/>


    <label for="fname">id Sản phẩm</label>
    <input type='text' id='fname' name='idsanpham'/>

    <input type="submit" name="submit" value="Chấp Nhận">
  </form>
</div>

</body>
</html>
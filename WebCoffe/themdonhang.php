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
  <form action="insertdonhang.php" method="POST">
  

     <label for="fname">Tên Khách Hàng</label>
   <input type='text' id='fname' name='tenkhachhang'/>


    <label for="lname">Số điện thoại</label>
     <input type='text' id='fname' name='sodienthoai' />


    <label for="fname">Địa Chỉ</label>
    <input type='text' id='fname' name='diachi'/>

    <input type="submit" name="submit" value="Chấp Nhận">
  </form>
</div>

</body>
</html>	
<?php
ob_start();

if(isset($_POST['dangxuat'])){
		setcookie('dangnhap',$_POST['dangnhap'],time()-3600);
		setcookie('matkhau',$_POST['matkhau'],time()-3600);
		if(headers_sent()){
					die('<script type="text/javascript">window.location.href="'."dangnhap.php".'"</script>'); 
				}else{
					header("location:index.php");
					die();
					ob_enf_fluch();
				}
	}
if(isset($_COOKIE['dangnhap']) &&  isset($_COOKIE['matkhau'])){
			$matkhau=md5($_COOKIE['matkhau']);
			include("connect.php");
			$result="SELECT * FROM taikhoan WHERE matkhau='$matkhau'";
			$select=mysqli_query($con, $result);
			$row=$select->fetch_array();
			
}else{
	header("location:index.php");
		
}
 ?>
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <style>
#banner{
	margin-left:100px;
	background-image:url(backgound1.jpeg);
	width:1200px;
	height:250px;
	background-size:1200px 250px;
}
div.dinhdang{
	display:inline-block;
	background-color:#d3d3d3;
	border:2px dotted #FF0000;
	margin-left:100px;
	margin-top:20px;	
	width:500px;
	height:400px;
}
ul li{
	font-size:20px;
	margin-bottom:20px;
	list-style:none;
	margin-left:0px;	
}
div.dinhdang h3{
	text-align:center;
	color:#F00;
	border-bottom:2px dotted #FF0000;
}
body{
	position:relative;
	background-image:url(go.jpg);
	background-repeat:repeat;
	background-size:1500px 1000px;
}

#dangxuat{
	cursor:pointer;
	margin:12px;
	background-color:#a9a9a9;
	height:45px;
	color:#FFF;
	box-shadow: 3px 1px 8px 8px #FFF;
}
#dangxuat{
	position:absolute;
	margin-top:30px;
	cursor:pointer;
	margin-left:200px;
}
div.sanpham{
	margin-top:20px;
	position:absolute;
	display:inline-block;
	margin-left:100px;
	float:right;
}
div.sanpham ul li{	
	
}
div.sanpham ul li a{
	position:inherit;
	margin-bottom:20px;
	font-size:45px;
	font-weight:bold;
	color:#003;
	text-decoration:none;	
}
div.sanpham a:hover{
	color:#F00;
}

	
 </style>
 </head>
 <body>
 <div id="banner" > </div>
 <div class="dinhdang">
	<h3> Thông Tin Cá Nhân</h3> 	
    <div class="acb"> 
    	<ul>
        
        	<li> Họ Và Tên :  <?php echo $row['Ho'].' '.$row['Ten'] ?></li>
            <li> Giới Tính : <?php echo $row['GioiTinh'] ?></li>
            <li> Email : <?php echo $row['Email'] ?></li>
			<li> Địa Chỉ : <?php echo $row['diachi'] ?></li>
            <li> SĐT : <?php echo $row['SDT'] ?> </li>
        </ul>
    </div>
    
     <form method="post" action="">
            <div class="adangxuat"> <a href="" ></a><input type="submit" name="dangxuat" value="đăng xuất" id="dangxuat"></div>
     	 </form> 
     
 </div>
 <div class="sanpham">
            <ul>
          	  <li> <a href="danhsachpsanpham.php" > Danh Sách Sản Phẩm</a></li>
            	<li> <a href="themsanpham.php" > Thêm Danh Sách Sản Phẩm </a></li>
                <li> <a href="doanhthu.php" > Doanh Thu </a></li>
            </ul>
      </div>
 </body>
 </html>
 
 <!-- <form method="post" action="">
            <div class="adangxuat"> <a href="" ></a><input type="submit" name="dangxuat" value="đăng xuất" id="dangxuat"></div>
            </form>
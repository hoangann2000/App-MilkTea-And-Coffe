<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Cafe</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    
    <link rel="stylesheet" href="css/TrangChu.css">
    <link rel="stylesheet" href="css/menu.css"> 
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <link href="https://fonts.googleapis.com/css?family=Akronim|Lobster|Playball" rel="stylesheet">       
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script>
      $(document).ready(function(){
        // Add smooth scrolling to all links
        $("a").on('click', function(event) {

        // Make sure this.hash has a value before overriding default behavior
        if (this.hash !== "") {
          // Prevent default anchor click behavior
          event.preventDefault();

          // Store hash
          var hash = this.hash;

          // Using jQuery's animate() method to add smooth page scroll
          // The optional number (800) specifies the number of milliseconds it takes to scroll to the specified area
          $('html, body').animate({
          scrollTop: $(hash).offset().top
          }, 800, function(){
         
          // Add hash (#) to URL when done scrolling (default click behavior)
          window.location.hash = hash;
          });
        } // End if
        });
      });
      </script>
    
  </head>
<body>
  <div class="TrangChu" id="TrangChu" style="" >
    <header id="TrangChu" class="">           
          <div class="menu">
              <nav class="navbar navbar-inverse navbar-static-top navbar-fixed-top">
                <div class="container-fluid">
                  <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>                        
                    </button>           
                  </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav" style="width: 100%;text-align: center;">       
                    <li style="float: none; display: inline-block"><a href="#TrangChu" >Trang Chủ</a></li>            
                    <li style="float: none; display: inline-block"><a href="chitietsanpham.php" >Sản Phẩm</a></li>      
                     <li style="float: none; display: inline-block"><a href="khachhang.php" >Khách hàng</a></li>      
                      <li style="float: none; display: inline-block"><a href="donhang.php" >Đơn hàng</a></li>      
                      <li style="float: none; display: inline-block"><a href="chitietdonhang.php" >Ct Đơn Hàng</a></li>   
                      
                    </ul>           
                </div>
                </div>
              </nav>  
          </div>

          
          <div class="banner row" id="banner">    
            <div class="parallax text-center" >
              <div class="parallax-pattern-overlay">
                <div class="container text-center" style="padding-top:170px;">
                  <a href="#"><img class="w3-container w3-center w3-animate-top logo" src="images/logo.png" alt="logo"></a>
                    <p class="w3-container w3-center w3-animate-zoom">
                      <span> 1 phút để ấm lòng<span>
                    </p>
                </div>
              </div>
            </div>
          </div>  
                
        </header>   
    </div>
    
  
    
    
  </body>
</html>
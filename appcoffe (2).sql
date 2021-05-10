-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 29, 2020 at 12:05 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `appcoffe`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `id` int(11) NOT NULL,
  `madonhang` int(11) NOT NULL,
  `masanpham` int(11) NOT NULL,
  `tensanpham` varchar(150) NOT NULL,
  `giasanpham` int(11) NOT NULL,
  `soluongsanpham` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`id`, `madonhang`, `masanpham`, `tensanpham`, `giasanpham`, `soluongsanpham`) VALUES
(3, 1, 2, 'TOKIBOKI', 12000, 2),
(4, 3, 3, 'Trà sữa trân châu đường đen', 12000, 2);

-- --------------------------------------------------------

--
-- Table structure for table `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `tenkhachhang` varchar(150) NOT NULL,
  `sodienthoai` varchar(150) NOT NULL,
  `diachi` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `donhang`
--

INSERT INTO `donhang` (`id`, `tenkhachhang`, `sodienthoai`, `diachi`) VALUES
(1, 'abcđé', '12332323', '279 Trần Đại Nghĩa'),
(2, 'abc', '12332323', '43 Phan Thanh '),
(3, 'ngocc', '6359448552', 'Đại học CNTT'),
(4, 'annnn', '1234567890', '65 Trưng Nữ Vương'),
(5, 'a', '123', '172 Lê Văn Hiến'),
(6, 'a', '1', 'd'),
(7, 'dsad', 'sad', '´d'),
(8, 'dsad', 'sad', '´d'),
(9, 'long', '03266252', 'dn'),
(10, 'd´', 'sad', '´d'),
(11, 'annn', '2323', '321'),
(12, 'annn', '2323', '321'),
(15, 'ád', 'ád', 'ád'),
(16, 'ds', 'sad', 'sad'),
(17, 'testtttttttttttttttt', '123', 'hue'),
(18, '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `id` int(11) NOT NULL,
  `tenloaisanpham` varchar(100) NOT NULL,
  `hinhanhloaisanpham` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `loaisanpham`
--

INSERT INTO `loaisanpham` (`id`, `tenloaisanpham`, `hinhanhloaisanpham`) VALUES
(1, 'Cafe', 'https://images.foody.vn/res/g70/690732/prof/s280x175/foody-upload-api-foody-mobile-2q-jpg-181204171627.jpg'),
(2, 'Sinh Tố', 'https://images.foody.vn/res/g90/895572/prof/s280x175/beauty-upload-api-file_bee99f86-edb2-4009-b6d9-e6f31e11463e-200522115315.jpeg'),
(3, 'Trà Sữa', 'https://images.foody.vn/res/g15/144507/prof/s280x175/foody-upload-api-foody-mobile-seatalk_img_15868599-200414173004.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(100) NOT NULL,
  `giasanpham` int(20) NOT NULL,
  `hinhanhsanpham` varchar(2000) NOT NULL,
  `motasanpham` varchar(2000) NOT NULL,
  `idsanpham` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensanpham`, `giasanpham`, `hinhanhsanpham`, `motasanpham`, `idsanpham`) VALUES
(1, 'Cafe kem gừng', 30000, 'https://images.foody.vn/res/g20/198021/prof/s280x175/foody-upload-api-foody-mobile-huy-coffee-cafe-sach-180622095941.jpg', 'Cà Phê Có Gừng là sự pha trộn độc đáo giữa cà phê nóng và lớp kem sữa dừa mềm - mịn - mát.\r\nTrà Gừng Có Cả Sữa lại là bản hoà tấu thú vị giữa trà ấm, sữa đậu nành thơm và hương vị cốt dừa \"cộp mác\" Cộng. \r\nCặp đôi \"Gừng Mới\" hứa hẹn sẽ là thức uống không thể thiếu trong mỗi cuộc \"trà dư\" cùng bạn hiền.', 1),
(2, 'Cafe sữa', 25000, 'https://images.foody.vn/res/g98/975925/prof/s280x175/foody-upload-api-foody-mobile-a-woman-holding-a-cu-191104100245.jpg', 'Cà phê sữa kiểu Việt Nam thường chỉ có hỗn hợp cà phê và sữa, không có các loại hương liệu khác, như bột ca cao và/hay bột quế như khi người ta pha Cappuccino.', 1),
(3, 'Cafe sài gòn', 30000, 'https://images.foody.vn/res/g75/744455/prof/s280x175/foody-upload-api-foody-mobile-foody-mobile-23-jpg--180528144829.jpg', 'Cafe đã tồn tại trong người dân Sài Gòn hơn 80 năm về trước. Những quán cafe lúc ấy dần mộc lên, thậm chí là rất nhiều vì người dân có nhu cầu sử dụng cafe hằng ngày.', 1),
(4, 'Ca cao', 35000, 'https://images.foody.vn/res/g64/631785/prof/s280x175/foody-upload-api-foody-mobile-tiem-ca-phe-nguyen-t-180620134640.jpg', 'Cà phê ca cao có vị đắng của cà phê kết hợp cùng vị ngọt ngào của ca cao sẽ tạo thành một hương vị rất độc đáo, mới lạ và rất thơm ngon.', 1),
(5, 'Bạc xỉu', 40000, 'https://images.foody.vn/res/g79/782005/prof/s280x175/foody-upload-api-foody-mobile-cafe-chat-jpg-180927110031.jpg', 'Bạc xỉu là cách gọi tắt từ cụm từ “ bạc tẩy xỉu phé” xuất phát từ tiếng Quan Thoại (là tiếng Trung phổ biến trong công động người Hoa ở Sài Gòn) nhằm để chỉ món sữa nóng thêm một chút cafe', 1),
(6, 'Sinh tố dứa', 40000, 'https://images.foody.vn/res/g97/967390/prof/s280x175/foody-upload-api-foody-mobile-5-200602160950.jpg', 'Sinh tố dứa là thức uống được ưa thích nhất trong mùa hè bởi vị ngọt mát của dứa và vị thơm nồng của sữa chua. Với cách làm sinh tố dứa đơn giản các bạn sẽ có một ly mát lạnh tại nhà vừa ngon vừa đảm bảo sức khỏe cho các thành viên trong gia đình.', 2),
(7, 'Sinh tố dâu', 40000, 'https://images.foody.vn/res/g88/873269/prof/s280x175/foody-upload-api-foody-mobile-nu-c-ep-trai-cay-190227084732.jpg', 'Sinh tố dâu là thức uống tươi ngon, bổ dưỡng, giải khát trong ngày hè. Có nhiều loại dâu để có thể làm sinh tố nhưng mùa này dâu tây là hợp nhất. Sinh tố dâu tây có vị thơm đặc trưng, chua chua, ngọt ngọt, uống kèm đá lạnh thì quá tuyệt!', 2),
(8, 'Sinh tố bơ', 35000, 'https://images.foody.vn/res/g104/1032498/prof/s280x175/foody-upload-api-foody-mobile-kembogfhghg-200626095910.jpg', 'Sinh tố bơ rất được chị em yêu thích bởi vị béo ngậy cùng mùi thơm đặc trưng. Bên cạnh đó, bơ còn có tác dụng làm đẹp và chứa nhiều chất dinh dưỡng tốt cho sức khỏe', 2),
(9, 'Sinh tố thanh long', 40000, 'https://images.foody.vn/res/g101/1003389/prof/s280x175/foody-upload-api-foody-mobile-2b85dc57-30f6-40f4-b-200409180054.jpg', 'Sinh tố thanh long là một thức uống đơn giản nhưng vô cùng thanh mát và tốt cho sức khỏe', 2),
(10, 'Sinh tố dưa hấu', 45000, 'https://images.foody.vn/res/g102/1018439/prof/s280x175/foody-upload-api-foody-mobile-seatalk_img_15864312-200409191451.jpg', 'Sinh tố dưa hấu nổi tiếng là thức uống giải nhiệt “thần kỳ”, cứu cánh những ngày oi bức, mệt mỏi.', 2),
(11, 'Trà sữa trân châu', 50000, 'https://images.foody.vn/res/g97/968257/prof/s280x175/foody-upload-api-foody-mobile-688d5126c0a926f77fb8-191108142726.jpg', 'Trà sữa trân châu xuất hiện từ năm 1980 tại Đài Loan và rất được giới trẻ các nước Châu Á yêu thích trong đó có Việt Nam. Trà sữa có hương vị thanh kết hợp hương thơm của trà và độ giòn ngậy, dẻo dai của trân châu tạo thành thức uống hấp dẫn.', 3),
(12, 'Trà sữa matcha', 45000, 'https://images.foody.vn/res/g102/1013978/prof/s280x175/foody-upload-api-foody-mobile-fancha-200319112753.jpg', 'Trà sữa matcha với hương vị thơm ngon được kết hợp hoàn hảo giữa bột trà xanh Nhật Bản và sữa béo thơm được nhiều người yêu thích', 3),
(13, 'Trà sữa kem cheese', 50000, 'https://images.foody.vn/res/g64/632252/prof/s280x175/foody-mobile-ng-jpg-219-636371165577505525.jpg', 'Trà sữa kem cheese luôn là sự lựa chọn hàng đầu của các “con chiên trà sữa”. Lớp phô mai béo béo, mặn mặn hòa cùng hương vị trà sữa thanh nhẹ mà quyến rũ khiến ai cũng mê tít.', 3),
(14, 'Trà sữa oreo cake cream', 55000, 'https://images.foody.vn/res/g8/77595/prof/s280x175/foody-upload-api-foody-mobile-papa-container-coffe-180710155449.jpg', 'Trà sữa cake cream đã trở thành món best seller của nhiều thương hiệu lớn như Heekca, Royal Tea… Là một trong những món trà sữa có tên tiếng Việt độc đáo là “chiếc bánh kem ẩn mình trong trà sữa”, đã thu hút nhiều sự tò mò của nhiều người “order” thường xuyên', 3);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`) VALUES
(2, 'an', 'ans@gmail.com', '123'),
(54, 'ngoc', 'ngoc@gmail.com', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

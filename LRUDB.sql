-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 06, 2018 at 02:46 AM
-- Server version: 5.7.18
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `LRUDB`
--

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

CREATE TABLE `province` (
  `PROVINCE_ID` int(5) NOT NULL,
  `PROVINCE_CODE` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `PROVINCE_NAME` varchar(150) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `province`
--

INSERT INTO `province` (`PROVINCE_ID`, `PROVINCE_CODE`, `PROVINCE_NAME`) VALUES
(1, '10', 'กรุงเทพมหานคร   '),
(2, '11', 'สมุทรปราการ   '),
(3, '12', 'นนทบุรี   '),
(4, '13', 'ปทุมธานี   '),
(5, '14', 'พระนครศรีอยุธยา   '),
(6, '15', 'อ่างทอง   '),
(7, '16', 'ลพบุรี   '),
(8, '17', 'สิงห์บุรี   '),
(9, '18', 'ชัยนาท   '),
(10, '19', 'สระบุรี'),
(11, '20', 'ชลบุรี   '),
(12, '21', 'ระยอง   '),
(13, '22', 'จันทบุรี   '),
(14, '23', 'ตราด   '),
(15, '24', 'ฉะเชิงเทรา   '),
(16, '25', 'ปราจีนบุรี   '),
(17, '26', 'นครนายก   '),
(18, '27', 'สระแก้ว   '),
(19, '30', 'นครราชสีมา   '),
(20, '31', 'บุรีรัมย์   '),
(21, '32', 'สุรินทร์   '),
(22, '33', 'ศรีสะเกษ   '),
(23, '34', 'อุบลราชธานี   '),
(24, '35', 'ยโสธร   '),
(25, '36', 'ชัยภูมิ   '),
(26, '37', 'อำนาจเจริญ   '),
(27, '39', 'หนองบัวลำภู   '),
(28, '40', 'ขอนแก่น   '),
(29, '41', 'อุดรธานี   '),
(30, '42', 'เลย   '),
(31, '43', 'หนองคาย   '),
(32, '44', 'มหาสารคาม   '),
(33, '45', 'ร้อยเอ็ด   '),
(34, '46', 'กาฬสินธุ์   '),
(35, '47', 'สกลนคร   '),
(36, '48', 'นครพนม   '),
(37, '49', 'มุกดาหาร   '),
(38, '50', 'เชียงใหม่   '),
(39, '51', 'ลำพูน   '),
(40, '52', 'ลำปาง   '),
(41, '53', 'อุตรดิตถ์   '),
(42, '54', 'แพร่   '),
(43, '55', 'น่าน   '),
(44, '56', 'พะเยา   '),
(45, '57', 'เชียงราย   '),
(46, '58', 'แม่ฮ่องสอน   '),
(47, '60', 'นครสวรรค์   '),
(48, '61', 'อุทัยธานี   '),
(49, '62', 'กำแพงเพชร   '),
(50, '63', 'ตาก   '),
(51, '64', 'สุโขทัย   '),
(52, '65', 'พิษณุโลก   '),
(53, '66', 'พิจิตร   '),
(54, '67', 'เพชรบูรณ์   '),
(55, '70', 'ราชบุรี   '),
(56, '71', 'กาญจนบุรี   '),
(57, '72', 'สุพรรณบุรี   '),
(58, '73', 'นครปฐม   '),
(59, '74', 'สมุทรสาคร   '),
(60, '75', 'สมุทรสงคราม   '),
(61, '76', 'เพชรบุรี   '),
(62, '77', 'ประจวบคีรีขันธ์   '),
(63, '80', 'นครศรีธรรมราช   '),
(64, '81', 'กระบี่   '),
(65, '82', 'พังงา   '),
(66, '83', 'ภูเก็ต   '),
(67, '84', 'สุราษฎร์ธานี   '),
(68, '85', 'ระนอง   '),
(69, '86', 'ชุมพร   '),
(70, '90', 'สงขลา   '),
(71, '91', 'สตูล   '),
(72, '92', 'ตรัง   '),
(73, '93', 'พัทลุง   '),
(74, '94', 'ปัตตานี   '),
(75, '95', 'ยะลา   '),
(76, '96', 'นราธิวาส   ');

-- --------------------------------------------------------

--
-- Table structure for table `tb_evaluation`
--

CREATE TABLE `tb_evaluation` (
  `id_evaluation` int(11) NOT NULL,
  `evaluation` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_evaluation`
--

INSERT INTO `tb_evaluation` (`id_evaluation`, `evaluation`) VALUES
(1, 'ดีเยี่ยม'),
(2, 'ดีมาก'),
(3, 'พอใช้'),
(4, 'ควรปรับปรุง');

-- --------------------------------------------------------

--
-- Table structure for table `tb_header`
--

CREATE TABLE `tb_header` (
  `id_header` int(11) NOT NULL,
  `header` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_header`
--

INSERT INTO `tb_header` (`id_header`, `header`) VALUES
(1, 'ผู้อำนวยการศูนย์การศึกษาฯ'),
(2, 'รองผู้อำนวยการศูนย์การศึกษาฯ'),
(3, 'คำสั่งมหาวิทยาลัย'),
(4, 'หนังสือสั่งการ');

-- --------------------------------------------------------

--
-- Table structure for table `tb_main`
--

CREATE TABLE `tb_main` (
  `id_main` int(11) NOT NULL,
  `date1` date DEFAULT NULL,
  `time1` time DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `place` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `id_position` int(2) DEFAULT NULL,
  `id_working` int(2) DEFAULT NULL,
  `working_detail` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `id_header` int(11) DEFAULT NULL,
  `id_evaluation` int(2) DEFAULT NULL,
  `filenamePicture` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_main`
--

INSERT INTO `tb_main` (`id_main`, `date1`, `time1`, `id_user`, `place`, `id_position`, `id_working`, `working_detail`, `id_header`, `id_evaluation`, `filenamePicture`) VALUES
(67, '2018-01-05', '01:00:00', 1, 'สำนักงานฯ', 1, 1, '', 1, 1, NULL),
(68, '2018-01-05', '01:00:00', 1, 'สำนักงานฯ', 1, 1, '', 1, 1, NULL),
(69, '2018-01-05', '01:00:00', 1, 'สำนักงานฯ', 1, 1, '', 1, 1, NULL),
(70, '2018-01-05', '01:00:00', 1, 'สำนักงานฯ', 1, 1, '', 1, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tb_position`
--

CREATE TABLE `tb_position` (
  `id_position` int(11) NOT NULL,
  `position` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_position`
--

INSERT INTO `tb_position` (`id_position`, `position`) VALUES
(1, 'เจ้าหน้าที่การเงิน'),
(2, 'เจ้าหน้าที่ธุรการ'),
(3, 'เจ้าหน้าที่บริหารงานฯ'),
(4, 'นักวิชาการศึกษา'),
(5, 'ช่างไฟฟ้า'),
(6, 'ช่างเทคนิค'),
(7, 'เจ้าหน้าที่ห้องสมุด');

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `id_user` int(11) NOT NULL,
  `firstname` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `lastname` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `password` text CHARACTER SET utf8 COLLATE utf8_bin,
  `id_position` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`id_user`, `firstname`, `lastname`, `username`, `password`, `id_position`) VALUES
(1, 'ณัฐชา', NULL, 'login1', '079323a49c300dcd8dffe1460dede02c', 1),
(2, 'ณัฏฐ์ฐิรา', NULL, 'login2', '3b38c223cd0767c5e6f40a7fb86159b4', 2),
(3, 'วรัฐภรณ์', NULL, 'login3', 'aa08be2b15a62bf1fb3db88022a77f92', 3),
(4, 'อัมรินทร์ ', NULL, 'login4', '0eeaf7876aed94bda664a02de7d09f80', 4),
(5, 'จิรายุทธ', NULL, 'login5', 'f15ff47b76c503839153cb11395ae387', 5),
(6, 'อังศุธร ', NULL, 'login6', '7b4308ce497ae1cc5b97b13fc4d7853f', 6),
(7, 'เฉลิมวุฒิ', NULL, 'login7', 'f4fdc4a12d16132a9b9e3b1c014e8697', 7);

-- --------------------------------------------------------

--
-- Table structure for table `tb_working`
--

CREATE TABLE `tb_working` (
  `id_working` int(11) NOT NULL,
  `working` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `id_position` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_working`
--

INSERT INTO `tb_working` (`id_working`, `working`, `id_position`) VALUES
(1, 'ปฏิบัติงานหน้าที่การเงิน', 1),
(2, 'ฝาก-ถอน บัญชีธนาคาร', 1),
(3, 'รับชำระค่าธรรมเนียม', 1),
(4, 'จ่ายค่าตอบแทน กศ.พ.', 1),
(5, 'ทำฏีกาเบิก-จ่าย', 1),
(6, 'เอกสารทางการเงิน', 1),
(7, 'สรุปรายงานประจำเดือน', 1),
(8, 'งานสารบรรณ', 2),
(9, 'งานเอกสารการพิมพ์', 2),
(10, 'งานประชุม', 2),
(11, 'งานรักษาการณ์ เวรยาม', 2),
(12, 'งานประชาสัมพันธ์', 2),
(13, 'ประสานงานเกี่ยวกับอุปกรณ์การสอบ', 2),
(14, 'งานยานพาหนะ', 2),
(15, 'จัดทำรายงานสรุปวัสดุครุภัณฑ์', 2),
(16, 'งานธุรการ', 3),
(17, 'งานบุคคล', 3),
(18, 'งานพัสดุ', 3),
(19, 'จ่ายค่าตอบแทน กศ.พ.', 3),
(20, 'ฝาก-ถอน บัญชีธนาคาร', 3),
(21, 'รับชำระค่าธรรมเนียม', 3),
(22, 'ดูแลสำรวจครุภัณฑ์', 3),
(23, 'งานเลขานุการ', 3),
(24, 'งานรักษาการณ์ เวรยาม ', 3),
(25, 'งานทะเบียนนักศึกษา', 3),
(26, 'งานทุนการศึกษา', 4),
(27, 'งานกิจกรรมนักศึกษาและงานพัฒนานักศึกษา', 4),
(28, 'งานศูนย์ฝึกประสบการณ์วิชาชีพครู', 4),
(29, 'ตรวจสอบระบบไฟฟ้า ระบบประปา', 5),
(30, 'งานพัสดุ', 5),
(31, 'งานเบิกจ่ายพัสดุ', 5),
(32, 'งานประสานการจัดซื้อจัดจ้าง', 5),
(33, 'ซ่อมบำรุงวัสดุและครุภัณฑ์', 5),
(34, 'จัดทำใบกันเงิน', 5),
(35, 'จัดทำชุดเบิก', 5),
(36, 'งานระบบคอมพิวเตอร์ ระบบสารสนเทศ', 6),
(37, 'ซ่อมบำรุงระบบคอมพิวเตอร์', 6),
(38, 'นำเสนอข่าวสารประชาสัมพันธ์ผ่านโฮมเพ็จ', 6),
(39, 'บันทึกภาพนิ่ง ภาพเคลื่อนไหว', 6),
(40, 'การเบิก - จ่ายสื่อการเรียนการสอน', 6),
(41, 'บริการรับ - ส่ง หนังสือ', 7),
(42, 'ซ่อมแซมหนังสือ', 7),
(43, 'จัดทำทะเบียนหนังสือ', 7),
(44, 'ดูแลและทำความสะอาดห้องสมุด', 7),
(45, 'งานอัดสำเนาเอกสาร ข้อสอบ', 7);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`PROVINCE_ID`);

--
-- Indexes for table `tb_evaluation`
--
ALTER TABLE `tb_evaluation`
  ADD PRIMARY KEY (`id_evaluation`);

--
-- Indexes for table `tb_header`
--
ALTER TABLE `tb_header`
  ADD PRIMARY KEY (`id_header`);

--
-- Indexes for table `tb_main`
--
ALTER TABLE `tb_main`
  ADD PRIMARY KEY (`id_main`);

--
-- Indexes for table `tb_position`
--
ALTER TABLE `tb_position`
  ADD PRIMARY KEY (`id_position`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `tb_working`
--
ALTER TABLE `tb_working`
  ADD PRIMARY KEY (`id_working`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `province`
--
ALTER TABLE `province`
  MODIFY `PROVINCE_ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;
--
-- AUTO_INCREMENT for table `tb_evaluation`
--
ALTER TABLE `tb_evaluation`
  MODIFY `id_evaluation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tb_header`
--
ALTER TABLE `tb_header`
  MODIFY `id_header` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tb_main`
--
ALTER TABLE `tb_main`
  MODIFY `id_main` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;
--
-- AUTO_INCREMENT for table `tb_position`
--
ALTER TABLE `tb_position`
  MODIFY `id_position` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `tb_working`
--
ALTER TABLE `tb_working`
  MODIFY `id_working` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

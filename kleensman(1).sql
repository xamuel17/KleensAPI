-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 26, 2019 at 05:55 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kleensman`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `adminID` int(11) NOT NULL,
  `username` varchar(33) DEFAULT NULL,
  `password` varchar(33) DEFAULT NULL,
  `firstname` varchar(33) DEFAULT NULL,
  `lastname` varchar(33) DEFAULT NULL,
  `job_title` varchar(33) DEFAULT NULL,
  `pic` blob,
  `date_reg` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customers_info`
--

CREATE TABLE `customers_info` (
  `custID` int(11) NOT NULL,
  `username` varchar(33) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `firstname` varchar(30) DEFAULT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `sex` varchar(30) DEFAULT NULL,
  `dob` varchar(30) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `pic` blob,
  `status` varchar(33) DEFAULT NULL,
  `date_reg` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers_info`
--

INSERT INTO `customers_info` (`custID`, `username`, `password`, `firstname`, `lastname`, `address`, `sex`, `dob`, `email`, `pic`, `status`, `date_reg`) VALUES
(37, 'Roberts', 'password123', 'Rob', 'steven', '204 frankfurt boulevard', 'male', '11/2/1890', 'robbetts@gmail.com', 0x6466646464676638, 'pending', '2019-06-26 11:34:45'),
(39, 'Rotits', 'padfdfddjf', 'Robttt', 'steven', '204 frankfurt boulevard', 'male', '11/2/1890', 'roberts.sam@gmail.com', 0x6466646464676638, 'pending', '2019-06-26 13:32:49');

-- --------------------------------------------------------

--
-- Table structure for table `customers_order`
--

CREATE TABLE `customers_order` (
  `orderID` int(11) NOT NULL,
  `custID` int(30) DEFAULT NULL,
  `serviceID` int(30) DEFAULT NULL,
  `plan` varchar(30) DEFAULT NULL,
  `schedule_time` time DEFAULT NULL,
  `schedule_date` date DEFAULT NULL,
  `booking_code` varchar(30) DEFAULT NULL,
  `payment_type` varchar(30) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `staffID` int(30) DEFAULT NULL,
  `date_reg` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customers_vehicle`
--

CREATE TABLE `customers_vehicle` (
  `cvID` int(11) NOT NULL,
  `custID` varchar(30) DEFAULT NULL,
  `vehicle_type` varchar(30) DEFAULT NULL,
  `vehicle_color` varchar(30) DEFAULT NULL,
  `vehicle_brand` varchar(30) DEFAULT NULL,
  `vehicle_plate_no` varchar(30) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `staff_info`
--

CREATE TABLE `staff_info` (
  `StaffID` int(11) NOT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `firstname` varchar(33) DEFAULT NULL,
  `lastname` varchar(33) DEFAULT NULL,
  `address` varchar(33) DEFAULT NULL,
  `email` varchar(33) DEFAULT NULL,
  `job_title` varchar(33) DEFAULT NULL,
  `performance` varchar(33) DEFAULT NULL,
  `phone_no` varchar(33) DEFAULT NULL,
  `pic` blob,
  `status` varchar(33) NOT NULL,
  `date_reg` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `custid` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `date_reg` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers_info`
--
ALTER TABLE `customers_info`
  ADD PRIMARY KEY (`custID`);

--
-- Indexes for table `customers_order`
--
ALTER TABLE `customers_order`
  ADD PRIMARY KEY (`orderID`);

--
-- Indexes for table `customers_vehicle`
--
ALTER TABLE `customers_vehicle`
  ADD PRIMARY KEY (`cvID`);

--
-- Indexes for table `staff_info`
--
ALTER TABLE `staff_info`
  ADD PRIMARY KEY (`StaffID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`custid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers_info`
--
ALTER TABLE `customers_info`
  MODIFY `custID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `customers_order`
--
ALTER TABLE `customers_order`
  MODIFY `orderID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customers_vehicle`
--
ALTER TABLE `customers_vehicle`
  MODIFY `cvID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `staff_info`
--
ALTER TABLE `staff_info`
  MODIFY `StaffID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `custid` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

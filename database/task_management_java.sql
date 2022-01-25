-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 25, 2022 at 08:21 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `task_management_java`
--

-- --------------------------------------------------------

--
-- Table structure for table `register_user`
--

CREATE TABLE `register_user` (
  `user_id` int(11) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `career` varchar(30) DEFAULT NULL,
  `phone` varchar(13) NOT NULL,
  `gender` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `register_user`
--

INSERT INTO `register_user` (`user_id`, `full_name`, `username`, `password`, `email`, `career`, `phone`, `gender`) VALUES
(2, 'Babayaga Shelby', 'Babayaga', 'aaa', 'aaaa', 'Professional Killer', '1111', 'Male'),
(3, 'bbb', 'bbb', 'bbb', 'bbb', NULL, '111', 'Male'),
(4, 'ddd', 'ddd', 'ddd', 'ddd', NULL, '3222', 'female'),
(5, 'saya saya', 'sayasaya', 'saya', 'saya@gmail.com', NULL, '1231431414', 'female'),
(6, 'diadia', 'diadia', 'diadia', 'diadia', NULL, '231231', 'female'),
(7, 'ccc', 'ccc', 'ccc', 'ccc', NULL, '111', 'Female'),
(8, 'Tanaka Saya', 'Saya', 'sayasayasaya', 'saya@gmail.com', 'Local Farmer', '0812341285932', 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `task_list`
--

CREATE TABLE `task_list` (
  `task_id` int(11) NOT NULL,
  `task_name` varchar(255) NOT NULL,
  `deadline` date NOT NULL,
  `status` varchar(50) NOT NULL,
  `task_priority` varchar(50) NOT NULL,
  `task_category` varchar(50) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `task_list`
--

INSERT INTO `task_list` (`task_id`, `task_name`, `deadline`, `status`, `task_priority`, `task_category`, `description`) VALUES
(8, 'Finish Java CRUD', '2022-01-27', 'To Do Task', 'High', 'Jaba II', 'Must be finished in 27 January 2022'),
(29, 'lezatos', '2022-01-23', 'In Progress', 'Medium Priority', 'mamamia', 'asdasda'),
(30, 'Shaking My Head', '2022-01-23', 'To Do Task', 'Medium Priority', 'SMH', 'sadfasadf'),
(31, 'mamamia', '2022-01-24', 'Done', 'High Priority', 'mamamia', 'mamamia'),
(32, 'sdfadf', '2022-01-19', 'Done', 'Low Priority', 'asdaf', 'dfaas'),
(33, 'asdfadsfasf', '2022-01-06', 'To Do Task', 'Low Priority', 'sdfaf', 'dafsadf');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `register_user`
--
ALTER TABLE `register_user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `task_list`
--
ALTER TABLE `task_list`
  ADD PRIMARY KEY (`task_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `register_user`
--
ALTER TABLE `register_user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `task_list`
--
ALTER TABLE `task_list`
  MODIFY `task_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

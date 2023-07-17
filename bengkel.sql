-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 17, 2023 at 11:14 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bengkel`
--
CREATE DATABASE IF NOT EXISTS `bengkel` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bengkel
-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `ID` int(11) NOT NULL,
  `NAMA` varchar(100) DEFAULT NULL,
  `JUMLAH` int(11) DEFAULT NULL,
  `LOKASI` varchar(22) DEFAULT NULL,
  `HARGA` double DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`ID`, `NAMA`, `JUMLAH`, `LOKASI`, `HARGA`, `STATUS`) VALUES
(1, 'FAN BELT', 0, 'A1', 200000, 1),
(2, 'LAGER', 0, 'A2', 125000, 1),
(3, 'KAMPAS REM', 0, 'A3', 350000, 1),
(4, 'SHOCKBREAKER', 0, 'A4', 1500000, 1),
(5, 'PLATINA CONDESOR', 0, 'B1', 120000, 1),
(6, 'BUSI', 0, 'B2', 50000, 1),
(7, 'PLAT KOPLING', 0, 'B3', 500000, 1),
(8, 'ENGINE MOUNTING', 0, 'B4', 450000, 1),
(9, 'RADIATOR', 0, 'C1', 1250000, 1),
(10, 'OLI REM', 0, 'C2', 100000, 1),
(11, 'AIR RADIATOR COOLANT', 0, 'C3', 125000, 1),
(12, 'SHELL HELIX HX8 5 W-30 4L', 0, 'C4', 675000, 1),
(13, 'SHELL HELIX HX6 10 W 4L', 0, 'D1', 330000, 1),
(14, 'SHELL RIMULA 4L', 0, 'D2', 335000, 1),
(15, 'SHELL HELIX EXTEND 4L', 0, 'D3', 780000, 1),
(16, 'LUPROMAX ZELOS 8000 5W-30 4L', 0, 'D4', 600000, 1),
(17, 'LUPROMAX HYPERION 8000 5W-30 4L', 0, 'E1', 770000, 1),
(18, 'WIPER', 0, 'E2', 32500, 1),
(19, 'AKI MOBIL', 0, 'E3', 850000, 1),
(20, 'FILTER AC', 0, 'E4', 95000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `ID` int(11) NOT NULL,
  `NAMA` varchar(100) DEFAULT NULL,
  `NO_TELP` varchar(12) DEFAULT NULL,
  `ALAMAT` varchar(100) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`ID`, `NAMA`, `NO_TELP`, `ALAMAT`, `STATUS`) VALUES
(1, 'SUPRI', '080000000001', 'JALAN GATAU', 1),
(2, 'JUNED', '080000000002', 'JALAN UDAH', 1),
(3, 'AGUS', '080000000003', 'JALAN GA', 1),
(4, 'BUDI', '080000000004', 'JALAN ADA', 1),
(5, 'ILHAM', '080000000005', 'JALAN IDE', 1);

-- --------------------------------------------------------

--
-- Table structure for table `mekanik`
--

CREATE TABLE `mekanik` (
  `ID` int(11) NOT NULL,
  `NAMA` varchar(100) DEFAULT NULL,
  `NO_TELP` varchar(12) DEFAULT NULL,
  `ALAMAT` varchar(100) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mekanik`
--

INSERT INTO `mekanik` (`ID`, `NAMA`, `NO_TELP`, `ALAMAT`, `STATUS`) VALUES
(1, 'ASEP', '080010122104', 'JALAN ANGGREK', 1),
(2, 'BAMBANG', '080010122106', 'JALAN BAKUNG', 1),
(3, 'CECEP', '080010122110', 'JALAN CEMPAKA', 1),
(4, 'DODI', '080010122114', 'JALAN DAHLIA', 1);

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `ID` int(11) NOT NULL,
  `NAMA` varchar(100) DEFAULT NULL,
  `HARGA` double DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`ID`, `NAMA`, `HARGA`, `STATUS`) VALUES
(1, 'TUNE UP MESIN', 350000, 1),
(2, 'REVISI REM', 250000, 1),
(3, 'PERBAIKAN KAKI KAKI', 350000, 1),
(4, 'OVERHAUL MESIN', 1500000, 1),
(5, 'PERBAIKAN KELISTRIKAN', 150000, 1),
(6, 'OVERHAUL GEARBOX', 1000000, 1),
(7, 'SERVICE DAN GANTI OLI', 75000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `ID` int(11) NOT NULL,
  `CLIENT_ID` int(11) DEFAULT NULL,
  `MEKANIK_ID` int(11) DEFAULT NULL,
  `SERVICE_ID` int(11) DEFAULT NULL,
  `BARANG_ID` int(11) DEFAULT NULL,
  `TOTAL_HARGA` double DEFAULT NULL,
  `TANGGAL` date DEFAULT NULL,
  `KENDARAAN` varchar(100) DEFAULT NULL,
  `TIPE` varchar(1) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `NAMA` varchar(100) DEFAULT NULL,
  `ALAMAT` varchar(100) DEFAULT NULL,
  `UMUR` int(11) DEFAULT NULL,
  `NO_TELP` varchar(12) DEFAULT NULL,
  `USERNAME` varchar(100) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  `ROLE` varchar(5) DEFAULT 'USER',
  `STATUS` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `NAMA`, `ALAMAT`, `UMUR`, `NO_TELP`, `USERNAME`, `PASSWORD`, `ROLE`, `STATUS`) VALUES
(1, 'ADMIN', 'JALAN-JALAN', 99, '080006942000', 'admin', 'admin', 'ADMIN', 1),
(2, 'USER', 'JALAN KEHIDUPAN', 66, '080010122114', 'user', 'user', 'USER', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `NAMA` (`NAMA`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `mekanik`
--
ALTER TABLE `mekanik`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `NAMA` (`NAMA`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `NAMA` (`NAMA`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `transaksi_ibfk_1` (`CLIENT_ID`),
  ADD KEY `transaksi_ibfk_2` (`MEKANIK_ID`),
  ADD KEY `transaksi_ibfk_3` (`SERVICE_ID`),
  ADD KEY `transaksi_ibfk_4` (`BARANG_ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `NAMA` (`NAMA`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `mekanik`
--
ALTER TABLE `mekanik`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`CLIENT_ID`) REFERENCES `client` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`MEKANIK_ID`) REFERENCES `mekanik` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_3` FOREIGN KEY (`SERVICE_ID`) REFERENCES `service` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_4` FOREIGN KEY (`BARANG_ID`) REFERENCES `barang` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 23, 2023 at 04:45 AM
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
USE `bengkel`;
-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `ID` varchar(100) NOT NULL,
  `NAMA` varchar(100) DEFAULT NULL,
  `JUMLAH` int(11) DEFAULT 0,
  `LOKASI` varchar(22) DEFAULT NULL,
  `HARGA` double DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`ID`, `NAMA`, `JUMLAH`, `LOKASI`, `HARGA`, `STATUS`) VALUES
('BR001', 'FAN BELT', 0, 'A1', 200000, 1),
('BR002', 'LAGER', 0, 'A2', 125000, 1),
('BR003', 'KAMPAS REM', 0, 'A3', 350000, 1),
('BR004', 'SHOCKBREAKER', 0, 'A4', 1500000, 1),
('BR005', 'PLATINA CONDESOR', 0, 'B1', 120000, 1),
('BR006', 'BUSI', 0, 'B2', 50000, 1),
('BR007', 'PLAT KOPLING', 0, 'B3', 500000, 1),
('BR008', 'ENGINE MOUNTING', 0, 'B4', 450000, 1),
('BR009', 'RADIATOR', 0, 'C1', 1250000, 1),
('BR010', 'OLI REM', 0, 'C2', 100000, 1),
('BR011', 'AIR RADIATOR COOLANT', 0, 'C3', 125000, 1),
('BR012', 'SHELL HELIX HX8 5 W-30 4L', 0, 'C4', 75000, 1),
('BR013', 'SHELL HELIX HX6 10 W 4L', 0, 'D1', 330000, 1),
('BR014', 'SHELL RIMULA 4L', 0, 'D2', 335000, 1),
('BR015', 'SHELL HELIX EXTEND 4L', 0, 'D3', 780000, 1),
('BR016', 'LUPROMAX ZELOS 8000 5W-30 4L', 0, 'D4', 600000, 1),
('BR017', 'LUPROMAX HYPERION 8000 5W-30 4L', 0, 'E1', 770000, 1),
('BR018', 'WIPER', 0, 'E2', 32500, 1),
('BR019', 'AKI MOBIL', 0, 'E3', 850000, 1),
('BR020', 'FILTER AC', 0, 'E4', 95000, 1),
('BR021', 'PENGKILAP BODY MOBIL', 0, 'F1', 50000, 1),
('BR022', 'STP BRAKE PARTS CLEANER 500ML', 0, 'F2', 48000, 1),
('BR023', 'TONGKAT E-TOLL', 0, 'F3', 10000, 1),
('BR024', 'KIT WIPER FLUID PUCH 400ML', 0, 'F4', 8000, 1),
('BR025', 'KUMPON CAT MOBIL', 0, 'G1', 25000, 1),
('BR026', 'KABEL BUSSI', 0, 'G2', 125000, 1),
('BR027', 'FILTER UDARA', 0, 'G3', 100000, 1),
('BR028', 'RING PISTON', 0, 'G4', 300000, 1),
('BR029', 'STEMPET', 0, 'H1', 50000, 1),
('BR030', 'KABEL KOPLING', 0, 'H2', 125000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `ID` varchar(100) NOT NULL,
  `NAMA` varchar(100) DEFAULT NULL,
  `NO_TELP` varchar(12) DEFAULT NULL,
  `ALAMAT` varchar(100) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`ID`, `NAMA`, `NO_TELP`, `ALAMAT`, `STATUS`) VALUES
('CL001', 'DYAH', '089249561644', 'JALAN KAMAYANGAN BLOK C-36', 1),
('CL002', 'ALVARO', '088057542480', 'JALAN YOGJAKARTA', 1),
('CL003', 'KEVIN', '084451979065', 'JALAN MALANGBONG', 1),
('CL004', 'FERRY', '080353023527', 'JALAN KAMAYANGAN BLOK C-37', 1),
('CL005', 'VALERIE', '089047564337', 'JALAN CIBODAS', 1);

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `ID` int(11) NOT NULL,
  `TRANSAKSI_ID` varchar(100) DEFAULT NULL,
  `KENDARAAN` varchar(100) DEFAULT NULL,
  `SERVICE_ID` varchar(100) DEFAULT NULL,
  `MEKANIK_ID` varchar(100) DEFAULT NULL,
  `BARANG_ID` varchar(100) DEFAULT NULL,
  `HARGA` double DEFAULT NULL,
  `JUMLAH` int(11) DEFAULT NULL,
  `SUBTOTAL` double DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `mekanik`
--

CREATE TABLE `mekanik` (
  `ID` varchar(100) NOT NULL,
  `NAMA` varchar(100) DEFAULT NULL,
  `NO_TELP` varchar(12) DEFAULT NULL,
  `ALAMAT` varchar(100) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mekanik`
--

INSERT INTO `mekanik` (`ID`, `NAMA`, `NO_TELP`, `ALAMAT`, `STATUS`) VALUES
('MK001', 'ASEP', '082732162391', 'JALAN PARAKAN SAAT BLOK A', 1),
('MK002', 'UDIN', '085631457147', 'JALAN PANDU', 1),
('MK003', 'JAJA', '088532475204', 'JALAN GATOT SUBROTO', 1),
('MK004', 'UJANG', '088956398236', 'JALAN PARAKAN SAAT BLOK C', 1),
('MK005', 'HENDRI', '086995138262', 'JALAN LAKSMUD NURTANIO', 1);

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `ID` varchar(100) NOT NULL,
  `NAMA` varchar(100) DEFAULT NULL,
  `HARGA` double DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`ID`, `NAMA`, `HARGA`, `STATUS`) VALUES
('SV001', 'TUNE UP MESIN', 350000, 1),
('SV002', 'REVISI REM', 250000, 1),
('SV003', 'PERBAIKAN KAKI KAKI', 350000, 1),
('SV004', 'OVERHAUL MESIN', 1500000, 1),
('SV005', 'PERBAIKAN KELISTRIKAN', 150000, 1),
('SV006', 'OVERHAUL GEARBOX', 1000000, 1),
('SV007', 'SERVICE DAN GANTI OLI', 75000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_income`
--

CREATE TABLE `transaksi_income` (
  `ID` varchar(100) NOT NULL,
  `USER_ID` varchar(100) DEFAULT NULL,
  `CLIENT_ID` varchar(100) DEFAULT NULL,
  `TOTAL_HARGA` double DEFAULT NULL,
  `TANGGAL` datetime DEFAULT current_timestamp(),
  `TIPE` varchar(21) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_outcome`
--

CREATE TABLE `transaksi_outcome` (
  `ID` varchar(100) NOT NULL,
  `USER_ID` varchar(100) DEFAULT NULL,
  `TOTAL_HARGA` double DEFAULT NULL,
  `TANGGAL` date DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` varchar(100) NOT NULL,
  `NAMA` varchar(100) DEFAULT NULL,
  `ALAMAT` varchar(100) DEFAULT NULL,
  `UMUR` int(11) DEFAULT NULL,
  `NO_TELP` varchar(12) DEFAULT NULL,
  `USERNAME` varchar(100) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  `ROLE` varchar(5) DEFAULT 'USER',
  `STATUS` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `NAMA`, `ALAMAT`, `UMUR`, `NO_TELP`, `USERNAME`, `PASSWORD`, `ROLE`, `STATUS`) VALUES
('ADM001', 'ADMIN', 'JALAN CIBATU 2', 62, '085103572997', 'admin', 'admin', 'ADMIN', 1),
('USR001', 'USER', 'JALAN PONDOK MUTIARA', 55, '08122108054', 'user', 'user', 'USER', 1);

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
-- Indexes for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `detail_transaksi_ibfk_1` (`SERVICE_ID`),
  ADD KEY `detail_transaksi_ibfk_2` (`MEKANIK_ID`),
  ADD KEY `detail_transaksi_ibfk_3` (`BARANG_ID`);

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
-- Indexes for table `transaksi_income`
--
ALTER TABLE `transaksi_income`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `transaksi_ibfk_1` (`CLIENT_ID`),
  ADD KEY `USER_ID` (`USER_ID`);

--
-- Indexes for table `transaksi_outcome`
--
ALTER TABLE `transaksi_outcome`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `USER_ID` (`USER_ID`);

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
-- AUTO_INCREMENT for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `detail_transaksi_ibfk_1` FOREIGN KEY (`SERVICE_ID`) REFERENCES `service` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_transaksi_ibfk_2` FOREIGN KEY (`MEKANIK_ID`) REFERENCES `mekanik` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_transaksi_ibfk_3` FOREIGN KEY (`BARANG_ID`) REFERENCES `barang` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaksi_income`
--
ALTER TABLE `transaksi_income`
  ADD CONSTRAINT `transaksi_income_ibfk_1` FOREIGN KEY (`CLIENT_ID`) REFERENCES `client` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_income_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`ID`);

--
-- Constraints for table `transaksi_outcome`
--
ALTER TABLE `transaksi_outcome`
  ADD CONSTRAINT `transaksi_outcome_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2023 at 06:18 PM
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

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `ID` int(11) NOT NULL,
  `NAMA` text DEFAULT NULL,
  `JUMLAH` int(11) DEFAULT NULL,
  `HARGA` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`ID`, `NAMA`, `JUMLAH`, `HARGA`) VALUES
(1, 'OLI MESIN', 0, 450000),
(2, 'FAN BELT', 0, 200000),
(3, 'LAGER', 0, 125000),
(4, 'KAMPAS REM', 0, 350000),
(5, 'SHOCKBREAKER', 0, 1500000),
(6, 'PLATINA CONDESOR', 0, 120000),
(7, 'BUSI', 0, 50000),
(8, 'PLAT KOPLING', 0, 500000),
(9, 'ENGINE MOUNTING', 0, 450000),
(10, 'RADIATOR', 0, 1250000),
(11, 'OLI REM', 0, 100000),
(12, 'AIR RADIATOR COOLANT', 0, 125000);

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `ID` int(11) NOT NULL,
  `NAMA` text DEFAULT NULL,
  `ID_KENDARAAN` int(11) DEFAULT NULL,
  `NO_TELP` varchar(12) DEFAULT NULL,
  `ALAMAT` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`ID`, `NAMA`, `ID_KENDARAAN`, `NO_TELP`, `ALAMAT`) VALUES
(2, 'SUPRI', 4, '080000000001', 'JALAN GATAU'),
(3, 'JUNED', 2, '080000000002', 'JALAN UDAH'),
(4, 'AGUS', 1, '080000000003', 'JALAN GA'),
(5, 'BUDI', 3, '080000000004', 'JALAN ADA'),
(6, 'ILHAM', 1, '080000000005', 'JALAN IDE');

-- --------------------------------------------------------

--
-- Table structure for table `kendaraan`
--

CREATE TABLE `kendaraan` (
  `ID` int(11) NOT NULL,
  `MEREK` text DEFAULT NULL,
  `MODEL` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `kendaraan`
--

INSERT INTO `kendaraan` (`ID`, `MEREK`, `MODEL`) VALUES
(1, 'HONDA', 'CRV'),
(2, 'TOYOTA', 'RAIZE'),
(3, 'HONDA', 'BRV'),
(4, 'HONDA', 'BRIO'),
(5, 'TOYOTA', 'INNOVA');

-- --------------------------------------------------------

--
-- Table structure for table `mekanik`
--

CREATE TABLE `mekanik` (
  `ID` int(11) NOT NULL,
  `NAMA` text DEFAULT NULL,
  `NO_TELP` varchar(12) DEFAULT NULL,
  `ALAMAT` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mekanik`
--

INSERT INTO `mekanik` (`ID`, `NAMA`, `NO_TELP`, `ALAMAT`) VALUES
(1, 'ASEP', '080010122104', 'JALAN ANGGREK'),
(2, 'BAMBANG', '080010122106', 'JALAN BAKUNG'),
(3, 'CECEP', '080010122110', 'JALAN CEMPAKA'),
(4, 'DODI', '080010122114', 'JALAN DAHLIA');

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `ID` int(11) NOT NULL,
  `NAME` text DEFAULT NULL,
  `HARGA` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`ID`, `NAME`, `HARGA`) VALUES
(1, 'TUNE UP MESIN', 350000),
(2, 'REVISI REM', 250000),
(3, 'PERBAIKAN KAKI KAKI', 350000),
(4, 'OVERHAUL MESIN', 1500000),
(5, 'PERBAIKAN KELISTRIKAN', 150000),
(6, 'OVERHAUL GEARBOX', 1000000),
(7, 'SERVICE DAN GANTI OLI', 75000);

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
  `TANGGAL` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `NAMA` text DEFAULT NULL,
  `ALAMAT` text DEFAULT NULL,
  `UMUR` int(11) DEFAULT NULL,
  `NO_TELP` varchar(12) DEFAULT NULL,
  `USERNAME` text DEFAULT NULL,
  `PASSWORD` text DEFAULT NULL,
  `ROLE` varchar(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `NAMA`, `ALAMAT`, `UMUR`, `NO_TELP`, `USERNAME`, `PASSWORD`, `ROLE`) VALUES
(1, 'ADMIN', 'JALAN-JALAN', 99, '080006942000', 'ADMIN', '4DM1N', 'ADM'),
(2, 'USER1', 'JALAN KEHIDUPAN', 66, '080010122114', 'USER1', 'US3R1', 'USR');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `client_ibfk_1` (`ID_KENDARAAN`);

--
-- Indexes for table `kendaraan`
--
ALTER TABLE `kendaraan`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `mekanik`
--
ALTER TABLE `mekanik`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `transaksi_ibfk_1` (`CLIENT_ID`),
  ADD KEY `transaksi_ibfk_2` (`SERVICE_ID`),
  ADD KEY `transaksi_ibfk_3` (`BARANG_ID`),
  ADD KEY `transaksi_ibfk_4` (`MEKANIK_ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `kendaraan`
--
ALTER TABLE `kendaraan`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `mekanik`
--
ALTER TABLE `mekanik`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

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
-- Constraints for table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_ibfk_1` FOREIGN KEY (`ID_KENDARAAN`) REFERENCES `kendaraan` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`CLIENT_ID`) REFERENCES `client` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`SERVICE_ID`) REFERENCES `service` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_3` FOREIGN KEY (`BARANG_ID`) REFERENCES `barang` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_4` FOREIGN KEY (`MEKANIK_ID`) REFERENCES `mekanik` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

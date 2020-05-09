-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 09 Bulan Mei 2020 pada 02.54
-- Versi server: 10.1.38-MariaDB
-- Versi PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uas`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tblkereta`
--

CREATE TABLE `tblkereta` (
  `ID_Petugas` varchar(15) NOT NULL,
  `No_Kereta` varchar(10) NOT NULL,
  `Kelas` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tblkereta`
--

INSERT INTO `tblkereta` (`ID_Petugas`, `No_Kereta`, `Kelas`) VALUES
('001', 'A123', 1),
('002', 'A122', 2),
('003', 'A124', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tblpemesan`
--

CREATE TABLE `tblpemesan` (
  `No_Pemesan` varchar(10) NOT NULL,
  `Nama_Pemesan` varchar(30) NOT NULL,
  `Jenis_Kelamin` varchar(10) NOT NULL,
  `Usia` varchar(10) NOT NULL,
  `Alamat` varchar(30) NOT NULL,
  `No_HP` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tblpemesan`
--

INSERT INTO `tblpemesan` (`No_Pemesan`, `Nama_Pemesan`, `Jenis_Kelamin`, `Usia`, `Alamat`, `No_HP`) VALUES
('001', 'Caca', 'Perempuan', '15', 'Solo', '0897989898'),
('002', 'Opang', 'Laki-laki', '25', 'Solo', '098909879');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tblpetugas`
--

CREATE TABLE `tblpetugas` (
  `Nama_Petugas` varchar(20) NOT NULL,
  `ID_Petugas` varchar(20) NOT NULL,
  `No_Telp` varchar(20) NOT NULL,
  `Alamat` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tblpetugas`
--

INSERT INTO `tblpetugas` (`Nama_Petugas`, `ID_Petugas`, `No_Telp`, `Alamat`) VALUES
('ss', 'ss', 'ss', 'ss'),
('caca', 'cvs', '0890987689', 'Solo'),
('nana', 'cvw', '909878988', 'solo');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbltiket`
--

CREATE TABLE `tbltiket` (
  `No_Kereta` varchar(15) NOT NULL,
  `No_Kursi` varchar(10) NOT NULL,
  `Nama_Penumpang` varchar(30) NOT NULL,
  `Tgl_Keberangkatan` varchar(20) NOT NULL,
  `Jam_Keberangkatan` varchar(50) NOT NULL,
  `Harga_Tiket` varchar(15) NOT NULL,
  `ID_Petugas` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbltiket`
--

INSERT INTO `tbltiket` (`No_Kereta`, `No_Kursi`, `Nama_Penumpang`, `Tgl_Keberangkatan`, `Jam_Keberangkatan`, `Harga_Tiket`, `ID_Petugas`) VALUES
('A001', '1B', 'Caca', '8 Mei 2020', '10.00', '250000', 'vcs'),
('A002', '2A', 'Opang', '9 Mei 2020', '01.00', '300000', 'cva');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbltransaksitiket`
--

CREATE TABLE `tbltransaksitiket` (
  `No_Tiket` varchar(15) NOT NULL,
  `Nama_Penumpang` varchar(30) NOT NULL,
  `No_Kereta` varchar(15) NOT NULL,
  `Jumlah_Tiket` varchar(20) NOT NULL,
  `Harga_Tiket` varchar(15) NOT NULL,
  `Total_Bayar` varchar(20) NOT NULL,
  `ID_Petugas` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbltransaksitiket`
--

INSERT INTO `tbltransaksitiket` (`No_Tiket`, `Nama_Penumpang`, `No_Kereta`, `Jumlah_Tiket`, `Harga_Tiket`, `Total_Bayar`, `ID_Petugas`) VALUES
('00234', 'Opang', 'A001', '2', '150000', '300000', 'cva');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `User Name` varchar(20) NOT NULL,
  `Password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `user1`
--

CREATE TABLE `user1` (
  `User Name` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Level` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbltiket`
--
ALTER TABLE `tbltiket`
  ADD PRIMARY KEY (`No_Kereta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

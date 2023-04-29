-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Počítač: 127.0.0.1
-- Vytvořeno: Sob 29. dub 2023, 13:34
-- Verze serveru: 10.4.27-MariaDB
-- Verze PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databáze: `vf_sporty_shoes`
--

-- --------------------------------------------------------

--
-- Struktura tabulky `admin`
--

CREATE TABLE `admin` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('admin', 'password123');

-- --------------------------------------------------------

--
-- Struktura tabulky `product`
--

CREATE TABLE `product` (
  `pid` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `price` int(11) NOT NULL,
  `sport` varchar(30) NOT NULL,
  `sex` varchar(30) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `product`
--

INSERT INTO `product` (`pid`, `name`, `price`, `sport`, `sex`, `status`) VALUES
(1, 'Latin Basic', 299, 'dancing', 'female', 'active'),
(2, 'Happy Bare Foot ', 209, '', 'unisex', 'active'),
(3, 'Nature Feeling', 415, 'hiking', 'male', 'archived'),
(4, 'Fast & Furious', 259, 'running', 'male', 'active'),
(7, 'Tap Dancing Shoes', 349, 'dancing', '', 'archived'),
(8, 'Standard Basic', 309, 'dancing', 'male', 'active');

-- --------------------------------------------------------

--
-- Struktura tabulky `purchase`
--

CREATE TABLE `purchase` (
  `pcid` int(11) NOT NULL,
  `pcemail` varchar(30) NOT NULL,
  `pcdate` date NOT NULL,
  `totalprice` int(11) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `purchase`
--

INSERT INTO `purchase` (`pcid`, `pcemail`, `pcdate`, `totalprice`, `status`) VALUES
(1, 'julia.davis@gmail.com', '2023-03-30', 299, 'delivered'),
(2, 'nick3@gmail.com', '2023-04-24', 614, 'sent'),
(3, 'hall.pete@gmail.com', '2023-04-27', 468, 'paid');

-- --------------------------------------------------------

--
-- Struktura tabulky `purchaseditems`
--

CREATE TABLE `purchaseditems` (
  `piid` int(11) NOT NULL,
  `pcid` int(11) NOT NULL,
  `pid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `purchaseditems`
--

INSERT INTO `purchaseditems` (`piid`, `pcid`, `pid`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 2, 3),
(4, 3, 2),
(5, 3, 4);

-- --------------------------------------------------------

--
-- Struktura tabulky `user`
--

CREATE TABLE `user` (
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `lname` varchar(30) NOT NULL,
  `fname` varchar(30) NOT NULL,
  `city` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `user`
--

INSERT INTO `user` (`email`, `password`, `lname`, `fname`, `city`) VALUES
('hall.pete@gmail.com', 'myPassword', 'Hall', 'Peter', 'Manchaster'),
('hannah.m@yahoo.com', 'hannah95', 'Morgan', 'Hannah', 'Oxford'),
('j.morgan@yahoo.com', 'myPassword', 'Morgan', 'Jane', 'Oxford'),
('julia.davis@gmail.com', '1234', 'Davis', 'Julia', 'London'),
('nick3@gmail.com', 'password', 'Harris', 'Nick', 'Glasgow');

--
-- Indexy pro exportované tabulky
--

--
-- Indexy pro tabulku `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username`);

--
-- Indexy pro tabulku `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`pid`);

--
-- Indexy pro tabulku `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`pcid`),
  ADD KEY `pcemail` (`pcemail`);

--
-- Indexy pro tabulku `purchaseditems`
--
ALTER TABLE `purchaseditems`
  ADD PRIMARY KEY (`piid`),
  ADD KEY `pcid` (`pcid`),
  ADD KEY `pid` (`pid`);

--
-- Indexy pro tabulku `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`email`);

--
-- AUTO_INCREMENT pro tabulky
--

--
-- AUTO_INCREMENT pro tabulku `product`
--
ALTER TABLE `product`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pro tabulku `purchase`
--
ALTER TABLE `purchase`
  MODIFY `pcid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pro tabulku `purchaseditems`
--
ALTER TABLE `purchaseditems`
  MODIFY `piid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Omezení pro exportované tabulky
--

--
-- Omezení pro tabulku `purchase`
--
ALTER TABLE `purchase`
  ADD CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`pcemail`) REFERENCES `user` (`email`);

--
-- Omezení pro tabulku `purchaseditems`
--
ALTER TABLE `purchaseditems`
  ADD CONSTRAINT `purchaseditems_ibfk_1` FOREIGN KEY (`pcid`) REFERENCES `purchase` (`pcid`),
  ADD CONSTRAINT `purchaseditems_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

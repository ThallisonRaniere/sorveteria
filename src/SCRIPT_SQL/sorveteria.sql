-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 19-Jun-2015 às 12:22
-- Versão do servidor: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sorveteria`
--
CREATE DATABASE IF NOT EXISTS `sorveteria`;

USE `sorveteria`;
-- --------------------------------------------------------

--
-- Estrutura da tabela `cabecalhovenda`
--

CREATE TABLE IF NOT EXISTS `cabecalhovenda` (
`idvenda` int(11) NOT NULL,
  `datavenda` date NOT NULL,
  `idcliente` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL,
  `observacoesvenda` varchar(100) DEFAULT NULL,
  `valortotal` decimal(8,2) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidades`
--

CREATE TABLE IF NOT EXISTS `cidades` (
`idcidade` int(4) NOT NULL,
  `nomecidade` varchar(50) NOT NULL,
  `idestado` int(2) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cidades`
--

INSERT INTO `cidades` (`idcidade`, `nomecidade`, `idestado`, `status`) VALUES
(1, 'MONTES CLAROS', 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
`idcliente` int(11) NOT NULL,
  `cpfcliente` varchar(11) DEFAULT NULL,
  `cnpjcliente` varchar(19) DEFAULT NULL,
  `nomecliente` varchar(60) NOT NULL,
  `contatocliente` varchar(60) NOT NULL,
  `emailcliente` varchar(60) NOT NULL,
  `cepcliente` varchar(9) NOT NULL,
  `numerologradourocliente` int(11) NOT NULL,
  `idcidade` int(4) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`idcliente`, `cpfcliente`, `cnpjcliente`, `nomecliente`, `contatocliente`, `emailcliente`, `cepcliente`, `numerologradourocliente`, `idcidade`, `status`) VALUES
(1, '56753038710', NULL, 'ADMINISTRADOR DO SISTEMA', '038 91919191', 'admin@gmail.com', '39400-220', 36, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `estados`
--

CREATE TABLE IF NOT EXISTS `estados` (
`idestado` int(2) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `estados`
--

INSERT INTO `estados` (`idestado`, `uf`, `status`) VALUES
(1, 'MG', 1),
(2, 'SP', 1),
(3, 'GO', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `itensvenda`
--

CREATE TABLE IF NOT EXISTS `itensvenda` (
`iditem` int(11) NOT NULL,
  `item` int(11) NOT NULL,
  `cabecalhovenda_idvenda` int(11) NOT NULL,
  `idproduto` int(11) NOT NULL,
  `quantidade` decimal(8,2) NOT NULL,
  `precovenda` decimal(8,2) NOT NULL,
  `valortotalitem` decimal(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE IF NOT EXISTS `produtos` (
`idproduto` int(11) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `saldoproduto` decimal(8,2) NOT NULL,
  `precovenda` decimal(8,2) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
`idusuario` int(11) NOT NULL,
  `nomeusuario` varchar(60) NOT NULL,
  `cpfusuario` varchar(11) NOT NULL,
  `cepusuario` varchar(9) NOT NULL,
  `numerologradourousuario` int(11) NOT NULL,
  `idcidade` int(4) NOT NULL,
  `loginusuario` varchar(50) NOT NULL,
  `senhausuario` varchar(32) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`idusuario`, `nomeusuario`, `cpfusuario`, `cepusuario`, `numerologradourousuario`, `idcidade`, `loginusuario`, `senhausuario`, `status`) VALUES
(1, 'ADMINISTRADOR DO SISTEMA', '10426194683', '39400-220', 36, 1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cabecalhovenda`
--
ALTER TABLE `cabecalhovenda`
 ADD PRIMARY KEY (`idvenda`,`idcliente`,`idusuario`), ADD KEY `fk_cabecalhovenda_usuarios1_idx` (`idusuario`), ADD KEY `fk_cabecalhovenda_clientes1_idx` (`idcliente`);

--
-- Indexes for table `cidades`
--
ALTER TABLE `cidades`
 ADD PRIMARY KEY (`idcidade`,`idestado`), ADD KEY `fk_cidades_estados_idx` (`idestado`);

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
 ADD PRIMARY KEY (`idcliente`,`idcidade`), ADD KEY `fk_clientes_cidades1_idx` (`idcidade`);

--
-- Indexes for table `estados`
--
ALTER TABLE `estados`
 ADD PRIMARY KEY (`idestado`);

--
-- Indexes for table `itensvenda`
--
ALTER TABLE `itensvenda`
 ADD PRIMARY KEY (`iditem`,`cabecalhovenda_idvenda`,`idproduto`), ADD KEY `fk_itensvenda_produtos1_idx` (`idproduto`), ADD KEY `fk_itensvenda_cabecalhovenda1_idx` (`cabecalhovenda_idvenda`);

--
-- Indexes for table `produtos`
--
ALTER TABLE `produtos`
 ADD PRIMARY KEY (`idproduto`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
 ADD PRIMARY KEY (`idusuario`,`idcidade`), ADD KEY `fk_usuarios_cidades1_idx` (`idcidade`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cabecalhovenda`
--
ALTER TABLE `cabecalhovenda`
MODIFY `idvenda` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cidades`
--
ALTER TABLE `cidades`
MODIFY `idcidade` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `estados`
--
ALTER TABLE `estados`
MODIFY `idestado` int(2) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `itensvenda`
--
ALTER TABLE `itensvenda`
MODIFY `iditem` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `produtos`
--
ALTER TABLE `produtos`
MODIFY `idproduto` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cabecalhovenda`
--
ALTER TABLE `cabecalhovenda`
ADD CONSTRAINT `fk_cabecalhovenda_clientes1` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_cabecalhovenda_usuarios1` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `cidades`
--
ALTER TABLE `cidades`
ADD CONSTRAINT `fk_cidades_estados` FOREIGN KEY (`idestado`) REFERENCES `estados` (`idestado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `clientes`
--
ALTER TABLE `clientes`
ADD CONSTRAINT `fk_clientes_cidades1` FOREIGN KEY (`idcidade`) REFERENCES `cidades` (`idcidade`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `itensvenda`
--
ALTER TABLE `itensvenda`
ADD CONSTRAINT `fk_itensvenda_cabecalhovenda1` FOREIGN KEY (`cabecalhovenda_idvenda`) REFERENCES `cabecalhovenda` (`idvenda`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_itensvenda_produtos1` FOREIGN KEY (`idproduto`) REFERENCES `produtos` (`idproduto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `usuarios`
--
ALTER TABLE `usuarios`
ADD CONSTRAINT `fk_usuarios_cidades1` FOREIGN KEY (`idcidade`) REFERENCES `cidades` (`idcidade`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

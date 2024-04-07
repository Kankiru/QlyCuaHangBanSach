﻿CREATE DATABASE DA1
go
USE DA1

go
CREATE TABLE KHACHHANG (
    MAKH NVARCHAR(50) PRIMARY KEY,
    TENKH NVARCHAR(50) NOT NULL,
    DIACHI NVARCHAR(50) NULL,
    EMAIL NVARCHAR(50) NULL,
    SDT NVARCHAR(20) NULL,
    NgaySinh DATE
);
go
-- Tạo Bảng NHANVIEN
CREATE TABLE NHANVIEN (
    IDNV NVARCHAR(50) PRIMARY KEY NOT NULL,
    TEN NVARCHAR(50),
    GIOITINH NVARCHAR(50) NULL,
    NGAYSINH DATE,
    EMAIL NVARCHAR(50) NULL,
    SDT NVARCHAR(50) NULL,
    TAIKHOAN NVARCHAR(50)  NULL,
    PASWORD CHAR(65)  NULL,
	ROLES nvarchar(20),
);

go
-- Tạo Bảng NHACUNGCAP
CREATE TABLE NHACUNGCAP (
    MANCC NVARCHAR(50) PRIMARY KEY NOT NULL,
    TENNHACUNGCAP NVARCHAR(50) NOT NULL,
    DIACHI NVARCHAR(50) NULL,
    EMAIL NVARCHAR(50) NULL,
    SDT NVARCHAR(20) NULL
);
go
-- Tạo Bảng THELOAI
CREATE TABLE THELOAI(
    MATL NVARCHAR(50) PRIMARY KEY NOT NULL,
    THELOAI NVARCHAR(50) NULL
);
go
-- Tạo Bảng TACGIA
CREATE TABLE TACGIA(
    MATG NVARCHAR(50) PRIMARY KEY NOT NULL,
    TENTG NVARCHAR(50) NULL,
    DIACHI NVARCHAR(50) NULL,
    SDT NVARCHAR(50) NULL
);
go


-- Tạo Bảng NHAXUATBAN
CREATE TABLE NHAXUATBAN (
    MANXB NVARCHAR(50) PRIMARY KEY NOT NULL,
    TENNXB NVARCHAR(50) NOT NULL,
    DIACHI NVARCHAR(50) NULL,
    EMAIL NVARCHAR(50) NULL,
    SDT NVARCHAR(20) NULL
);
go


-- Tạo Bảng SACH
CREATE TABLE SACH(
    MASACH NVARCHAR(50) PRIMARY KEY NOT NULL,
    MANXB NVARCHAR(50) NULL,
    THELOAI NVARCHAR(50) NOT NULL,
    MATG NVARCHAR(50) NULL,
    TENSACH NVARCHAR(50) NULL,
    NAMXUATBAN NVARCHAR(50) NULL,
    SOLUONG NVARCHAR(50) NULL,
    GIAMUA INT NULL,
    ANH NVARCHAR(50) NULL,
    FOREIGN KEY(THELOAI) REFERENCES THELOAI,
    FOREIGN KEY(MATG) REFERENCES TACGIA,
    FOREIGN KEY(MANXB) REFERENCES NHAXUATBAN
);
go
------------
CREATE TABLE SACH_TACGIA (
    MASACH NVARCHAR(50) NOT NULL,
    MATG NVARCHAR(50) NOT NULL,
    PRIMARY KEY (MASACH, MATG),
    FOREIGN KEY (MASACH) REFERENCES SACH(MASACH),
    FOREIGN KEY (MATG) REFERENCES TACGIA(MATG)
);
go

-- Tạo Bảng KHUYENMAI
CREATE TABLE KHUYENMAI (
    MAGG NVARCHAR(50) PRIMARY KEY NOT NULL,
    MAKH NVARCHAR(50) NOT NULL,
    FOREIGN KEY(MAKH) REFERENCES KHACHHANG(MAKH)
);
go
CREATE TABLE CTKHUYENMAI (
    MAGG NVARCHAR(50) NOT NULL,
    MASACH NVARCHAR(50) NOT NULL,
    GIAMGIA INT NULL,
    FOREIGN KEY(MAGG) REFERENCES KHUYENMAI(MAGG),
    FOREIGN KEY(MASACH) REFERENCES SACH(MASACH),
    PRIMARY KEY (MAGG, MASACH)
);
go

-- Tạo Bảng HOADON
CREATE TABLE HOADON(
    MAHD NVARCHAR(50) PRIMARY KEY NOT NULL,
    MAKH NVARCHAR(50) NOT NULL,
    IDNV NVARCHAR(50) NOT NULL,
    NGAYLAP DATETIME NULL,
    TONGTIEN INT NULL,
    GIAMGIA INT NOT NULL,
    THANHTIEN INT NULL,
    FOREIGN KEY(MAKH) REFERENCES KHACHHANG(MAKH),
    FOREIGN KEY(IDNV) REFERENCES NHANVIEN(IDNV)
);
go
-- Tạo Bảng HOADONCT
CREATE TABLE HOADONCT(
    MAHD NVARCHAR(50) NOT NULL,
    MASACH NVARCHAR(50) NOT NULL,
    SOLUONG NVARCHAR(50) NOT NULL,
    GIAMUA INT NOT NULL,
    THANHTIEN INT NOT NULL,
	PRIMARY KEY (MAHD, MASACH),
    FOREIGN KEY(MASACH) REFERENCES SACH(MASACH),
    FOREIGN KEY(MAHD) REFERENCES HOADON(MAHD)
);
go
-- Tạo Bảng PHIEUNHAP
CREATE TABLE PHIEUNHAP (
    MAPN NVARCHAR(50) PRIMARY KEY NOT NULL,
    MANV NVARCHAR(50) NOT NULL,
    MANCC NVARCHAR(50) NOT NULL,
    NGAYNHAP DATETIME NULL,
    TONGTIEN INT NULL,
    FOREIGN KEY (MANV) REFERENCES NHANVIEN(IDNV),
    FOREIGN KEY (MANCC) REFERENCES NHACUNGCAP(MANCC)
);
go
CREATE TABLE CTPHIEUNHAP (
    MACTPN NVARCHAR(50) NOT NULL,
    MAPN NVARCHAR(50) NOT NULL,
    MASACH NVARCHAR(50) NOT NULL,
    SOLUONG INT NULL,
    DONGIA INT NULL,
    THANHTIEN INT NULL,
    FOREIGN KEY (MAPN) REFERENCES PHIEUNHAP(MAPN),
    FOREIGN KEY (MASACH) REFERENCES SACH(MASACH)
);
go

	--------------------
	CREATE TABLE LICHSUGIA (
    MASACH NVARCHAR(50) PRIMARY KEY NOT NULL,
    NGAYCAPNHAT DATE NULL,
    NGAYKETTHUC DATE NULL,
    GIABAN INT NULL,
    FOREIGN KEY(MASACH) REFERENCES SACH(MASACH)
);
go
select * from lichsugia
go
----------------
CREATE TABLE VOUCHER (
    MAVOUCHER NVARCHAR(50) PRIMARY KEY NOT NULL,
    MAHD NVARCHAR(50) NOT NULL,
    TENVOUCHER NVARCHAR(50) NOT NULL,
    GIAMGIA INT NULL,
    FOREIGN KEY(MAHD) REFERENCES HOADON(MAHD)
);


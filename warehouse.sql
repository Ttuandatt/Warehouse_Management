create database quanlykhohang;
# drop database quanlykhohang;
use quanlykhohang;	
create table taikhoan (
    taikhoan varchar(30), matkhau varchar(30), loai int, manv varchar(255), Foreign Key (manv) REFERENCES nhanvien (manv)
);
create table nhanvien (
    manv varchar(255), tennv varchar(255), ngsinh varchar(255), diachi varchar(255), sdt char(11), ngayvao varchar(11), loai int, PRIMARY key (manv)
);

create table khachhang (
    makh varchar(255), tenkh varchar(255), diachi varchar(255), sdt varchar(11), primary key (makh)
);

create table nhacungcap (
    mancc varchar(255), tenncc varchar(255), diachi varchar(255), sdt varchar(11), primary key (mancc)
);

create table sanpham (
    masp varchar(255), tensp varchar(255), soluong int, giaban int, boxuly varchar(255), bonho varchar(255), ram int, gpu varchar(255),kichthuoc double, nhacungcap varchar(255), primary key (masp)
);

insert into
    khachhang (makh, tenkh, diachi, sdt) value (
        'KH001', 'Nguyen Van A', '322/15 An Duong Vuong, Quan 5, TP.HCM', '02385123912'
    ),
    (
        'KH002', 'Hoang Duoc Su', '213 Tran Binh Trong, Quan 5, TP.HCM', '034812349212'
    ),
    (
        'KH003', 'Nguyen Thi Anh', '45 Le Loi, Quan 1, TP.HCM', '032178945632'
    ),
    (
        'KH004', 'Tran Van Minh', '76 Nguyen Hue, Quan 3, TP.HCM', '036985214789'
    ),
    (
        'KH005', 'Le Thi Mai', '102 Nguyen Trai, Quan 10, TP.HCM', '038752136984'
    ),
    (
        'KH006', 'Pham Van Tuan', '31 Tran Hung Dao, Quan 1, TP.HCM', '035214789632'
    ),
    (
        'KH007', 'Nguyen Van Hieu', '17 Hoang Sa, Quan 1, TP.HCM', '039854621378'
    ),
    (
        'KH008', 'Tran Thi Lan', '92 Vo Van Tan, Quan 3, TP.HCM', '031478965214'
    ),
    (
        'KH009', 'Le Duc Tho', '55 Ly Thai To, Quan 10, TP.HCM', '032145789632'
    ),
    (
        'KH010', 'Phan Thi Huong', '29 Nguyen Van Cu, Quan 5, TP.HCM', '036985214785'
    ),
    (
        'KH011', 'Tran Van Dat', '8 Nguyen Dinh Chieu, Quan 3, TP.HCM', '034512365987'
    );

insert into
    nhacungcap (mancc, tenncc, diachi, sdt) value (
        'NC2134', 'Cty cong nghiep thuc pham Sao Mai', '41 Pasteur, phuong Ben Nghe, Quan 1, TP.HCM', '03258391234'
    ),
    (
        'NC2135', 'Công ty TNHH Đầu tư và Phát triển ABC', '25 Lê Lợi, phường Bến Thành, Quận 1, TP.HCM', '03258976521'
    ),
    (
        'NC2136', 'Công ty TNHH Sản xuất và Thương mại XYZ', '72 Nguyễn Huệ, phường Phạm Ngũ Lão, Quận 1, TP.HCM', '03259874123'
    ),
    (
        'NC2137', 'Công ty Cổ phần Công nghệ Viễn thông Đông Á', '14 Điện Biên Phủ, phường Đa Kao, Quận 1, TP.HCM', '03258741236'
    ),
    (
        'NC2138', 'Công ty TNHH Mỹ phẩm Hương Biển', '38 Hải Thượng Lãn Ông, phường Bến Thành, Quận 1, TP.HCM', '03259874512'
    );

insert into
    nhanvien (
        manv, tennv, ngsinh, diachi, sdt, ngayvao, loai
    ) value (
        'NV2345', 'Le Van Binh', '09/11/1988', '56 Tran Hung Dao, phuong Co Giang, quan 1, TP.HCM', '09123456789', '30/09/2015', 1
    ),
    (
        'NV6789', 'Hoang Thi Thao', '25/07/1992', '90 Nguyen Trai, phuong Pham Ngu Lao, quan 1, TP.HCM', '09345678901', '18/10/2016', 1
    ),
    (
        'NV8901', 'Tran Duc Quang', '17/03/1987', '45 Le Lai, phuong Ben Thanh, quan 1, TP.HCM', '09654321098', '22/07/2014', 0
    ),
    (
        'NV1234', 'Nguyen Van Khanh', '02/04/1993', '23 Vo Thi Sau, phuong Da Kao, quan 1, TP.HCM', '09987654321', '10/02/2019', 1
    ),
    (
        'NV5678', 'Pham Thi Thu', '11/08/1997', '67 Nguyen Dinh Chieu, phuong Da Kao, quan 1, TP.HCM', '09432109876', '29/05/2017', 1
    ),
    (
        'NV4321', 'Le Hoang Long', '30/06/1996', '32 Ly Tu Trong, phuong Ben Thanh, quan 1, TP.HCM', '09567890123', '15/11/2018', 1
    ),
    (
        'NV7891', 'Nguyen Van Cuong', '08/01/1991', '21 Nguyen Thi Minh Khai, phuong Ben Nghe, quan 1, TP.HCM', '09871234567', '07/04/2016', 1
    ),
    (
        'NV3212', 'Nguyen Ha Vy', '21/12/1999', '34 Vo Van Tan, phuong 6, quan 3, TP.HCM', '01284313854', '21/1/2019', 1
    ),
    (
        'NV4567', 'Tran Van An', '15/05/1995', '78 Le Loi, phuong Ben Thanh, quan 1, TP.HCM', '09876543210', '05/06/2018', 1
    ),
    (
        'NV7890', 'Pham Thi Minh', '03/09/1990', '123 Nguyen Hue, phuong Nguyen Thai Binh, quan 1, TP.HCM', '09781234567', '12/03/2017', 1
    );

insert into
    taikhoan (taikhoan, matkhau, loai, manv) value (
        'nv1111', '12345', 1, "NV5678"
    ),
    (
        'nv2222', '12345', 1, 'NV1234'
    ),
    (
        'nv3333', '12345', 1, 'NV2345'
    ),
    (
        'admin', '1', 0, 'NV8901'
    );

INSERT INTO sanpham (masp, tensp, soluong, giaban, boxuly, bonho, ram, gpu, kichthuoc, nhacungcap) VALUES 
('SP001', 'Laptop Dell Inspiron 15', 50, 18000000, 'Intel Core i5', '256GB', '8', 'GTX 2050', '15.6', 'NC2134'),
('SP002', 'Laptop HP Pavilion 14', 40, 15000000, 'Intel Core i5', '512GB', '8', 'GTX 2025', '14', 'NC2135'),
('SP003', 'Laptop ASUS VivoBook S15', 60, 17000000, 'Intel Core i7', '512GB', '16', 'RTX 2025', '15.6', 'NC2136'),
('SP004', 'Laptop Lenovo IdeaPad Flex 5', 35, 22000000, 'AMD Ryzen 7', '512GB', '16', 'RTX 3060', '15.6', 'NC2137'),
('SP005', 'PC Acer Aspire XC', 25, 12000000, 'Intel Core i5', '256GB', '8', 'Iris XE', '14', 'NC2134'),
('SP006', 'PC Dell OptiPlex 3080', 55, 28000000, 'Intel Core i7', '512GB', '32', 'RTX 3060', '15.6', 'NC2135'),
('SP007', 'PC HP EliteDesk 800 G6', 30, 32000000, 'Intel Core i9', '512GB', '32', 'RTX 3060', '15.6', 'NC2136'),
('SP008', 'PC Lenovo ThinkCentre M720', 20, 20000000, 'Intel Core i5', '256GB', '8', 'GTX 3050', '14', 'NC2137'),
('SP009', 'Laptop MSI Modern 15', 45, 19000000, 'Intel Core i7', '512GB', '16', 'Iris XE', '15.6', 'NC2134'),
('SP010', 'Laptop Acer Aspire 5', 40, 16000000, 'AMD Ryzen 5', '512GB', '8', 'GTX 2025', '15.6', 'NC2135'),
('SP011', 'Laptop Dell Inspiron 15', 50, 18000000, 'Intel Core i5', '256GB', '8', 'GTX 2050', '15.6', 'NC2134'),
('SP012', 'Laptop HP Pavilion 14', 40, 15000000, 'Intel Core i5', '512GB', '8', 'GTX 2025', '14', 'NC2135'),
('SP013', 'Laptop ASUS VivoBook S15', 60, 17000000, 'Intel Core i7', '512GB', '16', 'RTX 2025', '15.6', 'NC2136'),
('SP014', 'Laptop Lenovo IdeaPad Flex 5', 35, 22000000, 'AMD Ryzen 7', '512GB', '16', 'RTX 3060', '15.6', 'NC2137'),
('SP015', 'PC Acer Aspire XC', 25, 12000000, 'Intel Core i5', '256GB', '8', 'Iris XE', '14', 'NC2134'),
('SP016', 'PC Dell OptiPlex 3080', 55, 28000000, 'Intel Core i7', '512GB', '32', 'RTX 3060', '15.6', 'NC2135'),
('SP017', 'PC HP EliteDesk 800 G6', 30, 32000000, 'Intel Core i9', '512GB', '32', 'RTX 3060', '15.6', 'NC2136'),
('SP018', 'PC Lenovo ThinkCentre M720', 20, 20000000, 'Intel Core i5', '256GB', '8', 'GTX 3050', '14', 'NC2137'),
('SP019', 'Laptop MSI Modern 15', 45, 19000000, 'Intel Core i7', '512GB', '16', 'Iris XE', '15.6', 'NC2134'),
('SP020', 'Laptop Acer Aspire 5', 40, 16000000, 'AMD Ryzen 5', '512GB', '8', 'GTX 2025', '15.6', 'NC2135'),
('SP021', 'Laptop Dell XPS 13', 60, 25000000, 'Intel Core i7', '1TB', '16', 'GTX 1650 Ti', '13.4', 'NC2134'),
('SP022', 'Laptop HP Spectre x360', 50, 28000000, 'Intel Core i7', '512GB', '16', 'GTX 1650', '13.3', 'NC2135'),
('SP023', 'Laptop ASUS ROG Zephyrus G14', 40, 30000000, 'AMD Ryzen 9', '1TB', '32', 'RTX 3080', '14', 'NC2136'),
('SP024', 'Laptop Lenovo ThinkPad X1 Carbon', 55, 32000000, 'Intel Core i9', '2TB', '32', 'RTX 3070', '14', 'NC2137'),
('SP025', 'Laptop MSI GS66 Stealth', 60, 30000000, 'Intel Core i9', '2TB', '64', 'RTX 3080', '15.6', 'NC2134'),
('SP026', 'Laptop Acer Predator Helios 300', 55, 32000000, 'Intel Core i7', '1TB', '32', 'RTX 3070', '15.6', 'NC2135');


CREATE TABLE phieuxuat (
  sothutu int auto_increment PRIMARY KEY,
  maxuat VARCHAR(255),
  nguoitao VARCHAR(10),
  makh VARCHAR(255),
  tongtien DOUBLE,
  thoiGianTao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (makh) REFERENCES khachhang (makh)
);

-- Chèn dữ liệu vào bảng phieuxuat
INSERT INTO phieuxuat (maxuat, nguoitao, makh, tongtien)
VALUES
('PX001', 'admin', 'KH001', 1000.0),
('PX002', 'nhân viên', 'KH002', 2000.0),
('PX003', 'admin', 'KH003', 3000.0),
('PX004', 'nhân viên', 'KH004', 4000.0),
('PX005', 'admin', 'KH005', 5000.0),
('PX006', 'nhân viên', 'KH006', 6000.0),
('PX007', 'admin', 'KH007', 7000.0),
('PX008', 'nhân viên', 'KH008', 8000.0),
('PX009', 'admin', 'KH009', 9000.0),
('PX010', 'nhân viên', 'KH010', 10000.0),
('PX011', 'admin', 'KH011', 11000.0),
('PX012', 'nhân viên', 'KH012', 12000.0),
('PX013', 'admin', 'KH013', 13000.0),
('PX014', 'nhân viên', 'KH014', 14000.0),
('PX015', 'admin', 'KH015', 15000.0),
('PX016', 'nhân viên', 'KH016', 16000.0),
('PX017', 'admin', 'KH017', 17000.0),
('PX018', 'nhân viên', 'KH018', 18000.0),
('PX019', 'admin', 'KH019', 19000.0),
('PX020', 'nhân viên', 'KH020', 20000.0);

INSERT INTO khachhang (makh, tenkh, diachi, sdt) VALUES
    ('KH001', 'Nguyen Van A', '322/15 An Duong Vuong, Quan 5, TP.HCM', '02385123912'),
    ('KH002', 'Hoang Duoc Su', '213 Tran Binh Trong, Quan 5, TP.HCM', '034812349212'),
    ('KH003', 'Nguyen Thi Anh', '45 Le Loi, Quan 1, TP.HCM', '032178945632'),
    ('KH004', 'Tran Van Minh', '76 Nguyen Hue, Quan 3, TP.HCM', '036985214789'),
    ('KH005', 'Le Thi Mai', '102 Nguyen Trai, Quan 10, TP.HCM', '038752136984'),
    ('KH006', 'Pham Van Tuan', '31 Tran Hung Dao, Quan 1, TP.HCM', '035214789632'),
    ('KH007', 'Nguyen Van Hieu', '17 Hoang Sa, Quan 1, TP.HCM', '039854621378'),
    ('KH008', 'Tran Thi Lan', '92 Vo Van Tan, Quan 3, TP.HCM', '031478965214'),
    ('KH009', 'Le Duc Tho', '55 Ly Thai To, Quan 10, TP.HCM', '032145789632'),
    ('KH010', 'Phan Thi Huong', '29 Nguyen Van Cu, Quan 5, TP.HCM', '036985214785'),
    ('KH011', 'Tran Van Dat', '8 Nguyen Dinh Chieu, Quan 3, TP.HCM', '034512365987'),
    ('KH012', 'Nguyen Van B', '322/15 An Duong Vuong, Quan 5, TP.HCM', '02385123912'),
    ('KH013', 'Hoang Van Su', '213 Tran Binh Trong, Quan 5, TP.HCM', '034812349212'),
    ('KH014', 'Nguyen Van Anh', '45 Le Loi, Quan 1, TP.HCM', '032178945632'),
    ('KH015', 'Tran Van Hoang', '76 Nguyen Hue, Quan 3, TP.HCM', '036985214789'),
    ('KH016', 'Le Van Mai', '102 Nguyen Trai, Quan 10, TP.HCM', '038752136984'),
    ('KH017', 'Pham Thi Tuan', '31 Tran Hung Dao, Quan 1, TP.HCM', '035214789632'),
    ('KH018', 'Nguyen Van Hien', '17 Hoang Sa, Quan 1, TP.HCM', '039854621378'),
    ('KH019', 'Tran Thi Nhung', '92 Vo Van Tan, Quan 3, TP.HCM', '031478965214'),
    ('KH020', 'Le Duc Thang', '55 Ly Thai To, Quan 10, TP.HCM', '032145789632');


create table phieunhap (
    manhap varchar(255), mancc varchar(255), tongtien int
);
create table ctchungtu (
mact varchar(255), masp varchar(255), soluong int, Foreign Key (mact) REFERENCES chungtu (mact), Foreign Key (masp) REFERENCES sanpham (masp)
);

/* 
insert into
chungtu (mact, loai, tongtien) value ('N0321', 0, 374000000),
('N0574', 0, 368000000),
('N4392', 0, 200000000),
('N1234', 0, 700000000);
insert into ctchungtu (mact, masp, soluong) value ('N0321', 'SP011', 3),
('N0321', 'SP012', 10),
('N0574', 'SP013', 10),
('N0574', 'SP018', 4),
('N4392', 'SP020', 5),
('N4392', 'SP019', 5),
('N1234', 'SP006', 20); */
/* create table chungtu (
mact varchar(255), loai varchar(255), tongtien varchar(255), primary key (mact)
);
*/

###################### QUERY ########################
SELECT * FROM nhanvien;
SELECT * FROM khachhang;
SELECT * FROM nhacungcap;
SELECT * FROM sanpham;
SELECT * FROM phieuxuat;
SELECT * FROM taikhoan;
SELECT * FROM quanlykhohang.sanpham;

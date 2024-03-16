-- Active: 1694393309740@@127.0.0.1@3306@warehouse
create database warehouse;

use warehouse;

create table taikhoan (
    taikhoan VARCHAR(255), matkhau varchar(255)
);

create table nhanvien (
    manv varchar(255), tennv varchar(255), ngsinh varchar(255), diachi varchar(255), sdt char(11), ngayvao varchar(11), loai int, PRIMARY key (manv)
);

create table khachhang (
    makh varchar(255), tenkh varchar(255), diachi varchar(255), sdt varchar(11), primary key (makh)
);

create table sanpham (
    masp varchar(255), tensp varchar(255), soluong int, giaban int, primary key (masp)
);

create table nhacungcap (
    mancc varchar(255), tenncc varchar(255), diachi varchar(255), primary key (mancc)
);

create table taikhoan (
    taikhoan varchar(30), matkhau varchar(30)
);

create table chungtu (
    mact varchar(255), loai varchar(255), tongtien varchar(255), primary key (mact)
);

create table ctchungtu (
    mact varchar(255), masp varchar(255), soluong int, Foreign Key (mact) REFERENCES chungtu (mact), Foreign Key (masp) REFERENCES sanpham (masp)
);

alter table taikhoan add column loai int;

alter table sanpham add column boxuly varchar(255);

alter table sanpham add column bonho varchar(255);

alter table sanpham add column ram int;

alter table sanpham add column nhacungcap varchar(255);

alter table nhacungcap add column sdt varchar(11);

insert into
    taikhoan (taikhoan, matkhau, loai) value ('nv1111', '12345', 1),
    ('nv2222', '12345', 2),
    ('nv3333', '12345', 1),
    ('ql1234', '12345', 0)

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
        'NV8901', 'Tran Duc Quang', '17/03/1987', '45 Le Lai, phuong Ben Thanh, quan 1, TP.HCM', '09654321098', '22/07/2014', 1
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
    sanpham (
        masp, tensp, soluong, giaban, boxuly, bonho, ram, nhacungcap
    ) value (
        'SP002', 'Laptop HP Spectre x360', 40, 22000000, 'Intel Core i7', '1TB SSD', 16, 'NC2135'
    ),
    (
        'SP003', 'Laptop ASUS ROG Strix Scar', 30, 30000000, 'Intel Core i9', '1TB SSD', 32, 'NC2136'
    ),
    (
        'SP004', 'PC Acer Predator Orion 9000', 20, 40000000, 'Intel Core i9', '2TB HDD + 512GB SSD', 64, 'NC2137'
    ),
    (
        'SP005', 'PC Lenovo ThinkCentre M920', 60, 15000000, 'Intel Core i5', '1TB HDD', 8, 'NC2134'
    ),
    (
        'SP006', 'Laptop Apple MacBook Pro', 45, 35000000, 'Apple M1 Chip', '512GB SSD', 16, 'NC2135'
    ),
    (
        'SP007', 'PC Dell Alienware Aurora R12', 25, 38000000, 'Intel Core i9', '1TB SSD', 32, 'NC2136'
    ),
    (
        'SP008', 'Laptop Microsoft Surface Laptop 4', 55, 18000000, 'Intel Core i5', '256GB SSD', 8, 'NC2137'
    ),
    (
        'SP009', 'Laptop Lenovo ThinkPad X1 Carbon', 35, 20000000, 'Intel Core i7', '512GB SSD', 16, 'NC2134'
    ),
    (
        'SP010', 'PC HP Pavilion Gaming Desktop', 30, 25000000, 'AMD Ryzen 7', '1TB HDD + 512GB SSD', 16, 'NC2135'
    ),
    (
        'SP011', 'Laptop Acer Swift 5', 50, 18000000, 'Intel Core i7', '512GB SSD', 16, 'NC2134'
    ),
    (
        'SP012', 'PC ASUS ROG Strix GL12', 40, 32000000, 'Intel Core i9', '1TB SSD', 32, 'NC2135'
    ),
    (
        'SP013', 'Laptop MSI GS66 Stealth', 30, 28000000, 'Intel Core i9', '1TB SSD', 32, 'NC2136'
    ),
    (
        'SP014', 'PC Lenovo ThinkStation P520', 20, 45000000, 'Intel Xeon', '2TB HDD + 512GB SSD', 4, 'NC2137'
    ),
    (
        'SP015', 'PC Dell XPS Tower Special Edition', 60, 35000000, 'Intel Core i7', '1TB SSD', 32, 'NC2134'
    ),
    (
        'SP016', 'Laptop Razer Blade 15', 45, 32000000, 'Intel Core i7', '1TB SSD', 16, 'NC2135'
    ),
    (
        'SP017', 'PC HP ENVY Desktop', 25, 28000000, 'Intel Core i9', '1TB SSD', 32, 'NC2136'
    ),
    (
        'SP018', 'Laptop Samsung Galaxy Book Flex', 55, 22000000, 'Intel Core i7', '512GB SSD', 16, 'NC2137'
    ),
    (
        'SP019', 'Laptop LG Gram 17', 35, 25000000, 'Intel Core i7', '512GB SSD', 16, 'NC2134'
    ),
    (
        'SP020', 'PC Acer Aspire TC', 30, 15000000, 'Intel Core i5', '1TB HDD', 8, 'NC2135'
    );

insert into
    chungtu (mact, loai, tongtien) value ('N0321', 0, 374000000),
    ('N0574', 0, 368000000),
    ('N4392', 0, 200000000),
    ('N1234', 0, 700000000);

insert into
    ctchungtu (mact, masp, soluong) value ('N0321', 'SP011', 3),
    ('N0321', 'SP012', 10),
    ('N0574', 'SP013', 10),
    ('N0574', 'SP018', 4),
    ('N4392', 'SP020', 5),
    ('N4392', 'SP019', 5) ('N1234', 'SP006', 20);
    insert into khachhang (makh,tenkh,di)
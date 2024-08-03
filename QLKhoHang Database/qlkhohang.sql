create database quanlykhohang;
# drop database quanlykhohang;
use quanlykhohang;	

######################### KHO HÀNG #######################
CREATE TABLE khohang (
    makhohang varchar(255) PRIMARY KEY, 
    tenkhohang varchar(255), 
    diachikho varchar(255), 
    sdt varchar(255),
    trangthai int
);
drop table khohang;
INSERT INTO khohang (makhohang, tenkhohang, diachikho, sdt, trangthai) VALUES
('KH001', 'Kho Hàng A', '123 Đường ABC, Quận XYZ, Thành phố HCM', '0123456789',1),
('KH002', 'Kho Hàng B', '456 Đường DEF, Quận UVW, Thành phố HCM', '0987654321',1),
('KH003', 'Kho Hàng C', '789 Đường GHI, Quận RST, Thành phố HCM', '0369852147',1);

######################### SẢN PHẨM ####################### 
CREATE TABLE sanpham (
    masp varchar(255) PRIMARY KEY, 
    tensp varchar(255), 
    soluong int, 
    giaban int, 
    boxuly varchar(255), 
    ram varchar(10), 
    bonho varchar(255), 
    gpu varchar(255), 
    kichthuoc varchar(255), 
    nhacungcap varchar(255), 
    makho varchar(255),
    trangthai int,
    FOREIGN KEY (makho) REFERENCES khohang(makhohang)
);
drop table sanpham;
INSERT INTO sanpham (masp, tensp, soluong, giaban, boxuly, bonho, ram, gpu, kichthuoc, nhacungcap, makho, trangthai) VALUES 
('SP001', 'Dell Inspiron 15', 50, 18000000, 'Intel Core i5-11400H', '256GB', '8GB', 'GTX 2050', '15.6" FHD 144Hz', 'NC2134', 'KH001',1),
('SP002', 'HP Pavilion 14', 40, 15000000, 'Intel Core i5-11400H', '512GB', '8GB', 'GTX 2025', '14" 2.8K OLED', 'NC2135', 'KH002',1),
('SP003', 'ASUS VivoBook S15', 60, 17000000, 'Intel Core i7-1355U', '512GB', '16GB', 'RTX 2025', '15.6" FHD 60Hz', 'NC2136', 'KH003',1),
('SP004', 'Lenovo IdeaPad Flex 5', 35, 22000000, 'AMD Ryzen 7-6600H', '512GB', '16GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2137', 'KH001',1),
('SP005', 'Acer Aspire XC', 25, 12000000, 'Intel Core i5-1215U', '256GB', '8GB', 'Iris XE', '14" FHD 60Hz', 'NC2134', 'KH002',1),
('SP006', 'Dell OptiPlex 3080', 55, 28000000, 'Intel Core i7-12700H', '512GB', '32GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2135', 'KH003',1),
('SP007', 'HP EliteDesk 800 G6', 30, 32000000, 'Intel Core i7-13700H', '512GB', '32GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2136', 'KH001',1),
('SP008', 'Lenovo ThinkCentre M720', 20, 20000000, 'Intel Core i5-12450H', '256GB', '8GB', 'GTX 3050', '14" FHD 60Hz', 'NC2137', 'KH002',1),
('SP009', 'MSI Modern 15', 45, 19000000, 'Intel Core i7-1355U', '512GB', '16GB', 'Iris XE', '15.6" FHD 60Hz', 'NC2134', 'KH003',1),
('SP010', 'Acer Aspire 5', 40, 16000000, 'AMD Ryzen 5-5500H', '512GB', '8GB', 'GTX 2025', '15.6" FHD 144Hz', 'NC2135', 'KH001',1),
('SP011', 'Dell Inspiron 15', 50, 18000000, 'Intel Core i5-11400H', '256GB', '8GB', 'GTX 2050', '15.6" FHD 144Hz', 'NC2134', 'KH002',1),
('SP012', 'HP Pavilion 14', 40, 15000000, 'Intel Core i5-11400H', '512GB', '8GB', 'GTX 2025', '14" 2.8K OLED', 'NC2135', 'KH003',1),
('SP013', 'ASUS VivoBook S15', 60, 17000000, 'Intel Core i7-1355U', '512GB', '16GB', 'RTX 2025', '15.6" FHD 60Hz', 'NC2136', 'KH001',1),
('SP014', 'Lenovo IdeaPad Flex 5', 35, 22000000, 'AMD Ryzen 7-6600H', '512GB', '16GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2137', 'KH002',1),
('SP015', 'Acer Aspire XC', 25, 12000000, 'Intel Core i5-1215U', '256GB', '8GB', 'Iris XE', '14" FHD 60Hz', 'NC2134', 'KH003',1),
('SP016', 'Dell OptiPlex 3080', 55, 28000000, 'Intel Core i7-12700H', '512GB', '32GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2135', 'KH001',1),
('SP017', 'HP EliteDesk 800 G6', 30, 32000000, 'Intel Core i7-13700H', '512GB', '32GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2136', 'KH002',1),
('SP018', 'Lenovo ThinkCentre M720', 20, 20000000, 'Intel Core i5-12450H', '256GB', '8GB', 'GTX 3050', '14" FHD 60Hz', 'NC2137', 'KH003',1),
('SP019', 'MSI Modern 15', 45, 19000000, 'Intel Core i7-1355U', '512GB', '16GB', 'Iris XE', '15.6" FHD 60Hz', 'NC2134', 'KH001',1),
('SP020', 'Acer Aspire 5', 40, 16000000, 'AMD Ryzen 5-5500H', '512GB', '8GB', 'GTX 2025', '15.6" FHD 144Hz', 'NC2135', 'KH002',1),
('SP021', 'Dell XPS 13', 60, 25000000, 'Intel Core i7-1255U', '1TB', '16GB', 'GTX 1650 Ti', '13.4"', 'NC2136', 'KH003',1),
('SP022', 'HP Spectre x360', 50, 28000000, 'Intel Core i7-1255U', '512GB', '16GB', 'GTX 1650', '13.3"', 'NC2137', 'KH001',1),
('SP023', 'ASUS ROG Zephyrus G14', 40, 30000000, 'AMD Ryzen 7-5700U', '1TB', '32GB', 'RTX 3080', '14" FHD 144Hz', 'NC2134', 'KH002',1),
('SP024', 'Lenovo ThinkPad X1 Carbon', 55, 32000000, 'Intel Core i7-1255U', '2TB', '32GB', 'RTX 3070', '14" FHD 60Hz', 'NC2135', 'KH003',1),
('SP025', 'MSI GS66 Stealth', 60, 30000000, 'Intel Core i7-1255U', '2TB', '64GB', 'RTX 3080', '15.6" FHD 60Hz', 'NC2136', 'KH001',1),
('SP026', 'Acer Predator Helios 300', 55, 32000000, 'Intel Core i7-12700H', '1TB', '32GB', 'RTX 3070', '15.6" FHD 60Hz', 'NC2137', 'KH002',1),
('SP027', 'ASUS ROG Strix GA15', 30, 35000000, 'AMD Ryzen 7-5700U', '1TB', '32GB', 'RTX 3080', '15.6" FHD 60Hz', 'NC2134', 'KH003',1),
('SP028', 'HP Omen Obelisk', 25, 38000000, 'Intel Core i9-1355U', '2TB', '64GB', 'RTX 3090', '15.6" FHD 60Hz', 'NC2135', 'KH001',1),
('SP029', 'Lenovo Legion Tower 5i', 35, 32000000, 'Intel Core i7-12700H', '1TB', '32GB', 'RTX 3070', '15.6" FHD 60Hz', 'NC2136', 'KH002',1),
('SP030', 'MSI Trident A', 40, 30000000, 'Intel Core i7-12700H', '1TB', '32GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2137', 'KH003',1),
('SP031', 'Dell Latitude 14', 50, 27000000, 'Intel Core i7-1255U', '1TB', '32GB', 'GTX 1650', '14" FHD 60Hz', 'NC2134', 'KH001',1),
('SP032', 'HP Envy 15', 45, 29000000, 'Intel Core i7-12700H', '512GB', '16GB', 'GTX 1650 Ti', '15.6" FHD 144Hz', 'NC2135', 'KH002',1),
('SP033', 'ASUS ZenBook Duo', 55, 31000000, 'Intel Core i7-12700H', '1TB', '32GB', 'RTX 3050', '14" FHD 60Hz', 'NC2136', 'KH003',1),
('SP034', 'Lenovo Yoga 9i', 60, 33000000, 'Intel Core i7-12700H', '1TB', '32GB', 'RTX 3050', '14" FHD 60Hz', 'NC2137', 'KH001',1),
('SP035', 'MSI Prestige 14', 40, 25000000, 'Intel Core i7-12700H', '1TB', '32GB', 'GTX 1650 Ti', '14" FHD 60Hz', 'NC2134', 'KH002',1),
('SP036', 'Acer Nitro 5', 35, 28000000, 'Intel Core i7-12700H', '1TB', '32GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2135', 'KH003',1),
('SP037', 'Dell Alienware m15', 50, 35000000, 'Intel Core i9-1355U', '2TB', '64GB', 'RTX 3080', '15.6" FHD 60Hz', 'NC2136', 'KH001',1),
('SP038', 'HP ZBook Studio', 55, 32000000, 'Intel Core i7-12700H', '1TB', '32GB', 'RTX 3070', '15.6" FHD 60Hz', 'NC2137', 'KH002',1),
('SP039', 'Lenovo ThinkPad P1', 40, 30000000, 'Intel Core i7-12700H', '1TB', '32GB', 'RTX 3080', '15.6" FHD 60Hz', 'NC2134', 'KH003',1),
('SP040', 'MSI Creator Z16', 45, 33000000, 'Intel Core i9-1355U', '2TB', '64GB', 'RTX 3070', '15.6" FHD 60Hz', 'NC2135', 'KH001',1),
('SP041', 'Dell Precision 5560', 50, 28000000, 'Intel Core i7-12700H', '1TB', '32GB', 'GTX 1650', '15.6" FHD 60Hz', 'NC2136', 'KH002',1),
('SP042', 'HP EliteBook 840', 35, 26000000, 'Intel Core i7-12700H', '1TB', '32GB', 'RTX 3050', '14" FHD 60Hz', 'NC2137', 'KH003',1),
('SP043', 'ASUS ProArt StudioBook Pro X', 30, 38000000, 'Intel Xeon-1375M', '2TB', '64GB', 'RTX 3080', '17" 4K OLED', 'NC2134', 'KH001',1),
('SP044', 'Lenovo ThinkPad P15', 55, 35000000, 'Intel Core i9-1355U', '2TB', '64GB', 'RTX 3080', '15.6" FHD 60Hz', 'NC2135', 'KH002',1),
('SP045', 'MSI WS66', 60, 32000000, 'Intel Core i7-12700H', '1TB', '32GB', 'RTX 3070', '15.6" FHD 60Hz', 'NC2136', 'KH003',1),
('SP046', 'Acer ConceptD 7', 50, 33000000, 'Intel Core i9-1355U', '2TB', '64GB', 'RTX 3080', '15.6" 4K OLED', 'NC2137', 'KH001',1),
('SP047', 'Dell Precision 3561', 45, 29000000, 'Intel Core i7-12700H', '1TB', '32GB', 'RTX 3050', '15.6" FHD 60Hz', 'NC2134', 'KH002',1),
('SP048', 'HP ZBook Firefly', 55, 31000000, 'Intel Core i7-12700H', '1TB', '32GB', 'RTX 3050', '14" FHD 60Hz', 'NC2135', 'KH003',1),
('SP049', 'Lenovo ThinkPad P14s', 40, 30000000, 'Intel Core i7-12700H', '1TB', '32GB', 'RTX 3070', '14" FHD 60Hz', 'NC2136', 'KH001',1),
('SP050', 'MSI Summit E15', 35, 32000000, 'Intel Core i7-12700H', '1TB', '32GB', 'RTX 3070', '15.6" FHD 60Hz', 'NC2137', 'KH002',1),
('SP051', 'Dell Inspiron 14', 50, 20000000, 'Intel Core i5-12450H', '512GB', '8GB', 'GTX 2050', '14" FHD 144Hz', 'NC2134', 'KH002',1),
('SP052', 'HP Pavilion 15', 40, 18000000, 'Intel Core i5-11400H', '256GB', '8GB', 'GTX 2025', '15.6" FHD 60Hz', 'NC2135', 'KH003',1),
('SP053', 'ASUS VivoBook S14', 60, 19000000, 'Intel Core i7-1355U', '512GB', '16GB', 'RTX 2025', '14" 2.8K OLED', 'NC2136', 'KH001',1),
('SP054', 'Lenovo IdeaPad Flex 5', 35, 22000000, 'AMD Ryzen 7-6600H', '512GB', '16GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2137', 'KH002',1),
('SP055', 'Acer Aspire XC', 25, 12000000, 'Intel Core i5-1215U', '256GB', '8GB', 'Iris XE', '14" FHD 144Hz', 'NC2134', 'KH003',1),
('SP056', 'Dell OptiPlex 3080', 55, 28000000, 'Intel Core i7-12700H', '512GB', '32GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2135', 'KH001',1),
('SP057', 'HP EliteDesk 800 G6', 30, 32000000, 'Intel Core i7-13700H', '512GB', '32GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2136', 'KH002',1),
('SP058', 'Lenovo ThinkCentre M720', 20, 20000000, 'Intel Core i5-11400H', '256GB', '8GB', 'GTX 3050', '14" 2.8K OLED', 'NC2137', 'KH003',1),
('SP059', 'MSI Modern 14', 45, 21000000, 'Intel Core i7-1355U', '512GB', '16GB', 'Iris XE', '14" 2.8K OLED', 'NC2134', 'KH001',1),
('SP060', 'Acer Aspire 5', 40, 16000000, 'AMD Ryzen 5-5500H', '512GB', '8GB', 'GTX 2025', '15.6" FHD 60Hz', 'NC2135', 'KH002',1),
('SP061', 'Dell Inspiron 14', 50, 20000000, 'Intel Core i5-12450H', '512GB', '8GB', 'GTX 2050', '14" FHD 144Hz', 'NC2134', 'KH002',1),
('SP062', 'HP Pavilion 15', 40, 18000000, 'Intel Core i5-11400H', '256GB', '8GB', 'GTX 2025', '15.6" FHD 60Hz', 'NC2135', 'KH003',1),
('SP063', 'ASUS VivoBook S14', 60, 19000000, 'Intel Core i7-1355U', '512GB', '16GB', 'RTX 2025', '14" 2.8K OLED', 'NC2136', 'KH001',1),
('SP064', 'Lenovo IdeaPad Flex 5', 35, 22000000, 'AMD Ryzen 7-5700U', '512GB', '16GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2137', 'KH002',1),
('SP065', 'Acer Aspire XC', 25, 12000000, 'Intel Core i5-1215U', '256GB', '8GB', 'Iris XE', '14" FHD 144Hz', 'NC2134', 'KH003',1),
('SP066', 'Dell OptiPlex 3080', 55, 28000000, 'Intel Core i7-12700H', '512GB', '32GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2135', 'KH001',1),
('SP067', 'HP EliteDesk 800 G6', 30, 32000000, 'Intel Core i7-13700H', '512GB', '32GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2136', 'KH002',1),
('SP068', 'Lenovo ThinkCentre M720', 20, 20000000, 'Intel Core i5-11400H', '256GB', '8GB', 'GTX 3050', '14" 2.8K OLED', 'NC2137', 'KH003',1),
('SP069', 'MSI Modern 14', 45, 21000000, 'Intel Core i7-1355U', '512GB', '16GB', 'Iris XE', '14" 2.8K OLED', 'NC2134', 'KH001',1),
('SP070', 'Acer Aspire 5', 40, 16000000, 'AMD Ryzen 5-5500H', '512GB', '8GB', 'GTX 2025', '15.6" FHD 60Hz', 'NC2135', 'KH002',1),
('SP071', 'Dell Inspiron 14', 50, 20000000, 'Intel Core i5-12450H', '512GB', '8GB', 'GTX 2050', '14" FHD 144Hz', 'NC2134', 'KH002',1),
('SP072', 'HP Pavilion 15', 40, 18000000, 'Intel Core i5-11400H', '256GB', '8GB', 'GTX 2025', '15.6" FHD 60Hz', 'NC2135', 'KH003',1),
('SP073', 'ASUS VivoBook S14', 60, 19000000, 'Intel Core i7-1355U', '512GB', '16GB', 'RTX 2025', '14" 2.8K OLED', 'NC2136', 'KH001',1),
('SP074', 'Lenovo IdeaPad Flex 5', 35, 22000000, 'AMD Ryzen 7-5700U', '512GB', '16GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2137', 'KH002',1),
('SP075', 'Acer Aspire XC', 25, 12000000, 'Intel Core i5-1215U', '256GB', '8GB', 'Iris XE', '14" FHD 144Hz', 'NC2134', 'KH003',1),
('SP076', 'Dell OptiPlex 3080', 55, 28000000, 'Intel Core i7-12700H', '512GB', '32GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2135', 'KH001',1),
('SP077', 'HP EliteDesk 800 G6', 30, 32000000, 'Intel Core i7-13700H', '512GB', '32GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2136', 'KH002',1),
('SP078', 'Lenovo ThinkCentre M720', 20, 20000000, 'Intel Core i5-11400H', '256GB', '8GB', 'GTX 3050', '14" 2.8K OLED', 'NC2137', 'KH003',1),
('SP079', 'MSI Modern 14', 45, 21000000, 'Intel Core i7-1355U', '512GB', '16GB', 'Iris XE', '14" 2.8K OLED', 'NC2134', 'KH001',1),
('SP080', 'Acer Aspire 5', 40, 16000000, 'AMD Ryzen 5-5500H', '512GB', '8GB', 'GTX 2025', '15.6" FHD 60Hz', 'NC2135', 'KH002',1),
('SP081', 'Dell Inspiron 14', 50, 20000000, 'Intel Core i5-12450H', '512GB', '8GB', 'GTX 2050', '14" FHD 144Hz', 'NC2134', 'KH002',1),
('SP082', 'HP Pavilion 15', 40, 18000000, 'Intel Core i5-11400H', '256GB', '8GB', 'GTX 2025', '15.6" FHD 60Hz', 'NC2135', 'KH003',1),
('SP083', 'ASUS VivoBook S14', 60, 19000000, 'Intel Core i7-1355U', '512GB', '16GB', 'RTX 2025', '14" 2.8K OLED', 'NC2136', 'KH001',1),
('SP084', 'Lenovo IdeaPad Flex 5', 35, 22000000, 'AMD Ryzen 7-5700U', '512GB', '16GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2137', 'KH002',1),
('SP085', 'Acer Aspire XC', 25, 12000000, 'Intel Core i5-1215U', '256GB', '8GB', 'Iris XE', '14" FHD 144Hz', 'NC2134', 'KH003',1),
('SP086', 'Dell OptiPlex 3080', 55, 28000000, 'Intel Core i7-12700H', '512GB', '32GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2135', 'KH001',1),
('SP087', 'HP EliteDesk 800 G6', 30, 32000000, 'Intel Core i7-13700H', '512GB', '32GB', 'RTX 3060', '15.6" FHD 60Hz', 'NC2136', 'KH002',1),
('SP088', 'Lenovo ThinkCentre M720', 20, 20000000, 'Intel Core i5-11400H', '256GB', '8GB', 'GTX 3050', '14" 2.8K OLED', 'NC2137', 'KH003',1),
('SP089', 'MSI Modern 14', 45, 21000000, 'Intel Core i7-1355U', '512GB', '16GB', 'Iris XE', '14" 2.8K OLED', 'NC2134', 'KH001',1),
('SP090', 'Acer Aspire 5', 40, 16000000, 'AMD Ryzen 5-5500H', '512GB', '8GB', 'GTX 2025', '15.6" FHD 60Hz', 'NC2135', 'KH002',1);

######################### SẢN PHẨM DỰ TRỮ####################### 
CREATE TABLE sanphamdutru (
    masp varchar(255) PRIMARY KEY, 
    tensp varchar(255), 
    soluong int, 
    giaban int, 
    boxuly varchar(255), 
    ram varchar(10), 
    bonho varchar(255), 
    gpu varchar(255), 
    kichthuoc varchar(255), 
    nhacungcap varchar(255), 
    makho varchar(255),
    trangthai int,
    FOREIGN KEY (makho) REFERENCES khohang(makhohang)
);
drop table sanpham;
INSERT INTO sanphamdutru (masp, tensp, soluong, giaban, boxuly, bonho, ram, gpu, kichthuoc, nhacungcap, makho, trangthai) VALUES 
('SP001', 'Dell Inspiron 15', 50, 18000000, 'Intel Core i5-11400H', '256GB', '8GB', 'GTX 2050', '15.6" FHD 144Hz', 'NC2134', 'KH001',2);

######################### NHÀ CUNG CẤP ####################### 
CREATE TABLE nhacungcap (
    mancc varchar(255) PRIMARY KEY, 
    tenncc varchar(255), 
    diachi varchar(255), 
    sdt varchar(11),
    trangthai int
);
drop table nhacungcap;
INSERT INTO nhacungcap (mancc, tenncc, diachi, sdt, trangthai) VALUES
('NC2134', 'Cty cong nghiep thuc pham Sao Mai', '41 Pasteur, phuong Ben Nghe, Quan 1, TP.HCM', '03258391234',1),
('NC2135', 'Công ty TNHH Đầu tư và Phát triển ABC', '25 Lê Lợi, phường Bến Thành, Quận 1, TP.HCM', '03258976521',1),
('NC2136', 'Công ty TNHH Sản xuất và Thương mại XYZ', '72 Nguyễn Huệ, phường Phạm Ngũ Lão, Quận 1, TP.HCM', '03259874123',1),
('NC2137', 'Công ty Cổ phần Công nghệ Viễn thông Đông Á', '14 Điện Biên Phủ, phường Đa Kao, Quận 1, TP.HCM', '03258741236',1),
('NC2138', 'Công ty TNHH Mỹ phẩm Hương Biển', '38 Hải Thượng Lãn Ông, phường Bến Thành, Quận 1, TP.HCM', '03259874512',1);

######################### PHIẾU NHẬP ####################### 
create table phieunhap (
	mapn varchar(255) primary key,
	manguoitao VARCHAR(255),
    	makho varchar(255),
    	mancc varchar(255),
	thoigiantao date,
	tongtien INT,
	trangthai INT,
	#foreign key (mapx) REFERENCES ctphieuxuat(mapx),
	foreign key (manguoitao) REFERENCES nhanvien(manv)
);
drop table phieunhap;
######################### CHI TIẾT PHIẾU NHẬP #######################
create table ctphieunhap (
	mapn varchar(255),
	masp varchar(255),
	tensp varchar(255),
	soluong INT,
	gia INT,
	trangthai INT,
	foreign key (masp) REFERENCES sanpham(masp)
);
drop table ctphieunhap;
######################### PHIẾU XUẤT #######################  
CREATE TABLE phieuxuat (
  mapx varchar(255) primary key,
  manguoitao VARCHAR(255),
  makho varchar(255),
  makhachhang varchar(255),
  thoigiantao date,
  tongtien INT,
  trangthai INT,
  #foreign key (mapx) REFERENCES ctphieuxuat(mapx),
  foreign key (manguoitao) REFERENCES nhanvien(manv)
); 
INSERT INTO phieuxuat (manguoitao, tongtien, trangthai) VALUES
('NV1234', 228000000, 1),
('NV2345', 2000, 1),
('NV5678', 1800, 1);
drop table phieuxuat;
######################### CHI TIẾT PHIẾU XUẤT #######################
CREATE TABLE ctphieuxuat (
  mapx varchar(255),
  masp varchar(255),
  tensp varchar(255),
  soluong INT,
  gia INT,
  trangthai INT,
  foreign key (masp) REFERENCES sanpham(masp)
);
INSERT INTO ctphieuxuat (mapx, maNguoiTao, thoiGianTao, maSP, tenSP, soLuong, gia, trangthai) VALUES
(1, 'NV1234', CURRENT_TIMESTAMP, 'SP010', 'Acer Aspire 5', 5, 16000000, 1),
(1, 'NV1234', CURRENT_TIMESTAMP, 'SP022', 'HP Spectre x360', 3, 28000000, 1),
(1, 'NV1234', CURRENT_TIMESTAMP, 'SP045', 'MSI WS66', 2, 32000000, 1);
drop table ctphieuxuat;
######################### NHÂN VIÊN #######################
CREATE TABLE nhanvien (
    manv varchar(255) PRIMARY KEY, 
    tennv varchar(255), 
    ngsinh varchar(255), 
    gioitinh varchar(10), 
    diachi varchar(255), 
    sdt char(11), 
    ngayvao varchar(11), 
    loai int, 
    kho varchar(255),
    trangthai int,
    FOREIGN KEY (kho) REFERENCES khohang(makhohang)
);
drop table nhanvien;
INSERT INTO nhanvien (manv, tennv, ngsinh, gioitinh, diachi, sdt, ngayvao, loai, kho, trangthai) VALUES 
('NV2345', 'Le Van Binh', '09/11/1988', 'Nam', '56 Tran Hung Dao, phuong Co Giang, quan 1, TP.HCM', '09123456789', '30/09/2015', 1, 'KH001',1),
('NV6789', 'Hoang Thi Thao', '25/07/1992', 'Nu', '90 Nguyen Trai, phuong Pham Ngu Lao, quan 1, TP.HCM', '09345678901', '18/10/2016', 1, 'KH003',1),
('NV8901', 'Tran Duc Quang', '17/03/1987', 'Nam', '45 Le Lai, phuong Ben Thanh, quan 1, TP.HCM', '09654321098', '22/07/2014', 0, 'KH001',1),
('NV1234', 'Nguyen Van Khanh', '02/04/1993', 'Nam', '23 Vo Thi Sau, phuong Da Kao, quan 1, TP.HCM', '09987654321', '10/02/2019', 1, 'KH002',1),
('NV5678', 'Pham Thi Thu', '11/08/1997', 'Nu', '67 Nguyen Dinh Chieu, phuong Da Kao, quan 1, TP.HCM', '09432109876', '29/05/2017', 1, 'KH001',1),
('NV4321', 'Le Hoang Long', '30/06/1996', 'Nam', '32 Ly Tu Trong, phuong Ben Thanh, quan 1, TP.HCM', '09567890123', '15/11/2018', 1, 'KH002',1),
('NV7891', 'Nguyen Van Cuong', '08/01/1991', 'Nam', '21 Nguyen Thi Minh Khai, phuong Ben Nghe, quan 1, TP.HCM', '09871234567', '07/04/2016', 1, 'KH003',1),
('NV3212', 'Nguyen Ha Vy', '21/12/1999', 'Nu', '34 Vo Van Tan, phuong 6, quan 3, TP.HCM', '01284313854', '21/1/2019', 1, 'KH002',1),
('NV4567', 'Tran Van An', '15/05/1995', 'Nam', '78 Le Loi, phuong Ben Thanh, quan 1, TP.HCM', '09876543210', '05/06/2018', 1, 'KH001',1),
('NV7890', 'Pham Thi Minh', '03/09/1990', 'Nu', '123 Nguyen Hue, phuong Nguyen Thai Binh, quan 1, TP.HCM', '09781234567', '12/03/2017', 1, 'KH002',1);

######################### TÀI KHOẢN #######################
CREATE TABLE taikhoan (
	manv varchar(255) primary key, 
    matkhau varchar(30), 
    loai int, 
    trangthai int,
    Foreign Key (manv) REFERENCES nhanvien (manv)
);
drop table taikhoan;
insert into taikhoan (manv, matkhau, loai, trangthai) values 
    ("NV5678", '12345', 1, 1),
    ('NV1234', '12345', 1, 1),
    ('NV2345', '12345', 1, 1),
    ('NV8901', '1', 0, 1);
    
######################### KHÁCH HÀNG #######################
CREATE TABLE khachhang (
	makh varchar(255) primary key, 
    tenkh varchar(255),
    diachi varchar(255), 
    sdt varchar(255), 
    trangthai int
);
drop table khachhang;
INSERT INTO khachhang (makh, tenkh, diachi, sdt, trangthai) VALUES
    ('C001', 'Nguyen Van A', '322/15 An Duong Vuong, Quan 5, TP.HCM', '02385123912',1),
    ('C002', 'Hoang Duoc Su', '213 Tran Binh Trong, Quan 5, TP.HCM', '034812349212',1),
    ('C003', 'Nguyen Thi Anh', '45 Le Loi, Quan 1, TP.HCM', '032178945632',1),
    ('C004', 'Tran Van Minh', '76 Nguyen Hue, Quan 3, TP.HCM', '036985214789',1),
    ('C005', 'Le Thi Mai', '102 Nguyen Trai, Quan 10, TP.HCM', '038752136984',1),
    ('C006', 'Pham Van Tuan', '31 Tran Hung Dao, Quan 1, TP.HCM', '035214789632',1),
    ('C007', 'Nguyen Van Hieu', '17 Hoang Sa, Quan 1, TP.HCM', '039854621378',1),
    ('C008', 'Tran Thi Lan', '92 Vo Van Tan, Quan 3, TP.HCM', '031478965214',1),
    ('C009', 'Le Duc Tho', '55 Ly Thai To, Quan 10, TP.HCM', '032145789632',1),
    ('C010', 'Phan Thi Huong', '29 Nguyen Van Cu, Quan 5, TP.HCM', '036985214785',1),
    ('C011', 'Tran Van Dat', '8 Nguyen Dinh Chieu, Quan 3, TP.HCM', '034512365987',1),
    ('C012', 'Nguyen Van B', '322/15 An Duong Vuong, Quan 5, TP.HCM', '02385123912',1),
    ('C013', 'Hoang Van Su', '213 Tran Binh Trong, Quan 5, TP.HCM', '034812349212',1),
    ('C014', 'Nguyen Van Anh', '45 Le Loi, Quan 1, TP.HCM', '032178945632',1),
    ('C015', 'Tran Van Hoang', '76 Nguyen Hue, Quan 3, TP.HCM', '036985214789',1),
    ('C016', 'Le Van Mai', '102 Nguyen Trai, Quan 10, TP.HCM', '038752136984',1),
    ('C017', 'Pham Thi Tuan', '31 Tran Hung Dao, Quan 1, TP.HCM', '035214789632',1),
    ('C018', 'Nguyen Van Hien', '17 Hoang Sa, Quan 1, TP.HCM', '039854621378',1),
    ('C019', 'Tran Thi Nhung', '92 Vo Van Tan, Quan 3, TP.HCM', '031478965214',1),
    ('C020', 'Le Duc Thang', '55 Ly Thai To, Quan 10, TP.HCM', '032145789632',1);


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

/*
INSERT INTO khachhang (makh, tenkh, diachi, sdt) VALUES
    ('KH001', 'Nguyen Van A', '322/15 An Duong Vuong, Quan 5, TP.HCM', '02385123912'),
    ('KH002', 'Hoang Duoc Su', '213 Tran Binh Trong, Quan 5, TP.HCM', '034812349212'),
    ('KH003', 'Nguyen Thi Anh', '45 Le Loi, Quan 1, TP.HCM', '032178945632'),
    ('KH004', 'Tran Van Minh', '76 Nguyen Hue, Quan 3, TP.HCM', '036985214789'),
    ('KH005', 'Le Thi Mai', '102 Nguyen Trai, Quan 10, TP.HCM', '038752136984'),
    ('KH006', 'Pham Van Tuan', '31 Tran Hung Dao, Quan 1, TP.HCM', '035214789632'),
    ('KH007', 'Nguyen Van Hieu', '17 Hoang Sa, Quan 1, TP.HCM', '039854621378'),
    ('KH008', 'Tran Thi Lan', '92 Vo Van Tan, Quan 3, TP.HCM', '031478965214'),
    ('KH009', 'Le Duc khachhangkhachhangTho', '55 Ly Thai To, Quan 10, TP.HCM', '032145789632'),
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

*/

###################### QUERY ########################
SELECT * FROM nhanvien;
SELECT * FROM nhacungcap;
SELECT * FROM sanpham;
SELECT * FROM phieunhap;
SELECT * FROM ctphieunhap;
SELECT * FROM phieuxuat;
SELECT * FROM ctphieuxuat;
SELECT * FROM taikhoan;
SELECT * FROM khachhang;
SELECT * FROM khohang;
SELECT * FROM ctphieuxuat;
SELECT n.tennv
FROM nhanvien n
JOIN taikhoan t ON n.manv = t.manv
WHERE t.manv = 'NV8901';
SELECT * FROM quanlykhohang.sanpham;
DELETE FROM sanpham WHERE masp = 'x1';
UPDATE phieuxuat SET trangthai = 1 WHERE mapx = '3';
DELETE FROM phieuxuat WHERE manguoitao LIKE 'NV%';
DELETE FROM ctphieuxuat WHERE manguoitao LIKE 'NV%';

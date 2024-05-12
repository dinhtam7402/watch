USE watch;

INSERT INTO thuonghieu (tenthuonghieu, sodienthoai, diachi, email) VALUES
('KOI', '0123456789', 'Địa chỉ KOI', 'info@koi.com'),
('Saga', '0234567890', 'Địa chỉ Saga', 'info@saga.com'),
('Doxa', '0345678901', 'Địa chỉ Doxa', 'info@doxa.com'),
('Casio', '0456789012', 'Địa chỉ Casio', 'info@casio.com'),
('Daniel Wellington', '0567890123', 'Địa chỉ DW', 'info@dw.com'),
('Tissot', '0678901234', 'Địa chỉ Tissot', 'info@tissot.com'),
('Orient', '0789012345', 'Địa chỉ Orient', 'info@orient.com'),
('Citizen', '0890123456', 'Địa chỉ Citizen', 'info@citizen.com'),
('Rado', '0901234567', 'Địa chỉ Rado', 'info@rado.com'),
('Seiko', '0912345678', 'Địa chỉ Seiko', 'info@seiko.com'),
('Longiness', '0923456789', 'Địa chỉ Longiness', 'info@longiness.com'),
('Sokolov', '0934567890', 'Địa chỉ Sokolov', 'info@sokolov.com'),
('G-Shock', '0945678901', 'Địa chỉ G-Shock', 'info@gshock.com'),
('Baby-G', '0956789012', 'Địa chỉ Baby-G', 'info@babyg.com'),
('OP', '0967890123', 'Địa chỉ OP', 'info@op.com'),
('Fossil', '0978901234', 'Địa chỉ Fossil', 'info@fossil.com'),
('Movado', '0989012345', 'Địa chỉ Movado', 'info@movado.com'),
('Frederique Constant', '0990123456', 'Địa chỉ Frederique Constant', 'info@frederiqueconstant.com'),
('Calvin Klein', '0901234567', 'Địa chỉ Calvin Klein', 'info@calvinklein.com'),
('Candino', '0912345678', 'Địa chỉ Candino', 'info@candino.com'),
('SR Watch', '0923456789', 'Địa chỉ SR Watch', 'info@srwatch.com'),
('Certina', '0934567890', 'Địa chỉ Certina', 'info@certina.com');

INSERT INTO SanPham (mathuonghieu, tensanpham, gia, gioitinh, chatlieuday, chatlieumatkinh, pin, maumatso, mauvo, hinhdangmatso, kichthuoc, mucchongnuoc, bosuutap) VALUES
(1, 'Đồng hồ nam KOI', '5000000', 'Nam', 'Dây Da', NULL, 'Pin Quartz', 'Đen', 'Kim Loại', 'Tròn', '38mm', '5 ATM', 'Koi Noble'),
(2, 'Đồng hồ nữ Saga', '3500000', 'Nữ', 'Dây Kim Loại', NULL, NULL, 'Trắng', 'Vàng', 'Vuông', '28mm', 'Đi Tắm', NULL),
(3, 'Đồng hồ nam Doxa', '8000000', 'Nam', 'Dây Kim Loại', 'Kính Sapphire', 'Pin Quartz', 'Đen', 'Kim Loại', 'Tròn', '38mm', '10 ATM', NULL),
(4, 'Đồng hồ nữ Casio', '2500000', 'Nữ', 'Dây Đờ Mi', NULL, NULL, 'Nâu', 'Vàng', 'Tròn', '29mm', NULL, NULL),
(5, 'Đồng hồ đôi Daniel Wellington', '6000000', 'Đôi-Cặp', 'Dây Da', 'Kính Sapphire', 'Pin Quartz', 'Đen', 'Vàng Hồng', 'Tròn', '38mm', '3 ATM', NULL),
(6, 'Đồng hồ nam Tissot', '7000000', 'Nam', 'Dây Da', 'Kính Sapphire', 'Pin Quartz', 'Đính Đá', 'Kim Loại', 'Tròn', '38mm', '10 ATM', NULL),
(7, 'Đồng hồ nữ Orient', '4500000', 'Nữ', 'Dây Kim Loại', NULL, 'Pin Quartz', 'Nâu', 'Kim Loại', 'Tròn', '28mm', '5 ATM', NULL),
(8, 'Đồng hồ nam Citizen', '3000000', 'Nam', 'Dây Da', 'Kính Sapphire', 'Pin Quartz', 'Trắng', 'Vàng Hồng', 'Vuông', '38mm', '3 ATM', NULL),
(9, 'Đồng hồ nữ Rado', '12000000', 'Nữ', 'Dây Kim Loại', 'Kính Sapphire', 'Pin Quartz', 'Đen', 'Kim Loại', 'Tròn', '38mm', '10 ATM', NULL),
(10, 'Đồng hồ nam Seiko', '4000000', 'Nam', 'Dây Đờ Mi', NULL, 'Pin Quartz', 'Nâu', 'Vàng', 'Tròn', '29mm', '5 ATM', NULL),
(11, 'Đồng hồ nữ Longiness', '10000000', 'Nữ', 'Dây Kim Loại', 'Kính Sapphire', 'Pin Quartz', 'Đen', 'Vàng Hồng', 'Tròn', '28mm', '10 ATM', NULL),
(12, 'Đồng hồ nam Sokolov', '6000000', 'Nam', 'Dây Da', NULL, 'Pin Quartz', 'Nâu', 'Kim Loại', 'Tròn', '38mm', '5 ATM', NULL),
(13, 'Đồng hồ nam G-Shock', '3500000', 'Nam', 'Dây Đờ Mi', NULL, 'Pin Quartz', 'Đen', 'Vàng', 'Tròn', '38mm', '5 ATM', NULL),
(14, 'Đồng hồ nữ Baby-G', '2500000', 'Nữ', 'Dây Kim Loại', 'Kính Sapphire', 'Pin Quartz', 'Đính Đá', 'Vàng Hồng', 'Vuông', '28mm', '5 ATM', NULL),
(15, 'Đồng hồ đôi OP', '4500000', 'Đôi-Cặp', 'Dây Đờ Mi', NULL, 'Pin Quartz', 'Nâu', 'Kim Loại', 'Tròn', '29mm', '5 ATM', NULL),
(16, 'Đồng hồ nam Fossil', '3000000', 'Nam', 'Dây Da', 'Kính Sapphire', 'Pin Quartz', 'Đen', 'Vàng', 'Tròn', '38mm', '5 ATM', NULL),
(17, 'Đồng hồ nữ Movado', '9000000', 'Nữ', 'Dây Kim Loại', 'Kính Sapphire', 'Pin Quartz', 'Trắng', 'Vàng Hồng', 'Tròn', '28mm', '10 ATM', NULL),
(18, 'Đồng hồ nam Frederique Constant', '15000000', 'Nam', 'Dây Da', 'Kính Sapphire', 'Pin Quartz', 'Nâu', 'Kim Loại', 'Tròn', '38mm', '3 ATM', NULL),
(19, 'Đồng hồ nữ Calvin Klein', '18000000', 'Nữ', 'Dây Kim Loại', 'Kính Sapphire', 'Pin Quartz', 'Đen', 'Vàng', 'Tròn', '29mm', '10 ATM', NULL),
(20, 'Đồng hồ nam Candino', '8500000', 'Nam', 'Dây Đờ Mi', NULL, 'Pin Quartz', 'Nâu', 'Vàng', 'Tròn', '38mm', '5 ATM', NULL),
(21, 'Đồng hồ nữ SR Watch', '4000000', 'Nữ', 'Dây Kim Loại', 'Kính Sapphire', 'Pin Quartz', 'Đính Đá', 'Vàng Hồng', 'Vuông', '28mm', '5 ATM', NULL),
(22, 'Đồng hồ nam Certina', '7000000', 'Nam', 'Dây Da', 'Kính Sapphire', 'Pin Quartz', 'Nâu', 'Vàng', 'Tròn', '38mm', '10 ATM', NULL),
(1, 'Đồng hồ nữ Movado', '9500000', 'Nữ', 'Dây Da', 'Kính Sapphire', 'Pin Quartz', 'Trắng', 'Kim Loại', 'Tròn', '28mm', '10 ATM', 'Koi Noble'),
(2, 'Đồng hồ nữ Frederique Constant', '14000000', 'Nữ', 'Dây Kim Loại', 'Kính Sapphire', 'Pin Quartz', 'Đen', 'Vàng Hồng', 'Vuông', '29mm', '5 ATM', 'Koi Noble'),
(3, 'Đồng hồ nữ Calvin Klein', '20000000', 'Nữ', 'Dây Đờ Mi', NULL, 'Pin Quartz', 'Nâu', 'Vàng', 'Tròn', '38mm', '3 ATM', 'Koi Noble'),
(4, 'Đồng hồ nữ Candino', '9000000', 'Nữ', 'Dây Da', 'Kính Sapphire', 'Pin Quartz', 'Đính Đá', 'Vàng', 'Vuông', '28mm', '5 ATM', 'Koi Noble'),
(5, 'Đồng hồ nữ SR Watch', '4500000', 'Nữ', 'Dây Kim Loại', 'Kính Sapphire', 'Pin Quartz', 'Trắng', 'Kim Loại', 'Tròn', '38mm', '10 ATM', 'Koi Noble');

INSERT INTO khachhang (hoten, sodienthoai, email, diachi) VALUES
('Nguyễn Văn A', '0123456789', 'nguyenvana@example.com', '123 Đường ABC, Quận 1, Thành phố Hồ Chí Minh'),
('Trần Thị B', '0987654321', 'tranthib@example.com', '456 Đường XYZ, Quận 2, Thành phố Hồ Chí Minh'),
('Phạm Văn C', '0369852147', 'phamvanc@example.com', '789 Đường DEF, Quận 3, Thành phố Hồ Chí Minh'),
('Lê Thị D', '0321456987', 'lethid@example.com', '987 Đường GHI, Quận 4, Thành phố Hồ Chí Minh'),
('Hoàng Văn E', '0789562314', 'hoangvane@example.com', '456 Đường JKL, Quận 5, Thành phố Hồ Chí Minh'),
('Trần Văn F', '0362145789', 'tranvanf@example.com', '321 Đường MNO, Quận 6, Thành phố Hồ Chí Minh'),
('Nguyễn Thị G', '0912345678', 'nguyenthig@example.com', '741 Đường PQR, Quận 7, Thành phố Hồ Chí Minh'),
('Đinh Văn H', '0587469213', 'dinhvanh@example.com', '852 Đường STU, Quận 8, Thành phố Hồ Chí Minh'),
('Lê Văn I', '0932145678', 'levani@example.com', '963 Đường VWX, Quận 9, Thành phố Hồ Chí Minh'),
('Trần Thị K', '0975312468', 'tranthik@example.com', '159 Đường YZA, Quận 10, Thành phố Hồ Chí Minh'),
('Phạm Văn L', '0369874123', 'phamvanl@example.com', '357 Đường BCD, Quận 11, Thành phố Hồ Chí Minh'),
('Nguyễn Văn M', '0958472136', 'nguyenvanm@example.com', '258 Đường EFG, Quận 12, Thành phố Hồ Chí Minh'),
('Lê Thị N', '0321478963', 'lethin@example.com', '456 Đường HIJ, Quận Bình Thạnh, Thành phố Hồ Chí Minh'),
('Nguyễn Văn O', '0369852147', 'nguyenvano@example.com', '789 Đường KLM, Quận Gò Vấp, Thành phố Hồ Chí Minh'),
('Trần Thị P', '0321456987', 'tranthip@example.com', '987 Đường NOP, Quận Phú Nhuận, Thành phố Hồ Chí Minh');

INSERT INTO HoaDon (makhachhang, ngaydat, diachigiaohang, tongtien, phuongthucthanhtoan, trangthai) VALUES
(1, '2024-05-01', '123 Đường ABC, Quận 1, Thành phố Hồ Chí Minh', '9500000', 'Thanh toán khi nhận hàng', 'Đã giao hàng'),
(2, '2024-05-02', '456 Đường XYZ, Quận 2, Thành phố Hồ Chí Minh', '14000000', 'Thanh toán qua thẻ tín dụng', 'Đã giao hàng'),
(3, '2024-05-03', '789 Đường DEF, Quận 3, Thành phố Hồ Chí Minh', '20000000', 'Chuyển khoản ngân hàng', 'Chờ xử lý'),
(4, '2024-05-04', '987 Đường GHI, Quận 4, Thành phố Hồ Chí Minh', '9000000', 'Thanh toán khi nhận hàng', 'Đã giao hàng'),
(5, '2024-05-05', '456 Đường JKL, Quận 5, Thành phố Hồ Chí Minh', '4500000', 'Thanh toán khi nhận hàng', 'Đã giao hàng'),
(6, '2024-05-06', '321 Đường MNO, Quận 6, Thành phố Hồ Chí Minh', '7500000', 'Chuyển khoản ngân hàng', 'Chờ xử lý'),
(7, '2024-05-07', '741 Đường PQR, Quận 7, Thành phố Hồ Chí Minh', '4000000', 'Thanh toán qua thẻ tín dụng', 'Đã giao hàng'),
(8, '2024-05-08', '852 Đường STU, Quận 8, Thành phố Hồ Chí Minh', '2800000', 'Thanh toán khi nhận hàng', 'Đã giao hàng'),
(9, '2024-05-09', '963 Đường VWX, Quận 9, Thành phố Hồ Chí Minh', '4800000', 'Chuyển khoản ngân hàng', 'Chờ xử lý'),
(10, '2024-05-10', '159 Đường YZA, Quận 10, Thành phố Hồ Chí Minh', '3500000', 'Thanh toán khi nhận hàng', 'Đã giao hàng');

INSERT INTO ChiTietHoaDon (mahoadon, masanpham, soluong, dongia, thanhtien) VALUES
(1, 1, 1, '9500000', '9500000'),
(2, 2, 1, '14000000', '14000000'),
(3, 3, 1, '20000000', '20000000'),
(4, 4, 1, '9000000', '9000000'),
(5, 5, 1, '4500000', '4500000'),
(6, 6, 1, '7500000', '7500000'),
(7, 7, 1, '4000000', '4000000'),
(8, 8, 1, '2800000', '2800000'),
(9, 9, 1, '4800000', '4800000'),
(10, 10, 1, '3500000', '3500000'),
(1, 11, 1, '3000000', '3000000'),
(2, 12, 1, '8500000', '8500000'),
(3, 13, 1, '2000000', '2000000'),
(4, 14, 1, '5500000', '5500000'),
(5, 15, 1, '4000000', '4000000'),
(6, 16, 1, '2800000', '2800000'),
(7, 17, 1, '10500000', '10500000'),
(8, 18, 1, '3200000', '3200000'),
(9, 19, 1, '9500000', '9500000'),
(10, 20, 1, '5000000', '5000000');
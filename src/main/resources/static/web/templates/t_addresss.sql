CREATE TABLE t_address (
		aid INT AUTO_INCREMENT COMMENT '收件地址的id',
		uid INT COMMENT '用戶id',
		name VARCHAR(50) COMMENT '收件人姓名',
		city_name CHAR(6) COMMENT '城市',
		zip CHAR(6) COMMENT '郵政區號',
		address VARCHAR(100) COMMENT '用戶地址',
		phone VARCHAR(20) COMMENT '手機號碼',
		is_default INT COMMENT '是否默认：0-非預設，1-預設',
		created_user VARCHAR(20) COMMENT '創建人',
		created_time DATETIME COMMENT '創建時間',
		modified_user VARCHAR(20) COMMENT '最後修改人',
		modified_time DATETIME COMMENT '最後修改時間',
		PRIMARY KEY (aid)
	) DEFAULT CHARSET=UTF8;
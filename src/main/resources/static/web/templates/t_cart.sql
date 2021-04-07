CREATE TABLE t_cart (
		cid INT AUTO_INCREMENT COMMENT '購物車資料id',
		uid INT NOT NULL COMMENT '用户id',
		gid BIGINT(20) NOT NULL COMMENT '商品id',
		num INT NOT NULL COMMENT '商品數量',
		created_user VARCHAR(20) COMMENT '創建人',
		created_time DATETIME COMMENT '創建時間',
		modified_user VARCHAR(20) COMMENT '最後修改人',
		modified_time DATETIME COMMENT '最後修改時間',
		PRIMARY KEY (cid)
	) DEFAULT CHARSET=UTF8;
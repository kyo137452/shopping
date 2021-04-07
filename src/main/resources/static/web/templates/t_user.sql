CREATE TABLE t_user (
		uid INT AUTO_INCREMENT COMMENT '用戶id',
		username VARCHAR(20) UNIQUE NOT NULL COMMENT '用戶名稱',
                nickname VARCHAR(20) NOT NULL COMMENT '暱稱',
		password CHAR(32) NOT NULL COMMENT '密碼',
		salt CHAR(36) COMMENT '鹽值',
		phone VARCHAR(50) NOT NULL COMMENT '電話號碼',
		email VARCHAR(50) NOT NULL COMMENT '電子信箱',
                avatar VARCHAR(50) COMMENT '大頭貼',
		is_delete INT COMMENT '是否標記為刪除：0-未刪除，1-已刪除',
		created_user VARCHAR(20) COMMENT '創建人',
		created_time DATETIME COMMENT '創建時間',
		modified_user VARCHAR(20) COMMENT '最後修改人',
		modified_time DATETIME COMMENT '最後修改時間',
		PRIMARY KEY (uid)
	) DEFAULT CHARSET=UTF8;
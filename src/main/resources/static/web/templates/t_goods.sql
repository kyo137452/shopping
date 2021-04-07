CREATE TABLE `t_goods` (
  `id` bigint(20) NOT NULL COMMENT '商品id',
  `category_id` bigint(20) DEFAULT NULL COMMENT '分類id',
  `item_type` varchar(100) DEFAULT NULL COMMENT '商品系列',
  `title` varchar(100) DEFAULT NULL COMMENT '商品標題',
  `sell_point` varchar(150) DEFAULT NULL COMMENT '商品賣點',
  `price` bigint(20) DEFAULT NULL COMMENT '商品單價',
  `num` int(10) DEFAULT NULL COMMENT '庫存數量',
  `image` varchar(500) DEFAULT NULL COMMENT '圖片路徑',
  `status` int(1) DEFAULT '1' COMMENT '商品狀態  1：上下   2：下架   3：刪除',
  `priority` int(10) DEFAULT NULL COMMENT '顯示優先級',
  `created_time` datetime DEFAULT NULL COMMENT '創建時間',
  `modified_time` datetime DEFAULT NULL COMMENT '最後修改時間',
  `created_user` varchar(50) DEFAULT NULL COMMENT '創建人',
  `modified_user` varchar(50) DEFAULT NULL COMMENT '最後修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `t_goods`(`id`,`category_id`,`item_type`,`title`,`sell_point`,`price`,`num`,`image`,`status`,`priority`,`created_time`,`modified_time`,`created_user`,`modified_user`) values ('10000000',300,'3C產品','羅技G102 炫彩遊戲滑鼠-白','炫彩遊戲滑鼠-白',599,999,'/images/portal/mouse01/',1,62,'2021-03-07 15:08:55','2021-3-7 15:08:55','admin','admin');
insert into `t_goods`(`id`,`category_id`,`item_type`,`title`,`sell_point`,`price`,`num`,`image`,`status`,`priority`,`created_time`,`modified_time`,`created_user`,`modified_user`) values ('10000001',300,'3C產品','CPU Intel Core I3-10100 中央處理器','處理器',3870,999,'/images/portal/cpu02/',1,62,'2021-03-07 15:08:55','2021-3-7 15:08:55','admin','admin');
insert into `t_goods`(`id`,`category_id`,`item_type`,`title`,`sell_point`,`price`,`num`,`image`,`status`,`priority`,`created_time`,`modified_time`,`created_user`,`modified_user`) values ('10000002',300,'3C產品','威剛 ADATA 16G隨身碟 UV240','隨身碟',199,999,'/images/portal/usb/',1,22,'2021-03-07 15:08:55','2021-3-7 15:08:55','admin','admin');
insert into `t_goods`(`id`,`category_id`,`item_type`,`title`,`sell_point`,`price`,`num`,`image`,`status`,`priority`,`created_time`,`modified_time`,`created_user`,`modified_user`) values ('10000003',300,'3C產品','海盜船RGB DDR4 3600 8G*4','桌上型記憶體',9888,999,'/images/portal/ddr02/',1,42,'2021-03-07 15:08:55','2021-3-7 15:08:55','admin','admin');
insert into `t_goods`(`id`,`category_id`,`item_type`,`title`,`sell_point`,`price`,`num`,`image`,`status`,`priority`,`created_time`,`modified_time`,`created_user`,`modified_user`) values ('10000004',300,'3C產品','技嘉GIGABYTE NVIDIA RTX 3090顯示卡','顯示卡',46900,999,'/images/portal/vga04/',1,52,'2021-03-07 15:08:55','2021-3-7 15:08:55','admin','admin');
insert into `t_goods`(`id`,`category_id`,`item_type`,`title`,`sell_point`,`price`,`num`,`image`,`status`,`priority`,`created_time`,`modified_time`,`created_user`,`modified_user`) values ('10000005',300,'3C產品','(君主)內建炫彩固光風扇前3後1 鋼化玻璃','電腦機殼',1290,999,'/images/portal/boxx1/',1,32,'2021-03-07 15:08:55','2021-3-7 15:08:55','admin','admin');
insert into `t_goods`(`id`,`category_id`,`item_type`,`title`,`sell_point`,`price`,`num`,`image`,`status`,`priority`,`created_time`,`modified_time`,`created_user`,`modified_user`) values ('10000006',300,'3C產品','海韻750w 電源供應器80 PLUS 12年保固','電源供應器',6650,999,'/images/portal/power02/',1,28,'2021-03-07 15:08:55','2021-3-7 15:08:55','admin','admin');
insert into `t_goods`(`id`,`category_id`,`item_type`,`title`,`sell_point`,`price`,`num`,`image`,`status`,`priority`,`created_time`,`modified_time`,`created_user`,`modified_user`) values ('10000007',300,'3C產品','華碩ROG Strix Flare RGB 機械式電競鍵盤','機械式電競鍵盤 - 青軸',3990,999,'/images/portal/key1/',1,200,'2021-03-07 15:08:55','2021-3-7 15:08:55','admin','admin');

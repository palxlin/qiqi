use csi;

/*当前游戏简表*/
CREATE TABLE `tbl_current_game` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `game_no` int(10) NOT NULL,
  `game_type` varchar(10) NOT NULL default '0',
  `create_user` varchar(45) DEFAULT NULL,
  `nums` int(10) DEFAULT 0,
  `pos_of_crime_user` int(10),
  `pos_of_crime_ass_user` int(10),
  `status` int(10) DEFAULT 0,
  `remark` varchar(100) DEFAULT NULL,
  `deleted` char(1) default '0',
  `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '当前游戏简表';

/*当前游戏用户表*/
CREATE TABLE `tbl_current_player` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_no` varchar(45) NOT NULL COMMENT '用户微信号' ,
  `game_no` varchar(45) DEFAULT NULL COMMENT '游戏房间号,同tbl_game_current.game_no' ,
  `game_role` varchar(45) DEFAULT '' COMMENT '游戏角色',
  `game_pos` int(10) COMMENT '当前用户的房间位置',
  `status` int(10) DEFAULT 0 COMMENT '当前用户的游戏状态',
  `crime_item_1` varchar(100) COMMENT '作案工具1',
  `crime_item_2` varchar(100) COMMENT '作案工具2',
  `crime_item_3` varchar(100) COMMENT '作案工具3',
  `crime_item_4` varchar(100) COMMENT '作案工具4',
  `crime_clue_1` varchar(100) COMMENT '作案线索1',
  `crime_clue_2` varchar(100) COMMENT '作案线索2',
  `crime_clue_3` varchar(100) COMMENT '作案线索3',
  `crime_clue_4` varchar(100) COMMENT '作案线索4',
  `remark` varchar(100) DEFAULT NULL,
  `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '当前游戏用户表';

/*当前游戏细节*/
CREATE TABLE `tbl_current_game_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `game_no` int(10) NOT NULL COMMENT '游戏房间号',
  `crime_item` varchar(45) DEFAULT NULL COMMENT '作案工具名称',
  `crime_clue` varchar(45) DEFAULT NULL COMMENT '作案线索名称',
  `cause_of_death` varchar(100) DEFAULT NULL COMMENT '死亡原因',
  `location_of_crime` varchar(100) DEFAULT NULL COMMENT '案发地点',
  `clue_1` varchar(100) DEFAULT NULL COMMENT '蓝牌1',
  `clue_2` varchar(100) DEFAULT NULL COMMENT '蓝牌2',
  `clue_3` varchar(100) DEFAULT NULL COMMENT '蓝牌3',
  `clue_4` varchar(100) DEFAULT NULL COMMENT '蓝牌4',
  `clue_to_replace_1_content` varchar(100) DEFAULT NULL COMMENT '抽取的可替换的蓝牌1',
  `clue_to_replace_2_content` varchar(100) DEFAULT NULL COMMENT '抽取的可替换的蓝牌2',
  `witness_chosen_1` varchar(45) DEFAULT NULL COMMENT '目击者选择的线索1',
  `witness_chosen_2` varchar(45) DEFAULT NULL COMMENT '目击者选择的线索2',
  `witness_chosen_3` varchar(45) DEFAULT NULL COMMENT '目击者选择的线索3',
  `witness_chosen_4` varchar(45) DEFAULT NULL COMMENT '目击者选择的线索4',
  `witness_chosen_cause_of_death` varchar(45) DEFAULT NULL COMMENT '目击者选择的死亡原因',
  `witness_chosen_location_of_crime` varchar(45) DEFAULT NULL COMMENT '目击者选择的案发地点',
  `withnes_chosen_weight` varchar(10) DEFAULT NULL COMMENT '线索权重，6位数字对应6张牌上线索的权重，1-6从重到轻',
  `status` int(10) DEFAULT 0,
  `remark` varchar(200) ,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*作案工具线索牌表*/
CREATE TABLE `tbl_card_crime_item_clue` (
  `id` int(11) NOT NULL AUTO_INCREMENT ,
  `item_no` int(10) DEFAULT NULL COMMENT '编号' ,
  `item_type` char(1) DEFAULT NULL COMMENT '1.作案工具 2.作案线索' ,
  `item_name` varchar(45) DEFAULT NULL COMMENT '名称',
  `pic` int(10) DEFAULT 0 COMMENT '图片位置',
  `status` int(10)  ,
  `remark` varchar(200) ,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_card_crime_scene` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_no` int(10) DEFAULT NULL COMMENT '编号',
  `item_type` char(1) DEFAULT NULL COMMENT '1.作案工具 2.作案线索',
  `content` varchar(200) DEFAULT NULL COMMENT '内容',
  `pic` varchar(100) DEFAULT '0' COMMENT '图片位置',
  `status` int(10) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

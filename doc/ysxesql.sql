

/*Table structure for table `t_admin_perm` */

DROP TABLE IF EXISTS `t_admin_perm`;

CREATE TABLE `t_admin_perm` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `admin_id` int(9) DEFAULT NULL COMMENT '管理员编号',
  `menu_id` int(9) DEFAULT NULL COMMENT '菜单编号',
  `create_date` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `t_admin_perm` */

insert  into `t_admin_perm`(`id`,`admin_id`,`menu_id`,`create_date`) values (1,1,1,NULL),(2,1,2,NULL),(3,1,3,NULL),(4,1,4,NULL),(8,1,6,NULL),(9,1,7,NULL),(12,1,8,NULL),(14,3,2,'2016-03-22 15:09:14'),(15,3,7,'2016-03-22 15:09:14'),(16,9,1,NULL),(17,9,2,NULL),(18,9,3,NULL),(19,9,4,NULL),(20,9,6,NULL),(21,9,7,NULL),(22,9,8,NULL),(23,4,1,'2016-03-29 17:13:53'),(24,4,6,'2016-03-29 17:13:53'),(25,4,8,'2016-03-29 17:13:53'),(26,4,2,'2016-03-29 17:13:53'),(27,4,7,'2016-03-29 17:13:53'),(28,1,9,NULL),(29,1,10,NULL),(30,1,11,NULL),(31,1,12,NULL);

/*Table structure for table `t_sys_admin` */

DROP TABLE IF EXISTS `t_sys_admin`;

CREATE TABLE `t_sys_admin` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `mobile_phone` varchar(32) DEFAULT NULL COMMENT '联系方式',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `rel_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `status` varchar(8) DEFAULT 'open' COMMENT '状态open:开启，close:关闭',
  `create_date` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_admin` */

insert  into `t_sys_admin`(`id`,`user_name`,`password`,`mobile_phone`,`email`,`rel_name`,`status`,`create_date`,`update_date`) values (1,'admin','e10adc3949ba59abbe56e057f20f883e','17093460525','284280658@qq.com','超级管理员oy','open',NULL,'2016-04-05 15:37:46'),(9,'qinrong','e10adc3949ba59abbe56e057f20f883e',NULL,NULL,'覃荣','open',NULL,NULL);

/*Table structure for table `t_sys_menu` */

DROP TABLE IF EXISTS `t_sys_menu`;

CREATE TABLE `t_sys_menu` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fid` int(9) DEFAULT NULL COMMENT '父级菜单',
  `name` varchar(32) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(64) DEFAULT NULL COMMENT '地址',
  `icon_class` varchar(32) DEFAULT NULL COMMENT '菜单图标',
  `sort` int(4) DEFAULT NULL COMMENT '排序',
  `isdel` varchar(2) DEFAULT 'n' COMMENT '是否删除y：已删除/n：未删除',
  `create_date` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_menu` */

insert  into `t_sys_menu`(`id`,`fid`,`name`,`url`,`icon_class`,`sort`,`isdel`,`create_date`,`update_date`) values (1,NULL,'消息回复管理',NULL,'icon-envelope-alt',2,'n',NULL,NULL),(2,NULL,'自定义菜单管理',NULL,'icon-sitemap',3,'n',NULL,NULL),(3,NULL,'后台管理',NULL,'icon-cog',0,'n',NULL,NULL),(4,3,'管理员设置','system/admin/init','icon-user',0,'n',NULL,NULL),(6,1,'设置自动回复','system/message/init','icon-comment-alt',0,'n',NULL,NULL),(7,2,'设置自定义菜单','system/wechatmenu/init','icon-sitemap',0,'n',NULL,NULL),(9,NULL,'资料审核',NULL,'icon-user',4,'n',NULL,NULL),(10,9,'资料审核管理','system/data/shInit','icon-user',0,'n',NULL,NULL),(11,9,'已审核资料查看','system/data/yshInit','icon-user',1,'n',NULL,NULL),(12,9,'资料查看','system/data/syInit','icon-user',2,'n',NULL,NULL);

/*Table structure for table `t_wechat_data_audit` */

DROP TABLE IF EXISTS `t_wechat_data_audit`;

CREATE TABLE `t_wechat_data_audit` (
  `id` bigint(9) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `cus_type` varchar(32) DEFAULT NULL COMMENT '客户类型',
  `rel_name` varchar(32) DEFAULT NULL COMMENT '客户姓名',
  `mobile_phone` varchar(16) DEFAULT NULL COMMENT '手机号',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(300) DEFAULT NULL COMMENT '联系地址',
  `loan_money` varchar(16) DEFAULT NULL COMMENT '贷款金额（单位：万）',
  `loan_term` varchar(8) DEFAULT NULL COMMENT '贷款期限（单位：月）',
  `loan_purpose` varchar(300) DEFAULT NULL COMMENT '借款用途',
  `repay_source` varchar(300) DEFAULT NULL COMMENT '还款来源',
  `is_mortgage` varchar(4) DEFAULT NULL COMMENT '有无抵押',
  `mortgage_type` varchar(32) DEFAULT NULL COMMENT '抵押类型',
  `state` varchar(16) DEFAULT NULL COMMENT '状态（audit:审核中,close:审核不通过,open：审核通过）',
  `audit_people` varchar(32) DEFAULT NULL COMMENT '审核人员',
  `remark` varchar(300) DEFAULT NULL COMMENT '备注',
  `create_date` timestamp NULL DEFAULT NULL COMMENT '申请时间',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '审批时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Data for the table `t_wechat_data_audit` */

insert  into `t_wechat_data_audit`(`id`,`cus_type`,`rel_name`,`mobile_phone`,`email`,`address`,`loan_money`,`loan_term`,`loan_purpose`,`repay_source`,`is_mortgage`,`mortgage_type`,`state`,`audit_people`,`remark`,`create_date`,`update_date`) values (32,NULL,'呵呵','12312312312',NULL,'sadasdsadsa','222','1','阿达','阿萨德啊,阿萨德','有','股权','open','超级管理员oy','asdsadasdasdasd','2016-06-01 14:09:19','2016-06-01 15:38:29'),(33,NULL,'吕','1111111111','284280658@qq.com','龙华','500','2','5555555匿名','啦咯啦咯啦咯啦咯啦咯啦','有','房产','audit',NULL,NULL,'2016-06-01 15:54:36',NULL),(34,'个人','啦咯啦咯啦咯','2222222','啦咯啦咯啦咯啦咯啦咯啦','擦的','555','55','Hahahj','Shjsjsjsj','有','房产','audit',NULL,NULL,'2016-06-01 15:57:31',NULL);

/*Table structure for table `t_wechat_menu` */

DROP TABLE IF EXISTS `t_wechat_menu`;

CREATE TABLE `t_wechat_menu` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(16) DEFAULT NULL COMMENT '菜单标题，不超过16个字节',
  `type` varchar(32) DEFAULT NULL COMMENT '菜单的响应动作类型',
  `url` varchar(256) DEFAULT NULL COMMENT '网页链接，用户点击菜单可打开链接，不超过128字节',
  `keyword` varchar(64) DEFAULT NULL COMMENT '菜单KEY值，用于消息接口推送，不超过64字节',
  `fid` int(9) DEFAULT NULL COMMENT '父级菜单ID',
  `sort` int(9) DEFAULT NULL COMMENT '排序',
  `isdel` varchar(2) DEFAULT 'n' COMMENT '是否删除(y/n)',
  `create_date` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `t_wechat_menu` */

insert  into `t_wechat_menu`(`id`,`name`,`type`,`url`,`keyword`,`fid`,`sort`,`isdel`,`create_date`,`update_date`) values (14,'贷款申请','view','http://p2pwxtest.eptok.com/ysxe_wechat/wximgsc',NULL,0,2,'n','2016-05-04 14:04:23','2016-06-01 09:18:06'),(15,'公司简介','f',NULL,NULL,0,0,'n','2016-06-01 09:11:36',NULL),(16,'产品类型','f',NULL,NULL,0,1,'n','2016-06-01 09:11:51','2016-06-01 09:16:41'),(17,'基本情况','click',NULL,'jbqk',15,0,'n','2016-06-01 09:12:20','2016-06-01 09:15:32'),(18,'经营情况','click',NULL,'jyqk',15,1,'n','2016-06-01 09:13:49','2016-06-01 09:15:35'),(19,'风控体系','click',NULL,'fktx',15,2,'n','2016-06-01 09:15:59',NULL),(20,'发展前景','click',NULL,'fzqj',15,3,'n','2016-06-01 09:16:19','2016-06-01 09:16:24'),(21,'微利贷','click',NULL,'wld',16,0,'n','2016-06-01 09:16:56',NULL),(22,'循环贷','click',NULL,'xhd',16,1,'n','2016-06-01 09:17:13',NULL),(23,'银联贷','click',NULL,'yld',16,2,'n','2016-06-01 09:17:32',NULL),(24,'租金贷','click',NULL,'zjd',16,3,'n','2016-06-01 09:17:49',NULL);

/*Table structure for table `t_wechat_message` */

DROP TABLE IF EXISTS `t_wechat_message`;

CREATE TABLE `t_wechat_message` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '留言编号',
  `text` varchar(512) DEFAULT NULL COMMENT '留言内容',
  `open_id` varchar(64) DEFAULT NULL COMMENT '留言用户微信号',
  `type` varchar(64) DEFAULT NULL COMMENT '留言类型',
  `status` varchar(16) DEFAULT NULL COMMENT '状态(read:已读，unread：未读，reply：已回复)',
  `reply_text` varchar(512) DEFAULT NULL COMMENT '客服回复内容',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_wechat_message` */

/*Table structure for table `t_wechat_reply` */

DROP TABLE IF EXISTS `t_wechat_reply`;

CREATE TABLE `t_wechat_reply` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `keyword` varchar(64) DEFAULT NULL COMMENT '关键字/词',
  `key_type` varchar(8) DEFAULT 'accurate' COMMENT '关键字/词索引方式（accurate:精确，vague:模糊）',
  `reply_type` varchar(8) DEFAULT NULL COMMENT '回复类型（text:文本，news:图文）',
  `reply_text` varchar(1024) DEFAULT NULL COMMENT '回复内容',
  `news_img_link` varchar(256) DEFAULT NULL COMMENT '图片地址（当reply_type=news时可用）',
  `news_title` varchar(64) DEFAULT NULL COMMENT '图文消息标题（当reply_type=news时可用）',
  `news_link` varchar(256) DEFAULT NULL COMMENT '图文消息跳转地址（当reply_type=news时可用）',
  `status` varchar(8) DEFAULT 'open' COMMENT '状态（open:启用，close:关闭）',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `create_date` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_wechat_reply` */

insert  into `t_wechat_reply`(`id`,`keyword`,`key_type`,`reply_type`,`reply_text`,`news_img_link`,`news_title`,`news_link`,`status`,`remark`,`create_date`,`update_date`) values (1,'jbqk','accurate','text','深圳市银盛小额贷款有限公司于2007年4月24日在中国人民银行深圳市中心支行备案，于2007年7月19日在深圳市工商行政管理局登记注册成立了专营小额贷款业务的有限公司，并领取编号为：440301103156612的企业法人营业执照。公司于2010年10月15日整改合格获得深圳市金融办正式授牌开展小额贷款业务。公司现注册资本为人民币10000万元(实收资本)，公司法定代表人为林重成先生；公司经营范围为专营小额贷款业务(不吸收公众存款)。公司现有股东为：银盛电子支付科技有限公司、深圳市海盟投资有限公司、深圳市银盛融资担保有限公司和深圳市新导信息技术咨询有限公司，他们的股权所占比例分别为65%、12.5%、12.5%和10%。公司注册地址为深圳市龙华新区民治街道新区大道997号远景家园六楼601。\\\\n深圳市银盛小额贷款有限公司主要开展对具有成长性的中小微型企业和小工商业主发放小额贷款业务，特别为符合国家产业政策的创业型、科技型、知识型、环保型、特色型的中小微型企业、小工商业主及个人工商从业员提供融资咨询服务，在对客户的信誉、品质、资产等建立信任关系的基础上提供短期小额贷款。通过运用灵活的短期借款期限和利率的调节，解决了个体和私营小企业主在实际经营中对于短期资金的急需和要求，起到了促进资金融通和商品流通的作用，在银行和财政基金力所不及的领域和范围内发挥了拾遗补缺、接长补短的效用，为上述客户群体提供解决短期资金需求及提供简易快捷的融资渠道。',NULL,NULL,NULL,'open',NULL,'2016-06-01 09:13:14','2016-06-01 09:18:25'),(2,'jyqk','accurate','text','公司业务发展以“诚信、专业、创新、共赢”为经营理念，为中小微企业提供多样化的产品、订制化的服务、标准化的流程以及差别化的定价，力求为客户提供进入服务整体解决方案，最终形成以短期小额经营性贷款业务稳定收益为基本利润来源，以消费贷款和个人创业贷款业务为补充盈利点的模式。\\\\n经过近年来的发展，公司业务取得了较快的发展，业务模式逐渐走向规范。2015年全年公司共发放贷款 209 笔，累计发放金额91,246万元人民币。其中，面对中小微企业发放贷款共52笔，占比为27 %，计21,340万元，面对个人及个体工商户发放的贷款为157笔，占比为73%，计69,906万元。',NULL,NULL,NULL,'open',NULL,'2016-06-01 09:18:54',NULL),(3,'fktx','accurate','text','公司已经建立健全了以股东大会为最高权利机构，董事会为公司决策机构，管理层为执行机构、监事会为监督机构的完善的法人治理结构，各机构根据章程赋予的职责行使各自的权利、履行各自的义务。同时，公司在董事会的领导下开展各项工作，制定了较为完善的各项管理制度、风控制度以及业务操作流程。完善的风控体系保证了公司业务的顺利开展，促进了公司的健康、有序、持续的发展。',NULL,NULL,NULL,'open',NULL,'2016-06-01 09:19:09',NULL),(4,'fzqj','accurate','text','深圳市银盛小额贷款有限公司的使命是立足小额贷款业务，服务中小企业及国民，谋求员工、股东、客户、社会的协同发展；提供“一体化融资服务提供商”的专业服务，打造中国商业小额贷款一流品牌，成为具有可持续发展能力和国际化管理水准的金融机构。战略目标在目前注册资本人民币1亿元的基础上，至2020年，力争将公司发展成为拥有5亿元总资产、30亿元年贷款规模的中国最大规模的小额贷款机构；到2025年，进一步将公司发展成为拥有总资产超10亿元、年贷款规模达50亿元的大型小额贷款机构。信用昭著达四海，融资有道惠八方，银盛将继续秉承\"诚信、高效、严谨\"的企业精神，强化经营管理，提升公司的核心竞争力，营造中小、微型企业、金融服务型公司和个人之间的多赢格局，推动社会信用体系的完善和地方经济的发展，通过“银盛”品牌价值的不断增值，关爱社会，贡献社会，为将银盛小额贷款建成深圳乃至珠三角地区一流的小额贷款公司而不懈努力！',NULL,NULL,NULL,'open',NULL,'2016-06-01 09:19:26',NULL),(5,'wld','accurate','news','微利贷简介\\\\n1、额度：50万以上500万以下，封顶500万\\\\n2、贷款期限： 一年以内。\\\\n3、还款方式：根据实际客户情况协商。\\\\n4、不足额抵押贷款；解决短、频、快、急、难问题。\\\\n5、可接受的抵质押物：\\\\n\\\\t\\\\t不动产：住宅、别墅、商铺、写字楼、工业厂房、土地等\\\\n\\\\t\\\\t动产：机器设备、交通工具、股票、债券、股权、应收账款、银行汇票等\\\\n\\\\n优势说明：\\\\n1、自有资金放款速度快。\\\\n2、我司的微利贷产品与民间借贷相比，费用低。\\\\n3、还款方式灵活。可根据客户的经营收入及回款情况而定\\\\n4、无需足额抵押物',NULL,'微利贷',NULL,'open',NULL,'2016-06-01 09:21:28','2016-06-01 09:25:41'),(6,'xhd','accurate','news','我司一次性授予企业客户一定期限内一定金额的贷款额度，客户可根据生产经营需要，在核定的最高额度内循环使用的贷款品种。\\\\n\\\\n客户基本要求\\\\n1、具备企业法人资格，具备一定生产规模、连续从事生产经营2年以上，信用记录良好、行业发展前景较好的成长型企业；\\\\n2、生产经营稳定，具备按时偿还贷款本息的能力；\\\\n3、能够提供我司认可的合法、有效担保措施。\\\\n\\\\n产品特点\\\\n1、贷款额度：一次性授予贷款额度，实行总额控制；一般情况下总额度不超过人民币500万元；\\\\n2、授信额度期限：授信额度有效期一般在1年以内；\\\\n3、担保措施：我司认可的合法、有效的担保措施。\\\\n\\\\n业务申办流程\\\\n1、客户申请贷款；\\\\n2、我司进行贷前调查，提出授信方案；\\\\n3、授信审批，与客户签约；\\\\n4、落实担保措施；\\\\n5、客户申请使用贷款',NULL,'循环贷',NULL,'open',NULL,'2016-06-01 09:23:29','2016-06-01 09:28:34'),(7,'yld','accurate','news','我司联手银行共同支持客户发展：\\\\n1、客户已向银行申请贷款，在获得银行贷款前，我司给予客户一定的短期资金周转；\\\\n2、客户已获银行贷款审批，我司给予客户一定资金的短期资金过桥；\\\\n3、银行已给客户发放贷款资金，客户仍有资金需求的，我司给予客户一定额度的补充贷款，以满足客户生产、经营的资金总量需求。\\\\n\\\\n客户基本要求\\\\n1、生产规模较大，信用记录良好的成长型企业；\\\\n2、生产经营稳定，具备按时偿还贷款本息的能力；\\\\n3、已获得银行授信。\\\\n\\\\n产品特点\\\\n1、贷款额度：根据实际情况审批，一般不超过人民币500万元；\\\\n2、贷款期限：根据银行贷款期限进行审批，一般情况下不超过1年；\\\\n\\\\n业务申办流程\\\\n1、客户向我司申请贷款，并提供银行授信证明材料；\\\\n2、我司进行贷前调查，提出贷款方案；\\\\n3、贷款审批，与客户签署保证合同，贷款合同；\\\\n4、发放贷款。',NULL,'银联贷',NULL,'open',NULL,'2016-06-01 09:29:50',NULL),(8,'zjd','accurate','news','租金贷业务是指在深圳地区拥有使用权，收益权清晰的经营场所，并且有稳定的长期租金合约的客户，我司可以为其量身定做，一次性给予其一定的资金来满足生产经营的需求，客户可以将租金收入作为还款来源质押给我司。 \\\\n\\\\n客户基本要求\\\\n1、在深圳地区具有产权、使用权、收益权清晰的经营场所；\\\\n2、生产经营稳定，具备按时偿还贷款本息的能力；\\\\n3、无不良信用记录。\\\\n\\\\n产品特点\\\\n1、贷款额度：根据客户实际资金需求情况核定额度，一般不超过人民币250万元；\\\\n2、贷款期限：贷款期限根据客户实际情况灵活设定，一般不超过1年，能够满足借款人短期和中期流动资金需求；\\\\n\\\\n业务申办流程\\\\n1、客户提出申请，并提供贷款所需资料；\\\\n2、我司进行贷前调查，提出贷款方案；\\\\n3、贷款审批；\\\\n4、与客户签约，落实租金质押手续，发放贷款。',NULL,'租金贷',NULL,'open',NULL,'2016-06-01 09:31:24',NULL);

/*Table structure for table `t_wechat_scan` */

DROP TABLE IF EXISTS `t_wechat_scan`;

CREATE TABLE `t_wechat_scan` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `uid` varchar(32) DEFAULT NULL COMMENT '扫码唯一标识',
  `status` varchar(4) DEFAULT '0' COMMENT '状态（0：初始创建，200:已扫码，400：已确认，500：已超时）',
  `wechat_user_id` int(9) DEFAULT NULL COMMENT '扫码微信用户信息编号',
  `create_date` datetime DEFAULT NULL COMMENT '二维码创建时间',
  `scan_date` datetime DEFAULT NULL COMMENT '用户扫码时间',
  `end_date` datetime DEFAULT NULL COMMENT '造作结束时间（超时或已确认登陆）时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `NewIndex1` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_wechat_scan` */

/*Table structure for table `t_wechat_user_info` */

DROP TABLE IF EXISTS `t_wechat_user_info`;

CREATE TABLE `t_wechat_user_info` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `openid` varchar(64) DEFAULT NULL COMMENT '用户的唯一标识',
  `nickname` varchar(64) DEFAULT NULL COMMENT '用户昵称',
  `sex` int(2) DEFAULT NULL COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  `country` varchar(64) DEFAULT NULL COMMENT '国家',
  `province` varchar(64) DEFAULT NULL COMMENT '用户个人资料填写的省份',
  `city` varchar(64) DEFAULT NULL COMMENT '用户个人资料填写的城市',
  `headimgurl` varchar(256) DEFAULT NULL COMMENT '用户头像',
  `status` varchar(8) DEFAULT NULL COMMENT '状态（open：开启/close：关闭）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_wechat_user_info` */

insert  into `t_wechat_user_info`(`id`,`openid`,`nickname`,`sex`,`country`,`province`,`city`,`headimgurl`,`status`) values (6,'oTjXAt_VHx_k7lBWPQMgHPEQJt0s','吕志博',1,'中国','广东','深圳','http://wx.qlogo.cn/mmopen/3y5nX7eLiaujgJyDUsL1Dz2yuYDR7C9GmlRuibTH0J8Tic9KExOjMLtHLPibNn02iaXWhUZAobkVZzCr74Xia67ic193fFiaYcJAvziag/','close'),(7,'oTjXAt_xbTfo2rw-54Bm6LLotldM','荣格格',2,'中国','新疆','和田','http://wx.qlogo.cn/mmopen/lzRibhM9MMhxZN4nZAARP6kTsK2goLs0rrbHwJPrmXajwdicYODoXkDBxYoogh8Uib60kP6vGL6qhYy0xnRswRfePjHHUexP3K9/','open'),(8,'oTjXAtypoyI1YRl_-BURfSJnkTG8','小小小小小名堂',1,'','','','http://wx.qlogo.cn/mmopen/snsGOwDBKpicmsIibGrheV26uZ2uY98aWAQicbj5EL0k60YyVbHO31nyWey1CbPD2XBITic9y8tPz8VicrMfuIV7bv99d3iaxAmFul/','open');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

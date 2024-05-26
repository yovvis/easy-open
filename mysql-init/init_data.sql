use tenyon;
-- 用户信息
INSERT INTO tenyon.user (id, userAccount, userPassword, userName, userAvatar, userProfile, userRole, createTime,
                         updateTime, isDelete, mpOpenId, unionId, gender, phone, email, userStatus, address, job)
VALUES (1, 'yovvis', 'bf81e6a43e9b319e0c128efe91e29f93', '程序员Yovvis', 'https://cdn.tenyon.cn/avatar.png',
        '我有一头小毛驴我从来也不骑', 'admin', '2024-02-01 19:49:55', '2024-03-23 17:47:47', 0, null, null, 1,
        '13814371111', '123@qq.com', 1, '', '');
INSERT INTO tenyon.user (id, userAccount, userPassword, userName, userAvatar, userProfile, userRole, createTime,
                         updateTime, isDelete, mpOpenId, unionId, gender, phone, email, userStatus, address, job)
VALUES (2, 'yovvis2', 'bf81e6a43e9b319e0c128efe91e29f93', '普通Yovvis', 'https://cdn.tenyon.cn/avatar.png',
        '我有一头小毛驴我从来也不骑', 'user', '2024-02-01 19:49:55', '2024-04-06 15:43:31', 0, null, null, 0,
        '13814371111', '123@qq.com', 1, '', '');
INSERT INTO tenyon.user (id, userAccount, userPassword, userName, userAvatar, userProfile, userRole, createTime,
                         updateTime, isDelete, mpOpenId, unionId, gender, phone, email, userStatus, address, job)
VALUES (1755249537604112385, 'ceshi', 'bf81e6a43e9b319e0c128efe91e29f93', null, null, null, 'user',
        '2024-02-07 23:17:55', '2024-04-06 15:43:31', 0, null, null, 0, '13814371111', '123@qq.com', 1, '', '');
INSERT INTO tenyon.user (id, userAccount, userPassword, userName, userAvatar, userProfile, userRole, createTime,
                         updateTime, isDelete, mpOpenId, unionId, gender, phone, email, userStatus, address, job)
VALUES (1755249775375011841, 'ceshi', 'bf81e6a43e9b319e0c128efe91e29f93', null, null, null, 'user',
        '2024-02-07 23:18:52', '2024-04-06 15:43:31', 0, null, null, 0, '13814371111', '123@qq.com', 1, '', '');
INSERT INTO tenyon.user (id, userAccount, userPassword, userName, userAvatar, userProfile, userRole, createTime,
                         updateTime, isDelete, mpOpenId, unionId, gender, phone, email, userStatus, address, job)
VALUES (1771514197995102209, '111', 'bf81e6a43e9b319e0c128efe91e29f93', '123', '213', null, 'admin',
        '2024-03-23 20:27:52', '2024-04-06 15:43:31', 0, null, null, 0, '13814371111', '123@qq.com', 1, '', '');
-- 接口
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('邱瑞霖', '钟熠彤', 'www.kirk-medhurst.name', '戴弘文', '萧博文', 0, 579736448, '段嘉熙');
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('陆伟祺', '薛驰', 'www.austin-predovic.com', '金明哲', '江明哲', 0, 1072389228, '刘立轩');
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('梁浩轩', '邓建辉', 'www.kerry-koch.org', '潘明', '叶烨霖', 0, 7, '傅楷瑞');
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('任志泽', '龙鑫磊', 'www.in-paucek.name', '夏越彬', '汪睿渊', 0, 67226, '黎驰');
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('冯旭尧', '萧雪松', 'www.rudolph-effertz.net', '吕鸿煊', '冯昊天', 0, 3, '沈航');
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('严志强', '叶凯瑞', 'www.porfirio-breitenberg.net', '陶俊驰', '林嘉熙', 0, 37240718, '唐修杰');
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('姚志强', '黄钰轩', 'www.cherrie-kuhlman.co', '顾立辉', '马明辉', 0, 604, '范越彬');
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('秦明辉', '王熠彤', 'www.avery-rath.org', '范乐驹', '周烨霖', 0, 483, '蒋驰');
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('雷智渊', '白峻熙', 'www.linwood-yost.org', '萧雪松', '陶思', 0, 6571943, '覃弘文');
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('张智辉', '蔡博超', 'www.kenya-dubuque.name', '董靖琪', '白明辉', 0, 7628256, '程鹤轩');
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('宋浩轩', '王风华', 'www.arnulfo-hartmann.org', '许皓轩', '宋弘文', 0, 7, '卢浩宇');
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('朱明哲', '田子默', 'www.lakendra-littel.biz', '傅智渊', '覃鹏', 0, 39307, '龚文');
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('刘雪松', '叶晓博', 'www.stephany-abbott.org', '江果', '梁鹭洋', 0, 25132061, '李远航');
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('邱鹏煊', '白绍辉', 'www.santos-schimmel.org', '郝伟祺', '贺立诚', 0, 95, '唐文');
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('秦靖琪', '李正豪', 'www.ross-mckenzie.name', '董远航', '汪乐驹', 0, 8, '赖伟祺');
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('莫雨泽', '卢锦程', 'www.jermaine-murazik.net', '韩峻熙', '姚正豪', 0, 6530, '钟昊然');
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('武雨泽', '方瑞霖', 'www.waylon-lynch.com', '张炎彬', '田鹭洋', 0, 10, '赵鸿煊');
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('孟俊驰', '龙金鑫', 'www.mammie-johnston.co', '严展鹏', '白明轩', 0, 7, '孟嘉懿');
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('龙立诚', '方胤祥', 'www.arlean-altenwerth.co', '梁锦程', '龚浩然', 0, 2578968312, '郭伟泽');
insert into tenyon.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`,
                                     `userId`, `method`)
values ('姜明辉', '曹鹏煊', 'www.diedra-west.org', '孟越彬', '赖明哲', 0, 2756955328, '赖天翊');

-- 应用表初始数据
INSERT INTO app (id, appName, appDesc, appIcon, appType, scoringStrategy, reviewStatus, reviewMessage, reviewerId,
                 reviewTime, userId, createTime, updateTime, isDelete)
VALUES (1, '自定义MBTI性格测试', '测试性格', '11', 1, 0, 1, null, null, null, 1, '2024-04-24 15:58:05', '2024-05-09 15:09:53', 0);
INSERT INTO app (id, appName, appDesc, appIcon, appType, scoringStrategy, reviewStatus, reviewMessage, reviewerId,
                 reviewTime, userId, createTime, updateTime, isDelete)
VALUES (2, '自定义得分测试', '测试得分', '22', 0, 0, 1, null, null, null, 1, '2024-04-25 11:39:30', '2024-05-09 15:09:53', 0);
INSERT INTO app (id, appName, appDesc, appIcon, appType, scoringStrategy, reviewStatus, reviewMessage, reviewerId,
                 reviewTime, userId, createTime, updateTime, isDelete)
VALUES (3, 'AI MBTI 性格测试', '快来测测你的 MBTI', '11', 1, 1, 1, null, null, null, 1, '2024-04-26 16:38:12',
        '2024-05-09 15:09:53', 0);
INSERT INTO app (id, appName, appDesc, appIcon, appType, scoringStrategy, reviewStatus, reviewMessage, reviewerId,
                 reviewTime, userId, createTime, updateTime, isDelete)
VALUES (4, 'AI 得分测试', '看看你熟悉多少首都', '22', 0, 1, 1, null, null, null, 1, '2024-04-26 16:38:56', '2024-05-09 15:09:53', 0);

-- 题目表初始数据
INSERT INTO question (id, questionContent, appId, userId, createTime, updateTime, isDelete)
VALUES (1,
        '[{"options":[{"result":"I","value":"独自工作","key":"A"},{"result":"E","value":"与他人合作","key":"B"}],"title":"1. 你通常更喜欢"},{"options":[{"result":"J","value":"喜欢有明确的计划","key":"A"},{"result":"P","value":"更愿意随机应变","key":"B"}],"title":"2. 当安排活动时"},{"options":[{"result":"T","value":"认为应该严格遵守","key":"A"},{"result":"F","value":"认为应灵活运用","key":"B"}],"title":"3. 你如何看待规则"},{"options":[{"result":"E","value":"经常是说话的人","key":"A"},{"result":"I","value":"更倾向于倾听","key":"B"}],"title":"4. 在社交场合中"},{"options":[{"result":"J","value":"先研究再行动","key":"A"},{"result":"P","value":"边做边学习","key":"B"}],"title":"5. 面对新的挑战"},{"options":[{"result":"S","value":"注重细节和事实","key":"A"},{"result":"N","value":"注重概念和想象","key":"B"}],"title":"6. 在日常生活中"},{"options":[{"result":"T","value":"更多基于逻辑分析","key":"A"},{"result":"F","value":"更多基于个人情感","key":"B"}],"title":"7. 做决定时"},{"options":[{"result":"S","value":"喜欢有结构和常规","key":"A"},{"result":"N","value":"喜欢自由和灵活性","key":"B"}],"title":"8. 对于日常安排"},{"options":[{"result":"P","value":"首先考虑可能性","key":"A"},{"result":"J","value":"首先考虑后果","key":"B"}],"title":"9. 当遇到问题时"},{"options":[{"result":"T","value":"时间是一种宝贵的资源","key":"A"},{"result":"F","value":"时间是相对灵活的概念","key":"B"}],"title":"10. 你如何看待时间"}]',
        1, 1, '2024-04-24 16:41:53', '2024-05-09 12:28:58', 0);
INSERT INTO question (id, questionContent, appId, userId, createTime, updateTime, isDelete)
VALUES (2,
        '[{"options":[{"score":0,"value":"利马","key":"A"},{"score":0,"value":"圣多明各","key":"B"},{"score":0,"value":"圣萨尔瓦多","key":"C"},{"score":1,"value":"波哥大","key":"D"}],"title":"哥伦比亚的首都是?"},{"options":[{"score":0,"value":"蒙特利尔","key":"A"},{"score":0,"value":"多伦多","key":"B"},{"score":1,"value":"渥太华","key":"C"},{"score":0,"value":"温哥华","key":"D"}],"title":"加拿大的首都是?"},{"options":[{"score":0,"value":"大阪","key":"A"},{"score":1,"value":"东京","key":"B"},{"score":0,"value":"京都","key":"C"},{"score":0,"value":"名古屋","key":"D"}],"title":"日本的首都是?"},{"options":[{"score":0,"value":"墨尔本","key":"A"},{"score":0,"value":"悉尼","key":"B"},{"score":0,"value":"布里斯班","key":"C"},{"score":1,"value":"堪培拉","key":"D"}],"title":"澳大利亚的首都是?"},{"options":[{"score":1,"value":"雅加达","key":"A"},{"score":0,"value":"曼谷","key":"B"},{"score":0,"value":"胡志明市","key":"C"},{"score":0,"value":"吉隆坡","key":"D"}],"title":"印度尼西亚的首都是?"},{"options":[{"score":0,"value":"上海","key":"A"},{"score":0,"value":"杭州","key":"B"},{"score":1,"value":"北京","key":"C"},{"score":0,"value":"广州","key":"D"}],"title":"中国的首都是?"},{"options":[{"score":0,"value":"汉堡","key":"A"},{"score":0,"value":"慕尼黑","key":"B"},{"score":1,"value":"柏林","key":"C"},{"score":0,"value":"科隆","key":"D"}],"title":"德国的首都是?"},{"options":[{"score":0,"value":"釜山","key":"A"},{"score":1,"value":"首尔","key":"B"},{"score":0,"value":"大田","key":"C"},{"score":0,"value":"仁川","key":"D"}],"title":"韩国的首都是?"},{"options":[{"score":0,"value":"瓜达拉哈拉","key":"A"},{"score":0,"value":"蒙特雷","key":"B"},{"score":1,"value":"墨西哥城","key":"C"},{"score":0,"value":"坎昆","key":"D"}],"title":"墨西哥的首都是?"},{"options":[{"score":1,"value":"开罗","key":"A"},{"score":0,"value":"亚历山大","key":"B"},{"score":0,"value":"卢克索","key":"C"},{"score":0,"value":"卡利乌比亚","key":"D"}],"title":"埃及的首都是?"}]',
        2, 1, '2024-04-25 15:03:07', '2024-05-09 12:28:58', 0);
INSERT INTO question (id, questionContent, appId, userId, createTime, updateTime, isDelete)
VALUES (3,
        '[{"options":[{"result":"I","value":"独自工作","key":"A"},{"result":"E","value":"与他人合作","key":"B"}],"title":"1. 你通常更喜欢"},{"options":[{"result":"J","value":"喜欢有明确的计划","key":"A"},{"result":"P","value":"更愿意随机应变","key":"B"}],"title":"2. 当安排活动时"},{"options":[{"result":"T","value":"认为应该严格遵守","key":"A"},{"result":"F","value":"认为应灵活运用","key":"B"}],"title":"3. 你如何看待规则"},{"options":[{"result":"E","value":"经常是说话的人","key":"A"},{"result":"I","value":"更倾向于倾听","key":"B"}],"title":"4. 在社交场合中"},{"options":[{"result":"J","value":"先研究再行动","key":"A"},{"result":"P","value":"边做边学习","key":"B"}],"title":"5. 面对新的挑战"},{"options":[{"result":"S","value":"注重细节和事实","key":"A"},{"result":"N","value":"注重概念和想象","key":"B"}],"title":"6. 在日常生活中"},{"options":[{"result":"T","value":"更多基于逻辑分析","key":"A"},{"result":"F","value":"更多基于个人情感","key":"B"}],"title":"7. 做决定时"},{"options":[{"result":"S","value":"喜欢有结构和常规","key":"A"},{"result":"N","value":"喜欢自由和灵活性","key":"B"}],"title":"8. 对于日常安排"},{"options":[{"result":"P","value":"首先考虑可能性","key":"A"},{"result":"J","value":"首先考虑后果","key":"B"}],"title":"9. 当遇到问题时"},{"options":[{"result":"T","value":"时间是一种宝贵的资源","key":"A"},{"result":"F","value":"时间是相对灵活的概念","key":"B"}],"title":"10. 你如何看待时间"}]',
        3, 1, '2024-04-26 16:39:29', '2024-05-09 12:28:58', 0);
INSERT INTO question (id, questionContent, appId, userId, createTime, updateTime, isDelete)
VALUES (4,
        '[{"options":[{"score":0,"value":"利马","key":"A"},{"score":0,"value":"圣多明各","key":"B"},{"score":0,"value":"圣萨尔瓦多","key":"C"},{"score":1,"value":"波哥大","key":"D"}],"title":"哥伦比亚的首都是?"},{"options":[{"score":0,"value":"蒙特利尔","key":"A"},{"score":0,"value":"多伦多","key":"B"},{"score":1,"value":"渥太华","key":"C"},{"score":0,"value":"温哥华","key":"D"}],"title":"加拿大的首都是?"},{"options":[{"score":0,"value":"大阪","key":"A"},{"score":1,"value":"东京","key":"B"},{"score":0,"value":"京都","key":"C"},{"score":0,"value":"名古屋","key":"D"}],"title":"日本的首都是?"},{"options":[{"score":0,"value":"墨尔本","key":"A"},{"score":0,"value":"悉尼","key":"B"},{"score":0,"value":"布里斯班","key":"C"},{"score":1,"value":"堪培拉","key":"D"}],"title":"澳大利亚的首都是?"},{"options":[{"score":1,"value":"雅加达","key":"A"},{"score":0,"value":"曼谷","key":"B"},{"score":0,"value":"胡志明市","key":"C"},{"score":0,"value":"吉隆坡","key":"D"}],"title":"印度尼西亚的首都是?"},{"options":[{"score":0,"value":"上海","key":"A"},{"score":0,"value":"杭州","key":"B"},{"score":1,"value":"北京","key":"C"},{"score":0,"value":"广州","key":"D"}],"title":"中国的首都是?"},{"options":[{"score":0,"value":"汉堡","key":"A"},{"score":0,"value":"慕尼黑","key":"B"},{"score":1,"value":"柏林","key":"C"},{"score":0,"value":"科隆","key":"D"}],"title":"德国的首都是?"},{"options":[{"score":0,"value":"釜山","key":"A"},{"score":1,"value":"首尔","key":"B"},{"score":0,"value":"大田","key":"C"},{"score":0,"value":"仁川","key":"D"}],"title":"韩国的首都是?"},{"options":[{"score":0,"value":"瓜达拉哈拉","key":"A"},{"score":0,"value":"蒙特雷","key":"B"},{"score":1,"value":"墨西哥城","key":"C"},{"score":0,"value":"坎昆","key":"D"}],"title":"墨西哥的首都是?"},{"options":[{"score":1,"value":"开罗","key":"A"},{"score":0,"value":"亚历山大","key":"B"},{"score":0,"value":"卢克索","key":"C"},{"score":0,"value":"卡利乌比亚","key":"D"}],"title":"埃及的首都是?"}]',
        4, 1, '2024-04-26 16:39:29', '2024-05-09 12:28:58', 0);


-- 评分结果表初始数据
INSERT INTO scoring_result (id, resultName, resultDesc, resultPicture, resultProp, resultScoreRange, createTime,
                            updateTime, isDelete, appId, userId)
VALUES (1, 'ISTJ（物流师）', '忠诚可靠，被公认为务实，注重细节。', 'icon_url_istj', '["I","S","T","J"]', null,
        '2024-04-24 16:57:02', '2024-05-09 12:28:21', 0, 1, 1);
INSERT INTO scoring_result (id, resultName, resultDesc, resultPicture, resultProp, resultScoreRange, createTime,
                            updateTime, isDelete, appId, userId)
VALUES (2, 'ISFJ（守护者）', '善良贴心，以同情心和责任为特点。', 'icon_url_isfj', '["I","S","F","J"]', null,
        '2024-04-24 16:57:02', '2024-05-09 12:28:21', 0, 1, 1);
INSERT INTO scoring_result (id, resultName, resultDesc, resultPicture, resultProp, resultScoreRange, createTime,
                            updateTime, isDelete, appId, userId)
VALUES (3, 'INFJ（占有者）', '理想主义者，有着深刻的洞察力，善于理解他人。', 'icon_url_infj', '["I","N","F","J"]', null,
        '2024-04-24 16:57:02', '2024-05-09 12:28:21', 0, 1, 1);
INSERT INTO scoring_result (id, resultName, resultDesc, resultPicture, resultProp, resultScoreRange, createTime,
                            updateTime, isDelete, appId, userId)
VALUES (4, 'INTJ（设计师）', '独立思考者，善于规划和实现目标，理性而果断。', 'icon_url_intj', '["I","N","T","J"]', null,
        '2024-04-24 16:57:02', '2024-05-09 12:28:21', 0, 1, 1);
INSERT INTO scoring_result (id, resultName, resultDesc, resultPicture, resultProp, resultScoreRange, createTime,
                            updateTime, isDelete, appId, userId)
VALUES (5, 'ISTP（运动员）', '冷静自持，善于解决问题，擅长实践技能。', 'icon_url_istp', '["I","S","T","P"]', null,
        '2024-04-24 16:57:02', '2024-05-09 12:28:21', 0, 1, 1);
INSERT INTO scoring_result (id, resultName, resultDesc, resultPicture, resultProp, resultScoreRange, createTime,
                            updateTime, isDelete, appId, userId)
VALUES (6, 'ISFP（艺术家）', '具有艺术感和敏感性，珍视个人空间和自由。', 'icon_url_isfp', '["I","S","F","P"]', null,
        '2024-04-24 16:57:02', '2024-05-09 12:28:21', 0, 1, 1);
INSERT INTO scoring_result (id, resultName, resultDesc, resultPicture, resultProp, resultScoreRange, createTime,
                            updateTime, isDelete, appId, userId)
VALUES (7, 'INFP（治愈者）', '理想主义者，富有创造力，以同情心和理解他人著称。', 'icon_url_infp', '["I","N","F","P"]', null,
        '2024-04-24 16:57:02', '2024-05-09 12:28:21', 0, 1, 1);
INSERT INTO scoring_result (id, resultName, resultDesc, resultPicture, resultProp, resultScoreRange, createTime,
                            updateTime, isDelete, appId, userId)
VALUES (8, 'INTP（学者）', '思维清晰，探索精神，独立思考且理性。', 'icon_url_intp', '["I","N","T","P"]', null,
        '2024-04-24 16:57:02', '2024-05-09 12:28:21', 0, 1, 1);
INSERT INTO scoring_result (id, resultName, resultDesc, resultPicture, resultProp, resultScoreRange, createTime,
                            updateTime, isDelete, appId, userId)
VALUES (9, 'ESTP（拓荒者）', '敢于冒险，乐于冒险，思维敏捷，行动果断。', 'icon_url_estp', '["E","S","T","P"]', null,
        '2024-04-24 16:57:02', '2024-05-09 12:28:21', 0, 1, 1);
INSERT INTO scoring_result (id, resultName, resultDesc, resultPicture, resultProp, resultScoreRange, createTime,
                            updateTime, isDelete, appId, userId)
VALUES (10, 'ESFP（表演者）', '热情开朗，善于社交，热爱生活，乐于助人。', 'icon_url_esfp', '["E","S","F","P"]', null,
        '2024-04-24 16:57:02', '2024-05-09 12:28:21', 0, 1, 1);
INSERT INTO scoring_result (id, resultName, resultDesc, resultPicture, resultProp, resultScoreRange, createTime,
                            updateTime, isDelete, appId, userId)
VALUES (11, 'ENFP（倡导者）', '富有想象力，充满热情，善于激发他人的活力和潜力。', 'icon_url_enfp', '["E","N","F","P"]', null,
        '2024-04-24 16:57:02', '2024-05-09 12:28:21', 0, 1, 1);
INSERT INTO scoring_result (id, resultName, resultDesc, resultPicture, resultProp, resultScoreRange, createTime,
                            updateTime, isDelete, appId, userId)
VALUES (12, 'ENTP（发明家）', '充满创造力，善于辩论，挑战传统，喜欢探索新领域。', 'icon_url_entp', '["E","N","T","P"]', null,
        '2024-04-24 16:57:02', '2024-05-09 12:28:21', 0, 1, 1);
INSERT INTO scoring_result (id, resultName, resultDesc, resultPicture, resultProp, resultScoreRange, createTime,
                            updateTime, isDelete, appId, userId)
VALUES (13, 'ESTJ（主管）', '务实果断，善于组织和管理，重视效率和目标。', 'icon_url_estj', '["E","S","T","J"]', null,
        '2024-04-24 16:57:02', '2024-05-09 12:28:21', 0, 1, 1);
INSERT INTO scoring_result (id, resultName, resultDesc, resultPicture, resultProp, resultScoreRange, createTime,
                            updateTime, isDelete, appId, userId)
VALUES (14, 'ESFJ（尽责者）', '友善热心，以协调、耐心和关怀为特点，善于团队合作。', 'icon_url_esfj', '["E","S","F","J"]',
        null, '2024-04-24 16:57:02', '2024-05-09 12:28:21', 0, 1, 1);
INSERT INTO scoring_result (id, resultName, resultDesc, resultPicture, resultProp, resultScoreRange, createTime,
                            updateTime, isDelete, appId, userId)
VALUES (15, 'ENFJ（教导着）', '热情关爱，善于帮助他人，具有领导力和社交能力。', 'icon_url_enfj', '["E","N","F","J"]', null,
        '2024-04-24 16:57:02', '2024-05-09 12:28:21', 0, 1, 1);
INSERT INTO scoring_result (id, resultName, resultDesc, resultPicture, resultProp, resultScoreRange, createTime,
                            updateTime, isDelete, appId, userId)
VALUES (16, 'ENTJ（统帅）', '果断自信，具有领导才能，善于规划和执行目标。', 'icon_url_entj', '["E","N","T","J"]', null,
        '2024-04-24 16:57:02', '2024-05-09 12:28:21', 0, 1, 1);
INSERT INTO scoring_result (id, resultName, resultDesc, resultPicture, resultProp, resultScoreRange, createTime,
                            updateTime, isDelete, appId, userId)
VALUES (17, '首都知识大师', '你真棒棒哦，首都知识非常出色！', null, null, 9, '2024-04-25 15:05:44', '2024-05-09 12:28:21',
        0, 2, 1);
INSERT INTO scoring_result (id, resultName, resultDesc, resultPicture, resultProp, resultScoreRange, createTime,
                            updateTime, isDelete, appId, userId)
VALUES (18, '地理小能手！', '你对于世界各国的首都了解得相当不错，但还有一些小地方需要加强哦！', null, null, 7,
        '2024-04-25 15:05:44', '2024-05-09 12:28:21', 0, 2, 1);
INSERT INTO scoring_result (id, resultName, resultDesc, resultPicture, resultProp, resultScoreRange, createTime,
                            updateTime, isDelete, appId, userId)
VALUES (19, '继续加油！', '还需努力哦', null, null, 0, '2024-04-25 15:05:44', '2024-05-09 12:28:21', 0, 2, 1);

-- 用户回答表初始数据
INSERT INTO user_answer (id, appId, appType, choices, resultId, resultName, resultDesc, resultPicture, resultScore,
                         scoringStrategy, userId, createTime, updateTime, isDelete)
VALUES (1, 1, 1, '["A","A","A","B","A","A","A","B","B","A"]', 1, 'ISTJ（物流师）', '忠诚可靠，被公认为务实，注重细节。', 'icon_url_istj',
        null, 0, 1, '2024-05-09 15:08:22', '2024-05-09 15:10:13', 0);
INSERT INTO user_answer (id, appId, appType, choices, resultId, resultName, resultDesc, resultPicture, resultScore,
                         scoringStrategy, userId, createTime, updateTime, isDelete)
VALUES (2, 2, 0, '["D","C","B","D","A","C","C","B","C","A"]', 17, '首都知识大师', '你真棒棒哦，首都知识非常出色！', null, 10, 0, 1,
        '2024-05-09 15:08:36', '2024-05-09 15:10:13', 0);
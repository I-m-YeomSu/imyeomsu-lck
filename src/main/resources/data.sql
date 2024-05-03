insert into roles values(1,'ROLE_ADMIN');
insert into roles values(2,'ROLE_USER');


INSERT INTO match_schedule (matchDate, matchTime, matchState, matchTitle, homeTeamScore, awayTeamScore, homeTeamName, homeTeamLogo, awayTeamName, awayTeamLogo)
VALUES
    ('03월 20일 (수)', '17:00', '종료', '플레이오프 1R', '2', '3', '젠지', '로고없음', 'Dplus KIA', '로고없음'),
    ('03월 20일 (수)', '17:00', '종료', '플레이오프 2R', '1', '3', '젠지', '로고없음', 'KT', '로고없음'),
    ('03월 21일 (목)', '17:00', '종료', '플레이오프 1R', '3', '0', 'T1', '로고없음', '한화생명e스포츠', '로고없음'),
    ('03월 21일 (목)', '17:00', '종료', '플레이오프 2R', '0', '3', 'T1', '로고없음', 'DK', '로고없음'),
    ('03월 23일 (토)', '15:00', '종료', '플레이오프 1R', '1', '3', '젠지', '로고없음', '한화생명e스포츠', '로고없음'),
    ('03월 23일 (토)', '15:00', '종료', '플레이오프 2R', '3', '2', '광동', '로고없음', '피어엑스', '로고없음'),
    ('03월 24일 (일)', '15:00', '종료', '플레이오프 2R', '3', '0', 'Dplus KIA', '로고없음', 'T1', '로고없음'),
    ('03월 24일 (일)', '15:00', '종료', '플레이오프 2R', '1', '3', '농심', '로고없음', 'DRX', '로고없음'),
    ('03월 30일 (토)', '15:00', '종료', '플레이오프 2R', '3', '1', '한화생명e스포츠', '로고없음', 'T1', '로고없음'),
    ('03월 31일 (일)', '15:00', '종료', '결승전', '2', '3', '젠지', '로고없음', 'T1', '로고없음'),
    ('04월 03일 (수)', '17:00', '종료', '플레이오프 2R', '3', '2', '젠지', '로고없음', 'Dplus KIA', '로고없음'),
    ('04월 04일 (목)', '17:00', '종료', '플레이오프 2R', '0', '3', 'T1', '로고없음', '한화생명e스포츠', '로고없음'),
    ('04월 06일 (토)', '15:00', '종료', '플레이오프 3R', '3', '1', '젠지', '로고없음', '한화생명e스포츠', '로고없음'),
    ('04월 07일 (일)', '15:00', '종료', '플레이오프 3R', '0', '3', 'Dplus KIA', '로고없음', 'T1', '로고없음'),
    ('04월 13일 (토)', '15:00', '종료', '플레이오프 4R', '1', '3', '한화생명e스포츠', '로고없음', 'T1', '로고없음'),
    ('04월 14일 (일)', '15:00', '종료', '결승전', '3', '2', '젠지', '로고없음', 'T1', '로고없음');


INSERT INTO ranks (logo, teamName, win, lose, difference, winrate, kda, killCount, deathCount, assistCount)
VALUES
    ('https://nng-phinf.pstatic.net/MjAyNDA0MTRfODAg/MDAxNzEzMDkzODYyNDQ4.eYiZxiqvEsfKTolDJgMiWGdZdPkvjqTaJCBzieidI04g.Z49TEBd7qQnvaQbYAmJLhcozS7OO9Lam1tZ-Lz-UOsUg.PNG/xEtyTgLerKLWMjBvzShJ.png?type=f120_120', '젠지', 17, 1, '29', '0.94', 6.21, 596, 320, 1391),
    ('https://nng-phinf.pstatic.net/MjAyNDA0MTRfMTk2/MDAxNzEzMDkzODYxNTc2.SlpXOgtG6X6a131j5PFnnsTkmXoGGminj9HeOTn6kxAg.Qa50Pke89rBsv5j0zYAzSsLZZDED-hqCEVrb2PpKnbMg.PNG/OTPAFPzgFABncrdbehrH.png?type=f120_120', 'T1', 15, 3, '24', '0.83', 4.94, 637, 417, 1423),
    ('https://nng-phinf.pstatic.net/MjAyNDA0MTVfMjc3/MDAxNzEzMTQ2MTg1OTk2.L7-0M2qgNBTm0dmJ5obRmwBgJgsq_HKaXPpy_WY3ciIg.B0gYdA2lQvpa1VNviUPc2xlbEQoE6LRsv2X6D8-ei5Mg.PNG/FLymLRXFVoQVsINtpIbd.png?type=f120_120', '한화생명', 15, 3, '19', '0.83', 5.63, 590, 367, 1478),
    ('https://nng-phinf.pstatic.net/MjAyNDA0MDFfMjQz/MDAxNzExOTM0MDYzNTQ0.BXFXeZSKGudChxDQHSlXFjfpLD-8F7Qj5CRmPemM9_gg.YUChl06MZvRXyFifWKP67ym3c1o7bdQjHW4DzKPg98gg.PNG/CROUtRpfvhEPjVEZPuYf.png?type=f120_120', 'KT', 11, 7, '8', '0.61', 3.95, 621, 545, 1530),
    ('https://nng-phinf.pstatic.net/MjAyNDA0MTVfMTc5/MDAxNzEzMTQ2MzAyMzk2.a6RwHH4H0Pdmj2e94ATn0sbqufNeII2Tsp0eywcR9DMg.-kdna3kkkNAtkSdpNlT_AiQHjnumQjr6G_fDxsT9ncQg.PNG/UMIwmmSnEhcKdbuVlxOh.png?type=f120_120', 'DK', 9, 9, '0', '0.5', 3.86, 512, 450, 1226),
    ('https://nng-phinf.pstatic.net/MjAyNDA0MDFfMTk2/MDAxNzExOTM0MDYzMTcz.lhZizFf8Yl1-vPHTlhvhx-sCykaKbs_lgQCaisb53YEg.UZgLRfXQjBW_MYd23AMtncvr735nmqX6pftybznaLdYg.PNG/KFbUTxgbuDIRTdJvihUg.png?type=f120_120', '광동', 7, 11, '-7', '0.39', 2.72, 505, 654, 1276),
    ('https://nng-phinf.pstatic.net/MjAyNDAzMjNfMyAg/MDAxNzExMTgwNzAxMzcw.0Lxk2ZMpGjPvTn26rixHzpZWROCrYW2nVJvwgQeyxCsg.ZOxXZiI1lhZg70yPCrnK6KYDRwzpBVN5fa4MP2ErQQ0g.PNG/lEjmqZZltdVtVCIqCZNv.png?type=f120_120', '피어엑스', 6, 12, '-11', '0.33', 2.94, 492, 574, 1196),
    ('https://nng-phinf.pstatic.net/MjAyNDAzMjZfMjQg/MDAxNzExNDE3MTYyMDU3.UBuV4QtFQGlG203rf_kC8R8DZS0IqsXl0XD1iCGOMqAg.UtR359CPwFDzkrAQcUVbmE4cO88VGpINnzBw_c-lm3Qg.PNG/rACNYetwysAPKmGbIfzA.png?type=f120_120', '농심', 4, 14, '-16', '0.22', 2.39, 429, 609, 1026),
    ('https://nng-phinf.pstatic.net/MjAyNDAzMjZfMTg4/MDAxNzExNDE3MTYxNzE4.6_264vHe2E-X9BJ2GuOpSn9prpRBGCEGFGbZFkJeL98g.N8z_V3NoVyVf6Mt2v5gqWQ_dtEn5wWLhVUrxju94R6gg.PNG/gtrfcuNQbbKMYLqKcBUJ.png?type=f120_120', 'DRX', 3, 15, '-21', '0.17', 2.08, 353, 577, 850),
    ('https://nng-phinf.pstatic.net/MjAyNDAzMjZfMjI0/MDAxNzExNDE3MTYxMzkw.EBM7sWpqoY3sFMxqFm5ch2YdWwQytwIApMRxSswxuxMg.bK2d6-5k8S12EdbkcZLkxq4CZ5PdP-ic8bfeRe_-yOUg.PNG/fYCmSHyvOGzzBPrUcprF.png?type=f120_120', 'OK저축은행', 3, 15, '-25', '0.17', 2.19, 374, 603, 945);

INSERT INTO news (title, content, thumbnail, date, index)
VALUES
("LCK 무관 설움 씻은 파이널 MVP '기인' 김기인의 뜨거운 눈물", "[OSEN=올림픽공원, 고용준 기자] 기인 선수의 눈물은 우리가 1세트를 이기고 쉽게 갔으면 3-0으로 이겨서 울리지 않았을 것 같다. 풀세트 접전으로 가서 우리가 울렸다고 해도 되는 것 같다. 어떻게 보면 '기인 선수를 울리는 남자들'이라는 타이틀을 얻은 것 같다"'쵸비&rsq...", "https://imgnews.pstatic.net/image/origin/109/2024/04/15/5058431.jpg?type=nf472_236", "2024-04-15", 0),
    ("성공적인 이적 첫 시즌…'캐니언', 3년 만에 LCK 정상 등극", "정들었던 팀을 떠나 새로운 도전을 했던 '캐니언' 김건부의 첫 시즌은 성공적이었다. 2021년 이후 3년 만에 리그 오브 레전드 챔피언스 코리아(LCK) 정상에 선 것이다.젠지는 15일 서울 송파구 방이동 KSPO 돔에서 진행된 2024 리그 오브 레전드 챔피언스 코리아 스프링 플레이오프 결승전에서 접전 끝에 T1을 3...", "https://imgnews.pstatic.net/image/origin/347/2024/04/15/179581.jpg?type=nf472_236", "2024-04-15", 1),
    ("LCK '무관' 설움 끝→만장일치 'MVP' 젠지 '기인' 김기인 뜨거운 눈물 그리고 한(恨)풀이 [SS스타]", "젠지가 LCK 최초 4연속 우승을 달성했다. 사진 | LCK[스포츠서울 | 송파=김민규 기자] 젠지 탑 라이너 '기인' 김기인(25)은 리그 최하위부터 2위까지 모두 경험했다. 딱 하나 '우승'과는 인연이 없었다. 누구보다 간절함이 컸다. 그렇게 데뷔 7년 만에 왕좌에 올랐다.우승을 확정짓는 순간, 뜨거운 눈물을 쏟으며...", "https://imgnews.pstatic.net/image/origin/468/2024/04/15/1050555.jpg?type=nf472_236", "2024-04-15", 2),
    ("리그오브레전드챔피언스코리아 결승전, 9월 경주에서 열린다", "2023 LCK 스프링 결승전(대전) 현장. 경주시 제공(출처=LCK)경주에서 오는 9월 국내 최대 e스포츠 대회인 '리그오브레전드 챔피언스 코리아(이하 LCK) 서머 결승전'이 열린다.경주시는 LCK/한국e스포츠협회가 주최·주관하는 '2024 LCK 서머 결승전 개최도시' 공모에 최종 선정됐다고 15일 밝혔다.올해 12...", "https://imgnews.pstatic.net/image/origin/015/2024/04/15/4973009.jpg?type=nf472_236", "2024-04-15", 3),
    ("\"우리도 포핏(4-Peat)!\"…G2, 프나틱 꺾고 LEC 14번째 우승", "사진=라이엇 게임즈. 젠지e스포츠가 LCK 사상 최초의 4연패를 달성한 날, G2 e스포츠 역시 포핏(4-Peat)에 성공했다. 이번 우승으로 G2는 리그 오브 레전드 EMEA 챔피언십(LEC) 14번째 우승에 성공했다.G2가 14일(현지 시각) 독일 베를린 라이엇 게임즈 아레나에서 펼쳐진 2024 LEC 스프링 결승전에...", "https://imgnews.pstatic.net/image/origin/347/2024/04/15/179578.jpg?type=nf472_236", "2024-04-15", 4),
    ("'쵸비' 정지훈, 앞머리 벌어지는 이유는? \"이마 열면 복 오더라\" [인터뷰]", "(엑스포츠뉴스 송파, 임재형 기자) 젠지 '쵸비' 정지훈이 최근 팬들이 제기한 '앞머리' 이야기에 대해 재치 있는 답변을 전달했다. 정지훈의 앞머리는 경기의 난도에 따라 크게 갈라지면서 팬들의 많은 관심을 받은 바 있다.젠지는 14일 오후 서울 송파 올림픽공원 KSPO돔에서 열린 '20...", "https://imgnews.pstatic.net/image/origin/311/2024/04/15/1714684.jpg?type=nf472_236", "2024-04-15", 5),
    ("글로벌 킬러 콘텐츠 LCK, 경주 서머 결승 통해 신라 천년의 문화 세계에 알린다", "LCK가 이번 여름에도 지방 결승을 진행한다. 이번에는 천년의 고도인 경주다.14일 서울 KSPO 돔에서 열린 2024 LCK 스프링 결승전이 끝난 후 경주에서 서머 결승전이 공개됐다. 이어 LCK는 오는 6월 12일 서머 스플릿을 시작하고, 9월 7일과 8일 경상북도 경주시 경주실내체육관에서 결승을 진행한다고 공개했다....", "https://imgnews.pstatic.net/image/origin/236/2024/04/15/241922.jpg?type=nf472_236", "2024-04-15", 6),
    ("젠지, 사상 첫 4연속 우승…기인 '무관의 설움' 벗었다 [LCK 결승]", "젠지 e스포츠가 13년 동안 진행된 LCK(리그오브레전드 챔피언스 코리아)에서 한 번도 나오지 않았던 4회 연속 우승이라는 대기록을 이뤄냈다. 젠지는 지난 14일 서울 송파구 올림픽공원 안에 위치한 KSPO돔(전 올", "https://imgnews.pstatic.net/image/origin/015/2024/04/15/4972853.jpg?type=nf472_236", "2024-04-15", 7),
    ("국내 최대 e스포츠 'LCK 서머 결승전' 경주 개최", "9월7~8일 경주체육관대회기간 팬페스타 진행 지난해 대전에서 열린 'LCK 스프링 결승전' (사진제공-경주시)경북 경주에서 오는 9월 국내 최대 e스포츠 대회인 '리그오브레전드 챔피언스 코리아(LCK) 서머 결승전'이 열린다.경주시는 LCK와 한국e스포츠협회가 주최·주관하는 '2024 LCK 서머 결승전 개최도시' 공모에...", "https://imgnews.pstatic.net/image/origin/009/2024/04/15/5288241.jpg?type=nf472_236", "2024-04-15", 8),
    ("'결승전 MVP'까지 겹경사... '기인' 김기인, \"첫 우승이 어렵다... 기세 이어갈 것\" [인터뷰]", "(엑스포츠뉴스 송파, 임재형 기자) 맹활약을 펼치면서 커리어 첫 우승을 달성한 '기인' 김기인이 국제전까지 기세를 이어 가겠다고 다짐했다.젠지는 14일 오후 서울 송파 올림픽공원 KSPO돔에서 열린 '2024 LOL 챔피언스 코리아(이하 LCK)' 스프링 시즌 플레이오프 결승전 T1과 경기서...", "https://imgnews.pstatic.net/image/origin/311/2024/04/15/1714641.jpg?type=nf472_236", "2024-04-15", 9),
    ("'무관' 벽을 넘으니 '포핏'이 있었다", "'쵸비' 정지훈이 14일 서울 송파구 KSPO돔에서 열린 2024 LoL 챔피언스 코리아(LCK) 스프링 시즌 플레이오프 결승전에서 T1을 상대로 3대 2로 승리했다. 사진=윤민섭 기자'쵸비' 정지훈이 LoL 챔피언스 코리아(LCK) 선수 최초로 '포핏'(리그 4연속 우승)을 달성했다. 팀인 젠지도 정지훈과 함께 전무후무...", "https://imgnews.pstatic.net/image/origin/005/2024/04/15/1688683.jpg?type=nf472_236", "2024-04-15", 10),
    ("Gen.G take down T1 3-2 to win fourth straight LCK championship", "Gen.G players lift the LCK 2024 Spring trophy after defeating T1 3-2 in the final round of the playoffs on Sunday at the KSPO Dome in southern Seoul. [NEWS1] Korean League of Legen...", "https://imgnews.pstatic.net/image/origin/640/2024/04/15/52539.jpg?type=nf472_236", "2024-04-15", 11),
    ("LCK 서머 결승전, 9월에 경주에서 열린다", "▲ LCK 로고 (사진제공: LCK)지난 14일 결승전으로 LCK 스프링이 마무리된 가운데, 서머 결승전 개최 일정과 장소가 공개됐다.LCK는 14일 스프링 결승전 종료 이후 서머 결승전에 대해 밝혔다. 서머 결승 진출전과 결승전은 9월 7일과 8일에 열리며, 장소는 경주시에 위치한 경주실내체육관이다. 경주시를 선정한 이...", "https://imgnews.pstatic.net/image/origin/356/2024/04/15/66147.jpg?type=nf472_236", "2024-04-15", 12),
    ("구관이 명관 G2, 프나틱 3:1로 꺾고 LEC 우승", "G2 e스포츠가 2024 LEC 스프링 우승을 차지했다.G2 e스포츠는 15일 새벽에 열린 2024 LEC 스프링 결승전에서 프나틱을 상대로 3:1로 승리하며 우승을 차지, MSI 진출까지 확정 지었다. 2024 LEC 스프링은 정규 시즌은 프나틱, 팀 바이탈리티, G2 e스포츠, 팀 헤레틱스 네 팀이 6승 3패를 거두며...", "https://imgnews.pstatic.net/image/origin/442/2024/04/15/171506.jpg?type=nf472_236", "2024-04-15", 13),
    ("[롤짤] 무관의 설움 스스로 끊어낸 기인", "RedHorN이 매주 월요일 올리는 [롤짤]은 리그 오브 레전드 e스포츠에서 일어난 일을 한 컷에 담는 코너입니다. RedHorN 작가는 네이버에서 LCK 요약툰을 연재했습니다.지난 14일에 젠지의 승리로 마무리된 2024 LCK 스프링 결승전에서는 '인간승리'라 부를 수 있는 값진 결과가 있었습니다. 데뷔 7년 만에 첫...", "https://imgnews.pstatic.net/image/origin/356/2024/04/15/66146.jpg?type=nf472_236", "2024-04-15", 14),
    (""우리는 기인을 울린 남자들", 유쾌한 '쵸비'의 LCK 최초 '포핏' 소회", "[OSEN=올림픽공원, 고용준 기자] "간절할 때 미신을 믿는 편이다. 이마를 열면 복이 들어온다고 하길래 앞머리를 열었다."1만 2000석이 빈틈 없이 꽉 들어찬 KSPO돔에서 세트를 거듭할 수록 '쵸비' 정지훈의 앞이마가 더 넓어졌다. '쵸비' 정지훈은...", "https://imgnews.pstatic.net/image/origin/109/2024/04/15/5058184.jpg?type=nf472_236", "2024-04-15", 15),
    ("아쉬운 마무리... 선수단 격려한 T1 김정균 감독 \"정말 고생했다\" [인터뷰]", "(엑스포츠뉴스 송파, 임재형 기자) 스프링 시즌을 위해 끝까지 노력한 T1 선수들에게 전하는 김정균 감독의 첫 마디는 \"정말 고생했다\"는 격려의 메시지였다.T1은 14일 오후 서울 송파 올림픽공원 KSPO돔에서 열린 2024 LCK 스프링 시즌 플레이오프 결승전에서 젠지에게 2대 3으로 패했다. 이로써 T1은 스프링 시즌...", "https://imgnews.pstatic.net/image/origin/311/2024/04/15/1714642.jpg?type=nf472_236", "2024-04-15", 16),
    ("젠지, LCK 사상 최초 4연속 우승…14일 KSPO돔서 T1 꺾어", "젠지e스포츠가 13년 동안 진행된 리그 오브 레전드 챔피언스 코리아(LCK)에서 한 번도 나오지 않았던 4회 연속 우승을 달성했다.젠지는 14일 오후 서울 송파구 올림픽공원 안에 위치한 KSPO돔에서 열린 2024 리그 오브 레전드 챔피언스 코리아 스프링 플레이오프 결승전에서 T1과 대결, 3승 2패로 승리했다....", "https://imgnews.pstatic.net/image/origin/015/2024/04/15/4972777.jpg?type=nf472_236", "2024-04-15", 17);

INSERT INTO news (title, content, thumbnail, date, index)
VALUES ("T1의 11번째 우승 노리는 '구마유시', \"평소대로 하면 될 것\"", "T1 '구마유시' 이민형. T1의 '구마유시' 이민형이 젠지e스포츠와의 결승전을 앞두고 각오를 다졌다.T1이 13일 서울 송파구 방이동 KSPO 돔에서 진행된 2024 리그 오브 레전드 챔피언스 코리아 스프링 플레이오프 결승 진출전서 한화생명e스포츠를 3 대 1로 제압했다. 이날 승리로 6시즌 연속 LCK 결승 무대를 밟...", "https://imgnews.pstatic.net/image/origin/347/2024/04/13/179524.jpg?type=nf472_236", "2024-04-13", 0),
       ("LCK 결승 진출전 결승 진출한 T1 \"V11? 평소처럼 하면 자신 있어\"", "T1이 13일 서울 송파구 올림픽 공원 내 KSPO돔에서 펼쳐진 '2024 LoL 챔피언스 코리아(이하 LCK)' 스프링 스플릿 결승 진출전에서 한화생명e스포츠를 3:1로 잡고 결승에 진출했다. 오늘 승리로 T1은 한화생명에게 지난 경기 복수에 성공했고, 젠지와 5연속 결승에서 만나게 됐다. 또한, 결승 진출로 인해 MS...", "https://imgnews.pstatic.net/image/origin/442/2024/04/13/171489.jpg?type=nf472_236", "2024-04-13", 1),
       ("김정균 감독, '한화생명전 자신감의 근거 선수단, 선수들과 꼭 너무 우승하고 파'", "[OSEN=올림픽공원, 고용준 기자] '11번째 우승에 의미를 부여하기 보다, 지금 같이 하고 싶은 선수들과 꼭 우승하고 싶은 마음이 먼저에요.:'취재진과 공식 인터뷰를 끝내고 만난 김정균 T1 감독은 11번째 우승의 의미를 부여하기 보다 제자들과 함께 이뤄내고 싶은 목표에 대한 갈망을 드러냈다. 김...", "https://imgnews.pstatic.net/image/origin/109/2024/04/13/5057544.jpg?type=nf472_236", "2024-04-13", 2),
       ("[LCK] '젠지의 4연속 우승, 저희가 막겠습니다'", "결승에 오른 구마유시가 팬들 앞에서 젠지의 4연속 우승을 막겠다는 각오를 팬들 앞에서 전했다. 13일 서울 KSPO 돔에서 열린 2024 LCK 스프링 플레이오프 최종 결승 진출전에서 상대인 한화생명e스포츠를 3대", "https://imgnews.pstatic.net/image/origin/236/2024/04/13/241893.jpg?type=nf472_236", "2024-04-13", 3),
       ("'첫 결승 기회, 절실했는데' 한화생명 최인규 감독 아쉬움 그리고 서머를 향한 각오 [SS인터뷰]", "한화생명 최인규 감독(왼쪽)과 '피넛' 한왕호가 경기 후 인터뷰를 하고 있다. 송파=김민규기자 kmg@sportsseoul.com[스포츠서울 | 송파=김민규 기자] '첫 결승 기회 절실하게 준비했는데 패배 아쉽다.'정규리그를 '3위'로 마쳤지만 플레이오프(PO)를 거치며 기세를 탔다. T1을 세트스코어 3-0으로 물리쳤고...", "https://imgnews.pstatic.net/image/origin/468/2024/04/13/1049936.jpg?type=nf472_236", "2024-04-13", 4),
       ("폰 배경화면까지 T1…'구마유시' 이민형의 팀 사랑", "'T1의 프랜차이즈 스타'는 하루에도 수십 번 팀의 엠블럼을 쳐다본다.T1은 13일 서울 송파구 KSPO돔에서 열린 2024 LoL 챔피언스 코리아(LCK) 스프링 시즌 플레이오프 결승 진출전에서 한화생명e스포츠에 3대 1로 역전승했다. 이날 승리로 14일 같은 장소에서 열리는 결승전에 진출했다.경기 시작에 앞서 양 팀...", "https://imgnews.pstatic.net/image/origin/008/2024/04/13/2716626.jpg?type=nf472_236", "2024-04-13", 5),
       ("[LCK 스프링 플레이오프 결승 진출전] T1 이민형, 젠지에게 건넨 미소", "T1 '구마유시' 이민형. 사진=오윤석 기자김재현(T1 '구마유시'이민형)이 젠지에게 미소를 건네고 있다.김재현(T1 '구마유시' 이민형)이 13일 서울 송파구 KSPO 돔에서 열린 '2024 리그 오브 레전드 챔피언스 코리아(LCK)' 스프링 시즌 플레이오프 결승 진출전에서 한화생명e스포츠를 3대 1로 물리쳤다.", "https://imgnews.pstatic.net/image/origin/468/2024/04/13/1049934.jpg?type=nf472_236", "2024-04-13", 6),
       ("“구마유시 전성기? 승리할 수 있을 것 같다” T1 김정균 감독", "T1이 13일 서울 송파구 KSPO돔에서 진행된 2024 리그 오브 레전드 챔피언스 코리아 스프링 플레이오프 결승 진출전서 한화생명e스포츠를 3대 1로 이겼다. 이날 승리로 T1은 한화생명에게 지난 경기 복수에 성공했다. 또한 젠지와 결승전에 진출했다. 경기 후 인터뷰에서 김정균 T1 감독은 '구마유시'의 전성기에 대해 승리할 수 있을 것 같다고 말...", "https://imgnews.pstatic.net/image/origin/442/2024/04/13/171493.jpg?type=nf472_236", "2024-04-13", 7),
       ("T1, 한화생명 제압하고 스프링 결승 진출…한화생명은 플레이오프 3위 잔류", "T1이 한화생명을 제압하고 2024 LoL 챔피언스 코리아(이하 LCK) 스프링 시즌의 결승에 진출했다. T1은 13일 서울 송파구 KSPO돔에서 열린 LCK 스프링 시즌 플레이오프 결승 진출전에서 한화생명을 3대 1로 꺾었다. 이날 승리로 T1은 한화생명에게 지난 경기 복수에 성공했고, 젠지와 5연속 결승에서 만나게 됐다. 결승...", "https://imgnews.pstatic.net/image/origin/417/2024/04/13/286950.jpg?type=nf472_236", "2024-04-13", 8),
       ("[리그 오브 레전드 챔피언스 코리아 스프링] T1, 한화생명 꺾고 결승 진출", "T1(이하 T1)이 한화생명을 꺾고 2024 LoL 챔피언스 코리아(이하 LCK) 스프링 시즌의 결승에 진출했다. T1은 13일 서울 송파구 KSPO돔에서 열린 LCK 스프링 시즌 플레이오프 결승 진출전에서 한화생명을 3대 1로 물리쳤다. 이날 승리로 T1은 한화생명에게 지난 경기 복수에 성공했고, 젠지와 5연속 결승에서 만나게 됐다....", "https://imgnews.pstatic.net/image/origin/109/2024/04/13/5057545.jpg?type=nf472_236", "2024-04-13", 9),
       ("[LCK 스프링] 한화생명, 결승 진출 실패…불펜이 고전", "한화생명 e스포츠가 T1에게 1대 3으로 패해 결승 진출을 놓쳤다.이날 2024 리그 오브 레전드 챔피언스 코리아 스프링 시즌 플레이오프 결승 진출전에서 한화생명은 T1에게 1대 3으로 패했다.결승 진출을 놓치며 팀의 시즌이 마무리됐다.한화생명의 강점은 불펜이었다.하지만 이날 경기에서는 팀의 주력이 벌칙을...", "https://imgnews.pstatic.net/image/origin/119/2024/04/13/209144.jpg?type=nf472_236", "2024-04-13", 10),
       ("[LCK] T1, 한화생명에 완승... 결승 진출", "T1이 한화생명을 꺾고 2024 LoL 챔피언스 코리아(이하 LCK) 스프링 시즌의 결승에 진출했다. T1은 13일 서울 송파구 KSPO돔에서 열린 LCK 스프링 시즌 플레이오프 결승 진출전에서 한화생명을 3대 1로 물리쳤다. 결승 진출에 성공하면서 T1은 한화생명에게 지난 경기 복수에 성공했다.결승 상대는 젠지다....", "https://imgnews.pstatic.net/image/origin/001/2024/04/13/14035114.jpg?type=nf472_236", "2024-04-13", 11),
       ("이민형, 한화생명에 ‘패기’…T1, 승리로 결승행", "김재현(T1 '구마유시'이민형)이 한화생명의 디펜스를 찢으며 뛰어간다. 사진=오윤석 기자김재현(T1 '구마유시'이민형)이 한화생명의 디펜스를 뚫고 전진하고 있다.김재현(T1 '구마유시'이민형)이 한화생명의 적들을 상대로 힘을 주고 있다.김재현(T1 '구마유시'이민형)이 한화생명의 적들을 상대로 힘을 주고 있다.김재현(T1 '구마유시'이민형)이 한화생명...", "https://imgnews.pstatic.net/image/origin/468/2024/04/13/1049932.jpg?type=nf472_236", "2024-04-13", 12),
       ("[리그 오브 레전드 챔피언스 코리아 스프링] T1, 결승 진출...한화생명 퇴출", "T1이 한화생명을 꺾고 2024 LoL 챔피언스 코리아(이하 LCK) 스프링 시즌의 결승에 진출했다. T1은 13일 서울 송파구 KSPO돔에서 열린 LCK 스프링 시즌 플레이오프 결승 진출전에서 한화생명을 3대 1로 물리쳤다. 결승 진출에 성공하면서 T1은 한화생명에게 지난 경기 복수에 성공했다.결승 상대는 젠지다....", "https://imgnews.pstatic.net/image/origin/109/2024/04/13/5057544.jpg?type=nf472_236", "2024-04-13", 13),
       ("[리그 오브 레전드 챔피언스 코리아 스프링] T1, 결승 진출…한화생명 퇴출", "T1이 한화생명을 꺾고 2024 LoL 챔피언스 코리아(이하 LCK) 스프링 시즌의 결승에 진출했다. T1은 13일 서울 송파구 KSPO돔에서 열린 LCK 스프링 시즌 플레이오프 결승 진출전에서 한화생명을 3대 1로 물리쳤다. 결승 진출에 성공하면서 T1은 한화생명에게 지난 경기 복수에 성공했다.결승 상대는 젠지다....", "https://imgnews.pstatic.net/image/origin/417/2024/04/13/286950.jpg?type=nf472_236", "2024-04-13", 14),
       ("[리그 오브 레전드 챔피언스 코리아 스프링] T1, 한화생명 제압하고 결승 진출", "T1(이하 T1)이 한화생명을 제압하고 2024 LoL 챔피언스 코리아(이하 LCK) 스프링 시즌의 결승에 진출했다. T1은 13일 서울 송파구 KSPO돔에서 열린 LCK 스프링 시즌 플레이오프 결승 진출전에서 한화생명을 3대 1로 물리쳤다. 이날 승리로 T1은 한화생명에게 지난 경기 복수에 성공했고, 젠지와 5연속 결승에서 만나게 됐다....", "https://imgnews.pstatic.net/image/origin/001/2024/04/13/14035112.jpg?type=nf472_236", "2024-04-13", 15);

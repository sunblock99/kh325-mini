--유저 정보 테이블
DROP TABLE USERINFO CASCADE CONSTRAINTS;
CREATE TABLE USERINFO(
    UNO     NUMBER,
	ID 	        VARCHAR2(100) NOT NULL UNIQUE,
	PASSWORD 	VARCHAR2(100) NOT NULL,
	NAME        VARCHAR2(100) NOT NULL,
    PRIMARY KEY (UNO)
);

DROP SEQUENCE SEQ_USERNO;
CREATE SEQUENCE SEQ_USERNO;

INSERT INTO USERINFO VALUES(SEQ_USERNO.NEXTVAL, 'test1','1234','홍길동');
INSERT INTO USERINFO VALUES(SEQ_USERNO.NEXTVAL, 'test2','1234','최길동');

SELECT * FROM USERINFO;



--------------------------------------------------------------------------------



-- 경주마 정보 테이블
DROP TABLE HORSE_INFO CASCADE CONSTRAINTS;
CREATE TABLE HORSE_INFO(
    hrNo	    VARCHAR2(10)		NOT NULL,
	meet	    VARCHAR2(50),
	hrName	    VARCHAR2(30),
	name	    VARCHAR2(200),
	sex	        VARCHAR2(50),
	birthday	VARCHAR2(50),
	rank	    VARCHAR2(30),
	faHrName	VARCHAR2(30),
	moHrName	VARCHAR2(30),
	rcCntT	    NUMBER,
	ord1CntT	NUMBER,
	ord2CntT	NUMBER,
	ord3CntT	NUMBER,
	chaksunT	NUMBER,
	hrLastAmt	VARCHAR2(100),
    PRIMARY KEY (hrNo)
);

INSERT INTO
HORSE_INFO(hrNo, meet, hrName, name, sex, birthday, rank,
            faHrName, moHrName, rcCntT, ord1CntT, ord2CntT, 
            ord3CntT, chaksunT, hrLastAmt) 
VALUES(1, '이히힝 경마장', '짱빠른', '한국', '암', '20101010', 
        '국6', '짱아빠', '짱엄마', 10, 3, 2, 1, 3000000, '6000만원');
        
INSERT INTO
HORSE_INFO(hrNo, meet, hrName, name, sex, birthday, rank,
            faHrName, moHrName, rcCntT, ord1CntT, ord2CntT, 
            ord3CntT, chaksunT, hrLastAmt) 
VALUES(2, '이히힝 경마장', '개빠른', '미국', '수', '20200220', 
        '외6', '개아빠', '개엄마', 15, 3, 4, 5, 2000000, '3000만원');     
     
        
-- 마명 / 마번 / 출주회수 / 도입가 / 상금 순으로 10개
-- 전체 조회
SELECT * FROM HORSE_INFO ORDER BY '1'; 

-- 마명으로 경주마 검색
SELECT * FROM HORSE_INFO WHERE hrName LIKE '%개%'; 

-- 마번으로 경주마 검색
SELECT * FROM HORSE_INFO WHERE hrNo LIKE '1004'; 

-- 통산총출주회수(rcCntT) 높은순서대로  1-10등까지 출력
SELECT ROWNUM, rct.* 
FROM (  SELECT hrno, hrname, sex, birthday, rcCntT
        FROM HORSE_INFO
        ORDER BY rcCntT DESC) rct
WHERE ROWNUM <= 10;

-- 말도입가(hrLastAmt) 높은 순서대로 1-10등까지 출력
SELECT ROWNUM, price.* FROM(
    SELECT hrno, hrname, sex, birthday, REGEXP_REPLACE(hrLastAmt, '[^0-9]+') AS "말 도입가" FROM horse_info
    Where REGEXP_REPLACE(hrLastAmt, '[^0-9]+') is not null
    ORDER BY to_number(REGEXP_REPLACE(hrLastAmt, '[^0-9]+')) desc) price
where ROWNUM <= 10;

-- 통산 착순상금(chaksunT) 높은순서대로 1-10등까지 출력
SELECT ROWNUM, reward.* 
FROM (  SELECT hrno, hrname, sex, birthday, chaksunT
        FROM HORSE_INFO
        ORDER BY chaksunT DESC) reward
WHERE ROWNUM <= 10;





--------------------------------------------------------------------------------


-- 기수정보 테이블
DROP TABLE JOCKEY CASCADE CONSTRAINTS;
CREATE TABLE JOCKEY(
    jkNo            VARCHAR2(6),         --  기수 번호
    jkName          VARCHAR2(20),      --  기수 명
    meet            VARCHAR2(10),      --  시행경마장명
    age             NUMBER(3),         --  나이
    debut           DATE,              --  데뷔일자
    rcCntT          NUMBER(5),         --  통산총출주횟수
    ord1CntT        NUMBER(5),         --  통산1착횟수
    ord2CntT        NUMBER(5),         --  통산2착횟수
    ord3CntT        NUMBER(5),         --  통산3착횟수
    PRIMARY KEY (jkNo)
);

-- 기수명으로 검색 (부분 허용)
SELECT * FROM JOCKEY WHERE jkName LIKE '%길동%'; 

-- 기수 번호로 조회
SELECT * FROM JOCKEY WHERE jkNo = 1;

-- 총 출주가 높은 횟수 랭킹10
SELECT ROWNUM, E.*
FROM(SELECT * FROM JOCKEY ORDER BY rcCntT DESC) E
WHERE ROWNUM BETWEEN 1 AND 10;

-- 1착.2착.3착 횟수 비교후 도합 가장 높은 순서대로 1-10등까지 출력
SELECT ROWNUM, E.*
FROM(SELECT * FROM JOCKEY ORDER BY ord1CntT DESC, ord2CntT DESC, ord3CntT DESC) E
WHERE ROWNUM BETWEEN 1 AND 10;




--------------------------------------------------------------------------------



-- 말즐겨찾기 테이블

DROP TABLE FAVORITE_HORSE CASCADE CONSTRAINTS;

CREATE TABLE FAVORITE_HORSE(
    HNO	NUMBER	        NOT NULL, -- 말즐겨찾기번호
    hrNo     VARCHAR2(1000) 	NOT NULL, -- 마번
    UNO	NUMBER	        NOT NULL, --회원번호
    PRIMARY KEY (HNO), -- 주키로 설정
    FOREIGN KEY (hrNo) REFERENCES HORSE_INFO,
    FOREIGN KEY (UNO) REFERENCES USERINFO
);

ALTER TABLE FAVORITE_HORSE MODIFY hrNo VARCHAR2(1000);
ALTER TABLE FAVORITE_HORSE ADD(hrName VARCHAR2(1000));
ALTER TABLE FAVORITE_HORSE DROP COLUMN HRNAME;

DROP SEQUENCE SEQ_FAV_HORSENO;
CREATE SEQUENCE SEQ_FAV_HORSENO;


-- 즐겨찾기 번호 /회원번호 / 마번/ 마명 = 전체 출력
SELECT DISTINCT FH.HNO, FH.UNO, FH.hrNo, H.hrName
FROM FAVORITE_HORSE FH, USERINFO U, HORSE_INFO H  
WHERE FH.hrNo = H.hrNo AND FH.UNO = U.UNO AND FH.UNO = 1;

-- 즐겨찾기 테이블에서 말이름를 입력받아서 해당하는 즐겨찾기 한 회원번호/마명/마번/생년월일 출력
SELECT DISTINCT u.uno, H.hrName, H.hrNo, H.birthday 
FROM FAVORITE_HORSE FH, USERINFO U, HORSE_INFO H 
WHERE FH.hrNo = H.hrNo AND FH.UNO = U.UNO AND FH.UNO = 1 AND H.hrName LIKE '%짱빠른%';

-- 즐겨찾기 테이블에서 마번을 입력받아서 해당하는 즐겨찾기 한 회원번호/마명/마번/생년월일 출력
SELECT DISTINCT u.uno, H.hrName, H.hrNo, H.birthday
FROM FAVORITE_HORSE FH, USERINFO U, HORSE_INFO H 
WHERE FH.hrNo = H.hrNo AND FH.UNO = U.UNO AND FH.UNO = 1 H.hrNo LIKE '1004';


-- 즐겨찾기 테이블에서 즐겨찾기 번호를 입력받아서 해당하는 즐겨찾기 된 마명/마번/생년월일 출력
SELECT H.hrName, FH.hrNo, H.birthday
FROM FAVORITE_HORSE FH, USERINFO U, HORSE_INFO H
WHERE FH.hrNo = H.hrNo AND FH.UNO = U.UNO AND FH.UNO = 1 AND FH.HNO = 1;


--------------------------------------------------------------------------------


--기수 즐겨찾기 테이블
DROP TABLE FAVORITE_JOCKEY CASCADE CONSTRAINTS;
CREATE TABLE FAVORITE_JOCKEY(
    JNO              NUMBER,
    jkNo           	VARCHAR2(1000), 
    UNO              NUMBER,
    PRIMARY KEY (JNO),
    FOREIGN KEY (jkNo) REFERENCES JOCKEY,
    FOREIGN KEY (UNO) REFERENCES USERINFO
);

ALTER TABLE FAVORITE_JOCKEY MODIFY jkNo VARCHAR2(1000);

DROP SEQUENCE SEQ_FAV_JOCKEY_NO; 
CREATE SEQUENCE SEQ_FAV_JOCKEY_NO;




-- 즐겨찾기 번호/회원번호 / 기수번호/ 기수명 = 전체 출력 
SELECT DISTINCT FJ.JNO, FJ.UNO, J.jkNo, J.jkName
FROM FAVORITE_JOCKEY FJ, USERINFO U, JOCKEY J  
WHERE FJ.jkNo = J.jkNo AND FJ.UNO = u.uno;

-- 즐겨찾기 테이블에서 기수이름을 입력받아서 해당하는 즐겨찾기 한 회원번호/기수명/기수번호 출력
SELECT DISTINCT u.uno, j.jkname, j.jkno
FROM FAVORITE_JOCKEY FJ, USERINFO U, JOCKEY J  
WHERE FJ.jkNo = J.jkNo AND FJ.UNO = u.uno AND FJ.UNO = 1 AND j.jkname LIKE '홍길동';

-- 즐겨찾기 테이블에서 마번을 입력받아서 해당하는 즐겨찾기 한 회원번호/기수명/기수번호 출력
SELECT DISTINCT u.uno, j.jkname, j.jkno
FROM FAVORITE_JOCKEY FJ, USERINFO U, JOCKEY J  
WHERE FJ.jkNo = J.jkNo AND FJ.UNO = u.uno AND FJ.UNO = 1 AND j.jkno LIKE '1';


-- 즐겨찾기  테이블에서 즐겨찾기 번호를 입력받아서 해당하는 즐겨찾기 된 기수명/기수번호 출력
SELECT DISTINCT j.jkname, j.jkno
FROM FAVORITE_JOCKEY FJ, USERINFO U, JOCKEY J  
WHERE FJ.jkNo = J.jkNo AND FJ.UNO = u.uno AND FJ.UNO = 1 AND fj.jno LIKE '1';

----<강사님이 짜주신 insert 쿼리>
--INSERT INTO FAVORITE_HORSE (HNO ,hrNo ,hrName ,UNO) 
--VALUES (
-- SEQ_FAV_HORSENO.NEXTVAL,
-- (SELECT hrNo from HORSE_INFO where hrName = '거제도'),
-- (SELECT hrName from HORSE_INFO where hrName = '거제도'),
-- '1'
--);


--------------------------------------------------------------------------------



-- 경주정보 테이블
DROP TABLE RC_INFO CASCADE CONSTRAINTS;
CREATE TABLE RC_INFO (
	RNO NUMBER NOT NULL,
	rcDate VARCHAR2(1000) NULL,
	rcNo NUMBER NULL,
	rcDist NUMBER NULL,
	rcOrd	NUMBER NULL,
	rcTime NUMBER NULL,
	rcChul NUMBER NULL,
	hrNo	VARCHAR2(1000) NULL,
	hrName VARCHAR2(1000) NULL,
	wgHr	NUMBER NULL,
	jkNo	VARCHAR2(1000) NULL,
	jkName VARCHAR2(1000) NULL,
	chaksun NUMBER NULL,
    weath	VARCHAR2(1000) NULL
);

DROP SEQUENCE SEQ_BOX_NO;
CREATE SEQUENCE SEQ_BOX_NO;


-- 날짜 + 경기번호로 검색
SELECT * FROM rc_info 
WHERE rcDate 
LIKE '20191222' AND rcNo 
LIKE 1 ORDER BY rcOrd ASC;

-- 마명으로 검색
SELECT * FROM rc_info
WHERE hrName
LIKE '%원%'
ORDER BY RNO ASC;

-- 기수명으로 검색
SELECT * FROM rc_info
WHERE jkName
LIKE '%이%'
ORDER BY RNO ASC;











select * from favorite_horse;
select * from favorite_jockey;
select * from horse_info;
select * from jockey;
select * from rc_info;
select * from userinfo;


--------------------------------------------------------------------------------
-- 부대시설 테이블

DROP TABLE racefacility CASCADE CONSTRAINTS;
CREATE TABLE racefacility (
    fltseq            VARCHAR2(1000),
    flttitle          VARCHAR2(1000),
    fltecodename      VARCHAR2(1000),
    fltendday         VARCHAR2(1000),
    flthour           VARCHAR2(1000),
    fltlcodename      VARCHAR2(1000),
    fltmcodename      VARCHAR2(1000),
    fltobjtext        VARCHAR2(1000),
    fltpositionadd    VARCHAR2(1000),
    fltrentstatusname VARCHAR2(1000),
    fltscodename      VARCHAR2(1000),
    
    fltstatusname     VARCHAR2(1000),
    flttext           VARCHAR2(1000),
    PRIMARY KEY ( fltseq )
);
-- 부대시설명(fltTitle)으로 검색하기
SELECT * FROM racefacility WHERE flttitle LIKE '%편%'; 

--마권사는곳
SELECT * FROM racefacility WHERE fltecodename LIKE '마권사는곳'; 

--먹거리
SELECT * FROM racefacility WHERE fltecodename LIKE '먹거리'; 

--볼거리
SELECT * FROM racefacility WHERE fltecodename LIKE '볼거리'; 

--즐길거리
SELECT * FROM racefacility WHERE fltecodename LIKE '즐길거리'; 

--편의시설
SELECT * FROM racefacility WHERE fltecodename LIKE '편의시설'; 

--회원전용실
SELECT * FROM racefacility WHERE fltecodename LIKE '회원전용실'; 

--기타
SELECT * FROM racefacility WHERE fltecodename IS NULL ; 

SELECT * FROM racefacility ORDER BY TO_NUMBER(fltseq);


alter system set open_cursors = 5000 scope=both;



COMMIT;
--ROLLBACK;
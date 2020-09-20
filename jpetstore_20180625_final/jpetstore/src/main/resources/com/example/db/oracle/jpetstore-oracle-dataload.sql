insert into SEQUENCE values('seq_post',1000);
insert into SEQUENCE values('seq_answer',1000);
insert into SEQUENCE values('seq_category',1000);
insert into SEQUENCE values('seq_product',1000);
insert into SEQUENCE values('seq_bid',1000);
insert into SEQUENCE values('seq_banner',1000);
insert into SEQUENCE values('seq_advertisement',1000);
insert into SEQUENCE values('seq_complain',1000);
insert into SEQUENCE values('seq_item',1000);
insert into SEQUENCE values('seq_auction',1000);
insert into SEQUENCE values('linenum',1000);
insert into SEQUENCE values('ordernum',1000);
insert into SEQUENCE values('seq_question',1000);

update ACCOUNT set ONBLACKLIST = '0';
insert into COMPLAIN values(seq_complain.nextval,'j2ee', '-', '/shop/viewItem.do?itemId=1024&isAuction=on',sysdate,'admin', null,null);
insert into COMPLAIN values(seq_complain.nextval,'j2ee', '-', '/shop/blackList.do?seller=j2ee&itemId=1058',sysdate,'admin', null,null);
insert into COMPLAIN values(seq_complain.nextval,'j2ee', '-', '/shop/blackList.do?seller=j2ee&itemId=1058',sysdate,'admin', null,null);
insert into COMPLAIN values(seq_complain.nextval,'j2ee', '-', '/shop/blackList.do?seller=j2ee&itemId=1058',sysdate,'admin', null,null);
insert into COMPLAIN values(seq_complain.nextval,'j2ee', '-', '/shop/blackList.do?seller=j2ee&itemId=1058',sysdate,'admin', null,null);
insert into COMPLAIN values(seq_complain.nextval,'j2ee', '-', '/shop/blackList.do?seller=j2ee&itemId=1058',sysdate,'admin', null,null);
insert into COMPLAIN values(seq_complain.nextval,'j2ee', '-', '/shop/blackList.do?seller=j2ee&itemId=1058',sysdate,'admin', null,null);
insert into COMPLAIN values(seq_complain.nextval,'j2ee', '-', '/shop/blackList.do?seller=j2ee&itemId=1058',sysdate,'admin', null,null);
insert into COMPLAIN values(seq_complain.nextval,'j2ee', '-', '/shop/blackList.do?seller=j2ee&itemId=1058',sysdate,'admin', null,null);
insert into COMPLAIN values(seq_complain.nextval,'j2ee', '-', 'b',sysdate,'admin', null,null);
insert into COMPLAIN values(seq_complain.nextval,'j2ee', '-', 'b',sysdate,'admin', null,null);
insert into COMPLAIN values(seq_complain.nextval,'j2ee', '-', 'b',sysdate,'admin', null,null);

--delete from complain 

  	DELETE FROM COMPLAIN
  	WHERE page = (SELECT PAGE
    FROM (SELECT * FROM COMPLAIN WHERE BLACKID = 'j2ee')
	GROUP BY PAGE
	HAVING COUNT(PAGE)>10);
	
	update ACCOUNT set email = 'springtest45@gmail.com';
	
	update account set now_mileage = (select now_mileage from ACCOUNT where userid='j2ee') + 1000 where userid='j2ee'
	
	
	
	    SELECT SIGNON.USERNAME AS USER_ID,
      ACCOUNT.EMAIL,
      ACCOUNT.FIRSTNAME,
      ACCOUNT.LASTNAME,
      ACCOUNT.STATUS,
      ACCOUNT.ADDR1 AS address1,
      ACCOUNT.ADDR2 AS address2,
      ACCOUNT.CITY,
      ACCOUNT.STATE,
      ACCOUNT.ZIP,
      ACCOUNT.COUNTRY,
      ACCOUNT.PHONE,
      ACCOUNT.SEX,
      ACCOUNT.NOW_MILEAGE AS nowMileage,
      ACCOUNT.ONBLACKLIST,
      PROFILE.LANGPREF AS languagePreference,
      PROFILE.FAVCATEGORY AS favouriteCategoryId,
      PROFILE.MYLISTOPT AS listOption,
      PROFILE.BANNEROPT AS bannerOption,
      BANNER.BANNERNAME
    FROM ACCOUNT, PROFILE, SIGNON, BANNER
    WHERE ACCOUNT.USERID = 'j2ee'
      AND SIGNON.PASSWORD = 'j2ee'
      AND SIGNON.USERNAME = ACCOUNT.USERID
      AND PROFILE.USERID = ACCOUNT.USERID
      AND PROFILE.FAVCATEGORY = BANNER.FAVCATEGORY;
      
      update INVENTORY set qty = 100;
      

create table complain (
    complain_id int not null,
    blackid varchar(80) not null,
    blackreason varchar(255) null,
    page varchar(80) not null,
    datetime date not null,
    complainant varchar(80) not null,
    temp1 varchar(30),
    temp2 varchar(30),
    constraint pk_complain_id primary key (complain_id),
    constraint fk_blacklist_1 foreign key (blackid)
        references account (userid),
    constraint fk_blacklist_2 foreign key (complainant)
        references account (userid)
);
drop table complain;
delete from sequence where name='seq_complain';
drop SEQUENCE seq_complain;
insert into SEQUENCE values('seq_complain',1000);
create sequence seq_complain increment by 1 cache 10000;


      SELECT count(*)
      FROM COMPLAIN
      WHERE PAGE = '/shop/blackList.do?seller=j2ee&itemId=1058'
      AND COMPLAINANT = 'admin';
      
      
      delete from COMPLAIN where page='/shop/blackList.do?seller=j2ee&itemId=1058';
      
      
        SELECT
  	ITEM.SELLER AS seller,
  	ITEM.ITEMID AS itemid,
  	START_DATE AS startDate,
  	END_DATE AS endDate,
  	ADVERTISEMENT.IMAGE,
  	ADVERTISEMENT.TITLE
  FROM ADVERTISEMENT, ITEM
  WHERE
  	ITEM.ITEMID = ADVERTISEMENT.ITEMID;
  	AND ITEM.ISAD = '1';
      
insert into advertisement values(fish); 	
 
      update orders set userId='j2ee';
      
      
      insert into product values(12,'DOGS', '불독', 'test', null, null);
      
    drop sequence linenum;
create sequence ordernum;
drop sequence seq_complain;



CREATE SEQUENCE seq_post START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_question START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_answer START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_category START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_product START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_auction START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_bid START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_mileage START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_banner START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_item START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_orders START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE ordernum START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_advertisement START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_complain START WITH 1 INCREMENT BY 1;



create table USER(
	user_name varchar(15) NOT NULL,
	user_id varchar(10) PRIMARY KEY,#중복확인
	user_pwd varchar(10) NOT NULL
);
create table CATEGORY(
	category_id varchar(15) PRIMARY KEY,
	category_name varchar(15)
);
CREATE TABLE IMAGES( 
	img_id varchar(15) NOT NULL, 
	img mediumblob NOT NULL,
	img_title varchar(100) NOT NULL,
	img_width smallint(6) NOT NULL,  
	img_height smallint(6) NOT NULL,
	img_filesize int , # 파일크기 
	PRIMARY KEY (img_id)
 ); 
create table PRODUCTS(
	pro_url varchar(50) PRIMARY KEY,#기본키
	pro_name varchar(30),
	pro_price int,
	img_id varchar(15),
	category_id varchar(15),
	FOREIGN KEY (img_id) REFERENCES IMAGES(img_id)
	ON UPDATE CASCADE
	ON DELETE NO ACTION,
	FOREIGN KEY (category_id) REFERENCES CATEGORY(category_id)
	ON UPDATE CASCADE
	ON DELETE NO ACTION
);
create table WISH(
	user_id varchar(10),
	pro_url varchar(50),
	wish_date DATE,
	FOREIGN KEY (user_id) REFERENCES USER(user_id)
	ON UPDATE CASCADE
	ON DELETE NO ACTION,
	FOREIGN KEY (pro_url) REFERENCES PRODUCTS(pro_url)
	ON UPDATE CASCADE
	ON DELETE NO ACTION,
	CONSTRAINT wish_PK PRIMARY KEY (user_id,pro_url)
);

/* Drop Tables */

DROP TABLE IF EXISTS profiles;
DROP TABLE IF EXISTS sections;
DROP TABLE IF EXISTS departments;
DROP TABLE IF EXISTS divisions;
DROP TABLE IF EXISTS enter_months;
DROP TABLE IF EXISTS images;




/* Create Tables */

-- 部署マスタ
CREATE TABLE departments
(
	-- id
	id serial NOT NULL UNIQUE,
	-- 事業部マスタのid
	divisions_id int NOT NULL,
	-- 部署名
	name varchar(32) NOT NULL,
	-- 削除フラグ
	delete_flg boolean DEFAULT 'false' NOT NULL,
	-- 登録日
	created timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
	-- 更新日
	modified timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
	CONSTRAINT departments_pkey PRIMARY KEY (id),
	CONSTRAINT departments_unique_divisions_id_name UNIQUE (divisions_id, name)
) WITHOUT OIDS;


ALTER SEQUENCE departments_id_SEQ INCREMENT 1 MINVALUE 1;


-- 事業部マスタ
CREATE TABLE divisions
(
	-- id
	id serial NOT NULL UNIQUE,
	-- 事業部名
	name varchar(32) NOT NULL CONSTRAINT divisions_unique_name UNIQUE,
	-- 削除フラグ
	delete_flg boolean DEFAULT 'false' NOT NULL,
	-- 登録日
	created timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
	-- 更新日
	modified timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
	CONSTRAINT divisions_pk PRIMARY KEY (id)
) WITHOUT OIDS;


ALTER SEQUENCE divisions_id_SEQ INCREMENT 1 MINVALUE 1;


-- 入社月テーブル
CREATE TABLE enter_months
(
	-- id
	id serial NOT NULL UNIQUE,
	-- 入社月
	enter_month varchar(6) NOT NULL UNIQUE,
	-- 登録日
	created timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
	-- 更新日
	modified timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
	CONSTRAINT enter_months_pkey PRIMARY KEY (id)
) WITHOUT OIDS;


ALTER SEQUENCE enter_months_id_SEQ INCREMENT 1 MINVALUE 1;


-- 画像テーブル
CREATE TABLE images
(
	-- id
	id serial NOT NULL UNIQUE,
	-- ファイル名
	file_name varchar(256) NOT NULL UNIQUE,
	-- 登録日
	created timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
	-- 更新日
	modified timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
	CONSTRAINT images_pkey PRIMARY KEY (id)
) WITHOUT OIDS;


ALTER SEQUENCE images_id_SEQ INCREMENT 1 MINVALUE 1;


-- 社員紹介テーブル
CREATE TABLE profiles
(
	-- id
	id serial NOT NULL UNIQUE,
	-- 部課マスタのid
	sections_id int NOT NULL,
	-- 入社月テーブルのid
	enter_months_id int NOT NULL,
	-- 画像テーブルのid
	images_id int NOT NULL,
	-- 名字
	last_name varchar(16) NOT NULL,
	-- 名前
	first_name varchar(16) NOT NULL,
	-- 名字かな
	last_name_kana varchar(16) NOT NULL,
	-- 名前かな
	first_name_kana varchar(16) NOT NULL,
	-- 趣味
	hobby text NOT NULL,
	-- 経歴
	career text NOT NULL,
	-- 自己PR
	self_pr text NOT NULL,
	-- 備考
	-- 社内報から取得するのではなくユーザーが追加情報等を入力する
	remarks text,
	-- 削除フラグ
	delete_flg boolean DEFAULT 'false' NOT NULL,
	-- 登録日
	created timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
	-- 更新日
	modified timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
	CONSTRAINT profiles_pkey PRIMARY KEY (id)
) WITHOUT OIDS;


ALTER SEQUENCE profiles_id_SEQ INCREMENT 1 MINVALUE 1;


-- 部課マスタ
CREATE TABLE sections
(
	-- id
	id serial NOT NULL UNIQUE,
	-- 部署マスタのid
	departments_id int NOT NULL,
	-- 部課名
	name varchar(32) NOT NULL,
	-- 削除フラグ
	delete_flg boolean DEFAULT 'false' NOT NULL,
	-- 登録日
	created timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
	-- 更新日
	modified timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
	CONSTRAINT sections_pkey PRIMARY KEY (id),
	CONSTRAINT sections_unique_departments_id_name UNIQUE (departments_id, name)
) WITHOUT OIDS;


ALTER SEQUENCE sections_id_SEQ INCREMENT 1 MINVALUE 1;



/* Create Foreign Keys */

ALTER TABLE sections
	ADD CONSTRAINT sections_fkey_departments_id FOREIGN KEY (departments_id)
	REFERENCES departments (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE departments
	ADD CONSTRAINT departments_fkey_divisions_id FOREIGN KEY (divisions_id)
	REFERENCES divisions (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE profiles
	ADD CONSTRAINT profiles_fkey_enter_months_id FOREIGN KEY (enter_months_id)
	REFERENCES enter_months (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE profiles
	ADD CONSTRAINT profiles_fkey_images_id FOREIGN KEY (images_id)
	REFERENCES images (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE profiles
	ADD CONSTRAINT profiles_fkey_sections_id FOREIGN KEY (sections_id)
	REFERENCES sections (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



/* Comments */

COMMENT ON TABLE departments IS '部署マスタ';
COMMENT ON COLUMN departments.id IS 'id';
COMMENT ON COLUMN departments.divisions_id IS '事業部マスタのid';
COMMENT ON COLUMN departments.name IS '部署名';
COMMENT ON COLUMN departments.delete_flg IS '削除フラグ';
COMMENT ON COLUMN departments.created IS '登録日';
COMMENT ON COLUMN departments.modified IS '更新日';
COMMENT ON TABLE divisions IS '事業部マスタ';
COMMENT ON COLUMN divisions.id IS 'id';
COMMENT ON COLUMN divisions.name IS '事業部名';
COMMENT ON COLUMN divisions.delete_flg IS '削除フラグ';
COMMENT ON COLUMN divisions.created IS '登録日';
COMMENT ON COLUMN divisions.modified IS '更新日';
COMMENT ON TABLE enter_months IS '入社月テーブル';
COMMENT ON COLUMN enter_months.id IS 'id';
COMMENT ON COLUMN enter_months.enter_month IS '入社月';
COMMENT ON COLUMN enter_months.created IS '登録日';
COMMENT ON COLUMN enter_months.modified IS '更新日';
COMMENT ON TABLE images IS '画像テーブル';
COMMENT ON COLUMN images.id IS 'id';
COMMENT ON COLUMN images.file_name IS 'ファイル名';
COMMENT ON COLUMN images.created IS '登録日';
COMMENT ON COLUMN images.modified IS '更新日';
COMMENT ON TABLE profiles IS '社員紹介テーブル';
COMMENT ON COLUMN profiles.id IS 'id';
COMMENT ON COLUMN profiles.sections_id IS '部課マスタのid';
COMMENT ON COLUMN profiles.enter_months_id IS '入社月テーブルのid';
COMMENT ON COLUMN profiles.images_id IS '画像テーブルのid';
COMMENT ON COLUMN profiles.last_name IS '名字';
COMMENT ON COLUMN profiles.first_name IS '名前';
COMMENT ON COLUMN profiles.last_name_kana IS '名字かな';
COMMENT ON COLUMN profiles.first_name_kana IS '名前かな';
COMMENT ON COLUMN profiles.hobby IS '趣味';
COMMENT ON COLUMN profiles.career IS '経歴';
COMMENT ON COLUMN profiles.self_pr IS '自己PR';
COMMENT ON COLUMN profiles.remarks IS '備考
社内報から取得するのではなくユーザーが追加情報等を入力する';
COMMENT ON COLUMN profiles.delete_flg IS '削除フラグ';
COMMENT ON COLUMN profiles.created IS '登録日';
COMMENT ON COLUMN profiles.modified IS '更新日';
COMMENT ON TABLE sections IS '部課マスタ';
COMMENT ON COLUMN sections.id IS 'id';
COMMENT ON COLUMN sections.departments_id IS '部署マスタのid';
COMMENT ON COLUMN sections.name IS '部課名';
COMMENT ON COLUMN sections.delete_flg IS '削除フラグ';
COMMENT ON COLUMN sections.created IS '登録日';
COMMENT ON COLUMN sections.modified IS '更新日';




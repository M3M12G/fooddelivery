# fooddelivery
Food Delivery Website back-end realization using Spring framework + PostgreSQL DB


/*Food Delivery DB*/

/*
	Authors: Magauiya Mazhit & Mirolim Saidakhmatov
*/

/*	Tables(Draft representation)
	
stores(
	store_id PK,
	store_name,
	store_category FK (store_categories)
	);

store_categories(
	category_id PK,
	category_name
	);

menu(
	menu_id PK,
	foods,
	price,
	store FK(stores)
	);

delivery_types(
	delivery_type_id PK,
	delivery_type_name,
	);


couriers(
	courier_id PK,
	courier_name,
	courier_secondName,
	courier_middleName,
	order_cash,
	delivery_type FK(delivery_types)
	);

orders(
	order_id,
	client_number,
	menu_id FK(menu),
	order_date,
	courier_id FK(couriers),
	order_status, 
);

*/

/*-------------------------------------------------------------------------------------------------*/
CREATE ROLE admin WITH SUPERUSER CREATEDB CREATEROLE LOGIN ENCRYPTED PASSWORD 'rootPass@2020';


/*CREATING DATABASE*/

CREATE DATABASE "foodDelivery"
    WITH
    OWNER = admin
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;


CREATE ROLE admin WITH
	LOGIN
	SUPERUSER
	CREATEDB
	CREATEROLE
	INHERIT
	REPLICATION
	CONNECTION LIMIT -1
	PASSWORD 'rootPass@2020';

/*---------------------------------------------------------------------------------------------------*/

/*CREATING TABLES OF FOODDELIVERY DB*/


CREATE TABLE stores
(
  store_id serial NOT NULL,
  store_name varchar(100),
  store_category serial NOT NULL
);

ALTER TABLE stores ADD CONSTRAINT stores_id
  PRIMARY KEY (store_id);


/* DROP TABLE */

DROP TABLE stores;

/*---------------------------------------------------------------------------------------------------*/

CREATE TABLE store_categories
(
  category_id serial NOT NULL,
  category_name varchar(100)
);

ALTER TABLE store_categories ADD CONSTRAINT pk_store_categories
  PRIMARY KEY (category_id);

/* DROP TABLE */

DROP TABLE store_categories;

/* ADD FOREIGN KEY ( One store - One category, One category - many stores )*/

ALTER TABLE stores ADD CONSTRAINT store_category
  FOREIGN KEY (store_category) REFERENCES store_categories (category_id) ON DELETE RESTRICT ON UPDATE CASCADE;

/* DROP FOREIGN KEY */

ALTER TABLE stores
  DROP CONSTRAINT store_category;

/*-------------------------------------------------------------------------------------------------------*/

CREATE TABLE menu
(
  menu_id serial NOT NULL,
  foods text,
  price numeric,
  store serial NOT NULL
);

ALTER TABLE menu ADD CONSTRAINT pk_menu
  PRIMARY KEY (menu_id);

/* DROP TABLE */

DROP TABLE menu;

/* DROP FOREIGN KEY */

ALTER TABLE menu
  DROP CONSTRAINT store;


/* ADD FOREIGN KEY ( One menu belongs to exact One store, One store can allow order many menus )*/

ALTER TABLE menu ADD CONSTRAINT store
  FOREIGN KEY (store) REFERENCES stores (store_id) ON DELETE RESTRICT ON UPDATE DELETE;

/*-----------------------------------------------------------------------------------------------------------*/

CREATE TABLE delivery_types
(
  delivery_type_id serial NOT NULL,
  delivery_type_name varchar(50),
);

ALTER TABLE delivery_types ADD CONSTRAINT pk_delivery_types
  PRIMARY KEY (delivery_type_id);

/* DROP TABLE */

DROP TABLE delivery_types;

/*-----------------------------------------------------------------------------------------------------------*/


CREATE TABLE couriers
(
  courier_id serial NOT NULL,
  courier_name varchar(50),
  courier_secondName varchar(50),
  courier_middleName varchar(50),
  order_cash numeric,
  delivery_type serial NOT NULL
);

ALTER TABLE couriers ADD CONSTRAINT pk_couriers
  PRIMARY KEY (courier_id);

/* DROP FOREIGN KEY */

ALTER TABLE couriers
  DROP CONSTRAINT delivery_type;


/* ADD FOREIGN KEY ( One courier execute one type of delivery(for example, delivery with car, drone etc., One delivery type can be executed by many couriers) )*/

ALTER TABLE couriers ADD CONSTRAINT delivery_type
  FOREIGN KEY (delivery_type) REFERENCES delivery_types (delivery_type_id) ON DELETE RESTRICT ON UPDATE CASCADE;

/*-----------------------------------------------------------------------------------------------------------*/


CREATE TABLE orders
(
  order_id serial NOT NULL,
  client_number varchar(15),
  menu_id serial NOT NULL,
  order_time timestamp,
  courier_id serial NOT NULL,
  order_status boolean
);

ALTER TABLE orders ADD CONSTRAINT pk_orders
  PRIMARY KEY (order_id);

/* DROP TABLE */

DROP TABLE orders;


/* ADD FOREIGN KEY One order is carried by One courier, One courier can carry One order*/

ALTER TABLE orders ADD CONSTRAINT courier_id
  FOREIGN KEY (courier_id) REFERENCES couriers (courier_id) ON DELETE RESTRICT ON UPDATE CASCADE;

/* DROP FOREIGN KEY */

ALTER TABLE orders
  DROP CONSTRAINT courier_id;


/* ADD FOREIGN KEY One order includes One menu, One menu can be included on many orders*/

ALTER TABLE orders ADD CONSTRAINT menu_id
  FOREIGN KEY (menu_id) REFERENCES menu (menu_id) ON DELETE RESTRICT ON UPDATE CASCADE;

/* DROP FOREIGN KEY */

ALTER TABLE orders
  DROP CONSTRAINT menu_id;


--Creando base de datos
CREATE DATABASE dbtambo
GO
USE dbtambo
GO
--Creando tablas en la base de datos
CREATE TABLE employee(
	Idemployee int identity(1,1) PRIMARY KEY NOT NULL,
	full_name varchar(60),
	username varchar(60),
	password varchar(60),
	address varchar(60),
	telephone varchar(20),
	email varchar(255),
	rol varchar(20),
	created datetime,
	updated datetime,
);
CREATE TABLE suppliers(
	Idsupplier int identity(1,1) PRIMARY KEY NOT NULL,
	full_name varchar(60),
	address varchar(60),
	telephone varchar(20),
	email varchar(255),
	description varchar(255),
	created datetime,
	updated datetime,
);
CREATE TABLE categories(
	Idcategories int identity(1,1) PRIMARY KEY NOT NULL,
	name varchar(60),
	created datetime,
	updated datetime,
);
CREATE TABLE products(
	IdProduct int identity(1,1) PRIMARY KEY NOT NULL,
	code int,
	name varchar(60),
	description varchar(255),
	unit_price decimal(12,2),
	product_quantity int,
	created datetime,
	updated datetime,
	category_id int
);
create table purchases(
	IdPurchase int identity(1,1) PRIMARY KEY NOT NULL,
	supplier_id int,
	employee_id int,
	total decimal(12,2),
	created datetime,
);
create table purchases_details(
	id int identity(1,1) PRIMARY KEY NOT NULL,
	purchase_amount int,
	purchase_price decimal(12,2),
	purchase_subtotal decimal(12,2),
	purchase_id int,
	product_id int
);
create table sales(
	id int identity(1,1) PRIMARY KEY NOT NULL,
	sale_date datetime,
	total decimal(12,2),
	customer_id int,
	employee_id int,
);
create table sales_details(
	sale_quantity int,
	sale_price decimal(12,2),
	sale_subtotal decimal(12,2),
	product_id int,
	sale_id int,
);
CREATE TABLE customers(
	Idcustomer int identity(1,1) PRIMARY KEY NOT NULL,
	full_name varchar(60),
	telephone varchar(20),
	email varchar(255),
	description varchar(255),
	created datetime,
	updated datetime,
);
--Creacion de claves foraneas
ALTER TABLE sales ADD CONSTRAINT fk_customer_id FOREIGN KEY(customer_id) REFERENCES customers(Idcustomer)
ALTER TABLE sales ADD CONSTRAINT fk_employee_id FOREIGN KEY(employee_id) REFERENCES employee(Idemployee)
ALTER TABLE purchases ADD CONSTRAINT fk_supplier_id FOREIGN KEY(supplier_id) REFERENCES suppliers(Idsupplier)
ALTER TABLE purchases ADD CONSTRAINT fk_purchase_idemp FOREIGN KEY(employee_id) REFERENCES employee(Idemployee)
ALTER TABLE purchases_details ADD CONSTRAINT fk_purchase_idpurch FOREIGN KEY(purchase_id) REFERENCES purchases(IdPurchase)
ALTER TABLE purchases_details ADD CONSTRAINT fk_purchase_idprod FOREIGN KEY(product_id) REFERENCES products(IdProduct)
ALTER TABLE sales_details ADD CONSTRAINT fk_sales_idprod FOREIGN KEY(product_id) REFERENCES products(IdProduct)
ALTER TABLE sales_details ADD CONSTRAINT fk_sales_idsale FOREIGN KEY(sale_id) REFERENCES sales(id)
ALTER TABLE products ADD CONSTRAINT fk_product_category FOREIGN KEY(category_id) REFERENCES categories(Idcategories)
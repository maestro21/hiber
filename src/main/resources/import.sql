BEGIN;
DROP TABLE IF EXISTS hw6_orders CASCADE;
DROP TABLE IF EXISTS hw6_products CASCADE;
DROP TABLE IF EXISTS hw6_customers CASCADE;
CREATE TABLE hw6_customers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO hw6_customers (name) VALUES ('John'), ('Lena'), ('Peter'), ('Mary');


CREATE TABLE hw6_products (id bigserial PRIMARY KEY, title VARCHAR(255), cost int);
INSERT INTO hw6_products (title, cost) VALUES ('Banana', 100), ('Bread', 50), ('Water', 70), ('Peaches', 120), ('Watermelon', 330);

CREATE TABLE hw6_orders (id bigserial PRIMARY KEY, customer_id integer REFERENCES hw6_customers(id), product_id integer REFERENCES hw6_products(id), amount int, price int);


COMMIT;
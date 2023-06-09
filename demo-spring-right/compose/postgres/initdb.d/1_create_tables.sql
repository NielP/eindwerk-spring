create table customers
(
    id          bigint primary key generated by default as identity,
    first_name  varchar(50),
    last_name   varchar(50),
    postal_code varchar(50)
);

create table orders
(
    id          bigint primary key generated by default as identity,
    create_time timestamp,
    customer_id bigint references customers
);

create table products
(
    id          bigint primary key generated by default as identity,
    name        varchar(50),
    price       decimal(10, 2),
    ean         varchar(50)
);

 create table orders_products
(
   order_id int references orders,
   product_id int references products
);

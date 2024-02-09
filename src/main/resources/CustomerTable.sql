create table customer
(
    id         bigint auto_increment
        primary key,
    first_name varchar(255) null,
    surname    varchar(255) null,
    uf         varchar(255) null
);

create table customer_seq
(
    next_val bigint null
);
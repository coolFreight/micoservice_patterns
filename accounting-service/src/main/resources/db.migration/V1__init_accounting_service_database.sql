CREATE DATABASE IF NOT EXIST accounts;

CREATE TABLE IF NOT EXISTS accounts (
    order_id varchar primary key,
    status varchar not null
);

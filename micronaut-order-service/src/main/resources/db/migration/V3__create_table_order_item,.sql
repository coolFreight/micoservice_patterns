CREATE TABLE IF NOT EXISTS order_item (
    id varchar primary key,
    name varchar not null,
    quantity int4,
    order_id varchar not null
);


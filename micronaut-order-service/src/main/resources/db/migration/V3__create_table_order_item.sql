CREATE TABLE IF NOT EXISTS order_item (
    id varchar,
    name varchar not null,
    quantity int4,
    order_id varchar not null
);


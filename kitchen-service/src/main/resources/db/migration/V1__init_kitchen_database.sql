
CREATE TABLE IF NOT EXISTS ticket (
    ticket_id varchar primary key,
    order_id varchar not null,
    status varchar not null
);

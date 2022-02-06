ALTER TABLE IF EXISTS consumer ADD COLUMN IF NOT EXISTS order_id varchar;

ALTER TABLE IF EXISTS consumer ADD COLUMN IF NOT EXISTS consumer_verified boolean;
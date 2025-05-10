CREATE TABLE IF NOT EXISTS customer_addresses (
  customer_id BIGINT NOT NULL,
  address_type VARCHAR(50) NOT NULL,
  street VARCHAR(150),
  city VARCHAR(50),
  state VARCHAR(2),
  zip_code VARCHAR(9),
  country VARCHAR(50),
  is_primary BOOLEAN,
  complement VARCHAR(150),
  reference_point VARCHAR(150),
  FOREIGN KEY (customer_id) REFERENCES user(id) ON DELETE CASCADE
);

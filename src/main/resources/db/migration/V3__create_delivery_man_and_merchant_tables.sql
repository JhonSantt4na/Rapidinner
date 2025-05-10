-- Tabela 'delivery_man' (relacionada a 'user')
CREATE TABLE IF NOT EXISTS delivery_man (
  id BIGINT NOT NULL PRIMARY KEY,
  rating DECIMAL(3, 2) CHECK(rating >= 0 AND rating <= 5),
  cnh VARCHAR(20),
  available BOOLEAN,
  vehicle_type VARCHAR(50),
  vehicle_color VARCHAR(50),
  vehicle_model VARCHAR(50),
  vehicle_plate VARCHAR(20),
  FOREIGN KEY (id) REFERENCES user(id) ON DELETE CASCADE
);

-- Tabela 'merchant' (relacionada a 'user')
CREATE TABLE IF NOT EXISTS merchant (
  id BIGINT NOT NULL PRIMARY KEY,
  cnpj VARCHAR(14) UNIQUE NOT NULL,
  company_name VARCHAR(255) NOT NULL,
  business_address_street VARCHAR(150),
  business_address_city VARCHAR(50),
  business_address_state VARCHAR(2),
  business_address_zip_code VARCHAR(9),
  business_address_country VARCHAR(50),
  business_address_primary BOOLEAN,
  business_address_complement VARCHAR(150),
  business_address_reference_point VARCHAR(150),
  FOREIGN KEY (id) REFERENCES user(id) ON DELETE CASCADE
);
CREATE TABLE pokemon (
  ID SERIAL PRIMARY KEY,
  NAME VARCHAR NOT NULL DEFAULT '',
  HEIGHT_IN_CM NUMERIC NOT NULL DEFAULT 0,
  WEIGHT_IN_KG DOUBLE PRECISION NOT NULL DEFAULT 0,
  OWNER VARCHAR(256) NOT NULL
);

-- Drop the table if it exists to avoid conflicts during creation
DROP TABLE IF EXISTS cards;

-- Create the cards table with the specified columns and types
CREATE TABLE cards (
  card_id VARCHAR(50) PRIMARY KEY,
  set_id VARCHAR(50) NOT NULL,
  rarity VARCHAR(20) NOT NULL,
  type VARCHAR(50) NOT NULL,
  color VARCHAR(20) NOT NULL,
  feature VARCHAR(100),
  description TEXT,
  name VARCHAR(100) NOT NULL,
  img VARCHAR(255),
  power INT,
  counter INT
);

DROP TABLE IF EXISTS sets;

CREATE TABLE sets (
  id VARCHAR(255) PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description TEXT,
  img VARCHAR(255),
  type VARCHAR(100) NOT NULL
);

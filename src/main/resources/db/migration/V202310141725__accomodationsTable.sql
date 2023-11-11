CREATE TABLE accommodations (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    city_id BIGINT,
    type VARCHAR(255) NOT NULL,
    price DECIMAL(10,2),
    rating DECIMAL(10,2),
    FOREIGN KEY (city_id) REFERENCES cities (id)
);
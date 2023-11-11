CREATE TABLE trips(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    customer_id BIGINT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers (id)
);

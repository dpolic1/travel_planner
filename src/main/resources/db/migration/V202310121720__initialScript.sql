CREATE TABLE customers (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    username VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE customers_roles (
    customer_id BIGINT NOT NULL,
    role VARCHAR(100) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers (id)
);

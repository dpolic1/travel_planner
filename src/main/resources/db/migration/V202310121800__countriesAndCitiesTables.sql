CREATE TABLE countries (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE cities (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    country_id BIGINT NOT NULL,
    FOREIGN KEY (country_id) REFERENCES countries (id)
);
CREATE TABLE destinations (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    trip_id BIGINT NOT NULL,
    country_id BIGINT NOT NULL,
    FOREIGN KEY (country_id) REFERENCES countries (id),
    FOREIGN KEY (trip_id) REFERENCES trips (id)
);

CREATE TABLE specific_locations (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    country_id BIGINT NOT NULL,
    FOREIGN KEY (country_id) REFERENCES countries (id)
);

CREATE TABLE locations(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    destination_id BIGINT NOT NULL,
    city_id BIGINT,
    specific_location_id BIGINT,
    accommodation_type VARCHAR(255) NOT NULL,
    accommodation_id BIGINT,
    FOREIGN KEY (destination_id) REFERENCES destinations (id),
    FOREIGN KEY (city_id) REFERENCES cities (id),
    FOREIGN KEY (specific_location_id) REFERENCES specific_locations (id),
    FOREIGN KEY (accommodation_id) REFERENCES accommodations (id)
);
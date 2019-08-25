CREATE SEQUENCE user_seq START 1 INCREMENT 1;

CREATE TABLE hibernate.users (
    id INTEGER,
    installation_id VARCHAR,
    email VARCHAR,
    full_name VARCHAR,

    PRIMARY KEY(id),
    UNIQUE(installation_id)
);

CREATE SEQUENCE workshop_seq START 1 INCREMENT 1;

CREATE TABLE hibernate.workshops (
    id INTEGER,
    title VARCHAR,
    location VARCHAR,
    type VARCHAR,
    description TEXT,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    primary_instructor_id INTEGER,
    secondary_instructor_id INTEGER,

    PRIMARY KEY(id),
    FOREIGN KEY(primary_instructor_id) REFERENCES users (id),
    FOREIGN KEY(secondary_instructor_id) REFERENCES users (id)
);

CREATE SEQUENCE favorite_seq START 1 INCREMENT 1;

CREATE TABLE hibernate.favorites (
    id INTEGER,
    user_id INTEGER,
    workshop_id INTEGER,

    PRIMARY KEY(id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (workshop_id) REFERENCES workshops (id)
);

CREATE SEQUENCE admin_seq START 1 INCREMENT 1;

CREATE TABLE hibernate.admins (
    id INTEGER,
    user_id INTEGER,
    password_hash VARCHAR,

    PRIMARY KEY(id),
    FOREIGN KEY (user_id) REFERENCES users (id)
)
CREATE SEQUENCE user_seq START 0 INCREMENT 1;

CREATE TABLE users (
    id INTEGER,
    email VARCHAR,
    full_name VARCHAR,

    PRIMARY KEY(id)
);

CREATE SEQUENCE workshop_seq START 0 INCREMENT 1;

CREATE TABLE workshops (
    id INTEGER,
    title VARCHAR,
    location VARCHAR,
    description VARCHAR,
    start_time TIMESTAMP,
    end_time TIMESTAMP,

    PRIMARY KEY(id)
);

CREATE SEQUENCE favorite_seq START 0 INCREMENT 1;

CREATE TABLE favorites (
    id INTEGER,
    user_id INTEGER,
    workshop_id INTEGER,

    PRIMARY KEY(id),
    FOREIGN KEY (user_id) REFERENCES Users (id),
    FOREIGN KEY (workshop_id) REFERENCES Workshops (id)
);
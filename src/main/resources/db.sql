-- Table: users_app.messages

-- DROP TABLE IF EXISTS users_app.messages;

CREATE TABLE IF NOT EXISTS users_app.messages
(
    id primary key NOT NULL,
    from_user character varying(50)  NOT NULL,
    to_user character varying(50) NOT NULL,
    text text  NOT NULL,
    send_time timestamp without time zone
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS users_app.messages
    OWNER to postgres;

-- Table: users_app.users

-- DROP TABLE IF EXISTS users_app.users;

CREATE TABLE IF NOT EXISTS users_app.users
(
    id primary key NOT NULL,
    login character varying(50)  NOT NULL,
    password character varying(255)  NOT NULL,
    full_name character varying(100) ,
    birth_date date,
    registration_date timestamp without time zone NOT NULL,
    role character varying(50)  NOT NULL,
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS users_app.users
    OWNER to postgres;

INSERT INTO users_app.users(
    id, login, password, full_name, birth_date, registration_date, role)
    VALUES ("admin", "admin", "admin", "23.04.2000", "30.05.2025", "ADMIN");
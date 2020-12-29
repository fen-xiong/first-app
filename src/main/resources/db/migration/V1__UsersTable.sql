CREATE TABLE users
(
    id          UUID PRIMARY KEY,
    userid      serial UNIQUE,
    create_time timestamptz  NOT NULL,
    update_time timestamptz,
    shadow_time timestamptz,
    name        VARCHAR(100),
    password    VARCHAR(100) NOT NULL,
    email       VARCHAR(100) NOT NULL UNIQUE,
    account     VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE users_token
(
    token       VARCHAR(30)   ,
    user_role   VARCHAR(20)   NOT NULL,
    userId      serial UNIQUE NOT NULL  REFERENCES users (userid),
    create_time timestamptz   NOT NULL,
    update_time timestamptz
);
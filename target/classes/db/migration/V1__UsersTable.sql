CREATE TABLE users
(
    user_id     SERIAL PRIMARY KEY,
    name        VARCHAR(100) UNIQUE,
    password    VARCHAR(100) NOT NULL,
    email       VARCHAR(100) NOT NULL UNIQUE,
    account     VARCHAR(100) NOT NULL UNIQUE,
    create_at timestamptz    NOT NULL,
    update_at timestamptz,
    shadow_at timestamptz

);

CREATE TABLE users_token
(
    token       VARCHAR(30)    NOT NULL UNIQUE,
    user_role   VARCHAR(20)    NOT NULL,
    user_id     INT  REFERENCES users (user_id),
    create_at timestamptz    NOT NULL,
    update_at timestamptz
);
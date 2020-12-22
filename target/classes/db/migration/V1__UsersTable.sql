CREATE TABLE  users (
  id UUID  PRIMARY KEY,
  userid serial UNIQUE ,
  create_time timestamptz NOT NULL,
  update_time timestamptz,
  shadow_time timestamptz,
  name VARCHAR(100),
  password VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  account VARCHAR(100) NOT NULL UNIQUE
);
CREATE TABLE user_token (
    user_id serial REFERENCES users (userid),
    token text NOT NULL UNIQUE
)
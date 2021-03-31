CREATE TABLE book_category (
                               book_category_id SERIAL PRIMARY KEY,
                               user_id int REFERENCES users (user_id),
                               book_category_name varchar(20) NOT NULL UNIQUE,
                               created_at timestamptz  NOT NULL,
                               updated_at timestamptz
);

CREATE TABLE book_subcategory (
                                  book_subcategory_id SERIAL PRIMARY KEY,
                                  book_category_id int REFERENCES book_category (book_category_id ),
                                  book_subcategory_name varchar(20) NOT NULL UNIQUE,
                                  created_at timestamptz  NOT NULL,
                                  updated_at timestamptz
);

CREATE TABLE book_quesion (
                              book_quesion_id SERIAL PRIMARY KEY,
                              book_subcategory_id int REFERENCES book_subcategory    (book_subcategory_id ),
                              book_quesion_title varchar(88) NOT NULL UNIQUE,
                              created_at timestamptz  NOT NULL,
                              updated_at timestamptz
);

CREATE TABLE book_answer (
                             book_answer_id SERIAL PRIMARY KEY,
                             book_quesion_id int REFERENCES book_quesion (book_quesion_id ),
                             book_answer_content varchar(1000) NOT NULL UNIQUE,
                             created_at timestamptz  NOT NULL,
                             updated_at timestamptz ,
                             private_version int
);

CREATE TABLE book_comment (
                              book_comment_id SERIAL PRIMARY KEY,
                              book_answer_id int REFERENCES  book_answer ( book_answer_id ),
                              book_comment_content varchar(200) NOT NULL UNIQUE,
                              created_at timestamptz  NOT NULL,
                              updated_at timestamptz
);

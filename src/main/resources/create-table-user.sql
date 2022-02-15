CREATE TABLE users (
                       id serial not null primary key,
                       user_name varchar(100) not null,
                       time timestamp DEFAULT CURRENT_TIMESTAMP,
                       activities text not null
);
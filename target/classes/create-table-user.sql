CREATE TABLE users (
                       id serial not null primary key,
                       user_name varchar(100) not null,
                       time DATE DEFAULT now(),
                       activities text not null
);
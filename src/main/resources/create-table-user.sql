CREATE TABLE users (
                       id serial not null primary key,
                       user_name varchar(100) not null,
                       spend_time double precision NOT NULL ,
                       activities text not null,
                       time_to_add timestamp DEFAULT CURRENT_TIMESTAMP
);
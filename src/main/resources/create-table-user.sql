CREATE TABLE users (
    id SERIAL NOT NULL  PRIMARY KEY,
    firstname VARCHAR (45) NOT NULL,
    lastname VARCHAR(45) NOT NULL,
    age INT NOT NULL
);
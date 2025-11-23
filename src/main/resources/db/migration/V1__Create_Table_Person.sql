CREATE TABLE person (
                        id BIGINT IDENTITY(1,1) NOT NULL,
                        address VARCHAR(100) NOT NULL,
                        first_name VARCHAR(80) NOT NULL,
                        gender VARCHAR(6) NOT NULL,
                        last_name VARCHAR(80) NOT NULL,
                        CONSTRAINT PK_person PRIMARY KEY (id)
);

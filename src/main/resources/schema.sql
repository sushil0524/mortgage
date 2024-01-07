DROP TABLE IF EXISTS interest_rate;

CREATE TABLE interest_rate  (
                                id INTEGER AUTO_INCREMENT PRIMARY KEY,
                                maturity_period INTEGER NOT NULL,
                                interest_rate DOUBLE PRECISION NOT NULL
);
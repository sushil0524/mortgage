DROP TABLE IF EXISTS interest_rates;

CREATE TABLE interest_rates  (
                                id INTEGER AUTO_INCREMENT PRIMARY KEY,
                                maturity_period INTEGER NOT NULL,
                                interest_rate DOUBLE PRECISION NOT NULL
);
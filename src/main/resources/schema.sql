DROP TABLE IF EXISTS INTERESTRATES;

CREATE TABLE INTERESTRATES  (
                                id INTEGER AUTO_INCREMENT PRIMARY KEY,
                                maturityPeriod INTEGER NOT NULL,
                                interestRate DOUBLE PRECISION NOT NULL
);
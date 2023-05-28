CREATE TABLE IF NOT EXISTS exchange_value (
                                    id BIGINT NOT NULL PRIMARY KEY,
                                              currency_from VARCHAR(5),
    currency_to VARCHAR(5),
    conversion_multiple DECIMAL(10,2),
    port INT
    );
CREATE TABLE medicine (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) NOT NULL,
    dosage VARCHAR(100) NOT NULL,
    form INTEGER NOT NULL,
    manufacturer INTEGER NOT NULL,
    expiration_date DATE NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity_in_stock INTEGER NOT NULL,
    description VARCHAR(500) NOT NULL
);

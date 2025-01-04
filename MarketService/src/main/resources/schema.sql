CREATE SEQUENCE IF NOT EXISTS order_seq START WITH 10000 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS eventtype(
eventtypeid INT PRIMARY KEY,
name VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS orders(
ordersid INT PRIMARY KEY,
name VARCHAR(20),
paymentid INT,
clientid INT,
artistid INT,
eventdate DATE,
eventtypeid INT REFERENCES eventtype(eventtypeid),
createddate DATE
);

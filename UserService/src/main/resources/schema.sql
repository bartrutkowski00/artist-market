CREATE TABLE IF NOT EXISTS country (
countryid INT PRIMARY KEY,
name VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS city (
cityid INT PRIMARY KEY,
countryid INT REFERENCES country(countryid),
name VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS userrole (
userroleid INT PRIMARY KEY,
description VARCHAR(20)
);


CREATE TABLE IF NOT EXISTS usr (
usrid INT PRIMARY KEY,
username VARCHAR(20),
email VARCHAR(20),
phone INT,
cityid INT REFERENCES city(cityid),
userroleid INT,
createddate DATE,
updateddate DATE
);
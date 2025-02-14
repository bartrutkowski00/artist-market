MERGE INTO country AS target
USING (VALUES(1, 'Poland')) AS source(countryid, name)
ON target.countryid = source.countryid
WHEN MATCHED THEN
    UPDATE SET countryid = source.countryid, name = source.name
WHEN NOT MATCHED THEN
    INSERT (countryid, name) 
    VALUES (1, 'Poland');

MERGE INTO city AS target
USING (VALUES(1, 1, 'Warsaw'), (2, 1, 'Wroclaw')) AS source(cityid, countryid, name)
ON target.cityid = source.cityid
WHEN MATCHED THEN
    UPDATE SET cityid = source.cityid, countryid = source.countryid, name = source.name
WHEN NOT MATCHED THEN
    INSERT (cityid, countryid, name) 
    VALUES (source.cityid, source.countryid, source.name);

MERGE INTO userrole AS target
USING (VALUES(1, 'Client'), (2, 'Artist')) AS source(userroleid, description)
ON target.userroleid = source.userroleid
WHEN MATCHED THEN
    UPDATE SET userroleid = source.userroleid, description = source.description
WHEN NOT MATCHED THEN
    INSERT (userroleid, description) 
    VALUES (source.userroleid, source.description);

MERGE INTO usr AS target
USING (VALUES(1, 'am','TestPassword', 'am@artist.com', 592432854, 1, 1, TRUE, current_date, current_date)) AS source(usrid, username, password, email, phone, cityid, userroleid, activatedind, createddate, updateddate)
ON target.usrid = source.usrid
WHEN MATCHED THEN
    UPDATE SET usrid = source.usrid, username = source.username, password = source.password, email = source.email, phone = source.phone, cityid = source.cityid, userroleid = source.userroleid, activatedind = source.activatedind, createddate = source.createddate, updateddate = source.createddate
WHEN NOT MATCHED THEN
    INSERT (usrid, username, password, email, phone, cityid, userroleid, activatedind, createddate, updateddate)
    VALUES (source.usrid, source.username, source.password, source.email, source.phone, source.cityid, source.userroleid, source.activatedind, source.createddate, source.updateddate);
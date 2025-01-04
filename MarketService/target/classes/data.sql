MERGE INTO eventtype AS target
USING (VALUES (1, 'Concert')) AS source(eventtypeid, name)
ON target.eventtypeid = source.eventtypeid
WHEN MATCHED THEN
    UPDATE SET name = source.name
WHEN NOT MATCHED THEN
    INSERT (eventtypeid, name)
    VALUES (source.eventtypeid, source.name);


MERGE INTO orders AS target
USING (VALUES
    (1, 'Test event', 1, 2, 1, current_date, 1, current_date + 10)
) AS source(ordersid, name, paymentid, clientid, artistid, eventdate, eventtypeid, createddate)
ON target.ordersid = source.ordersid
WHEN MATCHED THEN
    UPDATE SET
        name = source.name,
        paymentid = source.paymentid,
        clientid = source.clientid,
        artistid = source.artistid,
        eventdate = source.eventdate,
        eventtypeid = source.eventtypeid,
        createddate = source.createddate
WHEN NOT MATCHED THEN
    INSERT (ordersid, name, paymentid, clientid, artistid, eventdate, eventtypeid, createddate)
    VALUES (
        source.ordersid,
        source.name,
        source.paymentid,
        source.clientid,
        source.artistid,
        source.eventdate,
        source.eventtypeid,
        source.createddate
    );

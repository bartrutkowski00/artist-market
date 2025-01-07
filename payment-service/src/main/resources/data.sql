MERGE INTO payment AS target
USING (VALUES (1, 1, 1, false)) AS source(paymentid, orderid, clientid, paid)
ON target.paymentid = source.paymentid
WHEN NOT MATCHED THEN
    INSERT (paymentid, orderid, clientid, paid)
    VALUES (source.paymentid, source.orderid, source.clientid, source.paid);
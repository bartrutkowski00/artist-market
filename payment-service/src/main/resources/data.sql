MERGE INTO payment AS target
USING (VALUES (1, 1, false)) AS source(paymentid, orderid, paid)
ON target.paymentid = source.paymentid
WHEN NOT MATCHED THEN
    INSERT (paymentid, orderid, paid)
    VALUES (source.paymentid, source.orderid, source.paid);
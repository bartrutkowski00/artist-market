INSERT INTO eventtype(eventtypeid, name)
VALUES (1, 'Concert');

INSERT INTO orders (ordersid, name, paymentid, clientid, artistid, eventdate, eventtypeid, createddate)
VALUES (1, 'Test event', 1, 2, 1, current_date, 1, current_date + 10 );
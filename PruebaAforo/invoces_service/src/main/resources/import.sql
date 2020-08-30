insert into cliente values (1, 'Jose', '123456');
insert into cliente values (2, 'Pedro', '153457');
insert into cliente values (3, 'Carlos', '143458');

insert into factura (id, invoce_numero, cliente_id, state, amount) values (1, '123', 1, 'POR_PAGAR', 3000);
insert into factura (id, invoce_numero, cliente_id, state, amount) values (2, '124', 1, 'POR_PAGAR', 5000);
insert into factura (id, invoce_numero, cliente_id, state, amount) values (3, '125', 2, 'POR_PAGAR', 4000);
insert into factura (id, invoce_numero, cliente_id, state, amount) values (4, '126', 2, 'POR_PAGAR', 6000);
insert into factura (id, invoce_numero, cliente_id, state, amount) values (5, '127', 2, 'POR_PAGAR', 1000);
insert into factura (id, invoce_numero, cliente_id, state, amount) values (6, '128', 2, 'POR_PAGAR', 2000);
insert into factura (id, invoce_numero, cliente_id, state, amount) values (7, '129', 3, 'POR_PAGAR', 5500);
insert into factura (id, invoce_numero, cliente_id, state, amount) values (8, '130', 3, 'POR_PAGAR', 8500);
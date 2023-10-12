CREATE TABLE clients (
    id BIGINT DEFAULT nextval('client_id_sequence') PRIMARY KEY,
    name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    payment_amount INTEGER,
    status VARCHAR(255)
);

INSERT INTO public.client (name,last_name,email,payment_amount,status) VALUES
	 ('aaa','aaa','aaa',20,'LatePayment'),
	 ('bbb','bbb','bbb',10,'PaymentAtTime'),
	 ('Andy','Gomez','a@a.a',10,'PaymentAtTime'),
	 ('a','a','a',1,'PaymentAtTime'),
	 ('a','a','a',30,'NotPayed'),
	 ('pedro','pedro','a@a.a',10,'PaymentAtTime'),
	 ('aaa','aaa','',23,'NotPayed');

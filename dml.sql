BEGIN;

INSERT INTO eli.person (id, first_name, last_name, birthdate, address)
VALUES ('1', 'יובל', 'בארי', '23-06-2004', 'האורן 119, בית חירות'),
('2', 'אוהד', 'לוי אור', '19-03-1995', 'חיפה'),
('3', 'מיה', 'טלמור', '06-11-2007', 'רמת גן');

INSERT INTO eli.subscription_type (name, validity_length, limit_enters)
VALUES ('כרטיסייה 10', 6, 10),
('כרטיסייה 20', 6, 20),
('מנוי חודשי', 1, NULL),
('מנוי עונתי', 6, NULL);

INSERT INTO eli.subscription (type_id, person_id, number_of_enters, opening_date, expiration_date)
VALUES (1, '1', 3, '01-06-2023', '01-12-2024'),
(4, '1', 20, '01-05-2022', '01-11-2022'),
(2, '2', 13, '12-05-2024', '12-11-2024'),
(1, '3', 10, '01-06-2023', '01-12-2023'),
(3, '3', 3, '22-07-2024', '22-08-2024');

COMMIT;
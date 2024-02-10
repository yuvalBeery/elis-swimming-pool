BEGIN;

DROP SCHEMA IF EXISTS eli CASCADE;
CREATE SCHEMA eli;

CREATE TABLE eli.person (
	id TEXT PRIMARY KEY NOT NULL,
	first_name TEXT NOT NULL,
	last_name TEXT NOT NULL,
	birthdate DATE NOT NULL,
	address TEXT NOT NULL
);

CREATE TABLE eli.subscription_type (
	id SERIAL PRIMARY KEY,
	name TEXT NOT NULL,
	--validity length is in monthes
	validity_length INT NOT NULL,
	limit_enters INT DEFAULT NULL
);

CREATE TABLE eli.subscription (
	id SERIAL PRIMARY KEY,
	type_id INTEGER REFERENCES eli.subscription_type (id) ON DELETE CASCADE ON UPDATE CASCADE,
	person_id TEXT REFERENCES eli.person (id)  ON DELETE CASCADE ON UPDATE CASCADE,
	number_of_enters INTEGER NOT NULL,
	opening_date DATE NOT NULL,
	expiration_date DATE NOT NULL
);

COMMIT;
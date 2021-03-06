/* Users table */
create table "users"
(
  id bigserial primary key NOT NULL,
  firstname text NOT NULL,
  lastname text NOT NULL,
  tcid VARCHAR (11) NOT NULL,
  email character varying(50) NOT NULL,
  phone character varying(50) NOT NULL,
  password text NOT NULL,
  admin boolean DEFAULT false,
  timestamp timestamp default current_timestamp
)


/* Doctors table */
create table doctors
(
    id serial primary key NOT NULL,
    first_name VARCHAR (99) NOT NULL,
    second_name VARCHAR (99) NOT NULL
);


/* Appoinments table */
create table appoinments
(
    id serial primary key NOT NULL,
    user_id integer NOT NULL,
    doctor_id integer NOT NULL,
    date TIMESTAMP NOT NULL,
    clock VARCHAR (5) NOT NULL
);


/* Visits table */
create table visits
(
    id serial primary key NOT NULL,
    date timestamp not null default CURRENT_TIMESTAMP, 
    url VARCHAR (100) NOT NULL
);


/* Contacts table */
create table contacts
(
    id serial primary key NOT NULL,
    fullname text NOT NULL,
    email character varying(50) NOT NULL,
    phone character varying(50) NOT NULL,
    message VARCHAR NOT NULL
);


/* Jop application table */
create table jobapp
(
    id serial primary key NOT NULL,
    first_name VARCHAR (99) NOT NULL,
    second_name VARCHAR (99) NOT NULL,
    email character varying(50) NOT NULL,
    phone character varying(50) NOT NULL,
    department character varying(50) NOT NULL,
    message VARCHAR NOT NULL
);


/* Blog table */
create table blog
(
    id serial primary key NOT NULL,
    blogtitle VARCHAR (99) NOT NULL,
    blogtext VARCHAR NOT NULL
);



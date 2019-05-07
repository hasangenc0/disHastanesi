/* Users table */
create table "users"
(
  id bigserial primary key NOT NULL,
  firstname text NOT NULL,
  lastname text NOT NULL,
  tcid VARCHAR (11) NOT NULL,
  email character varying(20) NOT NULL,
  phone character varying(20) NOT NULL,
  password text NOT NULL,
)

/* Appoinments table */
create table appoinments
(
    id serial primary key NOT NULL,
    first_name VARCHAR (99) NOT NULL,
    second_name VARCHAR (99) NOT NULL,
    tcid VARCHAR (99) NOT NULL,
    phone VARCHAR (99) NOT NULL,
    email VARCHAR (99) NOT NULL,
    doctor_name VARCHAR (99) NOT NULL,
    appoinment_date DATE NOT NULL,
    appoinment_time VARCHAR (5) NOT NULL,
    created_on TIMESTAMP NOT NULL,
    last_login TIMESTAMP
);


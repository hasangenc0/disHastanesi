create table appoinments 
( 
    id serial primary key, 
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
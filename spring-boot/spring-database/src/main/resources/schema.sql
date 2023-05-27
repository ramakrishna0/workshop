create table person
    (
        id integer not null,
        name varchar(255) not null ,
        location varchar(255),
        birth_date timestamp,
        primary key (id)
    );


insert into person (ID, NAME, LOCATION, BIRTH_DATE) values (10001, 'Jon Doe 1', 'USA', sysdate());
insert into person (ID, NAME, LOCATION, BIRTH_DATE) values (10002, 'Jon Doe 2', 'USA', sysdate());
insert into person (ID, NAME, LOCATION, BIRTH_DATE) values (10003, 'Jon Doe 3', 'USA', sysdate());
insert into person (ID, NAME, LOCATION, BIRTH_DATE) values (10004, 'Jon Doe 4', 'USA', sysdate());
insert into person (ID, NAME, LOCATION, BIRTH_DATE) values (10005, 'Jon Doe 5', 'USA', sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE) VALUES (10006, 'Ranga', 'Hyderabad',sysdate());

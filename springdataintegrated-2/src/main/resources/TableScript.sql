drop database if exists voting_db;

create database voting_db;

use voting_db;

create table candidate(
candidate_id int,
name VARCHAR(20),
no_of_votes int,
constraint pk_candidate primary key(candidate_id)
);

create table voter (
    voter_id int auto_increment,
    votername varchar(20),
    date_of_birth date,
    candidate_id int,
    constraint pk_voter primary key (voter_id),
    
    constraint fk_candidate_vote foreign key (candidate_id) references candidate(candidate_id)
);

INSERT INTO candidate VALUES(111,'A',50000);
INSERT INTO candidate VALUES(222,'B',90000);
INSERT INTO candidate VALUES(333,'C',80000);
INSERT INTO candidate VALUES(444,'D',10000);
INSERT INTO candidate VALUES(555,'E',60000);

INSERT INTO voter(votername,date_of_birth,candidate_id) VALUES('Paul','1998-10-23',111);
INSERT INTO voter(votername,date_of_birth,candidate_id) VALUES('John','2000-11-13',222);
INSERT INTO voter(votername,date_of_birth,candidate_id) VALUES('Joseph','2001-06-16',111);
INSERT INTO voter(votername,date_of_birth,candidate_id) VALUES('Joana','2006-12-05',333);




commit;

select * from candidate;
select * from voter;

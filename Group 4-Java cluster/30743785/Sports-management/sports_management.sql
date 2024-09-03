create database sports_tournament;
use sports_tournament;

create table team(
	team_id int auto_increment primary key,
    name varchar(50),
    coach varchar(50),
    captain varchar(50),
    total_players int default 0
);

select * from team;

insert into team values('1','Tmr','Sabari','Moha',12);

create table player(
	player_id int auto_increment primary key,
    name varchar(50),
    age int,
    team_id int,
     position varchar(50),
    foreign key(team_id) references team(team_id)
);
insert into player values('1','Moha',21,'1','first');
insert into player values('2','Mohan',22,'1','second');
select * from player;

update team set total_players= (select count(*) from player where team_id=2) where team_id=2;

create table matchtable(
	match_id int auto_increment primary key,
    team1_id int,
    team2_id int,
    match_date date,
    venue varchar(50),
    result varchar(50),
    foreign key(team1_id)references team(team_id),
    foreign key(team2_id)references team(team_id)
);
select * from matchtable;
drop table matchtable;
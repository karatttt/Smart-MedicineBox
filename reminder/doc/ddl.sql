create table if not exists reminder
(

    reminder_id bigint auto_increment
        primary key,
    user_id      bigint not null,

    medication_id          varchar(255) not null,
    begin_date              date,
    reminder_time          timestamp,
    cycle        int not null
);
create database smb_reminder;
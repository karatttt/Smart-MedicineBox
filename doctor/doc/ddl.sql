create table if not exists medication_info
(
    medication_id bigint auto_increment
        primary key,
    user_id       bigint          not null,
    name          varchar(255) not null,
    type          varchar(255) not null,
    description   text         null,
    imageurl      varchar(255) null
);


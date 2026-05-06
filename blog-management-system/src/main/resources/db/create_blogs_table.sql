DROP TABLE IF EXISTS blogs CASCADE;
create table Blog {
 id serial primary key
 title varchar(255)  
 content text
 create_at timestamp default current_timestamp
 updated_at timestamp default current_timestamp
 deleted_at timestamp 
}



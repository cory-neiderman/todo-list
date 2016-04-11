
CREATE SEQUENCE member_user_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE member (
  user_id integer DEFAULT nextval('member_user_id_seq'::regclass) NOT NULL,
  username varchar(80) NOT NULL, 
  password varchar(80) NOT NULL,    
  CONSTRAINT pk_member_user_id PRIMARY KEY (user_id)
);

CREATE SEQUENCE task_task_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE task (
  task_id integer DEFAULT nextval('task_task_id_seq'::regclass) NOT NULL,
  user_id integer NOT NULL,          
  creator_name varchar(50) NOT NULL, 
  description varchar(80) NOT NULL,     
  create_date date NOT NULL,       
  priority integer NOT NULL,             
  due_date date NOT NULL,          
  is_completed boolean NOT NULL DEFAULT FALSE,  
  CONSTRAINT pk_task_task_id PRIMARY KEY (task_id),
  CONSTRAINT fk_member_user_id FOREIGN KEY (user_id) REFERENCES member(user_id)
);


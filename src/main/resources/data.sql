CREATE TABLE task (
	id INT PRIMARY KEY auto_increment, 
	title varchar(200), 
	description TEXT, 
	points int,
	status int DEFAULT 0,
	user_id int
);

CREATE TABLE user (
	id bigint PRIMARY KEY auto_increment,
	name varchar(200),
	email varchar(200),
	password varchar(200),
	githubuser varchar(200)
);

CREATE TABLE role (
	id int primary key auto_increment,
	name varchar(200)
);

CREATE TABLE user_roles(
	user_id int,
	roles_id int
);

INSERT INTO role (name) VALUES ('ROLE_ADMIN'), ('ROLE_USER');

INSERT INTO user_roles VALUES (1,1), (1,2), (2,2), (3,2);

INSERT INTO user (name, email, password, githubuser) VALUES
('Joao Carlos', 'joao@gmail.com', '$2a$12$MR71xdTK7TLEufynjWM3yudy/afK7WSP.pEEaPZTK76zaRsCNQT02', 'joaocarloslima'),
('Carla Lopes', 'carla@gmail.com', '$2a$12$MR71xdTK7TLEufynjWM3yudy/afK7WSP.pEEaPZTK76zaRsCNQT02', 'carla'),
('Fabio Cabrini', 'fabio@fiap.com.br', '$2a$12$MR71xdTK7TLEufynjWM3yudy/afK7WSP.pEEaPZTK76zaRsCNQT02', 'jose');

INSERT INTO task (id, title, description, points, status, user_id) VALUES 
(1, 'A Hora da Estrela', 'Clarice lispector', 10, 129, 1);

INSERT INTO task (id, title, description, points, status) VALUES 
(2, 'Drácula', 'Bram Stoker', 10, 99);

INSERT INTO task (id, title, description, points, status, user_id) VALUES 
(3, 'O Homem de Giz', 'C.J. Tudor', 10, 149, 2);

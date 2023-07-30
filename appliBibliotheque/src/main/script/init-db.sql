CREATE sequence hibernate_sequence start with 1 increment by  1;

CREATE TABLE Domaine (
	id NUMBER(19,0) generated as identity, 
	description VARCHAR2(255 char), 
	nom VARCHAR2(255 char), 
	PRIMARY KEY (id)
);

CREATE TABLE Emprunt (
	id_lecteur NUMBER(19,0) not null, 
	id_livre NUMBER(19,0) not null, 
	date_debut date, 
	date_fin date, 
	etat VARCHAR2(255 char), 
	incident NUMBER(19,0), 
	PRIMARY KEY (id_lecteur, id_livre)
);

CREATE TABLE Incident (
	id NUMBER(19,0) generated as identity, 
	motif VARCHAR2(255 char), 
	PRIMARY KEY (id)
);

CREATE TABLE Livre (
	id NUMBER(19,0) not null, 
	auteur VARCHAR2(255 char), 
	dispo NUMBER(1,0), 
	etat VARCHAR2(255 char), 
	titre VARCHAR2(255 char), 
	domaine NUMBER(19,0), 
	PRIMARY KEY (id)
);

CREATE TABLE Personne (
	id NUMBER(19,0) not null,
	role VARCHAR2(31 char) not null, 
	codepostal VARCHAR2(255 char), 
	email VARCHAR2(255 char), 
	nom VARCHAR2(255 char), 
	numallee VARCHAR2(255 char), 
	numtel VARCHAR2(255 char), 
	pays VARCHAR2(255 char), 
	prenom VARCHAR2(255 char), 
	typevoie VARCHAR2(255 char), 
	ville VARCHAR2(255 char), 
	password VARCHAR2(255 char), 
	username VARCHAR2(255 char), 
	PRIMARY KEY (id)
);





ALTER TABLE emprunt ADD CONSTRAINT FKo6d0w2190bsb61x5yix155mf6 FOREIGN KEY (incident) REFERENCES incident;
ALTER TABLE emprunt ADD CONSTRAINT FK4wj65w7ulgjwick3b8hwn5tem FOREIGN KEY (id_lecteur) REFERENCES personne;
ALTER TABLE emprunt ADD CONSTRAINT FK2c4tf1n0sr8wpaxsw4f3ec2ur FOREIGN KEY (id_livre) REFERENCES livre;
ALTER TABLE livre ADD CONSTRAINT FKno6aivssoq8j0vo4ddxgp9eyd FOREIGN KEY (domaine) REFERENCES domaine;
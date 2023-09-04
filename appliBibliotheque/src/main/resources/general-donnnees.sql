
/*Domaine*/
INSERT INTO Domaine (id, nom, description)  VALUES (1,'livre de biologie','science');
INSERT INTO Domaine (id, nom, description)  VALUES (2,'Fantasy','La fantasy, terme issu de l’anglais fantasy est un genre artistique et littéraire qui représente des phénomènes surnaturels imaginaires.');

/*Incidents*/
INSERT INTO Incident (id,motif) VALUES (1,'motif 1');

/*Livres*/
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine)  VALUES (1,'JKR',1,'BON_ETAT','Harry Potter 1',2);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine)  VALUES (2,'JKR',1,'BON_ETAT','Harry Potter 2',2);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine)  VALUES (3,'JKR',1,'BON_ETAT','Harry Potter 3',2);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine)  VALUES (4,'JKR',1,'BON_ETAT','Harry Potter 4',2);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine)  VALUES (5,'JKR',1,'BON_ETAT','Harry Potter 5',2);

/*Lecteurs*/
INSERT INTO Personne (id, role , nom, prenom)  VALUES (1,'Lecteur','Paul','Dirac');
INSERT INTO Personne (id, role , nom, prenom)  VALUES (2,'Lecteur','Joseph','Staline');

/*Emprunts*/
INSERT INTO Emprunt (id_lecteur , id_livre , date_debut , date_fin , etat, incident) VALUES (1, 1, TO_DATE('2023-09-04 03:05:30', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-09-18 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),  'EFFECTIF', 1);

/*Administrateurs*/
INSERT INTO Personne (id, role , nom, prenom, email, numtel, numallee, typevoie, ville, codepostal, pays, username, password)  
		VALUES (3,'Administrateur','Soulef', 'Saoud', 'soulefsaoud@biblio.fr', '06XXXXXXXX', '5', 'rue de la Biologie', 'Paris', '75012', 'France', 'SoulefS', 'Eucaryote');		
INSERT INTO Personne (id, role , nom, prenom, email, numtel, numallee, typevoie, ville, codepostal, pays, username, password)  
		VALUES (4,'Administrateur','Victor', 'Sicard', 'victor.sicard@biblio.fr', '06XXXXXXXX', '8', 'rue des Mathématiques', 'Paris', '75012', 'France', 'VictorS', 'Cauchy-Schwartz');
INSERT INTO Personne (id, role , nom, prenom, email, numtel, numallee, typevoie, ville, codepostal, pays, username, password)  
		VALUES (5,'Administrateur','Roland', 'Panzou', 'roland.panzou@biblio.fr', '06XXXXXXXX', '3', 'rue de la Chimie', 'Paris', '75012', 'France', 'RolandP', 'Helium');

		
		


				




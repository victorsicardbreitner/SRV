/*Administrateurs*/
INSERT INTO Personne (id, role , nom, prenom, email, numtel, numallee, typevoie, ville, codepostal, pays, username, password)  
		VALUES (1,'Administrateur','Soulef', 'Saoud', 'soulefsaoud@biblio.fr', '06XXXXXXXX', '5', 'rue de la Biologie', 'Paris', '75012', 'France', 'SoulefS', 'Eucaryote');		
INSERT INTO Personne (id, role , nom, prenom, email, numtel, numallee, typevoie, ville, codepostal, pays, username, password)  
		VALUES (2,'Administrateur','Victor', 'Sicard', 'victor.sicard@biblio.fr', '06XXXXXXXX', '8', 'rue des Mathématiques', 'Paris', '75012', 'France', 'VictorS', 'Cauchy-Schwartz');
INSERT INTO Personne (id, role , nom, prenom, email, numtel, numallee, typevoie, ville, codepostal, pays, username, password)  
		VALUES (3,'Administrateur','Roland', 'Panzou', 'roland.panzou@biblio.fr', '06XXXXXXXX', '3', 'rue de la Chimie', 'Paris', '75012', 'France', 'RolandP', 'Helium');



/*Domaine*/
INSERT INTO Domaine (id, nom, description)  VALUES (1,'Fantasy','La fantasy, terme issu de l’anglais fantasy est un genre artistique et littéraire qui représente des phénomènes surnaturels imaginaires.');
INSERT INTO Domaine (id, nom, description) VALUES (2, 'Littérature contemporaine', 'Œuvres littéraires écrites à l’époque moderne et traitant de thèmes actuels.');
INSERT INTO Domaine (id, nom, description) VALUES (3, 'Romans policiers', 'Romans centrés sur une enquête ou une résolution de crime.');
INSERT INTO Domaine (id, nom, description) VALUES (4, 'Science-fiction et fantasy', 'Genres qui explorent des mondes imaginaires, futuristes ou fantastiques.');
INSERT INTO Domaine (id, nom, description) VALUES (5, 'Biographies et mémoires', 'Récits de la vie de personnes réelles.');
INSERT INTO Domaine (id, nom, description) VALUES (6, 'Histoire', 'Étude des événements, cultures et personnes du passé.');
INSERT INTO Domaine (id, nom, description) VALUES (7, 'Géographie et voyages', 'Étude des lieux et cultures du monde.');
INSERT INTO Domaine (id, nom, description) VALUES (8, 'Sciences sociales', 'Étude des comportements humains et des sociétés.');
INSERT INTO Domaine (id, nom, description) VALUES (9, 'Philosophie', 'Exploration des idées fondamentales sur la réalité, la moralité et la connaissance.');
INSERT INTO Domaine (id, nom, description) VALUES (10, 'Religion et spiritualité', 'Étude des croyances et pratiques spirituelles.');
INSERT INTO Domaine (id, nom, description) VALUES (11, 'Sciences naturelles', 'Étude des phénomènes naturels incluant la biologie, la physique, la chimie et l’astronomie.');
INSERT INTO Domaine (id, nom, description) VALUES (12, 'Mathématiques', 'Étude des nombres, quantités, formes et motifs.');
INSERT INTO Domaine (id, nom, description) VALUES (13, 'Technologie et ingénierie', 'Étude et application des inventions et innovations technologiques.');
INSERT INTO Domaine (id, nom, description) VALUES (14, 'Médecine et santé', 'Connaissance et pratique de la santé et du bien-être.');
INSERT INTO Domaine (id, nom, description) VALUES (15, 'Arts', 'Formes diverses d’expressions artistiques, telles que la peinture, la musique, et le théâtre.');
INSERT INTO Domaine (id, nom, description) VALUES (16, 'Littérature pour enfants', 'Ouvrages écrits spécifiquement pour un jeune public.');
INSERT INTO Domaine (id, nom, description) VALUES (17, 'Poésie', 'Forme d’expression littéraire privilégiant le rythme et la métaphore.');
INSERT INTO Domaine (id, nom, description) VALUES (18, 'Bandes dessinées et mangas', 'Histoires racontées à travers des illustrations séquentielles.');
INSERT INTO Domaine (id, nom, description) VALUES (19, 'Cuisine et gastronomie', 'Arts de préparer et de déguster des repas.');
INSERT INTO Domaine (id, nom, description) VALUES (20, 'Sports et loisirs', 'Activités physiques et récréatives pour le plaisir ou la compétition.');
INSERT INTO Domaine (id, nom, description) VALUES (21, 'Informatique et programmation', 'Étude et création de systèmes informatiques et de logiciels.');
INSERT INTO Domaine (id, nom, description) VALUES (22, 'Économie et affaires', 'Étude de la production, distribution et consommation des biens et services.');
INSERT INTO Domaine (id, nom, description) VALUES (23, 'Linguistique et langues étrangères', 'Étude des langues et de leur structure.');
INSERT INTO Domaine (id, nom, description) VALUES (24, 'Guides pratiques et manuels', 'Ouvrages fournissant des instructions ou des informations sur un sujet spécifique.');
INSERT INTO Domaine (id, nom, description) VALUES (25, 'Science et environnement', 'Étude de la nature et de l’impact humain sur notre planète.');
INSERT INTO Domaine (id, nom, description) VALUES (26, 'Mode et design', 'Arts de créer des vêtements et des objets esthétiquement plaisants.');
INSERT INTO Domaine (id, nom, description) VALUES (27, 'Ouvrages de référence', 'Sources d’information comme les dictionnaires et encyclopédies.');
INSERT INTO Domaine (id, nom, description) VALUES (28, 'Éducation et pédagogie', 'Étude de l’enseignement et des méthodes éducatives.');

/*Incidents*/
INSERT INTO Incident (id,motif) VALUES (1,'motif 1');

/*Livres*/
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (1, 'JKR', 1, 'BON_ETAT', 'Harry Potter et la Pierre Philosophale', 1);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (2, 'Haruki Murakami', 1, 'BON_ETAT', 'Kafka sur le rivage', 2);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (3, 'Agatha Christie', 1, 'BON_ETAT', 'Le crime de l’Orient-Express', 3);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (4, 'Isaac Asimov', 1, 'BON_ETAT', 'Les Robots', 4);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (5, 'Anne Frank', 1, 'BON_ETAT', 'Le Journal d’Anne Frank', 5);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (6, 'Yuval Noah Harari', 1, 'BON_ETAT', 'Sapiens: Une brève histoire de l’humanité', 6);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (7, 'Paul Theroux', 1, 'BON_ETAT', 'Le Grand Bazar ferroviaire', 7);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (8, 'Malcolm Gladwell', 1, 'BON_ETAT', 'Le point de basculement', 8);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (9, 'Platon', 1, 'BON_ETAT', 'La République', 9);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (10, 'Dalai Lama', 1, 'BON_ETAT', 'La voie vers l’éveil', 10);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (11, 'Stephen Hawking', 1, 'BON_ETAT', 'Une brève histoire du temps', 11);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (12, 'Marcus du Sautoy', 1, 'BON_ETAT', 'L’Énigme des nombres premiers', 12);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (13, 'Walter Isaacson', 1, 'BON_ETAT', 'Steve Jobs', 13);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (14, 'Atul Gawande', 1, 'BON_ETAT', 'La Checklist: Comment faire les choses bien', 14);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (15, 'Vincent Van Gogh', 1, 'BON_ETAT', 'Lettres à Théo', 15);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (16, 'Roald Dahl', 1, 'BON_ETAT', 'Charlie et la Chocolaterie', 16);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (17, 'Robert Frost', 1, 'BON_ETAT', 'La route non prise', 17);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (18, 'Akira Toriyama', 1, 'BON_ETAT', 'Dragon Ball', 18);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (19, 'Julia Child', 1, 'BON_ETAT', 'Maîtriser l’art de la cuisine française', 19);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (20, 'Phil Jackson', 1, 'BON_ETAT', 'Onze anneaux', 20);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (21, 'Mark Lutz', 1, 'BON_ETAT', 'Apprendre Python', 21);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (22, 'Adam Smith', 1, 'BON_ETAT', 'La richesse des nations', 22);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (23, 'Noam Chomsky', 1, 'BON_ETAT', 'Théories syntaxiques', 23);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (24, 'Marie Kondo', 1, 'BON_ETAT', 'La magie du rangement', 24);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (25, 'David Attenborough', 1, 'BON_ETAT', 'La vie sur Terre', 25);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (26, 'Tim Gunn', 1, 'BON_ETAT', 'Le guide du style', 26);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (27, 'Encyclopedia Britannica', 1, 'BON_ETAT', 'Encyclopédie Britannica', 27);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (28, 'Maria Montessori', 1, 'BON_ETAT', 'L’enfant', 28);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (29, 'T.A. Barron', 1, 'BON_ETAT', 'Les aventures de Merlin', 1);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (30, 'Christopher Paolini', 1, 'BON_ETAT', 'Eragon', 1);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (31, 'Khaled Hosseini', 1, 'BON_ETAT', 'Les cerfs-volants de Kaboul', 2);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (32, 'Jodi Picoult', 1, 'BON_ETAT', 'La couleur de la vérité', 2);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (33, 'Raymond Chandler', 1, 'BON_ETAT', 'Le grand sommeil', 3);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (34, 'Dashiell Hammett', 1, 'BON_ETAT', 'Le faucon maltais', 3);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (35, 'Frank Herbert', 1, 'BON_ETAT', 'Dune', 4);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (36, 'Orson Scott Card', 1, 'BON_ETAT', 'La stratégie Ender', 4);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (37, 'Walter Isaacson', 1, 'BON_ETAT', 'Albert Einstein', 5);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (38, 'Laura Hillenbrand', 1, 'BON_ETAT', 'Invincible', 5);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (39, 'Jared Diamond', 1, 'BON_ETAT', 'Effondrement', 6);
INSERT INTO Livre (id, auteur, dispo, etat, titre, domaine) VALUES (40, 'Howard Zinn', 1, 'BON_ETAT', 'Une histoire populaire des États-Unis', 6);

/*Lecteurs*/
INSERT INTO Personne (id, role , nom, prenom)  VALUES (4,'Lecteur','Dirac','Paul');
INSERT INTO Personne (id, role , nom, prenom)  VALUES (5,'Lecteur','Curie','Marie');
INSERT INTO Personne (id, role, nom, prenom) VALUES (6, 'Lecteur', 'Smith', 'John');
INSERT INTO Personne (id, role, nom, prenom) VALUES (7, 'Lecteur', 'Martinez', 'Sofia');
INSERT INTO Personne (id, role, nom, prenom) VALUES (8, 'Lecteur', 'Nakamura', 'Hiroshi');
INSERT INTO Personne (id, role, nom, prenom) VALUES (9, 'Lecteur', 'Kaur', 'Simran');
INSERT INTO Personne (id, role, nom, prenom) VALUES (10, 'Lecteur', 'Al-Mansoor', 'Ahmed');
INSERT INTO Personne (id, role, nom, prenom) VALUES (11, 'Lecteur', 'El-Hassan', 'Layla');
INSERT INTO Personne (id, role, nom, prenom) VALUES (12, 'Lecteur', 'Okafor', 'Chijioke');
INSERT INTO Personne (id, role, nom, prenom) VALUES (13, 'Lecteur', 'Adesanya', 'Amina');
INSERT INTO Personne (id, role, nom, prenom) VALUES (14, 'Lecteur', 'Leroux', 'Olivier');
INSERT INTO Personne (id, role, nom, prenom) VALUES (15, 'Lecteur', 'Dupont', 'Isabelle');
INSERT INTO Personne (id, role, nom, prenom) VALUES (16, 'Lecteur', 'Wang', 'Li');
INSERT INTO Personne (id, role, nom, prenom) VALUES (17, 'Lecteur', 'Chen', 'Ying');
INSERT INTO Personne (id, role, nom, prenom) VALUES (18, 'Lecteur', 'García', 'Carlos');
INSERT INTO Personne (id, role, nom, prenom) VALUES (19, 'Lecteur', 'Gonzalez', 'Maria');
INSERT INTO Personne (id, role, nom, prenom) VALUES (20, 'Lecteur', 'Patel', 'Raj');
INSERT INTO Personne (id, role, nom, prenom) VALUES (21, 'Lecteur', 'Desai', 'Priya');
INSERT INTO Personne (id, role, nom, prenom) VALUES (22, 'Lecteur', 'Ibrahim', 'Mohamed');
INSERT INTO Personne (id, role, nom, prenom) VALUES (23, 'Lecteur', 'Musa', 'Fatimah');
INSERT INTO Personne (id, role, nom, prenom) VALUES (24, 'Lecteur', 'Andersen', 'Erik');
INSERT INTO Personne (id, role, nom, prenom) VALUES (25, 'Lecteur', 'Johansen', 'Anna');

/*Emprunts*/
INSERT INTO Emprunt (id_lecteur , id_livre , date_debut , date_fin , etat, incident) VALUES (11, 11, TO_DATE('2023-09-04 03:05:30', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-09-18 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),  'EFFECTIF', 1);


		
		


				




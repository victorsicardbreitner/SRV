window.onload = function() {
	
	afficherConnexion();
	
	rechercherEmprunts();

	(document.getElementById("btnRechercher")).addEventListener("click", rechercherEmprunts);

	(document.getElementById("btnAjout")).addEventListener("click", ajouterEmprunt);

	(document.getElementById("btnDelete")).addEventListener("click", supprimerEmprunt);
	
	(document.getElementById("btnUpdate")).addEventListener("click",miseAJourEmprunt);

	/*
	(document.getElementById("btnUpdateDispo")).addEventListener("click", updateLivreDispo);
	
	*/
}

//connecté en tant qu'admin : statut modifié par la fonction "afficher connexion" executée à l'ouverture de la page ou en cas de MAJ
var admin=false;

function afficherConnexion(){	
	let token = sessionStorage.getItem('token');
	let jsonPayload =JSON.parse(parseJwt(token));
	document.getElementById("connexionActuelle").innerHTML=jsonPayload.sub+" "+jsonPayload.authorities+" "+jsonPayload.exp;
	if(jsonPayload.authorities=="[ROLE_ADMIN]"){
		admin=true;
		document.getElementById("colonneAdmin").classList.remove("d-none");
	}
}

function parseJwt (token) {
    let base64Url = token.split('.')[1];
    let base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    let jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));
    return jsonPayload;
    //return JSON.parse(jsonPayload);
};

function errCallbackJson(responseErrCallbackJson) {
	document.getElementById("messageException").classList.remove("d-none");
	let repJs = JSON.parse(responseErrCallbackJson);
	document.getElementById("messageException").innerHTML = repJs.message;
}


function rechercherEmprunts() {

	let wsUrl = "./api-bibli/emprunt?soldeMini="; //l'appel du controller qui fournit le fichier JSON
	makeAjaxGetRequest(wsUrl, function(responseJson) {
		document.getElementById("messageException").classList.add("d-none");
		let empruntsJs = JSON.parse(responseJson);

		let bodyElt = document.getElementById("table_body");
		bodyElt.innerHTML = "";//vider le tableau avant de le reremplir
		for (let emprunt of empruntsJs) {
			let row = bodyElt.insertRow(-1);
			(row.insertCell(0)).innerHTML = emprunt.nomLecteur; //emprunt.livre.titre
			(row.insertCell(1)).innerHTML = emprunt.nomLivre; //emprunt.lecteur.nom
			(row.insertCell(2)).innerHTML = emprunt.dateDebut; //emprunt.date_debut
			(row.insertCell(3)).innerHTML = emprunt.dateFin; //emprunt.date_fin
			(row.insertCell(4)).innerHTML = emprunt.incident; //emprunt.incident
			if(admin){
				(row.insertCell(5)).innerHTML = "<button class='btn btn-danger ' onClick='supprimerEmpruntBouton("+emprunt.idLecteur+","+emprunt.idLivre+")'>Supprimer <i class='fa-solid fa-xmark'></i></button>";
			}
		}
	});
}

function ajouterEmprunt() {
	let idLivre = (document.getElementById("inputIdLivre")).value;
	let idLecteur = (document.getElementById("inputIdLecteur")).value;
	let motifIncident = (document.getElementById("inputMotifIncident")).value;
	let empruntJs = {
		idLivre: idLivre,
		idLecteur: idLecteur
	};
	let empruntJson = JSON.stringify(empruntJs);
	let wsUrl = "./api-bibli/emprunt?idLivre=" + idLivre + "&idLecteur=" + idLecteur+ "&motifIncident=" + motifIncident;
	makeAjaxPostRequest(wsUrl, empruntJson, function(responseJson) {
		document.getElementById("messageException").classList.add("d-none");
		rechercherEmprunts();
	}, errCallbackJson);

}


function supprimerEmprunt() {
	let idLivre = (document.getElementById("inputIdLivre")).value;
	let idLecteur = (document.getElementById("inputIdLecteur")).value;
	let empruntJs = {
		idLivre: idLivre,
		idLecteur: idLecteur
	};
	let empruntJson = JSON.stringify(empruntJs);
	let wsUrl = "./api-bibli/emprunt?idLivre=" + idLivre + "&idLecteur=" + idLecteur;
	makeAjaxDeleteRequest(wsUrl, function(responseJson) {
		document.getElementById("messageException").classList.add("d-none");
		rechercherEmprunts();
	}, errCallbackJson)

}


function miseAJourEmprunt(){
	let idLivre = (document.getElementById("inputIdLivre")).value;
	let idLecteur = (document.getElementById("inputIdLecteur")).value;
	let motifIncident = (document.getElementById("inputMotifIncident")).value;
	let empruntJs = {
		idLivre: idLivre,
		idLecteur: idLecteur
	};
	let empruntJson = JSON.stringify(empruntJs); //motifIncident
	let wsUrl = "./api-bibli/emprunt?idLivre=" + idLivre + "&idLecteur=" + idLecteur+ "&motifIncident=" + motifIncident;
	makeAjaxPutRequest(wsUrl, empruntJson, function(responseJson) {
		document.getElementById("messageException").classList.add("d-none");
		rechercherEmprunts();
	}, errCallbackJson);
}

function supprimerEmpruntBouton(idLecteur,idLivre) {
	let empruntJs = {
		idLivre: idLivre,
		idLecteur: idLecteur
	};
	let empruntJson = JSON.stringify(empruntJs);
	let wsUrl = "./api-bibli/emprunt?idLivre=" + idLivre + "&idLecteur=" + idLecteur;
	makeAjaxDeleteRequest(wsUrl, function(responseJson) {
		document.getElementById("messageException").classList.add("d-none");
		rechercherEmprunts();
	}, errCallbackJson)

}

/*
function updateLivreEtat(){
	 let labelLivreUpdateEtat = (document.getElementById("inputLabelLivreUpdateEtat")).value;
	 let labelIdLivre = (document.getElementById("inputLabelIdLivreEtat")).value;
	 var  dispoVar= new Boolean(true);
	 
    
	 let livreUpdateEtatJs = {id : labelIdLivre,
								   dispo: dispoVar,
								   etat: labelLivreUpdateEtat.toUpperCase()};
	 
	 if(labelLivreUpdateEtat.toUpperCase() == "HORS_SERVICE") dispoVar = false;
	   	
	 livreUpdateEtatJs = {id : labelIdLivre,
								dispo: dispoVar,
								etat: labelLivreUpdateEtat.toUpperCase()};
	
	 let livreUpdateEtatJson = JSON.stringify(livreUpdateEtatJs);
	 
	 let wsUrl= "./api-bibli/livre/";
	 makeAjaxPutRequest(wsUrl,livreUpdateEtatJson, function(responseJson){
		  rechercherLivres();
	 })
	 
}
*/




window.onload=function(){
	
	(document.getElementById("btnRechercher")).addEventListener("click",rechercherAdministrateursSelonSoldeMini);
	(document.getElementById("btnAjout")).addEventListener("click", ajouterLecteur);
	
}

function rechercherAdministrateursSelonSoldeMini(){
	let soldeMini = (document.getElementById("inputSoldeMini")).value;
		
	let wsUrl = "./api-bibli/admin?soldeMini="+soldeMini; //l'appel du controller qui fournit le fichier JSON
	makeAjaxGetRequest(wsUrl,function(responseJson){
		let adminsJs = JSON.parse(responseJson);
		//console.log("comptesJs="+livresJs);
		
		let bodyElt = document.getElementById("table_body");
		bodyElt.innerHTML="";//vider le tableau avant de le reremplir
		for(let admin of adminsJs){
			let row = bodyElt.insertRow(-1);
			(row.insertCell(0)).innerHTML = lecteur.id;
			(row.insertCell(1)).innerHTML = lecteur.prenom;
			(row.insertCell(2)).innerHTML = lecteur.nom;
			(row.insertCell(3)).innerHTML = lecteur.codepostal;
			(row.insertCell(4)).innerHTML = lecteur.email;
			(row.insertCell(5)).innerHTML = lecteur.numallee;
			(row.insertCell(6)).innerHTML = lecteur.numtel;
			(row.insertCell(7)).innerHTML = lecteur.pays;
			(row.insertCell(8)).innerHTML = lecteur.typevoie;
			(row.insertCell(9)).innerHTML = lecteur.ville;
			(row.insertCell(10)).innerHTML = lecteur.password;
			(row.insertCell(11)).innerHTML = lecteur.username;
		}
	});
	
}

 function ajouterAdmin(){
	  let labelPrenom = (document.getElementById("inputLabelPrenom")).value;
	  console.log("LABEL "+ labelPrenom);
	  let labelNom = (document.getElementById("inputLabelNom")).value;
	  let adminJs = {prenom : labelPrenom,
	  				 nom : labelNom};
	  let adminJson= JSON.stringify(adminJs);
	   let wsUrl= "./api-bibli/lecteur";
	    makeAjaxPostRequest(wsUrl, adminJson,function(responseJson){
			console.log("responseJson=", responseJson);
		    rechercherLecteursSelonSoldeMini();
		});
   
 }
 

window.onload=function(){
	
	(document.getElementById("btnRechercher")).addEventListener("click",rechercherLecteursSelonSoldeMini);
	(document.getElementById("btnAjout")).addEventListener("click", ajouterLecteur);
	
}

function rechercherLecteursSelonSoldeMini(){
	let soldeMini = (document.getElementById("inputSoldeMini")).value;
		
	let wsUrl = "./api-bibli/lecteur?soldeMini="+soldeMini; //l'appel du controller qui fournit le fichier JSON
	makeAjaxGetRequest(wsUrl,function(responseJson){
		let lecteursJs = JSON.parse(responseJson);
		//console.log("comptesJs="+livresJs);
		
		let bodyElt = document.getElementById("table_body");
		bodyElt.innerHTML="";//vider le tableau avant de le reremplir
		for(let lecteur of lecteursJs){
			let row = bodyElt.insertRow(-1);
			(row.insertCell(0)).innerHTML = lecteur.id;
			(row.insertCell(1)).innerHTML = lecteur.prenom;
			(row.insertCell(2)).innerHTML = lecteur.nom;
		}
	});
	
}

 function ajouterLecteur(){
	  let labelPrenom = (document.getElementById("inputLabelPrenom")).value;
	  console.log("LABEL "+ labelPrenom);
	  let labelNom = (document.getElementById("inputLabelNom")).value;
	  let lecteurJs = {prenom : labelPrenom,
	  				 nom : labelNom};
	  let lecteurJson= JSON.stringify(lecteurJs);
	   let wsUrl= "./api-bibli/lecteur";
	    makeAjaxPostRequest(wsUrl, lecteurJson,function(responseJson){
			console.log("responseJson=", responseJson);
		    rechercherLecteursSelonSoldeMini();
		});
   
 }
 

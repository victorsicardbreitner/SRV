window.onload=function(){
	
	(document.getElementById("btnRechercher")).addEventListener("click",rechercherEmprunts);
	
	(document.getElementById("btnAjout")).addEventListener("click", ajouterEmprunt);
	/*
	(document.getElementById("btnDelete")).addEventListener("click", deleteLivre);
	(document.getElementById("btnUpdateDispo")).addEventListener("click", updateLivreDispo);
	(document.getElementById("btnUpdateEtat")).addEventListener("click",updateLivreEtat);
	*/
}



function rechercherEmprunts(){
	
	let wsUrl = "./api-bibli/emprunt?soldeMini="; //l'appel du controller qui fournit le fichier JSON
	makeAjaxGetRequest(wsUrl,function(responseJson){
		let empruntsJs = JSON.parse(responseJson);
		
		let bodyElt = document.getElementById("table_body");
		bodyElt.innerHTML="";//vider le tableau avant de le reremplir
		for(let emprunt of empruntsJs){
			let row = bodyElt.insertRow(-1);
			(row.insertCell(0)).innerHTML = emprunt.livre.titre;
			(row.insertCell(1)).innerHTML = emprunt.lecteur.nom;
			(row.insertCell(2)).innerHTML = emprunt.date_debut;
			(row.insertCell(3)).innerHTML = emprunt.date_fin;
		}
	});
	/*document.getElementById('idMessage').innerHTML="ok";*/
}

 function ajouterEmprunt(){
	  let idLivre = (document.getElementById("inputIdLivre")).value;
	  let idLecteur = (document.getElementById("inputIdLecteur")).value;
	  let empruntJs = {idLivre : idLivre,
	  				 idLivre: idLecteur};
	  let empruntJson= JSON.stringify(empruntJs);
	   let wsUrl= "./api-bibli/emprunt?idLivre="+idLivre+"&idLecteur="+idLecteur;
	    makeAjaxPostRequest(wsUrl, empruntJson,function(responseJson){
			 rechercherEmprunts();
		});
   
 }
 
 /*
 function deleteLivre(){
	 
	 let labelLivreDelete = (document.getElementById("inputLabelLivreDelete")).value;
	 	 
	 let wsUrl= "./api-bibli/livre/"+labelLivreDelete; 
	 makeAjaxDeleteRequest(wsUrl,function(responseJson){
		 rechercherLivres();
	 })
	 
 }
 
 function updateLivreDispo(){
	  let labelLivreUpdateDispo = (document.getElementById("inputLabelLivreUpdateDispo")).value;
	  let labelIdLivre = (document.getElementById("inputLabelIdLivre")).value;
	  let livreUpdateDispoJs = {id : labelIdLivre,
	  							dispo: labelLivreUpdateDispo};
		  						
	  let livreUpdateDispoJson = JSON.stringify(livreUpdateDispoJs);
	  
	  let wsUrl= "./api-bibli/livre/";
	  console.log("TEST UPDATE ", labelIdLivre+"  "+ livreUpdateDispoJs.dispo);
	  makeAjaxPutRequest(wsUrl,livreUpdateDispoJson, function(responseJson){
		    rechercherLivres();
	  })
	  
 }
 
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


 

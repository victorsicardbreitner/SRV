window.onload=function(){
	
	(document.getElementById("btnRechercher")).addEventListener("click",rechercherLecteursSelonSoldeMini);
	(document.getElementById("btnAjout")).addEventListener("click", ajouterLivre);
	(document.getElementById("btnDelete")).addEventListener("click", deleteLivre);
	(document.getElementById("btnUpdateDispo")).addEventListener("click", updateLivreDispo);
	(document.getElementById("btnUpdateEtat")).addEventListener("click",updateLivreEtat);
}

function rechercherLivresSelonSoldeMini(){
	let soldeMini = (document.getElementById("inputSoldeMini")).value;
		
	let wsUrl = "./api-bibli/livre?soldeMini="+soldeMini; //l'appel du controller qui fournit le fichier JSON
	makeAjaxGetRequest(wsUrl,function(responseJson){
		let livresJs = JSON.parse(responseJson);
		//console.log("comptesJs="+livresJs);
		
		let bodyElt = document.getElementById("table_body");
		bodyElt.innerHTML="";//vider le tableau avant de le reremplir
		for(let livre of livresJs){
			let row = bodyElt.insertRow(-1);
			(row.insertCell(0)).innerHTML = livre.id;
			(row.insertCell(1)).innerHTML = livre.titre;
			(row.insertCell(2)).innerHTML = livre.auteur;
			(row.insertCell(3)).innerHTML = livre.dispo;
			(row.insertCell(4)).innerHTML = livre.etat;
		}
	});
	
}

 function ajouterLivre(){
	  let labelTitre = (document.getElementById("inputLabelTitre")).value;
	  let labelAuteur = (document.getElementById("inputLabelAuteur")).value;
	  let livreJs = {titre : labelTitre,
	  				 auteur: labelAuteur};
	  let livreJson= JSON.stringify(livreJs);
	   let wsUrl= "./api-bibli/livre";
	    makeAjaxPostRequest(wsUrl, livreJson,function(responseJson){
			 rechercherLivresSelonSoldeMini();
		});
   
 }
 
 function deleteLivre(){
	 
	 let labelLivreDelete = (document.getElementById("inputLabelLivreDelete")).value;
	 	 
	 let wsUrl= "./api-bibli/livre/"+labelLivreDelete; 
	 makeAjaxDeleteRequest(wsUrl,function(responseJson){
		 rechercherLivresSelonSoldeMini();
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
		    rechercherLivresSelonSoldeMini();
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
		   rechercherLivresSelonSoldeMini();
	  })
	  
 }
     


 

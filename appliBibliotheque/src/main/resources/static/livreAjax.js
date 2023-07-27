window.onload=function(){
	
	(document.getElementById("btnRechercher")).addEventListener("click",rechercherLivresSelonSoldeMini);
	(document.getElementById("btnAjout")).addEventListener("click", ajouterLivre);
	(document.getElementById("btnDelete")).addEventListener("click", deleteLivre);
	(document.getElementById("btnUpdate")).addEventListener("click", updateLivre);
	
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
		}
	});
	
}

 function ajouterLivre(){
	  let labelTitre = (document.getElementById("inputLabelTitre")).value;
	  console.log("LABEL "+ labelTitre);
	  let labelAuteur = (document.getElementById("inputLabelAuteur")).value;
	  let livreJs = {titre : labelTitre,
	  				 auteur: labelAuteur};
	  let livreJson= JSON.stringify(livreJs);
	   let wsUrl= "./api-bibli/livre";
	    makeAjaxPostRequest(wsUrl, livreJson,function(responseJson){
			console.log("responseJson=", responseJson);
		    rechercherLivresSelonSoldeMini();
		});
   
 }
 
 function deleteLivre(){
	 
	 let labelLivreDelete = (document.getElementById("inputLabelLivreDelete")).value;
	 //let livreDeleteJs = {id: labelLivreDelete};
	// let livreDeleteJson = JSON.stringify(livreDeleteJs);
	 
	 let wsUrl= "./api-bibli/livre/"+ labelLivreDelete; 
	 makeAjaxDeleteRequest(wsUrl,function(responseJson){
		 console.log("responseJson=", responseJson);
		    rechercherLivresSelonSoldeMini();
	 })
	 
 }
 
 function updateLivre(){
	  let labelLivreUpdateDispo = (document.getElementById("inputLabelLivreUpdateDispo")).value;
	  let labelIdLivre = (document.getElementById("inputLabelIdLivre")).value;
	  let livreUpdateDispoJs = {id : labelIdLivre,
		  						dispo: labelLivreUpdateDispo};
	  let livreUpdateDispoJson = JSON.stringify(livreUpdateDispoJs);
	  
	  let wsUrl= "./api-bibli/livre/";
	  
	  makeAjaxPostRequest(wsUrl,livreUpdateDispoJson, function(responseJson){
		   console.log("responseJson=", responseJson);
		    rechercherLivresSelonSoldeMini();
	  })
	  
 }
 
 
     


 

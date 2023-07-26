window.onload=function(){
	
	(document.getElementById("btnRechercher")).addEventListener("click",rechercherLivresSelonSoldeMini);
	
}

function rechercherLivresSelonSoldeMini(){
	let soldeMini = (document.getElementById("inputSoldeMini")).value;
	
	
	let wsUrl = "./api-bibli/livre?soldeMini="+soldeMini; //l'appel du controller qui fournit le fichier JSON
	makeAjaxGetRequest(wsUrl,function(responseJson){
		let livresJs = JSON.parse(responseJson);
		console.log("comptesJs="+livresJs);
		
		let bodyElt = document.getElementById("table_body");
		bodyElt.innerHTML="";//vider le tableau avant de le reremplir
		for(let livre of livresJs){
			let row = bodyElt.insertRow(-1);
			(row.insertCell(0)).innerHTML = livre.id;
			(row.insertCell(1)).innerHTML = livre.titre;
			(row.insertCell(2)).innerHTML = livre.auteur;
		}
	});
	
}
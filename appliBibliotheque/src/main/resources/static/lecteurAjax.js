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

 function ajouterLecteur(){
	  let labelPrenom = (document.getElementById("inputLabelPrenom")).value;
	  console.log("LABEL "+ labelPrenom);
	  let labelNom = (document.getElementById("inputLabelNom")).value;
	  let labelUsername = (document.getElementById("inputLabelUsername")).value;
	  let labelEmail = (document.getElementById("inputLabelEmail")).value;
	  let labelNumtel = (document.getElementById("inputLabelNumtel")).value;
	  let labelPassword = (document.getElementById("inputLabelPassword")).value;
	  let labelNumallee = (document.getElementById("inputLabelNumallee")).value;
	  let labelTypevoie = (document.getElementById("inputLabelTypevoie")).value;
	  let labelCodepostal = (document.getElementById("inputLabelCodepostal")).value;
	  let labelVille = (document.getElementById("inputLabelVille")).value;
	  let labelPays = (document.getElementById("inputLabelPays")).value;
	  let lecteurJs = {prenom : labelPrenom,
	  				 nom : labelNom,
	  				 username : labelUsername,
	  				 email : labelEmail,
	  				 numtel : labelNumtel,
	  				 password : labelPassword,
	  				 numallee : labelNumallee,
	  				 typevoie : labelTypevoie,
	  				 codepostal : labelCodepostal,
	  				 ville : labelVille,
	  				 pays : labelPays};
	  let lecteurJson= JSON.stringify(lecteurJs);
	   let wsUrl= "./api-bibli/lecteur";
	    makeAjaxPostRequest(wsUrl, lecteurJson,function(responseJson){
			console.log("responseJson=", responseJson);
		    rechercherLecteursSelonSoldeMini();
		});
   
 }
 
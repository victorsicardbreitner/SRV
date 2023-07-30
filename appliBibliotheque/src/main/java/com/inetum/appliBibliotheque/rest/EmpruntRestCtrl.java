package com.inetum.appliBibliotheque.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inetum.appliBibliotheque.dao.DaoEmpruntJpa;
import com.inetum.appliBibliotheque.dao.DaoLecteur;
import com.inetum.appliBibliotheque.dao.DaoLivre;
import com.inetum.appliBibliotheque.entity.Emprunt;
import com.inetum.appliBibliotheque.entity.EmpruntCompositePk;
import com.inetum.appliBibliotheque.entity.Lecteur;
import com.inetum.appliBibliotheque.entity.Livre;
import com.inetum.appliBibliotheque.init.InitDataSet;


@RestController
@RequestMapping(value="/api-bibli/emprunt" , headers="Accept=application/json")
//ATTENTION origins = "*" peut être un problème de sécurité
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST}) //pour autoriser les appels extérieurs  Cross-origin resource sharing
public class EmpruntRestCtrl {
	
	Logger logger = LoggerFactory.getLogger(InitDataSet.class);
	
	@Autowired
	private DaoEmpruntJpa daoEmpruntJpa;
	
	@Autowired
	private DaoLivre daoLivreJpa;
	
	@Autowired
	private DaoLecteur daoLecteurJpa;
	
	/*
	@GetMapping("/{idEmprunt}")
	public ResponseEntity<?> getCompteByNumero(@PathVariable("idEmprunt") EmpruntCompositePk id) {
		Emprunt emprunt = daoEmpruntJpa.findById(id);
		if(emprunt!=null) {
			return new ResponseEntity<Emprunt>(emprunt, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String> ("{ \"err\" : \"emprunt non trouvé\"}", HttpStatus.NOT_FOUND) ;
		}
	}
	*/
	
	@GetMapping("")
	public List<Emprunt> getComptes(@RequestParam(value="soldeMini",required=false) Double soldeMini){
			return daoEmpruntJpa.findAll();
	}
	
	
	//ex de fin URL: ./api-bibli/emprunt?idLivre=2&idLecteur=4
	// appelé en mode POST avec dans la partie invisible "body" de la requête
	@PostMapping("")
	public Emprunt postEmprunt(@RequestParam(value="idLivre",required=false) Long idLivre, @RequestParam(value="idLecteur",required=false) Long idLecteur) {
		

		Livre livre = daoLivreJpa.findById(idLivre);
		Lecteur lecteur = daoLecteurJpa.findById(idLecteur);
		
		
		logger.debug("Livre : "+ livre.getTitre());
		logger.debug("Lecteur : "+ lecteur.getNom());
		
		
		Emprunt EmpruntEnregistreEnBase = daoEmpruntJpa.insert(new Emprunt(livre,lecteur));
		return EmpruntEnregistreEnBase;
	}
	
	
	//exemple de fin d'URL:  ./api-bibli/emprunt?idLivre=2&idLecteur=1
	@DeleteMapping("?idLivre={idLivre}&idLecteur={idLecteur}")
	public ResponseEntity<?> deleteEmpruntByNumero(@RequestParam(value="idLivre",required=true) Long idLivre, @RequestParam(value="idLecteur",required=true) Long idLecteur) {
		EmpruntCompositePk idEmprunt=new EmpruntCompositePk(idLivre,idLecteur);
	    Emprunt EmpruntAsupprimer = daoEmpruntJpa.findById(idEmprunt);
	    System.out.println("Emprunt supprimer"+ EmpruntAsupprimer);
	    if(EmpruntAsupprimer == null) 
	    	   		 return new ResponseEntity<String>("{ \"err\" : \"Emprunt not found\"}" ,
	 			           HttpStatus.NOT_FOUND);//40
	    daoEmpruntJpa.deleteById(idEmprunt);
	    return new ResponseEntity<>("{ \"done\" : \"Emprunt deleted\"}" ,
	    	   HttpStatus.OK);
	    // ou bien
	   // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    		    
	}
	
	@PutMapping("" )
	public  ResponseEntity<?> updateEmprunt(@RequestBody Emprunt EmpruntUpdated){
		EmpruntCompositePk numEmpruntToUpdate = EmpruntUpdated.getId();
		Emprunt EmpruntQuiDevraitExister = daoEmpruntJpa.findById(numEmpruntToUpdate);
	
	    if(EmpruntQuiDevraitExister==null)
	    	return new ResponseEntity<String>("{ \"err\" : \"Emprunt not found\"}" ,
			           HttpStatus.NOT_FOUND); //NOT_FOUND = code http 404
	    
	    EmpruntUpdated.setIncident(EmpruntQuiDevraitExister.getIncident());
	    
		daoEmpruntJpa.update(EmpruntUpdated);
		return new ResponseEntity<Emprunt>(EmpruntUpdated , HttpStatus.OK);
    }

		
}
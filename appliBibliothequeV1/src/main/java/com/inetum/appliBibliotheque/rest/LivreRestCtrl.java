package com.inetum.appliBibliotheque.rest;

import java.util.List;

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

import com.inetum.appliBibliotheque.dao.DaoLivreJpa;
import com.inetum.appliBibliotheque.entity.Livre;


@RestController
@RequestMapping(value="/api-bibli/livre" , headers="Accept=application/json")
//ATTENTION origins = "*" peut être un problème de sécurité
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST}) //pour autoriser les appels extérieurs  Cross-origin resource sharing
public class LivreRestCtrl {
	
	@Autowired
	private DaoLivreJpa daoLivreJpa;
	

	@GetMapping("/{idLivre}")
	public ResponseEntity<?> getCompteByNumero(@PathVariable("idLivre") Long id) {
		Livre livre = daoLivreJpa.findById(id);
		if(livre!=null) {
			return new ResponseEntity<Livre>(livre, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String> ("{ \"err\" : \"livre not found\"}", HttpStatus.NOT_FOUND) ;
		}
	}
	
	@GetMapping("")
	public List<Livre> getComptes(@RequestParam(value="soldeMini",required=false) Double soldeMini){
			return daoLivreJpa.findAll();
	}
	
	
	//ex de fin URL: ./api-bibli/livre
	// appelé en mode POST avec dans la partie invisible "body" de la requête
	@PostMapping("" )
	public Livre postLivre(@RequestBody Livre nouveauLivre) {
		System.out.println(" nouveau Livre "+ nouveauLivre);
		nouveauLivre.setDispo(true);
		Livre livreEnregistreEnBase = daoLivreJpa.insert(nouveauLivre);
		return livreEnregistreEnBase; // on retourne le livre avec la clé primaire auto-incrémentée
	}
	
	
	//exemple de fin d'URL:  ./api-bibli/livre/1
	@DeleteMapping("/{idLivre}" )
	public ResponseEntity<?> deleteLivreByNumero(@PathVariable("idLivre") Long id) {
	    Livre livreAsupprimer = daoLivreJpa.findById(id);
	    System.out.println("livre supprimer"+ livreAsupprimer);
	    if(livreAsupprimer == null) 
	    	   		 return new ResponseEntity<String>("{ \"err\" : \"livre not found\"}" ,
	 			           HttpStatus.NOT_FOUND);//40
	    daoLivreJpa.deleteById(id);
	    return new ResponseEntity<>("{ \"done\" : \"livre deleted\"}" ,
	    	   HttpStatus.OK);
	    // ou bien
	   // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    		    
	}
	
	@PutMapping("" )
	public  ResponseEntity<?> updateLivre(@RequestBody Livre livreUpdated){
		Long numLivreToUpdate = livreUpdated.getId();
		Livre livreQuiDevraitExister = daoLivreJpa.findById(numLivreToUpdate);
	
	    if(livreQuiDevraitExister==null)
	    	return new ResponseEntity<String>("{ \"err\" : \"livre not found\"}" ,
			           HttpStatus.NOT_FOUND); //NOT_FOUND = code http 404
	    
	    livreUpdated.setAuteur(livreQuiDevraitExister.getAuteur());
	    livreUpdated.setTitre(livreQuiDevraitExister.getTitre());
	    livreUpdated.setDispo(livreUpdated.getDispo());
	    
		daoLivreJpa.update(livreUpdated);
		return new ResponseEntity<Livre>(livreUpdated , HttpStatus.OK);
    }

		
}

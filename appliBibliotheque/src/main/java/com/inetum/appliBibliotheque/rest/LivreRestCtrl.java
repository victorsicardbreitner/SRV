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

import com.inetum.appliBibliotheque.dto.LivreDto;
import com.inetum.appliBibliotheque.entity.Lecteur;
import com.inetum.appliBibliotheque.entity.Livre;
import com.inetum.appliBibliotheque.service.ServiceLecteur;
import com.inetum.appliBibliotheque.service.ServiceLivre;


@RestController
@RequestMapping(value="/api-bibli/livre" , headers="Accept=application/json")
//ATTENTION origins = "*" peut être un problème de sécurité
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST}) //pour autoriser les appels extérieurs  Cross-origin resource sharing
public class LivreRestCtrl {

	
	@Autowired
	private ServiceLivre serviceLivre;
	
	@Autowired
	private ServiceLecteur serviceLecteur;

	

	@GetMapping("/{idLivre}")
	public ResponseEntity<?> getLivreById(@PathVariable("idLivre") Long id) {
		Livre livre = serviceLivre.trouverParId(id);
		if(livre!=null) {
			return new ResponseEntity<Livre>(livre, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String> ("{ \"err\" : \"livre not found\"}", HttpStatus.NOT_FOUND) ;
		}
	}
	
	
	
	@GetMapping("/livresEmpruntesActuel") //faire les erreurs
	public List<Livre> getLivresActuelByLecteur(@RequestParam(value="idLecteur",required=false) Long idLecteur) {
		Lecteur lecteur = serviceLecteur.trouverParId(idLecteur);
		return serviceLivre.trouverLivreActuelParLecteur(lecteur);
	}
	
	@GetMapping("/livresEmpruntes") //faire les erreurs
	public List<Livre> getLivresByLecteur(@RequestParam(value="idLecteur",required=false) Long idLecteur) {
		Lecteur lecteur = serviceLecteur.trouverParId(idLecteur);
		return serviceLivre.trouverLivreParLecteur(lecteur);
	}
	
	@GetMapping("")
	public List<LivreDto> getLivres(){
			return serviceLivre.trouverToutDto();
	}
	
	
	//ex de fin URL: ./api-bibli/livre
	// appelé en mode POST avec dans la partie invisible "body" de la requête
	@PostMapping("" )
	public Livre postLivre(@RequestBody Livre nouveauLivre) {
		System.out.println("nouveauLIvre "+ nouveauLivre);
		nouveauLivre.setDispo(true);
		Livre livreEnregistreEnBase = serviceLivre.sauvegarder(nouveauLivre);
		return livreEnregistreEnBase; // on retourne le livre avec la clé primaire auto-incrémentée
	}
	
	
	//exemple de fin d'URL:  ./api-bibli/livre/1
	@DeleteMapping("/{idLivre}" )
	public ResponseEntity<?> deleteLivreByNumero(@PathVariable("idLivre") Long id) {
	    Livre livreAsupprimer = serviceLivre.trouverParId(id);
	    System.out.println("livre supprimer"+ livreAsupprimer);
	    if(livreAsupprimer == null) 
	    	   		 return new ResponseEntity<String>("{ \"err\" : \"livre not found\"}" ,
	 			           HttpStatus.NOT_FOUND);//40
	    serviceLivre.suppressionParId(id);
	    return new ResponseEntity<>("{ \"done\" : \"livre deleted\"}" ,
	    	   HttpStatus.OK);
	    // ou bien
	   // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    		    
	}
	
	@PutMapping("" )
	public  ResponseEntity<?> updateLivre(@RequestBody Livre livreUpdated){
		Long numLivreToUpdate = livreUpdated.getId();
		Livre livreQuiDevraitExister = serviceLivre.trouverParId(numLivreToUpdate);
	
	    if(livreQuiDevraitExister==null)
	    	return new ResponseEntity<String>("{ \"err\" : \"livre not found\"}" ,
			           HttpStatus.NOT_FOUND); //NOT_FOUND = code http 404
	    
	    livreUpdated.setAuteur(livreQuiDevraitExister.getAuteur());
	    livreUpdated.setTitre(livreQuiDevraitExister.getTitre());
	    livreUpdated.setDispo(livreUpdated.getDispo());
	    
		serviceLivre.sauvegarder(livreUpdated);
		return new ResponseEntity<Livre>(livreUpdated , HttpStatus.OK);
    }

		
}

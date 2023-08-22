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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inetum.appliBibliotheque.dao.DaoLecteur;
import com.inetum.appliBibliotheque.entity.Lecteur;



@RestController
@RequestMapping(value="/api-bibli/lecteur" , headers="Accept=application/json")
//ATTENTION origins = "*" peut être un problème de sécurité
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST}) //pour autoriser les appels extérieurs  Cross-origin resource sharing
public class LecteurRestCtrl {
	
	@Autowired
	private DaoLecteur daoLecteurJpa;
	

	@GetMapping("/{idLecteur}")
	public ResponseEntity<?> getLecteurById(@PathVariable("idLecteur") Long id) {
		Lecteur lecteur = daoLecteurJpa.findById(id).orElse(null);
		if(lecteur!=null) {
			return new ResponseEntity<Lecteur>(lecteur, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String> ("{ \"err\" : \"lecteur not found\"}", HttpStatus.NOT_FOUND) ;
		}
	}
	
	@GetMapping("")
	public List<Lecteur> getComptes(@RequestParam(value="soldeMini",required=false) Double soldeMini){
			return daoLecteurJpa.findAll();
	}
	
	
	//ex de fin URL: ./api-bibli/lecteur
	// appelé en mode POST avec dans la partie invisible "body" de la requête
	@PostMapping("" )
	public Lecteur postLecteur(@RequestBody Lecteur nouveauLecteur) {
		System.out.println("nouveauLecteur "+ nouveauLecteur);
		Lecteur lecteurEnregistreEnBase = daoLecteurJpa.save(nouveauLecteur);
		return lecteurEnregistreEnBase; // on retourne le lecteur avec la clé primaire auto-incrémentée
	}
	
	
	//exemple de fin d'URL: ./api-bank/compte/1
	@DeleteMapping("/{idLecteur}" )
	public ResponseEntity<?> deleteLecteurByNumero(@PathVariable("idLecteur") Long id) {
	    Lecteur lecteurAsupprimer = daoLecteurJpa.findById(id).orElse(null);
	    if(lecteurAsupprimer == null) 
	    	   		 return new ResponseEntity<String>("{ \"err\" : \"lecteur not found\"}" ,
	 			           HttpStatus.NOT_FOUND);//40
	    daoLecteurJpa.deleteById(id);
	    return new ResponseEntity<>("{ \"done\" : \"lecteur deleted\"}" ,
	    	   HttpStatus.OK);
	    // ou bien
	   // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    		    
	}
	
	
	
}

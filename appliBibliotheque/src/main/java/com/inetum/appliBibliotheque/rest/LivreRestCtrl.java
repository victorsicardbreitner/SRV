package com.inetum.appliBibliotheque.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
}

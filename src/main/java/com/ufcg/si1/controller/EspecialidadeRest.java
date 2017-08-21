package com.ufcg.si1.controller;

import java.util.List;

import javax.ejb.EJB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.service.EspecialidadeService;
import com.ufcg.si1.util.CustomErrorType;

import com.ufcg.si1.exceptions.ObjetoJaExistenteException;
import com.ufcg.si1.exceptions.Rep;

@RestController
@RequestMapping("/especialidade")
@CrossOrigin
public class EspecialidadeRest {
	
	@Autowired
	private EspecialidadeService especialidadeService;
	
	@RequestMapping(value = "/insere", method = RequestMethod.POST)
    public ResponseEntity<Especialidade> incluirEspecialidade(@RequestBody Especialidade esp) throws Exception {
        try {
        	System.out.println(esp);
            especialidadeService.insere(esp);
            	
        } catch (Exception e) {
            return new ResponseEntity<Especialidade>(HttpStatus.BAD_REQUEST);
        } 
       return new ResponseEntity<Especialidade>(HttpStatus.CREATED);
    }
	
	//Analisar necessidade
	@RequestMapping(value = "/busca/{id}", method = RequestMethod.GET)
    public ResponseEntity<Especialidade> consultarEspecialidade(@PathVariable("id") long id) {

        Especialidade q = especialidadeService.findById(id);
        if (q == null) {
            return new ResponseEntity(new CustomErrorType("Especialidade with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Especialidade>(q, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/unidadesComEspecialidade/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<List> unidadesComEspecialidade(@PathVariable("codigo") int codigo){
		List<Long> unidades = especialidadeService.unidadesComEsecialidade(codigo);
		if (unidades.isEmpty()) {
			return new ResponseEntity<List>(HttpStatus.NOT_FOUND);
		} return new ResponseEntity<List>(unidades, HttpStatus.OK);
	}
	

}

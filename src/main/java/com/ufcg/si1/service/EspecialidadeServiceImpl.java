package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.repositories.EspecialidadeRepository;
import com.ufcg.si1.exceptions.ObjetoInexistenteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("especialidadeService")
public class EspecialidadeServiceImpl implements EspecialidadeService {

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

    @Override
    public void insere(Especialidade esp){
    	esp.setDescricao(esp.getDescricao().toLowerCase());
    	especialidadeRepository.save(esp);
    }

	@Override
	public Especialidade findById(long id) {
		return especialidadeRepository.findById(id);
	}

	public List<Long> unidadeIdsComEspecialidade(String nome){
		return (especialidadeRepository.findByNome(nome)).getIdUs();
	}

	@Override
	public List<Long> unidadesComEspecialidade(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Especialidade >getAll() {
		return especialidadeRepository.findAll();}
	
	
	}


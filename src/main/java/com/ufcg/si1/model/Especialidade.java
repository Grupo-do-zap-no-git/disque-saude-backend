package com.ufcg.si1.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity
public class Especialidade {

   
    private Long id;
    private String nome;
    private String descricao;
    private List<Long> idUs;

	public Especialidade(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
          }
	
	 public Especialidade() {
		// TODO Auto-generated constructor stub
	}
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="idUs", updatable = false)
	@ElementCollection(targetClass=Long.class)
	public List<Long> getIdUs() {
		return idUs;
	}

	public void setIdUs(List<Long> idUs) {
		this.idUs = idUs;
	}


    @Column(name="descricao", updatable=false)
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name="nome", updatable=false)
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

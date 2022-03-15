package com.gabriel.teste.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pessoa {

	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@EqualsAndHashCode.Include
	@JsonIgnore
	private Integer id;
	
	private String nome;
	@JsonIgnore
	private String telefone;
	@JsonIgnore
	private int idade;
	
	private String cidade;
	private String estado;
	@JsonIgnore
	private Integer score;
	
	@Transient
	private String scoreDescricao;
	
}

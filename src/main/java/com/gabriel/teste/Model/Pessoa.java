package com.gabriel.teste.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pessoa {

	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	
	private String nome;
	private String telefone;
	private int idade;
	private String cidade;
	private String estado;
	private Integer score;
	
	
}

package com.gabriel.teste.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gabriel.teste.Model.Pessoa;
import com.gabriel.teste.Repository.PessoaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PessoaService {

	private PessoaRepository pessoaRepository;

	@Transactional
	public List<Pessoa> findAllPessoas() {
		return pessoaRepository.findAll();
	}

	@Transactional
	public ResponseEntity<Pessoa> findById(Integer id) {
		return pessoaRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());

	}

	@Transactional
	public Pessoa savePessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

}

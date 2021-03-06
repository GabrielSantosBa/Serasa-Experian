package com.gabriel.teste.Service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gabriel.teste.Model.Pessoa;
import com.gabriel.teste.Repository.PessoaRepository;
import com.gabriel.teste.ScoreDescricao.ScoreAceitavel;
import com.gabriel.teste.ScoreDescricao.ScoreInaceitavel;
import com.gabriel.teste.ScoreDescricao.ScoreInsuficiente;
import com.gabriel.teste.ScoreDescricao.ScoreRecomendavel;
import com.gabriel.teste.ScoreDescricao.SemScore;
import com.gabriel.teste.ScoreDescricao.ValidaScoreDescricao;

@Service
public class PessoaService {

	private PessoaRepository pessoaRepository;

	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	@Transactional
	public ResponseEntity<List<Pessoa>> findAllPessoas() {
		List<Pessoa> pessoas = pessoaRepository.findAll();
		if(pessoas == null || pessoas.isEmpty() ) {
			return new ResponseEntity<>(pessoas, HttpStatus.NO_CONTENT);
		}
		pessoas.stream().map(pessoa -> validarPontuacaoScore(pessoa)).collect(Collectors.toList());
		return new ResponseEntity<>(pessoas, HttpStatus.OK);
	}

	@Transactional
	public ResponseEntity<Pessoa> findById(Integer id) {

		if (pessoaRepository.existsById(id)) {
			Pessoa pessoa = validarPontuacaoScore(pessoaRepository.findById(id).get());
			return new ResponseEntity<>(pessoa, HttpStatus.OK);
		}

		return ResponseEntity.noContent().build();

	}

	@Transactional
	public Pessoa savePessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public Pessoa validarPontuacaoScore(Pessoa pessoa) {
		ValidaScoreDescricao validaScoreDescricao = new ScoreAceitavel(
				new ScoreInaceitavel(new ScoreInsuficiente(new ScoreRecomendavel(new SemScore(pessoa)))));

		return validaScoreDescricao.validarPontuacaoScore(pessoa);
	}

}

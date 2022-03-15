package com.gabriel.teste.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.teste.Model.Pessoa;
import com.gabriel.teste.Service.PessoaService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/pessoa")
public class PessoaController {

	private PessoaService pessoaService;

	// @POST
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa createPessoa(@Valid @RequestBody Pessoa pessoa) {
		return pessoaService.savePessoa(pessoa);
	}

	// @GET -ALL
	@GetMapping
	public ResponseEntity<List<Pessoa>> getAll() {
		return pessoaService.findAllPessoas();
	}

	// @GET - ID
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> getById(@PathVariable Integer id) {
		return pessoaService.findById(id);
	}

}

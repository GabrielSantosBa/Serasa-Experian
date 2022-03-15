package com.gabriel.teste.Service;



import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gabriel.teste.Enums.ScoreDescricaoEnum;
import com.gabriel.teste.Model.Pessoa;
import com.gabriel.teste.Repository.PessoaRepository;


@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
@DisplayName("Pessoa Service")
public class PessoaServiceTest {

	
	@Mock
	private PessoaRepository pessoaRepository;
	
	@Mock
	private PessoaService pessoaService;
	
	
	@BeforeEach
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
		this.pessoaService = new PessoaService(pessoaRepository);
	}
	
	@Test 
	public void deveRetornarTodasAsPessoasDaBaseComStatusOk() {
		List<Pessoa> pessoas = pessoasMock();		
		Mockito.when(pessoaRepository.findAll()).thenReturn(pessoas);		
		ResponseEntity<List<Pessoa>> pessoasRetornadas = pessoaService.findAllPessoas();		
		Assert.assertEquals(pessoasRetornadas.getBody().size(), pessoas.size());
		Assert.assertEquals(pessoasRetornadas.getStatusCode().OK, HttpStatus.OK);
		
	}
	
	@Test 
	public void naoDeveRetornarPessoasDaBaseStatusNoContent() {
		List<Pessoa> pessoas = pessoasMock();	
		pessoas.clear();
		
		Mockito.when(pessoaRepository.findAll()).thenReturn(pessoas);		
		ResponseEntity<List<Pessoa>> pessoasRetornadas = pessoaService.findAllPessoas();		
		Assert.assertEquals(pessoasRetornadas.getBody().size(),0);
		Assert.assertEquals(pessoasRetornadas.getStatusCode().NO_CONTENT, HttpStatus.NO_CONTENT);
	
	}
	
	@Test
	public void validaInsercaoPessoa() {
		List<Pessoa> pessoas = pessoasMock();
		Mockito.when(pessoaService.savePessoa(pessoas.get(0))).thenReturn(pessoas.get(0));
		
		Pessoa pessoaRetornada = pessoaService.savePessoa(pessoas.get(0));
		Mockito.verify(pessoaRepository).save(pessoaRetornada);		
		Assert.assertEquals(pessoaRetornada.getId(), pessoas.get(0).getId());
		
	}
	
	@Test
	public void validaPessoaScoreInsuficiente() {
		List<Pessoa> pessoas = pessoasMock();
		Mockito.when(pessoaService.savePessoa(pessoas.get(0))).thenReturn(pessoas.get(0));
		Pessoa pessoaInsuficiente = pessoaService.validarPontuacaoScore(pessoas.get(0));
		Assert.assertEquals(pessoaInsuficiente.getScoreDescricao(), ScoreDescricaoEnum.INSUFICIENTE.toString());
	
	}
	
	@Test
	public void validaPessoaScoreInaceitavel() {
		
		List<Pessoa> pessoas = pessoasMock();
		Mockito.when(pessoaService.savePessoa(pessoas.get(1))).thenReturn(pessoas.get(1));
		Pessoa pessoaInsuficiente = pessoaService.validarPontuacaoScore(pessoas.get(1));
		Assert.assertEquals(pessoaInsuficiente.getScoreDescricao(), ScoreDescricaoEnum.INACEITÁVEL.toString());
		
	}
	
	@Test
	public void validaPessoaScoreAceitavel() {
		
		List<Pessoa> pessoas = pessoasMock();
		Mockito.when(pessoaService.savePessoa(pessoas.get(2))).thenReturn(pessoas.get(2));
		Pessoa pessoaInsuficiente = pessoaService.validarPontuacaoScore(pessoas.get(2));
		Assert.assertEquals(pessoaInsuficiente.getScoreDescricao(), ScoreDescricaoEnum.ACEITÁVEL.toString());
	}
	
	@Test
	public void validaPessoaScoreRecomendavel() {
		
		List<Pessoa> pessoas = pessoasMock();
		Mockito.when(pessoaService.savePessoa(pessoas.get(3))).thenReturn(pessoas.get(3));
		Pessoa pessoaInsuficiente = pessoaService.validarPontuacaoScore(pessoas.get(3));
		Assert.assertEquals(pessoaInsuficiente.getScoreDescricao(), ScoreDescricaoEnum.RECOMENDAVEL.toString());
	}
	
	
	private List<Pessoa> pessoasMock(){
		 List<Pessoa> pessoas = new ArrayList<>();
		 
		 Pessoa pessoa1 = new Pessoa();
		 pessoa1.setId(1);
		 pessoa1.setScore(10);
		 
		 Pessoa pessoa2 = new Pessoa();
		 pessoa2.setId(pessoa1.getId()+1);
		 pessoa2.setScore(201);
		 
		 Pessoa pessoa3 = new Pessoa();
		 pessoa3.setId(pessoa2.getId()+1);
		 pessoa3.setScore(501);
		 
		 Pessoa pessoa4 = new Pessoa();
		 pessoa4.setId(pessoa3.getId()+1);
		 pessoa4.setScore(701);
		 
		 pessoas.add(pessoa1);
		 pessoas.add(pessoa2);
		 pessoas.add(pessoa3);
		 pessoas.add(pessoa4);
		 
		 return pessoas;
		 
		 
	}

}

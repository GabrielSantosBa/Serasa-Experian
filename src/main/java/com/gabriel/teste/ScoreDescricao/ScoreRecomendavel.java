package com.gabriel.teste.ScoreDescricao;

import com.gabriel.teste.Model.Pessoa;

public class ScoreRecomendavel extends ValidaScoreDescricao{

	public ScoreRecomendavel(ValidaScoreDescricao proximo) {
		super(proximo);
	}

	@Override
	public Pessoa validarPontuacaoScore(Pessoa pessoa) {
		if(pessoa.getScore() > 700 && pessoa.getScore() < 1000) {
			pessoa.setScoreDescricao("Recomendavel");
		}			
		return proximo.validarPontuacaoScore(pessoa);
	}

}

package com.gabriel.teste.ScoreDescricao;

import com.gabriel.teste.Enums.ScoreDescricaoEnum;
import com.gabriel.teste.Model.Pessoa;

public class ScoreRecomendavel extends ValidaScoreDescricao{

	public ScoreRecomendavel(ValidaScoreDescricao proximo) {
		super(proximo);
	}

	@Override
	public Pessoa validarPontuacaoScore(Pessoa pessoa) {
		if(pessoa.getScore() > 700 && pessoa.getScore() < 1000) {
			pessoa.setScoreDescricao(ScoreDescricaoEnum.RECOMENDAVEL.toString());
		}			
		return proximo.validarPontuacaoScore(pessoa);
	}

}

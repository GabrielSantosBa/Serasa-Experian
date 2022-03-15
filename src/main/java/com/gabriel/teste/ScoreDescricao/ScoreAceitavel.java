package com.gabriel.teste.ScoreDescricao;

import com.gabriel.teste.Enums.ScoreDescricaoEnum;
import com.gabriel.teste.Model.Pessoa;

public class ScoreAceitavel extends ValidaScoreDescricao {

	public ScoreAceitavel(ValidaScoreDescricao proximo) {
		super(proximo);
	}

	@Override
	public Pessoa validarPontuacaoScore(Pessoa pessoa) {
		if (pessoa.getScore() > 500 && pessoa.getScore() <= 700) {
			pessoa.setScoreDescricao(ScoreDescricaoEnum.ACEITÁVEL.toString());
		}
		return proximo.validarPontuacaoScore(pessoa);
	}

}

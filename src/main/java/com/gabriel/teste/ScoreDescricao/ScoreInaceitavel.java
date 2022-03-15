package com.gabriel.teste.ScoreDescricao;

import com.gabriel.teste.Enums.ScoreDescricaoEnum;
import com.gabriel.teste.Model.Pessoa;

public class ScoreInaceitavel extends ValidaScoreDescricao {

	public ScoreInaceitavel(ValidaScoreDescricao proximo) {
		super(proximo);
	}

	@Override
	public Pessoa validarPontuacaoScore(Pessoa pessoa) {
		if (pessoa.getScore() > 200 && pessoa.getScore() <= 500) {
			pessoa.setScoreDescricao(ScoreDescricaoEnum.INACEITÁVEL.toString());
		}
		return proximo.validarPontuacaoScore(pessoa);
	}

}

package com.gabriel.teste.ScoreDescricao;

import com.gabriel.teste.Enums.ScoreDescricaoEnum;
import com.gabriel.teste.Model.Pessoa;

public class ScoreInsuficiente extends ValidaScoreDescricao {

	public ScoreInsuficiente(ValidaScoreDescricao proximo) {
		super(proximo);
	}

	@Override
	public Pessoa validarPontuacaoScore(Pessoa pessoa) {
		if (pessoa.getScore() > 0 && pessoa.getScore() <= 200) {
			pessoa.setScoreDescricao(ScoreDescricaoEnum.INSUFICIENTE.toString());
		}
		return proximo.validarPontuacaoScore(pessoa);
	}

}

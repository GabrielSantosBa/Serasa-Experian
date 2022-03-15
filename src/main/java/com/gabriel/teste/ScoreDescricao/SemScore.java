package com.gabriel.teste.ScoreDescricao;

import com.gabriel.teste.Model.Pessoa;

public class SemScore extends ValidaScoreDescricao {

	public SemScore(Pessoa proximo) {
		super(null);
	}

	@Override
	public Pessoa validarPontuacaoScore(Pessoa pessoa) {
		return pessoa;
	}

}

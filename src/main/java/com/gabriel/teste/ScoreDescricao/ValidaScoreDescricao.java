package com.gabriel.teste.ScoreDescricao;

import com.gabriel.teste.Model.Pessoa;

public abstract class ValidaScoreDescricao {

	protected ValidaScoreDescricao proximo;

	public ValidaScoreDescricao(ValidaScoreDescricao proximo) {
		this.proximo = proximo;
	}

	public abstract Pessoa validarPontuacaoScore(Pessoa pessoa);

}
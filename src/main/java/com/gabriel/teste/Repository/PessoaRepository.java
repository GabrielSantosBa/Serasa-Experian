package com.gabriel.teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.teste.Model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}

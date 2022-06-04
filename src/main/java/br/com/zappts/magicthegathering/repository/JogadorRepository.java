package br.com.zappts.magicthegathering.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zappts.magicthegathering.model.JogadorModel;

public interface JogadorRepository extends JpaRepository<JogadorModel, Long> {

	boolean existsByNome(String nome);

}

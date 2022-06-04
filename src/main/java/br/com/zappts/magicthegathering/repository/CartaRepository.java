package br.com.zappts.magicthegathering.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zappts.magicthegathering.model.CartaModel;

public interface CartaRepository extends JpaRepository<CartaModel, Long> {

	boolean existsByNomeAndEdicaoAndIdiomaAndIsFoilAndPreco(String nome, String edicao, String idioma, Boolean isFoil, BigDecimal preco);
	boolean existsByNomeAndEdicaoAndIdioma (String nome, String edicao, String idioma);
}

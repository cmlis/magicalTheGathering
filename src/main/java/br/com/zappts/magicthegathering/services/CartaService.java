package br.com.zappts.magicthegathering.services;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zappts.magicthegathering.bean.CartaModel;
import br.com.zappts.magicthegathering.repository.CartaRepository;

@Service
public class CartaService {

	@Autowired
	private CartaRepository cartaRepository;

	
	@Transactional
	public 	CartaModel save(CartaModel cartaModel) {
		return cartaRepository.save(cartaModel);
	}
	
	public boolean existsByNomeAndEdicaoAndIdiomaAndIsFoilAndPreco (String nome, String edicao, String idioma, boolean isFoil, BigDecimal preco) {
		return cartaRepository.existsByNomeAndEdicaoAndIdiomaAndIsFoilAndPreco(nome, edicao, idioma, isFoil, preco);
	
	}

	public boolean existsByNomeAndEdicaoAndIdioma(String nome, String edicao, String idioma) {
		
		return cartaRepository.existsByNomeAndEdicaoAndIdioma(nome, edicao, idioma);
	}
	
	
	public boolean incorrectLanguage(String idioma) {
		
		
		if (idioma.equalsIgnoreCase("português") || idioma.equalsIgnoreCase("portugues") ||
				idioma.equalsIgnoreCase("inglês") || idioma.equalsIgnoreCase("ingles") ||
				idioma.equalsIgnoreCase("japonês") || idioma.equalsIgnoreCase("japones")){

			return false;
		}
		
		return true;
		
	}
	
}

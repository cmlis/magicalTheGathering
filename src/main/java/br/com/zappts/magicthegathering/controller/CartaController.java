package br.com.zappts.magicthegathering.controller;



import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zappts.magicthegathering.bean.CartaModel;
import br.com.zappts.magicthegathering.controller.dto.CartaDto;
import br.com.zappts.magicthegathering.services.CartaService;

@RestController
@RequestMapping("/cartas")
public class CartaController {

	
	final CartaService cartaService;
	
	public CartaController(CartaService cartaService) {
		this.cartaService = cartaService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveCarta(@RequestBody @Valid CartaDto cartaDto ){
		
		if(cartaService.existsByNomeAndEdicaoAndIdiomaAndIsFoilAndPreco(cartaDto.getNome(), cartaDto.getEdicao(), 
				cartaDto.getIdioma(), cartaDto.getIsFoil(), cartaDto.getPreco())) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This card already has these characteristics.");
		}
		
		if(cartaService.incorrectLanguage(cartaDto.getIdioma())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: The Language is not allowed: " + cartaDto.getIdioma());
		}
			
		var cartaModel = new CartaModel();
		BeanUtils.copyProperties(cartaDto, cartaModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(cartaService.save(cartaModel));
	}
	
	
	

	
	
}

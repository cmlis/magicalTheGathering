package br.com.zappts.magicthegathering.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zappts.magicthegathering.bean.Carta;
import br.com.zappts.magicthegathering.controller.dto.CartaDto;
import br.com.zappts.magicthegathering.controller.form.CartaForm;
import br.com.zappts.magicthegathering.repository.CartaRepository;

@RestController
@RequestMapping("/cartas")
public class CartaController {

	@Autowired
	private CartaRepository cartaRepository;
	
	
	@PostMapping
	public ResponseEntity<Object> cadastrar(@RequestBody CartaForm form, UriComponentsBuilder uriBuilder){
		
		Carta carta = form.converter();
		cartaRepository.save(carta);
		
		URI uri  =  uriBuilder.path("/cartas/{id}").buildAndExpand(carta.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new CartaDto(carta));
	}
	
	
	
	
}

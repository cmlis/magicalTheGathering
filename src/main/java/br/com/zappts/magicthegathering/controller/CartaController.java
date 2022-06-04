package br.com.zappts.magicthegathering.controller;



import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zappts.magicthegathering.controller.dto.CartaDto;
import br.com.zappts.magicthegathering.model.CartaModel;
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
	
	
	@GetMapping
	public ResponseEntity<List<CartaModel>> getAllCards(){
		return ResponseEntity.status(HttpStatus.OK).body(cartaService.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneCard(@PathVariable(value = "id") Long id){
		
		Optional<CartaModel> cartaModelOptional = cartaService.findById(id);
		if (!cartaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(cartaModelOptional.get());
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCard(@PathVariable(value = "id") Long id){
		
		Optional<CartaModel> cartaModelOptional = cartaService.findById(id);
		if(!cartaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card not found");
		}
		cartaService.delete(cartaModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Card has been deleted successfully");
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCard(@PathVariable(value = "id") Long id,
											 @RequestBody @Valid CartaDto cartaDto){
		
		
		Optional<CartaModel> cartaModelOptional = cartaService.findById(id);
		
		if (!cartaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card not found");
		}
		
		var newCartaModel = new CartaModel();
		BeanUtils.copyProperties(cartaDto, newCartaModel);
		newCartaModel.setId(cartaModelOptional.get().getId());
		
		return ResponseEntity.status(HttpStatus.OK).body(cartaService.save(newCartaModel));
		
	}

	
	
}

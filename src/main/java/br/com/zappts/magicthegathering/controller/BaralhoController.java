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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.zappts.magicthegathering.controller.dto.BaralhoDto;
import br.com.zappts.magicthegathering.model.BaralhoModel;
import br.com.zappts.magicthegathering.model.CartaModel;
import br.com.zappts.magicthegathering.services.BaralhoServices;
import br.com.zappts.magicthegathering.services.CartaService;

@RestController
@RequestMapping("/baralhos")
public class BaralhoController {

	
	final BaralhoServices baralhoServices;
	final CartaService cartaService;
	
	public BaralhoController (BaralhoServices baralhoServices, CartaService cartaService) {
		this.baralhoServices = baralhoServices;
		this.cartaService = cartaService;
	}

	
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid BaralhoDto baralhoDto){
		
		var baralhoModel  = new BaralhoModel();
		BeanUtils.copyProperties(baralhoDto, baralhoModel);
		return ResponseEntity.status(HttpStatus.OK).body(baralhoServices.save(baralhoModel));
	}
	
	@GetMapping
	public ResponseEntity<List<BaralhoModel>> getAllDeck(){
		return ResponseEntity.status(HttpStatus.OK).body(baralhoServices.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneDeck(@PathVariable(value = "id") Long id, @RequestParam(name="ordemByName",required = false) String teste ){
		
		System.out.println("====TESTE   ORDEM");
		System.out.println(teste);
		
		Optional<BaralhoModel> baralhoModelOptional = baralhoServices.findById(id);
		if (!baralhoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deck not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(baralhoModelOptional.get());
		
	}
	
	
	@DeleteMapping("/{idBaralho}/{idCarta}")
	public ResponseEntity<Object> deleteCard(@PathVariable(value = "idBaralho") Long idBaralho, @PathVariable(value = "idCarta") Long idCarta ){
		
		
		Optional<BaralhoModel> baralhoModelOptional = baralhoServices.findByIdAndCartasId(idBaralho,idCarta);
		if(!baralhoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deck/Card not found");
		}
		
		Optional<CartaModel> cartaModel = cartaService.findById(idCarta);
		
		baralhoModelOptional.get().deleteCarta(cartaModel.get());
		BaralhoModel baralhoUpdated =  baralhoServices.save(baralhoModelOptional.get());

		return ResponseEntity.status(HttpStatus.OK).body(baralhoUpdated);
	}
	
	
	

	
	
}

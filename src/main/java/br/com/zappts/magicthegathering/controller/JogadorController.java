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
import br.com.zappts.magicthegathering.controller.dto.JogadorDto;
import br.com.zappts.magicthegathering.model.CartaModel;
import br.com.zappts.magicthegathering.model.JogadorModel;
import br.com.zappts.magicthegathering.services.JogadorService;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

	
	final JogadorService jogadorService;
	
	public JogadorController (JogadorService jogadorService) {
		this.jogadorService = jogadorService;
	}
	
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid JogadorDto jogadorDto ){
	
		if(jogadorService.existsByNome(jogadorDto.getNome())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This name is alreday taken.");
		}
		
		var jogadorModel = new JogadorModel();
		BeanUtils.copyProperties(jogadorDto, jogadorModel);
		return ResponseEntity.status(HttpStatus.OK).body(jogadorService.save(jogadorModel));
	}
	

	@GetMapping
	public ResponseEntity<List<JogadorModel>> getAllPlayers(){
		return ResponseEntity.status(HttpStatus.OK).body(jogadorService.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOnePlayer(@PathVariable(value = "id") Long id){
		
		Optional<JogadorModel> jogadorModelOptional = jogadorService.findById(id);
		if (!jogadorModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(jogadorModelOptional.get());
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePlayer(@PathVariable(value = "id") Long id){
		
		Optional<JogadorModel> jogadorModelOptional = jogadorService.findById(id);
		if(!jogadorModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found");
		}
		jogadorService.delete(jogadorModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Player has been deleted successfully");
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePlayer(@PathVariable(value = "id") Long id,
											 @RequestBody @Valid JogadorDto jogadorDto){
		
		
		Optional<JogadorModel> jogadorModelOptional = jogadorService.findById(id);
		
		if (!jogadorModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found");
		}
		
		var newJogadorModel = new JogadorModel();
		BeanUtils.copyProperties(jogadorDto, newJogadorModel);
		newJogadorModel.setId(jogadorModelOptional.get().getId());
		
		return ResponseEntity.status(HttpStatus.OK).body(jogadorService.save(newJogadorModel));
		
	}
	
}

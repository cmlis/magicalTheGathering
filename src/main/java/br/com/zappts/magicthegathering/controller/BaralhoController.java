package br.com.zappts.magicthegathering.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zappts.magicthegathering.controller.dto.BaralhoDto;
import br.com.zappts.magicthegathering.model.BaralhoModel;
import br.com.zappts.magicthegathering.services.BaralhoServices;

@RestController
@RequestMapping("/baralhos")
public class BaralhoController {

	
	final BaralhoServices baralhoServices;
	
	public BaralhoController (BaralhoServices baralhoServices) {
		this.baralhoServices = baralhoServices;
	}

	
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid BaralhoDto baralhoDto){
		
		var baralhoModel  = new BaralhoModel();
		BeanUtils.copyProperties(baralhoDto, baralhoModel);
		return ResponseEntity.status(HttpStatus.OK).body(baralhoServices.save(baralhoModel));
	}
	
	@GetMapping
	public ResponseEntity<List<BaralhoModel>> getAllCards(){
		return ResponseEntity.status(HttpStatus.OK).body(baralhoServices.findAll());
	}
	
	
	
}

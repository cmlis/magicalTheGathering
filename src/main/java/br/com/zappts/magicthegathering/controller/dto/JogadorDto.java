package br.com.zappts.magicthegathering.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class JogadorDto {

	
	
	private Long id;
	@NotBlank
	@Size(max = 20)
	private String nome;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}

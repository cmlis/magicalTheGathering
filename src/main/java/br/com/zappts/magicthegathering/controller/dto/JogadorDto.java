package br.com.zappts.magicthegathering.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class JogadorDto {

	

	@NotBlank
	@Size(max = 20)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}

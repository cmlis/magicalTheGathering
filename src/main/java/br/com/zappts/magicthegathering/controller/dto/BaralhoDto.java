package br.com.zappts.magicthegathering.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.zappts.magicthegathering.model.BaralhoModel;
import br.com.zappts.magicthegathering.model.CartaModel;
import br.com.zappts.magicthegathering.model.JogadorModel;

public class BaralhoDto {

	
	private String nome;
	private JogadorModel jogador;
	private List<CartaModel> cartas;
	
	
	public BaralhoDto() {
		
	}
	
	public BaralhoDto (BaralhoModel baralhoModel) {
		
		this.nome = baralhoModel.getNome();
		this.jogador = baralhoModel.getJogador();
		this.cartas = new ArrayList<>();
		this.cartas.addAll(baralhoModel.getCartas());
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	
	public JogadorModel getJogador() {
		return jogador;
	}

	public void setJogador(JogadorModel jogador) {
		this.jogador = jogador;
	}

	public List<CartaModel> getCartas() {
		return cartas;
	}


	public void setCartas(List<CartaModel> cartas) {
		this.cartas = cartas;
	}
	
	
}

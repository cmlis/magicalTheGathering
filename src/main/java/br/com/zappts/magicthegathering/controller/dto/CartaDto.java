package br.com.zappts.magicthegathering.controller.dto;

import java.math.BigDecimal;

import br.com.zappts.magicthegathering.bean.Carta;
import br.com.zappts.magicthegathering.bean.TipoIdioma;

public class CartaDto {
	
	
	private Long id;
	private String nome;
	private String edicao;
	private TipoIdioma idioma;
	private Boolean isFoil;
	private BigDecimal preco;
	private int qtdCartaMsmCaract;
	
	
	
	public CartaDto (Carta carta) {
		this.id = carta.getId();
		this.nome = carta.getNome();
		this.edicao = carta.getEdicao();
		this.idioma = carta.getIdioma();
		this.isFoil = carta.isFoil();
		this.preco = carta.getPreco();
		this.qtdCartaMsmCaract = carta.getQtdCartaMsmCaract();
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEdicao() {
		return edicao;
	}
	public TipoIdioma getIdioma() {
		return idioma;
	}
	public Boolean getIsFoil() {
		return isFoil;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public int getQtdCartaMsmCaract() {
		return qtdCartaMsmCaract;
	}

	
	
	

}

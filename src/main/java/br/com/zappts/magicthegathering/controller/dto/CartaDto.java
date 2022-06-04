package br.com.zappts.magicthegathering.controller.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zappts.magicthegathering.model.CartaModel;

public class CartaDto {
	
	@NotBlank
	@Size(max = 20)
	private String nome;
	@NotBlank
	@Size(max = 15)
	private String edicao;
	@NotBlank
	@Size(max = 15)
	private String idioma;
	@NotNull
	private Boolean isFoil;
	@NotNull
	private BigDecimal preco;
	private int qtdCartaMsmCaract;
	
	
	
	public CartaDto() {
		super();
	}
	
	public CartaDto (CartaModel carta) {
		this.nome = carta.getNome();
		this.edicao = carta.getEdicao();
		this.idioma = carta.getIdioma();
		this.isFoil = carta.getIsFoil();
		this.preco = carta.getPreco();
		this.qtdCartaMsmCaract = carta.getQtdCartaMsmCaract();
	}

	public String getNome() {
		return nome;
	}
	public String getEdicao() {
		return edicao;
	}
	public String getIdioma() {
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

//	
//	public static List<CartaDto> converter(List<Carta> cartas) {
//		
//		return cartas.stream().map(CartaDto::new).collect(Collectors.toList());
//		
//	}
//	
	

}

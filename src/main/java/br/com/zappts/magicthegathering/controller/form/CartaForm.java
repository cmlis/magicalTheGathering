package br.com.zappts.magicthegathering.controller.form;

import java.math.BigDecimal;

import br.com.zappts.magicthegathering.bean.Carta;
import br.com.zappts.magicthegathering.bean.TipoIdioma;


public class CartaForm {


	private String nome;
	private String edicao;
	private String idioma;
	private Boolean isFoil;
	private BigDecimal preco;
	private int qtdCartaMsmCaract;
	
	

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public Boolean getIsFoil() {
		return isFoil;
	}
	public void setIsFoil(Boolean isFoil) {
		this.isFoil = isFoil;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public int getQtdCartaMsmCaract() {
		return qtdCartaMsmCaract;
	}
	public void setQtdCartaMsmCaract(int qtdCartaMsmCaract) {
		this.qtdCartaMsmCaract = qtdCartaMsmCaract;
	}
	
	
	public Carta converter() {
		
		return new Carta(nome,edicao,TipoIdioma.converter(idioma),isFoil,preco,qtdCartaMsmCaract);
		
	}
	
	
	
	
}

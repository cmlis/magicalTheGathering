package br.com.zappts.magicthegathering.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Carta {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String edicao;
	@Enumerated(EnumType.STRING)
	private TipoIdioma idioma = TipoIdioma.PORTUGUES;
	private Boolean isFoil = false;
	private BigDecimal preco;
	private int qtdCartaMsmCaract;


	public Carta() {
		
	}

	

	public Carta(String nome, String edicao, TipoIdioma idioma, Boolean isFoil, BigDecimal preco,
			int qtdCartaMsmCaract) {
		this.nome = nome;
		this.edicao = edicao;
		this.idioma = idioma;
		this.isFoil = isFoil;
		this.preco = preco;
		this.qtdCartaMsmCaract = qtdCartaMsmCaract;
	}



	public Long getId() {
		return id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(edicao, id, idioma, isFoil, nome, preco, qtdCartaMsmCaract);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		return Objects.equals(edicao, other.edicao) && Objects.equals(id, other.id) && idioma == other.idioma
				&& Objects.equals(isFoil, other.isFoil) && Objects.equals(nome, other.nome)
				&& Objects.equals(preco, other.preco) && qtdCartaMsmCaract == other.qtdCartaMsmCaract;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nomeCarta) {
		this.nome = nomeCarta;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public TipoIdioma getIdioma() {
		return idioma;
	}
	public void setIdioma(TipoIdioma idioma) {
		this.idioma = idioma;
	}
	public Boolean isFoil() {
		return isFoil;
	}
	public void setFoil(Boolean isFoil) {
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

	
	
	
	
	
	
}

package br.com.zappts.magicthegathering.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CARTA")
public class CartaModel implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (nullable = false, length = 20)
	private String nome;
	@Column (nullable = false, length = 15)
	private String edicao;
	@Column (nullable = false, length = 15)
	private String idioma;
	@Column (nullable = false)
	private Boolean isFoil;
	@Column (nullable = false)
	private BigDecimal preco;
	private int qtdCartaMsmCaract;


	public CartaModel() {
		
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
		CartaModel other = (CartaModel) obj;
		return Objects.equals(edicao, other.edicao) && Objects.equals(id, other.id)
				&& Objects.equals(idioma, other.idioma) && Objects.equals(isFoil, other.isFoil)
				&& Objects.equals(nome, other.nome) && Objects.equals(preco, other.preco)
				&& qtdCartaMsmCaract == other.qtdCartaMsmCaract;
	}



	public Long getId() {
		return id;
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

	
}

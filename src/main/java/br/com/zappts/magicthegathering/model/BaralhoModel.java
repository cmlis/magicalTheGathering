package br.com.zappts.magicthegathering.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "TB_BARALHO")
public class BaralhoModel {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (nullable = false, length = 15)
	private String nome;
	@ManyToOne
	private JogadorModel jogador;
	@OneToMany
	private List<CartaModel> cartas = new ArrayList<>();
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(cartas, id, jogador, nome);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaralhoModel other = (BaralhoModel) obj;
		return Objects.equals(cartas, other.cartas) && Objects.equals(id, other.id)
				&& Objects.equals(jogador, other.jogador) && Objects.equals(nome, other.nome);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void deleteCarta(CartaModel carta) {
		
		this.cartas.remove(carta);
	}
	
	
	
	
}

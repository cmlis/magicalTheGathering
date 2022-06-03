package br.com.zappts.magicthegathering.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Jogador {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@OneToMany(mappedBy = "jogador")
	private List<Baralho> baralhos = new ArrayList<>();
	
	
	@Override
	public int hashCode() {
		return Objects.hash(baralhos, id, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		return Objects.equals(baralhos, other.baralhos) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
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
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Baralho> getBaralhos() {
		return baralhos;
	}
	public void setBaralhos(List<Baralho> baralhos) {
		this.baralhos = baralhos;
	}

	
	
	

}

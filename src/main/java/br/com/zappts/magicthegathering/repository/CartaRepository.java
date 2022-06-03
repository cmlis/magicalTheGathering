package br.com.zappts.magicthegathering.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zappts.magicthegathering.bean.Carta;

public interface CartaRepository extends JpaRepository<Carta, Long> {

}

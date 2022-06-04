package br.com.zappts.magicthegathering.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zappts.magicthegathering.model.JogadorModel;
import br.com.zappts.magicthegathering.repository.JogadorRepository;

@Service
public class JogadorService {

	
	@Autowired
	private JogadorRepository jogadorRepository;

	@Transactional
	public Object save(JogadorModel jogadorModel) {
		
		return jogadorRepository.save(jogadorModel);
	}

	public boolean existsByNome(String nome) {
		return jogadorRepository.existsByNome(nome);
	}
	
	public List<JogadorModel> findAll() {
		return jogadorRepository.findAll();
	}

	public Optional<JogadorModel> findById(Long id) {
		return jogadorRepository.findById(id);
	}

	@Transactional
	public void delete(JogadorModel jogadorModel) {
		jogadorRepository.delete(jogadorModel);
	}
	
	

	
}

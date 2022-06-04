package br.com.zappts.magicthegathering.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zappts.magicthegathering.model.BaralhoModel;
import br.com.zappts.magicthegathering.repository.BaralhoRepository;

@Service
public class BaralhoServices {

	
	@Autowired
	private BaralhoRepository baralhoRepository;
	
	@Transactional
	public 	BaralhoModel save(BaralhoModel baralhoModel) {
		return baralhoRepository.save(baralhoModel);
	}
	
	public List<BaralhoModel> findAll() {
		return baralhoRepository.findAll();
	}
	
	
	public Optional<BaralhoModel> findById(Long id) {
		return baralhoRepository.findById(id);
	}

	@Transactional
	public void delete(BaralhoModel baralhoModel) {
		baralhoRepository.delete(baralhoModel);
	}
	
	
}

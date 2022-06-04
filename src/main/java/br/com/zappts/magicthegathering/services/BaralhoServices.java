package br.com.zappts.magicthegathering.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zappts.magicthegathering.model.BaralhoModel;
import br.com.zappts.magicthegathering.model.CartaModel;
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
	
	public Optional<BaralhoModel> findByIdAndCartasId(Long id, Long cartasId) {
		return baralhoRepository.findByIdAndCartasId(id,cartasId);
	}
	
	

	public boolean existsByIdAndCartasId(Long baralhoModelId, Long cartasId) {
		
		return baralhoRepository.existsByIdAndCartasId(baralhoModelId,cartasId);
	}

	//ofical
//	@Transactional
//	public void delete(BaralhoModel baralhoModel) {
//		baralhoRepository.delete(baralhoModel);
//	}
	

	@Transactional
	public void deleteById(BaralhoModel baralhoModel) {
		
		for (CartaModel carta : baralhoModel.getCartas()) {
			
			
			baralhoRepository.deleteById(carta.getId());
			
		}
		
	}

	

	
//	
//	@Transactional
//	public void deleteByIdCarta(List<CartaModel> listaCarta) {
//		
//		for (CartaModel carta : listaCarta) {
//			
//			baralhoRepository.deleteById(carta.getId());
//		}
//		
//	}
	
	
	
	
}

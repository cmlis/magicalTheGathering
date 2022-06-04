package br.com.zappts.magicthegathering.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.zappts.magicthegathering.model.BaralhoModel;

public interface BaralhoRepository extends JpaRepository<BaralhoModel, Long> {

	boolean existsByIdAndCartasId(Long baralhoModelId, Long cartasId);

	Optional<BaralhoModel> findByIdAndCartasId(Long id, Long cartasId);
	
//	@Modifying
//	@Query(value =" DELETE FROM TB_BARALHO b WHERE b.baralho_model_id = :idBaralho and b.cartas_id = :idCarta ")
//	void deleteCarta(@Param("idBaralho") Long idBaralho, @Param ("idCarta") Long idCarta);

	void deleteByCartasId(Long id);
	

}
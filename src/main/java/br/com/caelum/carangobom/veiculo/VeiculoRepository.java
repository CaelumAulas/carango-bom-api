package br.com.caelum.carangobom.veiculo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface VeiculoRepository extends Repository<Veiculo, Long> {

    void delete(Veiculo veiculo);
    Veiculo save(Veiculo veiculo);

    boolean existsById(Long id);
    Optional<Veiculo> findById(Long id);

    @Query(
        nativeQuery = true,
        value = "select v.* from veiculo v inner join marca m on v.marca_id = m.id order by m.nome, v.modelo"
    )
    List<Veiculo> findAll();
}

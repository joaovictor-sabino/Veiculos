package com.database.veiculos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByModeloContainingIgnoreCase(String trecho);
}
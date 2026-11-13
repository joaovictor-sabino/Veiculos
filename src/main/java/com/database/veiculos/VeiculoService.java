package com.database.veiculos;

import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public List<Veiculo> listar() {
        return repository.findAll();
    }

    public List<Veiculo> buscarPorModelo(String trecho) {
        return repository.findByModeloContainingIgnoreCase(trecho);
    }

    public Veiculo buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Veículo não encontrado: " + id));
    }

    public Veiculo salvar(Veiculo veiculo) {
        veiculo.setModelo(maiusculo(veiculo.getModelo()));
        veiculo.setPlaca(maiusculo(veiculo.getPlaca()));
        veiculo.setCor(maiusculo(veiculo.getCor()));
        return repository.save(veiculo);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    private String maiusculo(String texto) {
        return texto == null ? null : texto.trim().toUpperCase(Locale.ROOT);
    }
}
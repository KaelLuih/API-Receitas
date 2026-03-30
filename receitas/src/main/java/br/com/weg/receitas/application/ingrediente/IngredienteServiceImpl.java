package br.com.weg.receitas.application.ingrediente;

import br.com.weg.receitas.domain.ingrediente.Ingrediente;
import br.com.weg.receitas.domain.ingrediente.IngredienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredienteServiceImpl implements IngredienteService {
private final IngredienteRepository repository;
    public void validarIngrediente(Ingrediente ingrediente) {
        if(ingrediente.getNome() == null || ingrediente.getNome().isBlank()){
            throw new RuntimeException("Ingrediente deve ter nome!");
        }

    }

    @Override
    public List<String> listarIngredientesUnicos() {
        return repository.findAll().stream()
                .map(ingrediente -> ingrediente.getNome())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}

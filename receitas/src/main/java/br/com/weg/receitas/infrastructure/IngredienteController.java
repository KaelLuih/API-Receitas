package br.com.weg.receitas.infrastructure;

import br.com.weg.receitas.application.ingrediente.IngredienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingrediente")
@RequiredArgsConstructor
public class IngredienteController {

    private final IngredienteService service;


    @GetMapping
    public ResponseEntity<List<String>> listarIngredientes(){
        List<String> ingredientes = service.listarIngredientesUnicos();

        if(ingredientes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ingredientes);
    }
}

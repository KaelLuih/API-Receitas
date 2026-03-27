package br.com.weg.receitas.infrastructure.receita;

import br.com.weg.receitas.application.receita.ReceitaService;
import br.com.weg.receitas.application.receita.dto.ReceitaRequisicaoDto;
import br.com.weg.receitas.application.receita.dto.ReceitaRespostaDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/receita")
public class ReceitaController {

    private final ReceitaService service;

    @GetMapping("/{id}")
    public ReceitaRespostaDto buscarReceitaID(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @GetMapping("/nome/{nome}")
    public List<ReceitaRespostaDto> buscarReceitasPorNome(@PathVariable String nome){
        return service.buscarPorNome(nome);
    }

    @GetMapping("/porcao/{porcao}")
    public List<ReceitaRespostaDto> buscarReceitasPorPorcao(@PathVariable double porcao){
        return service.buscarPorPorcao(porcao);
    }

    @GetMapping("/ingrediente/{ingrediente}")
    public List<ReceitaRespostaDto> buscarReceitasPorIngrediente(@PathVariable String ingrediente){
        return service.buscarPorIngrediente(ingrediente);
    }
    @GetMapping
    public List<ReceitaRespostaDto> listarReceitas(){
        return service.listarReceitas();
    }

    @PostMapping
    public ReceitaRespostaDto adicionarReceita(@RequestBody @Valid ReceitaRequisicaoDto receita){
        return service.salvarReceita(receita);
    }

    @PutMapping("/{id}")
    public ReceitaRespostaDto atualizarReceita(@PathVariable Long id, @RequestBody @Valid ReceitaRequisicaoDto receita){
        return service.atualizarReceita(id, receita);
    }

    @DeleteMapping("/nome/{nome}")
    public void deletarReceita(@PathVariable String nome){
        service.deletarPorNome(nome);
    }
    @GetMapping("/filtro/tempo")
    public List<ReceitaRespostaDto> filtrarPorTempo(
            @RequestParam Double tempoMin,
            @RequestParam Double tempoMax) {
        return service.findPorTempoPreparo(tempoMin, tempoMax);
    }
}

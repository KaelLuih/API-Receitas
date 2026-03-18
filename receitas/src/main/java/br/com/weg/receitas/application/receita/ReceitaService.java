package br.com.weg.receitas.application.receita;

import br.com.weg.receitas.application.receita.dto.ReceitaRequisicaoDto;
import br.com.weg.receitas.application.receita.dto.ReceitaRespostaDto;

import java.util.List;

public interface ReceitaService {

    List<ReceitaRespostaDto> listarReceitas();
    ReceitaRespostaDto buscarPorId(Long id);
    ReceitaRespostaDto salvarReceita(ReceitaRequisicaoDto requisicaoDto);
    ReceitaRespostaDto atualizarReceita(Long id, ReceitaRequisicaoDto requisicaoDto);
    void deletarReceita(Long id);
}

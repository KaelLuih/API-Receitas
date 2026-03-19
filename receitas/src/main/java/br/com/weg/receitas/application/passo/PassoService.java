package br.com.weg.receitas.application.passo;

import br.com.weg.receitas.domain.passo.Passo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PassoService {
    public void validarPasso(Passo passo){
        if(passo.getDescricao() == null || passo.getDescricao().isBlank()){
            throw new RuntimeException("Passo deve ter descrição");
        }
        if(passo.getOrdem() == null || passo.getOrdem() <= 0){
            throw new RuntimeException("Ordem do passo deve ser maior que 0");
        }
    }

    public void validarOrdemUnica(List<Passo> passos){
        Set<Integer> ordens = new HashSet<>();
        for(Passo passo : passos){
            if(!ordens.add(passo.getOrdem())){
                throw new RuntimeException("Ordem de passos duplicada: " + passo.getOrdem());
            }
        }
    }

    public List<Passo> ordenarPassos(List<Passo> passos){
        List<Passo> passosMutaveis = new ArrayList<>(passos);
        passosMutaveis.sort(Comparator.comparingInt(Passo::getOrdem));
        return passosMutaveis;
    }

    public void processarPassos(List<Passo> passos){
        if(passos == null || passos.isEmpty()){
            throw new RuntimeException("Receita deve ter pelo menos um passo");
        }
        passos.forEach(this::validarPasso);
        validarOrdemUnica(passos);
        ordenarPassos(passos);
    }
}

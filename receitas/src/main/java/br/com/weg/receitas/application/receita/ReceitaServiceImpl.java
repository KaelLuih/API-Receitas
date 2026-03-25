package br.com.weg.receitas.application.receita;

import br.com.weg.receitas.application.ingrediente.IngredienteService;
import br.com.weg.receitas.application.ingrediente.mapper.IngredienteMapper;
import br.com.weg.receitas.application.passo.PassoService;
import br.com.weg.receitas.application.passo.mapper.PassoMapper;
import br.com.weg.receitas.application.receita.dto.ReceitaRequisicaoDto;
import br.com.weg.receitas.application.receita.dto.ReceitaRespostaDto;
import br.com.weg.receitas.application.receita.mapper.ReceitaMapper;
import br.com.weg.receitas.domain.ingrediente.Ingrediente;
import br.com.weg.receitas.domain.passo.Passo;
import br.com.weg.receitas.domain.receita.Receita;
import br.com.weg.receitas.domain.receita.ReceitaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceitaServiceImpl implements ReceitaService{

    private final ReceitaRepository receitaRepository;
    private final IngredienteService ingredienteService;
    private final PassoService passoService;
    private final ReceitaMapper receitaMapper;
    private final IngredienteMapper ingredienteMapper;
    private final PassoMapper passoMapper;

    @Override
    public List<ReceitaRespostaDto> listarReceitas() {
        return receitaMapper.toDTOList(receitaRepository.findAll());
    }

    @Override
    public ReceitaRespostaDto buscarPorId(Long id) {
        return receitaMapper.toDTO(receitaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receita não encontrada!")));
    }

    @Override
    public List<ReceitaRespostaDto> buscarPorNome(String nome){
        return receitaMapper.toDTOList(receitaRepository.findByNome(nome));
    }

    @Override
    public List<ReceitaRespostaDto> buscarPorPorcao(double porcao){
        if(porcao <= 0){
            throw new RuntimeException("A porção deve ter um valor positivo!");
        }
        return receitaMapper.toDTOList(receitaRepository.findByPorcoes(porcao));
    }

    @Override
    public List<ReceitaRespostaDto> buscarPorIngrediente(String ingrediente){
        return receitaMapper.toDTOList(receitaRepository.findByIngredientes_Nome(ingrediente));
    }

    @Override
    public ReceitaRespostaDto salvarReceita(ReceitaRequisicaoDto requisicaoDto) {
        Receita receita = receitaMapper.toEntity(requisicaoDto);

        receita.getIngredientes().forEach(ingrediente -> {
            ingredienteService.validarIngrediente(ingrediente);
            ingrediente.setReceita(receita);
        });

        passoService.ordenarPassos(receita.getPassos());

        receita.getPassos().forEach(passo -> {
            passoService.validarPasso(passo);
            passo.setReceita(receita);
        });

        return receitaMapper.toDTO(receitaRepository.save(receita));
    }

    @Override
    public ReceitaRespostaDto atualizarReceita(Long id, ReceitaRequisicaoDto requisicaoDto) {
        Receita receita = receitaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receita não encontrada!"));

        receita.setNome(requisicaoDto.nome());
        receita.setDescricao(requisicaoDto.descricao());
        receita.setTempoPreparo(requisicaoDto.tempoPreparo());
        receita.setPorcoes(requisicaoDto.porcoes());

        receita.getIngredientes().clear();
        receita.getPassos().clear();

        requisicaoDto.ingredientes().forEach(ingredienteDTO -> {
            Ingrediente ingrediente = ingredienteMapper.toEntity(ingredienteDTO);
            ingredienteService.validarIngrediente(ingrediente);
            ingrediente.setReceita(receita);
            receita.getIngredientes().add(ingrediente);
        });

        List<Passo> passos = passoMapper.toEntityList(requisicaoDto.passos());

        passos.forEach(passo -> {
            passoService.validarPasso(passo);
            passo.setReceita(receita);
            receita.getPassos().add(passo);
        });

        Receita atualizada = receitaRepository.save(receita);
        return receitaMapper.toDTO(atualizada);
    }

    @Override
    @Transactional
    public void deletarPorNome(String nome) {
        List<Receita> receitas = receitaRepository.findByNome(nome);

        if(receitas.isEmpty()){
            throw new RuntimeException("Nenhuma receita com esse nome foi encontrada! " + nome);
        }

        if(receitas.size() > 1){
            throw new RuntimeException("Existem mais de uma receita com o mesmo nome por questões de segurança utilize o id para deletar! ");
        }
        Long idParaDeletar = receitas.get(0).getId();
        receitaRepository.deleteById(idParaDeletar);
    }

    @Override
    public List<ReceitaRespostaDto> findPorTempoPreparo(Double tempoMin, Double tempoMax) {
        if(tempoMin > tempoMax){
            throw new RuntimeException("Tempo minimo nao pode ser maior que o tempo maximo");
        }
        List<Receita> receitas = receitaRepository.findByTempoPreparoBetween(tempoMin,tempoMax);

        if(receitas.isEmpty()){
            throw new RuntimeException("Nenhuma receita esta entre esse espaço de tempo");
        }
        return receitaMapper.toDTOList(receitas);


    }


}

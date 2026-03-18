package br.com.weg.receitas.application.usuario.mapper;

import br.com.weg.receitas.application.usuario.dto.UsuarioRequisicaoDto;
import br.com.weg.receitas.application.usuario.dto.UsuarioRespostaDto;
import br.com.weg.receitas.domain.usuario.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequisicaoDto requisicao) {
        return Usuario.builder()
                .nome(requisicao.nome())
                .email(requisicao.email())
                .senha(requisicao.senha())
                .build();
    }

    public UsuarioRespostaDto toDTO(Usuario usuario) {
        return new UsuarioRespostaDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }

    public List<UsuarioRespostaDto> toList(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(this::toDTO)
                .toList();
    }
}
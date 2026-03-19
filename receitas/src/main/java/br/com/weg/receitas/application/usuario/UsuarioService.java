package br.com.weg.receitas.application.usuario;

import br.com.weg.receitas.application.usuario.dto.UsuarioRequisicaoDto;
import br.com.weg.receitas.application.usuario.dto.UsuarioRespostaDto;

public interface UsuarioService {
    UsuarioRespostaDto criarUsuario(UsuarioRequisicaoDto requisicaoDto);
    UsuarioRespostaDto buscarPorEmail(String email);
}

package br.com.weg.receitas.application.usuario;

import br.com.weg.receitas.application.usuario.dto.cadastro.UsuarioRequisicaoDto;
import br.com.weg.receitas.application.usuario.dto.cadastro.UsuarioRespostaDto;
import br.com.weg.receitas.application.usuario.dto.login.LoginRequisicaoDto;

public interface UsuarioService {
    UsuarioRespostaDto criarUsuario(UsuarioRequisicaoDto requisicaoDto);
    UsuarioRespostaDto buscarPorEmail(String email);

    UsuarioRespostaDto login(LoginRequisicaoDto login);
}

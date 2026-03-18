package br.com.weg.receitas.infrastructure.usuario;

import br.com.weg.receitas.application.usuario.UsuarioServiceImpl;
import br.com.weg.receitas.application.usuario.dto.UsuarioRequisicaoDto;
import br.com.weg.receitas.application.usuario.dto.UsuarioRespostaDto;
import br.com.weg.receitas.domain.usuario.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioServiceImpl service;

    @GetMapping("/{email}")
    public UsuarioRespostaDto buscarUsuarioID(@PathVariable String email){
        return service.buscarPorEmail(email);
    }

    @PostMapping
    public UsuarioRespostaDto adicionarUsuario(@RequestBody UsuarioRequisicaoDto usuario){
        return service.criarUsuario(usuario);
    }
}

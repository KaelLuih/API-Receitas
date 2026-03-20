package br.com.weg.receitas.infrastructure.usuario;

import br.com.weg.receitas.application.usuario.UsuarioService;
import br.com.weg.receitas.application.usuario.dto.UsuarioRequisicaoDto;
import br.com.weg.receitas.application.usuario.dto.UsuarioRespostaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping("/{email}")
    public UsuarioRespostaDto buscarUsuarioEmail(@PathVariable String email){
        return service.buscarPorEmail(email);
    }

    @PostMapping
    public UsuarioRespostaDto adicionarUsuario(@RequestBody UsuarioRequisicaoDto usuario){
        return service.criarUsuario(usuario);
    }
}

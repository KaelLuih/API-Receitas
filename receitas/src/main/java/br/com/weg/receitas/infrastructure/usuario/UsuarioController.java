package br.com.weg.receitas.infrastructure.usuario;

import br.com.weg.receitas.application.usuario.UsuarioService;
import br.com.weg.receitas.application.usuario.dto.cadastro.UsuarioRequisicaoDto;
import br.com.weg.receitas.application.usuario.dto.cadastro.UsuarioRespostaDto;
import br.com.weg.receitas.application.usuario.dto.login.LoginRequisicaoDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public UsuarioRespostaDto adicionarUsuario(@RequestBody @Valid UsuarioRequisicaoDto usuario){
        return service.criarUsuario(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioRespostaDto> login(@Valid @RequestBody LoginRequisicaoDto login){
        return ResponseEntity.ok(service.login(login));
    }
}

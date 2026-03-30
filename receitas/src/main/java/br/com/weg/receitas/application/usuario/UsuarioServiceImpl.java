package br.com.weg.receitas.application.usuario;

import br.com.weg.receitas.application.usuario.dto.cadastro.UsuarioRequisicaoDto;
import br.com.weg.receitas.application.usuario.dto.cadastro.UsuarioRespostaDto;
import br.com.weg.receitas.application.usuario.dto.login.LoginRequisicaoDto;
import br.com.weg.receitas.application.usuario.mapper.UsuarioMapper;
import br.com.weg.receitas.domain.usuario.Usuario;
import br.com.weg.receitas.domain.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UsuarioRespostaDto criarUsuario(UsuarioRequisicaoDto requisicaoDto) {
        if(repository.existsByEmail(requisicaoDto.email())){
            throw new RuntimeException("Email de usuário já cadastrado!");
        }
        Usuario usuario = mapper.toEntity(requisicaoDto);
        usuario.setSenha(passwordEncoder.encode(requisicaoDto.senha()));
        return mapper.toDTO(repository.save(usuario));
    }

    @Override
    public UsuarioRespostaDto buscarPorEmail(String email) {
        return mapper.toDTO(repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!")));
    }

    @Override
    public UsuarioRespostaDto login(LoginRequisicaoDto login){
        Usuario usuario = repository.findByEmail(login.email())
                .orElseThrow(() -> new RuntimeException("Email não encontrado!"));
        if(!passwordEncoder.matches(login.senha(), usuario.getSenha())){
            throw new RuntimeException("Senha incorreta!");
        }

        return new UsuarioRespostaDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}

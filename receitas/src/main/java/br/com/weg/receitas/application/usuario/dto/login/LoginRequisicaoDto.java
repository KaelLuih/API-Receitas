package br.com.weg.receitas.application.usuario.dto.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequisicaoDto(
        @NotBlank
        @Email
        String email,
        @NotBlank
        String senha) {
}

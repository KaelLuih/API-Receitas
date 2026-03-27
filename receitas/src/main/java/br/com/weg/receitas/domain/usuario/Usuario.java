    package br.com.weg.receitas.domain.usuario;

    import jakarta.persistence.*;
            import lombok.*;

    @Entity
    @Table(name = "usuario")
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public class Usuario {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String nome;

        @Column(unique = true)
        private String email;

        private String senha;
    }

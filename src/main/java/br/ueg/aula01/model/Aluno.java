package br.ueg.aula01.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TBL_ALUNO")
public @Data class Aluno {

    @Id
    @SequenceGenerator(
            name = "aluno_sequence",
            sequenceName = "seq_aluno_id",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "aluno_sequence"
    )
    @Column(name = "PK", nullable = false)
    private Long id;

    @Column(name="FIRSTNAME", nullable = false, length = 150)
    private String primeiroNome;

    @Column(name="LASTNAME", nullable = false, length = 150)
    private String sobreNome;

    @Column(name="E_MAIL", nullable = false, length = 300, unique = true)
    private Long email;

    @Column(name="AGE")
    private Long idade;
}
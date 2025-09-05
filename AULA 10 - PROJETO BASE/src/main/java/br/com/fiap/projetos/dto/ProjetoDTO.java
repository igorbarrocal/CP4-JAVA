package br.com.fiap.projetos.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class ProjetoDTO {
    private Long id;
    private String nome;
    private String responsavel;
    private Instant dataCriacao;
}


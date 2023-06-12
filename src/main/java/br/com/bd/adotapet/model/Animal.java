package br.com.bd.adotapet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "animal")
public class Animal {

    @Id
    private String id;

    private String nome;

    private String especie, descricao;

    private int idade;

    private boolean disponivel;

}

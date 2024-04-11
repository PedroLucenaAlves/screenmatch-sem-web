package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//informando ao JSON para ignorar todas as propriedades que nao passamos no parametro da classe (UnrecognizedPropertyException)
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo, @JsonAlias("totalSeasons") Integer totalTemporadas, //ler o apelido porem usa o nome do atributo da classe no json
		@JsonAlias("imdbRating") String avaliacao) {

}

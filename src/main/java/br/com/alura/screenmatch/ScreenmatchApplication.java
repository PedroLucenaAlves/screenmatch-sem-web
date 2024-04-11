package br.com.alura.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

/**
 * Ponto de entrada da aplicacao (startando projeto spring)
 */

@SpringBootApplication                          //permite criar no metodo principal algumas chamadas
public class ScreenmatchApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	
	//metodo principal, semelhante ao metodo main (por ser um metodo da interface command, e representado aqui uma tarefa a ser executada apos a inicializacao do spring
	@Override
	public void run(String... args) throws Exception {
		
		//consumindo a api que criamos
		
		ConsumoApi consumoApi = new ConsumoApi();
							//obtendo os dados passados no parametro
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);
		
//		json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
//		
//		System.out.println(json);
		
		ConverteDados conversor = new ConverteDados();
		
		//mandando o conversor transformar para a DadosSerie
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		
		System.out.println("passando os dados convertidos para a classe DadosSerie, com os campos pedidos no parametro da classe");
		
		System.out.println(dados);
		
	}

}

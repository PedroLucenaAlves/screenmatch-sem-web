package br.com.alura.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Classe especifica para consumir uma API
 * 
 * E boa pratica seprarar a responsabilidade e deixar o consumo de api numa classe separada
 * 
 * @author pedro.lucena
 *
 */

public class ConsumoApi {

	public String obterDados(String endereco) {
		
		System.out.println("Obtendo informacoes da requisicao em formato de String");

		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build(); //criando uri da requisicao
		
		HttpResponse<String> response = null; //resposta atraves da requisicao enviada
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		String json = response.body(); //corpo da resposta
		return json;

	}

}

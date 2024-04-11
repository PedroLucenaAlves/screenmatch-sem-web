package br.com.alura.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ConverteDados implements ConverteDadosFacade {
	
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public <T> T obterDados(String json, Class<T> classe) {
		
		System.out.println("Convertendo todos os campos passados no parametro da classe record");
		
		//ira ler o Json e tentar transforma-lo na classe passada
		try {
			return mapper.readValue(json, classe);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
}

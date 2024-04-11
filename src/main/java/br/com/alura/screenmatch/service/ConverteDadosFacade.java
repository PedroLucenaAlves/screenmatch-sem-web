package br.com.alura.screenmatch.service;

public interface ConverteDadosFacade {
	
	//<T> NO JAVA INFORMA QUE NAO SABEMOS QUAL O TIPO DO DADO QUE SERA PASSADO PARA NOS, MAS ALGO TEM QUE SER DEVOLVIDO 
	<T> T obterDados(String json, Class<T> classe); //classe generico
		
	

}

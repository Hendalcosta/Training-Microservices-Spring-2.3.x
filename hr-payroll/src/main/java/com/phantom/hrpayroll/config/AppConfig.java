package com.phantom.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration //anotation indicando que esta classe é de configuração para disponiblizar instâncias de objetos
public class AppConfig {
	
	@Bean//anotation que cria uma instancia unica que fica disponível para o projeto
	public RestTemplate restTemplate() {
		return new RestTemplate();//método que cfria um singleton (instância única) do tipo restTemplate e disponibiliza para injetar em outros componentes
	}
}

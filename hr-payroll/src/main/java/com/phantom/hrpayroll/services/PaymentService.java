package com.phantom.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.phantom.hrpayroll.entities.Payment;
import com.phantom.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")//associa o valor da propriedade hr-worker.host no application.properties para a variavel workerHost
	private String workerHost;//armazena o endereço e porta do hr-worker na variável workerHost
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();//cria uma map para armazenar os parametros do método .getForObject
		uriVariables.put("id", ""+workerId);//aspas + workerId para converter o tipo de worker ID (long) para o tipo do map (string)
		
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);//argumentos são: URL composta pelo endereço de horkhost + ID, o tipo de objeto requisitado e a s variaveis no Map de Uri
		return new Payment(worker.getName(),worker.getDailyIncome(), days);
	}
}

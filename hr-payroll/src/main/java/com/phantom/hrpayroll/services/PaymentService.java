package com.phantom.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phantom.hrpayroll.entities.Payment;
import com.phantom.hrpayroll.entities.Worker;
import com.phantom.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {
		
		Worker worker = workerFeignClient.findById(workerId).getBody();//.getBody() serve para acessar o corpo da resposta que é do tipo worker. Sem ele vai retornar o tipo ResponseEntity 
		return new Payment(worker.getName(),worker.getDailyIncome(), days);
	}
}

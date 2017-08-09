package com.ufcg.si1.rest;

import static org.junit.Assert.*;

import org.junit.*;
import org.springframework.web.client.RestTemplate;

import com.ufcg.si1.model.Queixa;

public class TestQueixaRest {
	
	
	private Queixa queixa1;
	private Queixa queixa2;
    RestTemplate restTemplate = new RestTemplate();
    public static final String REST_SERVICE_URI = "http://localhost:5000/SpringBootRestApi/api";

	@Before
	public void setup() {
		queixa1 = new Queixa(1, "Achei a comida do RU muito gostosa, algo de errado nao esta certo", 3, "",
                "Moao", "moao@gmail.com",
				  "Rua João Maurício", "Paraiba", "João Pessoa");
		queixa2 = new Queixa(2, "O preço do bolo ta muito caro", 1, "Joab deixa de ser mercenário", 
				"Eu", "soubonita@gmail.com", "Rua Queria Morrer", "Campina Grande", "Paraiba");
	}

    @Test
    public void consultaQueixa(){
    	try {
            Queixa queixa = restTemplate.getForObject(REST_SERVICE_URI+"/queixa/1", Queixa.class);
            Queixa consulta = restTemplate.getForObject(REST_SERVICE_URI +"/queixa/2", Queixa.class);
            Assert.assertEquals(queixa1, queixa);
            Assert.assertNotEquals(queixa2, queixa);
            Assert.assertEquals(queixa2, consulta);
    	} catch (Exception e) {
    		fail();
    	}

    }
}

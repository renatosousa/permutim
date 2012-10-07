package com.example.service;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Service;

@Service
public class FacebookPublisher {
	
	private static Logger log = Logger.getLogger(FacebookPublisher.class.getName());
	
	public void publicarMensagemNoMural(double pontuacao, String accessToken)
	{
		PostMethod postMethod = new PostMethod("https://graph.facebook.com/me/feed");
		
		postMethod.addParameter("access_token", accessToken);
		postMethod.addParameter("message", "Acertei " + pontuacao + "% do Quiz MundoJ");
		postMethod.addParameter("link", "https://apps.facebook.com/quizmundoj/");
		postMethod.addParameter("name", "Resultado Quiz MundoJ");
		postMethod.addParameter("type", "link");
		postMethod.addParameter("caption", "Quiz MundoJ - Perguntas e respostas sobre Java");
		
		HttpClient httpClient = new HttpClient();
		
		try {
			httpClient.executeMethod(postMethod);
			System.out.println(postMethod.getResponseBodyAsString());
		} catch (HttpException e) {
			e.printStackTrace();
			log.severe("Erro ao publicar mensagem");
		} catch (IOException e) {
			e.printStackTrace();
			log.severe("Erro ao publicar mensagem");
		}
	}
}

package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Pergunta;

@Service
public class ContadorDeAcertos {

	public double calcularPorcentagemDeAcertos(Pergunta[] perguntas, String[] respostas) {
		
		int acertos = 0;
		
		for(int i = 0; i < perguntas.length; i++)
		{
			Pergunta pergunta = perguntas[i];
			
			String respostaPergunta = respostas[i];
			
			if(pergunta.getRespostaCorreta().equals(respostaPergunta))
			{
				acertos++;
			}
		}
		
		return acertos * 100 / perguntas.length;
	}

}

package com.example.service;

import org.springframework.stereotype.Component;

import com.example.model.Pergunta;
import com.thoughtworks.xstream.XStream;

@Component
public class PerguntaServiceImpl implements PerguntaService {
	
	@Override
	public Pergunta[] listarPerguntas() {
		try {
			Pergunta[] perguntas = (Pergunta[]) new XStream().fromXML(PerguntaServiceImpl.class.getResourceAsStream("/perguntas.xml"));

			return perguntas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

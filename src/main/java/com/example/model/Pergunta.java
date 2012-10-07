package com.example.model;

public class Pergunta {

	private String enunciado;
	
	private String[] respostas;
	
	private String respostaCorreta;

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String[] getRespostas() {
		return respostas;
	}

	public void setRespostas(String[] respostas) {
		this.respostas = respostas;
	}

	public String getRespostaCorreta() {
		return respostaCorreta;
	}

	public void setRespostaCorreta(String respostaCorreta) {
		this.respostaCorreta = respostaCorreta;
	}
}

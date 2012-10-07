package com.example.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Pergunta;
import com.example.service.ContadorDeAcertos;
import com.example.service.FacebookPublisher;
import com.example.service.PerguntaService;

@Controller
@RequestMapping("/perguntas")
public class PerguntaController {

	@Autowired
	private PerguntaService perguntaService;

	@Autowired
	private ContadorDeAcertos contadorDeAcertos;

	@Autowired
	private FacebookPublisher facebookPublisher;

	@RequestMapping("/")
	public String listarPerguntas(Map<String, Object> map, HttpServletRequest request) {
		map.put("perguntas", perguntaService.listarPerguntas());

		return "perguntas";
	}

	@RequestMapping(value = "/responder", method = RequestMethod.POST)
	public String postarResposta(HttpServletRequest request) {

		Pergunta[] perguntas = perguntaService.listarPerguntas();
		String[] respostas = getRespostas(request, perguntas.length);

		double porcentagemDeAcertos = contadorDeAcertos.calcularPorcentagemDeAcertos(perguntas, respostas);

		String accessToken = recuperarAccessToken(request);

		facebookPublisher.publicarMensagemNoMural(porcentagemDeAcertos, accessToken);

		return "redirect:/?message=Respostas Enviadas com sucesso!";
	}

	private String recuperarAccessToken(HttpServletRequest request) {
		return (String) request.getSession().getAttribute("facebook_access_token");
	}

	private String[] getRespostas(HttpServletRequest request, int quantidadeDePerguntas) {
		String[] respostas = new String[quantidadeDePerguntas];

		for (int i = 0; i < quantidadeDePerguntas; i++) {
			respostas[i] = request.getParameter("pergunta_" + i);
		}

		return respostas;
	}
}

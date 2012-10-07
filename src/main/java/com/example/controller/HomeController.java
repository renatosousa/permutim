package com.example.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Usuario;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/incluirPermuta")
	public String incluirPermuta() {
		return "inclusaoPermuta";
	}
	
	@RequestMapping("/logar")
	public String logar(Usuario usuario) {
		if (usuario.getEmail().equals("natocosta@gmail.com") && usuario.getSenha().equals("1234")) {
			return "inclusaoPermuta";
		}

		return "login";

	}

	@RequestMapping("/")
	public String index(Map<String, Object> map, HttpServletRequest request) {
		String signedRequest = request.getParameter("signed_request");

		if (signedRequest != null) {
			String accessToken = getAccessToken(signedRequest);

			if (isAccessTokenInvalido(accessToken)) {
				requisitarAccessToken(map);
			} else {
				armazenarAccessToken(request, accessToken);
			}
		}

		return "index";
	}

	private void requisitarAccessToken(Map<String, Object> map) {
		String appId = "115674918577081";
		String appUrl = "http://apps.facebook.com/quizmundoj/";

		map.put("appUrl", appUrl);
		map.put("appId", appId);
	}

	private void armazenarAccessToken(HttpServletRequest request, String accessToken) {
		request.getSession().setAttribute("facebook_access_token", accessToken);
	}

	private boolean isAccessTokenInvalido(String accessToken) {
		return "".equals(accessToken);
	}

	private String getAccessToken(String signedRequest) {
		String jsonInformation = signedRequest.split("\\.")[1];

		String decodeJson = new String(Base64.decodeBase64(jsonInformation));

		int inicio = decodeJson.indexOf("oauth_token") + 14;
		int fim = decodeJson.indexOf("\"", inicio);

		String token = decodeJson.substring(inicio, fim);

		return token;
	}
}

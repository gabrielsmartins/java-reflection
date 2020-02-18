package br.com.alura.alurator.protocolo;

import java.util.HashMap;
import java.util.Map;

public class Request {

	private String nomeControle;
	private String nomeMetodo;
	private Map<String,Object> queryParams;

	public Request(String url) {

		String[] partesUrl = url.replaceFirst("/", "").split("[?]");
		
		String[] partesControleMetodo = partesUrl[0].split("/");
		nomeControle = Character.toUpperCase(partesControleMetodo[0].charAt(0)) + partesControleMetodo[0].substring(1) + "Controller";
		nomeMetodo = partesControleMetodo[1];
		queryParams = partesUrl.length > 1 ? new QueryParamsBuilder().comParametros(partesUrl[1]).build() : new HashMap<String, Object>();
	}

	public String getNomeControle() {
		return this.nomeControle;
	}
	
	public String getNomeMetodo() {
		return nomeMetodo;
	}
	
	public Map<String, Object> getQueryParams() {
		return queryParams;
	}
}

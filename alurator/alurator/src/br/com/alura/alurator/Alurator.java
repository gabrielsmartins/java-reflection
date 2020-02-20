package br.com.alura.alurator;

import java.util.Map;

import br.com.alura.alurator.conversor.ConversorXML;
import br.com.alura.alurator.ioc.ContainerIoC;
import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.ManipuladorObjeto;
import br.com.alura.alurator.reflexao.Reflexao;

public class Alurator {
	
	private String pacoteBase;
	private ContainerIoC containerIoC;

	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
		this.containerIoC = new ContainerIoC();
	}
	
	public Object executa(String url) {		
		Request request = new Request(url);
		
		String nomeControle = request.getNomeControle();
		String nomeMetodo = request.getNomeMetodo();
		Map<String, Object> params = request.getQueryParams();

		
		Class<?> classeControle = new Reflexao().getClasse(pacoteBase + nomeControle);
		Object instanciaControle = containerIoC.getInstance(classeControle);
	    Object retorno =	new ManipuladorObjeto(instanciaControle)
							       .getMetodo(nomeMetodo,params)
							       .invoca();
			
			
		System.out.println(retorno);
		
		
		return new ConversorXML().converte(retorno);	
}

	public <T, K extends T> void registra(Class<T> source, Class<K> target) {
	   containerIoC.registra(source,target);
	}

}
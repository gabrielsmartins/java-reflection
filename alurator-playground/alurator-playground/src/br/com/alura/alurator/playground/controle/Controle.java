package br.com.alura.alurator.playground.controle;

import java.util.List;

public class Controle {
	

	
	private List<String> lista = List.of("item 1", "item 2", "item 3");
	
	public List<String> getLista() {
		return lista;
	}
	
	public void metodoControle1(String s) {
		System.out.println("Executando método metodoControle1(String s)");
		System.out.println("Parametro 1 : " + s);
	}
	
	public void metodoControle2(String s, Integer i) {
		System.out.println("Executando método metodoControle2(String s, Integer i)");
		System.out.println("Parametro 1 :" + s);
		System.out.println("Parametro 2 :" + i);
	}
}

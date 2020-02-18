package br.com.alura.alurator.playground.controle;

public class SubControle extends Controle {
	
	private SubControle() {
		System.out.println("Iniciando SubControle");
	}
	
	public void metodoSubControle1() {
		System.out.println("Executando m�todo metodoSubControle1()");
	}
	
	public String metodoSubControle2() {
		System.out.println("Executando m�todo metodoSubControle2()");
		return "Retorno do m�todo metodoSubControle2";
	}

}

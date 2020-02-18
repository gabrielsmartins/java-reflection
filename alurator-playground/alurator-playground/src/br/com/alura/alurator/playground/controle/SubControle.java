package br.com.alura.alurator.playground.controle;

public class SubControle extends Controle {
	
	private SubControle() {
		System.out.println("Iniciando SubControle");
	}
	
	public void metodoSubControle1() {
		System.out.println("Executando método metodoSubControle1()");
	}
	
	public String metodoSubControle2() {
		System.out.println("Executando método metodoSubControle2()");
		return "Retorno do método metodoSubControle2";
	}

}

package br.com.alura.alurator.reflexao;

public class Reflexao {

	public ManipuladorClasse refleteClasse(String fqn) {
		try {
			Class<?> clazz = Class.forName(fqn);
			return new ManipuladorClasse(clazz);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}


}

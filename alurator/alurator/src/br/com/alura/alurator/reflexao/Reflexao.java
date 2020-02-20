package br.com.alura.alurator.reflexao;

public class Reflexao {

	public ManipuladorClasse refleteClasse(String fqn) {
			Class<?> clazz = getClasse(fqn);
			return new ManipuladorClasse(clazz);
	}

	public Class<?> getClasse(String fqn) {
		try {
			return Class.forName(fqn);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}


}

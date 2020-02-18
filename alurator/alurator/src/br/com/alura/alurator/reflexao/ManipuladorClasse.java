package br.com.alura.alurator.reflexao;

import java.lang.reflect.Constructor;

public class ManipuladorClasse {

	private Class<?> clazz;

	public ManipuladorClasse(Class<?> clazz) {
		this.clazz = clazz;
	}

	public ManipuladorConstrutor getContrutorPadrao() {
		try {
			Constructor<?> construtorPadrao = clazz.getDeclaredConstructor();
			return new ManipuladorConstrutor(construtorPadrao);
		} catch (NoSuchMethodException | SecurityException e) {
	       throw new RuntimeException(e);
		}
	}

	public ManipuladorObjeto criaInstancia() {
		Object instancia = getContrutorPadrao().invoca();
		return new ManipuladorObjeto(instancia);
	}

}

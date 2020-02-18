package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import br.com.alura.alurator.playground.controle.Controle;

public class TesteInstanciaCorretamente {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class<Controle> clazzControle = Controle.class;
		
		Constructor<Controle> constructor = clazzControle.getDeclaredConstructor(String.class);
		constructor.setAccessible(true);
		System.out.println(constructor);
		
		Controle controle = constructor.newInstance("xxx");
		System.out.println(controle);

	}

}

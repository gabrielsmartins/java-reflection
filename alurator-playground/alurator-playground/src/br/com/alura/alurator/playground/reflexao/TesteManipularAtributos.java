package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Field;

import br.com.alura.alurator.playground.modelo.Produto;

public class TesteManipularAtributos {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Object produto  = new Produto("Produto 1", 20.00, "Marca 1");
		
		Class<? extends Object> clazz = produto.getClass();
		
		System.out.println(clazz.getField("id"));
		
		 for(Field atributo : clazz.getDeclaredFields()) {
			 atributo.setAccessible(true);
	         System.out.println(atributo.getName() + ": " + atributo.get(produto));
	     }
		
	}

}

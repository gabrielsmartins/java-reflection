package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.com.alura.alurator.playground.controle.Controle;

public class TesteInovaMetodoComParametro {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<Controle> clazz = Controle.class;
		
		Method method1 = clazz.getDeclaredMethod("metodoControle1", String.class);
		
		Constructor<Controle> constructor = clazz.getDeclaredConstructor();
		Controle instance = constructor.newInstance();
		
		method1.invoke(instance, "xxx");
		
		Method method2 = clazz.getDeclaredMethod("metodoControle2", String.class, Integer.class);
		
		method2.invoke(instance, "xxx", 123);
	}

}

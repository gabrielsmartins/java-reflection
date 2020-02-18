package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TesteInvocaMetodoSemParametro {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class<?> subControleClazz = Class.forName("br.com.alura.alurator.playground.controle.SubControle");

		for(Method method : subControleClazz.getMethods()) {
			System.out.println(method);
		}
		
		System.out.println();
		
		for(Method method : subControleClazz.getDeclaredMethods()) {
			System.out.println(method);
		}
		
		System.out.println();
		
		Constructor<?> constructor = subControleClazz.getDeclaredConstructor();
		constructor.setAccessible(true);
		
		Object subControleInstance = constructor.newInstance();
		
		Method method = subControleClazz.getDeclaredMethod("metodoSubControle2");
		method.setAccessible(true);
		Object retorno = method.invoke(subControleInstance);
		System.out.println(retorno);
		
		
	}

}

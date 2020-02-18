package br.com.alura.alurator.reflexao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ManipuladorMetodo {

	private Object instancia;
	private Method method;
	private Map<String, Object> params;

	public ManipuladorMetodo(Object instancia, Method method, Map<String, Object> params) {
		this.instancia = instancia;
		this.method = method;
		this.params = params;
	}
	
	public Object invoca() {
		try {
			List<Object> parametros = new ArrayList<>();
			Stream.of(method.getParameters())
			     .forEach(p -> parametros.add(params.get(p.getName())));
			return method.invoke(instancia, parametros.toArray());
		} catch (IllegalAccessException | IllegalArgumentException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro dentro do método!",e);
		}
	}

}

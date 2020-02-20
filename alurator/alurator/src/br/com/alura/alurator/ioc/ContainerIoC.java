package br.com.alura.alurator.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class ContainerIoC {
	
	private Map<Class<?>, Class<?>> mapaDeTipos = new HashMap<>();

	public Object getInstance(Class<?> clazz) {
		
		Class<?> target = mapaDeTipos.get(clazz);
		
		if(target != null) {
			return getInstance(target);
		}
		
		Stream<Constructor<?>> construtores = Stream.of(clazz.getDeclaredConstructors());

		Optional<Constructor<?>> construtorPadrao = construtores.filter(c -> c.getParameterCount() == 0).findFirst();

		try {

			if (!construtorPadrao.isEmpty()) {

				Object instancia = construtorPadrao.get().newInstance();
				return instancia;

			} else {

				Constructor<?> construtor = clazz.getDeclaredConstructors()[0];

				List<Object> params = new ArrayList<>();
				
				for(Parameter param : construtor.getParameters()) {
					Class<?> type = param.getType();
					params.add(getInstance(type));
				}
				
				
				return construtor.newInstance(params.toArray());
			}

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public <T, K extends T> void registra(Class<T> source, Class<K> target) {
		this.mapaDeTipos.put(source, target);
	}


}

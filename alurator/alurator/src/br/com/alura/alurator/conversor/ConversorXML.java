package br.com.alura.alurator.conversor;

import java.lang.reflect.Field;
import java.util.Collection;

import br.com.alura.alurator.conversor.anotacao.XmlTag;

public class ConversorXML {

	public String converte(Object obj) {
		try {
		StringBuilder xmlBuilder = new StringBuilder();
		
		Class<?> clazz = obj.getClass();
		
		if(obj instanceof Collection) {
			Collection<?> collection = (Collection<?>) obj;
			xmlBuilder.append("<lista>\n");
				
			
			for(Object o : collection) {
				String xml = converte(o);
				xmlBuilder.append(xml);
			}
			
			xmlBuilder.append("</lista>\n");
		}else {
			XmlTag xmlAnnotationClazz = clazz.getDeclaredAnnotation(XmlTag.class);
			String nomeClasse = xmlAnnotationClazz == null ? clazz.getName() : xmlAnnotationClazz.value();
			xmlBuilder.append("<" + nomeClasse + ">\n");
			
			for(Field field : clazz.getDeclaredFields()) {
				field.setAccessible(true);
				XmlTag xmlAnnotationField = field.getDeclaredAnnotation(XmlTag.class);
				String nomeAtributo = 	xmlAnnotationField == null ? field.getName() : xmlAnnotationField.value();
			    Object valorAtributo = field.get(obj);
				xmlBuilder.append("<" + nomeAtributo +">");
				xmlBuilder.append(valorAtributo);
				xmlBuilder.append("</" + nomeAtributo +"/>\n");
			}
			
			xmlBuilder.append("</" + nomeClasse + ">\n");
			
		}
		
		return xmlBuilder.toString();
		
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro na geração do XML",e);
		}
	}

}

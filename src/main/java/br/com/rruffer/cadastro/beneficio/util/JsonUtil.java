package br.com.rruffer.cadastro.beneficio.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static String serializarJSON(Object json, boolean pretty) {
		String msg = null;
		
		try {
			if(pretty) {
				msg = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
			} else {
				msg = mapper.writeValueAsString(json);				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return msg;
	}
	
	public static <T> T deserializarJSON(String msg, Class<T> valueType) {
		
		try {
			return mapper.readValue(msg, valueType);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}

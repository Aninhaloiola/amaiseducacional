package br.com.maiseducacional.lib;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

/**
 * Processa requisições
 * 2017-11-17 Alternativa para vários request.getParameter()
 */
public class Requests {

	/**
	 * Armazena os parâmetros obtidos do método getParameterMap() 
	 */
	Map<String,String[]> params;
	/**
	 * Parâmetros mapeados
	 */
	Map<String,String> mappedParams = new HashMap<String,String>();
	
	public Requests() {
		
	}
	
	/**
	 * 
	 * @param Map<String,String[]> retorno do método getParameterMap() de HttpServletRequest
	 */
	public Requests(Map<String,String[]> params) {
		this.params = params;
		this.mapParams();
	}
	
	/**
	 * Obtém os parâmetros
	 * @param HttpServletRequest rq 
	 */
	public void getParameters(HttpServletRequest rq) {
		this.params = rq.getParameterMap();
		this.mapParams();
	}
	
	/**
	 * Mapeia todos os parâmetros obtidos e converte em String 
	 */
	private void mapParams() {
		Set<String> keys = this.params.keySet(); //Para cada key um array de string
		for(String k : keys) {
			String[] arrParam = this.params.get(k);
			String parameter = (arrParam!=null) ? String.join(",",arrParam) : "";
			this.mappedParams.put(k, parameter);
		}
	}
	
	/**
	 * Retorna um parâmetro específico como String
	 * @param String keyp parâmetro a ser retornado 
	 */
	public String getStrParam(String keyp) {
		if (this.mappedParams!=null && this.mappedParams.containsKey(keyp)) {
			 return this.mappedParams.get(keyp);
		}
		return "";
	}
	
	/**
	 * Retorna um parâmetro como int
	 * @param String keyp parâmetro a ser retornado
	 */
	public int getIntParam(String keyp) {
		String result = "0";
		if (this.mappedParams!=null && this.mappedParams.containsKey(keyp)) {
			 result = this.mappedParams.get(keyp);
		}
		return Integer.parseInt(result); 
	}
	
}
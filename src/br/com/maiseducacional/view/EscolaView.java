package br.com.maiseducacional.view;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import br.com.maiseducacional.dao.EscolaDao;
import br.com.maiseducacional.model.EscolaModel;

/**
 * Classe view para Escola
 */
public class EscolaView {
	
	private List<EscolaModel> lsEscm = null;
	private EscolaModel escm = null;
	
	/**
	 * Retorna um array json
	 */
	public JSONArray getEscolasJson() {
		JSONArray retorno = new JSONArray();
		
		if (this.lsEscm==null) {
			return retorno;
		}
		
		try {
			for (EscolaModel em : this.lsEscm) {
				JSONObject obj = new JSONObject();
						   obj.put("idInst", em.getIdInst());
						   obj.put("nome", em.getNome());
				retorno.put(obj);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}
	
	/**
	 * Listar escolas a partir do nivel e da série
	 * @param String nivel
	 * @param int serie
	 */
	public List<EscolaModel> listarEscolas(String nivel, int serie){
		try {
			EscolaDao ed = new EscolaDao();
			this.lsEscm = ed.getListaEscolasByNivelSerie(nivel, serie);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return this.lsEscm;
	}
	
}
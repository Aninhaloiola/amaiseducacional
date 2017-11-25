package br.com.maiseducacional.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.com.maiseducacional.dao.EscolaDao;
import br.com.maiseducacional.model.EscolaModel;

public class ConsultarEscolaView {

	/**
	 * Obtém dados para uma escola
	 * @param int idUsu
	 */
	public EscolaModel getEscolaDadosById(int idIns){
		EscolaModel escola = new EscolaModel();
		EscolaDao ed = new EscolaDao();
				  escola = ed.getEscolaInfo(idIns);
		return escola;
	}
	
	public ArrayList<EscolaModel> getListaEscolas(){
		EscolaDao ed = new EscolaDao();
		ArrayList<EscolaModel> em = ed.getListaEscolas();
		return em;
	}
	
}

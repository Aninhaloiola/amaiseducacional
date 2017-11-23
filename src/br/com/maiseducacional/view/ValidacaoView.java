package br.com.maiseducacional.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.com.maiseducacional.dao.MatriculaDao;
import br.com.maiseducacional.model.MatriculaModel;

public class ValidacaoView {
	
	public Map<String,Object> getMatriculaListaByUsu(int idUsu){
		Map<String,Object> matricula = new HashMap<String,Object>();
		try {
			MatriculaDao md = new MatriculaDao();
			ArrayList<MatriculaModel> pendls = md.getMatriculaPendenteListaByUsu(idUsu);
			matricula.put("pendentes", pendls);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return matricula;
	}
		
}
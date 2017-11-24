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
			ArrayList<MatriculaModel> pendls = md.getMatriculaListaByUsu(idUsu, "Pendente");
			matricula.put("pendentes", pendls);
			ArrayList<MatriculaModel> validas = md.getMatriculaListaByUsu(idUsu, "Validada");
			matricula.put("validadas", validas);
			ArrayList<MatriculaModel> canceladas = md.getMatriculaListaByUsu(idUsu, "Cancelada");
			matricula.put("canceladas", canceladas);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return matricula;
	}
	
	public int validarMatricula(int mtrId, int pessoaId) {
		MatriculaDao md = new MatriculaDao();
		return md.validarMatricula(mtrId, pessoaId);
	}
	
	public int cancelarMatricula(int mtrId, int pessoaId) {
		MatriculaDao md = new MatriculaDao();
		return md.cancelarMatricula(mtrId, pessoaId);
	}

}
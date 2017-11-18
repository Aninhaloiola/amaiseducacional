package br.com.maiseducacional.view;

import java.util.HashMap;
import java.util.Map;

import br.com.maiseducacional.dao.PessoaDao;

public class AcompanhaView {

	/**
	 * Obtém a matrícula do usuário logado
	 * @param int idUsu
	 */
	public Map<String,Object> getMatriculaDadosByUsu(int idUsu){
		Map<String,Object> matricula = new HashMap<String,Object>();
		try {
			PessoaDao pd = new PessoaDao();
			matricula.put("pessoa", pd.getPessoaById(idUsu));
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return matricula;
	}
	
}

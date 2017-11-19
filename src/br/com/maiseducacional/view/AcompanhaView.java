package br.com.maiseducacional.view;

import java.util.HashMap;
import java.util.Map;

import br.com.maiseducacional.dao.AlunoDao;
import br.com.maiseducacional.dao.EscolaDao;
import br.com.maiseducacional.dao.MatriculaDao;
import br.com.maiseducacional.dao.PessoaDao;
import br.com.maiseducacional.model.AlunoModel;
import br.com.maiseducacional.model.MatriculaModel;

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
			matricula.put("contato", pd.getPcontatoByPessoaId(idUsu));
			
			AlunoDao ad = new AlunoDao();
			AlunoModel am = ad.getAlunoByPessoaId(idUsu);
			matricula.put("aluno", am);
			
			MatriculaDao md = new MatriculaDao();
			MatriculaModel mmod = md.getMatriculaByAlunoId(am.getIdAluno());
			matricula.put("matricula", mmod);
			
			EscolaDao ed = new EscolaDao();
			matricula.put("insti", ed.getEscolaById(mmod.getIdInstituicao()));
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return matricula;
	}
	
}

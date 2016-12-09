package br.com.jessica.projetolocadora.dao;

import org.hibernate.Criteria;

import br.com.jessica.projetolocadora.modelo.Funcionario;
import br.com.jessica.projetolocadora.util.PesquisaBean;

public class FuncionarioDAO extends GenericoDAO<Funcionario, Integer> {

	@Override
	protected void setAtributoPesq(Criteria crit, PesquisaBean pesquisaBean) throws Exception {
		Funcionario o = (Funcionario) pesquisaBean.getEntidade();
		
		if(o == null){
			return;
		}
	}

}

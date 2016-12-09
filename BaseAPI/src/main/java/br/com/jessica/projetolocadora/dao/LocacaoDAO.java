package br.com.jessica.projetolocadora.dao;

import org.hibernate.Criteria;

import br.com.jessica.projetolocadora.modelo.Locacao;
import br.com.jessica.projetolocadora.util.PesquisaBean;

public class LocacaoDAO extends GenericoDAO<Locacao, Integer> {

	@Override
	protected void setAtributoPesq(Criteria crit, PesquisaBean pesquisaBean) throws Exception {
		Locacao o = (Locacao) pesquisaBean.getEntidade();
		
		if(o == null){
			return;
		}
	}

}

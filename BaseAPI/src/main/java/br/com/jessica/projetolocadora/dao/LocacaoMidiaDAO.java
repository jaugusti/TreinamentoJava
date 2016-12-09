package br.com.jessica.projetolocadora.dao;

import org.hibernate.Criteria;

import br.com.jessica.projetolocadora.modelo.LocacaoMidia;
import br.com.jessica.projetolocadora.util.PesquisaBean;

public class LocacaoMidiaDAO extends GenericoDAO<LocacaoMidia, Integer> {

	@Override
	protected void setAtributoPesq(Criteria crit, PesquisaBean pesquisaBean) throws Exception {
		LocacaoMidia o = (LocacaoMidia) pesquisaBean.getEntidade();
		
		if(o == null){
			return;
		}
	}

}

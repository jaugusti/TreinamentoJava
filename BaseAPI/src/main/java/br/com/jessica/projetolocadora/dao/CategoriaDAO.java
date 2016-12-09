package br.com.jessica.projetolocadora.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.jessica.projetolocadora.modelo.Categoria;
import br.com.jessica.projetolocadora.util.PesquisaBean;

public class CategoriaDAO extends GenericoDAO<Categoria, Integer> {

	@Override
	protected void setAtributoPesq(Criteria crit, PesquisaBean pesquisaBean) throws Exception {
		
		Categoria o = (Categoria) pesquisaBean.getEntidade();
		
		if(o == null){
			return;
		}		
		
		if(o.getDescricao() != null && !o.getDescricao().isEmpty()){
			crit.add(Restrictions.like("descricao", "%" + o.getDescricao() + "%"));
		}
	}
}

package br.com.jessica.projetolocadora.dao;

import org.hibernate.Criteria;

import br.com.jessica.projetolocadora.modelo.Usuario;
import br.com.jessica.projetolocadora.util.PesquisaBean;

public class UsuarioDAO extends GenericoDAO<Usuario, Integer> {

	@Override
	protected void setAtributoPesq(Criteria crit, PesquisaBean pesquisaBean) throws Exception {
		Usuario o = (Usuario) pesquisaBean.getEntidade();
		
		if(o == null){
			return;
		}
	}

	
	
}

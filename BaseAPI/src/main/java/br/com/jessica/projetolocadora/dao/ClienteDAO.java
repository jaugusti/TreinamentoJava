package br.com.jessica.projetolocadora.dao;

import java.io.Serializable;

import org.hibernate.Criteria;

import br.com.jessica.projetolocadora.modelo.Cliente;
import br.com.jessica.projetolocadora.util.PesquisaBean;

public class ClienteDAO extends GenericoDAO<Cliente, Integer>{

	@Override
	protected void setAtributoPesq(Criteria crit, PesquisaBean pesquisaBean) throws Exception {
		Cliente o = (Cliente) pesquisaBean.getEntidade();
		
		if(o == null){
			return;
		}
	}

}

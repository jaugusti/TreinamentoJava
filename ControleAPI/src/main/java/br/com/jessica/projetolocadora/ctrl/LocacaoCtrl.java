package br.com.jessica.projetolocadora.ctrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.jessica.projetolocadora.dao.ClienteDAO;
import br.com.jessica.projetolocadora.dao.FilmeDAO;
import br.com.jessica.projetolocadora.dao.LocacaoDAO;
import br.com.jessica.projetolocadora.dao.MidiaDAO;
import br.com.jessica.projetolocadora.dto.CategoriaDTO;
import br.com.jessica.projetolocadora.dto.ClienteDTO;
import br.com.jessica.projetolocadora.dto.FilmeDTO;
import br.com.jessica.projetolocadora.dto.ListFilmeDTO;
import br.com.jessica.projetolocadora.dto.LocacaoDTO;
import br.com.jessica.projetolocadora.dto.MidiaDTO;
import br.com.jessica.projetolocadora.modelo.Categoria;
import br.com.jessica.projetolocadora.modelo.Cliente;
import br.com.jessica.projetolocadora.modelo.Filme;
import br.com.jessica.projetolocadora.modelo.Funcionario;
import br.com.jessica.projetolocadora.modelo.Locacao;
import br.com.jessica.projetolocadora.modelo.Midia;
import br.com.jessica.projetolocadora.modelo.TipoMidia;

@Path("/locacao")
public class LocacaoCtrl {
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/criarLocacao")
	public LocacaoDTO criarLocacao(LocacaoDTO locacaoDTO){
		Locacao locacao = new Locacao();
		LocacaoDAO locacaoDAO = new LocacaoDAO();
		
		
		try {
			this.validarCamposObrigatorios(locacaoDTO);
			locacao = this.converterDTOEmLocacao(locacaoDTO);
			locacaoDAO.criar(locacao);
		} catch (Exception e) {
			String mensagem = "Problema ao criar registro na base. Mensagem Detalhada: ";
			locacaoDTO.setMensagem(mensagem + e.getMessage());
		}
		
		return locacaoDTO;
	}
	
	public Locacao converterDTOEmLocacao(LocacaoDTO locacaoDTO) throws Exception{
		Cliente cliente = new Cliente();
		Funcionario funcionario = new Funcionario();
		Locacao locacao = new Locacao();
		
		locacao.setId(locacaoDTO.getId());
		
		cliente.setId(locacaoDTO.getClienteDTO().getIdCliente());
		locacao.setCliente(cliente);
		
		funcionario.setId(locacaoDTO.getFuncionarioDTO().getIdFuncionario());
		locacao.setFuncionario(funcionario);
		
		locacao.setObservacao(locacaoDTO.getObservacao());
		
		locacao.setValor(locacaoDTO.getValor());
		locacao.setEmprestimo(converteData(locacaoDTO.getEmprestimo()));
		locacao.setDevolucao(converteData(locacaoDTO.getDevolucao()));

		return locacao;
	}
	public Calendar converteData(String data){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar a = Calendar.getInstance();
		try {
			a.setTime(sdf.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return a;
	}
	public void validarCamposObrigatorios(LocacaoDTO locacaoDTO) throws Exception{
		if(locacaoDTO.getEmprestimo() == null || locacaoDTO.getEmprestimo().isEmpty()){
			throw new Exception("Campo empréstimo é obrigatório!");
		}
		
		if(locacaoDTO.getDevolucao() == null || locacaoDTO.getDevolucao() == null){
			throw new Exception("Campo devolução é obrigatório!!");
		}
	}
}

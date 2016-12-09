package br.com.jessica.projetolocadora.dto;

import java.math.BigDecimal;
import java.util.Calendar;

public class LocacaoDTO extends BaseDTO{
	private Integer id;
	private ClienteDTO clienteDTO;
	private FuncionarioDTO funcionarioDTO;
	private String emprestimo;
	private String devolucao;
	private String observacao;
	private BigDecimal valor;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}
	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}
	public FuncionarioDTO getFuncionarioDTO() {
		return funcionarioDTO;
	}
	public void setFuncionarioDTO(FuncionarioDTO funcionarioDTO) {
		this.funcionarioDTO = funcionarioDTO;
	}
	public String getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(String emprestimo) {
		this.emprestimo = emprestimo;
	}
	public String getDevolucao() {
		return devolucao;
	}
	public void setDevolucao(String devolucao) {
		this.devolucao = devolucao;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}

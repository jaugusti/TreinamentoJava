package br.com.jessica.banco;

import java.util.ArrayList;
import java.util.Calendar;

import br.com.jessica.cliente.*;
import br.com.jessica.banco.conta.*;
import br.com.jessica.banco.movimentos.*;
import br.com.jessica.banco.utilitarios.ValorPorExtenso;

public class Banco {
	private ArrayList<Cliente> listaClientes = new ArrayList<>();
	private Movimentacao movimentacao = new Movimentacao();
	private int idMovimento = 0;
	
	public Banco(){
		Cliente cliente1 = new Cliente("91", "034", "123", 1700, "Gabriel");
		addCliente(cliente1);
		
		Cliente cliente2 = new Cliente("99", "034", "123", 10, "Jéssica");
		addCliente(cliente2);
	}
	
	
	public void addCliente(Cliente cliente){
		listaClientes.add(cliente);
	}
	
	/** Autenticar Cliente **/
	public boolean autenticaCliente(String agencia, String numeroConta, String senha){
		for(Cliente cliente : listaClientes)
			if(cliente.getConta().getAgencia().equals(agencia) && cliente.getConta().getNumeroConta().equals(numeroConta)
				&& cliente.getSenha().equals(senha))
				return true;
		return false;
	}
	/** Fim Autenticar Cliente **/
	
	/** Consultar Saldo **/
	public RetornoCliente consultaSaldo(InformacaoConta conta){
		for(Cliente cliente : listaClientes)
			if(cliente.getConta().getNumeroConta().equals(conta.getNumeroConta())
			&& cliente.getConta().getAgencia().equals(conta.getAgencia()))
				return new RetornoCliente(cliente.getConta(), cliente.getSaldo());
		return null;
	}
	
	public String saldoPorExtenso(InformacaoConta conta){
		RetornoCliente contaCliente = consultaSaldo(conta);

		if(contaCliente != null)
			if(contaCliente.getSaldo() < 0){
				ValorPorExtenso teste = new ValorPorExtenso(contaCliente.getSaldo()*(-1));
				return teste.toString() + " negativos";
			} 
			else {
				ValorPorExtenso teste = new ValorPorExtenso(contaCliente.getSaldo());
				return teste.toString();
			}
		else
			return "Conta Inválida";
	}
	/** Fim Consultar Saldo **/
	
	/** Depósito Envelope **/
	public InformacaoConta depositoEnvelope(InformacaoConta infConta, double valorOperacao){
		Cliente cliente = procuraCliente(infConta.getAgencia(), infConta.getNumeroConta());
		
		if(cliente != null){
			addMovimento(1, valorOperacao, "2016", "c", infConta, true, "Aguardando!");
			return infConta;
		}
		
		return null;
	}
	
	public void addMovimento(int tipoUsuario, double valorOperacao, String data, String tipoOperacao, InformacaoConta infConta,
	boolean operacaoPendente, String situacao){
		
		idMovimento += 1;
		movimentacao.addMovimento(new Movimento(idMovimento, tipoUsuario, valorOperacao, data, tipoOperacao, infConta,
				operacaoPendente, situacao));
	}
	/** Fim Depósito Envelope **/
	
	/** Soma Valor Operação no Saldo do Cliente **/
	public boolean movimentoCreditoCliente(Movimento movimento){
		String agencia = movimento.getConta().getAgencia();
		String numeroConta = movimento.getConta().getNumeroConta();
		
		Cliente cliente = procuraCliente(agencia, numeroConta);
		if(cliente != null){
			cliente.setSaldo(cliente.getSaldo() + movimento.getValorOperacao());
			return true;
		}
		return false;
	}
	
	/** Subtrai Valor Operação no Saldo do Cliente **/
	public boolean movimentoDebitoCliente(InformacaoConta infConta, int valorSaque){
		String agencia = infConta.getAgencia();
		String numeroConta = infConta.getNumeroConta();
		
		Cliente cliente = procuraCliente(agencia, numeroConta);
		if(cliente != null){
			cliente.setSaldo(cliente.getSaldo() - valorSaque);
			return true;
		}
		return false;
	}
	
	/** Procura um Cliente na Lista de Clientes **/
	public Cliente procuraCliente(String agencia, String numeroConta){
		for(Cliente cliente : listaClientes)
			if(cliente.getConta().getAgencia().equals(agencia)
			&& cliente.getConta().getNumeroConta().equals(numeroConta))
				return cliente;
		return null;
	}
	
	/** Usuário Banco **/
	public boolean autenticaUsuario(String agencia, String conta, String senha){
		if(agencia.equals("999") && conta.equals("999") && senha.equals("123mudar"))
			return true;
		else
			return false;
	}
	
	/** Aprovação de Depósitos **/
	public ArrayList<Movimento> verificaMovimentoPendente(){
		ArrayList<Movimento> listaMovimentos = new ArrayList<>();
		for(Movimento movimento : movimentacao.getListaMovimentos()){
			if(movimento.isOperacaoPendente())
				listaMovimentos.add(movimento);
		}
		return listaMovimentos;
	}
	
	public ArrayList<Integer> autorizaMovimento(ArrayList<Integer> listaMovimentosAprovados){
		ArrayList<Integer> movimentosAutorizados = new ArrayList<>();
		
		for(int i = 0; i < listaMovimentosAprovados.size(); i ++){
			for(Movimento movimento : movimentacao.getListaMovimentos()){
				if(movimento.isOperacaoPendente() && movimento.getIdMovimento() == listaMovimentosAprovados.get(i)){
					movimentoCreditoCliente(movimento);
					movimento.setOperacaoPendente(false);
					movimento.setSituacao("Aprovada!");
					movimentosAutorizados.add(movimento.getIdMovimento());
				}
			}
		}
		return movimentosAutorizados;
	}
	
	public ArrayList<Integer> cancelaMovimento(ArrayList<Integer> listaMovimentosAprovados){
		ArrayList<Integer> movimentosCancelados = new ArrayList<>();
		
		for(Movimento movimento : movimentacao.getListaMovimentos()){
			if(movimento.getSituacao().equals("Aguardando!") 
			&& !estaNaListaAprovados(listaMovimentosAprovados, movimento.getIdMovimento())){
				movimento.setOperacaoPendente(false);
				movimento.setSituacao("Cancelada!");
				movimentosCancelados.add(movimento.getIdMovimento());
			}
				
		}
		return movimentosCancelados;
	}
	
	public boolean estaNaListaAprovados(ArrayList<Integer> listaMovimentosAprovados, int idMovimento){
		for(int i : listaMovimentosAprovados){
			if(i == idMovimento)
				return true;
		}
		return false;
	}
	/** Fim Aprovação Depósitos **/
	
	
	
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public Movimentacao getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}
}
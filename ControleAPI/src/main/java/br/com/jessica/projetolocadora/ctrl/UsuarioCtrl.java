package br.com.jessica.projetolocadora.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.jessica.projetolocadora.ControleAPI.utils.VerifcaDadosUtils;
import br.com.jessica.projetolocadora.dao.ClienteDAO;
import br.com.jessica.projetolocadora.dao.FuncionarioDAO;
import br.com.jessica.projetolocadora.dao.UsuarioDAO;
import br.com.jessica.projetolocadora.modelo.Cliente;
import br.com.jessica.projetolocadora.modelo.Endereco;
import br.com.jessica.projetolocadora.modelo.Funcionario;
import br.com.jessica.projetolocadora.modelo.Usuario;
import br.com.jessica.projetolocadora.dto.BaseDTO;
import br.com.jessica.projetolocadora.dto.CategoriaDTO;
import br.com.jessica.projetolocadora.dto.ClienteDTO;
import br.com.jessica.projetolocadora.dto.EnderecoDTO;
import br.com.jessica.projetolocadora.dto.FuncionarioDTO;
import br.com.jessica.projetolocadora.dto.TipoUsuarioDTO;
import br.com.jessica.projetolocadora.dto.UsuarioDTO;
import br.com.jessica.projetolocadora.enums.TipoUsuario;

@Path("/usuario")
public class UsuarioCtrl {	
	@GET
	@Produces("application/json")
	@Path("/listarClientes")
	public List<ClienteDTO> listarClientes(){
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
		List<Cliente> clientes = new ArrayList<Cliente>();
		ClienteDAO clienteDAO = new ClienteDAO();
		
		try{
			clientes = clienteDAO.pesq(null);
			
			for(Cliente cliente : clientes){
				ClienteDTO clienteDTO = this.converterClienteEmDTO(cliente);
				clientesDTO.add(clienteDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return clientesDTO;
	}
	
	public ClienteDTO converterClienteEmDTO(Cliente cliente){
		ClienteDTO clienteDTO = new ClienteDTO();
		Usuario usuario = new Usuario();
		clienteDTO.setIdCliente(cliente.getId());
		
		usuario = cliente.getUsuario();
		clienteDTO.setId(usuario.getId());
		clienteDTO.setNome(usuario.getNome());
		clienteDTO.setTelefone(usuario.getTelefone());
		clienteDTO.setCelular(usuario.getCelular());
		clienteDTO.setEmail(usuario.getEmail());
		EnderecoDTO enderecoDTO = new EnderecoCtrl().converterEnderecoEmDTO(usuario.getEndereco());
		clienteDTO.setEnderecoDTO(enderecoDTO);
		
		return clienteDTO;
	}
	
	@GET
	@Produces("application/json")
	@Path("/listarFuncionarios")
	public List<FuncionarioDTO> listarFuncionarios(){
		List<FuncionarioDTO> funcionariosDTO = new ArrayList<FuncionarioDTO>();
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		try{
			funcionarios = funcionarioDAO.pesq(null);
			
			for(Funcionario funcionario : funcionarios){
				FuncionarioDTO funcionarioDTO = this.converterFuncionarioEmDTO(funcionario);
				funcionariosDTO.add(funcionarioDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return funcionariosDTO;
	}
	
	public FuncionarioDTO converterFuncionarioEmDTO(Funcionario funcionario){
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		Usuario usuario = new Usuario();
		
		funcionarioDTO.setIdFuncionario(funcionario.getId());
		funcionarioDTO.setLogin(funcionario.getLogin());
		funcionarioDTO.setSenha(funcionario.getSenha());
		funcionarioDTO.setSalario(funcionario.getSalario());
		
		usuario = funcionario.getUsuario();
		funcionarioDTO.setId(usuario.getId());
		funcionarioDTO.setNome(usuario.getNome());
		funcionarioDTO.setTelefone(usuario.getTelefone());
		funcionarioDTO.setCelular(usuario.getCelular());
		funcionarioDTO.setEmail(usuario.getEmail());
		EnderecoDTO enderecoDTO = new EnderecoCtrl().converterEnderecoEmDTO(usuario.getEndereco());
		funcionarioDTO.setEnderecoDTO(enderecoDTO);
		
		return funcionarioDTO;
	}
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/criarCliente")
	public ClienteDTO criarCliente(ClienteDTO clienteDTO){
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		
		try {
			VerifcaDadosUtils<ClienteDTO> verifica = new VerifcaDadosUtils<>();
			verifica.validarCamposObrigatorios(clienteDTO);
//			this.validarCamposObrigatorios(clienteDTO);
			usuario = this.converterClienteDTOEmUsuario(clienteDTO);
			usuarioDAO.criar(usuario);
			clienteDTO.setId(usuario.getId());
			
			cliente = this.converterDTOEmCliente(clienteDTO);
			clienteDAO.criar(cliente);
			
		} catch (Exception e) {
			String mensagemErro = "Problemas ao criar registro: mensagem detalhada: ";
			clienteDTO.setMensagem(mensagemErro + e.getMessage());
		}
		
		return clienteDTO;
	}
	
	
	public Cliente converterDTOEmCliente(ClienteDTO clienteDTO){
		Cliente cliente = new Cliente();
		cliente.setUsuario(converterClienteDTOEmUsuario(clienteDTO));
		cliente.setId(clienteDTO.getIdCliente());
		
		return cliente;
	}
	
	public Usuario converterClienteDTOEmUsuario(ClienteDTO clienteDTO){
		Usuario usuario = new Usuario();
		
		usuario.setId(clienteDTO.getId());
		usuario.setNome(clienteDTO.getNome());
		usuario.setTelefone(clienteDTO.getTelefone());
		usuario.setCelular(clienteDTO.getCelular());
		usuario.setEmail(clienteDTO.getEmail());
		if(clienteDTO.getEnderecoDTO() != null){
			Endereco endereco = new EnderecoCtrl().converterDTOEmEndereco(clienteDTO.getEnderecoDTO());
			usuario.setEndereco(endereco);
		}
		
		return usuario;
	}
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/criarFuncionario")
	public FuncionarioDTO criarFuncionario(FuncionarioDTO funcionarioDTO){
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = new Funcionario();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		
		try {
			VerifcaDadosUtils<FuncionarioDTO> verifica = new VerifcaDadosUtils<>();
			verifica.validarCamposObrigatorios(funcionarioDTO);
			
//			this.validarCamposObrigatorios(funcionarioDTO);
			usuario = this.converterFuncionarioDTOEmUsuario(funcionarioDTO);
			usuarioDAO.criar(usuario);
			funcionarioDTO.setId(usuario.getId());
			
			funcionario = this.converterDTOEmFuncionario(funcionarioDTO);
			funcionarioDAO.criar(funcionario);
			
		} catch (Exception e) {
			String mensagemErro = "Problemas ao criar registro: mensagem detalhada: ";
			funcionarioDTO.setMensagem(mensagemErro + e.getMessage());
		}
		
		return funcionarioDTO;
	}
	
	public Funcionario converterDTOEmFuncionario(FuncionarioDTO FuncionarioDTO){
		Funcionario funcionario = new Funcionario();
		funcionario.setUsuario(converterFuncionarioDTOEmUsuario(FuncionarioDTO));
		
		return funcionario;
	}
	
	public Usuario converterFuncionarioDTOEmUsuario(FuncionarioDTO funcionarioDTO){
		Usuario usuario = new Usuario();
		
		usuario.setId(funcionarioDTO.getId());
		usuario.setNome(funcionarioDTO.getNome());
		usuario.setTelefone(funcionarioDTO.getTelefone());
		usuario.setCelular(funcionarioDTO.getCelular());
		usuario.setEmail(funcionarioDTO.getEmail());
		if(funcionarioDTO.getEnderecoDTO() != null){
			Endereco endereco = new EnderecoCtrl().converterDTOEmEndereco(funcionarioDTO.getEnderecoDTO());
			usuario.setEndereco(endereco);
		}
		
		return usuario;
	}
	
	@GET
	@Produces("application/json")
	@Path("/buscarTiposUsuarios")
	public List<TipoUsuarioDTO> buscarTiposUsuario() {
		List<TipoUsuarioDTO> tiposUsuarioDTO = new ArrayList<TipoUsuarioDTO>();
		TipoUsuarioDTO tipoUsuarioDTO = null;
		
		for (TipoUsuario tp : TipoUsuario.values()) {
			tipoUsuarioDTO = new TipoUsuarioDTO();
			tipoUsuarioDTO.setCodigoUsuario(tp.getCodigoUsuario());
			tipoUsuarioDTO.setDescricaoUsuario(tp.getDescricaoUsuario());
			tiposUsuarioDTO.add(tipoUsuarioDTO);
		}
		
		return tiposUsuarioDTO;
	}
	//@POST - Criar registro
	//@DELETE - Remover
	//@PUT - Atualizar
}

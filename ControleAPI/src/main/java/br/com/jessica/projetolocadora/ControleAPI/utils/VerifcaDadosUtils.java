package br.com.jessica.projetolocadora.ControleAPI.utils;

import br.com.jessica.projetolocadora.dto.ClienteDTO;
import br.com.jessica.projetolocadora.dto.FuncionarioDTO;
import br.com.jessica.projetolocadora.dto.UsuarioDTO;

public class VerifcaDadosUtils<T extends UsuarioDTO> {
	
	public void validarCamposObrigatorios(T dados) throws Exception{
		
		verificaUsuario((UsuarioDTO)dados);
		
		
		if(dados instanceof FuncionarioDTO){
			if(((FuncionarioDTO) dados).getLogin() == null || ((FuncionarioDTO) dados).getLogin().isEmpty()){
				throw new Exception("Campo login é obrigatório.");
			}
			if(((FuncionarioDTO) dados).getSenha() == null || ((FuncionarioDTO) dados).getSenha().isEmpty()){
				throw new Exception("Campo senha é obrigatório.");
			}
		} else if (dados instanceof ClienteDTO) {
			if(((ClienteDTO) dados).getNome() == null || ((ClienteDTO) dados).getNome().isEmpty()){
				throw new Exception("Campo nome é obrigatório.");
			}
		}
	}
	
	private void verificaUsuario(UsuarioDTO dados) throws Exception {
		if(dados.getEmail() == null || dados.getEmail().isEmpty()){
			throw new Exception("Campo email é obrigatório.");
		}
	}

}

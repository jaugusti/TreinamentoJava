package br.com.jessica.projetolocadora.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.jessica.projetolocadora.dao.TipoMidiaDAO;
import br.com.jessica.projetolocadora.dto.TipoMidiaDTO;
import br.com.jessica.projetolocadora.modelo.Categoria;
import br.com.jessica.projetolocadora.modelo.TipoMidia;

@Path("/tipomidia")
public class TipoMidiaCtrl {
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/criarTipoMidia")
	public TipoMidiaDTO criarTipoMidia(TipoMidiaDTO tipoMidiaDTO){
		
		TipoMidiaDAO tipoMidiaDAO = new TipoMidiaDAO();
		TipoMidia tipoMidia = new TipoMidia();
		
		try {
			this.validarCamposObrigatorios(tipoMidiaDTO);
			tipoMidia = this.converterDTOEmTipoMidia(tipoMidiaDTO);
			tipoMidiaDAO.criar(tipoMidia);
		} catch (Exception e) {
			String mensagemErro = "Problemas ao criar registro: mensagem detalhada: ";
			tipoMidiaDTO.setMensagem(mensagemErro + e.getMessage());
		}
		
		return tipoMidiaDTO;
	}
	
	public void validarCamposObrigatorios(TipoMidiaDTO tipoMidiaDTO) throws Exception{
		if(tipoMidiaDTO.getDescricao() == null || tipoMidiaDTO.getDescricao().isEmpty()){
			throw new Exception("Campo Descrição é obrigatório.");
		}
	}
	
	public TipoMidia converterDTOEmTipoMidia(TipoMidiaDTO tipoMidiaDTO){
		TipoMidia tipoMidia = new TipoMidia();
		
		tipoMidia.setId(tipoMidiaDTO.getId());
		tipoMidia.setDescricao(tipoMidiaDTO.getDescricao());
		
		return tipoMidia;
	}
	
	@GET
	@Produces("application/json")
	@Path("/listarTiposMidia")
	public List<TipoMidiaDTO> listarTiposMidia(){
		List<TipoMidiaDTO> tiposMidiaDTO = new ArrayList<TipoMidiaDTO>();
		List<TipoMidia> tiposMidia = new ArrayList<TipoMidia>();
		TipoMidiaDAO tipoMidiaDAO = new TipoMidiaDAO();
		
		try{
			tiposMidia = tipoMidiaDAO.pesq(null);
			
			for(TipoMidia tipoMidia : tiposMidia){
				TipoMidiaDTO tipoMidiaDTO = this.converterTipoMidiaEmDTO(tipoMidia);
				tiposMidiaDTO.add(tipoMidiaDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return tiposMidiaDTO;
	}
	
	public TipoMidiaDTO converterTipoMidiaEmDTO(TipoMidia tipoMidia){
		TipoMidiaDTO tipoMidiaDTO = new TipoMidiaDTO();
		
		
		tipoMidiaDTO.setId(tipoMidia.getId());
		tipoMidiaDTO.setDescricao(tipoMidia.getDescricao());
		return tipoMidiaDTO;
	}
	//@POST - Criar registro
	//@DELETE - Remover
	//@PUT - Atualizar

}

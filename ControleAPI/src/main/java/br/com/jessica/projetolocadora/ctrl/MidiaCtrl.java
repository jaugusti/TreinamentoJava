package br.com.jessica.projetolocadora.ctrl;

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

import br.com.jessica.projetolocadora.dao.CategoriaDAO;
import br.com.jessica.projetolocadora.dao.FilmeDAO;
import br.com.jessica.projetolocadora.dao.MidiaDAO;
import br.com.jessica.projetolocadora.dto.CategoriaDTO;
import br.com.jessica.projetolocadora.dto.FilmeDTO;
import br.com.jessica.projetolocadora.dto.ListFilmeDTO;
import br.com.jessica.projetolocadora.dto.MidiaDTO;
import br.com.jessica.projetolocadora.dto.TipoMidiaDTO;
import br.com.jessica.projetolocadora.modelo.Categoria;
import br.com.jessica.projetolocadora.modelo.Filme;
import br.com.jessica.projetolocadora.modelo.Midia;
import br.com.jessica.projetolocadora.modelo.TipoMidia;

@Path("/midia")
public class MidiaCtrl {
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/criarMidia")
	public MidiaDTO criarMidia(MidiaDTO midiaDTO){
		Midia midia = new Midia();
		MidiaDAO midiaDAO = new MidiaDAO();
		
		
		try {
//			this.validarCamposObrigatorios(midiaDTO);
			midia = this.converterDTOEmMidia(midiaDTO);
			midiaDAO.criar(midia);
		} catch (Exception e) {
			String mensagem = "Problema ao criar registro na base. Mensagem Detalhada: ";
			midiaDTO.setMensagem(mensagem + e.getMessage());
		}
		
		return midiaDTO;
	}
	
	public Midia converterDTOEmMidia(MidiaDTO midiaDTO) throws Exception{
		Midia midia = new Midia();
		
		midia.setId(midiaDTO.getId());
		
		midia.setInutilizada(midiaDTO.getInutilizada());
		
		Filme filme = new FilmeCtrl().converterFilmeDTOEmFilme(midiaDTO.getFilmeDTO());
		midia.setFilme(filme);
		
		TipoMidia tipoMidia = new TipoMidiaCtrl().converterDTOEmTipoMidia(midiaDTO.getTipoMidiaDTO());
		midia.setTipoMidia(tipoMidia);
		return midia;
	}
	
	public void validarCamposObrigatorios(FilmeDTO filmeDTO) throws Exception{
		if(filmeDTO.getDescricao() == null || filmeDTO.getDescricao().isEmpty()){
			throw new Exception("Campo descrição é obrigatório!");
		}
		
		if(filmeDTO.getCategoriaDTO() == null || filmeDTO.getCategoriaDTO().getId() == null){
			throw new Exception("Campo categoria é obrigatório!!");
		}
	}
	
	@GET
	@Produces("application/json")
	@Path("/listarMidias")
	public List<MidiaDTO> listarMidias(){
		List<MidiaDTO> midiasDTO = new ArrayList<MidiaDTO>();
		List<Midia> midias = new ArrayList<Midia>();
		MidiaDAO midiaDAO = new MidiaDAO();
		
		try{
			midias = midiaDAO.pesq(null);
			
			for(Midia midia : midias){
				MidiaDTO midiaDTO = this.converterMidiaEmDTO(midia);
				midiasDTO.add(midiaDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return midiasDTO;
	}
	
	public MidiaDTO converterMidiaEmDTO(Midia midia){
		MidiaDTO midiaDTO = new MidiaDTO();
		
		midiaDTO.setId(midia.getId());
		midiaDTO.setInutilizada(midia.getInutilizada());
		
		FilmeDTO filmeDTO = new FilmeCtrl().converterFilmeEmFilmeDTO(midia.getFilme());
		midiaDTO.setFilmeDTO(filmeDTO);
		
		TipoMidiaDTO tipoMidiaDTO = new TipoMidiaCtrl().converterTipoMidiaEmDTO(midia.getTipoMidia());
		midiaDTO.setTipoMidiaDTO(tipoMidiaDTO);
		
		return midiaDTO;
	}
}

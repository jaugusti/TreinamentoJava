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

import br.com.jessica.projetolocadora.dao.FilmeDAO;
import br.com.jessica.projetolocadora.dto.CategoriaDTO;
import br.com.jessica.projetolocadora.dto.FilmeDTO;
import br.com.jessica.projetolocadora.dto.ListFilmeDTO;
import br.com.jessica.projetolocadora.modelo.Categoria;
import br.com.jessica.projetolocadora.modelo.Filme;

@Path("/filme")
public class FilmeCtrl {
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/cadastrar")
	public FilmeDTO cadastraFilme(FilmeDTO filmeDTO){
		Filme filme = new Filme();
		FilmeDAO filmeDAO = new FilmeDAO();
		
		
		try {
			this.validarCamposObrigatorios(filmeDTO);
			filme = this.converterFilmeDTOEmFilme(filmeDTO);
			filmeDAO.criar(filme);
			filmeDTO.setId(filme.getId());
		} catch (Exception e) {
			String mensagem = "Problema ao criar registro na base. Mensagem Detalhada: ";
			filmeDTO.setMensagem(mensagem + e.getMessage());
		}
		
		return filmeDTO;
	}
	
	public Filme converterFilmeDTOEmFilme(FilmeDTO filmeDTO) throws Exception{
		Calendar anoCalendaar = Calendar.getInstance();
		Calendar duracaoCalendar = Calendar.getInstance();
		
//		SimpleDateFormat sdfAno = new SimpleDateFormat("YYYY");
		SimpleDateFormat sdfDuracao = new SimpleDateFormat("hh:mm");
		
		anoCalendaar.set(Integer.parseInt(filmeDTO.getAno()), 0, 1, 0, 0, 0);
		duracaoCalendar.setTime(sdfDuracao.parse(filmeDTO.getDuracao()));
		
		Filme filme = new Filme();
		
		filme.setId(filmeDTO.getId());
		filme.setDescricao(filmeDTO.getDescricao());
		filme.setAno(anoCalendaar);
		filme.setResumo(filmeDTO.getResumo());
		filme.setClassificacao(filmeDTO.getClassificacao());
		filme.setDuracao(duracaoCalendar);
		if (filmeDTO.getCategoriaDTO() != null) {
			Categoria categoria = new CategoriaCtrl().converterDTOEmCategoria(filmeDTO.getCategoriaDTO());
			filme.setCategoria(categoria);
		}
		
		return filme;
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
	@Path("/listar")
	public ListFilmeDTO listaFilmes(){
		List<Filme> filmes = new ArrayList<Filme>();
		List<FilmeDTO> filmesDTO = new ArrayList<FilmeDTO>();
		FilmeDAO filmeDAO = new FilmeDAO();
		ListFilmeDTO listFilmeDTO = new ListFilmeDTO();
		
		try {
			filmes = filmeDAO.pesq(null);
			
			for(Filme filme : filmes){
				FilmeDTO filmeDTO = new FilmeDTO();
				filmeDTO = this.converterFilmeEmFilmeDTO(filme);
				filmesDTO.add(filmeDTO);
			}
			
			listFilmeDTO.setRetorno(filmesDTO);
		} catch (Exception e) {
			listFilmeDTO.setMensagem("---");
		}
		
		return listFilmeDTO;
	}
	
	public FilmeDTO converterFilmeEmFilmeDTO(Filme filme){
		FilmeDTO filmeDTO = new FilmeDTO();
		
		SimpleDateFormat stdf = new SimpleDateFormat("hh:mm");
		
		filmeDTO.setId(filme.getId());
		filmeDTO.setDescricao(filme.getDescricao());
		filmeDTO.setAno(String.valueOf(filme.getAno().get(Calendar.YEAR)));
		filmeDTO.setClassificacao(filme.getClassificacao());
		filmeDTO.setDuracao(stdf.format(filme.getDuracao().getTime()));
		filmeDTO.setResumo(filme.getResumo());
		CategoriaDTO categoriaDTO = new CategoriaCtrl().converterCategoriaEmDTO(filme.getCategoria());
		filmeDTO.setCategoriaDTO(categoriaDTO);
		return filmeDTO;
	}
}

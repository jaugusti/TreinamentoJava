package br.com.jessica.projetolocadora.dto;

public class MidiaDTO extends BaseDTO{
	private Integer id;
	private Boolean inutilizada;
	private FilmeDTO filmeDTO;
	private TipoMidiaDTO tipoMidiaDTO;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getInutilizada() {
		return inutilizada;
	}
	public void setInutilizada(Boolean inutilizada) {
		this.inutilizada = inutilizada;
	}
	public FilmeDTO getFilmeDTO() {
		return filmeDTO;
	}
	public void setFilmeDTO(FilmeDTO filmeDTO) {
		this.filmeDTO = filmeDTO;
	}
	public TipoMidiaDTO getTipoMidiaDTO() {
		return tipoMidiaDTO;
	}
	public void setTipoMidiaDTO(TipoMidiaDTO tipoMidiaDTO) {
		this.tipoMidiaDTO = tipoMidiaDTO;
	}
}

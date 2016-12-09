package br.com.jessica.projetolocadora.dto;

import java.util.Calendar;

public class FilmeDTO extends BaseDTO{
	private Integer id;
	private String descricao;
	private String ano;
	private String resumo;
	private Integer classificacao;
	private String duracao;
	private CategoriaDTO categoriaDTO;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public Integer getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(Integer classificacao) {
		this.classificacao = classificacao;
	}
	
	public CategoriaDTO getCategoriaDTO() {
		return categoriaDTO;
	}
	public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
		this.categoriaDTO = categoriaDTO;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public String getResumo() {
		return resumo;
	}
}

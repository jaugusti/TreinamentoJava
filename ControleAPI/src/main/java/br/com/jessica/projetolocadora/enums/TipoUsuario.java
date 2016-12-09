package br.com.jessica.projetolocadora.enums;

public enum TipoUsuario {

	CLIENTE(0, "Cliente"), FUNCIONARIO(1, "Funcionário");

	public int codigoUsuario;
	public String descricaoUsuario;

	private TipoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	private TipoUsuario(int codigoUsuario, String descricaoUsuario) {
		this.codigoUsuario = codigoUsuario;
		this.descricaoUsuario = descricaoUsuario;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public String getDescricaoUsuario() {
		return descricaoUsuario;
	}

}
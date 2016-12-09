function abrirTelaCadastroCategoria(){
	var url = "/WebApp/categoria/cadastro.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaListarCategoria(){
	var url = "/WebApp/categoria/pesquisa.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaCadastroEndereco(){
	var url = "/WebApp/endereco/cadastro.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaListarEnderecos(){
	var url = "/WebApp/endereco/pesquisa.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaCadastroFilme(){
	var url = "/WebApp/filme/cadastro.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaListarFilmes(){
	var url = "/WebApp/filme/pesquisa.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaCadastroMidia(){
	var url = "/WebApp/midia/cadastro.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaListarMidias(){
	var url = "/WebApp/midia/pesquisa.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaCadastroUsuario(){
	var url = "/WebApp/usuario/cadastro.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaListarClientes(){
	var url = "/WebApp/usuario/pesquisacliente.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaListarFuncionarios(){
	var url = "/WebApp/usuario/pesquisafuncionario.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaCadastroTipoMidia(){
	var url = "/WebApp/tipomidia/cadastro.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaListarTiposMidia(){
	var url = "/WebApp/tipomidia/pesquisa.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaCadastroLocacao(){
	var url = "/WebApp/locacao/cadastro.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaPrincipal(){
	var url = "/WebApp/index.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}
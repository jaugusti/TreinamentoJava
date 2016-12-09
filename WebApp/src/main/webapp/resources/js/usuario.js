function cadastrarUsuario(){
	var tipoUsuario = $('input[name=tipo-usuario]:checked').val();
	
	if(tipoUsuario == 1){
		var operacao = "/ControleAPI/usuario/criarFuncionario"
		
		var funcionarioDTO = new Object();
		funcionarioDTO.nome = $("#nome-usuario").val();
		funcionarioDTO.telefone = $("#telefone-usuario").val();
		funcionarioDTO.celular = $("#celular-usuario").val();
		funcionarioDTO.email = $("#email-usuario").val();
		funcionarioDTO.enderecoDTO = new Object();
		funcionarioDTO.enderecoDTO.id = $("#endereco-usuario").val();
		funcionarioDTO.login = $("#login-funcionario").val();
		funcionarioDTO.senha = $("#senha-funcionario").val();
		funcionarioDTO.salario = $("#salario-funcionario").val();
		
		var dados = JSON.stringify(funcionarioDTO);
	}
	else {
		var operacao = "/ControleAPI/usuario/criarCliente"
		
		var clienteDTO = new Object();
		clienteDTO.nome = $("#nome-usuario").val();
		clienteDTO.telefone = $("#telefone-usuario").val();
		clienteDTO.celular = $("#celular-usuario").val();
		clienteDTO.email = $("#email-usuario").val();
		clienteDTO.enderecoDTO = new Object();
		clienteDTO.enderecoDTO.id = $("#endereco-usuario").val();
		
		var dados = JSON.stringify(clienteDTO);
	}
	
//	var nome = $("#nome-usuario").val();
//	var telefone = $("#telefone-usuario").val();
//	var celular = $("#celular-usuario").val();
//	var email = $("#email-usuario").val();
	
//	var usuarioDTO = new Object();
//	var operacao = "/ControleAPI/usuario/criarUsuario" 
//		
//	usuarioDTO.nome = nome;
//	usuarioDTO.telefone = telefone;
//	usuarioDTO.celular = celular;
//	usuarioDTO.email = email;
	
//	usuarioDTO.enderecoDTO = new Object();
//	usuarioDTO.enderecoDTO.id = $("#endereco-usuario").val();

	$.ajax({
		method: "POST",
		url: operacao,
		data: dados,
		contentType: "application/json"
	}).done(function (data){
		var mensagem = '';
		var titulo = '';
		if(data.mensagem != undefined && data.mensagem != null && data.mensagem != ''){
			titulo = 'Atenção';
			mensagem = data.mensagem;
		}else{
			titulo = "Sucesso";
			mensagem = "Usuário cadastrado com sucesso.";
		}
		
		mostrarModal(titulo, mensagem);
		
		
		//abrirTelaPrincipal();
		
//		var url = "/WebApp/index.html";
//		
//		$.get(url, '', function(data){
//			$('#conteudo-principal').html(data);
//		})
	});
}
	
function mostrarModal(titulo, mensagem){
	$('#modal-title').html(titulo);
	$('#modal-mensagem').html(mensagem);
	
	$('#modal-mensagens').modal('show');
}		
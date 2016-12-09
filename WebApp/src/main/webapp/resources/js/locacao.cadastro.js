function cadastrarLocacao(){
	var emprestimo = $("#emprestimo-locacao").val();
	var devolucao = $("#devolucao-locacao").val();
	var valor = $("#valor-locacao").val();
	var observacao = $("#observacao-locacao").val();
	
	var locacaoDTO = new Object();
	var operacao = "/ControleAPI/locacao/criarLocacao" 
		
	locacaoDTO.emprestimo = emprestimo;
	locacaoDTO.devolucao = devolucao;
	locacaoDTO.valor = valor;
	locacaoDTO.observacao = observacao;

	locacaoDTO.clienteDTO = new Object();
	locacaoDTO.clienteDTO.idCliente = $("#cliente-locacao").val();
	
	locacaoDTO.funcionarioDTO = new Object();
	locacaoDTO.funcionarioDTO.idFuncionario = $("#funcionario-locacao").val();

	$.ajax({
		method: "POST",
		url: operacao,
		data: JSON.stringify(locacaoDTO),
		contentType: "application/json"
	}).done(function (data){
		var mensagem = '';
		var titulo = '';
		if(data.mensagem != undefined && data.mensagem != null && data.mensagem != ''){
			titulo = 'Atenção';
			mensagem = data.mensagem;
		}else{
			titulo = "Sucesso";
			mensagem = "Locação cadastrado com sucesso.";
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
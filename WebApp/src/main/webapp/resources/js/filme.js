function cadastrarFilme(){
	var descricao = $("#descricao-filme").val();
	var ano = $("#ano-filme").val();
	var resumo = $("#resumo-filme").val();
	var classificacao = $("#classificacao-filme").val();
	var duracao = $("#duracao-filme").val();
	
	var filmeDTO = new Object();
	var operacao = "/ControleAPI/filme/cadastrar" 
		
	filmeDTO.descricao = descricao;
	filmeDTO.ano = ano;
	filmeDTO.resumo = resumo;
	filmeDTO.classificacao = classificacao;
	filmeDTO.duracao = duracao;
	filmeDTO.categoriaDTO = new Object();
	filmeDTO.categoriaDTO.id = $("#categoria-filme").val();

	$.ajax({
		method: "POST",
		url: operacao,
		data: JSON.stringify(filmeDTO),
		contentType: "application/json"
	}).done(function (data){
		var mensagem = '';
		var titulo = '';
		if(data.mensagem != undefined && data.mensagem != null && data.mensagem != ''){
			titulo = 'Atenção';
			mensagem = data.mensagem;
		}else{
			titulo = "Sucesso";
			mensagem = "Filme cadastrado com sucesso.";
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
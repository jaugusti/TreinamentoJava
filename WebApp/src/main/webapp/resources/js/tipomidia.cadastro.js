function cadastrarTipoMidia(){
	var tipoMidiaDTO = new Object();
	var operacao = "/ControleAPI/tipomidia/criarTipoMidia" 
		
	tipoMidiaDTO.descricao = $("#descricao-tipomidia").val();

	$.ajax({
		method: "POST",
		url: operacao,
		data: JSON.stringify(tipoMidiaDTO),
		contentType: "application/json"
	}).done(function (data){
		var mensagem = '';
		var titulo = '';
		if(data.mensagem != undefined && data.mensagem != null && data.mensagem != ''){
			titulo = 'Atenção';
			mensagem = data.mensagem;
		}else{
			titulo = "Sucesso";
			mensagem = "Tipo de midia cadastrado com sucesso.";
		}
		
		mostrarModal(titulo, mensagem);
	});
}
	
function mostrarModal(titulo, mensagem){
	$('#modal-title').html(titulo);
	$('#modal-mensagem').html(mensagem);
	
	$('#modal-mensagens').modal('show');
}		
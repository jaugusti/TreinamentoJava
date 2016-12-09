function cadastrarMidia(){
	var midiaDTO = new Object();
	var operacao = "/ControleAPI/midia/criarMidia" 
		
	midiaDTO.inutilizada = $('input[name="inutilizada-midia"]:checked').val();
	
	midiaDTO.filmeDTO = new Object();
	midiaDTO.filmeDTO.id = $("#filme-midia").val();
	
	midiaDTO.tipoMidiaDTO = new Object();
	midiaDTO.tipoMidiaDTO.id = $("#tipo-midia").val();

	$.ajax({
		method: "POST",
		url: operacao,
		data: JSON.stringify(midiaDTO),
		contentType: "application/json"
	}).done(function (data){
		var mensagem = '';
		var titulo = '';
		if(data.mensagem != undefined && data.mensagem != null && data.mensagem != ''){
			titulo = 'Atenção';
			mensagem = data.mensagem;
		}else{
			titulo = "Sucesso";
			mensagem = "Mídia cadastrada com sucesso.";
		}
		
		mostrarModal(titulo, mensagem);
		
		
	});
}
	
function mostrarModal(titulo, mensagem){
	$('#modal-title').html(titulo);
	$('#modal-mensagem').html(mensagem);
	
	$('#modal-mensagens').modal('show');
}		
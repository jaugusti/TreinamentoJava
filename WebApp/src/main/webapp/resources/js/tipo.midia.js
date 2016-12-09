$(document).ready(function(){
	listarTipoMidia();
})

function listarTipoMidia(){
	var operacao = "/ControleAPI/tipomidia/listarTiposMidia"
		
	$.ajax({
		url: operacao
	}).done(function (data){
		linhaTabela = '<select id="tipo-midia" class="form-control" >';
		var lista = data;
		for(i = 0; i < lista.length; i++){
			linhaTabela += '<option value="' + lista[i].id + '">' + lista[i].descricao +  '</option>';
		}
		linhaTabela += '</select>';
		$('#boxMidia').append(linhaTabela);
	})
}
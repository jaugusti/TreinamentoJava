$(document).ready(function(){
	listarFilmeMidia();
})

function listarFilmeMidia(){
	var operacao = "/ControleAPI/filme/listar"
		
	$.ajax({
		url: operacao
	}).done(function (data){
		linhaTabela = '<select id="filme-midia" class="form-control" >';
		var lista = data.retorno;
		for(i = 0; i < lista.length; i++){
			linhaTabela += '<option value="' + lista[i].id + '">' + lista[i].descricao +  '</option>';
		}
		linhaTabela += '</select>';
		$('#boxFilme').append(linhaTabela);
	})
}
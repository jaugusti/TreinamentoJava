$(document).ready(function(){
	listarTiposMidia();
})

function listarTiposMidia(){
	var operacao = "/ControleAPI/tipomidia/listarTiposMidia" 
		
	$.ajax({
		url: operacao
	}).done(function (data){
		var lista = data;
		var linhaTabela = '';
		
		for(i = 0; i < lista.length; i++){
			linhaTabela = linhaTabela + '<tr>';
			
			linhaTabela = linhaTabela + '<th>';
			linhaTabela = linhaTabela + lista[i].id;
			linhaTabela = linhaTabela + '</th>';
			
			linhaTabela = linhaTabela + '<td>';
			linhaTabela = linhaTabela + lista[i].descricao;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + "</tr>";
		}
		
		$('#lista-tiposmidia').append(linhaTabela);
	})
}
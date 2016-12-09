$(document).ready(function(){
	listarFilmes();
})

function listarFilmes(){
	var operacao = "/ControleAPI/midia/listarMidias"
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
			linhaTabela = linhaTabela + lista[i].inutilizada;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td>';
			linhaTabela = linhaTabela + lista[i].filmeDTO.descricao;
			linhaTabela = linhaTabela + '</td>';
			

			linhaTabela = linhaTabela + '<td>';
			linhaTabela = linhaTabela + lista[i].tipoMidiaDTO.descricao;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + "</tr>";
		}
		
		$('#lista-midia').append(linhaTabela);
	})
}
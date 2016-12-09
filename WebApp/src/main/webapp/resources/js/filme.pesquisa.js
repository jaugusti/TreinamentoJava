$(document).ready(function(){
	listarFilmes();
})

function listarFilmes(){
	var operacao = "/ControleAPI/filme/listar"
	$.ajax({
		url: operacao
	}).done(function (data){
		var lista = data.retorno;
		var linhaTabela = '';
		
		for(i = 0; i < lista.length; i++){
			linhaTabela = linhaTabela + '<tr>';
			
			linhaTabela = linhaTabela + '<th>';
			linhaTabela = linhaTabela + lista[i].id;
			linhaTabela = linhaTabela + '</th>';
			
			linhaTabela = linhaTabela + '<td>';
			linhaTabela = linhaTabela + lista[i].descricao;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td>';
			linhaTabela = linhaTabela + lista[i].ano;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td>';
			linhaTabela = linhaTabela + lista[i].resumo;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td>';
			linhaTabela = linhaTabela + lista[i].classificacao;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td>';
			linhaTabela = linhaTabela + lista[i].duracao;
			linhaTabela = linhaTabela + '</td>';
			
			console.log(lista[i].categoriaDTO);
			linhaTabela = linhaTabela + '<td>';
			linhaTabela = linhaTabela + lista[i].categoriaDTO.descricao;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + "</tr>";
		}
		
		$('#lista-filme').append(linhaTabela);
	})
}
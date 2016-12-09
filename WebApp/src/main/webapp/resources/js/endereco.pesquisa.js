$(document).ready(function(){
	listarEndereco();
})

function listarEndereco(){
	var operacao = "/ControleAPI/endereco/listarEnderecos"
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
			linhaTabela = linhaTabela + lista[i].rua;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td>';
			linhaTabela = linhaTabela + lista[i].numero;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td>';
			linhaTabela = linhaTabela + lista[i].bairro;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td>';
			linhaTabela = linhaTabela + lista[i].cidade;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td>';
			linhaTabela = linhaTabela + lista[i].estado;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td>';
			linhaTabela = linhaTabela + lista[i].cep;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td>';
			linhaTabela = linhaTabela + lista[i].complemento;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + "</tr>";
		}
		
		$('#lista-endereco').append(linhaTabela);
	})
}
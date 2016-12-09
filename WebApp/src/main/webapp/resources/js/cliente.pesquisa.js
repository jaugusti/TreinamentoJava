$(document).ready(function(){
	listarClientes();
})

function listarClientes(){
	var operacao = "/ControleAPI/usuario/listarClientes"
	
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
			linhaTabela = linhaTabela + lista[i].nome;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td>';
			linhaTabela = linhaTabela + lista[i].telefone;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td>';
			linhaTabela = linhaTabela + lista[i].celular;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td>';
			linhaTabela = linhaTabela + lista[i].email;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td>';
			linhaTabela = linhaTabela + lista[i].enderecoDTO.rua + " " +
						lista[i].enderecoDTO.numero + " " + lista[i].bairro + " " +
						lista[i].enderecoDTO.cidade + " " + lista[i].estado + " " + 
						lista[i].enderecoDTO.cep + " " + lista[i].complemento;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + "</tr>";
		}
		
		$('#lista-clientes').append(linhaTabela);
	})
}
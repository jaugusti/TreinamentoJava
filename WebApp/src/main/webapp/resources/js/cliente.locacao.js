$(document).ready(function(){
	listarClientesLocacao();
})

function listarClientesLocacao(){
	var operacao = "/ControleAPI/usuario/listarClientes" 
		
	$.ajax({
		url: operacao
	}).done(function (data){
		linhaTabela = '<select id="cliente-locacao" class="form-control" >';
		var lista = data;
		for(i = 0; i < lista.length; i++){
			linhaTabela += '<option value="' + lista[i].idCliente + '">' + lista[i].nome + " " + lista[i].email + '</option>';
		}
		linhaTabela += '</select>';
		$('#boxCliente').append(linhaTabela);
	})
}
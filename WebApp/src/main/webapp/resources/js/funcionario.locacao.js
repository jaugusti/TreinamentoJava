$(document).ready(function(){
	listarFuncionariosLocacao();
})

function listarFuncionariosLocacao(){
	var operacao = "/ControleAPI/usuario/listarFuncionarios" 
		
	$.ajax({
		url: operacao
	}).done(function (data){
		linhaTabela = '<select id="funcionario-locacao" class="form-control" >';
		var lista = data;
		for(i = 0; i < lista.length; i++){
			linhaTabela += '<option value="' + lista[i].idFuncionario + '">' + " " + lista[i].email +  '</option>';
		}
		linhaTabela += '</select>';
		$('#boxFuncionario').append(linhaTabela);
	})
}
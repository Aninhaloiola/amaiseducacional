$(document).ready(function(){
	
	$('#inpt-usu').on('keyup', function(){
		var usu = $(this).val();
		if (usu=='' || usu.length < 6){
			$(this).addClass('is-invalid');
			$('#inpt-usu-msg').html('Insira um nome de usuário válido');
			$('#inpt-senha, #btn-submit').attr('disabled','disabled');
			return false;
		}
		$(this).removeClass('is-invalid');
		$(this).addClass('is-valid');
		$('#inpt-usu-msg').html('');
		$('#inpt-senha').removeAttr('disabled');
	});
	
	$('#inpt-senha').on('keyup', function(){
		var senha = $(this).val();
		if (senha=='' || senha.length < 6){
			$(this).addClass('is-invalid');
			$('#inpt-senha-msg').html('Insira uma senha válida');
			$('#btn-submit, #inpt-matr').attr('disabled','disabled');
			return false;
		}
		$(this).removeClass('is-invalid');
		$(this).addClass('is-valid');
		$('#inpt-senha-msg').html('');
		$('#btn-submit, #inpt-matr').removeAttr('disabled');
	});
	
});
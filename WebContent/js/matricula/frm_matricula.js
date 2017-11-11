/**
 * Formulário de matrícula
 */
$(document).ready(function(){
	//Formatações
	$('#inpt-cpf').mask('99999999999');
	$('#inpt-rg').mask('AAAAAAAAAAAAAA', {translation:{'A':{pattern:/[0-9]/, optional: true}}});
	$('#inpt-dtNasc').mask('99/99/9999');
	$('#inpt-fone').mask('AA AAAAAAAAA', {translation:{'A':{pattern:/[0-9]/, optional: true}}});
	
//	$('.validado').slideUp();
	
	//Validação de CPF
	$('#inpt-cpf').focus();
	$('#inpt-cpf').on('keyup', function(e){
		var cpf = $(this).val();
		if ((cpf.length < 11) || (Validar.valCpf(cpf)==false)) {
			FrmMatr.alerta(true,'CPF Inválido!');
			$('.validado').slideUp();
			return false;
		}
		FrmMatr.alerta(false,'');
		$('#inpt-rg').focus();
		$('.validado').slideDown();
	});
	//Validação de rg
	$('#inpt-rg').on('keyup', function(e){
		var rg = $(this).val();
		if(rg.length < 6){
			return false;
		}
	});
	//Validação de email
	$('#inpt-email').on('keyup', function(e){
		var MSG_ERRO_EMAIL = 'Insira um e-mail válido!';
		var email = $(this).val();
		if (!Validar.valEmail(email)){
			FrmMatr.alerta(true,MSG_ERRO_EMAIL);
			return false;
		}
		FrmMatr.alerta(false,'');
	});
	//Validação de nome
	$('#inpt-nome').on('keyup', function(){
		var nome = $(this).val();
		
	});
});

var FrmMatr = {
		/** Exibe um alerta para o formulário de matricula */
		alerta: function(acao, txt){
			if (acao) {
				$('#frm-matr-alert').slideDown();
			} else {
				$('#frm-matr-alert').slideUp();
			}
			$('#frm-matr-alert').html(txt);
		}
}

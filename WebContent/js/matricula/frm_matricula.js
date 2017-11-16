/**
 * Formulário de matrícula
 */
$(document).ready(function(){
	//Formatações
	$('#inpt-cpf').mask('99999999999');
	$('#inpt-rg').mask('AAAAAAAAAAAAAA', {translation:{'A':{pattern:/[0-9]/, optional: true}}});
	$('#inpt-dtNasc').mask('99/99/9999');
	$('#inpt-fone').mask('AA AAAAAAAAA', {translation:{'A':{pattern:/[0-9]/, optional: true}}});
	$('#inpt-celular').mask('AA AAAAAAAAA', {translation:{'A':{pattern:/[0-9]/, optional: true}}});
	$('#inpt-cep').mask('99999999');
	$('#inpt-uf').mask('AA', {translation:{A:{pattern:/[A-Za-z]/, optional: false}}});
	
//	$('.validado').slideUp();
	
	//Data de nascimento
	$('#inpt-dtNasc').datepicker({
		dateFormat: "dd/mm/yy",
		showAnim: "fold",
		changeYear: true,
		changeMonth: true,
		yearRange: "c-80:c",
		maxDate: "-1Y",
		monthNames: ["Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"],
		monthNamesShort: ["Jan","Fev","Mar","Abr","Mai","Jun","Jul","Ago","Set","Out","Nov","Dez"],
		dayNames: ["Domingo","Segunda","Terça","Quarta","Quinta","Sexta","Sábado"],
		dayNamesShort: ["Dom","Seg","Ter","Qua","Qui","Sex","Sab"],
		dayNamesMin: ["Dom","Seg","Ter","Qua","Qui","Sex","Sab"]
	});
	
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
	//UF
	$('#inpt-uf').on('keyup', function(){
		$(this).val(Validar.toUpper($(this).val()));
	});
	//Remove caracteres especiais de input com a respectiva classe
	$('input.naoespecial').on('keyup', function(){
		var inptv = $(this).val();
		$(this).val(Validar.removeEspec(inptv));
	});
	//Validar nome de usuário e senha
	$('.validausu').on('keyup', function(){
		var usuario = $(this).val();
		$(this).val(Validar.validaUsuario(usuario));
	});
	//Valida senha
	$('#inpt-senha').on('keyup', function(){
		var senha = $(this).val();
		if (senha.length < 6){
			$('#inpt-senha-msg').html('Insira um senha com pelo menos 6 dígitos');
			return false;
		}
		
		$('#inpt-senha-msg').html('Senha legal <i class="fa fa-check"></i>');
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

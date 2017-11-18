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
	
	$('.validado').hide();
	
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
	$('#inpt-senha-confirm').on('keyup', function(){
		var sconfirm = $(this).val();
		var senha = $('#inpt-senha').val();
		if (sconfirm!=senha){
			$('#btn-submit').attr('disabled','disabled');
			$('#inpt-senha-confirm-msg').html('Senha não confere!');
			return false;
		}
		$('#btn-submit').removeAttr('disabled');
		$('#inpt-senha-confirm-msg').html('Senha confere <i class="fa fa-check" aria-hidden="true"></i>');
	});
	//Carrega o ano escolar de acordo com o valor de escolaridade
	$('#inpt-escl').on('change', function(){
		$('#inpt-inst').attr('disabled','disabled'); //Desabilita combo de escolas
		$('#inpt-inst').val('0');
		
		var comboAnoEscola = $('#inpt-escl-ano');
		$(comboAnoEscola).val('0');
		
		var esco = $(this).val();
			esco = esco.toUpperCase();
		if (esco=='S'){
			$('#inpt-escol-msg').slideDown(300).html('Selecione o nivel de escolaridade, obrigado!');
			$(comboAnoEscola).attr('disabled','disabled');
			return false;
		}
		$('#inpt-escol-msg').hide(200).html('');
		
		$(comboAnoEscola).empty();
		$(comboAnoEscola).append($('<option title="Selecione" value="0">Selecione</option>'))
		var anos = (esco=='F') ? 10 : 4;
		for (var i=1; i < anos; i++){
			var option = document.createElement('option');
				option.setAttribute('title',i+'º Ano');
				option.setAttribute('value',i);
				option.appendChild(document.createTextNode(i+'º Ano'));
			$(comboAnoEscola).append(option);
		}
		$(comboAnoEscola).removeAttr('disabled');
	});
	//Carrega a lista de escolas compatíveis com a seleção
	$('#inpt-escl-ano').on('change', function(){
		var MSG_FALHA = 'Falha ao carregar escolas, atualize a página e tente novamente.';
		var MSG_VAZIO = 'Não há escolas disponiveis para esse nivel e ano escolar.';
		$('#inpt-inst').attr('disabled','disabled');
		$('#inpt-inst').val('0');
		
		$('#inpt-escl-inst-msg').html('Carregando, aguarde...');
		
		var nivel = $('#inpt-escl').val();
			nivel = nivel.toUpperCase();
		if (nivel=='S') {
			$('#inpt-escol-msg').slideDown(300).html('Selecione o nivel de escolaridade, obrigado!');
			return false;
		}
		var serie = parseInt($(this).val());
		if (serie < 1) {
			$('#inpt-escl-ano-msg').show(250).html('Selecione um Ano Escolar');
			return false;
		}
		$('#inpt-escl-ano-msg').hide(250).html('');
		
		var urlLista = '/maiseducacional/escola?acao=lista&tpres=json&nivel='+nivel+'&serie='+serie;
		$.ajax({
			url: urlLista,
			method: 'GET'
		}).done(function(res){
			if (!res.hasOwnProperty('result')){
				$('#inpt-escl-inst-msg').html(MSG_FALHA);
				return false;
			}
			var lista = res.result;
			
			if(lista.length < 1){
				$('#inpt-escl-inst-msg').html(MSG_VAZIO);
				return false;
			}
			
			$('#inpt-inst').empty();
			$('#inpt-inst').append($('<option title="Selecione" value="0">Selecione</option>'));
			$.each(lista, function(k,obj){
				var option = document.createElement('option');
					option.setAttribute('title',obj.nome);
					option.setAttribute('value',obj.idInst);
					option.appendChild(document.createTextNode(obj.nome));
				$('#inpt-inst').append(option);
			});
			$('#inpt-inst').removeAttr('disabled');
			$('#inpt-escl-inst-msg').html('');
		}).fail(function(err){
			$('#inpt-inst').attr('disabled','disabled');
			$('#inpt-escl-inst-msg').html('Falha, atualize a página e tente novamente, obrigado!');
		});
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

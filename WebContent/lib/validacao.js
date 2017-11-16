/**
 * Funções comuns para validação
 */

var Validar = {
	/**
	 * Validação de CPF
	 */
	valCpf: function(strCPF){
		"use strict";
		var Soma = 0;
	    var Resto;
	    
		if (strCPF == "00000000000") { return false; }
		if (strCPF == "11111111111") { return false; }
		if (strCPF == "55555555555") { return false; }
	    
		for (i=1; i<=9; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (11 - i);
		Resto = (Soma * 10) % 11;
		
	    if ((Resto == 10) || (Resto == 11)) { Resto = 0; }
	    if (Resto != parseInt(strCPF.substring(9, 10)) ) { return false; }
		
		Soma = 0;
	    for (i = 1; i <= 10; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (12 - i);
	    Resto = (Soma * 10) % 11;
		
	    if ((Resto == 10) || (Resto == 11)) {  Resto = 0; }
	    if (Resto != parseInt(strCPF.substring(10, 11) ) ) { return false; }
	    return true;
	},
	/**
	 * Validação de email
	 */
	valEmail: function(email){
		"use strict";
		var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		return re.test(email);
	},
	/**
	 * Remove caracteres especiais
	 */
	removeEspec: function(strRem){
		"use strict";
		var patt = /[`!@#$%&*()_|+\-=?;:'"¨¨,.<>\{\}\[\]\\\/]/gi;
		return strRem.replace(patt,'');
	},
	/** Valida nome de usuário */
	validaUsuario: function(usuario){
		"use strict";
		var patt = /[`!()_|+\-=?:;'"¨¨,<>\{\}\[\]\\\/]/gi;
		return usuario.replace(patt,'');
	},
	/**
	 * Converte texto para maiúsculo
	 */
	toUpper: function(strTxt){
		"use strict";
		return strTxt.toUpperCase(strTxt);
	}
}
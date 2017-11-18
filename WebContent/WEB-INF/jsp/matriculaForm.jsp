<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mais Educacional - Matricula</title>
	<%@ include file="/partials/headStyle.jsp" %>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/matricula.css">
	<%@ include file="/partials/headJs.jsp" %>
	<script type="text/javascript" src="<%=request.getContextPath()%>/lib/validacao.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/matricula/frm_matricula.js"></script>
</head>
<body>
<%@ include file="/partials/header.jsp" %>
<div class="container margin-2">
	<div class="row light-6 padding-2">
		<div class="col-12 txt-dark">
			<div style="text-align: center; font-size: 2em;">
				<i class="fa fa-address-book-o" aria-hidden="true"></i> Nova Matricula
			</div>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col">
			<div id="frm-matr-alert" class="alert alert-danger">
				${aviso}
			</div>
		</div>
	</div>
</div>
<div class="container light-6">
	<form method="post" action="/maiseducacional/matricula" enctype="application/x-www-form-urlencoded">
		<div class="form-row">
			<div class="form-group col-sm-3">
				<label class="badge badge-light" for="cpf">CPF*</label>
				<div class="input-group">
					<div class="input-group-addon"><i class="fa fa-address-card" aria-hidden="true"></i></div>
					<input required type="text" class="form-control" name="inpt-cpf" id="inpt-cpf" title="CPF" maxlength="11">
				</div>
				<small class="form-text badge badge-dark" id="inpt-cpf-msg">Somente números</small>
			</div>
			<div class="form-group col-sm-3">
				<label class="badge badge-light" for="rg">RG*</label>
				<div class="input-group">
					<div class="input-group-addon"><i class="fa fa-address-card-o" aria-hidden="true"></i></div>
					<input required type="text" class="form-control" name="inpt-rg" id="inpt-rg" title="RG" maxlength="14">
				</div>
				<small class="form-text badge badge-dark" id="inpt-rg-msg">Somente números</small>
			</div>
			<div class="form-group col-sm-3">
		    	<label class="badge badge-light" for="form-grop">Data de Nascimento*</label>
		    	<div class="input-group">
		    		<div class="input-group-addon"><i class="fa fa-calendar" aria-hidden="true"></i></div> 
					<input required type="text" class="form-control" name="inpt-dtNasc" id="inpt-dtNasc" title="Insira Data" placeholder=" / / " maxlength="10">
				</div>
		  	</div>
			<div class="form-group col-sm-3">
				<label class="badge badge-light" for="naturalidade">Naturalidade*</label>
				<div class="input-group">
					<div class="input-group-addon"><i class="fa fa-child" aria-hidden="true"></i></div>
					<select required class="form-control custom-select" name="inpt-nat" id="inpt-nat" title="Naturalidade">
						<option title="Selecione" value="0">Selecione</option>
					 	<option title="Brasileiro" value="1">Brasileiro</option>
					 	<option title="Estrangeiro" value="2">Estrangeiro</option>
					</select>
				</div>
			</div>
		</div>
		
		<div class="validado">
			<div class="form-row">
				<div class="form-group col-sm-4">
					<label class="badge badge-light" for="nome">Nome*</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></div>
						<input required type="text" class="form-control naoespecial" name="inpt-nome" id="inpt-nome" title="Nome do aluno" placeholder="Nome do aluno" maxlength="60">
					</div>
					<small class="help-text badge badge-dark">Insira o nome completo do Aluno</small> 
				</div>
				<div class="form-group col-sm-2">
					<label class="badge badge-light" for="sexo">Sexo*</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-venus-mars" aria-hidden="true"></i></div>
						<select required class="form-control custom-select" name="inpt-sx" id="inpt-sx" title="Sexo">
							<option title="Selecione" value="0">Selecione</option>
							<option title="Feminino" value="F">Feminino</option>
							<option title="Masculino" value="M">Masculino</option>
							<option title="Outros" value="O">Outros</option>
						</select>
					</div>
				</div>
				<div class="form-group col-sm-3">
					<label class="badge badge-light" for="nomeMae">Nome da Mãe*</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-female" aria-hidden="true"></i></div>
						<input required type="text" class="form-control naoespecial" name="inpt-nMae" id="inpt-nMae" title="Insira o nome da Mãe" placeholder="Nome da mãe" maxlength="50">
					</div>
				</div>
				<div class="form-group col-sm-3">
					<label class="badge badge-light" for="nomePai">Nome do Pai*</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-male" aria-hidden="true"></i></div>
						<input required type="text" class="form-control naoespecial" name="inpt-nPai" id="inpt-nPai" title="Insira o nome do pai" placeholder="Nome do pai" maxlength="50">
					</div> 
				</div>
			</div>
			<!-- ENDEREÇO -->
			<div class="form-row">
				<div class="form-group col-sm-3">
					<label class="badge badge-light" for="cep">CEP*</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-street-view" aria-hidden="true"></i></div>
						<input required type="text" class="form-control" name="inpt-cep" id="inpt-cep" title="Digite o cep" placeholder="00000000" maxlength="10">
					</div>
					<small class="form-text badge badge-dark" id="inpt-dtNasc-msg">Somente números</small>
				</div>
				<div class="form-group col-sm-2">
					<label class="badge badge-light" for="uf">UF*</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-map" aria-hidden="true"></i></div>
						<input required type="text" class="form-control naoespecial" name="inpt-uf" id="inpt-uf" title="Insira a sigla da unidade da federação" placeholder="UF" maxlength="2">
					</div>
				</div>
				<div class="form-group col-sm-3">
					<label class="badge badge-light" for="cidade">Cidade*</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-location-arrow" aria-hidden="true"></i></div>
						<input required type="text" class="form-control naoespecial" name="inpt-cidade" id="inpt-cidade" title="Nome da cidade" placeholder="Cidade" maxlength="44">
					</div>
				</div>
				<div class="form-group col-sm-4">
					<label class="badge badge-light" for="bairro">Bairro*</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-map-pin" aria-hidden="true"></i></div>
						<input type="text" class="form-control naoespecial" name="inpt-bairro" id="inpt-bairro" title="Bairro" placeholder="Bairro" maxlength="44">
					</div>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-sm-8">
					<label class="badge badge-light" for="endereco">Endereço*</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-map-marker" aria-hidden="true"></i></div>
						<input required type="text" class="form-control naoespecial" name="inpt-end" id="inpt-end" title="Insira Endereço" placeholder="Endereço" maxlength="59">
					</div> 
				</div>
				<div class="form-group col-sm-4">
					<label class="badge badge-light" for="complemento">Complemento</label>
					<input type="text" class="form-control naoespecial" name="inpt-compl" id="inpt-compl" title="Complemento" placeholder="Complemento" maxlength="44"> 
				</div>
			</div>
			<!-- Informações de contato -->
			<div class="form-row">
				<div class="form-group col-sm-6">
					<label class="badge badge-light" for="email">Email*</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-envelope" aria-hidden="true"></i></div>
						<input required type="email" class="form-control" name="inpt-email" id="inpt-email" title="Email do aluno" placeholder="emailaluno@provedor.com" maxlength="49">
					</div>
				</div>
				<div class="form-group col-sm-3">
					<label class="badge badge-light" for="telefone">Telefone</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-phone" aria-hidden="true"></i></div>
						<input type="text" class="form-control" name="inpt-fone" id="inpt-fone" title="Número de telefone" placeholder="00 000000000" maxlength="11">
					</div>
					<p class="help-text badge badge-dark" id="inpt-fone-msg">Somente números</p> 
			   </div>
				<div class="form-group col-sm-3">
					<label class="badge badge-light" for="celular">Celular*</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-mobile" aria-hidden="true"></i></div>
						<input required type="text" class="form-control" name="inpt-celular" id="inpt-celular" title="Celular" placeholder="00 000000000" maxlength="11">
					</div>
					<p class="help-text badge badge-dark" id="inpt-cel-msg">Somente números</p> 
			   </div>
			</div>
			<div class="form-row">
				<div class="form-group col-sm-4">
					<label class="badge badge-light" for="escolaridade">Escolaridade*</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-graduation-cap" aria-hidden="true"></i></div>
						<select required class="form-control custom-select" name="inpt-escl" id="inpt-escl" title="Nivel de escolaridade">
					 		<option title="Selecione" value="S">Selecione</option>
							 <option title="Fundamental" value="F">Fundamental</option>
							 <option title="Médio" value="M">Médio</option>
						</select>
					</div>
					<p class="help-text badge badge-danger" id="inpt-escol-msg"></p>
				</div>
				<div class="form-group col-sm-2">
					<label class="badge badge-light" for="anoEscolar">Ano Escolar</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-line-chart" aria-hidden="true"></i></div>
						<select required disabled class="form-control custom-select" name="inpt-escl-ano" id="inpt-escl-ano" title="Ano Eescolar">
					 		<option title="Selecione" value="0">Selecione</option>
						</select>
					</div>
					<p class="help-text badge badge-danger" id="inpt-escl-ano-msg"></p>
				</div>
				<div class="form-group col-sm-6">
					<label class="badge badge-light" for="instituicao">Instituição</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-university" aria-hidden="true"></i></div>
						<select required disabled class="form-control custom-select" name="inpt-inst" id="inpt-inst" title="Instituição que irá receber a matrícula">
							<option title="Selecione" value="0">Selecione</option>
						</select>
					</div>
					<p class="help-text badge badge-danger" id="inpt-escl-inst-msg"></p>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-sm-4">
					<label class="badge badge-light" for="usuario">Usuario</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></div>
						<input required type="text" class="form-control validausu" name="inpt-usu" id="inpt-usu" title="Nome de usuário" maxlength="20">
					</div>
				</div>
				<div class="form-group col-sm-4">
					<label class="badge badge-light" for="senha">Senha</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-key" aria-hidden="true"></i></div>
						<input required type="password" class="form-control validausu" name="inpt-senha" id="inpt-senha" title="Insira uma senha" maxlength="12">
					</div>
					<p class="help-text badge badge-dark" id="inpt-senha-msg">Mínimo 6 caracteres entre letras e números</p>
				</div>
				<div class="form-group col-sm-4">
					<label class="badge badge-light" for="confirmarSenha">Confirmar Senha</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-key" aria-hidden="true"></i></div>
						<input required type="password" class="form-control validausu" name="inpt-senha-confirm" id="inpt-senha-confirm" title="Confirmar senha" maxlength="12">
					</div>
					<p class="help-text badge badge-dark" id="inpt-senha-confirm-msg"></p>
				</div>
			</div>
			<div class="form-row">
				<div class="col-12">
					<button type="submit" id="btn-submit" class="btn btn-success" title="Enviar">
						<i class="fa fa-paper-plane-o" aria-hidden="true"></i> Enviar
					</button>
				</div>
			</div>
		</div>
	</form>
	<br/>
</div>
<%@ include file="/partials/footer.jsp" %>
</body>
</html>
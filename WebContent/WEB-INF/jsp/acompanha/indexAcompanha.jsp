<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mais Educacional - Acompanhamento de matricula</title>
	<%@ include file="/partials/headStyle.jsp" %>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/acompanha.css">
	<%@ include file="/partials/headJs.jsp" %>
</head>
<body>
<div class="container-fluid">
	<div class="row dark-8 txt-light">
		<div class="col-10">
			<h4>Acompanhamento de Matrícula</h4>
		</div>
		<div class="col-2 btn-top">
			<a class="btn btn-danger" href="<%=request.getContextPath()%>/login?acao=sair" title="Sair">
				<i class="fa fa-sign-out" aria-hidden="true"></i> Sair
			</a>
		</div>
	</div>
</div>
<div class="container-fluid">
	<div class="row padding-2">
		<div class="col-12 col-md-6">
			<h2><i class="fa fa-address-card" aria-hidden="true"></i> Acompanhe sua solicitação</h2>
		</div>
		<div class="col-12 col-md-6">
			<i class="fa fa-info-circle" aria-hidden="true"></i> <b>Status:</b> <span class="badge badge-danger">${matricula.situacao}</span>
		</div>
	</div>
</div>
<div class="container-fluid">
	<div class="card bg-light mb-3">
		<div class="card-header">
			<i class="fa fa-user" aria-hidden="true"></i> <b>Dados Pessoais do Aluno</b>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-12 col-md-2">
					<b>CPF:</b> ${pessoa.cpf}
				</div>
				<div class="col-12 col-md-3">
					<b>RG:</b> ${pessoa.rg}
				</div>
				<div class="col-12 col-md-4">
					<b>Data de Nascimento:</b> ${pessoa.dataNascStr}
				</div>
				<div class="col-12 col-md-3">
					<b>Naturalidade:</b> ${pessoa.naturalidade}
				</div>
			</div>
			<div>&nbsp;</div>
			<div class="row">
				<div class="col-12 col-md-4">
					<b>Nome:</b> ${pessoa.nome}
				</div>
				<div class="col-12 col-md-2">
					<b>Sexo:</b> ${pessoa.sexo}
				</div>
				<div class="col-12 col-md-3">
					<b>Mãe:</b> ${aluno.nomeMae}
				</div>
				<div class="col-12 col-md-3">
					<b>Pai:</b> ${aluno.nomePai}
				</div>
			</div>
		</div>
	</div>
	
	<div class="card text-white bg-info mb-3">
		<div class="card-header">
			<i class="fa fa-phone" aria-hidden="true"></i> <b>Informações de contato</b>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-12 col-md-3">
					<b>CEP</b> ${pessoa.cep}
				</div>
				<div class="col-12 col-md-3">
					<b>UF</b> ${pessoa.uf}
				</div>
				<div class="col-12 col-md-3">
					<b>Cidade</b> ${pessoa.cidade}
				</div>
				<div class="col-12 col-md-3">
					<b>Bairro</b> ${pessoa.bairro}
				</div>
			</div>
			<div>&nbsp;</div>
			<div class="row">
				<div class="col-12 col-md-8">
					<b>Endereço:</b> ${pessoa.endereco}
				</div>
				<div class="col-12 col-md-4">
					<b>Complemento:</b> ${pessoa.complemento}
				</div>
			</div>
			<div>&nbsp;</div>
			<div class="row">
				<div class="col-12 col-md-4">
					<b>Email:</b> ${contato.email}
				</div>
				<div class="col-12 col-md-4">
					<b>Telefone:</b> ${contato.telefone}
				</div>
				<div class="col-12 col-md-4">
					<b>Celular:</b> ${contato.celular}
				</div>
			</div>
		</div>
	</div>
	
	<div class="card text-white bg-secondary mb-3">
		<div class="card-header">
			<i class="fa fa-university" aria-hidden="true"></i> <b>Escola</b>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-12 col-md-4">
					<b>Escolaridade:</b> ${aluno.escolaridade}
				</div>
				<div class="col-12 col-md-4">
					<b>Ano Escolar:</b> ${aluno.anoEscolar}
				</div>
				<div class="col-12 col-md-4">
					<b>Instituição:</b> ${insti.nome}
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>
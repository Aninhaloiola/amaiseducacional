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
<div class="container">
	<div class="row padding-2">
		<div class="col-12 col-md-6">
			<h2>Acompanhe sua solicitação</h2>
		</div>
		<div class="col-12 col-md-6">
			<b>Status:</b> <span class="badge badge-danger">Pendente</span>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-12 col-md-3">
			<b>CPF:</b> ${pessoa.cpf}
		</div>
		<div class="col-12 col-md-3">
			<b>RG:</b> ${pessoa.rg}
		</div>
		<div class="col-12 col-md-3">
			<b>Data de Nascimento:</b> ${pessoa.dataNasc}
		</div>
		<div class="col-12 col-md-3">
			<b>Naturalidade:</b> ${pessoa.naturalidade}
		</div>
	</div>
	<div class="row">
		<div class="col-12 col-md-6">
			<b>Nome:</b> ${pessoa.nome}
		</div>
		<div class="col-12 col-md-3">
			<b>Mãe:</b>
		</div>
		<div class="col-12 col-md-3">
			<b>Pai:</b>
		</div>
	</div>
</div>

<%@ include file="/partials/footer.jsp" %>
</body>
</html>
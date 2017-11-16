<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mais Educacional</title>
	<%@ include file="/partials/headStyle.jsp" %>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/index.css">
	<%@ include file="/partials/headJs.jsp" %>
</head>
<body>
<%@ include file="/partials/header.jsp" %>
<div class="container-fluid margin-6">
	<div id="nmatricula" class="row light-8 padding-4">
		<div class="col-12 txt-dark">
			<div style="text-align: center; font-size: 2em;">
				Bem Vindo!
			</div>
			<div style="text-align: center;">
				<br/>
				No <strong>A Mais Educacional</strong> você porderá realizar solicitações de matrícula e acompanhar as que você efetuou anteriormente.
				<br/>Sem filas, sem espera, de onde você estiver e a qualquer hora.
			</div>
		</div>
	</div>
</div>
<div class="container-fluid margin-6">
	<div class="row dark-8">
		<div class="col-12" style="text-align: center;">
			<div class="btn-bar">
				<a href="<%=request.getContextPath() %>/matricula" class="btn btn-outline-success btn-lg" title="Nova Matricula">
					<i class="fa fa-plus"></i> Nova Matricula
				</a>
			</div>
		</div>
	</div>
</div>
<div class="container-fluid margin-6">
	<div class="row light-8 padding-4">
		<div class="col-12 txt-dark">
			<div style="text-align: center; font-size: 2em;">
				Na palma da mão
			</div>
			<div style="text-align: center;">
				Acompanhe sua solicitação sem sair de casa, direto do seu computador, tablet ou celular.
			</div>
		</div>
	</div>
</div>
<div class="container-fluid margin-6">
	<div id="amatricula" class="row dark-8">
		<div class="col-12" style="text-align: center;">
			<div class="btn-bar">
				<a href="<%=request.getContextPath() %>/acompanhar-matricula" class="btn btn-outline-info btn-lg" title="Acompanhar Matricula">
					<i class="fa fa-chevron-right"></i> Acompanhar Matricula
				</a>
			</div>
		</div>
	</div>
</div>
<div class="container-fluid margin-6">
	<div class="row light-8 padding-4	">
		<div class="col-12 txt-dark">
			<div style="text-align: center; font-size: 2em;">
				Escolas participantes
			</div>
			<div style="text-align: center;">
				Confira sua escola no A Mais Educacional
			</div>
		</div>
	</div>
</div>
<div class="container-fluid margin-6">
	<div id="cescola" class="row dark-8">
		<div class="col-12" style="text-align: center;">
			<div class="btn-bar">
				<a href="" class="btn btn-outline-info btn-lg" title="Consultar Escola">
					<i class="fa fa-search"></i> Consultar Escola
				</a>
			</div>
		</div>
	</div>
</div>
<footer>
	<div class="container-fluid">
		<div class="row dark-6 padding-2">
			<div class="col-12 col-sm-4">
				<div class="txt-light">
					<h6>Mais Educacional</h6>
				</div>
			</div>
			<div class="col-12 col-sm-2">
				<ul>
					<li><a href="" title="Inicio">Inicio</a></li>
					<li><a href="" title="Ajuda">Ajuda</a></li>
				</ul>
			</div>
			<div class="col-12 col-sm-2">
				<ul>
					<li><a href="" title="Contato">Contato</a></li>
				</ul>
			</div>
			<div class="col-12 col-sm-4">
				Copyright 2017
			</div>
		</div>
	</div>
</footer>
</body>
</html>
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
<video playsinline autoplay muted loop poster="<%=request.getContextPath()%>/images/iconEduca.jpg" id="bgvid">
    <source src="<%=request.getContextPath()%>/images/EasternChristianSchoolHighSchoolCampus.mp4" type="video/mp4">
</video>
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
<div id="amatricula" class="container-fluid margin-6">
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
	<div class="row dark-8">
		<div class="col-12" style="text-align: center;">
			<div class="btn-bar">
				<a href="<%=request.getContextPath() %>/login?tipo=acompanhar" class="btn btn-outline-info btn-lg" title="Acompanhar Matricula">
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
				<a href="<%=request.getContextPath()%>/consultarescola" class="btn btn-outline-info btn-lg" title="Consultar Escola">
					<i class="fa fa-search"></i> Consultar Escola
				</a>
			</div>
		</div>
	</div>
</div>
<%@ include file="/partials/footer.jsp" %>
</body>
</html>
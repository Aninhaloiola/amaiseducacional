<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mais Educacional - Escola</title>
	<%@ include file="/partials/headStyle.jsp" %>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/escola.css">
	<%@ include file="/partials/headJs.jsp" %>
	<script type="text/javascript" src="<%=request.getContextPath()%>/lib/validacao.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/escola/escola.js"></script>
</head>
<body>
<%@ include file="/partials/header.jsp" %>
<div class="container margin-2">
	<div class="row light-6 padding-2">
		<div class="col-12 txt-dark">
			<div style="text-align: center; font-size: 2em;">
				<i class="fa fa-search" aria-hidden="true"></i> Consultar Escola
			</div>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col">
			<c:if test="${not empty msg}">
			<div id="frm-matr-alert" class="alert alert-warning">
				${msg}
			</div>
			</c:if>
		</div>
	</div>
</div>
<div class="container light-6">
	<form method="get" action="/maiseducacional/consultarescola" enctype="application/x-www-form-urlencoded">
		<div class="form-row">
			<div class="form-group col-12">
				<label class="badge badge-light" for="escola">Escola</label>
				<div class="input-group">
					<div class="input-group-addon"><i class="fa fa-university" aria-hidden="true"></i></div>
					<select class="form-control custom-select" name="inpt-escola" id="inpt-escola" title="Selecione uma Escola">
					<option title="Selecione" value="0">Selecione</option>
					<c:forEach items="${escolas}" var="escola">
					<option title="${escola.nome}" value="${escola.idInst}">${escola.nome}</option>	
					</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-12">
				<button type="submit" class="btn btn-info" title="Pesquisar">
					<i class="fa fa-search" aria-hidden="true"></i> Pesquisar
				</button>
			</div>
		</div>
	</form>
</div>
<c:if test="${not empty escInfo}">
<div class="container light-6">
	<div class="row alert alert-success" style="font-size: 16px; color: #000;">
		<div class="col col-xs-6">
			<b>Escola:</b> ${escInfo.nome}
		</div>
		<div class="col col-xs-2">
			<b>UF:</b> ${escInfo.uf}
		</div>
		<div class="col col-xs-4">
			<b>Cidade:</b> ${escInfo.cidade}
		</div>
	</div>
	<div class="row">
		<div class="col">
			<table class="table table-hover table-dark">
				<thead class="thead-dark">
					<tr>
						<th>Matriculas</th>
						<th>Pendentes</th>
						<th>Validadas</th>
						<th>Canceladas</th>
						<th>Masculino</th>
						<th>Feminino</th>
						<th>Outros</th>
						<th>Brasileiros</th>
						<th>Estrangeiros</th>
					</tr>
				</thead>
				<tbody>
					<tr class="bg-primary">
						<td>${escInfo.totalMatriculas}</td>
						<td>${escInfo.totalPendentes}</td>
						<td>${escInfo.totalValidas}</td>
						<td>${escInfo.totalCanceladas}</td>
						<td>${escInfo.totalMasculino}</td>
						<td>${escInfo.totalFeminino}</td>
						<td>${escInfo.totalOutros}</td>
						<td>${escInfo.totalBra}</td>
						<td>${escInfo.totalEstrangeiros}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</c:if>
</body>
</html>
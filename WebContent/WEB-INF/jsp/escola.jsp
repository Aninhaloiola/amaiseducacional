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
			<div id="frm-matr-alert" class="alert alert-danger">
				${aviso}
			</div>
		</div>
	</div>
</div>
<div class="container light-6">
	<form method="post" action="/maiseducacional/escola" enctype="application/x-www-form-urlencoded">
		<div class="form-row">
			<div class="form-group col-12">
				<label class="badge badge-light" for="escola">Escola</label>
				<div class="input-group">
					<div class="input-group-addon"><i class="fa fa-university" aria-hidden="true"></i></div>
					<select class="form-control custom-select" name="inpt-escola" id="inpt-escola" title="Selecione uma Escola">
						<option title="Selecione" value="0">Selecione</option>
					</select>
				</div>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-12">
				<button type="button" title="Pesquisar">
					<i class="fa fa-search" aria-hidden="true"></i> Pesquisar
				</button>
			</div>
		</div>
	</form>
</div>
</body>
</html>
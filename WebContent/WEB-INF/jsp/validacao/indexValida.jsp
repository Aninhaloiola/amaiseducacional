<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mais Educacional - Validação de matricula</title>
	<%@ include file="/partials/headStyle.jsp" %>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/valida.css">
	<%@ include file="/partials/headJs.jsp" %>
</head>
<body>
<div class="container-fluid">
	<div class="row dark-8 txt-light">
		<div class="col-10">
			<h4>Validação de Matrícula</h4>
		</div>
		<div class="col-2 btn-top">
			<a class="btn btn-danger" href="<%=request.getContextPath()%>/login?acao=sair" title="Sair">
				<i class="fa fa-sign-out" aria-hidden="true"></i> Sair
			</a>
		</div>
	</div>
</div>
<!-- <div class="container-fluid"> -->
<!-- 	<div class="row padding-2"> -->
<!-- 		<div class="col-12 col-md-6"> -->
<!-- 			<h2><i class="fa fa-address-card" aria-hidden="true"></i> Matriculas para validação</h2> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->
<div class="container-fluid">
	<ul class="nav nav-tabs" role="tablist">
	    <li class="nav-item">
	        <a class="nav-link active" data-toggle="tab" href="#pendentes" role="tab">
	        	<i class="fa fa-user" aria-hidden="true"></i> <b>Pendentes de validação</b>
			</a>
	    </li>
	    <li class="nav-item">
	        <a class="nav-link" data-toggle="tab" href="#validadas" role="tab">
	        	<i class="fa fa-check" aria-hidden="true"></i> <b>Validadas</b>
	        </a>
	    </li>
	</ul>
	<!-- Tab panes -->
	<div class="tab-content">
	    <div class="tab-pane active" id="pendentes" role="tabpanel">
			<table class="table table-hover">
				<thead class="thead-dark">
					<tr>
						<th>Matricula</th>
						<th>Data</th>
						<th>Aluno</th>
						<th>Escolaridade</th>
						<th>Ano</th>
						<th>Ação</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${pendls}" var="mtr">
					<tr>
						<td>${mtr.idMatricula}</td>
						<td>${mtr.dtMat}</td>
						<td>${mtr.pessoa.nome}</td>
						<td>${mtr.am.escolaridade}</td>
						<td>${mtr.am.anoEscolar}</td>
						<td style="width: 25%; text-align: right;">
							<a href="<%=request.getContextPath() %>/validacao?acao=detalhar&mtr=${mtr.idMatricula}&p=${mtr.pessoa.idPessoa}" class="btn btn-info" title="Detalhar">Detalhar</a>
							<a href="<%=request.getContextPath() %>/validacao?acao=validar&mtr=${mtr.idMatricula}&p=${mtr.pessoa.idPessoa}" class="btn btn-primary" title="Validar">Validar</a>
							<a href="<%=request.getContextPath() %>/validacao?acao=cancelar&mtr=${mtr.idMatricula}&p=${mtr.pessoa.idPessoa}" class="btn btn-danger" title="Cancelar">Cancelar</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
	    </div>
	    <div class="tab-pane" id="validadas" role="tabpanel">
	    	Profile
	    </div>
	</div>
</div>

</body>
</html>
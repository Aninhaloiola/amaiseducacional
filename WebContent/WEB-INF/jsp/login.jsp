<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mais Educacional - Login</title>
	<%@ include file="/partials/headStyle.jsp" %>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css">
	<%@ include file="/partials/headJs.jsp" %>
	<script type="text/javascript" src="<%=request.getContextPath()%>/lib/validacao.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/login/frm_login.js"></script>
</head>
<body>
<%@ include file="/partials/header.jsp" %>
<div class="container-fluid margin-top-2">
	<div class="row">
		<div class="col-12 col-md-4"></div>
		<div class="col-12 col-md-6 col-lg-4">
			<div class="card text-white bg-light mb-3" style="max-width: 50rem;">
			 	<div class="card-header header">
			 		<a href="<%=request.getContextPath()%>/login" title="Login">
						<i class="fa fa-user-o" aria-hidden="true"></i> Log in
					</a>
			 	</div>
			  	<div class="card-body">
			    	<h4 class="card-title">
			    		<c:if test="${not empty msg}">
							<div id="frm-login-alert" class="alert alert-danger">
								<i class="fa fa-exclamation-triangle" aria-hidden="true"></i> ${msg}
							</div>
						</c:if>
					</h4>
			    	<p class="card-text">
			    		<form method="post" action="/maiseducacional/login" enctype="application/x-www-form-urlencoded">
							<div class="form-row">
								<div class="form-group col-12">
									<label class="badge badge-light" for="usuario">Usuario</label>
									<div class="input-group">
										<div class="input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></div>
										<input required type="text" class="form-control validausu" name="inpt-usu" id="inpt-usu" title="Nome de usuário" placeholder="Nome de usuário" maxlength="20">
									</div>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-12">
									<label class="badge badge-light" for="senha">Senha</label>
									<div class="input-group">
										<div class="input-group-addon"><i class="fa fa-key" aria-hidden="true"></i></div>
										<input required type="password" class="form-control validausu" name="inpt-senha" id="inpt-senha" title="Senha" maxlength="12">
									</div>
									<p class="help-text badge badge-dark" id="inpt-senha-msg">Mínimo 6 caracteres entre letras e números</p>
								</div>
							</div>
							<div class="form-row">
								<div class="col-12 btn-bar">
									<button type="submit" id="btn-submit" class="btn btn-primary" title="Log in">
										<i class="fa fa-lock" aria-hidden="true"></i> Log in
									</button>
								</div>
							</div>
						</form>
			    	</p>
			  	</div>
			</div>
		</div>
	</div>
</div>
<div class="margin-2">&nbsp;</div>
<%@ include file="/partials/footer.jsp" %>
</body>
</html>
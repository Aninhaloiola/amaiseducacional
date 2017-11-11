<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mais Educacional - Aviso</title>
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
				Aviso
			</div>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col">
			${aviso}
		</div>
	</div>
</div>
</body>
</html>
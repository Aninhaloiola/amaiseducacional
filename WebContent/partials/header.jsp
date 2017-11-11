<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-fluid">
	<div class="row header light-6">
		<div class="col-2 col-sm-1">
			<div class="img-logo">
				<img src="<%=request.getContextPath()%>/images/iconEduca.png" alt="Mais Educacioanl" title="Mais Educacioanl">
			</div>
		</div>
		<div class="col-10 col-sm-5">
			<div class="main-logo">
				<h1>
					<a href="<%=request.getContextPath()%>/inicio"> A Mais Educacional</a>
				</h1>
			</div>
		</div>
		<div class="col col-sm-2">
			<c:if test="${pagina != 'inicio'}">
			<a href="<%=request.getContextPath()%>/inicio" class="btn btn-outline-dark" title="Inicio">
				<i class="fa fa-home"></i> Inicio
			</a>
			</c:if>
			<c:if test="${pagina != 'matricula'}">
			<a href="#nmatricula" class="btn btn-outline-dark" title="Nova Matricula">
				<i class="fa fa-plus"></i> Nova Matricula
			</a>
			</c:if>
		</div>
		<div class="col col-sm-2">
			<c:if test="${pagina != 'acompanhar'}">
			<a href="#amatricula" class="btn btn-outline-dark" title="Acompanhar Matricula">
				<i class="fa fa-plus"></i> Acompanhar Matricula
			</a>
			</c:if>
		</div>
		<div class="col col-sm-2">
			<c:if test="${pagina != 'consultaresc'}">
			<a href="#cescola" class="btn btn-outline-dark" title="Consultar Escola">
				<i class="fa fa-plus"></i> Consultar Escola
			</a>
			</c:if>
		</div>
	</div>
</div>
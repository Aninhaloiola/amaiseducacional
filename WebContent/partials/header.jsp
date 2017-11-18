<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-fluid">
	<div class="row header light-8">
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
		<div class="col-12 col-sm-6">
			<ul class="main-nav">
				<li>
					<c:if test="${pagina != 'inicio'}">
					<a href="<%=request.getContextPath()%>/inicio" title="Inicio">
						<i class="fa fa-home"></i> Inicio
					</a>
					</c:if>
					<c:if test="${pagina != 'matricula'}">
					<a href="#nmatricula" title="Nova Matricula">
						<i class="fa fa-plus"></i> Nova Matricula
					</a>
					</c:if>
				</li><li>
					<c:if test="${pagina!='acompanhar' && pagina!='login'}">
					<a href="#amatricula" title="Acompanhar Matricula">
						<i class="fa fa-chevron-left"></i> Acompanhar Matricula
					</a>
					</c:if>
				</li><li>
					<c:if test="${pagina != 'consultaresc'}">
					<a href="#cescola" title="Consultar Escola">
						<i class="fa fa-search"></i> Consultar Escola
					</a>
					</c:if>
				</li>
			</ul>
		</div>
	</div>
</div>
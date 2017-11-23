<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
					<li><a href="<%=request.getContextPath()%>/inicio" title="Inicio">Inicio</a></li>
					<li><a href="<%=request.getContextPath()%>/login?tipo=validar" title="Validador">Validador</a></li>
				</ul>
			</div>
			<div class="col-12 col-sm-2">
			</div>
			<div class="col-12 col-sm-4">
				Copyright 2017
			</div>
		</div>
	</div>
</footer>
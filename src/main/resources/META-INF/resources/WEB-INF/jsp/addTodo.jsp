<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h2>Nova tarefa</h2>
	<form:form method="post" modelAttribute="todo">
		<div class="row">
			<div class="mb-3 row">
				<fieldset class="mb-3 col-lg-4">
					<form:label path="description" cssClass="form-label">Descrição </form:label>
					<form:input type="text" cssClass="form-control"
						id="inputDescription" path="description"
						aria-describedby="descriptionHelp" required="required" />
					<form:errors path="description" />
					<div id="descriptionHelp" class="form-text">Jogar o lixo
						fora.</div>
				</fieldset>
				<fieldset class="mb-3 col-lg-auto">
					<form:label path="targetDate" cssClass="form-label">Data </form:label>
					<form:input type="text" cssClass="form-control" path="targetDate"
						required="required" />
					<form:errors path="targetDate" />

				</fieldset>
				<form:input type="hidden" path="id" />
				<form:input type="hidden" path="done" />
			</div>
		</div>

		<button type="submit" class="btn btn-outline-success btn-sm">
			Enviar <i class="bi bi-send"></i>
		</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>
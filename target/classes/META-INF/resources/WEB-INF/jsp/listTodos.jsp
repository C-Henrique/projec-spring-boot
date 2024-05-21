<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<div class="container">
    <h2>Seu Todos</h2>
	<table class="table">
		<thead>
			<th>Descrição</th>
			<th>Data</th>
			<th>Finalizado</th>
			<th></th>
			<th></th>
		</thead>
		<tbody class="table-group-divider">
			<c:forEach items="${todos }" var="todos">
				<tr>
					<td>${todos.description }</td>
					<td>${todos.targetDate }</td>
					<td>${todos.done}</td>
					<td><a href="delete-todo?id=${todos.id }"
						class=" btn btn-outline-danger btn-sm"><i class="bi bi-trash"></i></a></td>
					<td><a href="update-todo?id=${todos.id }"
						class=" btn btn-outline-success btn-sm"><i
							class="bi bi-pencil"></i></a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn btn-outline-primary btn-sm">Novo <i
		class="bi bi-plus-lg"></i></a>
</div>
<%@ include file="common/footer.jspf" %>
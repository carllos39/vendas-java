<jsp:include page="../cabecalho.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Formulário de Itens Pedido</h2>
<form action="BuscaUmItenController" method="post">

<div>
<label>Produto</label>
<input value="<%=request.getParameter("id")%>" type="text" name="produto_id">
</div>
<div>
<label>Quantidade :</label>
<input type="text" name="quantidade">
</div>
<div>
<label>Valor :</label>
<input value=" ${produto.valor}" type="text" name="valor">
</div>
<div>
<label>Selecione um cliente</label>
<a href="ItensBuscaClienteController">Cliente</a>
<select name="id">
<option></option>
<c:forEach items="${lista}" var="cliente">
<option value="${cliente.id}">${cliente.nome}</option>
</c:forEach>
</select>
</div>
<button type="submit">Inserir</button>
</form>
<hr>
<h3>Lista de Itens pedido</h3>
<a href="<%=request.getContextPath()%>/ItensController"><button>Lista</button></a>
<table>
<tr>
<th>Id:</th>
<th>Quantidade:</th>
<th>Valor:</th>
<th>Produto:</th>
<th>Cliente:</th>
</tr>
<c:forEach items="${listaItens}" var="itenspedido">
<tr>
<td>${itenspedido.id}</td>
<td>${itenspedido.quantidade}</td>
<td>${itenspedido.valor}</td>
<td>${itenspedido.produto_id}</td>
<td>${itenspedido.cliente_id}</td>
<td><a href="Controller?id=${itenspedido.id}"><button>Alterar</button></a></td>
<td><a href="<%=request.getContextPath()%>/Controller?id=${itenspedido.id}"><button>Excluir</button></a></td>
</tr>
</c:forEach>
</table>
<jsp:include page="../rodape.jsp"></jsp:include>
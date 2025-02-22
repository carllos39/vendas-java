
<jsp:include page="../cabecalho.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Formulário de Produtos</h2>
<form action="ProdutoController" method="post">
<div>
<label>Nome :</label>
<input type="text" name="nome">
</div>
<div>
<label>Descrição :</label>
<input type="text" name="descricao">
</div>
<div>
<label>Valor :</label>
<input type="text" name="valor">
</div>
<button type="submit">Inserir</button>
</form>
<hr>
<h3>Lista de Produtos</h3>
<a href="<%=request.getContextPath()%>/ProdutoController"><button>Lista</button></a>
<table>
<tr>
<th>Id:</th>
<th>Nome:</th>
<th>Descrição:</th>
<th>Valor:</th>
<th>Ação:</th>
<th>Ação:</th>
</tr>
<c:forEach items="${listaProduto}" var="produto">
<tr>
<td>${produto.id}</td>
<td>${produto.nome}</td>
<td>${produto.descricao}</td>
<td>${produto.valor}</td>
<td><a href="BuscaProdutoController?id=${produto.id}"><button>Alterar</button></a></td>
<td><a href="<%=request.getContextPath()%>/ExcluirProdutoController?id=${produto.id}"><button>Excluir</button></a></td>
<td><a href="<%=request.getContextPath()%>/BuscaUmItenController?id=${produto.id}"><button>Cadastrar Itens</button></a></td>
</tr>
</c:forEach>
</table>
<jsp:include page="../rodape.jsp"></jsp:include>
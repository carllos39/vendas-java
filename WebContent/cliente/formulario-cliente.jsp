
<jsp:include page="../cabecalho.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Formulário de Cliente</h2>
<form action="ProdutoController" method="post">
<div>
<label>Nome :</label>
<input type="text" name="nome">
</div>
<div>
<label>Email :</label>
<input type="text" name="email">
</div>
<div>
<label>Senha :</label>
<input type="password" name="senha">
</div>
<button type="submit">Inserir</button>
</form>
<hr>
<h3>Lista de Clientes</h3>
<a href="ClienteController"><button>Lista</button></a>
<table>
<tr>
<th>Id:</th>
<th>Nome:</th>
<th>Email:</th>
<th>Ação:</th>
<th>Ação:</th>
<th>Ação:</th>
</tr>
<c:forEach items="${lista}" var="cliente">
<tr>
<td>${cliente.id}</td>
<td>${cliente.nome}</td>
<td>${cliente.email}</td>
<td><a href="BuscaUmEndereco?id=${cliente.id}"><button>Cadastrar Endereço</button></a></td>
<td><a href="BuscaClienteController?id=${cliente.id}"><button>Alterar</button></a></td>
<td><a href="ExcluirClienteController?id=${cliente.id}"><button>Excluir</button></a></td>
</tr>
</c:forEach>
</table>
<jsp:include page="../rodape.jsp"></jsp:include>
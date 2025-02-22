
<jsp:include page="../cabecalho.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Formulário de Endereços</h2>
<form action="BuscaUmEndereco" method="post">

                <div>
                <label>Id cliente :</label>
                <input value="<%=request.getParameter("id") %>" type="text" name="cliente_id">
                </div>
                <div>
                    <label for="logradouro">Logradouro:</label>
                    <input  type="text" id="logradouro" name="logradouro" size="30">
                </div>
                <div>
                    <label for="numero">Número:</label>
                    <input type="text" id="numero" name="numero" size="10">
                </div>
                <div>
                    <label for="bairro">Bairro:</label>
                    <input  type="text" id="bairro" name="bairro">
                </div>
                <div>
                    <label for="cidade">Cidade:</label>
                    <input  type="text" id="cidade" name="cidade">
                </div>
                <div>
                    <label for="estado">Estado:</label>
                    <input type="text" id="estado" name="estado">
                </div>
<button type="submit">Inserir</button>
</form>
<hr>
<h3>Lista de Endereços</h3>
<a href="<%=request.getContextPath()%>/EnderecoController"><button>Lista</button></a>
<table>
<tr>
<th>Id:</th>
<th>Endereço:</th>
<th>Número:</th>
<th>Bairro:</th>
<th>Cidade:</th>
<th>Estado:</th>
<th>Cliente:</th>
<th>Ação:</th>
<th>Ação:</th>
</tr>
<c:forEach items="${listaEnderecos}" var="endereco">
<tr>
<td>${endereco.id}</td>
<td>${endereco.logradouro}</td>
<td>${endereco.numero}</td>
<td>${endereco.bairro}</td>
<td>${endereco.cidade}</td>
<td>${endereco.estado}</td>
<td>${endereco.cliente_id}</td>
<td><a href="BuscaClienteController?id=${endereco.id}"><button>Alterar</button></a></td>
<td><a href="ExcluirClienteController?id=${endereco.id}"><button>Excluir</button></a></td>
</tr>
</c:forEach>
</table>


<jsp:include page="../rodape.jsp"></jsp:include>
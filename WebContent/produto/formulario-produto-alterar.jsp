<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../cabecalho.jsp"></jsp:include>
<h2>Formulário de alterar Produto</h2>
<form action="<%=request.getContextPath()%>/BuscaProdutoController" method="post">
<div>
<label>Id :</label>
<input type="text"  name="id">
</div>
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
<button type="submit">Alterar</button>
</form>
<jsp:include page="../rodape.jsp"></jsp:include>
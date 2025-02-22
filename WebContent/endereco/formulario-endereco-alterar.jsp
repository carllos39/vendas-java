<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../cabecalho.jsp"></jsp:include>
<h2>Formulário de alterar cliente</h2>
<form action="BuscaClienteController" method="post">
<div>
<label>Id :</label>
<input type="text"  name="id">
</div>
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
<button type="submit">Alterar</button>
</form>
<jsp:include page="../rodape.jsp"></jsp:include>
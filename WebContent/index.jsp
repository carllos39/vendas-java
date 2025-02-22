<jsp:include page="cabecalho.jsp"></jsp:include>
<form action="LoginController" method="post">
<input type="hidden" value="<%=request.getParameter("url")%>" name="url">
<div>
<label>Email</label>
<input type="text" name="email">
</div>
<div>
<label>Senha</label>
<input type="password" name="senha">
</div>
<button type="submit">Logar</button>
</form>
${msg}
<jsp:include page="rodape.jsp"></jsp:include>
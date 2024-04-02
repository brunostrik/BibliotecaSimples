<%@ page import="java.util.List" %>
<%@ page import="model.Autor" %>
<%@ page import="dao.AutorDAO" %>
<%@ page import="model.Area" %>
<%@ page import="dao.AreaDAO" %>
<%@ page import="model.Titulo" %>
<%@ page import="dao.TituloDAO" %>
<%@ page pageEncoding="utf-8" %>
<%@ include file="header.jsp" %>
<!-- Conteúdo Principal -->
<div class="content">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title text-center">Cadastrar Exemplares</h5>

            <form action="cadastrar-exemplares" method="post">
                <div class="form-group">
                    <label for="titulo">Título:</label>
                    <select name="titulo" id="titulo" class="form-control">
                        <%
                            List<Titulo> titulos = new TituloDAO().selectAll(Titulo.class);
                            for (Titulo a : titulos) {
                        %>
                        <option value="<%=a.getId()%>"><%=a.getTitulo()%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="acervo">Quantidade em acervo de biblioteca:</label>
                    <input type="number" name="acervo" id="acervo" class="form-control" required>
                </div>

                <div class="form-group">
                    <label for="emprest">Quantidade de exemplares emprestáveis:</label>
                    <input type="number" name="emprest" id="emprest" class="form-control" required>
                </div>

                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
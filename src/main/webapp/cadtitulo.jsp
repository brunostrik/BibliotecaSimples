<%@ page import="java.util.List" %>
<%@ page import="model.Autor" %>
<%@ page import="dao.AutorDAO" %>
<%@ page import="model.Area" %>
<%@ page import="dao.AreaDAO" %>
<%@ page pageEncoding="utf-8" %>
<%@ include file="header.jsp" %>
<!-- Conteúdo Principal -->
<div class="content">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title text-center">Cadastrar Título</h5>

            <form action="cadastrar-titulo" method="post">

                <div class="form-group">
                    <label for="titulo">Título:</label>
                    <input type="text" name="titulo" id="titulo" class="form-control" required maxlength="30">
                </div>

                <div class="form-group">
                    <label for="autor">Autor:</label>
                    <select name="autor" id="autor" class="form-control">
                        <%
                            List<Autor> autores = new AutorDAO().selectAll(Autor.class);
                            for (Autor a : autores) {

                        %>
                        <option value="<%=a.getId()%>"><%=a.getNome()%> <%=a.getSobrenome()%> (<%=a.getTitulacao()%>)
                        </option>
                        <%}%>
                    </select>
                </div>

                <div class="form-group">
                    <label for="area">Área:</label>
                    <select name="area" id="area" class="form-control">
                        <%
                            List<Area> areas = new AreaDAO().selectAll(Area.class);
                            for (Area a : areas) {

                        %>
                        <option value="<%=a.getId()%>"><%=a.getNome()%>
                        </option>
                        <%}%>
                    </select>
                </div>

                <div class="form-group">
                    <label for="prazo">Prazo (dias):</label>
                    <input type="number" name="prazo" id="prazo" class="form-control" required>
                </div>

                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
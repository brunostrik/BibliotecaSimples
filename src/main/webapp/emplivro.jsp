<%@ page import="java.util.List" %>
<%@ page import="model.Aluno" %>
<%@ page import="dao.AlunoDAO" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page pageEncoding="utf-8" %>
<%@ include file="header.jsp" %>
<!-- Conteúdo Principal -->
<div class="content">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title text-center">Emprestar Livros</h5>

            <form action="emprestar" method="post">
                <div class="form-group">
                    <label for="aluno">Aluno (alunos em débito não são exibidos):</label>
                    <select name="aluno" id="aluno" class="form-control">
                        <%
                            List<Aluno> alunos = new AlunoDAO().selectSemDebito();
                            for (Aluno a : alunos) {
                        %>
                        <option value="<%=a.getMatricula()%>"><%=a.getNome()%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="dataemp">Data Empréstimo:</label>
                    <input type="date" name="dataemp" id="dataemp" class="form-control" required value="<%=LocalDate.now().format(DateTimeFormatter.ISO_DATE)%>">
                </div>
                <div class="form-group">
                    <label for="items">Adicione o id dos exemplares, separados por vírgula:</label>
                    <input type="text" name="items" id="items" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
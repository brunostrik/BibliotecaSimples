<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="model.Emprestimo" %>
<%@ page import="dao.EmprestimoDAO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page pageEncoding="utf-8" %>
<%@ include file="header.jsp" %>
<!-- Conteúdo Principal -->
<div class="content">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title text-center">Devolver Livros</h5>
            <form action="devolver" method="post">
                <div class="form-group">
                    <label for="emp">Selecione o empréstimo a devolver:</label>
                    <select name="emp" id="emp" class="form-control">
                        <%
                            List<Emprestimo> emps = new EmprestimoDAO().selectPendentes();
                            for (Emprestimo e : emps) {
                                String detalhes = e.getAluno().getNome()+": "+e.getItems().size()+" livro(s) para "+ new SimpleDateFormat("dd/MM/yyyy").format(e.getDataPrevista());
                        %>
                        <option value="<%=e.getId()%>"><%=detalhes%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="datadev">Data devolução:</label>
                    <input type="date" name="datadev" id="datadev" class="form-control" required value="<%=LocalDate.now().format(DateTimeFormatter.ISO_DATE)%>">
                </div>

                <button type="submit" class="btn btn-primary">Confirmar</button>
            </form>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
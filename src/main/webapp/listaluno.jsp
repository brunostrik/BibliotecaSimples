<%@ page import="java.util.List" %>
<%@ page import="model.Aluno" %>
<%@ page import="dao.AlunoDAO" %>
<%@ page pageEncoding="utf-8" %>
<%@ include file="header.jsp" %>
<!-- Conteúdo Principal -->
<div class="content">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title text-center">Alunos</h5>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Matrícula</th>
                    <th scope="col">Nome</th>
                </tr>
                </thead>
                <%
                    List<Aluno> alunos = new AlunoDAO().selectAll(Aluno.class);
                    for (Aluno a : alunos) {
                %>

                <tbody>
                <tr>
                    <td><%=a.getMatricula()%>
                    </td>
                    <td><%=a.getNome()%>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>

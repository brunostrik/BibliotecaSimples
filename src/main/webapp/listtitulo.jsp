<%@ page import="java.util.List" %>
<%@ page import="model.Titulo" %>
<%@ page import="dao.TituloDAO" %>
<%@ page import="model.Exemplar" %>
<%@ page pageEncoding="utf-8" %>
<%@ include file="header.jsp" %>
<!-- Conteúdo Principal -->
<style>
    .accordion-toggle:after {
        content: '\002B'; /* Plus sign */
        font-size: 20px;
        float: right;
        color: #007BFF; /* Bootstrap primary color */
    }

    .accordion-toggle.collapsed:after {
        content: '\2212'; /* Minus sign */
    }
</style>
<div class="content">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title text-center">Títulos e Exemplares</h5>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Título</th>
                    <th scope="col">Autor</th>
                    <th scope="col">Área</th>
                    <th scope="col">Exemplares</th>
                </tr>
                </thead>
                <%
                    List<Titulo> titulos = new TituloDAO().selectAll(Titulo.class);
                    for (Titulo t : titulos) {
                %>

                <tbody>
                <tr data-toggle="collapse" data-target="#livro<%=t.getId()%>" class="accordion-toggle">
                    <td><%=t.getTitulo()%>
                    </td>
                    <td><%=t.getAutor().getNome() + " " + t.getAutor().getSobrenome()%>
                    </td>
                    <td><%=t.getArea().getNome()%>
                    </td>
                    <td>
                        <div class="collapse" id="livro<%=t.getId()%>">
                            <ul class="list-group">
                                <%
                                    List<Exemplar> exemplares = t.getExemplares();
                                    for (Exemplar e : exemplares) {
                                %>
                                <li class="list-group-item">Código: <%=e.getId()%>,
                                    Tipo: <%=e.isExemplarBiblioteca() ? "Acervo" : "Emprestável"%>
                                </li>
                                <%
                                    }
                                %>
                            </ul>
                        </div>
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

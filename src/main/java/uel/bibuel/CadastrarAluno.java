package uel.bibuel;

import dao.AlunoDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluno;

import java.io.IOException;

@WebServlet(name = "CadastrarAluno", value = "/cadastrar-aluno")
public class CadastrarAluno extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //obter valores dos parametros, montar o objeto e salvar
        Aluno a = new Aluno();
        a.setNome(request.getParameter("nome"));
        new AlunoDAO().persist(a);
        response.sendRedirect("listaluno.jsp");
    }
}

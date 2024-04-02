package uel.bibuel;

import java.io.*;

import dao.AlunoDAO;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Aluno;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Aluno a = new Aluno();
        a.setMatricula(123456);
        a.setNome("Pedrinho");
        AlunoDAO dao = new AlunoDAO();
        dao.persist(a);
        out.println("<html><body>");
        out.println("<h1>Criei</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
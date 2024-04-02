package uel.bibuel;

import dao.AlunoDAO;
import dao.AreaDAO;
import dao.AutorDAO;
import dao.TituloDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluno;
import model.Area;
import model.Autor;
import model.Titulo;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CadastrarTitulo", value = "/cadastrar-titulo")
public class CadastrarTitulo extends HttpServlet {
    public void init() {
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //obter valores dos parametros, montar o objeto e salvar
        Titulo t = new Titulo();
        t.setTitulo(request.getParameter("titulo"));
        t.setPrazo(Integer.parseInt(request.getParameter("prazo")));
        t.setArea(new AreaDAO().selectOne(Area.class, Integer.parseInt(request.getParameter("area"))));
        t.setAutor(new AutorDAO().selectOne(Autor.class, Integer.parseInt(request.getParameter("autor"))));
        new TituloDAO().persist(t);
        response.sendRedirect("listtitulo.jsp");
    }
    public void destroy(){
    }
}

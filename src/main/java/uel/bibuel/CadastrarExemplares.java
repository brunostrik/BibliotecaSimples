package uel.bibuel;

import dao.TituloDAO;
import dao.ExemplarDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Area;
import model.Autor;
import model.Titulo;
import model.Exemplar;

import java.io.IOException;

@WebServlet(name = "CadastrarExemplares", value = "/cadastrar-exemplares")
public class CadastrarExemplares extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //obter valores dos parametros, montar o objeto e salvar
        int qtdBib = Integer.parseInt(request.getParameter("acervo"));
        int qtdEmp = Integer.parseInt(request.getParameter("emprest"));
        Titulo t = new TituloDAO().selectOne(Titulo.class, Integer.parseInt(request.getParameter("titulo")));
        new ExemplarDAO().cadastrarVarios(t, qtdBib, qtdEmp);
        response.sendRedirect("listtitulo.jsp");
    }
}

package uel.bibuel;

import dao.EmprestimoDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Emprestimo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

@WebServlet(name = "Devolver", value = "/devolver")
public class Devolver extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //obter valores dos parametros, montar o objeto e salvar
        Emprestimo e = new EmprestimoDAO().selectOne(Emprestimo.class, Integer.parseInt(request.getParameter("emp")));
        try {
            e.setDataDevolucao(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("datadev")));
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }

        new EmprestimoDAO().merge(e);
        response.sendRedirect("index.jsp");
    }
}

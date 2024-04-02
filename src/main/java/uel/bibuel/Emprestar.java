package uel.bibuel;

import dao.AlunoDAO;
import dao.EmprestimoDAO;
import dao.ExemplarDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluno;
import model.Emprestimo;
import model.Exemplar;
import model.Item;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

@WebServlet(name = "Emprestar", value = "/emprestar")
public class Emprestar extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //obter valores dos parametros, montar o objeto e salvar
        Emprestimo e = new Emprestimo();
        Aluno a = new AlunoDAO().selectOne(Aluno.class, Integer.parseInt(request.getParameter("aluno")));
        e.setAluno(a);
        try {
            e.setDataEmprestimo(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataemp")));
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        //carrega os itens
        String[] exemplaresList = request.getParameter("items").split(",");
        for (String exemp : exemplaresList) {
            exemp = exemp.trim();
            Item i = new Item();
            i.setEmprestimo(e); //emprestimo
            Exemplar exemplar = new ExemplarDAO().selectOne(Exemplar.class, Integer.parseInt(exemp));
            if(exemplar.isExemplarBiblioteca()){
                throw new RuntimeException("Não é permitido emprestar exemplar de biblioteca!");
            }
            i.setExemplar(exemplar); //exemplar
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, exemplar.getTitulo().getPrazo());
            i.setDataDevolucao(cal.getTime()); //devolucao
            if (e.getItems() == null) e.setItems(new ArrayList<Item>());
            e.getItems().add(i);
        }
        //calcula a data de devolucao prevista
        //pega a maior
        Date maior = new GregorianCalendar(1900, Calendar.JANUARY, 1).getTime(); //começa em 1900
        for (Item i : e.getItems()) {
            if (maior.compareTo(i.getDataDevolucao()) < 0) {
                maior = i.getDataDevolucao();
            }
        }
        if (exemplaresList.length < 3) {
            //define que é a maior e boa
            e.setDataPrevista(maior);
        } else {
            //add +2 dias para cada livro apos o 2o.
            int qtdAdicionar = (exemplaresList.length - 2) * 2;
            Calendar cal = Calendar.getInstance();
            cal.setTime(maior);
            cal.add(Calendar.DATE, qtdAdicionar);
            e.setDataPrevista(cal.getTime());
        }
        new EmprestimoDAO().persist(e);
        response.sendRedirect("devlivro.jsp");
    }
}

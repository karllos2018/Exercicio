import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListaProdutos", urlPatterns = {"/listaProdutos"})
public class ListaProdutos extends HttpServlet {

    List<Produto> listaProdutos;

    public ListaProdutos() {
        listaProdutos = new ArrayList<>();
        var p1 = new Produto(1,"caneta","azul",1.0);
        var p2 = new Produto(2,"caderno","20 materias",10.0);
        var p3 = new Produto(3,"borracha","duas cores",2.0);
        var p4 = new Produto(4,"mesa","madeira",150.0);
        var p5 = new Produto(5,"computador","desktop",1000.0);

        listaProdutos.add(p1);
        listaProdutos.add(p2);
        listaProdutos.add(p3);
        listaProdutos.add(p4);
        listaProdutos.add(p5);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var out= response.getWriter();
        response.setContentType("text/html");
        out.println("<html>");
        out.println("<body>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th> id </th>");
        out.println("<th> nome </th>");
        out.println("<th> descriçao </th>");
        out.println("<th> preco </th>");
        out.println("</tr>");
        for (var i : listaProdutos
             ) {
            out.println("<tr>");
            out.println("<td>" + i.getId() + "</td>");
            out.println("<td>" + i.getNome() + "</td>");
            out.println("<td>" + i.getDescricao() + "</td>");
            out.println("<td>" + i.getPreco() + "</td>");
            out.println("<td> <a href='/Exercicio2109_war_exploded/adicionaCarrinho?id=" + i.getId() + "'> Add </a> </td>");
            out.println("</tr>");

        }
        out.println("</table>");
        out.println("</body>");
        out.println("<html>");
    }
}

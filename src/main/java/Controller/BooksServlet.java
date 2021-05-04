package Controller;

import Model.Books;
import Model.User;
import Service.BooksService;
import Service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BooksServlet", value = "/BooksServlet")
public class BooksServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("page");

        // Redirects to register.jsp
        if (action.equalsIgnoreCase("newBooks")) {
            RequestDispatcher rd = request.getRequestDispatcher("B-Pages/register.jsp");
            rd.forward(request, response);
        }

        if (action.equalsIgnoreCase(("register"))) {

            Books books = new Books();

            //String should be same as in name attribute of register.jsp
            books.setBooksname(request.getParameter("booksname"));
            books.setAuthor(request.getParameter("author"));
            books.setGenre((request.getParameter("genre")));
            books.setRackno(request.getParameter("rackno"));

            new BooksService().insertBooks(books);

            //moves to books list page after registration
            RequestDispatcher rd = request.getRequestDispatcher("B-Pages/list_books.jsp");
            rd.forward(request, response);
        }
        // Delete
        if (action.equalsIgnoreCase("deleteBook")) {

            int id = Integer.parseInt(request.getParameter("id"));
            new BooksService().deleteBook(id);

            List<Books> booksList = new BooksService().getBooksList();
            request.setAttribute("booksList", booksList);

            // RequestDispatcher rd =request.getRequestDispatcher("Pages/list_user.jsp");
        }

        //Edit

        if (action.equalsIgnoreCase(("editBook"))) {

            Books books = new Books();
            int id = Integer.parseInt(request.getParameter("id"));
            books.setBooksname(request.getParameter("booksname"));
            books.setAuthor(request.getParameter("author"));
            books.setGenre(request.getParameter("genre"));
            books.setRackno(request.getParameter("rackno"));

            try {
                new BooksService().editBook(id, books);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            List<Books> booksList = new BooksService().getBooksList();
            request.setAttribute("booksList", booksList);

            RequestDispatcher rd = request.getRequestDispatcher("B-Pages/list_books");
            rd.forward(request, response);
        }

        if (action.equalsIgnoreCase("listBooks")) {

            Books books = new Books();
            List<Books> booksList = new BooksService().getBooksList();
            request.setAttribute("booksList", booksList);
            request.setAttribute("books", books);
            RequestDispatcher rd = request.getRequestDispatcher("B-Pages/list_books.jsp");
            rd.forward(request, response);
        }

        if (action.equalsIgnoreCase("bookEdit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);

            User books = new UserService().getRow(id);
            request.setAttribute("id", id);
            request.setAttribute("books", books);

            RequestDispatcher rd = request.getRequestDispatcher("B-Pages/update_books.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
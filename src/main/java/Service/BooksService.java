package Service;

import DBConnection.DBConnection;
import Model.Books;
import Model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksService {

    //returns Bookslist

    public List<Books> getBooksList(){

        Books books = new Books();

        ArrayList<Books> getBooksList = new ArrayList<>();
        String query = "Select * from books";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try{
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFullname(rs.getString("booksname"));
                user.setAddress(rs.getString("author"));
                user.setPhonenumber(rs.getString("genre"));
                user.setUsername(rs.getString("rackno"));

                getBooksList.add(books);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return getBooksList();
    }


    //Insert Books
    public void insertBooks(Books books) {
        String query = "insert into books (booksname, author, genre, rackno)" + "values(?,?,?,?)";

        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, books.getBooksname());
            pstm.setString(2, books.getAuthor());
            pstm.setString(3, books.getGenre());
            pstm.setString(4, books.getRackno());

            pstm.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Delete Books
    public void deleteBook(int id) {
        String query = "delete from books where id = ?";

        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1,id);

            pstm.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Update book
    public void editBook(int id, Books books) throws SQLException{
        String query = "update books set booksname = ?, author = ?, genre = ?, rackno = ?" + "where id = ?";

        PreparedStatement pstm = new DBConnection().getStatement(query);

        pstm.setString(1, books.getBooksname());
        pstm.setString(2, books.getAuthor());
        pstm.setString(3, books.getGenre());
        pstm.setString(4, books.getRackno());
        pstm.setInt(5,books.getId());

        pstm.execute();
    }

    public Books getRow(int id){
        Books books = new Books();
        String query = "select * from books where id = ?";
        PreparedStatement pstm = new DBConnection().getStatement(query);

        try{
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()){
                books.setId(rs.getInt("id"));
                books.setBooksname(rs.getString("booksname"));
                books.setAuthor(rs.getString("author"));
                books.setGenre(rs.getString("genre"));
                books.setRackno(rs.getString("rackno"));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return books;
    }
}





package Service;

import DBConnection.DBConnection;
import Model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    //Return single user
    public User getUser(String username, String password) {
        User user = null;
        String query = "Select * from user where username = ? and password = ?";

        PreparedStatement pstm = new DBConnection().getStatement(query);
        try{
            pstm.setString(1, username);
            pstm.setString(2,password);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()){
                user = new User();

                user.setId(rs.getInt("id"));
                user.setFullname(rs.getString("fullname"));
                user.setAddress(rs.getString("address"));
                user.setPhonenumber(rs.getString("phonenumber"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    //returns Userlist

    public List<User> getUserList(){

        ArrayList<User> getUserList = new ArrayList<>();
        String query = "Select * from user";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try{
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFullname(rs.getString("fullname"));
                user.setAddress(rs.getString("address"));
                user.setPhonenumber(rs.getString("phonenumber"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));

                getUserList.add(user);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return getUserList;
    }


    //Insert User
    public void insertUser(User user) {
        String query = "insert into user (username, fullname , password, phonenumber, address)" + "values(?,?,?,?,?";

        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, user.getFullname());
            pstm.setString(2, user.getAddress());
            pstm.setString(3,user.getPhonenumber());
            pstm.setString(4, user.getUsername());
            pstm.setString(5,user.getPassword());

            pstm.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Delete User
    public void deleteUser(int id) {
        String query = "delete from user where id = ?";

        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1,id);

            pstm.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Update User
    public void editUser(int id, User user) throws SQLException{
        String query = "update user set fullname = ?, address = ?, phonenumber = ?, username = ?, password = ? " + "where id = ?";

        PreparedStatement pstm = new DBConnection().getStatement(query);

        pstm.setString(1,user.getFullname());
        pstm.setString(2,user.getAddress());
        pstm.setString(3,user.getPhonenumber());
        pstm.setString(4, user.getUsername());
        pstm.setString(5,user.getPassword());
        pstm.setInt(6,user.getId());

        pstm.execute();
    }

    public User getRow(int id){
        User user = new User();
        String query = "select * from user where id = ?";
        PreparedStatement pstm = new DBConnection().getStatement(query);

        try{
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()){
                user.setId(rs.getInt("id"));
                user.setFullname(rs.getString("fullname"));
                user.setAddress(rs.getString("address"));
                user.setPhonenumber(rs.getString("phonenumber"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return user;
    }
}

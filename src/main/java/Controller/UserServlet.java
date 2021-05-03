package Controller;

import Model.User;
import Service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("page");

        //Login
        if (action.equalsIgnoreCase("Login")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = new UserService().getUser(username, password);

            if (user != null){

                HttpSession session = request.getSession();

                session.setAttribute("uid", user.getId());
                session.setAttribute("username",user.getUsername());
                session.setAttribute("user",user);

                request.setAttribute("msg", "Login Success");

                RequestDispatcher rd = request.getRequestDispatcher("Pages/dashboard.jsp");
                rd.forward(request,response);
            }else {
                request.setAttribute("msg","Invalid password or username");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request,response);
            }
        }

        // Redirects to register.jspt
        if (action.equalsIgnoreCase("newUsers")){
            RequestDispatcher rd = request.getRequestDispatcher("Pages/register.jsp");
            rd.forward(request,response);
        }

        if (action.equalsIgnoreCase(("register"))) {

            User user = new User();

            //String should be same as in name attribute of register.jsp
            user.setFullname(request.getParameter("fullname"));
            user.setAddress(request.getParameter("address"));

            //Check
            user.setPhonenumber((request.getParameter("phonenumber")));
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));

            new UserService().insertUser(user);

            //moves to login page after registration
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }

        //For index
        if (action.equalsIgnoreCase("index")){

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }

        //Logout
        if (action.equalsIgnoreCase("logout")){

            HttpSession session = request.getSession(false);
            session.invalidate();

            // Message shown in login page
            request.setAttribute("msg", "Logout Success");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }

        // Delete
        if (action.equalsIgnoreCase("deleteUser")) {

            int id = Integer.parseInt(request.getParameter("id"));
            new UserService().deleteUser(id);

            List<User> userList = new UserService().getUserList();
            request.setAttribute("userList", userList);

           // RequestDispatcher rd =request.getRequestDispatcher("Pages/list_user.jsp");
        }

        //Edit

        if (action.equalsIgnoreCase(("editUser"))){

            User user = new User();
            int id = Integer.parseInt(request.getParameter("id"));
            user.setFullname(request.getParameter("fullname"));
            user.setAddress(request.getParameter("address"));
            user.setPhonenumber(request.getParameter("phonenumber"));
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));

            try{
                new UserService().editUser(id, user);
            }
            catch (SQLException e){
                e.printStackTrace();
            }

            List<User> userList = new UserService().getUserList();
            request.setAttribute("userList",userList);

            RequestDispatcher rd = request.getRequestDispatcher("Pages/list_user");
            rd.forward(request,response);
        }

        if (action.equalsIgnoreCase("listUser")){

            User user = new User();
            List<User> userList = new UserService().getUserList();
            request.setAttribute("userList", userList);
            request.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("Pages/list_user.jsp");
            rd.forward(request,response);
        }

        if (action.equalsIgnoreCase("userEdit")){
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);

            User user = new UserService().getRow(id);
            request.setAttribute("id",id);
            request.setAttribute("user",user);

            RequestDispatcher rd = request.getRequestDispatcher("Pages/update_user.jsp");
            rd.forward(request,response);
        }

        if (action.equalsIgnoreCase("home")){

            RequestDispatcher rd = request.getRequestDispatcher("pages/dashboard.jsp");
            rd.forward(request,response);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

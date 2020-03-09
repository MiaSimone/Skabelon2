package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Oversigt extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ClassNotFoundException {
        UserMapper u = new UserMapper();
        ArrayList<User> tmp = u.customerList();

        request.setAttribute("oversigt",tmp);
        //HttpSession session = request.getSession();
        //session.setAttribute("oversigt", tmp);
        //session.setAttribute("antal", antal);

        return "oversigt";
    }
}

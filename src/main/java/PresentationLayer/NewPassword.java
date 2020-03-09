package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class NewPassword extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ClassNotFoundException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        String newPassword = request.getParameter( "newPassword" );
        UserMapper.updatePassword(email,password,newPassword);
        request.setAttribute("update","Password Updated!");

        return "employeepage";
    }
}

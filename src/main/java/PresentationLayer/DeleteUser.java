package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class DeleteUser extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ClassNotFoundException {
        String email1 = request.getParameter("email1");
        String email2 = request.getParameter("email2");
        if (email1.equals(email2)){
            UserMapper.deleteUser(email1);
            request.setAttribute("message","User deleted");
            return "employeepage";
        } else {
            throw new LoginSampleException("De to emails var ikke ens, prøv igen.");
        }


    }
}

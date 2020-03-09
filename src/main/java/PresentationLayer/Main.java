package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserMapper u = new UserMapper();
        ArrayList<User> tmp = u.customerList();

        System.out.println(Arrays.toString(tmp.toArray()));
    }
}

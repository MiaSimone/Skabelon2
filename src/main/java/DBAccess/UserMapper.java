package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM Users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "id" );
                User user = new User( email, password, role );
                user.setId( id );
                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    public static ArrayList<User> customerList() throws SQLException, ClassNotFoundException{
        ArrayList<User> returnList = new ArrayList<>();
        Connection myConnector = Connector.connection();

        // TODO: hent fra databasen
        Statement statement = null;
        ResultSet resultSet = null;

        String query = "SELECT * FROM useradmin.users WHERE role = 'customer'";
        statement = myConnector.createStatement();
        // ResultSet sender dataen over i programmet
        resultSet = statement.executeQuery(query);

        //executeUpdate
        while (resultSet.next()){
            String email = resultSet.getString("email");
            String pas = resultSet.getString("password");
            String role = resultSet.getString("role");
            User tmpUser = new User(email, pas, role);
            returnList.add(tmpUser);
        }

        // Lukker efter mig:
        resultSet.close();
        statement.close();


        return returnList;
    }


    public static void createEmployee( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static void deleteUser(String email) {
        Connection con = null;

        try {
            con = Connector.connection();
            String sql = "delete from users where email ='"+email+"'";
            System.out.println("SQL:" + sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updatePassword(String email, String pass, String newPass) {
        Connection con = null;

        try {
            con = Connector.connection();
            String checkUser = "select * from users where email ='"+email+"'";
            System.out.println("Test 1" + checkUser);
            String deletePass = "update users set password='"+newPass+"' where email ='"+email+"'";
            System.out.println(deletePass);
            PreparedStatement ps = con.prepareStatement(checkUser);
            System.out.println("1");
            ResultSet resultSet = ps.executeQuery();
            System.out.println("2");
            String correctPass = "";
            System.out.println("3");
            while (resultSet.next()){
                System.out.println("4");
                correctPass = resultSet.getString("password");
            }
            System.out.println("5");
            if (pass.equals(correctPass)){
                System.out.println("6");
                ps = con.prepareStatement(deletePass);
                System.out.println("7");
                ps.executeUpdate();
                System.out.println("Password for user with email: " + email + " changed.");
                System.out.println("8");
                ps.close();
                con.close();
            } else {
                System.out.println("Denne bruger findes ikke.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

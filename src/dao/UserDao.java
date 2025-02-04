
package dao;
import java.sql.*;
import model.User;

/**
 *
 * @author hg_ofthecity
 */
public class UserDao {
    // global variables
    private String db_url = "jdbc:mysql://localhost:3306/Hotel_management_system_db";
    private String db_username = "root";
    private String db_password = "mugishathi";
    
    public UserDao() {}
    
    // Register user
    public Integer RegisterUser(User userObj) {
        try {
            // register driver
            // - not necessary
            // create connection
            Connection conn = DriverManager.getConnection(db_url, db_username, db_password);
            // prepared statement
            PreparedStatement pst =
                    conn.prepareStatement("INSERT INTO user (user_id, fullname, email, password) VALUES(?,?,?,?)");
            
            // setup parameters
            pst.setString(1, userObj.getUserId());
            pst.setString(2, userObj.getFullName());
            pst.setString(3, userObj.getUserEmail());
            pst.setString(4, userObj.getUserPassword());
            // execute query
            int rowsAffected = pst.executeUpdate();
            // close connection
            conn.close();
            return rowsAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    // Update user
    public Integer updateUser(User userObj) {
        try {
            // register driver
            // - not necessary
            // create connection
            Connection conn = DriverManager.getConnection(db_url, db_username, db_password);
            // prepared statement
            PreparedStatement pst =
                    conn.prepareStatement("UPDATE user SET fullname=?, email=?, password=? WHERE user_id=?");
            
            // setup parameters
            pst.setString(1, userObj.getFullName());
            pst.setString(2, userObj.getUserEmail());
            pst.setString(3, userObj.getUserPassword());
            pst.setString(4, userObj.getUserId());
            // execute query
            int rowsAffected = pst.executeUpdate();
            // close connection
            conn.close();
            return rowsAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    // retrieve users
    public ResultSet displayUsers(User userObj) {
        try {
            // register driver
            // -
            // create connection
            Connection conn = DriverManager.getConnection(db_url, db_username, db_password);
            // prepared statement
            PreparedStatement pst =
                    conn.prepareStatement("SELECT user_id, fullname, email, password, userLevel FROM user");
            // execute query
            ResultSet result = pst.executeQuery();
            // close connection
            // conn.close() -- the connection close itself when using prepared statement
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    // search user
    public ResultSet searchUser(User userObj, String searchKey) {
        try {
            // register driver
            // -
            // create connection
            Connection conn = DriverManager.getConnection(db_url, db_username, db_password);
            // prepared statement
            PreparedStatement pst =
                    conn.prepareStatement(
            "SELECT user_id, fullname, email, password, userLevel FROM user WHERE user_id LIKE '%"+searchKey+"%' OR fullname LIKE '%"+searchKey+"%'");
            // execute query
            ResultSet result = pst.executeQuery();
            // close connection
            // conn.close() -- the connection close itself when using prepared statement
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    // delete user
    public Integer deleteUser(User userObj) {
        try {
            // register driver
            // -
            // create connection
            Connection conn = DriverManager.getConnection(db_url, db_username, db_password);
            // prepared statement
            PreparedStatement pst =
                    conn.prepareStatement("DELETE FROM user WHERE user_id=?");
            pst.setString(1, userObj.getUserId());
            // execute query
            int rowsAffected = pst.executeUpdate();
            // close connection
            conn.close();
            return rowsAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    // Login User
    public ResultSet LoginUser(User userObj) {
        try {
            // register driver
            // -
            // create connection
            Connection conn = DriverManager.getConnection(db_url, db_username, db_password);
            // prepared statement
            PreparedStatement pst =
                    conn.prepareStatement("SELECT user_id, email, password, userLevel FROM user WHERE email=?");
            pst.setString(1, userObj.getUserEmail());
            // execute query
            ResultSet result = pst.executeQuery();
            // close connection
            // conn.close() -- the connection close itself when using prepared statement
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

package dao;

import controller.User;
import database.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class AccountDAO implements DAOInterface<User> {
    private Connection conn = null;
    private Statement st;

    public AccountDAO() {
        try {
            conn = JDBCUtil.getConnection();
            st = conn.createStatement();
        } catch (Exception e) {
        }

    }

    public static AccountDAO getInstance() {
        return new AccountDAO();
    }

    @Override
    public int insert(User obj) {
        int check = 0; //  check = 0 => insert false, check > 1 => insert succsec
        String sql = "INSERT INTO lythanhlong.account value('" + obj.getAccount() + "','" + obj.getPassword() + "')";
        try {
//            System.out.println(sql);
            check = st.executeUpdate(sql);
            System.out.println("Insert successfully => "+obj.toString());
            // close connection
            JDBCUtil.closeConnection();
        } catch (SQLException e) {
            System.out.println("Insert False"+obj.toString());
            JDBCUtil.closeConnection();
            throw new RuntimeException(e);
        }
        return check;
    }

    @Override
    public int update(User obj) {
        int check = 0; //  check = 0 => insert false, check > 1 => insert succsec
        String sql = "UPDATE lythanhlong.account SET password='" + obj.getPassword() + "' WHERE user_name='"+obj.getAccount()+"'";
        try {
//            System.out.println(sql);
            check = st.executeUpdate(sql);
            System.out.println("Update successfully => "+obj.toString());
            // close connection
            JDBCUtil.closeConnection();
        } catch (SQLException e) {
            System.out.println("Update False => "+obj.toString());
            JDBCUtil.closeConnection();
            throw new RuntimeException(e);
        }
        return check;
    }

    @Override
    public int delete(User obj) {
        int check = 0; //  check = 0 => insert false, check > 1 => insert succsec
        String sql = "DELETE FROM lythanhlong.account WHERE user_name='" + obj.getAccount() + "'";
        try {
            System.out.println(sql);
            check = st.executeUpdate(sql);
            System.out.println("Delete successfully => "+obj.toString());
            JDBCUtil.closeConnection();
        } catch (SQLException e) {
            System.out.println("Delete false => "+obj.toString());
            JDBCUtil.closeConnection();
            throw new RuntimeException(e);
        }
        return check;
    }

    @Override
    public ArrayList<User> selectAll() {
        ArrayList<User> listUser = new ArrayList<User>();
        String sql = "SELECT * FROM lythanhlong.account";
        try {
//            System.out.println(sql);
            ResultSet run = st.executeQuery(sql);
            String account = "";
            String password = "";
            while (run.next()){
                account = run.getNString("user_name");
                password = run.getNString("password");
                listUser.add(new User(account,password));
            }
            // close database
            JDBCUtil.closeConnection();
        } catch (SQLException e) {
            System.out.println("SELECT FALSE !");
            throw new RuntimeException(e);
        }
        return listUser;
    }

    @Override
    public ArrayList<User> selectById(String userId) {
        ArrayList<User> listUser = new ArrayList<User>();
        String sql = "SELECT * FROM lythanhlong.account WHERE user_name='"+userId+"'";
        try {
//            System.out.println(sql);
            ResultSet run = st.executeQuery(sql);
            String account = "";
            String password = "";
            while (run.next()){
                account = run.getNString("user_name");
                password = run.getNString("password");
                listUser.add(new User(account,password));
            }
            // close database
            JDBCUtil.closeConnection();
        } catch (SQLException e) {
            System.out.println("SELECT FALSE !");
            throw new RuntimeException(e);
        }
        return listUser;
    }
}

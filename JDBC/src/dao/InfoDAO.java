package dao;

import controller.Info;
import database.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InfoDAO implements DAOInterface<Info> {
    // create connection
    private Connection conn;
    // using sql => Statement
    private Statement st;

    public InfoDAO() {
        try {
            conn = JDBCUtil.getConnection();
            // using sql => Statement
            st = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static InfoDAO getInstance() {
        return new InfoDAO();
    }

    @Override
    public int insert(Info info) {
        int check = 0;// if function return 0 => insert false, return 1 => insert success
        try {
            // "INSERT INTO lythanhlong.info (ID,FIRST_NAME,LAST_NAME,AGE) VALUES ('021107', 'Vũ Như ', 'Cẩn', '20 ')";
            String sql = "INSERT INTO lythanhlong.info (info_id,first_name,last_name,age,email,sdt) VALUES('" +
                    info.getInfo_id() + "','" +
                    info.getFirst_name() + "','" +
                    info.getLast_name() + "'," +
                    info.getAge() + ",'" +
                    info.getEmail() + "','" +
                    info.getPhone_Number() + "')";
//            System.out.println(sql);
            // run sql insert
//            conn = JDBCUtil.getConnection();
            // using sql => Statement
//            st = conn.createStatement();

            check = st.executeUpdate(sql);
//            System.out.println(check);
            // close connection
            JDBCUtil.closeConnection();
        } catch (SQLException e) {
            System.out.println("loi");
            throw new RuntimeException(e);
        }
        return check;
    }

    @Override
    public int update(Info info) {
        int check = 0;
        try {
            String sql = "UPDATE lythanhlong.info SET " +
                    "first_name='" + info.getFirst_name() + "'," +
                    "last_name='" + info.getLast_name() + "'," +
                    "age=" + info.getAge() + "," +
                    "email='" + info.getEmail() + "'," +
                    "sdt='" + info.getPhone_Number() + "' " +
                    "WHERE info_id='" + info.getInfo_id() + "'";
            System.out.println(sql);
            check = st.executeUpdate(sql);
            JDBCUtil.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return check;
    }

    @Override
    public int delete(Info info) {
        int check = 0;
        try {
            String sql = "DELETE FROM lythanhlong.info where info_id='" + info.getInfo_id() + "'";
            System.out.println(sql);
            check = st.executeUpdate(sql);
            // Close connection
            JDBCUtil.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return check;
    }

    @Override
    public ArrayList<Info> selectAll() {
        ArrayList<Info> listInfo = new ArrayList<Info>();
        try {
            String sql = "SELECT * FROM lythanhlong.info";
            // tra ve dong du lieu
            ResultSet result = st.executeQuery(sql);
            // dùng vòng lặp lấy tưng dữ liệu ra
            while (result.next()) {
                // tham số chuyền vào là số cột hoặc tên cột
                String id = result.getNString("info_id");
                String first_name = result.getNString("first_name");
                String last_name = result.getNString("last_name");
                int age = result.getInt("age");
                String email = result.getNString("email");
                String phone_number = result.getNString("sdt");
                // thêm vô arraylist
                listInfo.add(new Info(id, first_name, last_name, age, email, phone_number));
            }
            // đóng kết nối
            JDBCUtil.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listInfo;
    }

    @Override
    public Info selectById(String id) {
        Info out = null;
        try {
            String sql = "SELECT * FROM lythanhlong.info WHERE info_id='"+id+"'";
            // tra ve dong du lieu
            ResultSet result = st.executeQuery(sql);
            // dùng vòng lặp lấy tưng dữ liệu ra
            while (result.next()) {
                // tham số chuyền vào là số cột hoặc tên cột
                String info_id = result.getNString("info_id");
                String first_name = result.getNString("first_name");
                String last_name = result.getNString("last_name");
                int age = result.getInt("age");
                String email = result.getNString("email");
                String phone_number = result.getNString("sdt");
                // tao doi tuong
                out = new Info(info_id, first_name, last_name, age, email, phone_number);
            }
            // đóng kết nối
            JDBCUtil.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    @Override
    public ArrayList<Info> selectByCondittion(String condition) {
        return null;
    }
}

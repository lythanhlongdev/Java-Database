package database;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    private static Connection c = null;

    // hàm kết nối với hệ quản trị cơ sở dũ liệu
    public static Connection getConnection() {
        try {
            // Đăng ký sử dụng database
            DriverManager.registerDriver(new Driver());
            // các thông số ket noi
            String url = "jdbc:mySQL://Localhost:3306/lythanhlong";
            String name = "root";
            String password = "111201";

            // tao ket noi
            c = DriverManager.getConnection(url, name, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // trả về một chuôĩ kết nối

        return c;
    }

    // DatabaseMetaData xuất mọi thông tin
    public static void printInfo(){
        try {
            if(c!= null){
                DatabaseMetaData metaData = c.getMetaData();
                System.out.println(metaData.getConnection());
                System.out.println(metaData.getDatabaseProductName());
                System.out.println(metaData.getDatabaseProductVersion());
            }
        }catch (Exception e){

        }
    }
    /*
        Mở kết nối phải đóng kết nối.
        hàm đóng kết nối
     */
    public static void closeConnection() {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {

        }
    }
}

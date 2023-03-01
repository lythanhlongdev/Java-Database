package test;

import database.JDBCUtil;

import java.sql.Connection;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        // kiem tra ket noi, lay dia chi ket noi
        Connection cn = JDBCUtil.getConnection();
//        //
//        try{
//            String id = "021106";
//            String name = "Vũ Như Cẩn";
//            int age = 20;
//            Statement st = cn.createStatement();
//            String  x = "INSERT INTO lythanhlong.info (ID,FIRST_NAME,LAST_NAME,AGE) VALUES ('021107', 'Vũ Như ', 'Cẩn', '20 ')";
//            int check = st.executeUpdate(x);
//            if (check > 0){
//                System.out.println("Thanh cong");
//            }else {
//                System.out.println("That bai");
//            }
//            JDBCUtil.closeConnection();
//        }catch (Exception e){
//            System.out.println("Loi");
//        }

    }
}

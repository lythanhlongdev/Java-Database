package test;

import controller.User;
import dao.AccountDAO;
import database.JDBCUtil;
import view.Manger;

import java.sql.Connection;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
/*************************************+*** INSERT ************************************************************/
//        User x = new User("lythanhlong", "123");
//        AccountDAO.getInstance().insert(x);
        // insert 1000 account
//        for (int i = 1; i <= 1000; ++i) {
//            AccountDAO.getInstance().insert(new User("user"+i,"123"));
//        }
/*************************************+*** DELETE ************************************************************/
        // delete 1000 account
//        for (int i = 1; i <= 1000; ++i) {
//            AccountDAO.getInstance().delete(new User("user"+i,"123"));
//        }

/*************************************+*** UPDATE ************************************************************/
//        AccountDAO.getInstance().update(new User("lythanhlong","123456"));

/*************************************+*** SELECT ALL ************************************************************/
//        ArrayList<User> listUser = AccountDAO.getInstance().selectAll();
//        listUser.forEach((n)-> System.out.println(n.toString()));
/*************************************+*** SELECT By Id ************************************************************/
//        ArrayList<User> listUser = AccountDAO.getInstance().selectById("lythanhlong");
//        listUser.forEach((n) -> System.out.println(n.toString()));

/******************* Test View controlle *******************/
        Manger.managerUser();
    }
}

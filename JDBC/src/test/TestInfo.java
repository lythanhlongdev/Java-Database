package test;

import controller.Info;
import dao.DAOInterface;
import dao.InfoDAO;

import java.util.ArrayList;

public class TestInfo {
    public static void main(String[] args) {
        // Test Insert() =>  pass
//        Info user = new Info("021106","Lý Thành","Long",21,"lythanhlongfmc@gmail.com","08666424xx");
//        InfoDAO.getInstance().insert(user);
        for (int i = 1; i < 1000; ++i){
            Info user = new Info("ID"+i,"Lý Thành","Long"+i,i,"lythanhlongfmc@gmail.com","08666424xx");
            InfoDAO.getInstance().insert(user);
        }

        // Test Delete () =>  pass
//        InfoDAO.getInstance().delete(new Info("021106","Lý Thành","Long",21,"lythanhlongfmc@gmail.com","08666424xx"));
//        for (int i = 1; i< 1000; ++i){
//            Info user = new Info("ID"+i,"Lý Thành","Long"+i,i,"lythanhlongfmc@gmail.com","08666424xx");
//            InfoDAO.getInstance().delete(user);
//        }

        // Test Update(), pass
//        InfoDAO.getInstance().update(new Info("021106","Vũ Như","Cẩn",20,"vannhucu@gmail.com","xxx-xxx-xxx"));

        // Test SelectALL(), pass
//        ArrayList<Info> ls = InfoDAO.getInstance().selectAll();
//        ls.forEach((n)-> System.out.println(n.toString()));

        // Test SelectById(), pass
//        Info xx = InfoDAO.getInstance().selectById("021105");
//        System.out.println(xx.toString());
    }
}

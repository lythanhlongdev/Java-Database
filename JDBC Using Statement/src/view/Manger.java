package view;

import controller.User;
import dao.AccountDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class Manger {
    public static  void managerUser(){
        int choose = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1.Insert");
            System.out.println("2.Update");
            System.out.println("3.Delete");
            System.out.println("4.Select All");
            System.out.println("5.Select By Id");
            System.out.println("0.Exit");
            System.out.print("You choose: ");
            choose = sc.nextInt();
            switch (choose){
                case 1:{
                    System.out.println("cls");
                    System.out.println("User name: ");
                    String userName = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Passwork: ");
                    String passwork = sc.nextLine();
                    AccountDAO.getInstance().insert(new User(userName,passwork));
                    break;
                }
                case 2:{
                    System.out.println("cls");
                    System.out.println("User name change: ");
                    String userName = sc.nextLine();
                    System.out.println("Passwork: ");
                    String passwork = sc.nextLine();
                    AccountDAO.getInstance().update(new User(userName,passwork));
                    break;
                }
                case 3:{
                    break;
                }
                case 4:{
                    System.out.println("cls");
                    ArrayList<User> list = AccountDAO.getInstance().selectAll();
                    list.forEach((n)-> System.out.println(n.toString()));
                    break;
                }
                case 5:{
                    System.out.println("Enter User name: ");
                    sc.nextLine();
                    String userName = sc.nextLine().trim();
                    ArrayList<User> list = AccountDAO.getInstance().selectById(userName);
                    list.forEach((n)-> System.out.println(n.toString()));
                    break;
                }
                case 0:{
                    break;
                }
                default:
                    System.out.println("Choose false !");
            }
        }while (choose != 0);
    }
}

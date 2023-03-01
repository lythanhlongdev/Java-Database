package dao;

import java.util.ArrayList;

public interface DAOInterface <T>{
    int insert(T obj);
    int update(T obj);
    int delete(T obj);
    ArrayList<T> selectAll();
    ArrayList<T> selectById(String userId);
}

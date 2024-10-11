package dao;

import java.util.List;

public interface IDao <T>{

    T getElement (int id);
    List<T> getAllElements();
    void insertElement(T Element);
    void updateElement(T Element);
    void deleteElement(int id);
}

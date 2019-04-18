package com.itheima.dao;
import com.itheima.po.Customer;

import java.util.List;

public interface Dao {
    int fCById(int id);
    String fCByName(String username);
    int  addC(Customer customer);
    int upC(Customer customer);
    int deC(int id);

}

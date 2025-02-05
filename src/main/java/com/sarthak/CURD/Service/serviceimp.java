package com.sarthak.CURD.Service;
import java.util.List;

import com.sarthak.CURD.Model.Employee;
public interface serviceimp {
   public List<Employee> getAllItems();
   public Employee getItemById(int id);
   public Employee createItem(Employee item);
    public Employee updateItem(int id, Employee itemDetails);
    public Employee deleteItem(int id);
}

package com.sarthak.CURD.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.sarthak.CURD.Model.Employee;
import com.sarthak.CURD.Repository.MyMongoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class service implements serviceimp {
    @Autowired
    private MyMongoRepository myMongoRepository;
    @Override
    public List<Employee> getAllItems() {
        return myMongoRepository.findAll();
    }

    @Override
    public Employee getItemById(int id) {
        return myMongoRepository.findById(id).orElse(null);
    }

    @Override
    public Employee createItem(Employee item) {
        return myMongoRepository.save(item);
    }

    @Override
    public Employee updateItem(int id, Employee itemDetails) {
       Employee item = myMongoRepository.findById(id).orElse(null);
        if (item != null) {
            item.setName(itemDetails.getName());
            item.setSalary(itemDetails.getSalary());
            return myMongoRepository.save(item);
        }
        return null;
    }

    @Override
    public Employee deleteItem(int id) {
        Employee item=myMongoRepository.findById(id).orElse(null);
        if(item!=null){
            myMongoRepository.deleteById(id);
            return item;
        }
        return null;
    }

}

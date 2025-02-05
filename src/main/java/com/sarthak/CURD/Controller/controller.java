package com.sarthak.CURD.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.sarthak.CURD.Service.service;
import com.sarthak.CURD.Model.Employee;
import java.util.List;

@RestController
@RequestMapping("/api")
public class controller {
    @Autowired
    private service myService;

    @GetMapping("/items")
    public List<Employee> getAllItems() {
        return myService.getAllItems();
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Employee> getItemById(@PathVariable int id) {
        Employee item = myService.getItemById(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/items")
    public Employee createItem(@RequestBody Employee item) {
        System.out.println("in post controller");
        return myService.createItem(item);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Employee> updateItem(@PathVariable int id, @RequestBody Employee itemDetails) {
        Employee updatedItem = myService.updateItem(id, itemDetails);
        if(updatedItem!=null)
            return new ResponseEntity<Employee>(updatedItem, HttpStatus.OK);
         else 
            return new ResponseEntity<Employee>(updatedItem, HttpStatus.NOT_FOUND);
        
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable int id) {
        Employee Deleteditem = myService.deleteItem(id);
        if (Deleteditem!=null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
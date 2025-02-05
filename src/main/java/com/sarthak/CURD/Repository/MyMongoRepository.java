package com.sarthak.CURD.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sarthak.CURD.Model.Employee;

@Repository
public interface MyMongoRepository extends MongoRepository<Employee, Integer> {

}

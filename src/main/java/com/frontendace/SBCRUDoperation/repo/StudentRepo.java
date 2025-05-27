package com.frontendace.SBCRUDoperation.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.frontendace.SBCRUDoperation.entities.StudentItem;

@Repository
public interface StudentRepo extends MongoRepository<StudentItem, String> {

}

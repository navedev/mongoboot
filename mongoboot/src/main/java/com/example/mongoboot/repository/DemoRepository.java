package com.example.mongoboot.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongoboot.domain.Details;

@Repository
public interface DemoRepository extends MongoRepository<Details, ObjectId> {

	List<Details> findByName(String name);

}

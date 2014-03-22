package main.java.be.protracker.repositories.mongo;

import main.java.be.protracker.model.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverRepository extends MongoRepository<Driver, String> {

}

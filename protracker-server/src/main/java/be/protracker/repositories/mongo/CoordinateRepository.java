package main.java.be.protracker.repositories.mongo;

import main.java.be.protracker.model.Coordinate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoordinateRepository extends MongoRepository<Coordinate, String> {

}

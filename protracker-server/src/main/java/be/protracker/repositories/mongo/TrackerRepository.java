package main.java.be.protracker.repositories.mongo;

import main.java.be.protracker.model.Tracker;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrackerRepository extends MongoRepository<Tracker, String> {

}

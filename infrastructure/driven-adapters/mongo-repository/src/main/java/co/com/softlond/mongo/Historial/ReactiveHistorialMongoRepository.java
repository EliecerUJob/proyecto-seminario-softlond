package co.com.softlond.mongo.Historial;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import co.com.softlond.mongo.Collections.HistorialCollection;

public interface ReactiveHistorialMongoRepository extends ReactiveMongoRepository<HistorialCollection, String>{
    
}

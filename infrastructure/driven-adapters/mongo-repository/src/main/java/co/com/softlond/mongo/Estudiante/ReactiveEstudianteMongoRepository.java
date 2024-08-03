package co.com.softlond.mongo.Estudiante;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import co.com.softlond.mongo.Collections.EstudianteCollections;

public interface ReactiveEstudianteMongoRepository extends ReactiveMongoRepository<EstudianteCollections, String>{
    
}

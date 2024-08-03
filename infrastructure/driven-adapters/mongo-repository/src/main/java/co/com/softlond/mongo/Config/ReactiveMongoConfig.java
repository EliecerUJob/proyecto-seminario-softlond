package co.com.softlond.mongo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

// import co.com.softlond.mongo.Estudiante.ReactiveEstudianteMongoRepository;
// import co.com.softlond.mongo.Plantilla.ReactivePlantillaMongoRepository;

@Configuration
@EnableReactiveMongoRepositories(basePackages = {"co.com.softlond"})
public class ReactiveMongoConfig {
}

package co.com.softlond.mongo.Estudiante;

import org.springframework.stereotype.Repository;

import co.com.softlond.model.EstudianteModel;
import co.com.softlond.model.gateways.EstudianteGateways;
import reactor.core.publisher.Mono;

@Repository
public class EstudianteGatewayImpl implements EstudianteGateways{

    private ReactiveEstudianteMongoRepository estudianteMongoRepository;

    public EstudianteGatewayImpl(ReactiveEstudianteMongoRepository estudianteMongoRepository) {
        this.estudianteMongoRepository = estudianteMongoRepository;
    }

    @Override
    public Mono<EstudianteModel> saveEstudiante(EstudianteModel estudiante) {
        return estudianteMongoRepository.save(EstudianteMapper.toCollections(estudiante))
                .map( estudianteEntity -> EstudianteMapper.toModel(estudianteEntity) );
    }
    
}

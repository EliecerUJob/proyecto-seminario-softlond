package co.com.softlond.mongo.Historial;

import org.springframework.stereotype.Repository;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.model.PlantillaModel;
import co.com.softlond.model.gateways.HistorialGateways;
import reactor.core.publisher.Mono;

@Repository
public class HistorialGatewaysImpl implements HistorialGateways{

    private ReactiveHistorialMongoRepository historialMongoRepository;

    public HistorialGatewaysImpl(ReactiveHistorialMongoRepository historialMongoRepository) {
        this.historialMongoRepository = historialMongoRepository;
    }

    @Override
    public Mono<HistorialModel> saveHistorial(HistorialModel model) {
        System.out.println(model.getLastDescription()+ "Entre save");
        return historialMongoRepository.save(HistorialMapper.toCollection(model))
                .map( historialEntity -> HistorialMapper.toModel(historialEntity) );
    }

    @Override
    public Mono<HistorialModel> updateHistorial(HistorialModel model, PlantillaModel plantilla) {
        HistorialModel updateHistorialModel = model;
        updateHistorialModel.setContador( model.getContador() + 1 );
        updateHistorialModel.setLastDescription(plantilla.getDescripcion());
        System.out.println(plantilla.getDescripcion() + " descripcion update");
        System.out.println("entre update");
        return historialMongoRepository.save(HistorialMapper.toCollection(updateHistorialModel))
                .map( historialEntity -> HistorialMapper.toModel(historialEntity) );
        
    }

    @Override
    public Mono<HistorialModel> get() {
        System.out.println("Entre get historial");
        return historialMongoRepository.findAll()
                .next()
                .map( historialEntity -> HistorialMapper.toModel(historialEntity) );
    }
    
}

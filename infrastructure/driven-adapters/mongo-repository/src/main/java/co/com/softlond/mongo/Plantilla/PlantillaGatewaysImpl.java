package co.com.softlond.mongo.Plantilla;

import org.springframework.stereotype.Repository;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.model.PlantillaModel;
import co.com.softlond.model.gateways.PlantillaGateways;
import co.com.softlond.mongo.Historial.HistorialGatewaysImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PlantillaGatewaysImpl implements PlantillaGateways{    

    private ReactivePlantillaMongoRepository reactivePlantillaMongoRepository;
    private HistorialGatewaysImpl historialGatewaysImpl;

    public PlantillaGatewaysImpl(ReactivePlantillaMongoRepository reactivePlantillaMongoRepository,
            HistorialGatewaysImpl historialGatewaysImpl) {
        this.reactivePlantillaMongoRepository = reactivePlantillaMongoRepository;
        this.historialGatewaysImpl = historialGatewaysImpl;
    }

    @Override
    public Mono<PlantillaModel> savePlantilla(PlantillaModel plantilla) {

        reactivePlantillaMongoRepository.findAll().count().subscribe( lenght -> {
            if (lenght <= 0) {
                HistorialModel historialModel = new HistorialModel();
                historialModel.setContador(1);
                historialModel.setLastDescription(plantilla.getDescripcion());
                historialGatewaysImpl.saveHistorial(historialModel).subscribe();
            }else{
                historialGatewaysImpl.updateHistorial(historialGatewaysImpl.get().block(), plantilla).subscribe();
            }
        } );

        return reactivePlantillaMongoRepository.save(PlantillaMapper.toCollection(plantilla))
                .map(plantillaEntity -> PlantillaMapper.toModel(plantillaEntity));
    }

    @Override
    public Flux<PlantillaModel> getAll() {
        return reactivePlantillaMongoRepository.findAll()
                .map( plantillasEntity -> PlantillaMapper.toModel(plantillasEntity) );
    }
    
}

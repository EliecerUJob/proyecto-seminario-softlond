package co.com.softlond.model.gateways;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.model.PlantillaModel;
import reactor.core.publisher.Mono;

public interface HistorialGateways {
    
    Mono<HistorialModel> saveHistorial(HistorialModel model);
    Mono<HistorialModel> updateHistorial(HistorialModel model, PlantillaModel plantillaModel);
    Mono<HistorialModel> get();

}

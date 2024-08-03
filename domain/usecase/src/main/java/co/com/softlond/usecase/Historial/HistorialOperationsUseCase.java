package co.com.softlond.usecase.Historial;

import org.springframework.stereotype.Service;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.model.PlantillaModel;
import co.com.softlond.model.gateways.HistorialGateways;
import reactor.core.publisher.Mono;

@Service
public class HistorialOperationsUseCase {
    
    private final HistorialGateways historialGateways;

    public HistorialOperationsUseCase(HistorialGateways historialGateways) {
        this.historialGateways = historialGateways;
    }

    public Mono<HistorialModel> saveHistorial(HistorialModel historialModel){
        return historialGateways.saveHistorial(historialModel);
    }

    public Mono<HistorialModel> updateHistorial(HistorialModel historialModel, PlantillaModel plantillaModel){
        return historialGateways.updateHistorial(historialModel, plantillaModel);
    }

    public Mono<HistorialModel> get(){
        return historialGateways.get();
    }

}

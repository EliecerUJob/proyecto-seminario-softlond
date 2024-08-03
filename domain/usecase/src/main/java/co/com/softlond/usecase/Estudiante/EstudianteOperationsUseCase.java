package co.com.softlond.usecase.Estudiante;

import org.springframework.stereotype.Service;

import co.com.softlond.model.EstudianteModel;
import co.com.softlond.model.gateways.EstudianteGateways;
import reactor.core.publisher.Mono;

@Service
public class EstudianteOperationsUseCase {
    
    private EstudianteGateways estudianteGateways;

    public EstudianteOperationsUseCase(EstudianteGateways estudianteGateways) {
        this.estudianteGateways = estudianteGateways;
    }

    public Mono<EstudianteModel> saveEstudiante(EstudianteModel estudiante){
        if (estudiante.getGradoEscolaridad() > 0 && estudiante.getGradoEscolaridad() < 5) {
            estudiante.setNivelEscolaridad("Primaria");
        }
        return estudianteGateways.saveEstudiante(estudiante);
    }

}

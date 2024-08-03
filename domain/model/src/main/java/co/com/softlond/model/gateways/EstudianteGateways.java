package co.com.softlond.model.gateways;

import co.com.softlond.model.EstudianteModel;
import reactor.core.publisher.Mono;

public interface EstudianteGateways {
    Mono<EstudianteModel> saveEstudiante(EstudianteModel estudiante);
}

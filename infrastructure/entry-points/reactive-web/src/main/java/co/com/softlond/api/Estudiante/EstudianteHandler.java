package co.com.softlond.api.Estudiante;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.softlond.model.EstudianteModel;
import co.com.softlond.usecase.Estudiante.EstudianteOperationsUseCase;
import reactor.core.publisher.Mono;

@Service
public class EstudianteHandler {
    
    private final EstudianteOperationsUseCase estudianteOperationsUseCase;

    public EstudianteHandler(EstudianteOperationsUseCase estudianteOperationsUseCase) {
        this.estudianteOperationsUseCase = estudianteOperationsUseCase;
    }

    public Mono<ServerResponse> saveEstudiante(ServerRequest request){
        return request.bodyToMono(EstudianteModel.class)
                .flatMap(estudianteOperationsUseCase::saveEstudiante)
                .flatMap( estudiante -> ServerResponse.ok().bodyValue(estudiante) )
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume( error -> ServerResponse.badRequest().bodyValue(error.getMessage()) );
    }

}

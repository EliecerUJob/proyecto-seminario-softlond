package co.com.softlond.api.Historial;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.softlond.usecase.Historial.HistorialOperationsUseCase;
import reactor.core.publisher.Mono;

@Service
public class HistorialHandler {
    
    private final HistorialOperationsUseCase operationsUseCase;

    public HistorialHandler(HistorialOperationsUseCase operationsUseCase) {
        this.operationsUseCase = operationsUseCase;
    }

    public Mono<ServerResponse> get(ServerRequest request){
        return operationsUseCase.get()
                .flatMap( historial -> ServerResponse.ok().bodyValue(historial) )
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }

}

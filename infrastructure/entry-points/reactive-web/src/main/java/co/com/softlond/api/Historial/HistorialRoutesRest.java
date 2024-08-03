package co.com.softlond.api.Historial;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class HistorialRoutesRest {
    
    @Bean
    public RouterFunction<ServerResponse> historialRoutes(HistorialHandler historialHandler){
        return RouterFunctions.route(GET("/api/historial"), historialHandler::get);
    }

}

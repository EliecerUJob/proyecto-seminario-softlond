package co.com.softlond.api.Estudiante;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class EstudianteRoutesRest {
    
    @Bean
    public RouterFunction<ServerResponse> estudianteRoutes(EstudianteHandler handler){
        return route(POST("/api/estudiante/save"), handler::saveEstudiante);
    }

}

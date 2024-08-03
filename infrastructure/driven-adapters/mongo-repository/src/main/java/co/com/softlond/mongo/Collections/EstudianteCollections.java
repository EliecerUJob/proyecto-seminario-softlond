package co.com.softlond.mongo.Collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "estudiante")
public class EstudianteCollections {
    
    @Id
    private String id;
    private String nombres;
    private String apellidos;
    private String codigoEstudiantil;
    private long identificacion;
    private int gradoEscolaridad;
    private long numeroTelefonico;
    private String direccion;
    private String nivelEscolaridad;
    
}

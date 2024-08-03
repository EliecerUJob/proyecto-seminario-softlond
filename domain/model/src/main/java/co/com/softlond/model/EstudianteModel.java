package co.com.softlond.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EstudianteModel {
    
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

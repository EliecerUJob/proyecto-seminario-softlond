package co.com.softlond.mongo.Estudiante;

import co.com.softlond.model.EstudianteModel;
import co.com.softlond.mongo.Collections.EstudianteCollections;

public class EstudianteMapper {
    
    public static EstudianteModel toModel(EstudianteCollections collections){
        
        return EstudianteModel.builder()
                .id(collections.getId())
                .nombres(collections.getNombres())
                .apellidos(collections.getApellidos())
                .codigoEstudiantil(collections.getCodigoEstudiantil())
                .direccion(collections.getDireccion())
                .gradoEscolaridad(collections.getGradoEscolaridad())
                .identificacion(collections.getIdentificacion())
                .numeroTelefonico(collections.getNumeroTelefonico())
                .build();

    }

    public static EstudianteCollections toCollections(EstudianteModel model){

        EstudianteCollections collections = new EstudianteCollections();
        collections.setId(model.getId());
        collections.setNombres(model.getNombres());
        collections.setApellidos(model.getApellidos());
        collections.setCodigoEstudiantil(model.getCodigoEstudiantil());
        collections.setIdentificacion(model.getIdentificacion());
        collections.setGradoEscolaridad(model.getGradoEscolaridad());
        collections.setNumeroTelefonico(model.getNumeroTelefonico());
        collections.setDireccion(model.getDireccion());

        return collections;

    }

}

package co.com.softlond.mongo.Historial;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.mongo.Collections.HistorialCollection;

public class HistorialMapper {
    
    public static HistorialModel toModel(HistorialCollection collection){
        return HistorialModel.builder()
            .id(collection.getId())
            .contador(collection.getContador())
            .lastDescription(collection.getLastDescription())
            .build();
    }

    public static HistorialCollection toCollection(HistorialModel model){
        HistorialCollection collection = new HistorialCollection();
        collection.setId(model.getId());
        collection.setContador(model.getContador());
        collection.setLastDescription(model.getLastDescription());
        return collection;
    }

}

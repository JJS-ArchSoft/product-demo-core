package com.jjsarchsoft.demo.services.interfaces;

import com.jjsarchsoft.demo.models.ModelObject1;
import java.util.Collection;

public interface ModelObject1Service {

    ModelObject1 getOne(long id);
    Collection<ModelObject1> getAll();
    ModelObject1 update(ModelObject1 object);
    boolean delete(long id);

}

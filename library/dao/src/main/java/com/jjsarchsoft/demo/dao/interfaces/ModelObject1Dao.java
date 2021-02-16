package com.jjsarchsoft.demo.dao.interfaces;

import com.jjsarchsoft.demo.models.ModelObject1;
import java.util.Collection;

public interface ModelObject1Dao {

    ModelObject1 get(long id);
    Collection<ModelObject1> getAll();
    ModelObject1 update(ModelObject1 object);
    boolean delete(long id);

}

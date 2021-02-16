package com.jjsarchsoft.demo.dao.implementations;

import com.jjsarchsoft.demo.dao.interfaces.ModelObject1Dao;
import com.jjsarchsoft.demo.models.ModelObject1;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

// Just as a sample to retrieve an object from the database
@Log4j2
@Component
public class ModelObject1DaoImpl implements ModelObject1Dao {

    private final Collection<ModelObject1> modelObject1Table;

    public ModelObject1DaoImpl() {
        log.info("initializing database table ModelObject1");
        modelObject1Table = new ArrayList<>();
        modelObject1Table.add(ModelObject1.builder().id(1L).property1("value1-1").property2("value1-2").build());
        modelObject1Table.add(ModelObject1.builder().id(2L).property1("value2-1").property2("value2-2").build());
        modelObject1Table.add(ModelObject1.builder().id(3L).property1("value3-1").property2("value3-2").build());
    }

    @Override
    public ModelObject1 get(long id) {
        log.info("Retrieving ModelObject1 with id {}", id);
        return modelObject1Table.stream().filter(mo1t -> id == mo1t.getId()).findFirst().orElse(null);
    }

    @Override
    public Collection<ModelObject1> getAll() {
        log.info("Retrieving all ModelObject1");
        return modelObject1Table;
    }

    @Override
    public ModelObject1 update(ModelObject1 object) {
        if(object.getId() == null) {
            object.setId(modelObject1Table.stream().max(Comparator.comparing(ModelObject1::getId)).orElse(ModelObject1.builder().id(0L).build()).getId() +1);
            log.info("Saving new ModelObject1: {}", ReflectionToStringBuilder.toString(object, ToStringStyle.JSON_STYLE));
            modelObject1Table.add(object);
            return object;
        } else {
            log.info("Updating ModelObject1 with id: {} - {}", object.getId(), ReflectionToStringBuilder.toString(object, ToStringStyle.JSON_STYLE));
            ModelObject1 row = get(object.getId());
            if(row != null) {
                row.setProperty1(object.getProperty1());
                row.setProperty2(object.getProperty2());
            }
            return row;
        }
    }

    @Override
    public boolean delete(long id) {
        log.info("Deleting ModelObject1 with id: {}", id);
        ModelObject1 row = get(id);
        if(row != null) {
            modelObject1Table.removeIf(mo1t -> mo1t.getId().equals(id));
            return true;
        }
        return false;
    }

}

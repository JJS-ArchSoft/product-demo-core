package com.jjsarchsoft.demo.services.implementations;

import com.jjsarchsoft.demo.dao.interfaces.ModelObject1Dao;
import com.jjsarchsoft.demo.models.ModelObject1;
import com.jjsarchsoft.demo.services.interfaces.ModelObject1Service;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Log4j2
@Service
public class ModelObject1ServiceImpl implements ModelObject1Service {

    private final ModelObject1Dao dao;

    public ModelObject1ServiceImpl(ModelObject1Dao dao) {
        this.dao = dao;
    }

    @Override
    public ModelObject1 getOne(long id) {
        log.info("Executing getOne business method");
        ModelObject1 result = dao.get(id);
        if(result == null)
            throw new NoSuchElementException("Row with id " + id + " not found");
        return result;
    }

    @Override
    public Collection<ModelObject1> getAll() {
        log.info("Executing getAll business method");
        return dao.getAll();
    }

    @Override
    public ModelObject1 update(ModelObject1 object) {
        log.info("Executing update business method");
        ModelObject1 result = dao.update(object);
        if(result == null)
            throw new NoSuchElementException("Row with id " + object.getId() + " not found");
        return result;
    }

    @Override
    public boolean delete(long id) {
        log.info("Executing delete business method");
        return dao.delete(id);
    }

}

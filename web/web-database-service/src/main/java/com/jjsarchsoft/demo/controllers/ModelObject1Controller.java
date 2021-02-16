package com.jjsarchsoft.demo.controllers;

import com.jjsarchsoft.demo.models.ModelObject1;
import com.jjsarchsoft.demo.services.interfaces.ModelObject1Service;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Log4j2
@RestController
@RequestMapping("/model")
@Validated
public class ModelObject1Controller {

    private final ModelObject1Service service;

    public ModelObject1Controller(ModelObject1Service service) {
        log.info("Instantiating model controller");
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelObject1> get(@PathVariable @NotNull Long id) {
        log.info("Executing controller method get");
        return ResponseEntity.ok(service.getOne(id));
    }

    @GetMapping
    public ResponseEntity<Collection<ModelObject1>> getAll() {
        log.info("Executing controller method getAll");
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<ModelObject1> save(@RequestBody @Valid ModelObject1 model) {
        log.info("Executing controller method save");
        return ResponseEntity.ok(service.update(model));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @NotNull Long id) {
        log.info("Executing controller method delete");
        service.delete(id);
        return null;
    }

}

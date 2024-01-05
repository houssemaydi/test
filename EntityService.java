
package com.example.demo.service;

import com.example.demo.model.Entity;
import com.example.demo.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntityService {

    @Autowired
    private EntityRepository entityRepository;

    public List<Entity> getAllEntities() {
        return entityRepository.findAll();
    }

    public Optional<Entity> getEntityById(Long id) {
        return entityRepository.findById(id);
    }

    public Entity createEntity(String name) {
        Entity newEntity = new Entity();
        newEntity.setName(name);
        return entityRepository.save(newEntity);
    }

    // Other CRUD methods
}

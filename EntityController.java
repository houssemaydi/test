
package com.example.demo.controller;

import com.example.demo.model.Entity;
import com.example.demo.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entities")
public class EntityController {

    @Autowired
    private EntityService entityService;

    @GetMapping
    public ResponseEntity<List<Entity>> getAllEntities() {
        return ResponseEntity.ok(entityService.getAllEntities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entity> getEntityById(@PathVariable Long id) {
        return entityService.getEntityById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Entity> createEntity(@RequestParam String name) {
        return ResponseEntity.ok(entityService.createEntity(name));
    }
}

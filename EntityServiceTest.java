
package com.example.demo.service;

import com.example.demo.model.Entity;
import com.example.demo.repository.EntityRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EntityServiceTest {

    @Mock
    private EntityRepository entityRepository;

    @InjectMocks
    private EntityService entityService;

    @Test
    public void testCreateEntity() {
        String name = "Test Name";
        Entity entity = new Entity();
        entity.setName(name);

        when(entityRepository.save(any(Entity.class))).thenReturn(entity);

        Entity created = entityService.createEntity(name);

        assertEquals(name, created.getName());
        verify(entityRepository, times(1)).save(any(Entity.class));
    }

    // Other test methods
}

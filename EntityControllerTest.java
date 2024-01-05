
package com.example.demo.controller;

import com.example.demo.model.Entity;
import com.example.demo.service.EntityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class EntityControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EntityService entityService;

    @InjectMocks
    private EntityController entityController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(entityController).build();
    }

    @Test
    public void testCreateEntity() throws Exception {
        String name = "Test Entity";
        Entity entity = new Entity();
        entity.setName(name);

        when(entityService.createEntity(name)).thenReturn(entity);

        mockMvc.perform(post("/entities")
                .param("name", name))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(name));

        verify(entityService, times(1)).createEntity(name);
    }

    // Other test methods
}

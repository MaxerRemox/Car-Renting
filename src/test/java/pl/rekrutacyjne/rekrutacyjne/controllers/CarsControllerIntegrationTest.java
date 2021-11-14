package pl.rekrutacyjne.rekrutacyjne.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CarsControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void shouldReturnAllElements() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cars/list"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection()).andReturn();
    }

    @Test
    public void shouldSaveEditedCar() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/cars/editsave"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection()).andReturn();
    }

}
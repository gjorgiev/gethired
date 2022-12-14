package com.gjorgiev.gethired.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gjorgiev.gethired.models.Location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static com.gjorgiev.gethired.utils.TestConstants.URL_LOCATIONS_BASE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/sql/populate-table-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/sql/populate-table-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class LocationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    @DisplayName("[200] GET /api/v1/locations - Get locations")
    public void getLocations() throws Exception{
        mockMvc.perform(get(URL_LOCATIONS_BASE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].id").value(11))
                .andExpect(jsonPath("content[0].city").value("Los Angeles"))
                .andExpect(jsonPath("content[0].country").value("USA"))
                .andExpect(jsonPath("content[1].id").value(12))
                .andExpect(jsonPath("content[1].city").value("Berlin"))
                .andExpect(jsonPath("content[1].country").value("Germany"))
                .andExpect(jsonPath("content[2].id").value(13))
                .andExpect(jsonPath("content[2].city").value("London"))
                .andExpect(jsonPath("content[2].country").value("United Kingdom"));
    }

    @Test
    @DisplayName("[200] GET /api/v1/locations/11 - Get location by id")
    public void getLocationById() throws Exception{
        mockMvc.perform(get(URL_LOCATIONS_BASE + "/11"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(11))
                .andExpect(jsonPath("city").value("Los Angeles"))
                .andExpect(jsonPath("country").value("USA"));
    }

    @Test
    @DisplayName("[200] POST /api/v1/locations - Crate new location")
    public void createLocation() throws Exception{
        Location location = new Location();
        location.setCity("Sao Paolo");
        location.setCountry("Brazil");

        mockMvc.perform(post(URL_LOCATIONS_BASE)
                .content(mapper.writeValueAsString(location))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("city").value("Sao Paolo"))
                .andExpect(jsonPath("country").value("Brazil"));
    }
}

package com.gjorgiev.gethired.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static com.gjorgiev.gethired.utils.TestConstants.URL_COMPANIES_BASE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/sql/populate-table-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/sql/populate-table-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class CompanyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("[200] GET /api/v1/companies - Get companies")
    public void getCompanies() throws Exception{
        mockMvc.perform(get(URL_COMPANIES_BASE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].name").value("Microsoft"))
                .andExpect(jsonPath("content[1].id").value(2))
                .andExpect(jsonPath("content[1].name").value("Apple"))
                .andExpect(jsonPath("content[2].id").value(3))
                .andExpect(jsonPath("content[2].name").value("Google"));
    }

    @Test
    @DisplayName("[200] GET /api/v1/companies/1 - Get company by id")
    public void getCompanyById() throws Exception{
        mockMvc.perform(get(URL_COMPANIES_BASE + "/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("name").value("Microsoft"));
    }
}

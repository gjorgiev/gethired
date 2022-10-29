package com.gjorgiev.gethired.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gjorgiev.gethired.dto.request.JobRequest;
import com.gjorgiev.gethired.models.Company;
import com.gjorgiev.gethired.models.Job;
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


import static com.gjorgiev.gethired.utils.TestConstants.URL_JOBS_BASE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/sql/populate-table-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/sql/populate-table-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class JobControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    @DisplayName("[200] GET /api/v1/jobs - Get jobs")
    public void getJobs() throws Exception{
        mockMvc.perform(get(URL_JOBS_BASE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].id").value(11))
                .andExpect(jsonPath("content[0].title").value("Java Developer"))
                .andExpect(jsonPath("content[0].company.id").value(11))
                .andExpect(jsonPath("content[1].id").value(12))
                .andExpect(jsonPath("content[1].title").value("Python Developer"))
                .andExpect(jsonPath("content[1].company.id").value(12))
                .andExpect(jsonPath("content[2].id").value(13))
                .andExpect(jsonPath("content[2].title").value("Scala Developer"))
                .andExpect(jsonPath("content[2].company.id").value(13));
    }

    @Test
    @DisplayName("[200] GET /api/v1/jobs/11 - Get Job by id")
    public void getJobById() throws Exception{
        mockMvc.perform(get(URL_JOBS_BASE + "/11"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(11))
                .andExpect(jsonPath("title").value("Java Developer"))
                .andExpect(jsonPath("company.id").value(11));
    }

    @Test
    @DisplayName("[200] POST /api/v1/jobs - Create new job")
    public void createJob() throws Exception {
        Company company = new Company();
        company.setId(11L);

        Job job = new Job();
        job.setTitle("C/C++ Developer");
        job.setDescription("Embedded systems developer");
        job.setCompany(company);
        job.setRemote(true);

        mockMvc.perform(post(URL_JOBS_BASE)
                        .content(mapper.writeValueAsString(job))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("title").value("C/C++ Developer"))
                .andExpect(jsonPath("description").value("Embedded systems developer"))
                .andExpect(jsonPath("company.id").value(11))
                .andExpect(jsonPath("remote").value(true));
    }
}

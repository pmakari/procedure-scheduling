package com.caresyntax.scheduling.controller;

import com.caresyntax.scheduling.BaseTest;
import com.caresyntax.scheduling.config.JacksonMapperConfig;
import com.caresyntax.scheduling.domain.dto.request.PageRequestDTO;
import com.caresyntax.scheduling.domain.dto.request.PatientRequestDTO;
import com.caresyntax.scheduling.domain.enums.Sex;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Parviz on 10.05.2018.
 */
public class PatientControllerTest extends BaseTest {

    @Before
    public void init() {
        jdbcTemplate.update("insert into patients(id, name, birth_date,created_at) values(?, ?, ?,?)",
                10, "Parviz",new Date(),new Date());
        jdbcTemplate.update("insert into patients(id, name, birth_date,created_at) values(?, ?, ?,?)",
                11, "David",new Date(),new Date());

        jdbcTemplate.update("insert into patients(id, name, birth_date,created_at) values(?, ?, ?,?)",
                12, "John",new Date(),new Date());

    }

//mockmvc tests To Do
}

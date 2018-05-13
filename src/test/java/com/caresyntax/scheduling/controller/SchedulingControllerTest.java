package com.caresyntax.scheduling.controller;

import com.caresyntax.scheduling.BaseTest;
import com.caresyntax.scheduling.config.JacksonMapperConfig;
import com.caresyntax.scheduling.domain.dto.request.PageRequestDTO;
import com.caresyntax.scheduling.domain.dto.request.PatientRequestDTO;
import com.caresyntax.scheduling.domain.enums.Sex;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by Parviz on 10.05.2018.
 */
public class SchedulingControllerTest extends BaseTest{

    @Test
    public void post_changeStatus_ok() throws Exception {
        //arrange
    }


}

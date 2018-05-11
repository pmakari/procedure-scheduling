package com.caresyntax.scheduling.controller;

import com.caresyntax.scheduling.BaseTest;
import com.caresyntax.scheduling.domain.dto.request.PageRequestDTO;
import org.junit.Test;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Parviz on 10.05.2018.
 */
public class PatientControllerTest extends BaseTest {

    @Test
    public void showPatients_simplePageRequest_succeed() throws Exception {
        //arrange
        PageRequestDTO requestDTO = new PageRequestDTO(0, 10);

        //act and asserts
        mvc.perform(get("/patient/show")
                .contentType(MediaType.TEXT_PLAIN)
                .accept(MediaType.TEXT_HTML)
                .param("page", requestDTO.getPage().toString())
                .param("size", requestDTO.getSize().toString()))
                .andExpect(status().isOk()).andExpect(view().name("patient/show")).andExpect(model().size(3))
                .andReturn();
    }
}

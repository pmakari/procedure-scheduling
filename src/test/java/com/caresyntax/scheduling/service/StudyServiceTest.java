package com.caresyntax.scheduling.service;

import com.caresyntax.scheduling.BaseTest;
import com.caresyntax.scheduling.domain.dto.request.ChangeStatusDTO;
import com.caresyntax.scheduling.domain.dto.request.PatientRequestDTO;
import com.caresyntax.scheduling.domain.dto.request.StudyRequestDTO;
import com.caresyntax.scheduling.domain.dto.response.PatientResponseDTO;
import com.caresyntax.scheduling.domain.dto.response.StudyResponseDTO;
import com.caresyntax.scheduling.domain.enums.Sex;
import com.caresyntax.scheduling.domain.enums.Status;
import com.caresyntax.scheduling.exception.specific.NoSuchStudyException;
import com.caresyntax.scheduling.service.api.StudyService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by Parviz on 10.05.2018.
 */
public class StudyServiceTest extends BaseTest {



    @Autowired
    StudyService studyService;

    @Before
    public void init() {
        jdbcTemplate.update("insert into patients(id, name, birth_date,created_at) values(?, ?, ?,?)",
                1, "Parviz",new Date(),new Date());
    }

    @Test(expected = NoSuchStudyException.class)
    public void findById_nonExistingSection_succeed() {
        //arrange
        Long id = Long.MAX_VALUE;
        //to do : insert fake records
        //act
        studyService.findById(id);
    }

    @Test
    public void save_study_succeed(){
        StudyRequestDTO requestDTO=StudyRequestDTO.builder().description("description").endTime(new Date()).startTime(new Date())
                .status(Status.PLANNED).patientId(1l).doctors(1l).rooms(1l).id(1l).build();
        studyService.save(requestDTO);
       StudyResponseDTO expected= studyService.findById(1l);
        Assert.assertEquals(expected.getId(), requestDTO.getId());
        Assert.assertNotNull(expected.getId());
    }

    @Test
    public void change_studyStatus_succeed(){
//        StudyRequestDTO requestDTO=StudyRequestDTO.builder().description("description").endTime(new Date()).startTime(new Date())
//                .status(Status.PLANNED).patientId(1l).doctors(1l).rooms(1l).id(2l).build();
//        studyService.save(requestDTO);
//        ChangeStatusDTO changeStatusDTO=ChangeStatusDTO.builder().id(2l).status(Status.FINISHED).build();
//        studyService.changeStatus(changeStatusDTO);
//        StudyResponseDTO expected= studyService.findById(2l);
//        Assert.assertEquals(expected.getStatus(), Status.FINISHED);
//        Assert.assertNotEquals(expected.getStatus(),requestDTO.getStatus());
    }

}


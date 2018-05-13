package com.caresyntax.scheduling.service;

import com.caresyntax.scheduling.BaseTest;
import com.caresyntax.scheduling.domain.dto.request.PatientRequestDTO;
import com.caresyntax.scheduling.domain.dto.response.PatientResponseDTO;
import com.caresyntax.scheduling.domain.enums.Sex;
import com.caresyntax.scheduling.service.api.PatientService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by Parviz on 10.05.2018.
 */
public class PatientServiceTest extends BaseTest {
    @Autowired
    PatientService patientService;

    @Test
    public void save_patient_succeed(){
        PatientRequestDTO patientRequestDTO=PatientRequestDTO.builder().name("Parviz").sex(Sex.MALE).birthDate(new Date()).build();
        patientService.save(patientRequestDTO);
        PatientResponseDTO expectedResponse=patientService.findByName("Parviz");
        Assert.assertNotEquals(expectedResponse.getName(), "wrongname");
        Assert.assertEquals(expectedResponse.getName(), patientRequestDTO.getName());
        Assert.assertNotNull(expectedResponse.getName());
    }


}

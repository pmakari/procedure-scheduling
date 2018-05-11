package com.caresyntax.scheduling.service.api;

import com.caresyntax.scheduling.domain.dto.request.PageRequestDTO;
import com.caresyntax.scheduling.domain.dto.request.PatientRequestDTO;
import com.caresyntax.scheduling.domain.dto.response.PatientResponseDTO;
import com.caresyntax.scheduling.domain.entity.PatientEntity;
import org.springframework.data.domain.Page;

/**
 * Created by Parviz on 10.05.2018.
 */
public interface PatientService {

    public void save(PatientRequestDTO requestDTO);

    public PatientResponseDTO findByName(String name);

    Page<PatientEntity> findAll(PageRequestDTO pageRequest);
    public PatientResponseDTO findById(Long id);
}

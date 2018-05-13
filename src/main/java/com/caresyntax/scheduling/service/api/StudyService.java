package com.caresyntax.scheduling.service.api;

import com.caresyntax.scheduling.domain.dto.request.ChangeStatusDTO;
import com.caresyntax.scheduling.domain.dto.request.PageRequestDTO;
import com.caresyntax.scheduling.domain.dto.request.StudyRequestDTO;
import com.caresyntax.scheduling.domain.dto.response.StudyResponseDTO;
import com.caresyntax.scheduling.domain.entity.StudyEntity;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Parviz on 10.05.2018.
 */
public interface StudyService {
    public void save(StudyRequestDTO requestDTO);
    public StudyResponseDTO findById(Long id);
    public void changeStatus(ChangeStatusDTO changeStatusDTO);
    public Page<StudyEntity> findAll(PageRequestDTO requestDTO);



}

package com.caresyntax.scheduling.service.api;

import com.caresyntax.scheduling.domain.dto.request.StudyRequestDTO;
import com.caresyntax.scheduling.domain.dto.response.StudyResponseDTO;

/**
 * Created by Parviz on 10.05.2018.
 */
public interface StudyService {
    public void save(StudyRequestDTO requestDTO);
    public StudyResponseDTO findById(Long id);


}

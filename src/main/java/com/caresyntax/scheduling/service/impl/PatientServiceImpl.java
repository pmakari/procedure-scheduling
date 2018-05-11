package com.caresyntax.scheduling.service.impl;

import com.caresyntax.scheduling.domain.dto.request.PageRequestDTO;
import com.caresyntax.scheduling.domain.dto.request.PatientRequestDTO;
import com.caresyntax.scheduling.domain.dto.response.PatientResponseDTO;
import com.caresyntax.scheduling.domain.entity.PatientEntity;
import com.caresyntax.scheduling.exception.BusinessException;
import com.caresyntax.scheduling.repository.PatientRepository;
import com.caresyntax.scheduling.service.api.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Parviz on 10.05.2018.
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    @Transactional
    public void save(PatientRequestDTO requestDTO) {
        PatientEntity patientEntity = PatientEntity.builder().name(requestDTO.getName()).sex(requestDTO.getSex()).birthDate(requestDTO.getBirthDate()).build();
        if (requestDTO.getId()!=null && requestDTO.getId()!=0){
            patientEntity.setId(requestDTO.getId());
        }
        try {
            patientRepository.save(patientEntity);
        } catch (DataAccessException ex) {
            throw new BusinessException(ex.getMessage(), ex);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public PatientResponseDTO findByName(String name) {
        try {
            PatientEntity patientEntity = patientRepository.findByName(name);
            PatientResponseDTO patientDTO = PatientResponseDTO.builder().name(patientEntity.getName()).sex(patientEntity.getSex()).birthDate(patientEntity.getBirthDate()).build();
            return patientDTO;
        } catch (DataAccessException ex) {
            throw new BusinessException(ex.getMessage(), ex);
        }

    }

    @Transactional(readOnly = true)
    @Override
    public Page<PatientEntity> findAll(PageRequestDTO requestDTO) {
        try {
            Page<PatientEntity> page = patientRepository.findAll(new PageRequest(requestDTO.getPage(), requestDTO.getSize()));
            return page;
        } catch (DataIntegrityViolationException ex) {
            throw new BusinessException(ex.getMessage(), ex.getCause());
        }

    }
    @Transactional
    @Override
    public PatientResponseDTO findById(Long id) {
        PatientEntity entity=patientRepository.findOne(id);
        PatientResponseDTO responseDTO=PatientResponseDTO.builder().id(entity.getId()).name(entity.getName()).sex(entity.getSex()).birthDate(entity.getBirthDate()).build();
        return responseDTO;
    }
}
